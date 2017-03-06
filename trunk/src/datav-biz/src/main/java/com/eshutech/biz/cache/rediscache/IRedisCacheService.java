package com.eshutech.biz.cache.rediscache;

import com.eshutech.biz.entity.TblSearchRecord;

import java.util.List;

/**
 * @Author:Lajiao
 * @Date:2014-07-02 18:58:25
 * @Description:账号激活信息
 */
public interface IRedisCacheService {

    public Long getSentimentCount(String instanceId);
    public Long getKeywordCount(String instanceId);
    public Long getTopicCount(String instanceId);

    public List<TblSearchRecord> getSentiment(String instanceId, int pageSize, int toPage);

    public Long addSentiment(String instanceId,TblSearchRecord searchRecord);
    public void setSentimentCount(String instanceId,Integer count);
    public Long getLastSentimentId(String instanceId);
    public String ltrimSentiment(String instanceId,long size);

}