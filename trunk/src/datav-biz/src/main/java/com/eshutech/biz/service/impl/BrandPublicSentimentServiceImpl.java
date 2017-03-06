/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: BrandPublicSentimentServiceImpl
 * Creator:  wanggao
 * Create-Date: 下午8:12
 **/
package com.eshutech.biz.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.eshutech.biz.constant.Constants;
import com.eshutech.biz.entity.*;
import com.eshutech.biz.mapper.*;
import com.eshutech.biz.model.*;
import com.eshutech.biz.model.aliyun.*;
import com.eshutech.biz.service.BrandPublicSentimentService;
import com.eshutech.biz.util.AESDecode;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: Kim
 * @date: 16/10/19
 * @time: 下午8:12
 */
@Service
public class BrandPublicSentimentServiceImpl implements BrandPublicSentimentService {

    @Resource
    TblWeiboAnalysisMapper tblWeiboAnalysisMapper;

    @Resource
    TblWeiboAnalysisResultMapper tblWeiboAnalysisResultMapper;

    @Resource
    TblDatavTopicsMapper tblDatavTopicsMapper;

    @Resource
    AliTopicMapper  aliTopicMapper;

    @Resource
    AliKeywordMapper aliKeywordMapper;


    private Logger logger = LoggerFactory.getLogger(BrandPublicSentimentServiceImpl.class);


    @Override
    public String weiboAnalysisResult(String instanceId) {


        TblWeiboAnalysisExample weiboAnalysisExample = new TblWeiboAnalysisExample();
        weiboAnalysisExample.createCriteria().andInstanceidEqualTo(instanceId).andShowStatusEqualTo(1);
        List<TblWeiboAnalysis> list = tblWeiboAnalysisMapper.selectByExample(weiboAnalysisExample);
        if (null != list && !list.isEmpty()) {
            TblWeiboAnalysis tblWeiboAnalysis = list.get(0);
            return weiboAnalysisResultWithId(tblWeiboAnalysis.getAnalysisId());
        }
        return "";
    }

    @Override
    public String weiboAnalysisResultWithId(String analysisId) {
        /*
         * STEP1
         * 微博分析数据获取
         */

        String screenName = null;
        String avatarLarge = null;
        String content = null;
        String weiboCreateTime = null;
        Integer repostsCount = 0;
        String result = AESDecode.sendGet(Constants.URL + "getWeiboAnalysisResult?id=" + analysisId, Constants.AK_ID, Constants.AK_SECRET);

        /*
         * STEP2
         * graphData数据处理
         */
        logger.info(result);
        JSONObject object = JSON.parseObject(result);
        if (object.containsKey("success")) {
            if (object.getBooleanValue("success")) {
                if (object.containsKey("result")) {
                    JSONObject objectResult = object.getJSONObject("result");
                    /*
                     * 更新微博分析记录的图片,内容,标题等信息
                     */
                    JSONObject wInfo = objectResult.getJSONObject("wInfo");
                    if(null != wInfo) {
                        Long createdAt = wInfo.getLong("createdAt");
                        repostsCount = wInfo.getInteger("repostsCount");
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        weiboCreateTime = format.format(new Date(createdAt));


                        JSONObject uInfo = wInfo.getJSONObject("user");
                        if(null != uInfo)
                        {
                            screenName = uInfo.getString("name");
                            if (null != uInfo.getString("avatarLarge"))
                            {
                                avatarLarge = uInfo.getString("avatarLarge");
                            }
                            else
                            {
                                avatarLarge = uInfo.getString("profileImageUrl");
                            }
                        }
                    }
                    content = objectResult.getString("content");

                    if (null != objectResult.get("data")) {
                        if (objectResult.containsKey("graphData")) {
                            String graphData = objectResult.getString("graphData");
                            try {
                            /*
                             * STEP2-1
                             * 解析graphData数据
                             */
                                if (null != graphData && !graphData.equals("null")) {


                                    Document document = DocumentHelper.parseText(graphData);
                                    Element root = document.getRootElement();

                                    Element nodes = root.element("graph").element("nodes");
                                    Element edges = root.element("graph").element("edges");

                                    List<Element> nodeList = nodes.elements("node");
                                    List<Element> edgeList = edges.elements("edge");
                            /*
                             * STEP2-2
                             * 转换NODE信息
                             */
                                    List<GraphNode> graphNodes = new ArrayList<GraphNode>();
                                    for (Element node : nodeList) {
                                        GraphNode nodeModel = new GraphNode();
                                        nodeModel.setId(node.attributeValue("id"));
                                        nodeModel.setLabel(node.attributeValue("label"));
                                        nodeModel.setViz_size(node.element("size").attributeValue("value"));
                                        nodeModel.setViz_color(node.element("color").attributeValue("r") + "," + node.element("color").attributeValue("g") + "," + node.element("color").attributeValue("b"));
                                        nodeModel.setViz_position_x(node.element("position").attributeValue("x"));
                                        nodeModel.setViz_position_y(node.element("position").attributeValue("y"));
                                        nodeModel.setViz_position_z(node.element("position").attributeValue("z"));
                                        graphNodes.add(nodeModel);
                                    }
                            /*
                             * STEP2-3
                             * 转换EDGE信息
                             */
                                    List<GraphEdge> graphEdges = new ArrayList<GraphEdge>();
                                    for (Element edge : edgeList) {
                                        GraphEdge graphEdge = new GraphEdge();
                                        graphEdge.setId(edge.attributeValue("id"));
                                        graphEdge.setSource(edge.attributeValue("source"));
                                        graphEdge.setTarget(edge.attributeValue("target"));

                                        graphEdges.add(graphEdge);
                                    }
                            /*
                             * STEP2-4
                             * 序列化
                             */
                                    String jsonGraphNodes = JSON.toJSONString(graphNodes);
                                    String jsonGraphEdges = JSON.toJSONString(graphEdges);
                            /*
                             * STEP2-5
                             * 删除graphData节点,新增graphNodes和graphEdges
                             */
                                    objectResult.remove("graphData");
                                    objectResult.put("graphNodes", jsonGraphNodes);
                                    objectResult.put("graphEdges", jsonGraphEdges);
                                }

                                result = JSON.toJSONString(object);
                            } catch (Exception e) {
                                e.printStackTrace();
                                logger.error(e.getMessage());
//                                return "";
                            }
                        }
                    }
                }
            }
        }
        /*
         * STEP 4:更新微博分析结果状态
         */
        TblWeiboAnalysisExample tblWeiboAnalysisExample = new TblWeiboAnalysisExample();
        tblWeiboAnalysisExample.createCriteria().andAnalysisIdEqualTo(analysisId);
        List<TblWeiboAnalysis> analysisList = tblWeiboAnalysisMapper.selectByExample(tblWeiboAnalysisExample);

        for (TblWeiboAnalysis analysis : analysisList) {
            analysis.setAnalysisResultId(analysisId);
            analysis.setModifyTime(new Date());
            if (null != screenName) {
                analysis.setWeiboUser(screenName);
            }
            if (null != content) {
                analysis.setWeiboDesc(content);
            }
            if (null != avatarLarge) {
                analysis.setWeiboHeadImg(avatarLarge);
            }
            if (null != weiboCreateTime) {
                analysis.setWeiboCreateTime(weiboCreateTime);
            }
            if (null != repostsCount) {
                analysis.setRepostsCount(repostsCount);
            }

            tblWeiboAnalysisMapper.updateByPrimaryKey(analysis);
        }
        return result;
    }

    @Override
    public String queryReportNumber(String keyWordTopicId, String time, String timeType) {
        StringBuilder param = new StringBuilder();
        param.append("?");
        if (null != keyWordTopicId && !keyWordTopicId.equals("")) {
            param.append("keyWordTopicId=").append(keyWordTopicId).append("&");
        }
        if (null != time && !time.equals("")) {
            param.append("time=").append(time).append("&");
        }
        if (null != timeType && !timeType.equals("")) {
            param.append("timeType=").append(timeType);
        }

        String result = AESDecode.sendGet(Constants.URL + "queryReportNumber" + param.toString(), Constants.AK_ID, Constants.AK_SECRET);
        logger.info(result);
        return result;
    }


    @Override
    public String queryReportEmotion(String keyWordTopicId, String time, String timeType) {
        StringBuilder param = new StringBuilder();
        param.append("?");
        if (null != keyWordTopicId && !keyWordTopicId.equals("")) {
            param.append("keyWordTopicId=").append(keyWordTopicId).append("&");
        }
        if (null != time && !time.equals("")) {
            param.append("time=").append(time).append("&");
        }
        if (null != timeType && !timeType.equals("")) {
            param.append("timeType=").append(timeType);
        }

        String result = AESDecode.sendGet(Constants.URL + "queryReportEmotion" + param.toString(), Constants.AK_ID, Constants.AK_SECRET);
        logger.info(result);
        return result;
    }

    @Override
    public String queryReportHotWord(String keyWordTopicId, String time, String timeType) {
        StringBuilder param = new StringBuilder();
        param.append("?");
        if (null != keyWordTopicId && !keyWordTopicId.equals("")) {
            param.append("keyWordTopicId=").append(keyWordTopicId).append("&");
        }
        if (null != time && !time.equals("")) {
            param.append("time=").append(time).append("&");
        }
        if (null != timeType && !timeType.equals("")) {
            param.append("timeType=").append(timeType);
        }

        String result = AESDecode.sendGet(Constants.URL + "queryReportHotWord" + param.toString(), Constants.AK_ID, Constants.AK_SECRET);
        logger.info(result);
        return result;
    }

    @Override
    public String queryReportHotEvent(String keyWordTopicId, String time, String timeType) {
        StringBuilder param = new StringBuilder();
        param.append("?");
        if (null != keyWordTopicId && !keyWordTopicId.equals("")) {
            param.append("keyWordTopicId=").append(keyWordTopicId).append("&");
        }
        if (null != time && !time.equals("")) {
            param.append("time=").append(time).append("&");
        }
        if (null != timeType && !timeType.equals("")) {
            param.append("timeType=").append(timeType);
        }

        String result = AESDecode.sendGet(Constants.URL + "queryReportHotEvent" + param.toString(), Constants.AK_ID, Constants.AK_SECRET);
        logger.info(result);
        return result;
    }

    @Override
    public String queryReportTopic(String keyWordTopicId, String time, String timeType) {
        StringBuilder param = new StringBuilder();
        param.append("?");
        if (null != keyWordTopicId && !keyWordTopicId.equals("")) {
            param.append("keyWordTopicId=").append(keyWordTopicId).append("&");
        }
        if (null != time && !time.equals("")) {
            param.append("time=").append(time).append("&");
        }
        if (null != timeType && !timeType.equals("")) {
            param.append("timeType=").append(timeType);
        }

        String result = AESDecode.sendGet(Constants.URL + "queryReportTopic" + param.toString(), Constants.AK_ID, Constants.AK_SECRET);
        logger.info(result);
        return result;
    }

    @Override
    public String queryReportKeyWord(String keyWordTopicId, String time, String timeType) {
        StringBuilder param = new StringBuilder();
        param.append("?");
        if (null != keyWordTopicId && !keyWordTopicId.equals("")) {
            param.append("keyWordTopicId=").append(keyWordTopicId).append("&");
        }
        if (null != time && !time.equals("")) {
            param.append("time=").append(time).append("&");
        }
        if (null != timeType && !timeType.equals("")) {
            param.append("timeType=").append(timeType);
        }

        String result = AESDecode.sendGet(Constants.URL + "queryReportKeyWord" + param.toString(), Constants.AK_ID, Constants.AK_SECRET);
        logger.info(result);
        return result;
    }

    @Override
    public String queryReportTagAnalysis(String keyWordTopicId, String time, String timeType) {
        StringBuilder param = new StringBuilder();
        param.append("?");
        if (null != keyWordTopicId && !keyWordTopicId.equals("")) {
            param.append("keyWordTopicId=").append(keyWordTopicId).append("&");
        }
        if (null != time && !time.equals("")) {
            param.append("time=").append(time).append("&");
        }
        if (null != timeType && !timeType.equals("")) {
            param.append("timeType=").append(timeType);
        }

        String result = AESDecode.sendGet(Constants.URL + "queryReportTagAnalysis" + param.toString(), Constants.AK_ID, Constants.AK_SECRET);
        logger.info(result);
        return result;
    }

    @Override
    public String queryReportNumberTrend(String keyWordTopicId, String time, String timeType) {
        StringBuilder param = new StringBuilder();
        param.append("?");
        if (null != keyWordTopicId && !keyWordTopicId.equals("")) {
            param.append("keyWordTopicId=").append(keyWordTopicId).append("&");
        }
        if (null != time && !time.equals("")) {
            param.append("time=").append(time).append("&");
        }
        if (null != timeType && !timeType.equals("")) {
            param.append("timeType=").append(timeType);
        }

        String result = AESDecode.sendGet(Constants.URL + "queryReportNumberTrend" + param.toString(), Constants.AK_ID, Constants.AK_SECRET);
        logger.info(result);
        return result;
    }

    @Override
    public String queryReportEmotionTrend(String keyWordTopicId, String time, String timeType) {
        StringBuilder param = new StringBuilder();
        param.append("?");
        if (null != keyWordTopicId && !keyWordTopicId.equals("")) {
            param.append("keyWordTopicId=").append(keyWordTopicId).append("&");
        }
        if (null != time && !time.equals("")) {
            param.append("time=").append(time).append("&");
        }
        if (null != timeType && !timeType.equals("")) {
            param.append("timeType=").append(timeType);
        }

        String result = AESDecode.sendGet(Constants.URL + "queryReportEmotionTrend" + param.toString(), Constants.AK_ID, Constants.AK_SECRET);
        logger.info(result);
        return result;
    }

    /**
     * 获取舆论信息
     *
     * @param instanceId
     * @param param
     * @return
     */
    @Override
    public String search(String instanceId, BrandSentimentParam param) {
        String result;
        /*
         * STEP 1:根据实例ID,获取专题ID
         */
        TblDatavTopicsExample tblDatavTopicsExample = new TblDatavTopicsExample();
        tblDatavTopicsExample.createCriteria().andInstanceIdEqualTo(instanceId).andTopicTypeEqualTo(0);
        List<TblDatavTopics> tblDatavTopicsList = tblDatavTopicsMapper.selectByExample(tblDatavTopicsExample);
        if (tblDatavTopicsList.isEmpty()) {
            ErrorMsg errorMsg = new ErrorMsg();
            errorMsg.setSuccess("false");
            errorMsg.setMessage("未查询到相关信息");
            errorMsg.setResult("");
            result = JSON.toJSONString(errorMsg);
            return result;
        }
        /*
         * STEP 2:必须设置topicId,请求舆情
         */
        TblDatavTopics tblDatavTopics = tblDatavTopicsList.get(0);
        if (null == tblDatavTopics.getTopicId()) {
            ErrorMsg errorMsg = new ErrorMsg();
            errorMsg.setSuccess("false");
            errorMsg.setMessage("未查询到相关信息");
            errorMsg.setResult("");
            result = JSON.toJSONString(errorMsg);
            return result;
        }
        param.setMonitorTopicId(tblDatavTopics.getTopicId());
        result = AESDecode.sendGet(Constants.URL + "search" + param.paramsToString(), Constants.AK_ID, Constants.AK_SECRET);
        logger.info(param.paramsToString());
        logger.info(result);
        return result;
    }

    @Override
    public void queryTopicsList()
    {
        String result = AESDecode.sendGet(Constants.URL + "queryTopicsList", Constants.AK_ID, Constants.AK_SECRET);
        logger.info(result);

        TopicResponse object = JSON.parseObject(result,TopicResponse.class);
        if(object.getSuccess())
        {
            List<AliTopic> topicList = object.getResult();
            if(null != topicList)
            {
                for(AliTopic topic:topicList)
                {
                    try
                    {
                        aliTopicMapper.insert(topic);
                    }
                    catch (Exception e)
                    {
                        aliTopicMapper.updateByPrimaryKey(topic);
                    }
                }
            }
        }
    }

    @Override
    public void getKeywords(Integer topicId)
    {
        String result = AESDecode.sendGet(Constants.URL + "getKeywords?topicId="+topicId, Constants.AK_ID, Constants.AK_SECRET);
        logger.info(result);
        try {
            KeywordResponse object = JSON.parseObject(result, KeywordResponse.class);
            if (object.getSuccess()) {
                List<AliKeyword> keywordList = object.getResult();
                if (null != keywordList) {
                    for (AliKeyword keyword : keywordList) {
                        try {
                            aliKeywordMapper.insert(keyword);
                        } catch (Exception e) {
                            aliKeywordMapper.updateByPrimaryKey(keyword);
                        }
                    }
                }
            }
        }
        catch (Exception e)
        {
            logger.info(ExceptionUtils.getStackTrace(e));
        }
    }

}
