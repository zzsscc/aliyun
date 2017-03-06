/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: BrandSentimentController
 * Creator:  wanggao
 * Create-Date: 上午9:27
 **/
package com.eshutech.action.isv;

import com.eshutech.utils.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author: Kim
 * @date: 16/10/21
 * @time: 上午9:27
 *
 */
@Controller
@RequestMapping("/brand")
public class BrandSentimentController extends BaseController {


    @RequestMapping(value = "list",method = RequestMethod.GET)
    public void list(HttpServletRequest request, HttpServletResponse response, Model model)
    {

    }
}
