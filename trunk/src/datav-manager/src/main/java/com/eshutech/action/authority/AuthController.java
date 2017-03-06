/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: IsvController
 * Creator:  wanggao
 * Create-Date: 下午2:34
 **/
package com.eshutech.action.authority;

import com.alibaba.fastjson.JSONObject;
import com.eshutech.biz.entity.TblIsvInstances;
import com.eshutech.biz.entity.TblUser;
import com.eshutech.biz.service.IsvInstanceService;
import com.eshutech.biz.service.UserService;
import com.eshutech.utils.BaseController;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Map;

/**
 *
 * @author: Kim
 * @date: 16/10/21
 * @time: 下午2:34
 *
 */
@Controller
@RequestMapping(value="/authAliyun")
public class AuthController extends BaseController {

    Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Resource
    IsvInstanceService isvInstanceService;

    @Resource
    UserService userService;

    @Autowired
    private HttpServletRequest request;

    private static final String SECRET_KEY = "9ca5lJrgNiM1LZUiOt27IXNjNTCdbZkoLtzlqALGZwOBM80NJdBEqYX816FfFOCF";




    @RequestMapping(value="")
    public String auth(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) {
        //1. 校验参数（必传参数，参数格式...）
        //..

        //2. 校验token
        if(!validateToken()) {
            model.addAttribute("error", "token is invalid");
            logger.error("token is invalid");
            return "pixelv1/login";
        }

        //3. 处理具体业务逻辑
        //...
        String instanceId = request.getParameter("instanceId");
        logger.info("免登实例:"+instanceId);
        if(null == instanceId)
        {
            model.addAttribute("error", "缺少必要的参数:instanceId");
            logger.error("缺少必要的参数:instanceId");
            return "pixelv1/login";
        }

        TblIsvInstances instances = isvInstanceService.verify(instanceId);
        if(null != instances)
        {
            TblUser tblUser = userService.findOne(instances.getUid());

            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(tblUser.getUsername(), tblUser.getPlainPassword());
            subject.login(token);
            session.setAttribute("nick",tblUser.getFullname());
            session.setAttribute("userId",tblUser.getId());
            session.setAttribute("username",tblUser.getUsername());
            return "redirect:/manager/index";
        }
        else
        {
            model.addAttribute("error","未找到需要验证的实例信息");
            logger.error("未找到需要验证的实例信息:"+instanceId);
            return "pixelv1/login";
        }
    }




    /**
     * 校验token
     * @return
     */
    private boolean validateToken() {
        String genToken = generateToken();
        return genToken == null ? false : genToken.equals(request.getParameter("token"));
    }

    /**
     * 根据请求参数生成token
     * @return
     */
    private String generateToken() {
        Map<String, String[]> parameterMap = request.getParameterMap();
        String[] sortedKeys = (String[])parameterMap.keySet().toArray(new String[0]);
        Arrays.sort(sortedKeys);
        StringBuilder baseStringBuilder = new StringBuilder();
        for(String key : sortedKeys) {
            if(!"token".equals(key)) {
                baseStringBuilder.append(key).append("=").append(parameterMap.get(key)[0]).append("&");
            }
        }
        baseStringBuilder.append("key").append("=").append(SECRET_KEY);
        return md5(baseStringBuilder.toString());
    }

    /**
     * md5工具方法
     * @param s
     * @return
     */
    private static String md5(String s) {
        try {
            MessageDigest DIGESTER = MessageDigest.getInstance("MD5");
            byte[] digest = DIGESTER.digest(s.getBytes());
            return bytesToString(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String bytesToString(byte[] data) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
                'e', 'f'};
        char[] temp = new char[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            byte b = data[i];
            temp[i * 2] = hexDigits[b >>> 4 & 0x0f];
            temp[i * 2 + 1] = hexDigits[b & 0x0f];
        }
        return new String(temp);
    }

    /**
     * 返回错误结果
     * @param errorMessage
     * @return
     */
    private String generateErrorResponse(String errorMessage) {
        JSONObject result = new JSONObject();
        result.put("success", false);
        result.put("message", errorMessage);
        return result.toJSONString();
    }

    /**
     * 返回正确结果
     * @return
     */
    private String generateCorrectResponse() {
        JSONObject result = new JSONObject();
        result.put("success", true);
        return result.toJSONString();
    }
}
