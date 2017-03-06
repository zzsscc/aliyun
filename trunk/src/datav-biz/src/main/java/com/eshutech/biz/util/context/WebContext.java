package com.eshutech.biz.util.context;

import com.google.common.collect.Maps;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

public class WebContext {
    static ThreadLocal<Map<String, Object>> webContext = new ThreadLocal<Map<String, Object>>();

    public static final String XWORK_REQUEST    = "xwork.WebContext.request";
    public static final String XWORK_RESPONSE   = "xwork.WebContext.response";
    private static final String XWORK_SESSION    = "xwork.WebContext.session";
    private static final String XWORK_PARAMETERS = "xwork.WebContext.parameters";

    public static Map<String, Object> getContext() {
        Map<String, Object> context = webContext.get();
        if (context == null) {
            context = Maps.newHashMap();
            webContext.set(context);
        }
        return context;
    }

    public static ServletContext getServletContext() {
        return (ServletContext) getContext().get(XWORK_PARAMETERS);
    }

    public static void setServletContext(ServletContext servletContext) {
        getContext().put(XWORK_PARAMETERS, servletContext);
    }

    public static HttpServletRequest getServletRequest() {
        return (HttpServletRequest) getContext().get(XWORK_REQUEST);
    }

    public static void setServletRequest(HttpServletRequest request) {
        getContext().put(XWORK_REQUEST, request);
    }

    public static HttpSession getHttpSession() {
        return (HttpSession) getContext().get(XWORK_SESSION);
    }

    public static void setHttpSession(HttpSession session) {
        getContext().put(XWORK_SESSION, session);
    }

    public void setParameters(Map<String, Object> parameters) {
        getContext().put(XWORK_PARAMETERS, parameters);
    }

    @SuppressWarnings("unchecked")
    public Map<String, Object> getParameters() {
        return (Map<String, Object>) getContext().get(XWORK_PARAMETERS);
    }

    public static HttpServletResponse getServletResponse() {
        return (HttpServletResponse) getContext().get(XWORK_RESPONSE);
    }

    public static void setServletResponse(HttpServletResponse response) {
        getContext().put(XWORK_RESPONSE, response);
    }

    public static void removeAttribute(String key) {
        getContext().remove(key);
    }

    public static void setAttribute(String key, Object value) {
        getContext().put(key, value);
    }

    @SuppressWarnings("unchecked")
    public static <T> T getAttribute(String key) {
        return (T) getContext().get(key);
    }
}