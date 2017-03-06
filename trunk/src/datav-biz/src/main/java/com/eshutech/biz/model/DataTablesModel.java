package com.eshutech.biz.model;

import java.util.List;

/**
 * User: Kim
 * Date: 14-2-3
 * Time: 下午8:36
 */
public class DataTablesModel {
    private String iTotalDisplayRecords;
    private String iTotalRecords;
    private Integer iDisplayStart;
    private Integer sEcho;
    @SuppressWarnings("rawtypes")
	private List aaData;

    public DataTablesModel() {
    }

    public Integer getIDisplayStart() {
        return iDisplayStart;
    }

    public void setIDisplayStart(Integer iDisplayStart) {
        this.iDisplayStart = iDisplayStart;
    }

    @SuppressWarnings("rawtypes")
	public List getAaData() {
        return aaData;
    }

    @SuppressWarnings("rawtypes")
	public void setAaData(List aaData) {
        this.aaData = aaData;
    }

    public String getITotalDisplayRecords() {
        return iTotalDisplayRecords;
    }

    public void setITotalDisplayRecords(String iTotalDisplayRecords) {
        this.iTotalDisplayRecords = iTotalDisplayRecords;
    }

    public String getITotalRecords() {
        return iTotalRecords;
    }

    public void setITotalRecords(String iTotalRecords) {
        this.iTotalRecords = iTotalRecords;
    }

    public Integer getSEcho() {
        return sEcho;
    }

    public void setSEcho(Integer sEcho) {
        this.sEcho = sEcho;
    }
}
