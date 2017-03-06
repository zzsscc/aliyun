/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: FrameController
 * Creator:  wanggao
 * Create-Date: 下午1:12
 **/
package com.eshutech.action.isv;

import com.eshutech.biz.entity.TblDatavKeywordsExample;
import com.eshutech.biz.entity.TblDatavTopicsExample;
import com.eshutech.biz.entity.TblSearchRecordExample;
import com.eshutech.biz.entity.TblWeiboAnalysisExample;
import com.eshutech.biz.mapper.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author: Kim
 * @date: 16/10/19
 * @time: 下午1:12
 *
 */
@Controller
public class ManagerController {

    @Resource
    TblDatavTopicsMapper tblDatavTopicsMapper;

    @Resource
    TblDatavKeywordsMapper tblDatavKeywordsMapper;

    @Resource
    TblIsvInstancesMapper tblIsvInstancesMapper;

    @Resource
    TblWeiboAnalysisMapper tblWeiboAnalysisMapper;

    @Resource
    TblSearchRecordMapper tblSearchRecordMapper;



    @RequestMapping(value="/manager/index",method = RequestMethod.GET)
    public String entry(Model model, HttpSession session)
    {
        int weiboNum = tblWeiboAnalysisMapper.countByExample(new TblWeiboAnalysisExample());
        model.addAttribute("topicNum",tblDatavTopicsMapper.countByExample(new TblDatavTopicsExample()));
        model.addAttribute("keywordNum",tblDatavKeywordsMapper.countByExample(new TblDatavKeywordsExample()));
        model.addAttribute("weiboNum",weiboNum);
        model.addAttribute("sentimentNum",tblSearchRecordMapper.countByExample(new TblSearchRecordExample()));
        model.addAttribute("weiboAnalysisNum",weiboNum);
        return "manager/index";
    }


    @RequestMapping(value="/manager/users",method = RequestMethod.GET)
    public String users(Model model, HttpSession session, HttpServletRequest request)
    {
        if(null != request.getParameter("username") && !request.getParameter("username").equals(""))
        {
            model.addAttribute("username",request.getParameter("username"));
        }
        if(null != request.getParameter("aliUid") && !request.getParameter("aliUid").equals(""))
        {
            model.addAttribute("aliUid",request.getParameter("aliUid"));
        }
        if(null != request.getParameter("mobile") && !request.getParameter("mobile").equals(""))
        {
            model.addAttribute("mobile",request.getParameter("mobile"));
        }
        return "manager/users";
    }

    @RequestMapping(value="/manager/topics",method = RequestMethod.GET)
    public String topics(Model model, HttpSession session, HttpServletRequest request)
    {
        if(null != request.getParameter("uid"))
        {
            model.addAttribute("uid",request.getParameter("uid"));
        }
        if(null != request.getParameter("topicName") && !request.getParameter("topicName").equals(""))
        {
            model.addAttribute("topicName",request.getParameter("topicName"));
        }
        return "manager/topics";
    }

    @RequestMapping(value="/manager/keywords",method = RequestMethod.GET)
    public String keywords(Model model, HttpSession session, HttpServletRequest request)
    {
        if(null != request.getParameter("topicId") && !request.getParameter("topicId").equals(""))
        {
            model.addAttribute("topicId",request.getParameter("topicId"));
        }
        if(null != request.getParameter("keyword") && !request.getParameter("keyword").equals(""))
        {
            model.addAttribute("keyword",request.getParameter("keyword"));
        }
        return "manager/keywords";
    }

    @RequestMapping(value="/manager/analysis",method = RequestMethod.GET)
    public String analysis(Model model, HttpSession session, HttpServletRequest request)
    {
        if(null != request.getParameter("username") && !request.getParameter("username").equals(""))
        {
            model.addAttribute("username",request.getParameter("username"));
        }
        return "manager/analysis";
    }

    @RequestMapping(value="/manager/aliTopic",method = RequestMethod.GET)
    public String aliTopic(Model model, HttpSession session, HttpServletRequest request)
    {
        if(null != request.getParameter("topicName") && !request.getParameter("topicName").equals(""))
        {
            model.addAttribute("topicName",request.getParameter("topicName"));
        }
        if(null != request.getParameter("topicId") && !request.getParameter("topicId").equals(""))
        {
            model.addAttribute("topicId",request.getParameter("topicId"));
        }
        return "manager/aliTopic";
    }

    @RequestMapping(value="/manager/aliKeyword",method = RequestMethod.GET)
    public String aliKeyword(Model model, HttpSession session, HttpServletRequest request)
    {
        if(null != request.getParameter("topicId") && !request.getParameter("topicId").equals(""))
        {
            model.addAttribute("topicId",request.getParameter("topicId"));
        }
        if(null != request.getParameter("keyword") && !request.getParameter("keyword").equals(""))
        {
            model.addAttribute("keyword",request.getParameter("keyword"));
        }
        return "manager/aliKeyword";
    }
}
