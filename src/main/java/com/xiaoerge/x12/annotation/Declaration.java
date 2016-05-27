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
@Target(ElementType.TYPE)
public @interface Declaration {

    public int size();
    public String name();
}
