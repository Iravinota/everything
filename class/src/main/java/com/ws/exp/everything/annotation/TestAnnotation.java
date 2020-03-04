package com.ws.exp.everything.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * TestAnnotation
 *
 * @author Eric at 2020-03-03_21:54
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface TestAnnotation {

    // 注解的属性，成员变量。并非是方法。只是以方法的方式来进行定义
    int id();

    String msg() default "hello world";

    @Deprecated
    String[] paths() default {};
}
