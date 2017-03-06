/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: FrameController
 * Creator:  wanggao
 * Create-Date: 下午1:12
 **/
package com.eshutech.admin.action.isv;

import com.eshutech.biz.entity.TblIsvInstances;
import com.eshutech.biz.mapper.TblInstanceProfileMapper;
import com.eshutech.biz.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
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
    DatavTopicsService datavTopicsService;

    @Resource
    DatavKeywordsService datavKeywordsService;

    @Resource
    IsvInstanceService isvInstanceService;

    @Resource
    SystemCodeService systemCodeService;

    @Resource
    WeiboAnalysisService weiboAnalysisService;

    @Resource
    InstanceProfileService instanceProfileService;

    @Resource
    TblInstanceProfileMapper tblInstanceProfileMapper;

    /**
     * 设置页面跳转
     * @param name
     * @return
     */
    @RequestMapping(value="/manager/{name}",method = RequestMethod.GET)
    public String frame(@PathVariable String name, Model model, HttpSession session)
    {



        if (name.equals("index"))
        {
            Integer userId = (Integer) session.getAttribute("userId");
            TblIsvInstances instances = isvInstanceService.findByUserId(userId);
            String instanceId = instances.getInstanceId();
            model.addAttribute("topicNum",datavTopicsService.count(instanceId));
            model.addAttribute("keywordNum",datavKeywordsService.countAll(instanceId));
            model.addAttribute("weiboNum",weiboAnalysisService.count(instanceId));

            model.addAttribute("topicTotal",instances.getTopicLimit());
            model.addAttribute("keywordTotal",instances.getKeywordLimit());
            model.addAttribute("sentimentTotal",instances.getSentimentLimit());
            model.addAttribute("weiboAnalysisTotal",instances.getWeiboAnalysis());

            model.addAttribute("sentimentNum",instanceProfileService.getSentimentCount(instanceId));
            model.addAttribute("weiboAnalysisNum",instanceProfileService.getWeiboAnalysisCount(instanceId));

        }

        return "manager/"+name;
    }
}
