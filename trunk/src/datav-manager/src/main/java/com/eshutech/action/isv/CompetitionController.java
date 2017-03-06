/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: CompetitionController
 * Creator:  wanggao
 * Create-Date: 下午6:58
 **/
package com.eshutech.action.isv;

import com.eshutech.biz.entity.TblCompetitionInfo;
import com.eshutech.biz.service.CompetitionInfoService;
import com.eshutech.biz.service.IsvInstanceService;
import com.eshutech.utils.BaseController;
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

/**
 *
 * @author: Kim
 * @date: 16/10/19
 * @time: 下午6:58
 *
 */
@Controller
@RequestMapping("/competition")
public class CompetitionController extends BaseController{

    @Resource
    CompetitionInfoService competitionInfoService;

    @Resource
    IsvInstanceService isvInstanceService;
    /**
     * 获取竞品列表
     * @param request
     * @param response
     * @param model
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public void list(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session)
    {
        Integer userId = (Integer) session.getAttribute("userId");
        String instanceId = isvInstanceService.findByUserId(userId).getInstanceId();
        List<TblCompetitionInfo> list = competitionInfoService.queryCompetition(instanceId);

        try {
            echoJson(response,model,list);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 更新竞品信息:info为JSON字符串,格式为[{"topicId":5,"position":1,"imgUrl":"http://xx.com/xx.jpg","name":"gfd111"},{"topicId":6,"position":2,"imgUrl":"http://xx.com/xx.jpg","name":"gfd111"}]
     * @param request
     * @param response
     * @param model
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public void update(HttpServletRequest request, HttpServletResponse response, Model model,HttpSession session)
    {
        String info = request.getParameter("info");
        Integer userId = (Integer) session.getAttribute("userId");
        String instanceId = isvInstanceService.findByUserId(userId).getInstanceId();

        competitionInfoService.saveCompetition(instanceId,info);
        try {
            echoJson(response,model,true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
