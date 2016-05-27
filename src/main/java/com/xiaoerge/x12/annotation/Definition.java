package com.xiaoerge.x12.annotation;

import com.xiaoerge.x12.enumeration.Required;

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

    public Required required();
    public int position();
    public int minLength();
    public int maxLength();
    public String[] codeValues() default {};
}
