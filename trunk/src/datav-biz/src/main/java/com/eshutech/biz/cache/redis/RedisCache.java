package com.eshutech.biz.cache.redis;


import com.eshutech.biz.cache.Cache;
import com.eshutech.biz.cache.CacheClosure;
import com.eshutech.biz.cache.DefaultHGetAndSetCacheClosure;
import com.eshutech.biz.cache.exception.RedisException;
import com.eshutech.biz.cache.util.JsonUtils;
import org.codehaus.jackson.type.TypeReference;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Lajiao
 * @Date: 13-12-04
 * @Time: 上午9:47
 * @Description: to write something
 */
public class RedisCache implements Cache {
    private final String DEFAULT_HOST = "127.0.0.1";
    private final int    DEFAULT_PORT = 6379;
    private JedisPool pool;
    private String  host         = DEFAULT_HOST;
    private int     port         = DEFAULT_PORT;
    private int     timeout      = 60000;
    private int     maxActive    = 100;
    private int     maxIdle      = 20;
    private int     maxWait      = 1000;
    private String  auth         = "mac_redis@123";
    private Integer dbIndex      = 0;
    private boolean testOnBorrow = false;

    public void init() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxActive(maxActive);
        config.setMaxIdle(maxIdle);
        config.setMaxWait(maxWait);
        config.setTestOnBorrow(testOnBorrow);

        if (auth == null || auth.trim().length() <= 0) {
            pool = new JedisPool(config, host, port, timeout);
        } else {
            pool = new JedisPool(config, host, port, timeout, auth);
            Jedis jedis = pool.getResource();
            jedis.lpush("connect","success");
        }

    }

    public void destroy() {
        pool.destroy();
    }

    public void del(String key) throws RedisException {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            if (dbIndex != 0) {
                jedis.select(dbIndex);
            }
            jedis.del(key);
        } catch (Exception e) {
            throw new RedisException("505", "redis del key:[" + key + "] failure.");
        } finally {
            pool.returnResource(jedis);
        }
    }

    public Object set(CacheClosure cacheClosure) throws RedisException {
        Object value = cacheClosure.getValue();
        if (null != value) {
            String json = JsonUtils.objectToJson(value);

            Jedis jedis = null;
            try {
                jedis = pool.getResource();
                if (dbIndex != 0) {
                    jedis.select(dbIndex);
                }
                if (null == cacheClosure.getTime()) {
                    jedis.set(cacheClosure.getKey(), json);
                } else {
                    jedis.setex(cacheClosure.getKey(), cacheClosure.getTime(), json);
                }
            } catch (Exception e) {
                throw new RedisException("505", "redis put object:[" + cacheClosure + "] failure.");
            } finally {
                pool.returnResource(jedis);
            }
        } else {
            // if json is null,set default value
            if (cacheClosure.getIfNullSetDefaultValue()) {
                Jedis jedis = null;
                try {
                    jedis = pool.getResource();
                    if (dbIndex != 0) {
                        jedis.select(dbIndex);
                    }
                    if (null == cacheClosure.getTime()) {
                        jedis.set(cacheClosure.getKey(), cacheClosure.getIfNullDefaultValue());
                    } else {
                        jedis.setex(cacheClosure.getKey(), cacheClosure.getTime(), cacheClosure.getIfNullDefaultValue());
                    }
                } catch (Exception e) {
                    throw new RedisException("505", "redis put object:[" + cacheClosure + "] failure.");
                } finally {
                    pool.returnResource(jedis);
                }
            }
        }
        return value;
    }

    public Object get(CacheClosure cacheClosure) throws RedisException {
        Jedis jedis = null;
        String json = null;

        try {
            jedis = pool.getResource();
            if (dbIndex != 0) {
                jedis.select(dbIndex);
            }
            json = jedis.get(cacheClosure.getKey());
        } catch (Exception e) {
            throw new RedisException("505", "redis get object:[" + cacheClosure + "] failure.");
        } finally {
            pool.returnResource(jedis);
        }

        if (null == json) {
            return null;
        } else {
            if (cacheClosure.getIfNullSetDefaultValue()) {
                if (json.equals(cacheClosure.getIfNullDefaultValue())) {
                    return null;
                }
            }
            return JsonUtils.jsonToObject(json, cacheClosure.getTypeReference());
        }
    }

    public <T> List<T> mulGet(Class<T> className, boolean ifNullSetDefaultValue, String defaultValue, String... key) throws RedisException {
        Jedis jedis = null;
        List<String> jsonList = null;
        try {
            jedis = pool.getResource();
            if (dbIndex != 0) {
                jedis.select(dbIndex);
            }
            jsonList = jedis.mget(key);
        } catch (Exception e) {
            throw new RedisException("505", "redis get object:[" + key.toString() + "] failure.");
        } finally {
            pool.returnResource(jedis);
        }

        if (null == jsonList || jsonList.size() == 0) {
            return null;
        } else {
            List<T> result = new ArrayList<T>();

            for (String json : jsonList) {
                if (null == json) {
                    result.add(null);
                } else {
                    if (ifNullSetDefaultValue) {
                        if (json.equals(defaultValue)) {
                            result.add(null);
                            continue;
                        }
                    }
                    T object = JsonUtils.jsonToObject(json, className, false);
                    result.add(object);
                }
            }

            return result;
        }
    }


    public <T> List<T> lrange(Class<T> className, String key,int start,int end) throws RedisException {
        Jedis jedis = null;
        List<String> jsonList = null;
        try {
            jedis = pool.getResource();
            if (dbIndex != 0) {
                jedis.select(dbIndex);
            }
            jsonList = jedis.lrange(key,start,end);
        } catch (Exception e) {
            throw new RedisException("505", "redis get object:[" + key.toString() + "] failure.");
        } finally {
            pool.returnResource(jedis);
        }

        if (null == jsonList || jsonList.size() == 0) {
            return null;
        } else {
            List<T> result = new ArrayList<T>();

            for (String json : jsonList) {
                if (null == json) {
                    result.add(null);
                } else {
                    T object = JsonUtils.jsonToObject(json, className, false);
                    result.add(object);
                }
            }

            return result;
        }
    }

    public List<?> mulGetAndSet(final TypeReference<?> typeReference, boolean ifNullSetDefaultValue, String defaultValue, final String[] key,
                                final CacheClosure[] values) throws RedisException
    {
        Jedis jedis = null;
        List<String> jsonList = null;
        try {
            jedis = pool.getResource();
            if (dbIndex != 0) {
                jedis.select(dbIndex);
            }
            jsonList = jedis.mget(key);
        } catch (Exception e) {
            throw new RedisException("505", "redis get object:[" + key.toString() + "] failure.");
        } finally {
            pool.returnResource(jedis);
        }

        List<Object> result = new ArrayList<Object>();
        if (null == jsonList || jsonList.size() == 0) {
            for (int i = 0; i < key.length; i++) {
                Object value = set(values[i]);
                result.add(value);
            }
            return result;
        } else {
            for (int i = 0; i < jsonList.size(); i++) {
                String json = jsonList.get(i);
                if (null == json) {
                    Object value = set(values[i]);
                    result.add(value);
                } else {
                    if (ifNullSetDefaultValue) {
                        if (json.equals(defaultValue)) {
                            result.add(null);
                            continue;
                        }
                    }
                    Object object = JsonUtils.jsonToObject(json, typeReference);
                    result.add(object);
                }
            }

            return result;
        }
    }

    public Object getAndSet(CacheClosure cacheClosure) throws RedisException {
        Jedis jedis = null;
        String json = null;
        try {
            jedis = pool.getResource();
            if (dbIndex != 0) {
                jedis.select(dbIndex);
            }
            json = jedis.get(cacheClosure.getKey());
        } catch (Exception e) {
            throw new RedisException("505", "redis get object:[" + cacheClosure + "] failure.");
        } finally {
            pool.returnResource(jedis);
        }

        if (null == json) {
            Object value = cacheClosure.getValue();

            if (null != value) {
                json = JsonUtils.objectToJson(value);
            } else if (cacheClosure.getIfNullSetDefaultValue()) {
                json = cacheClosure.getIfNullDefaultValue();
            }

            if (null != json) {
                try {
                    jedis = pool.getResource();
                    if (dbIndex != 0) {
                        jedis.select(dbIndex);
                    }
                    if (null == cacheClosure.getTime()) {
                        jedis.set(cacheClosure.getKey(), json);
                    } else {
                        jedis.setex(cacheClosure.getKey(), cacheClosure.getTime(), json);
                    }
                } catch (Exception e) {
                    throw new RedisException("505", "redis set object:[" + cacheClosure + "] failure.");
                } finally {
                    pool.returnResource(jedis);
                }
            }

            return value;
        } else {
            if (cacheClosure.getIfNullSetDefaultValue()) {
                if (json.equals(cacheClosure.getIfNullDefaultValue())) {
                    return null;
                }
            }
            return JsonUtils.jsonToObject(json, cacheClosure.getTypeReference());
        }
    }

    public Object hgetAndSet(String key, DefaultHGetAndSetCacheClosure cacheClosure) throws RedisException {
        Jedis jedis = null;
        String json = null;
        try {
            jedis = pool.getResource();
            if (dbIndex != 0) {
                jedis.select(dbIndex);
            }
            json = jedis.hget(key, cacheClosure.getKey());
        } catch (Exception e) {
            throw new RedisException("505", "redis get object:[" + cacheClosure + "] failure.");
        } finally {
            pool.returnResource(jedis);
        }

        if (null == json) {
            Object value = cacheClosure.getValue();

            if (null != value) {
                json = JsonUtils.objectToJson(value);
            } else if (cacheClosure.getIfNullSetDefaultValue()) {
                json = cacheClosure.getIfNullDefaultValue();
            }

            if (null != json) {
                try {
                    jedis = pool.getResource();
                    if (dbIndex != 0) {
                        jedis.select(dbIndex);
                    }
                    jedis.hset(key, cacheClosure.getKey(), json);
                } catch (Exception e) {
                    throw new RedisException("505", "redis set object:[" + cacheClosure + "] failure.");
                } finally {
                    pool.returnResource(jedis);
                }
            }

            return value;
        } else {
            if (cacheClosure.getIfNullSetDefaultValue()) {
                if (json.equals(cacheClosure.getIfNullDefaultValue())) {
                    return null;
                }
            }
            return JsonUtils.jsonToObject(json, cacheClosure.getTypeReference());
        }
    }

    public long increment(String key, long value) throws RedisException {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            if (dbIndex != 0) {
                jedis.select(dbIndex);
            }
            return jedis.incrBy(key, value);
        } catch (Exception e) {
            throw new RedisException("505", "redis increment key:[" + key + "] value:[" + value + "] failure.");
        } finally {
            pool.returnResource(jedis);
        }
    }

    public void setTimeout(String key, int seconds) throws RedisException {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            if (dbIndex != 0) {
                jedis.select(dbIndex);
            }
            jedis.expire(key, seconds);
        } catch (Exception e) {
            throw new RedisException("505", "redis set key:[" + key + "] timeout:[" + seconds + "] failure.");
        } finally {
            pool.returnResource(jedis);
        }
    }

    public Long lpush(String key, String msg) throws RedisException {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            if (dbIndex != 0) {
                jedis.select(dbIndex);
            }

            return jedis.lpush(key, msg);

        } catch (Exception e) {
            throw new RedisException("505", "redis lpush key:[" + key + "] msg:[" + msg + "] failure.");
        } finally {
            pool.returnResource(jedis);
        }
    }

    public List<String> brpop(String key, int timeOut) throws RedisException {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            if (dbIndex != 0) {
                jedis.select(dbIndex);
            }
            List<String> rtn = jedis.brpop(timeOut, key);
            return rtn;
        } catch (Exception e) {
            throw new RedisException("505", "redis brpop key:[" + key + "] timeout:[" + timeOut + "] failure.");
        } finally {
            pool.returnResource(jedis);
        }
    }


    public String ltrim(String key, long start,long end) throws RedisException {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            if (dbIndex != 0) {
                jedis.select(dbIndex);
            }
            return jedis.ltrim(key, start,end);

        } catch (Exception e) {
            throw new RedisException("505", "redis ltrim key:[" + key + "] failure.");
        } finally {
            pool.returnResource(jedis);
        }
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getMaxActive() {
        return maxActive;
    }

    public void setMaxActive(int maxActive) {
        this.maxActive = maxActive;
    }

    public int getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(int maxIdle) {
        this.maxIdle = maxIdle;
    }

    public int getMaxWait() {
        return maxWait;
    }

    public void setMaxWait(int maxWait) {
        this.maxWait = maxWait;
    }

    public JedisPool getPool() {
        return pool;
    }

    public void setPool(JedisPool pool) {
        this.pool = pool;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public boolean isTestOnBorrow() {
        return testOnBorrow;
    }

    public void setTestOnBorrow(boolean testOnBorrow) {
        this.testOnBorrow = testOnBorrow;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public static void main(String[] args) {
        RedisCache cache = new RedisCache();
        cache.init();
        //cache.setAuth("mac_redis@123");
        //
        // Jedis jedis = cache.getPool().getResource();
        // List<String> values = jedis.mget("c_t_a_p_11");
        // System.out.println(values);
        // cache.increment("c_t_a_p_11",1);

        List<Long> values = null;
        try {
            values = cache.mulGet(Long.class, true, "-3", "c_t_a_p_14");
        } catch (RedisException e) {
            e.printStackTrace();
        }
        System.out.println(values);
    }

    public Integer getDbIndex() {
        return dbIndex;
    }

    public void setDbIndex(Integer dbIndex) {
        this.dbIndex = dbIndex;
    }
}
