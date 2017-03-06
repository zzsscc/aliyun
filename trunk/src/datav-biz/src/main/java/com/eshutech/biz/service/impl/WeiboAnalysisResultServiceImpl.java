/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: WeiboAnalysisResultServiceImpl
 * Creator:  wanggao
 * Create-Date: 下午12:14
 **/
package com.eshutech.biz.service.impl;

import com.eshutech.biz.entity.TblWeiboAnalysisResult;
import com.eshutech.biz.mapper.TblWeiboAnalysisResultMapper;
import com.eshutech.biz.service.WeiboAnalysisResultService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * @author: Kim
 * @date: 16/10/19
 * @time: 下午12:14
 *
 */
@Service
public class WeiboAnalysisResultServiceImpl implements WeiboAnalysisResultService {

    @Resource
    TblWeiboAnalysisResultMapper tblWeiboAnalysisResultMapper;

    @Override
    public TblWeiboAnalysisResult queryById(String id) {
        return tblWeiboAnalysisResultMapper.selectByPrimaryKey(id);
    }
}
