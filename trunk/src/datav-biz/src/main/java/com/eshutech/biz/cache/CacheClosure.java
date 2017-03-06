package com.eshutech.biz.cache;

import org.codehaus.jackson.type.TypeReference;

/**
 * @Author: Lajiao
 * @Date: 13-12-04
 * @Time: 上午9:47
 * @Description: to write something
 */
public interface CacheClosure {
    public static final String CACHE_DEFAULT_VALUE = "-3";

    /**
     * 缓存键
     */
    public String getKey();

    /**
     * 缓存值
     */
    public Object getValue();

    /**
     * 类型
     */
    public TypeReference<?> getTypeReference();

    /**
     * 时间,单位:秒,为空表示永久有效
     */
    public Integer getTime();

    /**
     * 当值为空时，是否设置默认值标志
     */
    public boolean getIfNullSetDefaultValue();

    /**
     * 当值为空时，设置的默认值
     */
    public String getIfNullDefaultValue();
}
