/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: CreateInstanceParam
 * Creator:  wanggao
 * Create-Date: 下午5:29
 **/
package com.eshutech.biz.model.aliyun;


/**
 *
 * @author: Kim
 * @date: 16/10/17
 * @time: 下午5:29
 *
 */
public class IsvParam {

    /*
     *安全检验令牌
     */
    private String token;
    /*
     *动作
     */

    private String action;
    /*
     *用户唯一标示
     */

    private String aliUid;
    /*
     *云市场业务ID
     */

    private String orderBizId;
    /*
     *云市场订单ID
     */

    private String orderId;
    /*
     *商品规格标示,与商品唯一对应,可在商品管理的销售信息中查看
     */

    private String skuId;
    /*
     *账号数量:适用于以账号数量形式售卖的商品
     */

    private String accountQuantity;
    /*
     *过期时间:yyyy-MM-dd HH:mm:ss
     */

    private String expiredOn;
    /*
     *模版ID:适用于模版建站商品
     */

    private String template;
    /*
     *钉钉企业ID:适用于钉钉类商品
     */

    private String corpId;
    /*
     *用户邮箱
     */

    private String email;
    /*
     *用户手机号
     */

    private String mobile;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getAliUid() {
        return aliUid;
    }

    public void setAliUid(String aliUid) {
        this.aliUid = aliUid;
    }

    public String getOrderBizId() {
        return orderBizId;
    }

    public void setOrderBizId(String orderBizId) {
        this.orderBizId = orderBizId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public String getAccountQuantity() {
        return accountQuantity;
    }

    public void setAccountQuantity(String accountQuantity) {
        this.accountQuantity = accountQuantity;
    }

    public String getExpiredOn() {
        return expiredOn;
    }

    public void setExpiredOn(String expiredOn) {
        this.expiredOn = expiredOn;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getCorpId() {
        return corpId;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
