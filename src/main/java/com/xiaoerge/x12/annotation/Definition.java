package com.xiaoerge.x12.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by xiaoerge on 5/27/16.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Definition {

    int position();
    int minLength();
    int maxLength();
    int maxComponents() default 1;
}
