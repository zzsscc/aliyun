/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: SearchResult
 * Creator:  wanggao
 * Create-Date: 下午3:57
 **/
package com.eshutech.biz.model;

import com.eshutech.biz.entity.TblSearchRecord;

import java.util.List;

/**
 *
 * @author: Kim
 * @date: 16/10/31
 * @time: 下午3:57
 *
 */
public class SearchResult {

    private List<TblSearchRecord> records;
    private Object facetFields;
    private Object dateFacetFields;

    public List<TblSearchRecord> getRecords() {
        return records;
    }

    public void setRecords(List<TblSearchRecord> records) {
        this.records = records;
    }

    public Object getFacetFields() {
        return facetFields;
    }

    public void setFacetFields(Object facetFields) {
        this.facetFields = facetFields;
    }

    public Object getDateFacetFields() {
        return dateFacetFields;
    }

    public void setDateFacetFields(Object dateFacetFields) {
        this.dateFacetFields = dateFacetFields;
    }
}
