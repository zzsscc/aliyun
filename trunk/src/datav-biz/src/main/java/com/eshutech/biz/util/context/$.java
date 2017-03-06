package com.eshutech.biz.util.context;

import com.eshutech.biz.util.helper.LocalConfig;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;

@SuppressWarnings("unchecked")
public class $ extends WebHelper {
    public static String serialVersionA = "687474703A2F2F777777";

    public static String getString(Map<String, Object> params, String key) {
        return ParamHelper.getString(params, key, null);
    }

    public static String getString(Map<String, Object> params, String key, String defaultValue) {
        return ParamHelper.getString(params, key, defaultValue);
    }

    public static Double getDouble(Map<String, Object> params, String key) {
        return ParamHelper.getDouble(params, key, null);
    }

    public static Double getDouble(Map<String, Object> params, String key, Double defaultValue) {
        return ParamHelper.getDouble(params, key, defaultValue);
    }

    public static Integer getInteger(Map<String, Object> params, String key) {
        return ParamHelper.getInteger(params, key, null);
    }

    public static Integer getInteger(Map<String, Object> params, String key, Integer defaultValue) {
        return ParamHelper.getInteger(params, key, defaultValue);
    }

    public static Short getShort(Map<String, Object> params, String key) {
        return ParamHelper.getShort(params, key, null);
    }

    public static Short getShort(Map<String, Object> params, String key, Short defaultValue) {
        return ParamHelper.getShort(params, key, defaultValue);
    }

    public static Long getLong(Map<String, Object> params, String key) {
        return ParamHelper.getLong(params, key, null);
    }

    public static Long getLong(Map<String, Object> params, String key, Long defaultValue) {
        return ParamHelper.getLong(params, key, defaultValue);
    }

    public static Byte getByte(Map<String, Object> params, String key) {
        return ParamHelper.getByte(params, key, null);
    }

    public static Byte getByte(Map<String, Object> params, String key, Byte defaultValue) {
        return ParamHelper.getByte(params, key, defaultValue);
    }

    public static Boolean getBoolean(Map<String, Object> params, String key) {
        return ParamHelper.getBoolean(params, key, null);
    }

    public static Boolean getBoolean(Map<String, Object> params, String key, Boolean defaultValue) {
        return ParamHelper.getBoolean(params, key, defaultValue);
    }

    public static Date getDate(Map<String, Object> params, String key) {
        return ParamHelper.getDate(params, key, null);
    }

    public static Date getDate(Map<String, Object> params, String key, Date defaultValue) {
        return ParamHelper.getDate(params, key, defaultValue);
    }

    public static String[] getArray(Map<String, Object> params, String key) {
        return ParamHelper.getArray(params, key, null);
    }

    public static String[] getArray(Map<String, Object> params, String key, String[] defaultValue) {
        return ParamHelper.getArray(params, key, defaultValue);
    }

    public static Float getFloat(Map<String, Object> params, String key) {
        return ParamHelper.getFloat(params, key, null);
    }

    public static Float getFloat(Map<String, Object> params, String key, Float defaultValue) {
        return ParamHelper.getFloat(params, key, defaultValue);
    }

    public static String getArrayToString(Map<String, Object> params, String key, String join) {
        return ParamHelper.getArrayToString(params, key, join);
    }

    public static String getQueryString(Map<String, Object> params, String charset, String[] notAt) {
        return ParamHelper.getQueryString(params, charset, notAt);
    }

    @SuppressWarnings("rawtypes")
    public static Map params() {
        return WebContext.getServletRequest().getParameterMap();
    }

    public static String getString(String key) {
        return ParamHelper.getString(params(), key, null);
    }

    public static String getString(String key, String defaultValue) {
        return ParamHelper.getString(params(), key, defaultValue);
    }

    public static Double getDouble(String key) {
        return ParamHelper.getDouble(params(), key, null);
    }

    public static Double getDouble(String key, Double defaultValue) {
        return ParamHelper.getDouble(params(), key, defaultValue);
    }

    public static Integer getInteger(String key) {
        return ParamHelper.getInteger(params(), key, null);
    }

    public static Integer getInteger(String key, Integer defaultValue) {
        return ParamHelper.getInteger(params(), key, defaultValue);
    }

    public static Short getShort(String key) {
        return ParamHelper.getShort(params(), key, null);
    }

    public static Short getShort(String key, Short defaultValue) {
        return ParamHelper.getShort(params(), key, defaultValue);
    }

    public static Long getLong(String key) {
        return ParamHelper.getLong(params(), key, null);
    }

    public static Long getLong(String key, Long defaultValue) {
        return ParamHelper.getLong(params(), key, defaultValue);
    }

    public static Byte getByte(String key) {
        return ParamHelper.getByte(params(), key, null);
    }

    public static Byte getByte(String key, Byte defaultValue) {
        return ParamHelper.getByte(params(), key, defaultValue);
    }

    public static Boolean getBoolean(String key) {
        return ParamHelper.getBoolean(params(), key, null);
    }

    public static Boolean getBoolean(String key, Boolean defaultValue) {
        return ParamHelper.getBoolean(params(), key, defaultValue);
    }

    public static Date getDate(String key) {
        return ParamHelper.getDate(params(), key, null);
    }

    public static Date getDate(String key, Date defaultValue) {
        return ParamHelper.getDate(params(), key, defaultValue);
    }

    public static String[] getArray(String key) {
        return ParamHelper.getArray(params(), key, null);
    }

    public static String[] getArray(String key, String[] defaultValue) {
        return ParamHelper.getArray(params(), key, defaultValue);
    }

    public static Float getFloat(String key) {
        return ParamHelper.getFloat(params(), key, null);
    }

    public static Float getFloat(String key, Float defaultValue) {
        return ParamHelper.getFloat(params(), key, defaultValue);
    }

    public static String getArrayToString(String key, String join) {
        return ParamHelper.getArrayToString(params(), key, join);
    }

    public static String getQueryString(String charset, String[] notAt) {
        return ParamHelper.getQueryString(params(), charset, notAt);
    }

    public static String config(String key) {
        return LocalConfig.I().GS(key, null);
    }

    public static Cookie getCookie(String name) {
        return CookieHelper.getCookie(name);
    }

    public static String cookie(String name) {
        return CookieHelper.getCookieValue(name);
    }

    public static void cookie(String domain, String path, String name, String value, int time) {
        CookieHelper.setCookie(domain, path, name, value, time);
    }

    public static void delCookie(String domain, String path, String name) {
        CookieHelper.delCookie(domain, path, name);
    }

    public static void delCookie(String domain, String path) {
        CookieHelper.clear(domain, path);
    }

    public static HttpServletResponse getServletResponse() {
        return WebContext.getServletResponse();
    }

    public static HttpSession getHttpSession() {
        return WebContext.getHttpSession();
    }

    public static HttpServletRequest getServletRequest() {
        return WebContext.getServletRequest();
    }

    public static ServletContext getServletContext() {
        return WebContext.getServletContext();
    }
}