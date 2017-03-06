/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: KeywordController
 * Creator:  wanggao
 * Create-Date: 下午5:50
 **/
package com.eshutech.admin.action.isv;

import com.eshutech.biz.entity.TblDatavKeywords;
import com.eshutech.biz.model.ErrorMsg;
import com.eshutech.biz.model.ListObject;
import com.eshutech.biz.service.DatavKeywordsService;
import com.eshutech.utils.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    private DatavKeywordsService datavKeywordsService;


    /**
     * 根据专题ID获取关键词列表
     * @param request
     * @param response
     * @param model
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public void list(HttpServletRequest request, HttpServletResponse response, Model model)
    {
        //TODO:分页查询
        int pageNum = request.getParameter("pageNum") == null ? 1 : Integer.parseInt(request.getParameter("pageNum"));
        int pageSize = request.getParameter("pageSize") == null ? 20 : Integer.parseInt(request.getParameter("pageSize"));
        Integer topicId = Integer.parseInt(request.getParameter("topicId"));
        List<TblDatavKeywords> list = datavKeywordsService.queryKeywords(topicId,pageNum,pageSize);

        int count = datavKeywordsService.count(topicId);
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

    /**
     * 添加新关键词
     * @param request
     * @param response
     * @param model
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public void add(HttpServletRequest request, HttpServletResponse response, Model model)
    {
        ErrorMsg errorMsg;

        String keyword = request.getParameter("keyword");
        Integer topicId = Integer.parseInt(request.getParameter("topicId"));
        String siteTypeIds = request.getParameter("siteTypeIds");
        errorMsg = datavKeywordsService.insertKeyword(keyword,topicId,siteTypeIds);
        try {
            echoJson(response,model,errorMsg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 更新关键词
     * @param request
     * @param response
     * @param model
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public void update(HttpServletRequest request, HttpServletResponse response, Model model)
    {
        String keyword = request.getParameter("keyword");
        Integer id = Integer.parseInt(request.getParameter("id"));
        String siteTypeIds = request.getParameter("siteTypeIds");
        datavKeywordsService.updateKeyword(keyword,id,siteTypeIds);
        try {
            echoJson(response,model,true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 删除关键词
     * @param request
     * @param response
     * @param model
     */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public void delete(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        //TODO:删除多个关键词,id为JSON数组
        ErrorMsg errorMsg = new ErrorMsg();
        String id = request.getParameter("id");
        if(null == id)
        {
            errorMsg.setSuccess("false");
            errorMsg.setMessage("缺少必要参数!");
            errorMsg.setResult("");
            echoJson(response,model,errorMsg);
            return;
        }
        datavKeywordsService.deleteKeyword(id);
        try {
            echoJson(response,model,true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
