package com.eshutech.biz.cache;

/**
 * @Author: Lajiao
 * @Date: 13-12-04
 * @Time: 上午9:47
 * @Description: to write something
 */
public abstract class DefaultSetTimeoutCacheClosure implements CacheClosure {
    public boolean getIfNullSetDefaultValue() {
        return false;
    }

    public String getIfNullDefaultValue() {
        return null;
    }
}
