/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: ListObject
 * Creator:  wanggao
 * Create-Date: 下午4:22
 **/
package com.eshutech.biz.model;

import java.util.List;

/**
 *
 * @author: Kim
 * @date: 16/10/23
 * @time: 下午4:22
 *
 */
public class ListObject {

    private int total;
    private List list;
    private int pageNum;
    private int pageSize;

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
