/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: DatavKeywordsService
 * Creator:  wanggao
 * Create-Date: 下午2:06
 **/
package com.eshutech.biz.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.eshutech.biz.constant.Constants;
import com.eshutech.biz.entity.*;
import com.eshutech.biz.mapper.TblDatavKeywordsMapper;
import com.eshutech.biz.mapper.TblDatavTopicsMapper;
import com.eshutech.biz.mapper.TblIsvInstancesMapper;
import com.eshutech.biz.mapper.TblSystemCodeMapper;
import com.eshutech.biz.model.ErrorMsg;
import com.eshutech.biz.service.DatavKeywordsService;
import com.eshutech.biz.util.AESDecode;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 *
 * @author: Kim
 * @date: 16/10/18
 * @time: 下午2:06
 *
 */
@Service
public class DatavKeywordsServiceImpl implements DatavKeywordsService {

    @Resource
    private TblDatavKeywordsMapper tblDatavKeywordsMapper;

    @Resource
    private TblDatavTopicsMapper    tblDatavTopicsMapper;

    @Resource
    TblSystemCodeMapper tblSystemCodeMapper;

    @Resource
    TblIsvInstancesMapper tblIsvInstancesMapper;

    private Logger logger = LoggerFactory.getLogger(DatavKeywordsServiceImpl.class);

    @Override
    public ErrorMsg insertKeyword(String keyword,Integer topicId,String siteTypeIds) {

        ErrorMsg errorMsg = new ErrorMsg();

        //TODO:先插入到本地记录,然后再同步到阿里云,后台管理:对没有成功同步到阿里云的关键词,要做怎样的处理

        /*
         * STEP 1
         */
        List<String> list = JSON.parseArray(keyword,String.class);
        List<Integer> typeList = JSON.parseArray(siteTypeIds,Integer.class);

//        for(int i = 0;i<list.size();i++)
//        {
//            TblDatavKeywords datavKeywords = new TblDatavKeywords();
//            datavKeywords.setKeyword(list.get(i));
//            //此处的topicId为自身系统内的topic的id,并非阿里云的topicId
//            datavKeywords.setTopicId(topicId);
//            datavKeywords.setSiteTypeIds(siteTypeIds);
//            datavKeywords.setCreateTime(new Date());
//            datavKeywords.setModifyTime(new Date());
//            tblDatavKeywordsMapper.insert(datavKeywords);
//        }
//
//        TblDatavKeywordsExample example = new TblDatavKeywordsExample();
//        example.createCriteria().andTopicIdEqualTo(topicId).andKeywordIdIsNull();
//
//        List<TblDatavKeywords> keywordsList = tblDatavKeywordsMapper.selectByExample(example);
//        for(TblDatavKeywords keywords:keywordsList) {
//            KeywordTask.BI(keywords);
//        }

        /*
         * STEP 1
         * 判断关键词有没有超标
         */
        TblDatavTopics tblDatavTopics = tblDatavTopicsMapper.selectByPrimaryKey(topicId);
        int allKeywordsCount = countAll(tblDatavTopics.getInstanceId());
        TblIsvInstances instances = tblIsvInstancesMapper.selectByPrimaryKey(tblDatavTopics.getInstanceId());
        Integer keywordLimit = instances.getKeywordLimit();
        if(allKeywordsCount+list.size() > keywordLimit)
        {
            errorMsg.setSuccess("false");
            errorMsg.setMessage("添加关键字已达上限,每个用户最多可添加"+keywordLimit+"个关键字");
            return errorMsg;
        }

        Map<String,Object> param = new HashMap<String, Object>();
        param.put("topicId",Integer.parseInt(tblDatavTopics.getTopicId()));
        param.put("keywords", list);
        param.put("siteTypeIds",typeList);
        String paramBody = JSON.toJSONString(param);

        String result = AESDecode.sendPost(Constants.URL+"createKeyword",paramBody, Constants.AK_ID, Constants.AK_SECRET);
        logger.info(result);
        JSONObject object = JSON.parseObject(result);
        if(object.getBoolean("success")) {
            JSONArray resultArray = object.getJSONArray("result");
            /*
             * STEP 2
             */
            for(int i = 0;i<list.size();i++)
            {
                TblDatavKeywords datavKeywords = new TblDatavKeywords();
                datavKeywords.setKeyword(list.get(i));
                //此处的topicId为自身系统内的topic的id,并非阿里云的topicId
                datavKeywords.setTopicId(topicId);
                datavKeywords.setKeywordId(resultArray.getInteger(i));
                datavKeywords.setSiteTypeIds(siteTypeIds);
                datavKeywords.setStatus(1);
                datavKeywords.setCreateTime(new Date());
                datavKeywords.setModifyTime(new Date());
                tblDatavKeywordsMapper.insert(datavKeywords);
            }


            errorMsg.setSuccess("true");
            return errorMsg;
        }
        else{
            errorMsg.setMessage("添加关键字失败,请稍后再试!");
            errorMsg.setSuccess("false");
            return errorMsg;
        }
    }

    @Override
    public List<TblDatavKeywords> queryKeywords(Integer topicId,int pageNum,int pageSize) {

        PageHelper.startPage(pageNum,pageSize);
        TblDatavKeywordsExample datavKeywordsExample = new TblDatavKeywordsExample();
        datavKeywordsExample.createCriteria().andTopicIdEqualTo(topicId).andStatusEqualTo(1);
        List<TblDatavKeywords> list = tblDatavKeywordsMapper.selectByExample(datavKeywordsExample);
        if(null == list)
        {
            list = new ArrayList<TblDatavKeywords>();
        }
        return list;
    }

    @Override
    public ErrorMsg deleteKeyword(String ids) {
        ErrorMsg errorMsg = new ErrorMsg();
        /*
         * STEP 1:根据传入的ID,解析得到关键字列表,得到数加平台的ID列表
         */
        List<Integer> array = JSON.parseArray(ids,Integer.class);
        TblDatavKeywordsExample datavKeywordsExample = new TblDatavKeywordsExample();
        datavKeywordsExample.createCriteria().andIdIn(array);
        List<TblDatavKeywords> datavKeywords = tblDatavKeywordsMapper.selectByExample(datavKeywordsExample);
        //查无数据,返回
        if(datavKeywords.isEmpty())
        {
            errorMsg.setSuccess("false");
            errorMsg.setMessage("未查到此关键字!");
            return errorMsg;
        }

        List<Integer> idList = new ArrayList<Integer>();
        for(TblDatavKeywords tblDatavKeywords:datavKeywords)
        {
            idList.add(tblDatavKeywords.getKeywordId());
        }

        /*
         * STEP 2:组装请求参数
         */
        Map<String,Object> param = new HashMap<String, Object>();
        param.put("ids",idList);
        String paramBody = JSON.toJSONString(param);
        String result = AESDecode.sendPost(Constants.URL+"deleteKeyword",paramBody, Constants.AK_ID, Constants.AK_SECRET);
        logger.info(result);
        JSONObject object = JSON.parseObject(result);

        /*
         * STEP 3:同步更新数据库里的数据
         */
        if(object.getBoolean("success")) {

            for(TblDatavKeywords keywords:datavKeywords)
            {
                keywords.setStatus(0);
                tblDatavKeywordsMapper.updateByPrimaryKey(keywords);
            }
            errorMsg.setSuccess("true");
            errorMsg.setMessage("删除成功");
            errorMsg.setResult(ids);
            return errorMsg;
        }
        else
        {
            errorMsg.setSuccess("false");
            return errorMsg;
        }

    }

    @Override
    public ErrorMsg updateKeyword(String keyword, Integer id, String siteTypeIds) {
        ErrorMsg errorMsg = new ErrorMsg();

        List<Integer> typeList = JSON.parseArray(siteTypeIds,Integer.class);

        TblDatavKeywords datavKeywords = tblDatavKeywordsMapper.selectByPrimaryKey(id);



        Map<String,Object> param = new HashMap<String, Object>();
        param.put("keyword",keyword);
        param.put("siteTypeIds",typeList);
        param.put("id",datavKeywords.getKeywordId());
        param.put("topicId",datavKeywords.getTopicId());
        String paramBody = JSON.toJSONString(param);

        String result = AESDecode.sendPost(Constants.URL+"updateKeyword",paramBody, Constants.AK_ID, Constants.AK_SECRET);
        logger.info(result);
        JSONObject object = JSON.parseObject(result);
        if(object.getBoolean("success")) {
            datavKeywords.setKeyword(keyword);
            datavKeywords.setSiteTypeIds(siteTypeIds);
            datavKeywords.setModifyTime(new Date());
            tblDatavKeywordsMapper.updateByPrimaryKey(datavKeywords);
            errorMsg.setSuccess("true");
            return errorMsg;
        }
        else
        {
            errorMsg.setSuccess("false");
            return errorMsg;
        }
    }

    @Override
    public int count(Integer topicId) {
        TblDatavKeywordsExample tblDatavKeywordsExample = new TblDatavKeywordsExample();
        tblDatavKeywordsExample.createCriteria().andTopicIdEqualTo(topicId);
        return tblDatavKeywordsMapper.countByExample(tblDatavKeywordsExample);
    }

    @Override
    public int countAll(String instanceId) {
        TblDatavTopicsExample topicsExample = new TblDatavTopicsExample();
        topicsExample.createCriteria().andInstanceIdEqualTo(instanceId);
        List<TblDatavTopics> topicsList = tblDatavTopicsMapper.selectByExample(topicsExample);
        List<Integer> topicIds = new ArrayList<Integer>();
        for(TblDatavTopics topics:topicsList)
        {
            topicIds.add(topics.getId());
        }
        if(topicIds.isEmpty())
        {
            return 0;
        }
        TblDatavKeywordsExample example = new TblDatavKeywordsExample();
        example.createCriteria().andTopicIdIn(topicIds).andStatusEqualTo(1);

        return tblDatavKeywordsMapper.countByExample(example);
    }


    @Override
    public List<TblDatavKeywords> selectAll(String instanceId) {
        TblDatavTopicsExample topicsExample = new TblDatavTopicsExample();
        topicsExample.createCriteria().andInstanceIdEqualTo(instanceId);
        List<TblDatavTopics> topicsList = tblDatavTopicsMapper.selectByExample(topicsExample);
        List<Integer> topicIds = new ArrayList<Integer>();
        for(TblDatavTopics topics:topicsList)
        {
            topicIds.add(topics.getId());
        }
        if(topicIds.isEmpty())
        {
            return new ArrayList<TblDatavKeywords>();
        }
        TblDatavKeywordsExample example = new TblDatavKeywordsExample();
        example.createCriteria().andTopicIdIn(topicIds).andStatusEqualTo(1);

        return tblDatavKeywordsMapper.selectByExample(example);
    }

}
