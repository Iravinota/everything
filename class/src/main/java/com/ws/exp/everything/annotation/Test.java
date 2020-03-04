package com.ws.exp.everything.annotation;

import java.lang.annotation.Annotation;
import java.util.Arrays;

/**
 * Test
 *
 * @author Eric at 2020-03-03_21:54
 */
@TestAnnotation(id = 5)
public class Test {

    public static void main(String[] args) {

        // 检阅在这个类上的注解
        boolean hasAnnotation = Test.class.isAnnotationPresent(TestAnnotation.class);
        System.out.println(hasAnnotation);

        if (hasAnnotation) {
            TestAnnotation testAnnotation = Test.class.getAnnotation(TestAnnotation.class);

            System.out.println("id: " + testAnnotation.id());
            System.out.println("msg: " + testAnnotation.msg());
        }

        Annotation[] annotations = Test.class.getAnnotations();
        System.out.println(Arrays.toString(annotations));
    }
}
