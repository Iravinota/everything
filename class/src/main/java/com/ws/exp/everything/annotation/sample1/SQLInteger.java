package com.ws.exp.everything.annotation.sample1;

import javax.swing.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解Integer类型字段
 *
 * @author Eric at 2020-03-04_14:59
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLInteger {

    // 该字段对应数据集表列名
    String name() default "";

    // 嵌套注解?
    Constraints constraint() default @Constraints;
}
