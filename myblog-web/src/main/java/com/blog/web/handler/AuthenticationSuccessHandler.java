package com.blog.web.handler;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;

/**
 * 
 * 自定义的登录成功处理方法，如果不是被拦截的页面，则调整到ajax登录返回
 * 
 */
public class AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
	private static final Logger LOGGER = Logger.getLogger(AuthenticationSuccessHandler.class);
    private RequestCache requestCache = new HttpSessionRequestCache();
    private String ajaxTargetUrl;
	
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws ServletException, IOException {
    	LOGGER.info("in AuthenticationSuccessHandler");
    	
        String targetUrlParameter = getTargetUrlParameter();
        if (isAlwaysUseDefaultTargetUrl() || (targetUrlParameter != null && StringUtils.hasText(request.getParameter(targetUrlParameter)))) {
            requestCache.removeRequest(request, response);
            super.onAuthenticationSuccess(request, response, authentication); 
            return;
        }

        SavedRequest savedRequest = requestCache.getRequest(request, response);
        if (savedRequest != null) {
            clearAuthenticationAttributes(request);
            // Use the DefaultSavedRequest URL
            String targetUrl = savedRequest.getRedirectUrl();
            logger.debug("Redirecting to DefaultSavedRequest Url: " + targetUrl);
            getRedirectStrategy().sendRedirect(request, response, targetUrl);
            return;
        }
        
        ////不是被拦截的页面, 则转到ajax登录返回页面
        if (ajaxTargetUrl != null) {
            clearAuthenticationAttributes(request);
            getRedirectStrategy().sendRedirect(request, response, ajaxTargetUrl);
            return;
        }
        
        logger.error("ajaxTargetUrl is null, which is impossiable!");
        super.onAuthenticationSuccess(request, response, authentication);

        return;

    }


    
    public void setRequestCache(RequestCache requestCache) {
        this.requestCache = requestCache;
    }

	public void setAjaxTargetUrl(String ajaxTargetUrl) {
		this.ajaxTargetUrl = ajaxTargetUrl;
	}    

}

