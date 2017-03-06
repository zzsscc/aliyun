/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: InstanceProfile
 * Creator:  wanggao
 * Create-Date: 上午10:35
 **/
package com.eshutech.biz.service;

/**
 *
 * @author: Kim
 * @date: 16/11/14
 * @time: 上午10:35
 *
 */
public interface InstanceProfileService {

    public void addSentimentCount(String instanceId,Integer value);
    public void updateWeiboAnalysisCount(String instanceId,Integer value);

    public int getSentimentCount(String instanceId);
    public int getWeiboAnalysisCount(String instanceId);
}
