package com.eshutech.biz.util.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @Author:Binwei.Chen
 * @Date:2014年7月4日
 * @Time:下午1:48:29
 * @Description:业务属性配置信息
 */
@Target(ElementType.TYPE)
@Retention(RUNTIME)
@Documented
public @interface ServiceProperty {
    public String model() default "";

    public boolean local() default false;

    public boolean remote() default false;
}
