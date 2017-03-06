/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: TestController
 * Creator:  wanggao
 * Create-Date: 下午8:02
 **/
package com.eshutech.admin.action.authority;

import com.eshutech.biz.cache.rediscache.IRedisCacheService;
import com.eshutech.biz.entity.*;
import com.eshutech.biz.mapper.*;
import com.eshutech.biz.model.aliyun.BrandSentimentParam;
import com.eshutech.biz.model.aliyun.SearchResponse;
import com.eshutech.biz.service.InstanceProfileService;
import com.eshutech.biz.service.SearchService;
import com.eshutech.biz.service.WeiboAnalysisService;
import com.eshutech.biz.task.TopicTask;
import com.eshutech.utils.BaseController;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Thread.sleep;

/**
 *
 * @author: Kim
 * @date: 16/11/3
 * @time: 下午8:02
 *
 */
@Controller
public class TestController extends BaseController {

    @Autowired
    IRedisCacheService   redisCacheService;

    @Autowired
    TblSearchRecordMapper tblSearchRecordMapper;

    @Autowired
    TblIsvInstancesMapper tblIsvInstancesMapper;

    @Autowired
    TblInstanceProfileMapper tblInstanceProfileMapper;

    @Resource
    SearchService searchService;

    @Resource
    TblDatavTopicsMapper tblDatavTopicsMapper;

    @Resource
    TblWeiboAnalysisMapper tblWeiboAnalysisMapper;

    @Resource
    WeiboAnalysisService weiboAnalysisService;
    @Resource
    InstanceProfileService instanceProfileService;


    @RequestMapping(value = "/test/insert_sentiment")
    public void testInsertSentiment(HttpServletResponse response, Model model) throws IOException {

        TblSearchRecord searchRecord = new TblSearchRecord();
        searchRecord.setMonitorKeywords("Test");

        redisCacheService.addSentiment("0602f7ca2773424d910d042e410bd74f",searchRecord);
        echoJson(response,model,true);
    }

    @RequestMapping(value = "/test/get_sentiment")
    public void testGetSentiment(HttpServletResponse response, Model model) throws IOException {
        List<TblSearchRecord> result = redisCacheService.getSentiment("0602f7ca2773424d910d042e410bd74f",20,1);
        echoJson(response,model,result);
    }

    @RequestMapping(value = "/test/get_sentiment_count")
    public void testGetSentimentCount(HttpServletResponse response, Model model) throws IOException {
        Long result = redisCacheService.getSentimentCount("0602f7ca2773424d910d042e410bd74f");
        echoJson(response,model,result);
    }

    @RequestMapping(value = "/test/insertProfie")
    public void insertProfile(HttpServletResponse response, Model model) throws IOException {
        Long result = 0L;

        List<TblIsvInstances> instancesList = tblIsvInstancesMapper.selectByExample(new TblIsvInstancesExample());
        for(TblIsvInstances instances:instancesList)
        {
            TblInstanceProfile instanceProfile = new TblInstanceProfile();
            instanceProfile.setInstanceId(instances.getInstanceId());
            instanceProfile.setCreateTime(new Date());
            instanceProfile.setModifyTime(new Date());
            instanceProfile.setSentimentCount(0);
            instanceProfile.setWeiboAnalysisCount(0);
            tblInstanceProfileMapper.insert(instanceProfile);
        }

        echoJson(response,model,result);
    }

    @RequestMapping(value = "/test/updateSentimentCount")
    public void updateSentimentCount(HttpServletResponse response, Model model) throws IOException {
        Long result = 0L;
        //
        List<TblIsvInstances> instancesList = tblIsvInstancesMapper.selectByExample(new TblIsvInstancesExample());
        for(TblIsvInstances instances:instancesList)
        {
            BrandSentimentParam param = new BrandSentimentParam();
            param.setToPage("1");
            param.setPageSize("1");
            SearchResponse searchResponse = searchService.searchByInstanceId(instances.getInstanceId(),param);
            TblInstanceProfileExample example = new TblInstanceProfileExample();
            example.createCriteria().andInstanceIdEqualTo(instances.getInstanceId());
            List<TblInstanceProfile> profileList = tblInstanceProfileMapper.selectByExample(example);
            if(!profileList.isEmpty()) {
                TblInstanceProfile instanceProfile = profileList.get(0);
                instanceProfile.setInstanceId(instances.getInstanceId());
                instanceProfile.setModifyTime(new Date());
                instanceProfile.setSentimentCount(searchResponse.getTotalCount());
                tblInstanceProfileMapper.updateByPrimaryKey(instanceProfile);

                if(searchResponse.getTotalCount() > 20000) {
                    TblDatavTopicsExample topicsExample = new TblDatavTopicsExample();
                    topicsExample.createCriteria().andInstanceIdEqualTo(instances.getInstanceId());
                    List<TblDatavTopics> topicsList = tblDatavTopicsMapper.selectByExample(topicsExample);
                    for (TblDatavTopics topics : topicsList) {
                        topics.setTopicStatus(0);
                        TopicTask.BI(topics);
                    }
                }
            }
        }

        echoJson(response,model,result);
    }

    @RequestMapping(value = "/test/enableSentiment")
    public void enableSentiment(HttpServletResponse response, Model model, HttpServletRequest request) throws IOException {
        String instanceId = request.getParameter("id");
        TblDatavTopicsExample topicsExample = new TblDatavTopicsExample();
        topicsExample.createCriteria().andInstanceIdEqualTo(instanceId);
        List<TblDatavTopics> topicsList = tblDatavTopicsMapper.selectByExample(topicsExample);
        for (TblDatavTopics topics : topicsList) {
            topics.setTopicStatus(1);
            TopicTask.BI(topics);
        }
        echoJson(response,model,1);
    }

    @RequestMapping(value = "/test/updateWeiboAnlaysisCount")
    public void updateWeiboAnlaysisCount(HttpServletResponse response, Model model, HttpServletRequest request) throws IOException {
//        WeiboSyncThread weiboSyncThread = new WeiboSyncThread();
//        weiboSyncThread.run();
        List<TblWeiboAnalysis> weiboAnalysisList = tblWeiboAnalysisMapper.selectByExample(new TblWeiboAnalysisExample());
        for(TblWeiboAnalysis weiboAnalysis:weiboAnalysisList)
        {
            String weiboUrl = weiboAnalysis.getWeiboUrl();
            weiboUrl = weiboUrl.replace("weibo.com","weibo.cn");
            Integer result = weiboAnalysisService.checkAnalysisCount("",weiboUrl);
            String instanceId = weiboAnalysis.getInstanceid();
            Integer currentCount = instanceProfileService.getWeiboAnalysisCount(instanceId);
            if(null != currentCount && null != result) {
                instanceProfileService.updateWeiboAnalysisCount(instanceId, result + currentCount);
            }
            else
            {
                System.out.println(instanceId+":"+weiboUrl);
            }

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        echoJson(response,model,1);
    }


    @RequestMapping(value = "/test/getCommentCount")
    public void getCommentCount(HttpServletRequest request,HttpServletResponse servletResponse,Model model) throws IOException {
        String url = request.getParameter("url");
        Integer result = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet(url);
        try {
//            httpget.addHeader(new BasicHeader("Cookie","_T_WM=7063af2c00065ef8f75996b52a9f3608;"));
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
        echo(servletResponse,model,""+result);
    }
}
