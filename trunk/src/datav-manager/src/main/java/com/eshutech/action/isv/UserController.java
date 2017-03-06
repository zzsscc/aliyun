/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: UserController
 * Creator:  wanggao
 * Create-Date: 下午2:25
 **/
package com.eshutech.action.isv;

import com.eshutech.biz.entity.TblUser;
import com.eshutech.biz.entity.TblUserExample;
import com.eshutech.biz.mapper.TblUserMapper;
import com.eshutech.biz.model.DataTablesModel;
import com.eshutech.biz.model.ErrorMsg;
import com.eshutech.biz.model.vo.UserVo;
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
import java.io.IOException;
import java.util.List;

/**
 *
 * @author: Kim
 * @date: 16/11/16
 * @time: 下午2:25
 *
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Resource
    TblUserMapper tblUserMapper;

    @Resource
    UserService userService;


    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public void list(HttpServletRequest request, HttpServletResponse response, Model model)
    {
        Integer iDisplayStart = Integer.parseInt(request.getParameter("iDisplayStart"));
        Integer iDisplayLength = Integer.parseInt(request.getParameter("iDisplayLength"));

        TblUserExample example = new TblUserExample();
        int hasFilter = 0;
        if(null != request.getParameter("username"))
        {
            String username = request.getParameter("username");
            example.createCriteria().andUsernameEqualTo(username);
            hasFilter++;
        }
        if(null != request.getParameter("aliUid"))
        {
            String aliUid = request.getParameter("aliUid");
            example.createCriteria().andAliUidEqualTo(aliUid);
            hasFilter++;
        }
        if(null != request.getParameter("mobile"))
        {
            String mobile = request.getParameter("mobile");
            example.createCriteria().andMobileEqualTo(mobile);
            hasFilter++;
        }

        example.setOrderByClause(" sentiment_count desc");

        PageHelper.startPage(iDisplayStart / iDisplayLength+1,iDisplayLength);
        List<UserVo> list = tblUserMapper.selectUserVo(example);
        int count = tblUserMapper.countVoByExample(example);

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

    @RequestMapping(value = "/resetPassword",method = RequestMethod.POST)
    public void resetPassword(HttpServletRequest request,HttpServletResponse response,Model model) throws IOException {
        Integer uid = Integer.parseInt(request.getParameter("uid"));
        TblUser user = userService.findOne(uid);
        if(null != user)
        {
            userService.resetPassword(user);
        }
        ErrorMsg errorMsg = new ErrorMsg();
        errorMsg.setSuccess("true");
        errorMsg.setResult(user.getPlainPassword());
        echoJson(response,model,errorMsg);
    }
}
