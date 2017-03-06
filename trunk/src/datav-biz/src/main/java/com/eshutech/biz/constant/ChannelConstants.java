package com.eshutech.biz.constant;

/**
 * @Author: Lajiao
 * @Date: 12-5-3
 * @Time: 下午5:37
 * @Description: to write something
 */
public class ChannelConstants {
    public static final int DEFAULT_PROVINCE_ID = -1;    // 全国
    public static final int DEFAULT_CITY_ID     = -1;    // 全市
    public static final int DEFAULT_PROVIDER_ID = -1;    // 全网通道

    /**
     * 运营商
     */
    public static class Provider {
        public static final int CHINA_MOBILE  = 0;
        public static final int CHINA_UNICOM  = 1;
        public static final int CHINA_TELECOM = 2;
        public static final int CHINA_TIETONG = 3;
    }
}
