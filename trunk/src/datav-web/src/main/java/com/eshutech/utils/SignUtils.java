package com.eshutech.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.message.BasicNameValuePair;

import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

public class SignUtils {

    public static String signData(List<BasicNameValuePair> nvps, String privateKeyPath, String privateKeyPwd) throws Exception {
        TreeMap<String, String> tempMap = new TreeMap<String, String>();
        for (BasicNameValuePair pair : nvps) {
            if ((pair.getValue() != null) && (!"".equals(pair.getValue().trim()))) {
                tempMap.put(pair.getName(), pair.getValue());
            }
        }
        StringBuffer buf = new StringBuffer();
        for (String key : tempMap.keySet()) {
            buf.append(key).append("=").append((String) tempMap.get(key)).append("&");
        }
        String signatureStr = buf.substring(0, buf.length() - 1);
        System.out.println("待签名数据：" + signatureStr);
        RSAUtil.KeyInfo keyInfo = RSAUtil.getPFXPrivateKey(privateKeyPath, privateKeyPwd);
        return RSAUtil.signByPrivate(signatureStr, keyInfo.getPrivateKey(), "UTF-8");
    }

    public static String signStrData(String data, String privateKeyPath, String privateKeyPwd) throws Exception {

        System.out.println("待签名数据：" + data);
        RSAUtil.KeyInfo keyInfo = RSAUtil.getPFXPrivateKey(privateKeyPath, privateKeyPwd);
        return RSAUtil.signByPrivate(data, keyInfo.getPrivateKey(), "UTF-8");
    }

    public static boolean verferSignData(JSONObject obj, String publicKeypath) {
        Iterator<?> keys = obj.keySet().iterator();
        TreeMap<String, String> temp = new TreeMap<String, String>();
        while (keys.hasNext()) {
            String name = keys.next().toString();
            if ((obj.getString(name) != null) && (!"".equals(obj.getString(name))) && (!"signature".equals(name)) && (!"null".equalsIgnoreCase(obj.getString(name)))) {
                temp.put(name, obj.getString(name));
            }
        }
        StringBuffer buf = new StringBuffer();
        for (String key : temp.keySet()) {
            buf.append(key).append("=").append((String) temp.get(key)).append("&");
        }
        String signatureStr = buf.substring(0, buf.length() - 1);
        System.out.println("待验签数据：" + signatureStr);
        return RSAUtil.verifyByKeyPath(signatureStr, obj.getString("signature"), publicKeypath, "UTF-8");
    }

}
