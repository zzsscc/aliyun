package com.eshutech.biz.cache.rediscache.impl;


import com.alibaba.fastjson.JSON;
import com.eshutech.biz.cache.Cache;
import com.eshutech.biz.cache.CacheConstants;
import com.eshutech.biz.cache.DefaultGetCacheClosure;
import com.eshutech.biz.cache.exception.RedisException;
import com.eshutech.biz.cache.rediscache.IRedisCacheService;
import com.eshutech.biz.entity.TblSearchRecord;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("redisCacheService")
public class RedisCacheService implements IRedisCacheService {
    private static final Logger logger          = LoggerFactory.getLogger(RedisCacheService.class);
    public static final  String SENTIMENT_NO = "instance.sentiment.no_";
    public static final  String KEYWORD_NO = "instance.keyword.no_";
    public static final  String TOPIC_NO = "instance.topic.no_";
    public static final  String SENTIMENT_RECORD = "instance.sentiment.record_";

    @Resource(name = "cache")
    Cache cache;

    /**
     * 每个实例的舆情数量
     * @param instanceId
     * @return
     */
    @Override
    public Long getSentimentCount(String instanceId) {
        final String key = CacheConstants.Keys(SENTIMENT_NO, instanceId);
        Long value = null;
        try {
            value = (Long)cache.get(new DefaultGetCacheClosure() {
                @Override
                public String getKey() {
                    return key;
                }
                @Override
                public Long getValue() {
                    return 0L;
                }
                @Override
                public TypeReference<Long> getTypeReference() {
                    return new TypeReference<Long>(){};
                }
            });
        } catch (RedisException e) {
            e.printStackTrace();
        }
        return value == null ? 0 : value;
    }

    @Override
    public Long getKeywordCount(String instanceId)
    {
        String key = CacheConstants.Keys(KEYWORD_NO, instanceId);
        long value = 0;
        try {
            value = cache.increment(key, 1L);
        } catch (RedisException e) {
            e.printStackTrace();
        }
        return value;
    }

    @Override
    public Long getTopicCount(String instanceId) {
        final String key = CacheConstants.Keys(TOPIC_NO, instanceId);
        Long value = null;
        try {
            value = (Long)cache.get(new DefaultGetCacheClosure() {
                @Override
                public String getKey() {
                    return key;
                }

                @Override
                public Long getValue() {
                    return 0L;
                }

                @Override
                public TypeReference<?> getTypeReference() {
                    return null;
                }
            });
        } catch (RedisException e) {
            e.printStackTrace();
        }
        return value == null ? 0:value;
    }

    /**
     * 获取实例下的舆情数据
     * @param instanceId
     * @param pageSize
     * @param toPage
     * @return
     */
    @Override
    public List<TblSearchRecord> getSentiment(String instanceId, int pageSize, int toPage) {
        final String key = CacheConstants.Keys(SENTIMENT_RECORD, instanceId);
        List<TblSearchRecord> value = null;
        try {
            value = cache.lrange(TblSearchRecord.class,key,(toPage-1)*pageSize,(toPage*pageSize-1));
        } catch (RedisException e) {
            e.printStackTrace();
        }
        return value;
    }

    /**
     * 将舆情数据插入到该用户实例里去
     * @param instanceId
     * @param searchRecord
     * @return
     */
    @Override
    public Long addSentiment(String instanceId,TblSearchRecord searchRecord)
    {
        final String key = CacheConstants.Keys(SENTIMENT_RECORD, instanceId);
        Long value=null;
        try {
            String str = JSON.toJSONString(searchRecord);
            value = cache.lpush(key, str);
        } catch (RedisException e) {
            e.printStackTrace();
        }
        return value == null ? 0 : value;
    }

    @Override
    public void setSentimentCount(String instanceId,Integer count)
    {
        final String countKey = CacheConstants.Keys(SENTIMENT_NO, instanceId);

        try {
            cache.del(countKey);
            cache.increment(countKey,count);
        } catch (RedisException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Long getLastSentimentId(String instanceId) {
        final String key = CacheConstants.Keys(SENTIMENT_RECORD, instanceId);
        Long result = 0L;
        List<TblSearchRecord> value = null;
        try {
            value = cache.lrange(TblSearchRecord.class, key, 0, 0);
        }
        catch (RedisException e){
            e.printStackTrace();
        }
        if(null != value && !value.isEmpty())
        {
            result = value.get(0).getId();
        }
        return result;
    }

    @Override
    public String ltrimSentiment(String instanceId, long size) {
        final String key = CacheConstants.Keys(SENTIMENT_RECORD, instanceId);
        String value=null;
        try {
            value = cache.ltrim(key,0,size-1);
        } catch (RedisException e) {
            e.printStackTrace();
        }
        return value;
    }
}
