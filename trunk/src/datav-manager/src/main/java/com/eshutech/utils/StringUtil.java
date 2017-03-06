package com.eshutech.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class StringUtil {

    public static final DecimalFormat decimalFormat = new DecimalFormat(
            "##.##");
    public static final String COMMA = ",";
    public static final String EMPTY = "";
    public static final String PID_REGEX = "pid=";
    public static final String P_REGEX = "p=";
    public static final String PID_CHG_REGEX = "(pid=)(.*?)(&|$)";
    public static final String P_CHG_REGEX = "(p=)(.*?)(&|$)";
    public static final String SINGLE_QUOTATION = "\'";

    private static final DecimalFormat df = new DecimalFormat(
            "0.00");
    private static final String urlPattern = "http://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";

    /**
     * 字符串转LIST<String>
     */
    public final static List<String> stringToListString(String inStr,
                                                        String split) {
        if (null == inStr || EMPTY.equals(inStr)) {
            return null;
        }

        List<String> rtn = new ArrayList<String>();
        String[] arry = inStr.split(split);
        for (String s : arry) {
            rtn.add(s);
        }
        return rtn;
    }

    /**
     * LIST<String>转字符串
     */
    public final static String ListStringToString(List<String> lst,
                                                  String addStr) {
        if (null == lst || lst.isEmpty()) {
            return null;
        }

        String rtn = "";
        for (String l : lst) {
            if (l == null || l.isEmpty()) {
                continue;
            }
            rtn = rtn + addStr + l;
        }
        return isEmpty(rtn) ? rtn : rtn.substring(1);
    }

    /**
     * 字符串转LIST<Long>
     */
    public final static List<Long> stringToListLong(String inStr) {
        if (null == inStr || EMPTY.equals(inStr)) {
            return null;
        }

        List<Long> rtn = new ArrayList<Long>();
        Long l;
        String[] arry = inStr.split(COMMA);
        for (String s : arry) {
            l = parseLong(s, null);
            if (l != null) {
                rtn.add(l);
            }
        }
        return rtn;
    }

    /**
     * 字符串转LIST<Long>
     */
    public final static String ListLongToString(List<Long> lst) {
        if (null == lst || lst.isEmpty()) {
            return null;
        }

        String rtn = "";
        for (Long l : lst) {
            if (l == null) {
                continue;
            }
            rtn = rtn + COMMA + l.toString();
        }
        return isEmpty(rtn) ? rtn : rtn.substring(1);
    }

    public final static String ListStringToString(List<String> lst) {
        if (null == lst || lst.isEmpty()) {
            return "\'\'";
        }

        String rtn = "";
        for (String s : lst) {
            if (s == null || s.isEmpty()) {
                continue;
            }
            rtn = rtn + COMMA + SINGLE_QUOTATION + s + SINGLE_QUOTATION;
        }
        return isEmpty(rtn) ? rtn : rtn.substring(1);
    }

    /**
     * JSON格式List<String>转换
     *
     * @param jsonString
     * @return
     */
    public final static String JsonArrayStringToString(String jsonString) {
        String rtn;
        if (jsonString == null || jsonString.isEmpty()) {
            return null;
        }
        rtn = jsonString.replace("[", "").replace("]", "").replaceAll("\"", "");
        return rtn;
    }

    /**
     * 判断字符串是否为空(true:为空 false:不为空)
     *
     * @param inStr
     * @return
     */
    public final static boolean isEmpty(String inStr) {
        if (null == inStr || EMPTY.equals(inStr)) {
            return true;
        }
        return false;
    }

    /**
     * 判断字符串是否为数字(true:为空 false:不为空)
     *
     * @param inStr
     * @return
     */
    public final static boolean isNumeric(String inStr) {
        if (null == inStr || EMPTY.equals(inStr.trim())) {
            return false;
        }
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(inStr).matches();
    }

    /**
     * 字符串转化Integer类型
     *
     * @param inStr
     * @param def
     * @return
     */
    public final static Integer parseInteger(String inStr, Integer def) {
        try {
            return Integer.valueOf(inStr);
        } catch (Exception ex) {
            return def;
        }
    }

    /**
     * 字符串转化LONG类型
     *
     * @param inStr
     * @param def
     * @return
     */
    public final static Long parseLong(String inStr, Long def) {
        try {
            return Long.parseLong(inStr);
        } catch (Exception ex) {
            return def;
        }
    }

    /**
     * 字符串转化Double类型
     *
     * @param inStr
     * @param def
     * @return
     */
    public final static Double parseDouble(String inStr, Double def) {
        try {
            return Double.parseDouble(inStr);
        } catch (Exception ex) {
            return def;
        }
    }

    /**
     * 转化字符为数字（不符合条件的返回默认值）
     *
     * @param obj
     * @param def
     * @return
     */
    public final static Integer parseInteger(Object obj, Integer def) {
        try {
            return Integer.valueOf(String.valueOf(obj));
        } catch (Exception ex) {
            return def;
        }
    }

    /**
     * 转化字符为布尔数学（不符合条件的返回默认值）
     *
     * @param obj
     * @param def
     * @return
     */
    public final static Boolean parseBoolean(Object obj, Boolean def) {
        if (obj == null) {
            return def;
        }
        try {
            return Boolean.valueOf((String) obj);
        } catch (Exception ex) {
            return def;
        }
    }

    /**
     * 截取字符串,后面添加...
     *
     * @param name
     * @param maxLength
     * @return
     */
    public final static String cutString(String name, Integer maxLength) {
        if (maxLength == null) {
            maxLength = 20;
        }
        if (name == null || name.length() < 1) {
            return "";
        }

        Integer w = 0;// 字符串长度，一个汉字长度为2
        Integer s = 0;// 汉字个数
        boolean p = false;// 判断字符串当前循环的前一个字符是否为汉字
        boolean b = false;// 判断字符串当前循环的字符是否为汉字
        String nameSub = "";

        for (int i = 0; i < name.length(); i++) {
            if (i > 1 && b == false) {
                p = false;
            }
            if (i > 1 && b == true) {
                p = true;
            }

            char c = name.charAt(i);
            // 单字节加1
            if ((c >= 0x0001 && c <= 0x007e) || (0xff60 <= c && c <= 0xff9f)) {
                w++;
                b = false;
            } else {
                w += 2;
                s++;
                b = true;
            }
            if (w > maxLength && i <= name.length() - 1) {
                if (b == true && p == true) {
                    nameSub = name.substring(0, i);
                }
                if (b == false && p == false) {
                    nameSub = name.substring(0, i - 1);
                }
                if (b == true && p == false) {
                    nameSub = name.substring(0, i);
                }
                if (p == true) {
                    nameSub = name.substring(0, i);
                }
                break;
            }
        }
        if (w <= maxLength) {
            return name;
        }
        return nameSub;
    }

    /**
     * 判断字符串中是否包含中文字符
     *
     * @param str
     * @return
     */
    public final static boolean containChineseWord(String str) {
        Pattern pattern = Pattern.compile("[\\u4e00-\\u9fa5]");
        Matcher matcher = pattern.matcher(str);

        return matcher.find();
    }

    /**
     * 去除空格 换行符等
     *
     * @param content
     * @return
     */
    public final static String replaceSpecialSymbols(String content) {
        return content.replaceAll("\n|\r|\t|&nbsp;", "");
    }

    /**
     * 截取字符串,后面添加...
     *
     * @param name
     * @param maxLength
     * @return
     */
    public final static String cutStringAddStr(String name, Integer maxLength) {
        if (maxLength == null) {
            maxLength = 20;
        }
        if (name == null || name.length() < 1) {
            return "";
        }

        Integer w = 0;// 字符串长度，一个汉字长度为2
        Integer s = 0;// 汉字个数
        boolean p = false;// 判断字符串当前循环的前一个字符是否为汉字
        boolean b = false;// 判断字符串当前循环的字符是否为汉字
        String addStr = "...";
        String nameSub = "";

        for (int i = 0; i < name.length(); i++) {
            if (i > 1 && b == false) {
                p = false;
            }
            if (i > 1 && b == true) {
                p = true;
            }

            char c = name.charAt(i);
            // 单字节加1
            if ((c >= 0x0001 && c <= 0x007e) || (0xff60 <= c && c <= 0xff9f)) {
                w++;
                b = false;
            } else {
                w += 2;
                s++;
                b = true;
            }
            if (w > maxLength && i <= name.length() - 1) {
                if (b == true && p == true) {
                    nameSub = name.substring(0, i - 2) + addStr;
                }
                if (b == false && p == false) {
                    nameSub = name.substring(0, i - 3) + addStr;
                }
                if (b == true && p == false) {
                    nameSub = name.substring(0, i - 2) + addStr;
                }
                if (p == true) {
                    nameSub = name.substring(0, i - 2) + addStr;
                }
                break;
            }
        }
        if (w <= maxLength) {
            return name;
        }
        return nameSub;
    }

    /**
     * 中文转换
     *
     * @param str
     * @return
     */
    public final static String decode(String str) {
        try {
            byte[] unicode = str.getBytes("ISO-8859-1");
            return new String(unicode, "utf-8");
        } catch (Exception ex) {
            return str;
        }
    }

    /**
     * 字符转化为DATE格式(yyyy-MM-dd HH:mm:ss)
     *
     * @param value
     * @return
     */
    public final static Date parseDate(String value) {
        Date ret = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            ret = sdf.parse(value);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ret;
    }

    /**
     * native2ascii转码
     *
     * @param str
     * @return
     */
    public final static String native2ascii(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        String tmp;
        StringBuffer sb = new StringBuffer(1000);
        char c;
        int i, j;
        sb.setLength(0);
        for (i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            if (c > 255) {
                sb.append("\\u");
                j = (c >>> 8);
                tmp = Integer.toHexString(j);
                if (tmp.length() == 1)
                    sb.append("0");
                sb.append(tmp);
                j = (c & 0xFF);
                tmp = Integer.toHexString(j);
                if (tmp.length() == 1)
                    sb.append("0");
                sb.append(tmp);
            } else {
                sb.append(c);
            }

        }
        return (new String(sb));
    }

    /**
     * @param str
     * @return
     */
    public final static String encodeUTF8(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "UTF-8").replace("+", " ");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * 保留两位小数
     */
    public final static String sqrt(String str) {
        if (isEmpty(str)) {
            return str;
        }
        try {
            return df.format(Double.valueOf(str));
        } catch (Exception ex) {
            return str;
        }
    }

    public final static String sqrt(String str, Double divider) {
        Double d = StringUtil.parseDouble(str, 0d) / 100.00d;
        decimalFormat.setMinimumFractionDigits(2);
        return decimalFormat.format(d);
    }

    /**
     * 判断日期类型
     *
     * @param value
     * @param format
     * @return
     */
    public final static Date parseData(String value, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.parse(value);
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * 验证邮箱地址是否合法
     *
     * @param email
     * @return
     */
    public static boolean isEmail(String email) {
        String regex = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);
        return m.find();
    }

    public static boolean isMobile(String mobiles) {
        Pattern p = Pattern
                .compile("^0{0,1}((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }

    public static String getExtensionName(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot > -1) && (dot < (filename.length() - 1))) {
                return filename.substring(dot + 1);
            }
        }
        return filename;
    }

    public static String getNoExtensionName(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot > -1) && (dot < (filename.length() - 1))) {
                return filename.substring(0, dot);
            }
        }
        return filename;
    }


    public static String lastMonthFirstDay()
    {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        return format.format(calendar.getTime());
    }

    public static String lastMonthLastDay()
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DATE, -1);
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        return format.format(calendar.getTime());
    }

    public static String lastMonthFirstDay2()
    {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(calendar.getTime());
    }

    public static String lastMonthLastDay2()
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DATE, -1);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(calendar.getTime());
    }

    public static String lastMonthFirstDay3(String sssqq)
    {
        String result = sssqq.substring(0,4)+"-"+sssqq.substring(4,6)+"-"+sssqq.substring(6,8);
        return result;
    }

    public static String lastMonthLastDay3(String sssqz)
    {
        String result = sssqz.substring(0,4)+"-"+sssqz.substring(4,6)+"-"+sssqz.substring(6,8);
        return result;
    }


    public static String[] chars = new String[] { "a", "b", "c", "d", "e", "f",
            "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
            "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z" };


    public static String generateShortUuid() {
        StringBuffer shortBuffer = new StringBuffer();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < 16; i++) {
            String str = uuid.substring(i * 2, i * 2 + 2);
            int x = Integer.parseInt(str, 16);
            shortBuffer.append(chars[x % 0x3E]);
        }
        return shortBuffer.toString().toUpperCase();

    }
}
