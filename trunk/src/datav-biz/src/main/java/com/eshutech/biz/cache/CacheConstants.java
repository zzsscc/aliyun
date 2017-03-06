package com.eshutech.biz.cache;


import com.eshutech.biz.util.StringUtil;

/**
 * @Author: Lajiao
 * @Date: 12-3-23
 * @Time: 上午9:24
 * @Description: 缓存KEY参数
 */
public class CacheConstants {
    public static final int    TIMEOUT_DAY         = 24 * 60 * 60;
    public static final int    TIMEOUT_MONTH       = 31 * 24 * 60 * 60;
    public static final String CACHE_KEY_SEPARATOR = "_";
    public static final String CACHE_DEFAULT_VALUE = "-3";
    // CACHE-GROUP
    public static final String CACHE_DEFAULT_DB    = "1";
    public static final String CACHE_ORDER         = "O";
    public static final String CACHE_SETTLE        = "S";
    public static final String CACHE_CASH          = "C";
    public static final String REDIS_MQ            = "RedisMq";

    /**
     * 缓存键值
     */
    public static final String Keys(Object... objects) {
        if (objects == null || objects.length <= 0) {
            return null;
        }
        StringBuffer rtn = new StringBuffer();
        for (Object k : objects) {
            rtn.append(StringUtil.nullToEmpty(k)).append(CACHE_KEY_SEPARATOR);
        }
        return rtn.toString();
    }
}
