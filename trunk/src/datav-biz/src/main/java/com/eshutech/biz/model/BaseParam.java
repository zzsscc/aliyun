/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: BaseParam
 * Creator:  wanggao
 * Create-Date: 下午1:39
 **/
package com.eshutech.biz.model;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;

/**
 *
 * @author: Kim
 * @date: 16/10/17
 * @time: 下午1:39
 *
 */
public class BaseParam {

    public String paramsToString() {
        StringBuilder result = new StringBuilder();
        result.append("?");
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field:fields)
        {
            try {
                if(field.get(this) != null &&!field.get(this).toString().equals("")&&!field.getName().equals("callback"))
                {
                    try {
                        result.append(field.getName()).append("=").append(URLEncoder.encode(field.get(this).toString(), "utf-8")).append("&");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return result.toString();
    }
}
