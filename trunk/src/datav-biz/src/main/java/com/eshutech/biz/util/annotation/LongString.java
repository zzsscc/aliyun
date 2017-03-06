package com.eshutech.biz.util.annotation;

import org.codehaus.jackson.annotate.JacksonAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author:Lajiao
 * @Date:2014年7月4日
 * @Time:下午1:48:29
 * @Description:系统参数返回过滤
 */
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotation
public @interface LongString {
    boolean value() default true;
}