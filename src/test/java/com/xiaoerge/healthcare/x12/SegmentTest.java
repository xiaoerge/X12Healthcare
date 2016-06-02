package com.xiaoerge.healthcare.x12;

import com.xiaoerge.healthcare.x12.segment.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by xiaoerge on 5/23/16.
 */
public class SegmentTest {

    @Test
    public void testParseISA() {
        String x12 = "HL*1**20*1~";
        HL hl = new HL(x12);

        Assert.assertEquals(true, hl.validate());
        Assert.assertEquals(x12, hl.toString());
        Assert.assertEquals(4, hl.size());
        Assert.assertEquals("1", hl.getHierarchicalIDNumber());
        Assert.assertEquals("", hl.getHierarchicalParentIDNumber());
        Assert.assertEquals("20", hl.getHierarchicalLevelCode());
        Assert.assertEquals("1", hl.getHierarchicalChildCode());
    }

    @Test
    public void testCreateISA() {
        String x12 = "HL*1**20*1~";
        HL hl = new HL();

        hl.setHierarchicalIDNumber("1");
        hl.setHierarchicalLevelCode("20");
        hl.setHierarchicalChildCode("1");

        Assert.assertEquals(true, hl.validate());
        Assert.assertEquals(x12, hl.toString());
    }
}
