/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: IsvInstanceService
 * Creator:  wanggao
 * Create-Date: 上午11:13
 **/
package com.eshutech.biz.service;

import com.eshutech.biz.entity.TblIsvInstances;
import com.eshutech.biz.model.ErrorMsg;
import com.eshutech.biz.model.aliyun.IsvParam;

/**
 *
 * @author: Kim
 * @date: 16/10/19
 * @time: 上午11:13
 *
 */
public interface IsvInstanceService {

    /**
     * 创建实例
     * @param param
     * @return
     */
    public ErrorMsg createInstance(IsvParam param);

    /**
     * 续费实例
     * @return
     */
    public ErrorMsg renewInstance(String instanceId,String expiredOn);

    /**
     * 实例过期
     * @return
     */
    public ErrorMsg expiredInstance(String instanceId);

    /**
     * 释放实例
     * @return
     */
    public ErrorMsg releaseInstance(String instanceId);

    /**
     * 绑定域名
     * @return
     */
    public ErrorMsg bindDomain();

    /**
     * 免登
     * @return
     */
    public TblIsvInstances verify(String instanceId);

    /**
     * 根据用户id查到实例id
     * @param uid
     * @return
     */
    public TblIsvInstances findByUserId(Integer uid);
}
