/**
 * Copyright (c) 2014. Drore Co, Ltd. All rights reserved.
 * Filename: Validation
 * Creator:  wanggao
 * Create-Date: 下午11:07
 **/
package com.eshutech.utils;

import java.util.regex.Pattern;

/**
 * @author: Kim
 * @date: 14/11/30
 * @time: 下午11:07
 */
public class Validation {

    static String reg = "(?:')|(?:--)|(/\\*(?:.|[\\n\\r])*?\\*/)|" + "(\\b(select|update|and|or|delete|insert|trancate|char|into|substr|ascii|declare|exec|count|master|into|drop|execute)\\b)";
    static Pattern sqlPattern = Pattern.compile(reg, Pattern.CASE_INSENSITIVE);

    /**
     * Sql注入过滤
     * @param whereClause
     * @return
     */
    public static boolean DetectSqlInjection(String whereClause)
    {
        if (sqlPattern.matcher(whereClause).find()) {
            return false;
        }
        return true;
    }
}
