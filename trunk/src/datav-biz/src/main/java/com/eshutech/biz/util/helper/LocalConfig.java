package com.eshutech.biz.util.helper;

import com.eshutech.biz.util.StringUtil;
import com.google.common.collect.Maps;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

/**
 * @Author:Lajiao
 * @Date:2014年5月20日
 * @Time:下午5:58:45
 * @Description:本地参数配置信息
 */
public class LocalConfig {
    private static       LocalConfig         instance           = null;
    private final static String DEFAULT_NULL_VALUE = "NULL";
    private static Map<String, String> Config             = Maps.newHashMap();

    private LocalConfig() {
    }

    public static synchronized LocalConfig I() {
        if (instance == null) {
            instance = new LocalConfig();
            instance.initPropertys();
        }
        return instance;
    }

    public void initPropertys() {
        Config.clear();
        try {
            // 加载配置文件
            InputStream fis = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.xml");
            InputStreamReader isr = new InputStreamReader(fis, "utf-8");
            SAXReader reader = new SAXReader();
            Document document = reader.read(isr);
            List<Element> lstPropS = document.getRootElement().elements("props");
            for (Element props : lstPropS) {
                List<Element> lstProp = props.elements("prop");
                for (Element prop : lstProp) {
                    Config.put(prop.attributeValue("key"), prop.getTextTrim());
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private String get(String key) {
        String rtn = Config.get(key);
        if (rtn != null) {
            if (DEFAULT_NULL_VALUE.equals(rtn)) {
                return null;
            }
            return rtn;
        }
        return rtn;
    }

    public String GS(String key, String def) {
        String rtn = get(key);
        return rtn == null ? def : rtn;
    }

    public String GS(String key) {
        String rtn = get(key);
        return rtn == null ? StringUtil.EMPTY : rtn;
    }

    public int GI(String key, int def) {
        return StringUtil.parseInteger(get(key), def);
    }

    public double GD(String key, double def) {
        return StringUtil.parseDouble(get(key), def);
    }

    public boolean GB(String key) {
        return Boolean.parseBoolean(get(key));
    }

    public String Host() {
        return GS("http_server_host");
    }

    public String Port() {
        return GS("http_server_port");
    }
}
