package com.eshutech.biz.task;


import com.eshutech.biz.constant.PropertyConstants;
import com.eshutech.biz.exception.ServiceException;
import com.eshutech.biz.util.helper.LocalConfig;
import com.eshutech.biz.util.http.HttpSyncRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author:Binwei.Chen
 * @Date:2015-05-06 14:32:47
 * @Description:初始化上报应用部署信息
 */
public class HostHeartTask {
    private static final Logger                   logger   = LoggerFactory.getLogger(HostHeartTask.class);
    private static final ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

    public void startAnalyzing() {
        int hostHeartTaskService = LocalConfig.I().GI("HostHeartTask", 1);
        if (hostHeartTaskService == 1) {
            executor.scheduleWithFixedDelay(new Runnable() {
                public void run() {
                    try {
                        String url = PropertyConstants.HTTP_SERVER_URL;
                        String host = LocalConfig.I().GS(PropertyConstants.HTTP_SERVER_HOST);
                        String port = LocalConfig.I().GS(PropertyConstants.HTTP_SERVER_PORT);
                        Integer type = LocalConfig.I().GI(PropertyConstants.HTTP_SERVER_TYPE, 0);

                        StringBuilder heartUrl = new StringBuilder();
                        heartUrl.append(url);
                        heartUrl.append("?ip=").append(host);
                        heartUrl.append("&port=").append(port);
                        heartUrl.append("&type=").append(type);

                        HttpSyncRequest.httpSyncDate(heartUrl.toString());
                    } catch (ServiceException e) {
                        logger.error("request host heart url error;code:[{}] msg:[{}]", e.getCode(), e.getMsg());
                    } catch (Exception e) {
                        logger.error("request host heart url error;code:[{}] msg:[{}]", e.getMessage());
                    }
                }
            }, 10, 60 * 60, TimeUnit.SECONDS);
        }
    }

    public void destroyAnalyzing() {
        executor.shutdown();
    }
}