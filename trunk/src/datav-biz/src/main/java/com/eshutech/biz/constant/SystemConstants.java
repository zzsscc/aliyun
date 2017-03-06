package com.eshutech.biz.constant;

/**
 * @Author: Lajiao
 * @Date: 12-3-18
 * @Time: 下午3:21
 * @Description: 系统常量
 */
public class SystemConstants {
    // 字符编码
    public static final String DEFAULT_ENCODE            = "UTF-8";
    public static final String DEFAULT_CHARSET           = "UTF-8";
    public static final String DEFAULT_HTTP_CONTENT_TYPE = "application/json;charset=UTF-8";
    public static final String APPEND_DEFAULT            = ".";
    // 数据分页
    public static final int    PAGE_LIMIT_10             = 10;
    public static final int    PAGE_LIMIT_16             = 16;
    public static final int    PAGE_LIMIT_20             = 20;
    public static final int    PAGE_LIMIT_50             = 50;
    public static final int    PAGE_LIMIT_100            = 100;
    public static final int    PAGE_LIMIT_200            = 200;
    // KEY宝开头
    public static final String KEY_START_WITH            = "150";

    // SESSION
    public static class SESSION {
        public static final String SESSION_ADMIN_LOGIN_ID = "admin_login_id";
        public static final String SESSION_ADMIN_LOGIN    = "admin_login";
        public static final int    SESSION_EXPIRES        = 14 * 24 * 3600;
    }
}
