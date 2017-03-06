package com.eshutech.biz.factory.log;

import com.eshutech.biz.entity.TblLogEmail;
import com.eshutech.biz.task.BaseConsumerThread;
import com.eshutech.biz.util.annotation.TaskThread;
import com.eshutech.biz.util.helper.LocalConfig;
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
 * @Description:异常日志记录
 */
@TaskThread(model = "LogEmail")
public class SendEmail extends BaseConsumerThread {
    private static final Logger                  logger     = LoggerFactory.getLogger(SendEmail.class);
    private static final BlockingQueue<TblLogEmail> matchQueue = new LinkedBlockingQueue<TblLogEmail>();

    public static void BI(String from, String to, String title, String body, String filePath) {
        int isRun = LocalConfig.I().GI("LogEmail", 0);
        if (isRun == 0) {
            logger.info("LogEmail-SEND:{}", body);
            return;
        }

        try {
            TblLogEmail log = new TblLogEmail();
            log.setEmailFrom(from);
            log.setEmailTo(to);
            log.setEmailTitle(title);
            log.setEmailContent("text/html;charset=UTF-8");
            log.setEmailBody(body);
            log.setEmailFiles(filePath);
            log.setCreateTime(new Date());
            matchQueue.put(log);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void runFunction() {
        TblLogEmail logEmail = null;
        try {
            logEmail = matchQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
            logger.error("--------[LogEmail] Exception:{}--------", ExceptionUtils.getStackTrace(e));
            return;
        }
        // 数据入库
        //TODO:send email
    }
}
