package com.xiaoerge.x12.enumeration;

/**
 * Created by xiaoerge on 5/26/16.
 */
public class Qualifier {
    public static <T> T codeValueOf(Class<T> c, String s) {
        T[] constants = c.getEnumConstants();
        for (T e : constants) {
            if (e.toString().equals(s)) return e;
        }
        return null;
    }
}
