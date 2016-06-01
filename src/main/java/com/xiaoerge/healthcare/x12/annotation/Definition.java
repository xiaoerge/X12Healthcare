package com.xiaoerge.healthcare.x12.annotation;

import com.xiaoerge.healthcare.x12.enumeration.Required;

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

    public Required required() default Required.OPTIONAL;
    public int position();
    public int minLength();
    public int maxLength();
    public String[] codeValues() default {};
}
