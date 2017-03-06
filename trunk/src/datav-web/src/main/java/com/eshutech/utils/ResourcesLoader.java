package com.eshutech.utils;

import java.io.InputStream;

/**
 * Summary:资源加载辅助类 <br>
 *
 */
public abstract class ResourcesLoader {

    public final static InputStream getResource(String name) {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        return cl.getResourceAsStream(name);
    }
}
