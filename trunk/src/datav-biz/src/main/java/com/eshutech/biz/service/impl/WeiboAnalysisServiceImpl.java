/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: WeiboAnalysisServiceImpl
 * Creator:  wanggao
 * Create-Date: 下午12:14
 **/
package com.eshutech.biz.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.eshutech.biz.constant.Constants;
import com.eshutech.biz.entity.TblWeiboAnalysis;
import com.eshutech.biz.entity.TblWeiboAnalysisExample;
import com.eshutech.biz.mapper.TblWeiboAnalysisMapper;
import com.eshutech.biz.model.ErrorMsg;
import com.eshutech.biz.service.WeiboAnalysisService;
import com.eshutech.biz.util.AESDecode;
import com.github.pagehelper.PageHelper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: Kim
 * @date: 16/10/19
 * @time: 下午12:14
 */
@Service
public class WeiboAnalysisServiceImpl implements WeiboAnalysisService {

    @Resource
    TblWeiboAnalysisMapper tblWeiboAnalysisMapper;

    private Logger logger = LoggerFactory.getLogger(WeiboAnalysisServiceImpl.class);

    @Override
    public ErrorMsg insertAnalysis(String instanceId, String weiboUrl) {
        ErrorMsg errorMsg = new ErrorMsg();

        /*
         * STEP 1:组装请求
         */
        Map<String, String> param = new HashMap<String, String>();
        param.put("url", weiboUrl);
        String paramBody = JSON.toJSONString(param);
        String result = AESDecode.sendPost(Constants.URL + "weiboAnalysis", paramBody, Constants.AK_ID, Constants.AK_SECRET);
        logger.info(result);
        /*
         * 解析返回,插入微博分析记录,初始状态只有分析Id,其他数据为待分析
         */
        JSONObject object = JSON.parseObject(result);
        if (null != object) {
            if (object.getBoolean("success") && null != object.get("result")) {

                TblWeiboAnalysis weiboAnalysis = new TblWeiboAnalysis();
                weiboAnalysis.setInstanceid(instanceId);
                weiboAnalysis.setWeiboUrl(weiboUrl);
                weiboAnalysis.setWeiboDesc("分析中...");
                weiboAnalysis.setWeiboUser("分析中...");
                weiboAnalysis.setWeiboCreateTime("");
                weiboAnalysis.setWeiboHeadImg("/img/noimage.png");
                weiboAnalysis.setAnalysisId(object.getString("result"));
                weiboAnalysis.setCreateTime(new Date());
                weiboAnalysis.setModifyTime(new Date());
                tblWeiboAnalysisMapper.insert(weiboAnalysis);

                errorMsg.setMessage("成功");
                errorMsg.setSuccess("true");
                errorMsg.setResult("");
            } else {
                errorMsg.setMessage(object.get("messages").toString());
                errorMsg.setSuccess("false");
                errorMsg.setResult("");
            }
        } else {
            errorMsg.setMessage(object.get("messages").toString());
            errorMsg.setSuccess("false");
            errorMsg.setResult("");
        }

        return errorMsg;
    }

    @Override
    public List<TblWeiboAnalysis> queryAnalysises(String instanceId, int pageNum, int pageSize) {

        PageHelper.startPage(pageNum, pageSize);

        TblWeiboAnalysisExample analysisExample = new TblWeiboAnalysisExample();
        analysisExample.createCriteria().andInstanceidEqualTo(instanceId);
        analysisExample.setOrderByClause("id desc");
        List<TblWeiboAnalysis> list = tblWeiboAnalysisMapper.selectByExample(analysisExample);
        return list;
    }

    @Override
    public ErrorMsg updateAnalysis(Integer id, Integer status) {
        ErrorMsg errorMsg = new ErrorMsg();
        TblWeiboAnalysis weiboAnalysis = tblWeiboAnalysisMapper.selectByPrimaryKey(id);
        if (null == weiboAnalysis) {
            errorMsg.setSuccess("false");
            errorMsg.setMessage("未查到相关信息");
            errorMsg.setResult("");
            return errorMsg;
        }
        weiboAnalysis.setShowStatus(status);
        //TODO:更新其他同实例的微博状态为0
        int result = tblWeiboAnalysisMapper.updateByPrimaryKey(weiboAnalysis);
        if (result != 0) {
            errorMsg.setSuccess("true");
            errorMsg.setMessage("更新成功");
            errorMsg.setResult("");
            TblWeiboAnalysisExample tblWeiboAnalysisExample = new TblWeiboAnalysisExample();
            tblWeiboAnalysisExample.createCriteria().andInstanceidEqualTo(weiboAnalysis.getInstanceid()).andShowStatusEqualTo(1).andIdNotEqualTo(weiboAnalysis.getId());
            List<TblWeiboAnalysis> tblWeiboAnalysises = tblWeiboAnalysisMapper.selectByExample(tblWeiboAnalysisExample);
            for (TblWeiboAnalysis tblWeiboAnalysis : tblWeiboAnalysises) {
                tblWeiboAnalysis.setShowStatus(0);
                tblWeiboAnalysisMapper.updateByPrimaryKey(tblWeiboAnalysis);
            }
        } else {
            errorMsg.setSuccess("false");
            errorMsg.setMessage("更新失败");
            errorMsg.setResult("");
        }
        return errorMsg;
    }

    @Override
    public ErrorMsg deleteAnalysis(Integer id) {
        ErrorMsg errorMsg = new ErrorMsg();
        int result = tblWeiboAnalysisMapper.deleteByPrimaryKey(id);
        if (result != 0) {
            errorMsg.setSuccess("true");
            errorMsg.setMessage("删除成功");
            errorMsg.setResult("");
        } else {
            errorMsg.setSuccess("false");
            errorMsg.setMessage("删除失败");
            errorMsg.setResult("");
        }
        return errorMsg;

    }

    @Override
    public ErrorMsg refreshAnalysis(Integer id) {
        ErrorMsg errorMsg = new ErrorMsg();

        TblWeiboAnalysis weiboAnalysis = tblWeiboAnalysisMapper.selectByPrimaryKey(id);
        Map<String, String> param = new HashMap<String, String>();
        param.put("url", weiboAnalysis.getWeiboUrl());
        String paramBody = JSON.toJSONString(param);
        String result = AESDecode.sendPost(Constants.URL + "weiboAnalysis", paramBody, Constants.AK_ID, Constants.AK_SECRET);
        logger.info(result);
        JSONObject object = JSON.parseObject(result);
        if (null != object) {
            if (object.getBoolean("success")) {
                errorMsg.setSuccess("true");
                errorMsg.setMessage(object.getString("message"));
                errorMsg.setResult("");
                weiboAnalysis.setAnalysisId(object.getString("result"));
                tblWeiboAnalysisMapper.updateByPrimaryKey(weiboAnalysis);
            } else {
                errorMsg.setSuccess("false");
                errorMsg.setMessage(object.getString("message"));
                errorMsg.setResult("");
            }
        } else {
            errorMsg.setSuccess("false");
            errorMsg.setMessage(result);
            errorMsg.setResult("");
        }
        return errorMsg;
    }

    @Override
    public int count(String instance) {
        TblWeiboAnalysisExample tblWeiboAnalysisExample = new TblWeiboAnalysisExample();
        tblWeiboAnalysisExample.createCriteria().andInstanceidEqualTo(instance);
        return tblWeiboAnalysisMapper.countByExample(tblWeiboAnalysisExample);
    }

    @Override
    public TblWeiboAnalysis queryAnalysisesById(String instanceId, String analysisId) {
        TblWeiboAnalysisExample tblWeiboAnalysisExample = new TblWeiboAnalysisExample();
        tblWeiboAnalysisExample.createCriteria().andInstanceidEqualTo(instanceId).andAnalysisIdEqualTo(analysisId);
        List<TblWeiboAnalysis> list = tblWeiboAnalysisMapper.selectByExample(tblWeiboAnalysisExample);
        if (!list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public Integer checkAnalysisCount(String instanceId, String url) {
        Integer result = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet(url);
        try {
            HttpResponse response = httpclient.execute(httpget);
            HttpEntity entity = response.getEntity();
            String html = EntityUtils.toString(entity);
            httpclient.close();
            Pattern p = Pattern.compile("(?<=转发\\[)(.+?)(?=\\])");
            Matcher m = p.matcher(html);
            while (m.find()) {
                try {
                    result = Integer.parseInt(m.group(0));
                }
                catch (Exception e)
                {
                    System.out.println(url);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
