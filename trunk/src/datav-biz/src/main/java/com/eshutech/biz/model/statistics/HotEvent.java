/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: HotEvent
 * Creator:  wanggao
 * Create-Date: 下午2:42
 **/
package com.eshutech.biz.model.statistics;

/**
 *
 * @author: Kim
 * @date: 16/11/25
 * @time: 下午2:42
 *
 */
public class HotEvent {
    private String desc;
    private int count;
    private String url;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
