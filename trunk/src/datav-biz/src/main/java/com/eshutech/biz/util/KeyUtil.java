package com.eshutech.biz.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;


/**
 * @Author:Binwei.Chen
 * @Date:2015-05-06 14:32:47
 * @Description:机构工具类
 */
public class KeyUtil {

    public static String indistinct2(String value, Integer left, Integer right) {
        if (StringUtil.isEmpty(value)) {
            return value;
        }
        String rtn = "";
        int length = value.length();
        if (length > left) {
            rtn = rtn + value.substring(0, left);
        }
        rtn = rtn + "****";
        if (length > right) {
            rtn = rtn + value.substring(length - right, length);
        }
        return rtn;
    }

    public static String indistinct(String value, Integer left, Integer right) {
        if (StringUtil.isEmpty(value)) {
            return value;
        }
        int length = value.length();
        if (length > left) {
            value = m(left) + value.substring(left, value.length());
        } else {
            return m(left);
        }

        if (length > right) {
            value = value.substring(0, length - right) + m(right);
        } else {
            return m(right);
        }

        return value;
    }

    public static String jsonKey(String json, String key) {
        try {
            JSONObject jsonObject = JSON.parseObject(json);
            return jsonObject.getString(key);
        } catch (Exception ex) {
            return StringUtil.EMPTY;
        }
    }

    private static String m(int length) {
        StringBuffer rtn = new StringBuffer();
        for (int i = 0; i < length; i++) {
            rtn.append("*");
        }
        return rtn.toString();
    }

    public static void main(String[] args) {
        System.out.println(KeyUtil.indistinct("1231412412521521515", 4, 4));
    }
}
