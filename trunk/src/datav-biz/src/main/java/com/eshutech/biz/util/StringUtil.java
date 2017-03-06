/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: StringUtil
 * Creator:  wanggao
 * Create-Date: 上午10:32
 **/
package com.eshutech.biz.util;

/**
 *
 * @author: Kim
 * @date: 16/10/18
 * @time: 上午10:32
 *
 */
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class StringUtil {
    public static final String COMMA = ",";
    public static final String EMPTY = "";
    public static final String SINGLE_QUOTATION = "\'";
    public static final DecimalFormat df = new DecimalFormat("0.00");
    private static final byte UPPER_A = 65;
    private static final byte UPPER_Z = 90;
    private static final byte LOW_A = 97;
    private static final byte LOW_Z = 122;
    private static final byte TO_UPPER = 32;
    static byte ZERO = 48;
    static byte NIGHT = 57;

    public StringUtil() {
    }

    public static boolean equals(String a, String b) {
        return a == null?b == null:a.equals(b);
    }

    public static boolean equalsIgnoreCase(String a, String b) {
        return a == null?b == null:a.equalsIgnoreCase(b);
    }

    public static final List<String> stringToListString(String inStr, String split) {
        if(null != inStr && !"".equals(inStr)) {
            ArrayList rtn = new ArrayList();
            String[] arry = inStr.split(split);
            String[] arr$ = arry;
            int len$ = arry.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                String s = arr$[i$];
                rtn.add(s);
            }

            return rtn;
        } else {
            return null;
        }
    }

    public static final String ListStringToString(List<String> lst, String addStr) {
        if(null != lst && !lst.isEmpty()) {
            String rtn = "";

            String l;
            for(Iterator i$ = lst.iterator(); i$.hasNext(); rtn = rtn + addStr + l) {
                l = (String)i$.next();
            }

            return isEmpty(rtn)?rtn:rtn.substring(1);
        } else {
            return null;
        }
    }

    public static final List<Long> stringToListLong(String inStr) {
        if(null != inStr && !"".equals(inStr)) {
            ArrayList rtn = new ArrayList();
            String[] arry = inStr.split(",");
            String[] arr$ = arry;
            int len$ = arry.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                String s = arr$[i$];
                Long l = parseLong((String)s, (Long)null);
                if(l != null) {
                    rtn.add(l);
                }
            }

            return rtn;
        } else {
            return null;
        }
    }

    public static final List<Integer> stringToListInteger(String inStr) {
        if(null != inStr && !"".equals(inStr)) {
            ArrayList rtn = new ArrayList();
            String[] arry = inStr.split(",");
            String[] arr$ = arry;
            int len$ = arry.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                String s = arr$[i$];
                Integer l = parseInteger((String)s, (Integer)null);
                if(l != null) {
                    rtn.add(l);
                }
            }

            return rtn;
        } else {
            return null;
        }
    }

    public static final String ListIntegerToString(List<Integer> lst) {
        if(null != lst && !lst.isEmpty()) {
            String rtn = "";

            Integer l;
            for(Iterator i$ = lst.iterator(); i$.hasNext(); rtn = rtn + "," + l.toString()) {
                l = (Integer)i$.next();
            }

            return isEmpty(rtn)?rtn:rtn.substring(1);
        } else {
            return null;
        }
    }

    public static final String ListLongToString(List<Long> lst) {
        if(null != lst && !lst.isEmpty()) {
            String rtn = "";

            Long l;
            for(Iterator i$ = lst.iterator(); i$.hasNext(); rtn = rtn + "," + l.toString()) {
                l = (Long)i$.next();
            }

            return isEmpty(rtn)?rtn:rtn.substring(1);
        } else {
            return null;
        }
    }

    public static final String ListStringToString(List<String> lst) {
        if(null != lst && !lst.isEmpty()) {
            String rtn = "";

            String s;
            for(Iterator i$ = lst.iterator(); i$.hasNext(); rtn = rtn + "," + "\'" + s + "\'") {
                s = (String)i$.next();
            }

            return isEmpty(rtn)?rtn:rtn.substring(1);
        } else {
            return "\'\'";
        }
    }

    public static final String JsonArrayStringToString(String jsonString) {
        if(jsonString != null && !isEmpty(jsonString)) {
            String rtn = jsonString.replace("[", "").replace("]", "").replaceAll("\"", "");
            return rtn;
        } else {
            return null;
        }
    }

    public static boolean isBlank(String str) {
        int length;
        if(str != null && (length = str.length()) != 0) {
            for(int i = 0; i < length; ++i) {
                if(!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }

            return true;
        } else {
            return true;
        }
    }

    public static final boolean isEmpty(String inStr) {
        return null == inStr || "".equals(inStr.trim());
    }

    public static final boolean isNumeric(String inStr) {
        if(null != inStr && !"".equals(inStr.trim())) {
            Pattern pattern = Pattern.compile("[0-9]*");
            return pattern.matcher(inStr).matches();
        } else {
            return false;
        }
    }

    public static final Integer parseInteger(String inStr, Integer def) {
        try {
            return Integer.valueOf(inStr);
        } catch (Exception var3) {
            return def;
        }
    }

    public static final Long parseLong(String inStr, Long def) {
        try {
            return Long.valueOf(Long.parseLong(inStr));
        } catch (Exception var3) {
            return def;
        }
    }

    public static final Long parseLong(Object inObjece, Long def) {
        try {
            return Long.valueOf(Long.parseLong(String.valueOf(inObjece)));
        } catch (Exception var3) {
            return def;
        }
    }

    public static final Double parseDouble(String inStr, Double def) {
        try {
            return Double.valueOf(Double.parseDouble(inStr));
        } catch (Exception var3) {
            return def;
        }
    }

    public static final Integer parseInteger(Object obj, Integer def) {
        try {
            return Integer.valueOf(String.valueOf(obj));
        } catch (Exception var3) {
            return def;
        }
    }

    public static final Boolean parseBoolean(Object obj, Boolean def) {
        if(obj == null) {
            return def;
        } else {
            try {
                return Boolean.valueOf(obj.toString());
            } catch (Exception var3) {
                return def;
            }
        }
    }

    public static final String cutString(String name, Integer maxLength) {
        if(maxLength == null) {
            maxLength = Integer.valueOf(20);
        }

        if(name != null && name.length() >= 1) {
            Integer w = Integer.valueOf(0);
            Integer s = Integer.valueOf(0);
            boolean p = false;
            boolean b = false;
            String nameSub = "";

            for(int i = 0; i < name.length(); ++i) {
                if(i > 1 && !b) {
                    p = false;
                }

                if(i > 1 && b) {
                    p = true;
                }

                char c = name.charAt(i);
                if((c < 1 || c > 126) && ('｠' > c || c > 'ﾟ')) {
                    w = Integer.valueOf(w.intValue() + 2);
                    s = Integer.valueOf(s.intValue() + 1);
                    b = true;
                } else {
                    w = Integer.valueOf(w.intValue() + 1);
                    b = false;
                }

                if(w.intValue() > maxLength.intValue() && i <= name.length() - 1) {
                    if(b && p) {
                        nameSub = name.substring(0, i);
                    }

                    if(!b && !p) {
                        nameSub = name.substring(0, i - 1);
                    }

                    if(b && !p) {
                        nameSub = name.substring(0, i);
                    }

                    if(p) {
                        nameSub = name.substring(0, i);
                    }
                    break;
                }
            }

            return w.intValue() <= maxLength.intValue()?name:nameSub;
        } else {
            return "";
        }
    }

    public static final boolean containChineseWord(String str) {
        Pattern pattern = Pattern.compile("[\\u4e00-\\u9fa5]");
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }

    public static final String replaceSpecialSymbols(String content) {
        return content.replaceAll("\n|\r|\t|&nbsp;", "");
    }

    public static final String cutStringAddStr(String name, Integer maxLength) {
        if(maxLength == null) {
            maxLength = Integer.valueOf(20);
        }

        if(name != null && name.length() >= 1) {
            Integer w = Integer.valueOf(0);
            Integer s = Integer.valueOf(0);
            boolean p = false;
            boolean b = false;
            String addStr = "...";
            String nameSub = "";

            for(int i = 0; i < name.length(); ++i) {
                if(i > 1 && !b) {
                    p = false;
                }

                if(i > 1 && b) {
                    p = true;
                }

                char c = name.charAt(i);
                if((c < 1 || c > 126) && ('｠' > c || c > 'ﾟ')) {
                    w = Integer.valueOf(w.intValue() + 2);
                    s = Integer.valueOf(s.intValue() + 1);
                    b = true;
                } else {
                    w = Integer.valueOf(w.intValue() + 1);
                    b = false;
                }

                if(w.intValue() > maxLength.intValue() && i <= name.length() - 1) {
                    if(b && p) {
                        nameSub = name.substring(0, i - 2) + addStr;
                    }

                    if(!b && !p) {
                        nameSub = name.substring(0, i - 3) + addStr;
                    }

                    if(b && !p) {
                        nameSub = name.substring(0, i - 2) + addStr;
                    }

                    if(p) {
                        nameSub = name.substring(0, i - 2) + addStr;
                    }
                    break;
                }
            }

            return w.intValue() <= maxLength.intValue()?name:nameSub;
        } else {
            return "";
        }
    }

    public static final String decode(String str) {
        try {
            byte[] ex = str.getBytes("ISO-8859-1");
            return new String(ex, "utf-8");
        } catch (Exception var2) {
            return str;
        }
    }

    public static final Date parseDate(String value) {
        Date ret = null;

        try {
            SimpleDateFormat ex = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            ret = ex.parse(value);
        } catch (Exception var3) {
            var3.printStackTrace();
        }

        return ret;
    }

    public static final String native2ascii(String str) {
        if(str != null && !isEmpty(str)) {
            StringBuffer sb = new StringBuffer(1000);
            sb.setLength(0);

            for(int i = 0; i < str.length(); ++i) {
                char c = str.charAt(i);
                if(c > 255) {
                    sb.append("\\u");
                    int j = c >>> 8;
                    String tmp = Integer.toHexString(j);
                    if(tmp.length() == 1) {
                        sb.append("0");
                    }

                    sb.append(tmp);
                    j = c & 255;
                    tmp = Integer.toHexString(j);
                    if(tmp.length() == 1) {
                        sb.append("0");
                    }

                    sb.append(tmp);
                } else {
                    sb.append(c);
                }
            }

            return new String(sb);
        } else {
            return str;
        }
    }

    public static final String encodeUTF8(String str) {
        if(str != null && !isEmpty(str)) {
            try {
                return URLEncoder.encode(str, "UTF-8").replace("+", " ");
            } catch (UnsupportedEncodingException var2) {
                var2.printStackTrace();
                return str;
            }
        } else {
            return str;
        }
    }

    public static final String sqrt(String str) {
        if(isEmpty(str)) {
            return str;
        } else {
            try {
                return df.format(Double.valueOf(str));
            } catch (Exception var2) {
                return str;
            }
        }
    }

    public static final Date parseData(String value, String format) {
        try {
            SimpleDateFormat ex = new SimpleDateFormat(format);
            return ex.parse(value);
        } catch (Exception var3) {
            return null;
        }
    }

    public static final Date parseData(Object value, String format) {
        try {
            SimpleDateFormat ex = new SimpleDateFormat(format);
            return ex.parse(value.toString());
        } catch (Exception var3) {
            return null;
        }
    }

    public static final String percent(Object dividend, Object divisor) {
        try {
            double ex = parseDouble(dividend.toString(), Double.valueOf(0.0D)).doubleValue();
            double divisor_d = parseDouble(divisor.toString(), Double.valueOf(0.0D)).doubleValue();
            if(ex > 0.0D && divisor_d > 0.0D) {
                Double d = Double.valueOf(ex * 100.0D / divisor_d);
                DecimalFormat decimalFormat = new DecimalFormat("##.##");
                decimalFormat.setMinimumFractionDigits(2);
                String rtn = decimalFormat.format(d).replace(".00", "");
                return rtn;
            } else {
                return "0.00";
            }
        } catch (Exception var9) {
            return "0.00";
        }
    }

    public static final String price(Object dividend) {
        try {
            double ex = parseDouble(dividend.toString(), Double.valueOf(0.0D)).doubleValue();
            Double d = Double.valueOf(ex / 100.0D);
            DecimalFormat decimalFormat = new DecimalFormat("##.##");
            decimalFormat.setMinimumFractionDigits(2);
            String rtn = decimalFormat.format(d).replace(".00", "");
            return rtn;
        } catch (Exception var6) {
            return "0";
        }
    }

    public static final String rateFee(Object dividend) {
        try {
            double ex = parseDouble(dividend.toString(), Double.valueOf(0.0D)).doubleValue();
            if(ex <= 0.0D) {
                return "0.01";
            } else {
                Double d = Double.valueOf(ex / 100.0D);
                if(d.doubleValue() <= 0.0D) {
                    return "0.01";
                } else {
                    String[] array = String.valueOf(d).split("\\.");
                    if(array.length != 2) {
                        return price(dividend);
                    } else {
                        StringBuffer rtn = new StringBuffer();
                        rtn.append(array[0]);
                        switch(array[1].length()) {
                            case 1:
                                if(!"0".equals(array[1])) {
                                    rtn.append(".");
                                    rtn.append(array[1]);
                                }
                                break;
                            case 2:
                                if(!"00".equals(array[1])) {
                                    rtn.append(".");
                                    rtn.append(array[1]);
                                }
                                break;
                            default:
                                if("00".equals(array[1].substring(0, 2))) {
                                    rtn.append(".01");
                                } else {
                                    rtn.append(".");
                                    rtn.append(array[1].substring(0, 2));
                                }
                        }

                        return rtn.toString();
                    }
                }
            }
        } catch (Exception var6) {
            return "0.01";
        }
    }

    public static String matchString(String value, String rs, String re) {
        try {
            String ex = null;
            int start = value.indexOf(rs);
            if(start >= 0) {
                ex = value.substring(start);
            }

            int end = ex.indexOf(re);
            return ex.substring(rs.length(), end);
        } catch (Exception var6) {
            return null;
        }
    }

    public static void main(String[] args) {
        System.err.println(price("-5012"));
    }

    public static boolean isUpper(String data) {
        char[] arr$ = data.toCharArray();
        int len$ = arr$.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            char item = arr$[i$];
            if(item < 65 || item > 90) {
                return false;
            }
        }

        return true;
    }

    public static String changeHungaryToCamel(String stringValue) {
        if(stringValue.indexOf("_") >= 0 || isUpper(stringValue)) {
            stringValue = stringValue.toLowerCase();
            boolean _index = false;

            String oldChar;
            String newChar;
            int _index1;
            for(int valLength = stringValue.length(); (_index1 = stringValue.indexOf(95)) >= 0; stringValue = stringValue.replace(oldChar, newChar)) {
                if(_index1 + 1 < valLength && stringValue.charAt(_index1 + 1) >= 97 && stringValue.charAt(_index1 + 1) <= 122) {
                    oldChar = new String(new char[]{'_', stringValue.charAt(_index1 + 1)});
                    newChar = new String(new char[]{(char)(stringValue.charAt(_index1 + 1) - 32)});
                } else {
                    oldChar = new String(new char[]{'_'});
                    newChar = "";
                }
            }
        }

        return stringValue;
    }

    public static String changeCamelToHungary(String stringValue) {
        String oldChar;
        String newChar;
        int _index1;
        if(stringValue.indexOf("_") < 0) {
            for(boolean _index = false; (_index1 = indexOfUpper(stringValue)) >= 0; stringValue = stringValue.replace(oldChar, newChar)) {
                oldChar = new String(new char[]{stringValue.charAt(_index1)});
                newChar = new String(new char[]{'_', (char)(stringValue.charAt(_index1) + 32)});
            }
        }

        return stringValue.toUpperCase();
    }

    private static int indexOfUpper(String stringValue) {
        char[] cs = stringValue.toCharArray();

        for(int i = 0; i < cs.length; ++i) {
            if(cs[i] >= 65 && cs[i] <= 90) {
                return i;
            }
        }

        return -1;
    }

    public static boolean notEmpty(String data) {
        return !isEmpty(data);
    }

    public static Map<String, String> changeHungaryToCamel(Map<String, String> groupDate) {
        LinkedHashMap newDate = new LinkedHashMap();
        Iterator i$ = groupDate.entrySet().iterator();

        while(i$.hasNext()) {
            Entry item = (Entry)i$.next();
            newDate.put(changeHungaryToCamel((String)item.getKey()), item.getValue());
        }

        groupDate.clear();
        return newDate;
    }

    public static String addLastDot(String string, int lastIndex) {
        StringBuilder builder = new StringBuilder(string);
        boolean isNeg = false;
        if(builder.charAt(0) == 45) {
            builder = builder.delete(0, 1);
            isNeg = true;
        }

        int length = builder.length();

        for(int i = 0; i <= lastIndex - length; ++i) {
            builder.insert(0, '0');
        }

        builder.insert(builder.length() - lastIndex, '.');
        if(isNeg) {
            builder.insert(0, '-');
        }

        return builder.toString();
    }

    public static String append(String string, char appendChar, int length) {
        char[] c = new char[length];
        Arrays.fill(c, appendChar);
        string = string == null?"":string;
        StringBuilder builder = new StringBuilder(string.length() + length + 1);
        return builder.append(string).append(c).toString();
    }

    public static String coverLastChar(String string, char coverChar, int length) {
        if(string != null && string.length() >= length) {
            char[] c = new char[length];
            Arrays.fill(c, coverChar);
            StringBuilder builder = new StringBuilder(string);
            return builder.replace(builder.length() - length, builder.length(), new String(c)).toString();
        } else {
            return string;
        }
    }

    public static String coverFirst(String string, String cover) {
        if(string != null && string.length() >= cover.length()) {
            StringBuilder builder = new StringBuilder(string);
            return builder.replace(0, cover.length(), cover).toString();
        } else {
            return string;
        }
    }

    public static String coverFirst(String string, char cover) {
        if(string != null && string.length() >= 1) {
            StringBuilder builder = new StringBuilder(string);
            builder.setCharAt(0, cover);
            return builder.toString();
        } else {
            return string;
        }
    }

    public static String deleteFirst(String string, int length) {
        if(string != null && string.length() >= length) {
            StringBuilder builder = new StringBuilder(string);
            return builder.delete(0, length).toString();
        } else {
            return string;
        }
    }

    public static char toUpper(char c) {
        return c >= 97 && c <= 122?(char)(c - 32):c;
    }

    public static char toLower(char c) {
        return c >= 65 && c <= 90?(char)(c + 32):c;
    }

    public static String insert(String string, char insertVal, int length) {
        char[] c = new char[length];
        Arrays.fill(c, insertVal);
        return string != null?(new StringBuilder(string.length() + length)).append(c).append(string).toString():null;
    }

    public static boolean isInteger(String innerItem) {
        if(isEmpty(innerItem)) {
            return false;
        } else {
            char[] cs = innerItem.toCharArray();
            int i = 0;
            if(cs[0] == 45 && cs.length >= 2) {
                i = 1;
            }

            while(i < cs.length) {
                char c = cs[i];
                if(c < ZERO || c > NIGHT) {
                    return false;
                }

                ++i;
            }

            return true;
        }
    }

    public static boolean isDouble(String innerItem) {
        if(innerItem == null) {
            return false;
        } else {
            boolean hasDot = false;
            char[] cs = innerItem.toCharArray();
            int i = 0;
            if(cs[0] == 45 && cs.length >= 2) {
                i = 1;
            }

            for(; i < cs.length; ++i) {
                char c = cs[i];
                if(c < ZERO || c > NIGHT) {
                    if(hasDot || c != 46) {
                        return false;
                    }

                    hasDot = true;
                }
            }

            return true;
        }
    }

    public static boolean isDouble(String innerItem, int n) {
        if(innerItem == null) {
            return false;
        } else {
            boolean hasDot = false;
            char[] cs = innerItem.toCharArray();
            int i = 0;
            if(cs[0] == 45 && cs.length >= 2) {
                i = 1;
            }

            for(; i < cs.length; ++i) {
                char c = cs[i];
                if(c < ZERO || c > NIGHT) {
                    if(hasDot || c != 46) {
                        return false;
                    }

                    hasDot = true;
                }
            }

            return true;
        }
    }

    public static String format(String msg, String key, Object value) {
        return msg.replaceAll("\\{" + key + "\\}", String.valueOf(value == null?"":value));
    }

    public static String removePlaceholder(String msg) {
        return msg.replaceAll("\\{(.*?)\\}", "");
    }

    public static String appendLeft(char c, int length, Object content) {
        String result = String.valueOf(content);
        length -= result.length();
        Object cs = null;
        if(length > 0) {
            char[] cs1 = new char[length];
            Arrays.fill(cs1, c);
            return (new StringBuilder(length + result.length())).append(cs1).append(result).toString();
        } else {
            return result;
        }
    }

    public static Map<String, String> toQueryMap(String paramStr) {
        String[] vals = split(paramStr, "&");
        HashMap resultMap = new HashMap(vals.length);

        for(int i = 0; i < vals.length; ++i) {
            int index = vals[i].indexOf("=");
            resultMap.put(vals[i].substring(0, index), vals[i].substring(index + 1, vals[i].length()));
        }

        return resultMap;
    }

    public static String[] split(String msg, String cut) {
        int index = 0;
        int befault = 0;
        int i = 0;
        ArrayList l = new ArrayList(128);

        do {
            index = msg.indexOf(cut, index);
            l.add(msg.substring(befault, index == -1?msg.length():index));
            ++i;
            ++index;
            befault = index + cut.length() - 1;
        } while(index > 0 && index < msg.length());

        return (String[])l.toArray(new String[l.size()]);
    }

    public static String nullToEmpty(Object value) {
        return value == null?"":value.toString().trim();
    }

    public static String decodeUnicode(String theString) {
        if(theString.contains("&#x")) {
            theString = theString.replaceAll("&#x", "\\\\u").replaceAll(";", "");
        }

        int len = theString.length();
        StringBuffer outBuffer = new StringBuffer(len);
        int x = 0;

        while(true) {
            while(true) {
                while(x < len) {
                    char aChar = theString.charAt(x++);
                    if(aChar == 92) {
                        aChar = theString.charAt(x++);
                        if(aChar == 117) {
                            int value = 0;

                            for(int i = 0; i < 4; ++i) {
                                aChar = theString.charAt(x++);
                                switch(aChar) {
                                    case '0':
                                    case '1':
                                    case '2':
                                    case '3':
                                    case '4':
                                    case '5':
                                    case '6':
                                    case '7':
                                    case '8':
                                    case '9':
                                        value = (value << 4) + aChar - 48;
                                        break;
                                    case ':':
                                    case ';':
                                    case '<':
                                    case '=':
                                    case '>':
                                    case '?':
                                    case '@':
                                    case 'G':
                                    case 'H':
                                    case 'I':
                                    case 'J':
                                    case 'K':
                                    case 'L':
                                    case 'M':
                                    case 'N':
                                    case 'O':
                                    case 'P':
                                    case 'Q':
                                    case 'R':
                                    case 'S':
                                    case 'T':
                                    case 'U':
                                    case 'V':
                                    case 'W':
                                    case 'X':
                                    case 'Y':
                                    case 'Z':
                                    case '[':
                                    case '\\':
                                    case ']':
                                    case '^':
                                    case '_':
                                    case '`':
                                    default:
                                        throw new IllegalArgumentException("Malformed   \\uxxxx   encoding.");
                                    case 'A':
                                    case 'B':
                                    case 'C':
                                    case 'D':
                                    case 'E':
                                    case 'F':
                                        value = (value << 4) + 10 + aChar - 65;
                                        break;
                                    case 'a':
                                    case 'b':
                                    case 'c':
                                    case 'd':
                                    case 'e':
                                    case 'f':
                                        value = (value << 4) + 10 + aChar - 97;
                                }
                            }

                            outBuffer.append((char)value);
                        } else {
                            if(aChar == 116) {
                                aChar = 9;
                            } else if(aChar == 114) {
                                aChar = 13;
                            } else if(aChar == 110) {
                                aChar = 10;
                            } else if(aChar == 102) {
                                aChar = 12;
                            }

                            outBuffer.append(aChar);
                        }
                    } else {
                        outBuffer.append(aChar);
                    }
                }

                return outBuffer.toString();
            }
        }
    }

    public static String UrlDecode(String value) {
        try {
            return URLDecoder.decode(value, "utf-8");
        } catch (Exception var2) {
            return value;
        }
    }

    public static String UrlEncode(String value) {
        try {
            return URLEncoder.encode(value, "utf-8");
        } catch (Exception var2) {
            return value;
        }
    }
}