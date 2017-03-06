/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: WeiboAnalysisController
 * Creator:  wanggao
 * Create-Date: 下午4:21
 **/
package com.eshutech.admin.action.isv;

import com.eshutech.biz.entity.TblIsvInstances;
import com.eshutech.biz.entity.TblWeiboAnalysis;
import com.eshutech.biz.model.ErrorMsg;
import com.eshutech.biz.model.ListObject;
import com.eshutech.biz.service.BrandPublicSentimentService;
import com.eshutech.biz.service.InstanceProfileService;
import com.eshutech.biz.service.IsvInstanceService;
import com.eshutech.biz.service.WeiboAnalysisService;
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
 * @time: 下午4:21
 *
 */
@Controller
@RequestMapping("/weiboAnalysis")
public class WeiboAnalysisController extends BaseController{

    @Resource
    WeiboAnalysisService weiboAnalysisService;

    @Resource
    IsvInstanceService isvInstanceService;

    @Resource
    BrandPublicSentimentService brandPublicSentimentService;

    @Resource
    InstanceProfileService instanceProfileService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public void list(HttpServletRequest request, HttpServletResponse response, Model model,HttpSession session)
    {
        Integer userId = (Integer) session.getAttribute("userId");

        int pageNum = request.getParameter("pageNum") == null ? 1 : Integer.parseInt(request.getParameter("pageNum"));
        int pageSize = request.getParameter("pageSize") == null ? 20 : Integer.parseInt(request.getParameter("pageSize"));

        String instanceId = isvInstanceService.findByUserId(userId).getInstanceId();
        List<TblWeiboAnalysis> list = weiboAnalysisService.queryAnalysises(instanceId,pageNum,pageSize);

        int count = weiboAnalysisService.count(instanceId);

        ListObject listObject = new ListObject();
        listObject.setTotal(count);
        listObject.setList(list);
        listObject.setPageNum(pageNum);
        listObject.setPageSize(pageSize);
        try {
            echoJson(response,model,listObject);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public void add(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) throws IOException {
        ErrorMsg errorMsg = new ErrorMsg();
        String weiboUrl = request.getParameter("weiboUrl");
        if(null == weiboUrl)
        {
            errorMsg.setSuccess("false");
            errorMsg.setMessage("缺少必要参数!");
            errorMsg.setResult("");
            echoJson(response,model,errorMsg);
            return;
        }

        Integer userId = (Integer) session.getAttribute("userId");
        String instanceId = isvInstanceService.findByUserId(userId).getInstanceId();
        errorMsg = weiboAnalysisService.insertAnalysis(instanceId,weiboUrl);
        weiboUrl = weiboUrl.replace("weibo.com","weibo.cn");
        Integer result = weiboAnalysisService.checkAnalysisCount("",weiboUrl);
        Integer currentCount = instanceProfileService.getWeiboAnalysisCount(instanceId);
        instanceProfileService.updateWeiboAnalysisCount(instanceId,result+currentCount);


        echoJson(response,model,errorMsg);
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public void update(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        ErrorMsg errorMsg = new ErrorMsg();
        Integer id = null;
        if(null != request.getParameter("id"))
        {
            id = Integer.parseInt(request.getParameter("id"));
        }
        if(null == id)
        {
            errorMsg.setSuccess("false");
            errorMsg.setMessage("缺少必要参数!");
            errorMsg.setResult("");
            echoJson(response,model,errorMsg);
            return;
        }
        Integer status = Integer.parseInt(request.getParameter("showStatus"));
        errorMsg = weiboAnalysisService.updateAnalysis(id,status);
        echoJson(response,model,errorMsg);
    }

    @RequestMapping(value = "/refreshAnalysis",method = RequestMethod.POST)
    public void refreshAnalysis(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        ErrorMsg errorMsg = new ErrorMsg();
        Integer id=null;
        //TODO:分析
        if(null != request.getParameter("id"))
        {
            id = Integer.parseInt(request.getParameter("id"));
        }
        if(null == id)
        {
            errorMsg.setSuccess("false");
            errorMsg.setMessage("缺少必要参数!");
            errorMsg.setResult("");
            echoJson(response,model,errorMsg);
            return;
        }
        errorMsg =  weiboAnalysisService.refreshAnalysis(id);

        echoJson(response,model,errorMsg);

    }


    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public void delete(HttpServletRequest request, HttpServletResponse response, Model model)
    {
        Integer id = Integer.parseInt(request.getParameter("id"));
        ErrorMsg error = weiboAnalysisService.deleteAnalysis(id);
        try {
            echoJson(response,model,error);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/preview",method = RequestMethod.GET)
    public String preview(HttpServletRequest request, HttpServletResponse response, Model model)
    {
        /*
         * 预览的ID是否有全新,在获取数据的页面校验
         */
        String previewId = request.getParameter("previewId");
        model.addAttribute("previewId",previewId);
        return "front/analysisPreview";
    }

    @RequestMapping(value = "/refreshAnalysisStatus",method = RequestMethod.POST)
    public void refreshAnalysisStatus(HttpServletRequest request,HttpSession session,HttpServletResponse response,Model model) throws IOException
    {
        String analysisId = request.getParameter("analysisId");
        String result = brandPublicSentimentService.weiboAnalysisResultWithId(analysisId);
        if(!result.equals(""))
        {
            echoJson(response,model,true);
            return;
        }
        echoJson(response,model,false);
    }

    @RequestMapping(value = "/checkAnalysisCount",method = RequestMethod.GET)
    public void checkAnalysisCount(HttpServletRequest request,HttpSession session,HttpServletResponse response,Model model) throws IOException
    {
        Integer userId = (Integer) session.getAttribute("userId");
        TblIsvInstances tblIsvInstances = isvInstanceService.findByUserId(userId);
        String instanceId = tblIsvInstances.getInstanceId();
        String url = request.getParameter("url");
        url = url.replace("weibo.com","weibo.cn");
        Integer result = weiboAnalysisService.checkAnalysisCount("",url);

        ErrorMsg errorMsg = new ErrorMsg();

        if(null == result)
        {
            errorMsg.setSuccess("false");
            errorMsg.setResult("获取转发次数失败,请稍后再试!");
            errorMsg.setMessage("获取转发次数失败,请稍后再试!");
            //TODO:邮件提醒
        }
        else
        {
            errorMsg.setSuccess("true");
            errorMsg.setResult(""+result);
            //如果分析总数超过总量,提示
            Integer currentCount = instanceProfileService.getWeiboAnalysisCount(instanceId);
            if(tblIsvInstances.getWeiboAnalysis() - currentCount - result < 0)
            {
                errorMsg.setSuccess("false");
                errorMsg.setResult("此微博需消耗"+result+"流量,当前微博分析剩余流量不足!");
                errorMsg.setMessage("此微博需消耗"+result+"流量,当前微博分析剩余流量不足!");
            }
        }

        echoJson(response,model,errorMsg);
    }
}
