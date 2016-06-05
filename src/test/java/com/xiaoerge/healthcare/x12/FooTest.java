package com.xiaoerge.healthcare.x12;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Pattern;

/**
 * Created by xiaoerge on 6/3/16.
 */
public class FooTest {

    @Test
    public void testFoo() {
        String asterikS = "**********";

        //this will print 0,  to get it to print size, escape asterisks
        // System.out.println(asterikS.split(Pattern.quote("*")).length);

        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        //System.out.println(methodName);

        for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
            //System.out.println(element.getLineNumber());
        }
    }
}
