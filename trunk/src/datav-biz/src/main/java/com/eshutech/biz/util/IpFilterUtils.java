package com.eshutech.biz.util;

import com.google.common.base.Splitter;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 数字签名
 */
public class IpFilterUtils {
    private final static Set<String> filters = new HashSet<String>();

    static {
        try {
            // 加载配置文件
            InputStream fis = Thread.currentThread().getContextClassLoader().getResourceAsStream("filter.xml");
            InputStreamReader isr = new InputStreamReader(fis, "utf-8");
            SAXReader reader = new SAXReader();
            Document document = reader.read(isr);
            List nodes = document.getRootElement().elements("props");
            for (Iterator it = nodes.iterator(); it.hasNext(); ) {
                Element elm = (Element) it.next();
                if (elm.attributeValue("name").equals("ips")) {
                    List props = elm.elements("prop");
                    for (Iterator pit = props.iterator(); pit.hasNext(); ) {
                        Element pelm = (Element) pit.next();
                        filters.add(pelm.attributeValue("ip"));
                    }
                }
            }
            isr.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isFilter(String ip) {
        if (StringUtil.isEmpty(ip)) {
            return false;
        }

        return filters.contains(ip);
    }

    public static boolean IpMatch(String ips, String ip) {
        if (StringUtil.isEmpty(ips) || StringUtil.isEmpty(ip)) {
            return false;
        }
        if ("*".equals(ips)) {
            return true;
        }
        List<String> ipList = Splitter.on(',').omitEmptyStrings().splitToList(ips);
        for (String s : ipList) {
            if (ip.matches(s)) {
                return true;
            }
        }
        return false;
    }

    public static final void reload() {
        try {
            filters.clear();
            // 加载配置文件
            InputStream fis = Thread.currentThread().getContextClassLoader().getResourceAsStream("filter.xml");
            InputStreamReader isr = new InputStreamReader(fis, "utf-8");
            SAXReader reader = new SAXReader();
            Document document = reader.read(isr);
            List nodes = document.getRootElement().elements("props");
            for (Iterator it = nodes.iterator(); it.hasNext(); ) {
                Element elm = (Element) it.next();
                if (elm.attributeValue("name").equals("ips")) {
                    List props = elm.elements("prop");
                    for (Iterator pit = props.iterator(); pit.hasNext(); ) {
                        Element pelm = (Element) pit.next();
                        filters.add(pelm.attributeValue("ip"));
                    }
                }
            }
            isr.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String reg = "192.*.*.*";
        System.out.println("193.168.101.100".matches(reg));
    }
}