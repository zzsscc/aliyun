/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: TopicController
 * Creator:  wanggao
 * Create-Date: 下午2:42
 **/
package com.eshutech.admin.action.isv;

import com.eshutech.biz.entity.TblDatavTopics;
import com.eshutech.biz.model.ErrorMsg;
import com.eshutech.biz.model.ListObject;
import com.eshutech.biz.service.DatavTopicsService;
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
 * @time: 下午2:42
 *
 */
@Controller
@RequestMapping("/topic")
public class TopicController extends BaseController {

    @Resource
    private DatavTopicsService datavTopicsService;

    @Resource
    private IsvInstanceService isvInstanceService;
    /**
     * 专题列表
     * @param request
     * @param response
     * @param model
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public void list(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session)
    {
        //TODO:分页查询
        Integer userId = (Integer) session.getAttribute("userId");
        String instanceId = isvInstanceService.findByUserId(userId).getInstanceId();
        List<TblDatavTopics> list = datavTopicsService.queryTopics(instanceId);

        int count = datavTopicsService.count(instanceId);

        ListObject listObject = new ListObject();
        listObject.setTotal(count);
        listObject.setList(list);

        try {
            //TODO:暂时不返回总数
            echoJson(response,model,list);
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
        String topicName = request.getParameter("topicName");
        Integer topicType = request.getParameter("topicType") == null ? 0 : Integer.parseInt(request.getParameter("topicType"));
        Integer topicStatus = request.getParameter("topicStatus") == null ? 0 : Integer.parseInt(request.getParameter("topicStatus"));

        Integer userId = (Integer) session.getAttribute("userId");
        String instanceId = isvInstanceService.findByUserId(userId).getInstanceId();
        ErrorMsg errorMsg = datavTopicsService.insertTopic(topicName,instanceId,topicStatus,topicType);
        try {
            echoJson(response,model,errorMsg);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        String topicName = request.getParameter("topicName");
        Integer id = Integer.parseInt(request.getParameter("id"));
        Integer topicStatus = Integer.parseInt(request.getParameter("topicStatus"));
        if(null == topicStatus)
        {
            topicStatus = 1;
        }
        datavTopicsService.updateTopic(id,topicName,topicStatus);
        try {
            echoJson(response,model,true);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        Integer id = Integer.parseInt(request.getParameter("id"));
        datavTopicsService.deleteTopic(id);
        try {
            echoJson(response,model,true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
