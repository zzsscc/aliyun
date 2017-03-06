package com.eshutech.biz.util.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @Author:Lajiao
 * @Date:2014年7月4日
 * @Time:下午1:48:29
 * @Description:系统操作日志入库
 */
@Target(ElementType.TYPE)
@Retention(RUNTIME)
@Documented
public @interface Log {
    public String model() default "未知模块";

    public boolean insert() default true;

    public boolean modify() default true;

    public boolean del() default true;

    public String filter() default "";
}
