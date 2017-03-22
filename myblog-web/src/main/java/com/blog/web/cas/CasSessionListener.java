package com.blog.web.cas;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
/** 
 * Session监听器，提供由sessionId获取session的功能
 */ 
public class CasSessionListener implements HttpSessionListener {
    
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        CasSessionContext.AddSession(httpSessionEvent.getSession());
    }

    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        CasSessionContext.DelSession(session);
    }

}