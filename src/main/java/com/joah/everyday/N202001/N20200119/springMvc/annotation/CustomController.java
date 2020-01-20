package com.joah.everyday.N202001.N20200119.springMvc.annotation;

import java.lang.annotation.*;

/**
 * @author Joah
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CustomController {

    String value() default "";
}