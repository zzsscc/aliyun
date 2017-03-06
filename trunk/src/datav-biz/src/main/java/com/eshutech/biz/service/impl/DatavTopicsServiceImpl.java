/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: DatavTopicsServiceImpl
 * Creator:  wanggao
 * Create-Date: 上午11:15
 **/
package com.eshutech.biz.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.eshutech.biz.constant.Constants;
import com.eshutech.biz.entity.*;
import com.eshutech.biz.mapper.TblDatavTopicsMapper;
import com.eshutech.biz.mapper.TblIsvInstancesMapper;
import com.eshutech.biz.mapper.TblSystemCodeMapper;
import com.eshutech.biz.model.ErrorMsg;
import com.eshutech.biz.service.DatavTopicsService;
import com.eshutech.biz.util.AESDecode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author: Kim
 * @date: 16/10/19
 * @time: 上午11:15
 *
 */
@Service
public class DatavTopicsServiceImpl implements DatavTopicsService {
    @Resource
    TblDatavTopicsMapper tblDatavTopicsMapper;

    @Resource
    TblSystemCodeMapper tblSystemCodeMapper;

    @Resource
    TblIsvInstancesMapper tblIsvInstancesMapper;


    private Logger logger = LoggerFactory.getLogger(DatavTopicsServiceImpl.class);


    @Override
    public ErrorMsg insertTopic(String topicName, String instanceId, Integer topicStatus, Integer topicType) {
        ErrorMsg errorMsg = new ErrorMsg();

        TblDatavTopicsExample example = new TblDatavTopicsExample();
        example.createCriteria().andInstanceIdEqualTo(instanceId);
        List<TblDatavTopics> topicsList = tblDatavTopicsMapper.selectByExample(example);
        TblIsvInstances instances = tblIsvInstancesMapper.selectByPrimaryKey(instanceId);
        Integer topicLimit = instances.getTopicLimit();

        if(topicsList.size() >= topicLimit)
        {
            errorMsg.setSuccess("false");
            errorMsg.setMessage("添加品牌已达上限,每个用户最多可添加"+topicLimit+"个品牌");
            return errorMsg;
        }
        /*
         * STEP1:查询是否已存在类型为0的专题,如果已存在,不允许添加,只能添加类型为1的
         */
        TblDatavTopicsExample topicsExample = new TblDatavTopicsExample();
        topicsExample.createCriteria().andInstanceIdEqualTo(instanceId).andTopicTypeEqualTo(0);
        List<TblDatavTopics> list = tblDatavTopicsMapper.selectByExample(topicsExample);
        if(!list.isEmpty() && topicType.equals(0))
        {
            errorMsg.setSuccess("false");
            return errorMsg;
        }

        /*
         * STEP2:请求数加接口
         */

        Map<String,Object> param = new HashMap<String, Object>();
        param.put("name",topicName+"_"+instances.getUid());
        if(null != topicStatus)
        {
            param.put("status",topicStatus);
        }
        String paramBody = JSON.toJSONString(param);
        String result = AESDecode.sendPost(Constants.URL+"createTopic",paramBody, Constants.AK_ID, Constants.AK_SECRET);
        logger.info(result);
        JSONObject object = JSON.parseObject(result);
        if(object.getBoolean("success"))
        {
            TblDatavTopics tblDatavTopics = new TblDatavTopics();
            tblDatavTopics.setTopicName(topicName);
            tblDatavTopics.setInstanceId(instanceId);
            tblDatavTopics.setCreateTime(new Date());
            tblDatavTopics.setModifyTime(new Date());
            tblDatavTopics.setTopicStatus(topicStatus);
            tblDatavTopics.setTopicType(topicType);
            tblDatavTopics.setTopicId(object.getString("result"));
            tblDatavTopicsMapper.insert(tblDatavTopics);
            errorMsg.setSuccess("true");
            return errorMsg;
        }
        else
        {
            errorMsg.setMessage("添加品牌失败,请稍后再试!");
            errorMsg.setSuccess("false");
            return errorMsg;
        }
    }

    @Override
    public List<TblDatavTopics> queryTopics(String instanceId) {
        TblDatavTopicsExample topicsExample = new TblDatavTopicsExample();
        topicsExample.createCriteria().andInstanceIdEqualTo(instanceId);
        List<TblDatavTopics> list = tblDatavTopicsMapper.selectByExample(topicsExample);
        return list;
    }

    @Override
    public int updateTopic(Integer id,String topicName,Integer topicStatus) {

        TblDatavTopics tblDatavTopics = tblDatavTopicsMapper.selectByPrimaryKey(id);
        TblIsvInstances instances = tblIsvInstancesMapper.selectByPrimaryKey(tblDatavTopics.getInstanceId());
        Map<String,Object> param = new HashMap<String, Object>();
        //TODO:取用户数据
        param.put("id",Integer.parseInt(tblDatavTopics.getTopicId()));
        param.put("name",topicName+"_"+instances.getUid());
        param.put("status",topicStatus);

        String paramBody = JSON.toJSONString(param);
        String result = AESDecode.sendPost(Constants.URL+"updateTopic",paramBody, Constants.AK_ID, Constants.AK_SECRET);
        logger.info(result);
        JSONObject object = JSON.parseObject(result);
        if(object.getBoolean("success"))
        {
            tblDatavTopics.setTopicStatus(topicStatus);
            tblDatavTopics.setTopicName(topicName);
            tblDatavTopics.setModifyTime(new Date());
            tblDatavTopicsMapper.updateByPrimaryKey(tblDatavTopics);
            return 1;
        }
        else
        {
            return 0;
        }
    }

    @Override
    public int deleteTopic(Integer id) {

        TblDatavTopics tblDatavTopics = tblDatavTopicsMapper.selectByPrimaryKey(id);

        Map<String,String> param = new HashMap<String, String>();
//        //TODO:取用户数据
        param.put("id",tblDatavTopics.getTopicId());
        String paramBody = JSON.toJSONString(param);
        String result = AESDecode.sendPost(Constants.URL+"deleteTopic",paramBody, Constants.AK_ID, Constants.AK_SECRET);
        logger.info(result);
        JSONObject object = JSON.parseObject(result);
        if(object.getBoolean("success"))
        {
            tblDatavTopicsMapper.deleteByPrimaryKey(id);
            return 1;
        }
        else
        {
            return 0;
        }
    }

    @Override
    public TblDatavTopics queryBrandTopic(String instanceId) {
        TblDatavTopicsExample topicsExample = new TblDatavTopicsExample();
        topicsExample.createCriteria().andInstanceIdEqualTo(instanceId).andTopicTypeEqualTo(0);
        List<TblDatavTopics> list = tblDatavTopicsMapper.selectByExample(topicsExample);
        if(!list.isEmpty())
        {
            return list.get(0);
        }
        return null;
    }

    @Override
    public int count(String instance) {
        TblDatavTopicsExample tblDatavTopicsExample = new TblDatavTopicsExample();
        tblDatavTopicsExample.createCriteria().andInstanceIdEqualTo(instance);
        return tblDatavTopicsMapper.countByExample(tblDatavTopicsExample);
    }

}
