package com.eshutech.biz.util;

import com.eshutech.biz.factory.log.LogEx;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @Author:Lajiao
 * @Date:2014-08-29 09:12:21
 * @Description:Spring容器
 */
public class SpringUtils implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    public SpringUtils() {
    }

    public void setApplicationContext(ApplicationContext context) throws BeansException {
        applicationContext = context;
    }

    public static Object getBean(String name) {
        try {
            return applicationContext.getBean(name);
        } catch (Exception ex) {
            ex.printStackTrace();
            LogEx.BI("9005", "SpringUtils", name, "获取容器异常:[{}].[{}]", new Object[]{name, ex.getMessage()});
            return null;
        }
    }
}
