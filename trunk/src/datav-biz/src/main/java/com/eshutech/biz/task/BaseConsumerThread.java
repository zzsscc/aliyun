package com.eshutech.biz.task;


import com.eshutech.biz.util.annotation.TaskThread;
import com.eshutech.biz.util.helper.LocalConfig;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author:Binwei.Chen
 * @Date:2015-05-06 14:32:47
 * @Description:基础消费线程
 */
public class BaseConsumerThread {
    private        Logger  logger    = LoggerFactory.getLogger(BaseConsumerThread.class);
    private static boolean isRunning = false;

    public void startAnalyzing() {
        TaskThread taskThread = this.getClass().getAnnotation(TaskThread.class);
        int isRun = LocalConfig.I().GI(taskThread.model(), 0);
        if (isRun == 0) {
            return;
        }

        Thread consumer = new Consumer();
        consumer.start();
        isRunning = true;
    }

    public void destroyAnalyzing() {

    }

    class Consumer extends Thread {
        public void run() {
            while (true) {
                try {
                    runFunction();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    logger.info("--------消费线程异常:{}--------", ExceptionUtils.getStackTrace(ex));
                }
            }
        }
    }

    public void runFunction() {
    }
}