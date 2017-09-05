package com.blog.web.cas;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

/** 
 * 为了在集群环境中跟踪并取得session，添加此工具类
 */ 
public class CasSessionContext {

    private static Map<String, HttpSession> sessionMap = new HashMap<String, HttpSession>();

    public static synchronized void AddSession(HttpSession session) {
        if (session != null) {
            sessionMap.put(session.getId(), session);
        }
    }

    public static synchronized void DelSession(HttpSession session) {
        if (session != null) {
            sessionMap.remove(session.getId());
        }
    }

    public static synchronized HttpSession getSession(String sessionId) {
        if (sessionId == null) {
            return null;
        }
        return (HttpSession) sessionMap.get(sessionId);
    }
    
}

