package com.eshutech.biz.util;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 数据转化工具类
 *
 * @author Lajiao
 */
public class CertificateUtil {

    public static final Map<String, String> map = Maps.newHashMap();

    static {
        map.put("11", "北京");
        map.put("12", "天津");
        map.put("13", "河北");
        map.put("14", "山西");
        map.put("15", "内蒙古");
        map.put("21", "辽宁");
        map.put("22", "吉林");
        map.put("23", "黑龙江");
        map.put("31", "上海");
        map.put("32", "江苏");
        map.put("33", "浙江");
        map.put("34", "安徽");
        map.put("35", "福建");
        map.put("36", "江西");
        map.put("37", "山东");
        map.put("41", "河南");
        map.put("42", "湖北");
        map.put("43", "湖南");
        map.put("44", "广东");
        map.put("45", "广西");
        map.put("46", "海南");
        map.put("50", "重庆");
        map.put("51", "四川");
        map.put("52", "贵州");
        map.put("53", "云南");
        map.put("54", "西藏");
        map.put("61", "陕西");
        map.put("62", "甘肃");
        map.put("63", "青海");
        map.put("64", "宁夏");
        map.put("65", "新疆");
        map.put("71", "台湾");
        map.put("81", "香港");
        map.put("91", "澳门");
    }

    public static String getProvinceName(String code) {
        if (code == null || code.length() <= 2) {
            return "";
        }
        return map.get(code.substring(0, 2));
    }

    public static String getProvinceId(String name) {
        Set<String> keyset = map.keySet();
        for (String key : keyset) {
            if (name.contains(map.get(key))) {
                return key;
            }
        }
        return null;
    }

    public static boolean validateCert(String cert) {
        if (cert != null && !cert.trim().isEmpty()) {
            Pattern p = Pattern.compile("(\\d{14}[0-9a-zA-Z])|(\\d{17}[0-9a-zA-Z])");
            Matcher m = p.matcher(cert);
            return m.matches();
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(CertificateUtil.getProvinceName("331023"));
    }
}
