/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: CompetitionInfoServiceImpl
 * Creator:  wanggao
 * Create-Date: 下午7:14
 **/
package com.eshutech.biz.service.impl;

import com.eshutech.biz.entity.TblCompetitionInfo;
import com.eshutech.biz.entity.TblCompetitionInfoExample;
import com.eshutech.biz.mapper.TblCompetitionInfoMapper;
import com.eshutech.biz.service.CompetitionInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author: Kim
 * @date: 16/10/19
 * @time: 下午7:14
 *
 */
@Service
public class CompetitionInfoServiceImpl implements CompetitionInfoService {
    @Resource
    TblCompetitionInfoMapper tblCompetitionInfoMapper;

    @Override
    public int saveCompetition(String instanceId, String info) {
        TblCompetitionInfoExample competitionInfoExample = new TblCompetitionInfoExample();
        competitionInfoExample.createCriteria().andInstanceidEqualTo(instanceId);
        List<TblCompetitionInfo> result = tblCompetitionInfoMapper.selectByExample(competitionInfoExample);
        TblCompetitionInfo competitionInfo;
        if (result.isEmpty())
        {
            competitionInfo = new TblCompetitionInfo();
            competitionInfo.setInstanceid(instanceId);
            competitionInfo.setInfo(info);
            competitionInfo.setCreateTime(new Date());
            competitionInfo.setModifyTime(new Date());
            tblCompetitionInfoMapper.insert(competitionInfo);
        }
        else {
            competitionInfo = result.get(0);
            competitionInfo.setInfo(info);
            competitionInfo.setModifyTime(new Date());
            tblCompetitionInfoMapper.updateByPrimaryKey(competitionInfo);
        }
        return 1;
    }

    @Override
    public List<TblCompetitionInfo> queryCompetition(String instanceId) {
        TblCompetitionInfoExample competitionInfoExample = new TblCompetitionInfoExample();
        competitionInfoExample.createCriteria().andInstanceidEqualTo(instanceId);
        List<TblCompetitionInfo> result = tblCompetitionInfoMapper.selectByExample(competitionInfoExample);
        if(null == result)
        {
            result = new ArrayList<TblCompetitionInfo>();
        }
        return result;
    }
}
