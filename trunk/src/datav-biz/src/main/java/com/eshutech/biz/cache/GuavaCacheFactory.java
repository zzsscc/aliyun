package com.eshutech.biz.cache;



/**
 * @Author:Binwei.Chen
 * @Date:2015/2/2
 * @Description:
 */
public class GuavaCacheFactory {

    private static GuavaCacheFactory instance;
    private static LRUCache<String, Object> lruCache = new LRUCache<String, Object>(20000);

    private GuavaCacheFactory() {
    }

    public static synchronized GuavaCacheFactory instance() {
        if (instance == null) {
            instance = new GuavaCacheFactory();
            instance.initSize(1000);
        }
        return instance;
    }

    private static void initSize(int size) {
        if (lruCache.getCacheSize() > 0) {
            lruCache.init();
        }
        lruCache.setCacheSize(size);
    }

    public static void clear() {
        lruCache.clear();
    }

    public static Object get(String group, String key) {
        return lruCache.get(group + CacheConstants.CACHE_KEY_SEPARATOR + key);
    }

    public static void put(String group, String key, Object value) {
        lruCache.put(group + CacheConstants.CACHE_KEY_SEPARATOR + key, value);
    }
}
