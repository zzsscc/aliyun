/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: StatisticsService
 * Creator:  wanggao
 * Create-Date: 下午3:05
 **/
package com.eshutech.biz.service;

import com.eshutech.biz.model.statistics.HotEvent;
import com.eshutech.biz.model.statistics.HotKeyword;

import java.util.List;

/**
 *
 * @author: Kim
 * @date: 16/11/25
 * @time: 下午3:05
 *
 */
public interface StatisticsService {

    public List<HotKeyword> hotKeyword(String instance);
    public List<HotEvent> hotEvent(String instance);

}
