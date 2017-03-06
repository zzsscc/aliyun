package com.eshutech.biz.factory.sms;

import com.alibaba.fastjson.JSONObject;
import com.eshutech.biz.constant.Enum.ExecuteStatusEnum;
import com.eshutech.biz.entity.TblSmsMt;
import com.eshutech.biz.factory.log.LogEx;
import com.eshutech.biz.task.BaseConsumerThread;
import com.eshutech.biz.util.annotation.TaskThread;
import com.eshutech.biz.util.helper.LocalConfig;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author:Lajiao
 * @Date:2014年10月21日
 * @Time:上午8:23:04
 * @Description:短信发送
 */
@TaskThread(model = "SendSms")
public class SendSms extends BaseConsumerThread {
    private static final Logger               logger     = LoggerFactory.getLogger(SendSms.class);
    private static final BlockingQueue<TblSmsMt> matchQueue = new LinkedBlockingQueue<TblSmsMt>();

    public static void BI(TblSmsMt smsMt) {
        int isRun = LocalConfig.I().GI("SendSms", 0);
        if (isRun == 0) {
            logger.info("SendSms-SEND:{}", smsMt);
            return;
        }

        try {
            matchQueue.put(smsMt);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void runFunction() {
        TblSmsMt smsMt = null;
        try {
            smsMt = matchQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
            LogEx.BI("700001", "SendSms", "", "短信发送异常:{}", new Object[]{ExceptionUtils.getStackTrace(e)});
            return;
        }

        // 上行短信入库
        NameValuePair[] nameValuePairs = new NameValuePair[8];
        nameValuePairs[0] = new NameValuePair("userid", "");
        nameValuePairs[1] = new NameValuePair("account", LocalConfig.I().GS("sms.account.hx"));
        nameValuePairs[2] = new NameValuePair("password", LocalConfig.I().GS("sms.password.hx"));
        nameValuePairs[3] = new NameValuePair("mobile", smsMt.getMtPhone());
        nameValuePairs[4] = new NameValuePair("content", smsMt.getMtContent());
        nameValuePairs[5] = new NameValuePair("sendTime", "");
        nameValuePairs[6] = new NameValuePair("action", "send");
        nameValuePairs[7] = new NameValuePair("extno", "");

        PostMethod postMethod = new PostMethod("http://dx.ipyy.net/smsJson.aspx");
        HttpClient client = new HttpClient();
        postMethod.addRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

        try {
            postMethod.setRequestBody(nameValuePairs);
            int status = client.executeMethod(postMethod);
            TblSmsMt upd = new TblSmsMt();
            upd.setId(smsMt.getId());
            if (status == HttpStatus.SC_OK) {
                String result = postMethod.getResponseBodyAsString();
                JSONObject jsonObject = JSONObject.parseObject(result);
                if (jsonObject == null) {
                    upd.setMtStatus(ExecuteStatusEnum.FAIL.getCode().toString());
                    upd.setMtId("");
                    upd.setMtTime(new Date());
                    upd.setMtCount("1");
                } else if ("Success".equals(jsonObject.getString("returnstatus"))) {
                    upd.setMtStatus(ExecuteStatusEnum.SUCC.getCode().toString());
                    upd.setMtId(jsonObject.getString("taskID"));
                    upd.setMtTime(new Date());
                    upd.setMtCount(jsonObject.getString("successCounts"));
                } else {
                    upd.setMtStatus(ExecuteStatusEnum.FAIL.getCode().toString());
                    upd.setMtId(jsonObject.getString("taskID"));
                    upd.setMtTime(new Date());
                    upd.setMtCount(jsonObject.getString("successCounts"));
                }
                upd.setDataDesc(result);
            } else {
                upd.setMtStatus(ExecuteStatusEnum.FAIL.getCode().toString());
                upd.setMtId("");
                upd.setMtTime(new Date());
                upd.setDataDesc(String.valueOf("FAIL-STATUS:" + status));
            }
//            ISmsMtService smsMtService = (ISmsMtService) SpringUtils.getBean("smsMtService");
//            smsMtService.update(upd);
        } catch (Exception e) {
            e.printStackTrace();
            LogEx.BI("700002", "SendSms", "", "短信发送异常:{}", new Object[]{ExceptionUtils.getStackTrace(e)});
        } finally {
            // 释放连接
            postMethod.releaseConnection();
        }
    }
}
