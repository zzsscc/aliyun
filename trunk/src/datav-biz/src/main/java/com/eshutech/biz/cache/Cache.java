package com.eshutech.biz.cache;

import com.eshutech.biz.cache.exception.RedisException;
import org.codehaus.jackson.type.TypeReference;

import java.util.List;

/**
 * @Author:Lajiao
 * @Date:2014年8月19日
 * @Time:下午4:24:32
 * @Description:接口方法类
 */
public interface Cache {
    public void init();

    public void destroy();

    public void del(String key) throws RedisException;

    public Object set(CacheClosure cacheClosure) throws RedisException;

    public Object get(CacheClosure cacheClosure) throws RedisException;

    public <T> List<T> mulGet(Class<T> className, boolean ifNullSetDefaultValue, String defaultValue, String... key) throws RedisException;

    public <T> List<T> lrange(Class<T> className, String key,int start,int end) throws RedisException;

    public List<?> mulGetAndSet(TypeReference<?> typeReference, boolean ifNullSetDefaultValue, String defaultValue, String[] key, CacheClosure[] values) throws RedisException;

    public Object getAndSet(CacheClosure cacheClosure) throws RedisException;

    public Object hgetAndSet(String key, DefaultHGetAndSetCacheClosure cacheClosure) throws RedisException;

    public long increment(String key, long value) throws RedisException;

    public void setTimeout(String key, int seconds) throws RedisException;

    public Long lpush(String key, String msg) throws RedisException;
    public String ltrim(String key, long start,long end) throws RedisException;

    public List<String> brpop(String key, int timeOut) throws RedisException;

}
