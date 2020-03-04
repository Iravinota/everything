package com.ws.exp.everything.annotation.sample1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 表注解
 *
 * @author Eric at 2020-03-04_14:57
 */
@Target(ElementType.TYPE)   // 作用于类上
@Retention(RetentionPolicy.RUNTIME) // 保存到运行时
public @interface DBTable {
    String name() default "";
}
