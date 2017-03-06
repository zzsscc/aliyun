/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: SysUserServiceImpl
 * Creator:  wanggao
 * Create-Date: 上午11:19
 **/
package com.eshutech.biz.service.impl;

import com.eshutech.biz.entity.SysUser;
import com.eshutech.biz.entity.SysUserExample;
import com.eshutech.biz.mapper.SysUserMapper;
import com.eshutech.biz.service.SysUserService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * @author: Kim
 * @date: 16/11/16
 * @time: 上午11:19
 *
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Resource
    SysUserMapper sysUserMapper;

    @Override
    public SysUser findUserByName(String username) {
        SysUserExample example = new SysUserExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<SysUser> list = sysUserMapper.selectByExample(example);
        if(!list.isEmpty())
        {
            return list.get(0);
        }
        return null;
    }

    @Override
    public SysUser findOne(Integer id) {
        SysUserExample example = new SysUserExample();
        example.createCriteria().andIdEqualTo(id);


        return sysUserMapper.selectByExample(example).get(0);
    }

    @Override
    public Integer findNextId(Integer currentId) {
        SysUserExample example = new SysUserExample();
        example.createCriteria().andIdGreaterThan(currentId);
        example.setOrderByClause("id asc");

        PageHelper.startPage(1,1);
        List<SysUser> list = sysUserMapper.selectByExample(example);
        if(!list.isEmpty())
        {
            return list.get(0).getId();
        }
        return null;
    }

    @Override
    public void updateUser(SysUser user) {
        sysUserMapper.updateByPrimaryKey(user);
    }
}
