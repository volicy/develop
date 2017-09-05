package com.test.springboot.config.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class JackInterceptor implements HandlerInterceptor {
    
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
        System.out.println(this.getClass().getName() + "<------>preHandle");
        return true;
    }
    
    public void postHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        System.out.println(this.getClass().getName() + "<------>postHandle");
        
    }
    
    public void afterCompletion(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        System.out.println(this.getClass().getName()
                + "<------>afterCompletion");
        
    }
    
}
