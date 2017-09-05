<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel='stylesheet' type='text/css' href='./css/pub_footer.css' />
 <script type="text/javascript">
            requirejs(["jquery","publib_footer"], function(jquery,publib_footer) {
               publib_footer.init();
            });
        </script>
</div> <!-- END #content -->

<footer>
    <div class='pub_fo'>
    	<div id='pub_footerall' class='pub_footer_new'>
    		<dl>
    		<dt></dt>
    			<dd class='foot_sub_menu'>
    				<div class="juzhong">
    				<a href='http://www.csdn.net/company/about.html' target='_blank'>公司简介</a>
    					<span>|</span>
    				<a href='#' target='_blank'>广告服务</a>
    					<span>|</span>
    				<a href='/company/contact.html' target='_blank'>联系方式</a>
    					<span>|</span>
    				<a href='/company/statement.html' target='_blank'>版权声明</a>
    					<span>|</span>
    				<a href='mailto:fashionbrot@163.com'>问题报告</a>
    					<span>|</span>
    				<a target='_blank' href='/friendlink.html'>合作伙伴</a>
    				</div>
    			</dd>
    			<dd class='foot_contact'>
    				<div class="juzhong" >
		   				 <a href='#' target='_blank' class='qq qqcustomer_s'>网站客服</a>
		   				<a href='http://wpa.qq.com/msgrd?v=3&uin=960885984&site=qq&menu=yes' target='_blank' class='qq'>杂志客服</a>
		   				<a href='#' target='_blank' class='weibo'>微博客服</a>
		   				<a href='mailto:fashionbrot@163.com' class='email' title='联系邮箱'>fashionbrot@163.com</a>
		   				<span class='phone' title='服务热线'>17600382908</span>
		   				<span class='interval'>|</span>
		   				<span>有限公司 版权所有</span>
		   				<span class='interval'></span>
    				</div>

    			</dd>
    			<dd  class='foot_copyright'>
    				<div class="juzhong">
    				<span>京&nbsp;ICP&nbsp;证&nbsp;123456&nbsp;号</span>
    				<span class='interval'>|</span>
    				<span>Copyright &copy; 2006-2017, myblog, All Rights Reserved&nbsp;</span>
    				<a href='#' target='_blank'><img src='' alt='Logo' alt='' title='' /></a>
    				</div>
    			</dd>
    			</dl>
			</div>
		</div>
</footer>

</div> 
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/headjs/1.0.3/head.min.js"></script> -->
<spring:theme code="cas.javascript.file" var="casJavascriptFile" text="" />
<%-- <script type="text/javascript" src="<c:url value="${casJavascriptFile}" />"></script> --%>
</body>
</html>

