package com.eshutech.biz.cache.util;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * @Author: Lajiao
 * @Date: 13-12-04
 * @Time: 上午9:47
 * @Description: to write something
 */
@SuppressWarnings("deprecation")
public class JsonUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.getDeserializationConfig().set(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        SimpleDateFormat myDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        objectMapper.getSerializationConfig().setDateFormat(myDateFormat);
    }

    /**
     * object transform json string
     *
     * @param o object
     * @return json string
     */
    public static String objectToJson(Object o) {
        try {
            return objectMapper.writeValueAsString(o);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * json string transform object
     *
     * @param json
     * @param className
     * @param defaultInstance when json string is empty,whether build classes instance,true:build;false:not build
     * @param <T>
     * @return
     */
    public static <T> T jsonToObject(String json, Class<T> className, boolean defaultInstance) {
        if (StringUtils.isEmpty(json)) {
            if (defaultInstance) {
                try {
                    return className.newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            } else {
                return null;
            }
        } else {
            try {
                return objectMapper.readValue(json, className);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T jsonToObject(String json, TypeReference<T> typeReference) {
        if (StringUtils.isEmpty(json)) {
            return null;
        } else {
            try {
                return (T) objectMapper.readValue(json, typeReference);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
