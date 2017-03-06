/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: FrontController
 * Creator:  wanggao
 * Create-Date: 下午8:37
 **/
package com.eshutech.admin.action.isv;

import com.alibaba.fastjson.JSON;
import com.eshutech.biz.entity.TblDatavTopics;
import com.eshutech.biz.entity.TblWeiboAnalysis;
import com.eshutech.biz.model.aliyun.BrandSentimentParam;
import com.eshutech.biz.model.aliyun.SearchResponse;
import com.eshutech.biz.service.*;
import com.eshutech.utils.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author: Kim
 * @date: 16/10/19
 * @time: 下午8:37
 *
 */
@Controller
@RequestMapping("/front")
public class FrontController extends BaseController {
    @Resource
    BrandPublicSentimentService brandPublicSentimentService;

    @Resource
    IsvInstanceService isvInstanceService;

    @Resource
    DatavTopicsService datavTopicsService;

    @Resource
    SearchService searchService;

    @Resource
    WeiboAnalysisService weiboAnalysisService;

    @Resource
    WeiboAnalysisResultService weiboAnalysisResultService;



    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    /**
     * 大屏页面
     * @param name
     * @return
     */
    @RequestMapping(value="/screen/{name}",method = RequestMethod.GET)
    public String forwardPage(@PathVariable String name,HttpSession session,Model model)
    {
        Integer userId = (Integer) session.getAttribute("userId");
        String instanceId = isvInstanceService.findByUserId(userId).getInstanceId();
        TblDatavTopics brandTopic  = datavTopicsService.queryBrandTopic(instanceId);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, -1);

        if(null == brandTopic)
        {
            model.addAttribute("topicId", 0);
            model.addAttribute("time", dateFormat.format(new Date()));
        }
        else {
            model.addAttribute("topicId", brandTopic.getTopicId());
            model.addAttribute("time", dateFormat.format(new Date()));
        }
        return "front/"+name;
    }

    /**
     * 获取微博分析结果
     * @param request
     * @param response
     * @param model
     * @param session
     */
    @RequestMapping(value = "/weiboAnalysisResult",method = RequestMethod.GET)
    public void weiboAnalysisResult(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session)
    {
        Integer userId = (Integer) session.getAttribute("userId");
        String instanceId = isvInstanceService.findByUserId(userId).getInstanceId();
        String result = brandPublicSentimentService.weiboAnalysisResult(instanceId);
        try {
            echo(response,model,result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取热门事件
     * @param request
     * @param response
     * @param model
     * @param session
     */
    @RequestMapping(value = "/queryReportHotEvent",method = RequestMethod.GET)
    public void queryReportHotEvent(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session)
    {
        String time = request.getParameter("time");
        String topicId = request.getParameter("topicId");
        String timeType = request.getParameter("timeType");
        String result = brandPublicSentimentService.queryReportHotEvent(topicId,time,timeType);
        try {
            echo(response,model,result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 情感分析
     * @param request
     * @param response
     * @param model
     * @param session
     */
    @RequestMapping(value = "/queryReportEmotion",method = RequestMethod.GET)
    public void queryReportEmotion(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session)
    {
        String time = request.getParameter("time");
        String topicId = request.getParameter("topicId");
        String timeType = request.getParameter("timeType");
        String result = brandPublicSentimentService.queryReportEmotion(topicId,time,timeType);
        try {
            echo(response,model,result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 情感趋势分析
     * @param request
     * @param response
     * @param model
     * @param session
     */
    @RequestMapping(value = "/queryReportEmotionTrend",method = RequestMethod.GET)
    public void queryReportEmotionTrend(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session)
    {
        String time = request.getParameter("time");
        String topicId = request.getParameter("topicId");
        String timeType = request.getParameter("timeType");
        String result = brandPublicSentimentService.queryReportEmotionTrend(topicId,time,timeType);
        try {
            echo(response,model,result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询某个专题下的舆情趋势
     * @param request
     * @param response
     * @param model
     * @param session
     */
    @RequestMapping(value = "/queryReportNumberTrend",method = RequestMethod.GET)
    public void queryReportNumberTrend(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session)
    {
        String time = request.getParameter("time");
        String topicId = request.getParameter("topicId");
        String timeType = request.getParameter("timeType");
        String result = brandPublicSentimentService.queryReportNumberTrend(topicId,time,timeType);
        try {
            echo(response,model,result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 分析每个专题下的舆情数量
     * @param request
     * @param response
     * @param model
     * @param session
     */
    @RequestMapping(value = "/queryReportTopic",method = RequestMethod.GET)
    public void queryReportTopic(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session)
    {
        String time = request.getParameter("time");
        String topicId = request.getParameter("topicId");
        String timeType = request.getParameter("timeType");
        String result = brandPublicSentimentService.queryReportTopic(topicId,time,timeType);
        try {
            echo(response,model,result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询某个时间点的不同源站下的舆情数量
     * @param request
     * @param response
     * @param model
     * @param session
     */
    @RequestMapping(value = "/queryReportNumber",method = RequestMethod.GET)
    public void queryReportNumber(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session)
    {
        String time = request.getParameter("time");
        String topicId = request.getParameter("topicId");
        String timeType = request.getParameter("timeType");
        String result = brandPublicSentimentService.queryReportNumber(topicId,time,timeType);
        try {
            echo(response,model,result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询热词云
     * @param request
     * @param response
     * @param model
     * @param session
     */
    @RequestMapping(value = "/queryReportHotWord",method = RequestMethod.GET)
    public void queryReportHotWord(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session)
    {
        String time = request.getParameter("time");
        String topicId = request.getParameter("topicId");
        String timeType = request.getParameter("timeType");
        String result = brandPublicSentimentService.queryReportHotWord(topicId,time,timeType);
        try {
            echo(response,model,result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 微博分析预览
     * @param request
     * @param response
     * @param model
     * @param session
     */
    @RequestMapping(value="/weiboAnalysisResult/preview",method = RequestMethod.GET)
    public void weiboAnalysisResultPreview(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) throws IOException {
        Integer userId = (Integer) session.getAttribute("userId");
        String instanceId = isvInstanceService.findByUserId(userId).getInstanceId();
        String id = request.getParameter("id");
        /*
         * STEP 1: 判断该实例是否有此分析id的微博
         */
        TblWeiboAnalysis weiboAnalysis = weiboAnalysisService.queryAnalysisesById(instanceId,id);
        if(null == weiboAnalysis)
        {
            echo(response,model,"查询的结果不存在");
            return;
        }
        /*
         * STEP 2:根据分析ID,获取微博信息
         */
        String result;
//        if(null == weiboAnalysis.getAnalysisResultId())
//        {
            result = brandPublicSentimentService.weiboAnalysisResultWithId(id);
//        }
//        else
//        {
//            TblWeiboAnalysisResult tblWeiboAnalysisResult = weiboAnalysisResultService.queryById(weiboAnalysis.getAnalysisResultId());
//            result = tblWeiboAnalysisResult.getAnalysisResult();
//        }


        echo(response,model,result);
    }

    /**
     *
     * @param request
     * @param response
     * @param model
     * @param param
     * @throws IOException
     */
    @RequestMapping(value = "/search",method = RequestMethod.GET)
    public void sentimentBox(HttpServletRequest request, HttpServletResponse response, Model model, @ModelAttribute BrandSentimentParam param,HttpSession session) throws IOException {
        Integer userId = (Integer) session.getAttribute("userId");
        String instanceId = isvInstanceService.findByUserId(userId).getInstanceId();

//
//        Integer pageSize = Integer.parseInt(param.getPageSize());
//        Integer toPage = Integer.parseInt(param.getToPage());
//        Integer totalCount = redisCacheService.getSentimentCount(instanceId).intValue();
//        Integer totalPage = (int) Math.ceil(totalCount/pageSize);
//
//        SearchResponse searchResponse = new SearchResponse();
//        searchResponse.setPageSize(pageSize);
//        searchResponse.setToPage(toPage);
//        searchResponse.setTotalCount(totalCount);
//        searchResponse.setTotalPages(totalPage);
//
//        SearchResult searchResult = new SearchResult();
//        searchResult.setRecords(redisCacheService.getSentiment(instanceId,pageSize,toPage));
//
//        searchResponse.setResult(searchResult);
//        searchResponse.setSuccess(true);

        SearchResponse searchResponse = searchService.searchByInstanceId(instanceId,param);

        String result = JSON.toJSONString(searchResponse);
//        String result = brandPublicSentimentService.search(instanceId,param);
        echoJson(response,model,result);
    }
}
