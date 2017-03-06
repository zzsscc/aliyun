package com.eshutech.biz.util.context;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieHelper {
    public static final int ONE_DAY   = 86400;
    public static final int ONE_MONTH = 2592000;
    public static final int ONE_WEEK  = 604800;
    public static final int ONE_YEAR  = 604800;
    public static final int ONE_TIME  = -1;

    public static Cookie getCookie(String name) {
        HttpServletRequest request = WebContext.getServletRequest();
        Cookie[] cookies = request.getCookies();
        if (cookies != null)
            for (Cookie cookie : cookies) {
                if (equals(cookie.getName(), name).booleanValue())
                    return cookie;
            }
        return null;
    }

    public static String getCookieValue(String name) {
        Cookie cookie = getCookie(name);
        if (cookie != null)
            return cookie.getValue();
        return null;
    }

    public static void setCookie(String domain, String path, String name, String value, int time) {
        HttpServletResponse response = WebContext.getServletResponse();
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(time);
        cookie.setPath(path);
        if (!empty(domain).booleanValue())
            cookie.setDomain(domain);
        response.addCookie(cookie);
    }

    public static void delCookie(String domain, String path, String name) {
        HttpServletResponse response = WebContext.getServletResponse();
        HttpServletRequest request = WebContext.getServletRequest();
        Cookie[] cookies = request.getCookies();
        if (cookies != null)
            for (Cookie cookie : cookies)
                if (equals(cookie.getName(), name).booleanValue()) {
                    if (!empty(domain).booleanValue())
                        cookie.setDomain(domain);
                    cookie.setPath(path);
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
    }

    public static void clear(String domain, String path) {
        if (domain == null)
            domain = "";
        HttpServletResponse response = WebContext.getServletResponse();
        HttpServletRequest request = WebContext.getServletRequest();
        Cookie[] cookies = request.getCookies();
        if (cookies != null)
            for (Cookie cookie : cookies) {
                if (!empty(domain).booleanValue())
                    cookie.setDomain(domain);
                cookie.setPath(path);
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
    }

    public static Boolean equals(String v1, String v2) {
        if ((v1 == null) && (v2 == null))
            return Boolean.valueOf(true);
        if ((v1 != null) && (v2 != null) && (v1.equals(v2))) {
            return Boolean.valueOf(true);
        }
        return Boolean.valueOf(false);
    }

    public static Boolean empty(String string) {
        if ((string == null) || (string.trim().equals("")))
            return Boolean.valueOf(true);
        return Boolean.valueOf(false);
    }
}