package com.ws.exp.everything.annotation.sample1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解String类型字段
 *
 * @author Eric at 2020-03-04_15:21
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLString {
    // 列名
    String name() default "";

    // 列类型分配长度，如varchar2(30)中的30
    int value() default 0;

    Constraints constraint() default @Constraints;
}
