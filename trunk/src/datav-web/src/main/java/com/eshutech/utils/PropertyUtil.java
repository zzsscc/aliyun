package com.eshutech.utils;

import java.io.IOException;
import java.util.Properties;

/**
 * 基础配置信息
 *
 * @author chand.chen
 */
public abstract class PropertyUtil {
    private static Properties pro = new Properties();

    static {
        try {
            pro.load(ResourcesLoader.getResource("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return pro.getProperty(key);
    }

    public static Integer getProInteger(String key) {
        return Integer.valueOf(pro.getProperty(key));
    }
}
