package com.eshutech.biz.cache;

/**
 * @Author: Lajiao
 * @Date: 13-12-04
 * @Time: 上午9:47
 * @Description: to write something
 */
public abstract class DefaultSetCacheClosure implements CacheClosure {

    public Integer getTime() {
        return null;
    }

    public boolean getIfNullSetDefaultValue() {
        return true;
    }

    public String getIfNullDefaultValue() {
        return CACHE_DEFAULT_VALUE;
    }
}
