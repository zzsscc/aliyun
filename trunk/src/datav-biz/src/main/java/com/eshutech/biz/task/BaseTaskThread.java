package com.eshutech.biz.task;


import com.eshutech.biz.util.annotation.TaskThread;
import com.eshutech.biz.util.helper.LocalConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author:Binwei.Chen
 * @Date:2015-05-06 14:32:47
 * @Description:基础任务线程
 */
public class BaseTaskThread {
    private Logger logger   = LoggerFactory.getLogger(BaseTaskThread.class);
    private ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

    public void startAnalyzing() {
        final TaskThread taskThread = this.getClass().getAnnotation(TaskThread.class);
        executor.scheduleWithFixedDelay(new Runnable() {
            public void run() {
                try {
                    int isRun = LocalConfig.I().GI(taskThread.model(), 0);
                    if (isRun == 0) {
                        return;
                    }
                    runFunction();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    logger.error("{} Exception;msg:[{}]", taskThread.model(), "Exception");
                }
            }
        }, taskThread.initialDelay(), taskThread.delay(), TimeUnit.SECONDS);
    }

    public void destroyAnalyzing() {
        executor.shutdown();
    }

    public void runFunction() {
    }
}