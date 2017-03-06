/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: UserService
 * Creator:  wanggao
 * Create-Date: 下午12:19
 **/
package com.eshutech.biz.service;

import com.eshutech.biz.entity.TblUser;

/**
 *
 * @author: Kim
 * @date: 16/10/22
 * @time: 下午12:19
 *
 */
public interface UserService {

    public TblUser findUserByName(String username);
    public TblUser findOne(Integer id);

    public Integer findNextId(Integer currentId);
    public void updateUser(TblUser user);
    public void resetPassword(TblUser user);
}
