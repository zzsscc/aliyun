/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: DatavTopicsService
 * Creator:  wanggao
 * Create-Date: 上午11:12
 **/
package com.eshutech.biz.service;

import com.eshutech.biz.entity.TblDatavTopics;
import com.eshutech.biz.model.ErrorMsg;

import java.util.List;

/**
 *
 * @author: Kim
 * @date: 16/10/19
 * @time: 上午11:12
 *
 */
public interface DatavTopicsService {

    /**
     * 插入专题信息
     * @param topicName
     * @param instanceId
     * @param topicStatus
     * @param topicType
     * @return
     */
    public ErrorMsg insertTopic(String topicName, String instanceId, Integer topicStatus, Integer topicType);

    /**
     * 获取专题
     * @param instanceId
     * @return
     */
    public List<TblDatavTopics> queryTopics(String instanceId);

    /**
     * 更新专题
     * @param id
     * @param topicName
     * @param topicStatus
     * @return
     */
    public int updateTopic(Integer id,String topicName,Integer topicStatus);

    /**
     * 删除专题
     * @param id
     * @return
     */
    public int deleteTopic(Integer id);

    /**
     * 获取品牌专题
     * @param instanceId
     * @return
     */
    public TblDatavTopics queryBrandTopic(String instanceId);

    public int count(String instance);
}
