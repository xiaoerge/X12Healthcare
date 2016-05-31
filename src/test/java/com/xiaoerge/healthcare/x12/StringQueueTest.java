package com.xiaoerge.healthcare.x12;

import com.xiaoerge.healthcare.x12.segment.ISA;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by xiaoerge on 5/30/16.
 */
public class StringQueueTest {

    @Test
    public void testStringQueueCreate() {
        String x12 = "";

        StringQueue stringQueue = new StringQueue(x12);

        Assert.assertTrue(stringQueue.getHeader().startsWith("ISA"));
        Assert.assertTrue(stringQueue.getContent().startsWith("GS"));
        Assert.assertTrue(stringQueue.getTrailer().startsWith("IEA"));
    }
}
