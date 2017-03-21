package com.blog.web.filter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSONObject;
import com.blog.web.util.CommonTools;
import com.blog.web.util.SqlParameterFilter;
import com.blog.web.util.URLBean;

public class UserSessionFilter implements Filter{
	private static int VisitLimit;	//每分钟访问次数上限
	private static final int MaxStackSize = 60;
	private static Map<String, Queue<Long>> VisitIpInfo = new HashMap<String, Queue<Long>>();

	private static ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:bean.xml");
	private URLBean urlBean=(URLBean)ac.getBean("urlBean");

	private Log logger = LogFactory.getLog(this.getClass());

	public void destroy() {
		
	}

	/**
	 * 验证来源ip的请求计数是否超上限
	 * 
	 * @param srcIp
	 * @return
	 */
	private boolean validateSrcIp(HttpServletRequest request) {
		String srcIp = CommonTools.getRequestSrcIp(request);
		if (srcIp == null || (!urlBean.getUnRestrictIp().isEmpty() && srcIp.startsWith(urlBean.getUnRestrictIp()) ) ) {//|| srcIp.startsWith("10.110")
			logger.info("--srcIp--req--- " 
					+ srcIp + " -- " + request.getServletPath());
			return true;
		}
		if (VisitIpInfo.containsKey(srcIp)) {
			Queue<Long> visitQueue = VisitIpInfo.get(srcIp);
			while (visitQueue.size() > 0) {
				long visitDuration = System.currentTimeMillis() - visitQueue.peek() ;
				//判断访问时间是否超过了3分钟的记录，超过了就移除
				if (visitDuration > 60*1000)  {
					visitQueue.poll();
					continue;
				}
				//判断集合的数量是否超过了30个，超过了就移除最早的记录
				if (visitQueue.size() > MaxStackSize) {
					visitQueue.poll();
					continue;
				}
				break;
			}
			//把最新一次的请求时间加入集合
			visitQueue.offer(System.currentTimeMillis());
			if (visitQueue.size() > VisitLimit) {
				logger.info("--srcIp--accessCnt--req--- " 
						+ srcIp + " -- " + visitQueue.size() + " -- " + request.getServletPath());
				return false;
			} else {
				return true;
			}
		} else {
			Queue<Long> visitQueue = new LinkedList<Long>();
			visitQueue.offer(System.currentTimeMillis());
			VisitIpInfo.put(srcIp, visitQueue);
			return true;
		}
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		VisitLimit = urlBean.getVisitLimit();
		//如果每分钟请求次数 大于 集合存储请求记录的数量，则不限制请求次数
		if(VisitLimit > MaxStackSize){
			chain.doFilter(req, resp);
			return;
		}
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		JSONObject jsonObject = new JSONObject();
		String path = request.getServletPath();
		
		for (String url : urlBean.getCountFilterURL()) {
			if (url.equalsIgnoreCase(path) || path.startsWith(url)) {
				if (!validateSrcIp(request)) {
					response.setContentType("application/json");
					response.setCharacterEncoding("utf-8");
					PrintWriter pw = response.getWriter();
					jsonObject.put("status","fail");
					jsonObject.put("info","请求太频繁，请稍后重试");
					pw.print(jsonObject);
					pw.flush();
					pw.close();
					return;
				}
			}
		}
		// 对Request里的传值参数进行安全过滤
		HttpServletRequest xssRequest = new SqlParameterFilter(request);
		chain.doFilter(xssRequest, resp);
		return;
	}
	public void init(FilterConfig arg0) throws ServletException {
	}
}
