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

    @Test
    public void testParseN3() {
        String x12 = "N3*201 PARK AVENUE*SUITE 300~";
        N3 n3 = new N3(x12);

        Assert.assertEquals(true, n3.validate());
        Assert.assertEquals(x12, n3.toString());
        Assert.assertEquals("201 PARK AVENUE", n3.getAddressInformation());
        Assert.assertEquals("SUITE 300", n3.getAddressInformation2());
    }

    @Test
    public void testCreateN3() {
        String x12 = "N3*201 PARK AVENUE*SUITE 300~";
        N3 n3 = new N3();

        n3.setAddressInformation("201 PARK AVENUE");
        n3.setAddressInformation2("SUITE 300");

        Assert.assertEquals(true, n3.validate());
        Assert.assertEquals(x12, n3.toString());
    }

    @Test
    public void testParseN4() {
        String x12 = "N4*KANSAS CITY*MO*64108~";
        N4 n4 = new N4(x12);

        Assert.assertEquals(true, n4.validate());
        Assert.assertEquals(x12, n4.toString());
        Assert.assertEquals("KANSAS CITY", n4.getCityName());
        Assert.assertEquals("MO", n4.getStateOrProvinceCode());
        Assert.assertEquals("64108", n4.getPostalCode());
    }

    @Test
    public void testCreateN4() {
        String x12 = "N4*KANSAS CITY*MO*64108~";
        N4 n4 = new N4();

        n4.setCityName("KANSAS CITY");
        n4.setStateOrProvinceCode("MO");
        n4.setPostalCode("64108");

        Assert.assertEquals(true, n4.validate());
        Assert.assertEquals(x12, n4.toString());
    }

    @Test
    public void testParsePRV() {
        String x12 = "PRV*RF*PXC*207Q00000X~";
        PRV prv = new PRV(x12);

        Assert.assertEquals(true, prv.validate());
        Assert.assertEquals(x12, prv.toString());
        Assert.assertEquals("RF", prv.getProviderCode());
        Assert.assertEquals("PXC", prv.getReferenceIdentificationQualifier());
        Assert.assertEquals("207Q00000X", prv.getReferenceIdentification());
    }

    @Test
    public void testCreatePRV() {
        String x12 = "PRV*RF*PXC*207Q00000X~";
        PRV prv = new PRV();

        prv.setProviderCode("RF");
        prv.setReferenceIdentificationQualifier("PXC");
        prv.setReferenceIdentification("207Q00000X");

        Assert.assertEquals(true, prv.validate());
        Assert.assertEquals(x12, prv.toString());
    }

    @Test
    public void testParseTRN() {
        String x12 = "TRN*1*98175-012547*8877281234*RADIOLOGY~";
        TRN trn = new TRN(x12);

        Assert.assertEquals(true, trn.validate());
        Assert.assertEquals(x12, trn.toString());
        Assert.assertEquals("1", trn.getTraceTypeCode());
        Assert.assertEquals("98175-012547", trn.getReferenceIdentification());
        Assert.assertEquals("8877281234", trn.getOriginatingCompanyIdentifier());
        Assert.assertEquals("RADIOLOGY", trn.getReferenceIdentification2());
    }

    @Test
    public void testCreateTRN() {
        String x12 = "TRN*1*98175-012547*8877281234*RADIOLOGY~";
        TRN trn = new TRN();

        trn.setTraceTypeCode("1");
        trn.setReferenceIdentification("98175-012547");
        trn.setOriginatingCompanyIdentifier("8877281234");
        trn.setReferenceIdentification2("RADIOLOGY");

        Assert.assertEquals(true, trn.validate());
        Assert.assertEquals(x12, trn.toString());
    }
}
