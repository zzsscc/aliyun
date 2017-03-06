/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: CompetitionInfoService
 * Creator:  wanggao
 * Create-Date: 下午7:14
 **/
package com.eshutech.biz.service;

import com.eshutech.biz.entity.TblCompetitionInfo;

import java.util.List;

/**
 *
 * @author: Kim
 * @date: 16/10/19
 * @time: 下午7:14
 *
 */
public interface CompetitionInfoService {
    /**
     * 保存竞品信息
     * @param instanceId
     * @param info
     * @return
     */
    public int saveCompetition(String instanceId,String info);

    /**
     * 获取竞品数据
     * @param instanceId
     * @return
     */
    public List<TblCompetitionInfo> queryCompetition(String instanceId);
}
