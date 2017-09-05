package com.test.springboot.config.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/** 
 * @Description 自定义的Serlvlet过滤器 

 */
@WebFilter(urlPatterns = "/*")
public class JackFilter  implements Filter {
    
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        System.out.println(req.getRequestURL() + "------>doFilter");
        chain.doFilter(request, response);
    }
    
    public void destroy() {
    }
    
}
