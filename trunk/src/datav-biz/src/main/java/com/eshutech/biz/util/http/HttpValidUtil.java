package com.eshutech.biz.util.http;


import com.eshutech.biz.util.StringUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 数据转化工具类
 *
 * @author Lajiao
 */
public class HttpValidUtil {
    private static final String regex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

    public static boolean validateUrl(String cert) {
        if (cert != null && !cert.trim().isEmpty()) {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(cert);
            return m.matches();
        } else {
            return false;
        }
    }

    public static String CreateLink(Map<String, String> params) {
        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);

        String prestr = "";
        for (int i = 0; i < keys.size(); i++) {
            String key = (String) keys.get(i);
            String value = (String) params.get(key);
            if (i == keys.size() - 1) {
                prestr = prestr + key + "=" + StringUtil.encodeUTF8(value);
            } else {
                prestr = prestr + key + "=" + StringUtil.encodeUTF8(value) + "&";
            }
        }
        return prestr;
    }

    public static void main(String[] args) {
        System.out.println(HttpValidUtil.validateUrl("httsps://www.baidu.com"));
    }
}
