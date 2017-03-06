/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: WeiboSyncThread
 * Creator:  wanggao
 * Create-Date: 上午9:48
 **/
package com.eshutech.thread;

import com.eshutech.biz.entity.TblWeiboAnalysis;
import com.eshutech.biz.entity.TblWeiboAnalysisExample;
import com.eshutech.biz.mapper.TblWeiboAnalysisMapper;
import com.eshutech.biz.service.InstanceProfileService;
import com.eshutech.biz.service.WeiboAnalysisService;

import javax.annotation.Resource;
import java.util.List;

import static java.lang.Thread.sleep;

/**
 *
 * @author: Kim
 * @date: 16/11/15
 * @time: 上午9:48
 *
 */
public class WeiboSyncThread implements Runnable {

    @Resource
    TblWeiboAnalysisMapper tblWeiboAnalysisMapper;

    @Resource
    WeiboAnalysisService weiboAnalysisService;
    @Resource
    InstanceProfileService instanceProfileService;

    @Override
    public void run() {
        List<TblWeiboAnalysis> weiboAnalysisList = tblWeiboAnalysisMapper.selectByExample(new TblWeiboAnalysisExample());
        for(TblWeiboAnalysis weiboAnalysis:weiboAnalysisList)
        {
            String weiboUrl = weiboAnalysis.getWeiboUrl();
            weiboUrl = weiboUrl.replace("weibo.com","weibo.cn");
            Integer result = weiboAnalysisService.checkAnalysisCount("",weiboUrl);
            String instanceId = weiboAnalysis.getInstanceid();
            Integer currentCount = instanceProfileService.getWeiboAnalysisCount(instanceId);
            instanceProfileService.updateWeiboAnalysisCount(instanceId,result+currentCount);

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
