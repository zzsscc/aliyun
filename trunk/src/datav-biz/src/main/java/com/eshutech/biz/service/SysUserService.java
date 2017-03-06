/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: SysUserService
 * Creator:  wanggao
 * Create-Date: 上午11:19
 **/
package com.eshutech.biz.service;

import com.eshutech.biz.entity.SysUser;

/**
 *
 * @author: Kim
 * @date: 16/11/16
 * @time: 上午11:19
 *
 */
public interface SysUserService {
    public SysUser findUserByName(String username);
    public SysUser findOne(Integer id);

    public Integer findNextId(Integer currentId);
    public void updateUser(SysUser user);
}
