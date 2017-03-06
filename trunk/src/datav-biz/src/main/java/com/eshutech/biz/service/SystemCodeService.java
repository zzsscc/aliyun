/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: SystemCodeService
 * Creator:  wanggao
 * Create-Date: 上午9:39
 **/
package com.eshutech.biz.service;

/**
 *
 * @author: Kim
 * @date: 16/11/3
 * @time: 上午9:39
 *
 */
public interface SystemCodeService {
    public String getSystemCodeValue(String code);
    public void updateSystemCode(String code,Object value);
}
