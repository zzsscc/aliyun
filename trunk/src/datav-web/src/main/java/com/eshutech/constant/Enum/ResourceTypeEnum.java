package com.eshutech.constant.Enum;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

/**
 * @Author:Binwei.Chen
 * @Date:2014年7月29日
 * @Time:下午2:05:05
 * @Description:资源模块CODE
 */
public enum ResourceTypeEnum {
    FOLDER(0, "目录"),
    MENU(1, "菜单"),
    BUTTON(2, "按钮");

    private int    id;
    private String name;

    private ResourceTypeEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getName(Integer id) {
        if (id == null) {
            return "未知";
        }
        for (ResourceTypeEnum re : ResourceTypeEnum.values()) {
            if (re.getId() == id.intValue()) {
                return re.getName();
            }
        }
        return "未知";
    }

    public static String getMaps() {
        Map<String, Object> combos = Maps.newHashMap();
        for (ResourceTypeEnum re : ResourceTypeEnum.values()) {
            combos.put(String.valueOf(re.getId()), re.getName());
        }
        return JSON.toJSONString(combos);
    }

    public static String getComboValue(String nameKey, String valueKey) {
        List<Map<String, Object>> combos = Lists.newArrayList();
        Map<String, Object> temp;
        for (ResourceTypeEnum re : ResourceTypeEnum.values()) {
            temp = Maps.newHashMap();
            temp.put(nameKey, re.getName());
            temp.put(valueKey, re.getId());
            combos.add(temp);
        }
        return JSON.toJSONString(combos);
    }

    public static String getComboValue() {
        return getComboValue("name", "value");
    }
}
