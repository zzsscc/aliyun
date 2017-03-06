/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: UserServiceImpl
 * Creator:  wanggao
 * Create-Date: 下午12:19
 **/
package com.eshutech.biz.service.impl;

import com.eshutech.biz.entity.TblUser;
import com.eshutech.biz.entity.TblUserExample;
import com.eshutech.biz.mapper.TblUserMapper;
import com.eshutech.biz.service.UserService;
import com.eshutech.biz.util.Digests;
import com.eshutech.biz.util.EncodeUtils;
import com.eshutech.biz.util.context.WebHelper;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import static com.eshutech.biz.constant.Constants.SALT_SIZE;

/**
 *
 * @author: Kim
 * @date: 16/10/22
 * @time: 下午12:19
 *
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    TblUserMapper tblUserMapper;

    @Override
    public TblUser findUserByName(String username) {
        TblUserExample tblUserExample = new TblUserExample();
        tblUserExample.createCriteria().andUsernameEqualTo(username);
        List<TblUser> list = tblUserMapper.selectByExample(tblUserExample);
        if(!list.isEmpty())
        {
            return list.get(0);
        }
        return null;
    }

    @Override
    public TblUser findOne(Integer id) {
        return tblUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer findNextId(Integer currentId) {
        TblUserExample example = new TblUserExample();
        example.createCriteria().andIdGreaterThan(currentId);
        example.setOrderByClause("id asc");

        PageHelper.startPage(1,1);
        List<TblUser> list = tblUserMapper.selectByExample(example);
        if(!list.isEmpty())
        {
            return list.get(0).getId();
        }
        return null;
    }

    @Override
    public void updateUser(TblUser user) {
        tblUserMapper.updateByPrimaryKey(user);
    }

    @Override
    public void resetPassword(TblUser user)
    {
        String password = WebHelper.genPassword(8);
        byte[] salt = Digests.generateSalt(SALT_SIZE);
        user.setPlainPassword(password);
        user.setPassword(WebHelper.entryptPassword(password,salt));
        user.setSalt(EncodeUtils.hexEncode(salt));
        user.setModifyTime(new Date());
        tblUserMapper.updateByPrimaryKey(user);
    }
}
