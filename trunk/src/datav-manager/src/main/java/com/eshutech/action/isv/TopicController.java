/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: TopicController
 * Creator:  wanggao
 * Create-Date: 下午2:42
 **/
package com.eshutech.action.isv;

import com.eshutech.biz.entity.*;
import com.eshutech.biz.mapper.AliTopicMapper;
import com.eshutech.biz.mapper.TblDatavTopicsMapper;
import com.eshutech.biz.model.DataTablesModel;
import com.eshutech.biz.service.BrandPublicSentimentService;
import com.eshutech.biz.service.IsvInstanceService;
import com.eshutech.utils.BaseController;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import static java.lang.Thread.sleep;

/**
 *
 * @author: Kim
 * @date: 16/10/19
 * @time: 下午2:42
 *
 */
@Controller
@RequestMapping("/topic")
public class TopicController extends BaseController {

    @Resource
    TblDatavTopicsMapper tblDatavTopicsMapper;

    @Resource
    AliTopicMapper aliTopicMapper;

    @Resource
    IsvInstanceService isvInstanceService;

    @Resource
    BrandPublicSentimentService brandPublicSentimentService;
    /**
     * 专题列表
     * @param request
     * @param response
     * @param model
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public void list(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session)
    {
        Integer iDisplayStart = Integer.parseInt(request.getParameter("iDisplayStart"));
        Integer iDisplayLength = Integer.parseInt(request.getParameter("iDisplayLength"));


        TblDatavTopicsExample example = new TblDatavTopicsExample();
        if(null != request.getParameter("uid"))
        {
            Integer uid = Integer.parseInt(request.getParameter("uid"));
            TblIsvInstances instances = isvInstanceService.findByUserId(uid);
            example.createCriteria().andInstanceIdEqualTo(instances.getInstanceId());
        }
        if(null != request.getParameter("topicName"))
        {
            String topicName = request.getParameter("topicName");
            example.createCriteria().andTopicNameEqualTo(topicName);
        }

        PageHelper.startPage(iDisplayStart / iDisplayLength+1,iDisplayLength);
        List<TblDatavTopics> list = tblDatavTopicsMapper.selectByExample(example);
        int count = tblDatavTopicsMapper.countByExample(example);

        DataTablesModel dataTablesModel = new DataTablesModel();
        dataTablesModel.setITotalDisplayRecords(""+count);
        dataTablesModel.setITotalRecords(""+count);
        dataTablesModel.setAaData(list);

        try {
            echoJson(response,model,dataTablesModel);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * 专题列表
     * @param request
     * @param response
     * @param model
     */
    @RequestMapping(value = "/listAli",method = RequestMethod.GET)
    public void listAli(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session)
    {
        Integer iDisplayStart = Integer.parseInt(request.getParameter("iDisplayStart"));
        Integer iDisplayLength = Integer.parseInt(request.getParameter("iDisplayLength"));


        AliTopicExample example = new AliTopicExample();
        if(null != request.getParameter("topicName"))
        {
            String topicName = request.getParameter("topicName");
            example.createCriteria().andNameEqualTo(topicName);
        }
        if(null != request.getParameter("topicId"))
        {
            Integer topicId = Integer.parseInt(request.getParameter("topicId"));
            example.createCriteria().andIdEqualTo(topicId);
        }
        example.setOrderByClause(" status desc");
        PageHelper.startPage(iDisplayStart / iDisplayLength+1,iDisplayLength);
        List<AliTopic> list = aliTopicMapper.selectByExample(example);
        int count = aliTopicMapper.countByExample(example);

        DataTablesModel dataTablesModel = new DataTablesModel();
        dataTablesModel.setITotalDisplayRecords(""+count);
        dataTablesModel.setITotalRecords(""+count);
        dataTablesModel.setAaData(list);

        try {
            echoJson(response,model,dataTablesModel);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @RequestMapping(value = "/syncAliTopic",method = RequestMethod.POST)
    public void syncAliTopic(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session)
    {
        brandPublicSentimentService.queryTopicsList();

        try {
            echoJson(response,model,true);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping(value = "/syncAliKeyword",method = RequestMethod.POST)
    public void syncAliKeyword(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session)
    {

        if(null != request.getParameter("topicId")) {
            Integer topicId = Integer.parseInt(request.getParameter("topicId"));
            brandPublicSentimentService.getKeywords(topicId);
        }
        else
        {
            AliTopicExample example = new AliTopicExample();
            example.setOrderByClause(" status desc");
            List<AliTopic> topicList = aliTopicMapper.selectByExample(example);
            for(AliTopic topic:topicList)
            {
                brandPublicSentimentService.getKeywords(topic.getId());
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        try {
            echoJson(response,model,true);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 添加品牌专题,默认类型是0,关注品牌类型为1
     * @param request
     * @param response
     * @param model
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public void add(HttpServletRequest request, HttpServletResponse response, Model model,HttpSession session)
    {

    }

    /**
     * 更新品牌信息
     * @param request
     * @param response
     * @param model
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public void update(HttpServletRequest request, HttpServletResponse response, Model model)
    {

    }

    /**
     * 删除品牌
     * @param request
     * @param response
     * @param model
     */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public void delete(HttpServletRequest request, HttpServletResponse response, Model model)
    {

    }
}
