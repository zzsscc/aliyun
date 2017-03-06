/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: InstanceProfileServiceImpl
 * Creator:  wanggao
 * Create-Date: 上午10:35
 **/
package com.eshutech.biz.service.impl;

import com.eshutech.biz.entity.*;
import com.eshutech.biz.mapper.TblDatavTopicsMapper;
import com.eshutech.biz.mapper.TblInstanceProfileMapper;
import com.eshutech.biz.mapper.TblIsvInstancesMapper;
import com.eshutech.biz.service.DatavTopicsService;
import com.eshutech.biz.service.InstanceProfileService;
import com.eshutech.biz.task.TopicTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 *
 * @author: Kim
 * @date: 16/11/14
 * @time: 上午10:35
 *
 */
@Service
public class InstanceProfileServiceImpl implements InstanceProfileService {

    private Logger logger = LoggerFactory.getLogger(InstanceProfileServiceImpl.class);

    @Resource
    TblInstanceProfileMapper tblInstanceProfileMapper;

    @Resource
    TblDatavTopicsMapper tblDatavTopicsMapper;

    @Resource
    DatavTopicsService datavTopicsService;

    @Resource
    TblIsvInstancesMapper tblIsvInstancesMapper;

    @Override
    public void addSentimentCount(String instanceId,Integer value) {
        TblInstanceProfileExample example = new TblInstanceProfileExample();
        example.createCriteria().andInstanceIdEqualTo(instanceId);
        List<TblInstanceProfile> profileList = tblInstanceProfileMapper.selectByExample(example);
        if(!profileList.isEmpty())
        {
            TblInstanceProfile profile = profileList.get(0);
            TblIsvInstances tblIsvInstances = tblIsvInstancesMapper.selectByPrimaryKey(instanceId);
            Integer count = profile.getSentimentCount();
            count = count + value;
            if(count >= tblIsvInstances.getSentimentLimit())
            {
//                count = 0;
                //如果流量超标,停止所有专题
                TblDatavTopicsExample topicsExample = new TblDatavTopicsExample();
                topicsExample.createCriteria().andInstanceIdEqualTo(instanceId);
                List<TblDatavTopics> topicsList = tblDatavTopicsMapper.selectByExample(topicsExample);
                for(TblDatavTopics topics:topicsList)
                {
                    topics.setTopicStatus(0);
                    TopicTask.BI(topics);
                }
            }
            profile.setSentimentCount(count);
            profile.setModifyTime(new Date());
            tblInstanceProfileMapper.updateByPrimaryKey(profile);
        }
    }

    @Override
    public void updateWeiboAnalysisCount(String instanceId,Integer value) {
        TblInstanceProfileExample example = new TblInstanceProfileExample();
        example.createCriteria().andInstanceIdEqualTo(instanceId);
        List<TblInstanceProfile> profileList = tblInstanceProfileMapper.selectByExample(example);
        if(!profileList.isEmpty())
        {
            TblInstanceProfile profile = profileList.get(0);
            profile.setWeiboAnalysisCount(value);
            profile.setModifyTime(new Date());
            tblInstanceProfileMapper.updateByPrimaryKey(profile);
        }
    }

    @Override
    public int getSentimentCount(String instanceId) {
        int result = 0;
        TblInstanceProfileExample example = new TblInstanceProfileExample();
        example.createCriteria().andInstanceIdEqualTo(instanceId);
        List<TblInstanceProfile> profileList = tblInstanceProfileMapper.selectByExample(example);
        if(!profileList.isEmpty()) {
            TblInstanceProfile profile = profileList.get(0);
            result = profile.getSentimentCount();
        }
        return result;
    }

    @Override
    public int getWeiboAnalysisCount(String instanceId) {
        int result = 0;
        TblInstanceProfileExample example = new TblInstanceProfileExample();
        example.createCriteria().andInstanceIdEqualTo(instanceId);
        List<TblInstanceProfile> profileList = tblInstanceProfileMapper.selectByExample(example);
        if(!profileList.isEmpty()) {
            TblInstanceProfile profile = profileList.get(0);
            result = profile.getWeiboAnalysisCount();
        }
        return result;
    }
}
