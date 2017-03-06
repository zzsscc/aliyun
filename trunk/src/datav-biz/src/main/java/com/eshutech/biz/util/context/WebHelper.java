package com.eshutech.biz.util.context;

import com.eshutech.biz.util.Digests;
import com.eshutech.biz.util.EncodeUtils;
import com.google.common.collect.Maps;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.eshutech.biz.constant.Constants.HASH_INTERATIONS;

public class WebHelper {
    public static String serialVersionB = "2E6C617A7933712E636F6";

    static ThreadLocal<Map<Object, Object>> threadLocal = new ThreadLocal<Map<Object, Object>>();

    public static char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static void setLocal(Object key, Object object) {
        getLocal().put(key, object);
    }

    public static Map<Object, Object> getLocal() {
        Map<Object, Object> map = threadLocal.get();
        if (map == null) {
            map = Maps.newHashMap();
            threadLocal.set(map);
        }
        return map;
    }

    public static String getUrlPath() {
        HttpServletRequest request = WebContext.getServletRequest();

        String path = request.getContextPath();
        String port = "";
        if (request.getServerPort() != 80)
            port = ":" + request.getServerPort();
        return request.getScheme() + "://" + request.getServerName() + port + path + "/" + request.getServletPath();
    }

    public static Cookie getCookie(String path, String key) {
        HttpServletRequest request = WebContext.getServletRequest();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies)
                if ((cookie.getName().equals(key)) && (equals(cookie.getPath(), path).booleanValue()))
                    return cookie;
        }
        return null;
    }

    public static String getCookieValue(String path, String key) {
        Cookie cookie = getCookie(path, key);
        if (cookie != null)
            return cookie.getValue();
        return null;
    }

    public static void setCookie(String path, String key, String value) {
        HttpServletResponse response = WebContext.getServletResponse();
        Cookie cookie = new Cookie(key, value);
        cookie.setMaxAge(2592000);
        cookie.setPath(path);
        response.addCookie(cookie);
    }

    public static void delCookie(String path, String key) {
        HttpServletResponse response = WebContext.getServletResponse();
        HttpServletRequest request = WebContext.getServletRequest();
        Cookie[] cookies = request.getCookies();
        if (cookies != null)
            for (Cookie cookie : cookies) {
                String strCookieName = cookie.getName();
                if ((strCookieName.equals(key)) && (equals(cookie.getPath(), path).booleanValue())) {
                    cookie.setMaxAge(0);
                    cookie.setPath(path);
                    response.addCookie(cookie);
                }
            }
    }

    public static Boolean equals(String v1, String v2) {
        if ((v1 == null) && (v2 == null))
            return Boolean.valueOf(true);
        if ((v1 != null) && (v2 != null) && (v1.equals(v2))) {
            return Boolean.valueOf(true);
        }
        return Boolean.valueOf(false);
    }

    public static <T> T getSession(String key) {
        return getSession(key, null);
    }

    @SuppressWarnings("unchecked")
    public static <T> T getSession(String key, Object defaultValue) {
        HttpServletRequest request = WebContext.getServletRequest();
        HttpSession session = request.getSession();
        Object value = session.getAttribute(key);
        return (T) (value == null ? defaultValue : value);
    }

    public static void setSession(String key, Object value) {
        HttpServletRequest request = WebContext.getServletRequest();
        HttpSession session = request.getSession();
        if (value == null)
            removeSession(key);
        else
            session.setAttribute(key, value);
    }

    public static void removeSession(String key) {
        HttpServletRequest request = WebContext.getServletRequest();
        HttpSession session = request.getSession();
        session.removeAttribute(key);
    }

    public static void SetTips(String tips) {
        if (tips == null)
            return;
        HttpServletRequest request = WebContext.getServletRequest();
        HttpSession session = request.getSession();
        session.setAttribute("tips", new Tips(tips));
    }

    public static Tips GetTips() {
        HttpServletRequest request = WebContext.getServletRequest();
        HttpSession session = request.getSession();
        return (Tips) session.getAttribute("tips");
    }

    public static int rand(Integer iMax) {
        return Math.abs(new Random().nextInt() % iMax.intValue());
    }

    public static String date(Date date, String format) {
        String dateStr = "";
        if (date == null)
            date = new Date();
        try {
            SimpleDateFormat DF = new SimpleDateFormat(format);
            dateStr = DF.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dateStr;
    }

    public static Date date(String date, String format) {
        if ((date == null) || (date.equals("")))
            return null;
        if ((format == null) || (format.equals("")))
            return null;
        try {
            return new SimpleDateFormat(format).parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String zerofill(Object value, Integer max) {
        if (value == null)
            return "";
        String strValue = value.toString();
        if (strValue.length() >= max.intValue())
            return strValue;
        String strZero = "";
        for (int i = 0; i < max.intValue() - strValue.length(); i++)
            strZero = strZero + "0";
        return strZero + strValue;
    }

    public static String uuid() {
        String strUUID = UUID.randomUUID().toString();
        return strUUID.replaceAll("-", "");
    }

    public static String genPassword(int length)
    {
        String val = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num"; // 输出字母还是数字  

            if ("char".equalsIgnoreCase(charOrNum)) // 字符串  
            {
                int choice = random.nextInt(2) % 2 == 0 ? 65 : 97; //取得大写字母还是小写字母  
                val += (char) (choice + random.nextInt(26));
            } else if ("num".equalsIgnoreCase(charOrNum))// 数字  
            {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }

    public static String trim(String string) {
        if ((string == null) || (string.trim().equals("")))
            return "";
        return string.trim();
    }

    public static String text(String htmlStr) {
        String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>";
        String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>";
        String regEx_html = "<[^>]+>";
        Pattern p_script = Pattern.compile(regEx_script, 2);
        Matcher m_script = p_script.matcher(htmlStr);
        htmlStr = m_script.replaceAll("");
        Pattern p_style = Pattern.compile(regEx_style, 2);
        Matcher m_style = p_style.matcher(htmlStr);
        htmlStr = m_style.replaceAll("");
        Pattern p_html = Pattern.compile(regEx_html, 2);
        Matcher m_html = p_html.matcher(htmlStr);
        htmlStr = m_html.replaceAll("");
        return htmlStr;
    }

    public static String html(String string) {
        if ((string == null) || (string.trim().equals("")))
            return "";
        string = string.replace("&", "&amp;");
        string = string.replace("<", "&lt;");
        string = string.replace(">", "&gt;");
        string = string.replace(" ", "&nbsp;");
        string = string.replace("\"", "&quot;");
        string = string.replaceAll("\\n", "<br/>");
        string = string.replaceAll("[\\s]", "&nbsp;");

        return string;
    }

    public static String encode(String string, String charset) {
        if ((string == null) || (string.trim().equals("")))
            return "";
        try {
            string = URLEncoder.encode(string, charset);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return string;
    }

    public static class Tips {
        private String value;

        public Tips(String tips) {
            this.value = tips;
        }

        public String getValue() {
            String temp = this.value;
            this.value = null;
            return temp;
        }

        public Boolean getNotNull() {
            if (this.value != null)
                return Boolean.valueOf(true);
            return Boolean.valueOf(false);
        }
    }


    /**
     * 设定安全的密码，生成随机的salt并经过1024次 sha-1 hash
     */
    public static String entryptPassword(String password,byte[] salt) {
//        byte[] salt = Digests.generateSalt(SALT_SIZE);
        byte[] hashPassword = Digests.sha1(password.getBytes(), salt, HASH_INTERATIONS);
        return EncodeUtils.hexEncode(hashPassword);
    }

    public static String decryptPassword(String passwordStr,String saltStr)
    {
        byte[] salt =EncodeUtils.hexDecode(saltStr);
        byte[] hashPassword = Digests.sha1(passwordStr.getBytes(), salt, HASH_INTERATIONS);
        String ss = EncodeUtils.hexEncode(salt) + EncodeUtils.hexEncode(hashPassword);
        return "";
    }

}