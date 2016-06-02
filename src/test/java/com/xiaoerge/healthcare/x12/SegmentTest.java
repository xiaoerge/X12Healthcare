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

    @Test
    public void testParseNM1() {
        String x12 = "NM1*1P*1*JONES*MARCUS***MD*34*111223333~";
        NM1 nm1 = new NM1(x12);

        Assert.assertEquals(true, nm1.validate());
        Assert.assertEquals(x12, nm1.toString());
        Assert.assertEquals("1P", nm1.getEntityIdentifierCode());
        Assert.assertEquals("1", nm1.getEntityTypeQualifier());
        Assert.assertEquals("JONES", nm1.getNameLastOrOrganizationName());
        Assert.assertEquals("MARCUS", nm1.getNameFirst());
        Assert.assertEquals("MD", nm1.getNameSuffix());
        Assert.assertEquals("34", nm1.getIdentificationCodeQualifier());
        Assert.assertEquals("111223333", nm1.getIdentificationCode());
    }

    @Test
    public void testCreateNM1() {
        String x12 = "NM1*1P*1*JONES*MARCUS***MD*34*111223333~";
        NM1 nm1 = new NM1();

        nm1.setEntityIdentifierCode("1P");
        nm1.setEntityTypeQualifier("1");
        nm1.setNameLastOrOrganizationName("JONES");
        nm1.setNameFirst("MARCUS");
        nm1.setNameSuffix("MD");
        nm1.setIdentificationCodeQualifier("34");
        nm1.setIdentificationCode("111223333");

        Assert.assertEquals(true, nm1.validate());
        Assert.assertEquals(x12, nm1.toString());
    }

    @Test
    public void testParseREF() {
        String x12 = "REF*EO*477563928~";
        REF ref = new REF(x12);

        Assert.assertEquals(true, ref.validate());
        Assert.assertEquals(x12, ref.toString());
        Assert.assertEquals("EO", ref.getReferenceIdentificationQualifier());
        Assert.assertEquals("477563928", ref.getReferenceIdentification());
        Assert.assertEquals("", ref.getDescription());
    }

    @Test
    public void testCreateREF() {
        String x12 = "REF*EO*477563928~";
        REF ref = new REF();

        ref.setReferenceIdentificationQualifier("EO");
        ref.setReferenceIdentification("477563928");
        ref.setDescription("");

        Assert.assertEquals(true, ref.validate());
        Assert.assertEquals(x12, ref.toString());
    }
}
