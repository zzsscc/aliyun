package com.eshutech.biz.util;

import com.google.common.base.Splitter;

import java.util.List;

/**
 * 数字签名
 */
public class SessionUtils {

    public static boolean SessionMatch(String sessions, String token) {
        if ("*".equals(sessions) || "ALL".equals(sessions)) {
            return true;
        }
        List<String> sessionList = Splitter.on(',').omitEmptyStrings().splitToList(sessions);
        if (sessionList.contains(token)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
    }
}