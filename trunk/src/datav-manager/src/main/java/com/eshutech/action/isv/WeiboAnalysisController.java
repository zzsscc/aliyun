/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: WeiboAnalysisController
 * Creator:  wanggao
 * Create-Date: 下午4:21
 **/
package com.eshutech.action.isv;

import com.eshutech.biz.entity.TblIsvInstances;
import com.eshutech.biz.entity.TblUser;
import com.eshutech.biz.entity.TblWeiboAnalysis;
import com.eshutech.biz.entity.TblWeiboAnalysisExample;
import com.eshutech.biz.mapper.TblWeiboAnalysisMapper;
import com.eshutech.biz.model.DataTablesModel;
import com.eshutech.biz.model.ErrorMsg;
import com.eshutech.biz.service.BrandPublicSentimentService;
import com.eshutech.biz.service.InstanceProfileService;
import com.eshutech.biz.service.IsvInstanceService;
import com.eshutech.biz.service.UserService;
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

/**
 *
 * @author: Kim
 * @date: 16/10/19
 * @time: 下午4:21
 *
 */
@Controller
@RequestMapping("/analysis")
public class WeiboAnalysisController extends BaseController{

    @Resource
    TblWeiboAnalysisMapper tblWeiboAnalysisMapper;

    @Resource
    IsvInstanceService isvInstanceService;

    @Resource
    BrandPublicSentimentService brandPublicSentimentService;

    @Resource
    InstanceProfileService instanceProfileService;

    @Resource
    UserService userService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public void list(HttpServletRequest request, HttpServletResponse response, Model model,HttpSession session)
    {
        Integer iDisplayStart = Integer.parseInt(request.getParameter("iDisplayStart"));
        Integer iDisplayLength = Integer.parseInt(request.getParameter("iDisplayLength"));

        TblWeiboAnalysisExample example = new TblWeiboAnalysisExample();

        if(null != request.getParameter("username"))
        {
            String username = request.getParameter("username");
            TblUser user = userService.findUserByName(username);
            TblIsvInstances instances = isvInstanceService.findByUserId(user.getId());
            example.createCriteria().andInstanceidEqualTo(instances.getInstanceId());
        }

        PageHelper.startPage(iDisplayStart / iDisplayLength+1,iDisplayLength);
        List<TblWeiboAnalysis> list = tblWeiboAnalysisMapper.selectByExample(example);
        int count = tblWeiboAnalysisMapper.countByExample(example);

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

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public void add(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) throws IOException {
        ErrorMsg errorMsg = new ErrorMsg();
        echoJson(response,model,errorMsg);
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public void update(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        ErrorMsg errorMsg = new ErrorMsg();

        echoJson(response,model,errorMsg);
    }

    @RequestMapping(value = "/refreshAnalysis",method = RequestMethod.POST)
    public void refreshAnalysis(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        ErrorMsg errorMsg = new ErrorMsg();
        echoJson(response,model,errorMsg);
    }


    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public void delete(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {

        ErrorMsg error = new ErrorMsg();

        echoJson(response,model,error);

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
        ErrorMsg errorMsg = new ErrorMsg();
        echoJson(response,model,errorMsg);
    }
}
