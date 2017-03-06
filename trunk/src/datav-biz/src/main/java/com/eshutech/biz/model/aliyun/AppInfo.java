/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: AppInfo
 * Creator:  wanggao
 * Create-Date: 下午7:52
 **/
package com.eshutech.biz.model.aliyun;

/**
 *
 * @author: Kim
 * @date: 16/10/17
 * @time: 下午7:52
 *
 */
public class AppInfo {

    /*
     *前台地址
     */
    private String frontEndUrl;
    /*
     *管理地址
     */
    private String adminUrl;
    /*
     *管理员账号
     */
    private String username;
    /*
     *管理员密码
     */
    private String password;
    /*
     *免登地址
     */
    private String authUrl;


    public String getFrontEndUrl() {
        return frontEndUrl;
    }

    public void setFrontEndUrl(String frontEndUrl) {
        this.frontEndUrl = frontEndUrl;
    }

    public String getAdminUrl() {
        return adminUrl;
    }

    public void setAdminUrl(String adminUrl) {
        this.adminUrl = adminUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthUrl() {
        return authUrl;
    }

    public void setAuthUrl(String authUrl) {
        this.authUrl = authUrl;
    }
}
