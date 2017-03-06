package com.eshutech.biz.util.context;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.TypeReference;
import com.google.common.collect.Maps;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

public class ParamHelper {
    public static Long serialVersionD = Long.valueOf(0L);

    public static Map<String, Object> setString(Map<String, Object> params, String key, String value) {
        String[] str = {value};
        params.put(key, str);
        return params;
    }

    public static String getString(Map<String, Object> params, String key) {
        return getString(params, key, null);
    }

    public static String getString(Map<String, Object> params, String key, String defaultValue) {
        String temp = null;
        if (params.get(key) == null) {
            return defaultValue;
        }
        if (params.get(key).getClass().isArray()) {
            temp = getArray(params, key)[0];
        } else if (params.get(key) instanceof JSONArray) {
            return JSON.parseObject(JSON.toJSONString(params.get(key)), new TypeReference<String[]>() {
            })[0];
        } else {
            temp = params.get(key).toString();
        }
        if (temp != null) {
            temp = temp.replaceAll("%", "\\%");
        }
        if (temp == null) {
            return defaultValue;
        }
        return temp;
    }

    public static Double getDouble(Map<String, Object> params, String key) {
        return getDouble(params, key, null);
    }

    public static Double getDouble(Map<String, Object> params, String key, Double defaultValue) {
        String value = getString(params, key);

        Double i = defaultValue;
        if ((value == null) || (value.equals("")))
            return defaultValue;
        try {
            i = new Double(value);
        } catch (Exception e) {
            System.out.println("<ParamHelper error> - " + e.getMessage());
            i = defaultValue;
        }
        return i;
    }

    public static Integer getInteger(Map<String, Object> params, String key) {
        return getInteger(params, key, null);
    }

    public static Integer getInteger(Map<String, Object> params, String key, Integer defaultValue) {
        String value = getString(params, key);
        Integer i = defaultValue;
        i = defaultValue;
        if ((value == null) || (value.equals("")))
            return defaultValue;
        try {
            i = new Integer(value);
        } catch (NumberFormatException e) {
            System.out.println("<ParamHelper error> - " + e.getMessage());
        }
        return i;
    }

    public static Short getShort(Map<String, Object> params, String key) {
        return getShort(params, key, null);
    }

    public static Short getShort(Map<String, Object> params, String key, Short defaultValue) {
        String value = getString(params, key);
        Short i = defaultValue;
        i = defaultValue;
        if ((value == null) || (value.equals("")))
            return defaultValue;
        try {
            i = new Short(value);
        } catch (NumberFormatException e) {
            System.out.println("<ParamHelper error> - " + e.getMessage());
        }
        return i;
    }

    public static Long getLong(Map<String, Object> params, String key) {
        return getLong(params, key, null);
    }

    public static Long getLong(Map<String, Object> params, String key, Long defaultValue) {
        String value = getString(params, key);
        Long i = defaultValue;
        i = defaultValue;
        if ((value == null) || (value.equals("")))
            return defaultValue;
        try {
            i = new Long(value);
        } catch (NumberFormatException e) {
            System.out.println("<ParamHelper error> - " + e.getMessage());
        }
        return i;
    }

    public static Byte getByte(Map<String, Object> params, String key) {
        return getByte(params, key, null);
    }

    public static Byte getByte(Map<String, Object> params, String key, Byte defaultValue) {
        Byte value = defaultValue;
        String s = getString(params, key, null);
        if ((s == null) || (s.equals(""))) {
            return defaultValue;
        }
        if (s != null) {
            try {
                value = Byte.valueOf(s);
            } catch (NumberFormatException e) {
                System.out.println("<ParamHelper error> - " + e.getMessage());
            }
        }
        return value;
    }

    public static Boolean getBoolean(Map<String, Object> params, String key) {
        return getBoolean(params, key, null);
    }

    public static Boolean getBoolean(Map<String, Object> params, String key, Boolean defaultValue) {
        Boolean b = defaultValue;
        String s = getString(params, key, null);
        if ((s != null) && (!s.trim().equals(""))) {
            try {
                b = Boolean.valueOf((Boolean.valueOf(s).booleanValue()) || (s.equals("1")));
            } catch (NumberFormatException e) {
                System.out.println("<ParamHelper error> - " + e.getMessage());
            }
        }
        return b;
    }

    public static Date getDate(Map<String, Object> params, String key) {
        return getDate(params, key, null);
    }

    public static Date getDate(Map<String, Object> params, String key, Date defaultValue) {
        Date date = null;
        String d = getString(params, key);
        if ((d == null) || ("".equals(d)))
            date = defaultValue;
        else {
            try {
                date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(d);
            } catch (Exception e) {
                try {
                    date = new SimpleDateFormat("yyyy-MM-dd").parse(d);
                } catch (Exception ex) {
                    System.out.println("<ParamHelper error> - " + e.getMessage());
                    System.out.println("<ParamHelper error> - " + ex.getMessage());
                    date = defaultValue;
                }
            }
        }
        return date;
    }

    public static String[] getArray(Map<String, Object> params, String key) {
        return getArray(params, key, null);
    }

    public static String[] getArray(Map<String, Object> params, String key, String[] defaultValue) {
        if (params == null) {
            return defaultValue;
        }
        if (params.get(key) == null)
            return defaultValue;
        try {
            return (String[]) params.get(key);
        } catch (ClassCastException e) {
            System.out.println("<ParamHelper error> - " + e.getMessage());
        }
        return defaultValue;
    }

    public static Float getFloat(Map<String, Object> params, String key) {
        return getFloat(params, key, null);
    }

    public static Float getFloat(Map<String, Object> params, String key, Float defaultValue) {
        String s = getString(params, key);
        Float value = defaultValue;
        if ((s == null) || (s.equals(""))) {
            return defaultValue;
        }
        if (s != null) {
            try {
                value = Float.valueOf(s);
            } catch (Exception e) {
                System.out.println("<ParamHelper error> - " + e.getMessage());
                value = defaultValue;
            }
        }
        return value;
    }

    public static String getArrayToString(Map<String, Object> params, String key, String defaultParamName) {
        String[] args = getArray(params, key);
        String str = "";
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                str = str + (i == 0 ? "" : defaultParamName) + args[i];
            }
        }

        return str;
    }

    public static Map<String, Object> convertParamsMap(Map<String, String> params) {
        Map<String, Object> map = Maps.newHashMap();
        Iterator<String> iter = params.keySet().iterator();
        while (iter.hasNext()) {
            String key = (String) iter.next();
            String[] values = {(String) params.get(key)};
            map.put(key, values);
        }
        return map;
    }

    public static String getQueryString(Map<String, Object> params, String charset, String[] notAt) {
        String query = "";
        if (params == null) {
            return query;
        }
        Map<String, Boolean> notMap = Maps.newHashMap();
        for (String not : notAt) {
            notMap.put(not, Boolean.valueOf(true));
        }
        Iterator<String> iter = params.keySet().iterator();
        while (iter.hasNext()) {
            String key = (String) iter.next();
            String value = getString(params, key);
            if (notMap.get(key) == null) {
                if ((value != null) && (!value.equals(""))) {
                    try {
                        value = URLEncoder.encode(value, charset);
                    } catch (UnsupportedEncodingException e) {
                        System.out.println("<ParamHelper error> - " + e.getMessage());
                    }
                    if (!query.equals(""))
                        query = query + "&";
                    query = query + key + "=" + value;
                }
            }
        }
        return query;
    }
}