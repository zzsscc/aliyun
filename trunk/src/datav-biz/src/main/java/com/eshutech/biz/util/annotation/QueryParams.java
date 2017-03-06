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
 * @Description:查询字段
 */
@Target(ElementType.FIELD)
@Retention(RUNTIME)
@Documented
public @interface QueryParams {
    String name();

    String value();
}
