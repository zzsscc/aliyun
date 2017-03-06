/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: KeywordController
 * Creator:  wanggao
 * Create-Date: 下午5:50
 **/
package com.eshutech.action.isv;

import com.eshutech.biz.entity.*;
import com.eshutech.biz.mapper.AliKeywordMapper;
import com.eshutech.biz.mapper.TblDatavKeywordsMapper;
import com.eshutech.biz.model.DataTablesModel;
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
 * @date: 16/10/18
 * @time: 下午5:50
 *
 */
@Controller
@RequestMapping(value = "/keyword")
public class KeywordController extends BaseController {

    @Resource
    private TblDatavKeywordsMapper tblDatavKeywordsMapper;

    @Resource
    AliKeywordMapper aliKeywordMapper;


    /**
     * 根据专题ID获取关键词列表
     * @param request
     * @param response
     * @param model
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public void list(HttpServletRequest request, HttpServletResponse response, Model model)
    {
        Integer iDisplayStart = Integer.parseInt(request.getParameter("iDisplayStart"));
        Integer iDisplayLength = Integer.parseInt(request.getParameter("iDisplayLength"));

        PageHelper.startPage(iDisplayStart / iDisplayLength+1,iDisplayLength);

        TblDatavKeywordsExample example = new TblDatavKeywordsExample();
        if(null != request.getParameter("topicId"))
        {
            Integer topicId = Integer.parseInt(request.getParameter("topicId"));
            example.createCriteria().andTopicIdEqualTo(topicId);
        }
        if(null != request.getParameter("keyword"))
        {
            String keyword = request.getParameter("keyword");
            example.createCriteria().andKeywordLike(keyword);
        }
        List<TblDatavKeywords> list = tblDatavKeywordsMapper.selectByExample(example);
        int count = tblDatavKeywordsMapper.countByExample(example);

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

    @RequestMapping(value = "/listAli",method = RequestMethod.GET)
    public void listAli(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session)
    {
        Integer iDisplayStart = Integer.parseInt(request.getParameter("iDisplayStart"));
        Integer iDisplayLength = Integer.parseInt(request.getParameter("iDisplayLength"));


        AliKeywordExample example = new AliKeywordExample();

        if(null != request.getParameter("topicId"))
        {
            Integer topicId = Integer.parseInt(request.getParameter("topicId"));
            example.createCriteria().andTopicIdEqualTo(topicId);
        }
        if(null != request.getParameter("keyword"))
        {
            String keyword = request.getParameter("keyword");
            example.createCriteria().andKeywordLike(keyword);
        }


        PageHelper.startPage(iDisplayStart / iDisplayLength+1,iDisplayLength);
        List<AliKeyword> list = aliKeywordMapper.selectByExample(example);
        int count = aliKeywordMapper.countByExample(example);

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

}
