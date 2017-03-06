/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: IsvInstanceServiceImpl
 * Creator:  wanggao
 * Create-Date: 上午11:15
 **/
package com.eshutech.biz.service.impl;

import com.alibaba.fastjson.JSON;
import com.eshutech.biz.entity.*;
import com.eshutech.biz.mapper.TblInstanceProfileMapper;
import com.eshutech.biz.mapper.TblIsvInstancesMapper;
import com.eshutech.biz.mapper.TblUserMapper;
import com.eshutech.biz.model.aliyun.AppInfo;
import com.eshutech.biz.model.ErrorMsg;
import com.eshutech.biz.model.aliyun.IsvParam;
import com.eshutech.biz.service.IsvInstanceService;
import com.eshutech.biz.util.Digests;
import com.eshutech.biz.util.EncodeUtils;
import com.eshutech.biz.util.context.WebHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import static com.eshutech.biz.constant.Constants.SALT_SIZE;

/**
 *
 * @author: Kim
 * @date: 16/10/19
 * @time: 上午11:15
 *
 */
@Service
public class IsvInstanceServiceImpl implements IsvInstanceService {
    private Logger logger = LoggerFactory.getLogger(IsvInstanceServiceImpl.class);


    @Resource
    TblIsvInstancesMapper tblIsvInstancesMapper;
    @Resource
    TblUserMapper         tblUserMapper;

    @Resource
    TblInstanceProfileMapper tblInstanceProfileMapper;

    @Override
    public ErrorMsg createInstance(IsvParam param) {
        ErrorMsg errorMsg = new ErrorMsg();

        /*
         * STEP 1:查询该aliUid是否已经存在
         *
         */
//        TblIsvInstancesExample isvInstancesExample = new TblIsvInstancesExample();
//        isvInstancesExample.createCriteria().andAliUidEqualTo(param.getAliUid());
//        List<TblIsvInstances> list =  tblIsvInstancesMapper.selectByExample(isvInstancesExample);
//        if(!list.isEmpty())
//        {
//            //如果aliUid已存在,返回实例ID,用户名,密码
//            TblUser tblUser = tblUserMapper.selectByPrimaryKey(list.get(0).getUid());
//            AppInfo appInfo = new AppInfo();
//            appInfo.setUsername(tblUser.getUsername());
//            appInfo.setPassword(tblUser.getPassword());//转成明码
//            errorMsg.setMessage(JSON.toJSONString(appInfo));
//            errorMsg.setResult(list.get(0).getInstanceId());
//            return errorMsg;
//        }
        /*
         * STEP 2:新增示例信息,并初始化密码,返回app信息:账号,免登地址,前台地址,管理员密码,管理地址
         */
        String username = "162"+new Date().getTime();
        String password = WebHelper.genPassword(8);
        byte[] salt = Digests.generateSalt(SALT_SIZE);
        TblUser user = new TblUser();
        user.setPlainPassword(password);
        user.setPassword(WebHelper.entryptPassword(password,salt));
        user.setEnabled("1");
        user.setUsername(username);
        user.setSalt(EncodeUtils.hexEncode(salt));
        user.setCreateTime(new Date());
        user.setModifyTime(new Date());
        tblUserMapper.insert(user);


        TblUserExample tblUserExample = new TblUserExample();
        tblUserExample.createCriteria().andUsernameEqualTo(username);
        List<TblUser> userList = tblUserMapper.selectByExample(tblUserExample);
        Integer uid=null;
        if(!userList.isEmpty())
        {
            uid = userList.get(0).getId();
        }

        String instance = WebHelper.uuid();
        TblIsvInstances tblIsvInstances = new TblIsvInstances();
        tblIsvInstances.setInstanceId(instance);
        tblIsvInstances.setAliUid(param.getAliUid());
        tblIsvInstances.setOrderId(param.getOrderId());
        tblIsvInstances.setOrderBizId(param.getOrderBizId());
        tblIsvInstances.setAccountQuantity(param.getAccountQuantity());
        tblIsvInstances.setCorpId(param.getCorpId());
        tblIsvInstances.setEmail(param.getEmail());
        tblIsvInstances.setUid(uid);

        tblIsvInstances.setKeywordLimit(40);
        tblIsvInstances.setTopicLimit(8);
        tblIsvInstances.setSentimentLimit(80000);
        tblIsvInstances.setWeiboAnalysis(80000);
        tblIsvInstances.setExpiredOn(param.getExpiredOn());
        tblIsvInstances.setMobile(param.getMobile());
        tblIsvInstances.setSkuId(param.getSkuId());
        tblIsvInstances.setTemplate(param.getTemplate());
        int result = tblIsvInstancesMapper.insert(tblIsvInstances);
        if(result!=0)
        {
            AppInfo appInfo = new AppInfo();
            appInfo.setUsername(username);
            appInfo.setPassword(password);
            errorMsg.setMessage(JSON.toJSONString(appInfo));
            errorMsg.setResult(instance);
        }
        else{
            errorMsg.setResult("0");
        }
        logger.info("create instance result "+instance+" :"+result);

        TblInstanceProfile instanceProfile = new TblInstanceProfile();
        instanceProfile.setCreateTime(new Date());
        instanceProfile.setModifyTime(new Date());
        instanceProfile.setInstanceId(instance);
        instanceProfile.setSentimentCount(0);
        instanceProfile.setWeiboAnalysisCount(0);
        tblInstanceProfileMapper.insert(instanceProfile);

        return errorMsg;
    }

    @Override
    public ErrorMsg renewInstance(String instanceId, String expiredOn) {
        ErrorMsg errorMsg = new ErrorMsg();

        TblIsvInstancesExample tblIsvInstancesExample = new TblIsvInstancesExample();
        tblIsvInstancesExample.createCriteria().andInstanceIdEqualTo(instanceId);
        List<TblIsvInstances> isvInstances = tblIsvInstancesMapper.selectByExample(tblIsvInstancesExample);

        if(isvInstances.isEmpty())
        {
            errorMsg.setSuccess("false");
            errorMsg.setMessage("未找到需要续费的实例信息");
        }
        else{
            TblIsvInstances tblIsvInstances = isvInstances.get(0);
            tblIsvInstances.setExpiredOn(expiredOn);
            tblIsvInstancesMapper.updateByPrimaryKey(tblIsvInstances);
            errorMsg.setSuccess("true");
        }
        return errorMsg;
    }

    @Override
    public ErrorMsg expiredInstance(String instanceId) {
        ErrorMsg errorMsg = new ErrorMsg();

        TblIsvInstancesExample tblIsvInstancesExample = new TblIsvInstancesExample();
        tblIsvInstancesExample.createCriteria().andInstanceIdEqualTo(instanceId);
        List<TblIsvInstances> isvInstances = tblIsvInstancesMapper.selectByExample(tblIsvInstancesExample);

        if(isvInstances.isEmpty())
        {
            errorMsg.setSuccess("false");
            errorMsg.setMessage("未找到需要续费的实例信息");
        }
        else{
            TblIsvInstances tblIsvInstances = isvInstances.get(0);
            tblIsvInstances.setExpiredOn("1970-01-01 00:00:00");
            tblIsvInstancesMapper.updateByPrimaryKey(tblIsvInstances);
            errorMsg.setSuccess("true");
        }
        return errorMsg;
    }

    @Override
    public ErrorMsg releaseInstance(String instanceId) {

        ErrorMsg errorMsg = new ErrorMsg();

        TblIsvInstancesExample tblIsvInstancesExample = new TblIsvInstancesExample();
        tblIsvInstancesExample.createCriteria().andInstanceIdEqualTo(instanceId);
        List<TblIsvInstances> isvInstances = tblIsvInstancesMapper.selectByExample(tblIsvInstancesExample);

        if(isvInstances.isEmpty())
        {
            errorMsg.setSuccess("false");
            errorMsg.setMessage("未找到需要续费的实例信息");
        }
        else{
            TblIsvInstances tblIsvInstances = isvInstances.get(0);
            tblIsvInstancesMapper.deleteByPrimaryKey(tblIsvInstances.getInstanceId());
            errorMsg.setSuccess("true");
        }
        return errorMsg;
    }


    @Override
    public ErrorMsg bindDomain() {
        return null;
    }

    @Override
    public TblIsvInstances verify(String instanceId) {

        TblIsvInstancesExample tblIsvInstancesExample = new TblIsvInstancesExample();
        tblIsvInstancesExample.createCriteria().andInstanceIdEqualTo(instanceId);
        List<TblIsvInstances> isvInstances = tblIsvInstancesMapper.selectByExample(tblIsvInstancesExample);
        if(isvInstances.isEmpty())
        {
            return null;
        }
        else{
            return isvInstances.get(0);
        }

    }

    @Override
    public TblIsvInstances findByUserId(Integer uid) {
        TblIsvInstancesExample tblIsvInstancesExample = new TblIsvInstancesExample();
        tblIsvInstancesExample.createCriteria().andUidEqualTo(uid);
        List<TblIsvInstances> list = tblIsvInstancesMapper.selectByExample(tblIsvInstancesExample);
        if(list.isEmpty())
        {
            return null;
        }
        return list.get(0);
    }


}
