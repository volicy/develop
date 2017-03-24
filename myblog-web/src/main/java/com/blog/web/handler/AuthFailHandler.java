package com.blog.web.handler;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

/**
 * 实现登录中的异常处理
 */
public class AuthFailHandler implements AuthenticationFailureHandler {
	private static final Logger LOGGER = Logger.getLogger(AuthFailHandler.class);
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	private String loginUrl;
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException ex)
			throws IOException, ServletException {
		LOGGER.info("in AuthFailHandler: " + request.getRequestURL(), ex);
		redirectStrategy.sendRedirect(request, response, loginUrl);
	}

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

}
