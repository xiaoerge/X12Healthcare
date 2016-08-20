package com.xiaoerge.x12.control;

import com.xiaoerge.x12.benefit.inquiry.BenefitInquiryInformationSource;
import com.xiaoerge.x12.benefit.inquiry.BenefitInquiryInformationReceiver;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by xiaoerge on 6/5/16.
 */
public class LoopTest {

    @Test
    public void testParseInformationSource() {
        String x12 = "HL*1**20*1~NM1*PR*2*ACE INSURANCE COMPANY*****PI*87728~";
        BenefitInquiryInformationSource benefitInquiryInformationSource = new BenefitInquiryInformationSource(x12);

        Assert.assertTrue(benefitInquiryInformationSource.validate());
        Assert.assertEquals(x12, benefitInquiryInformationSource.toX12String());
        Assert.assertEquals("1", benefitInquiryInformationSource.getHierarchicalIDNumber());
        Assert.assertEquals("20", benefitInquiryInformationSource.getHierarchicalLevelCode());
        Assert.assertEquals("1", benefitInquiryInformationSource.getHierarchicalChildCode());
        Assert.assertEquals("PR", benefitInquiryInformationSource.getEntityIdentifierCode());
        Assert.assertEquals("2", benefitInquiryInformationSource.getEntityTypeQualifier());
        Assert.assertEquals("ACE INSURANCE COMPANY", benefitInquiryInformationSource.getNameLastOrOrganizationName());
        Assert.assertEquals("PI", benefitInquiryInformationSource.getIdentificationCodeQualifier());
        Assert.assertEquals("87728", benefitInquiryInformationSource.getIdentificationCode());
    }

    @Test
    public void testCreateInformationSource() {
        String x12 = "HL*1**20*1~NM1*PR*2*ACE INSURANCE COMPANY*****PI*87728~";
        BenefitInquiryInformationSource benefitInquiryInformationSource = new BenefitInquiryInformationSource();

        benefitInquiryInformationSource.setHierarchicalIDNumber("1");
        benefitInquiryInformationSource.setHierarchicalLevelCode("20");
        benefitInquiryInformationSource.setHierarchicalChildCode("1");
        benefitInquiryInformationSource.setEntityIdentifierCode("PR");
        benefitInquiryInformationSource.setEntityTypeQualifier("2");
        benefitInquiryInformationSource.setNameLastOrOrganizationName("ACE INSURANCE COMPANY");
        benefitInquiryInformationSource.setIdentificationCodeQualifier("PI");
        benefitInquiryInformationSource.setIdentificationCode("87728");

        Assert.assertTrue(benefitInquiryInformationSource.validate());
        Assert.assertEquals(x12, benefitInquiryInformationSource.toX12String());
    }

    @Test
    public void testParseInformationReceiver() {
        String x12 = "HL*2*1*21*1~" +
                "NM1*1P*1*JONES*MARCUS***MD*34*111223333~" +
                "REF*EO*477563928~" +
                "N3*201 PARK AVENUE*SUITE 300~" +
                "N4*KANSAS CITY*MO*64108~";
        BenefitInquiryInformationReceiver benefitInquiryInformationReceiver = new BenefitInquiryInformationReceiver(x12);

        Assert.assertTrue(benefitInquiryInformationReceiver.validate());
        Assert.assertEquals(x12, benefitInquiryInformationReceiver.toX12String());
        Assert.assertEquals("2", benefitInquiryInformationReceiver.getHierarchicalIDNumber());
        Assert.assertEquals("1", benefitInquiryInformationReceiver.getHierarchicalParentIDNumber());
        Assert.assertEquals("21", benefitInquiryInformationReceiver.getHierarchicalLevelCode());
        Assert.assertEquals("1", benefitInquiryInformationReceiver.getHierarchicalChildCode());
        Assert.assertEquals("1P", benefitInquiryInformationReceiver.getEntityIdentifierCode());
        Assert.assertEquals("1", benefitInquiryInformationReceiver.getEntityTypeQualifier());
        Assert.assertEquals("JONES", benefitInquiryInformationReceiver.getNameLastOrOrganizationName());
        Assert.assertEquals("MARCUS", benefitInquiryInformationReceiver.getNameFirst());
        Assert.assertEquals("MD", benefitInquiryInformationReceiver.getNameSuffix());
        Assert.assertEquals("34", benefitInquiryInformationReceiver.getIdentificationCodeQualifier());
        Assert.assertEquals("111223333", benefitInquiryInformationReceiver.getIdentificationCode());
//        Assert.assertEquals("EO", benefitInquiryInformationReceiver.getReferenceIdentificationQualifier());
//        Assert.assertEquals("477563928", benefitInquiryInformationReceiver.getReferenceIdentification());
        Assert.assertEquals("201 PARK AVENUE", benefitInquiryInformationReceiver.getAddressInformation1());
        Assert.assertEquals("SUITE 300", benefitInquiryInformationReceiver.getAddressInformation2());
        Assert.assertEquals("KANSAS CITY", benefitInquiryInformationReceiver.getCityName());
        Assert.assertEquals("MO", benefitInquiryInformationReceiver.getStateOrProvinceCode());
        Assert.assertEquals("64108", benefitInquiryInformationReceiver.getPostalCode());
    }

    @Test
    public void testCreateInformationReceiver() {
        String x12 = "HL*2*1*21*1~" +
                "NM1*1P*1*JONES*MARCUS***MD*34*111223333~" +
                "REF*EO*477563928~" +
                "N3*201 PARK AVENUE*SUITE 300~" +
                "N4*KANSAS CITY*MO*64108~";
        BenefitInquiryInformationReceiver benefitInquiryInformationReceiver = new BenefitInquiryInformationReceiver();

        benefitInquiryInformationReceiver.setHierarchicalIDNumber("2");
        benefitInquiryInformationReceiver.setHierarchicalParentIDNumber("1");
        benefitInquiryInformationReceiver.setHierarchicalLevelCode("21");
        benefitInquiryInformationReceiver.setHierarchicalChildCode("1");
        benefitInquiryInformationReceiver.setEntityIdentifierCode("1P");
        benefitInquiryInformationReceiver.setEntityTypeQualifier("1");
        benefitInquiryInformationReceiver.setNameLastOrOrganizationName("JONES");
        benefitInquiryInformationReceiver.setNameFirst("MARCUS");
        benefitInquiryInformationReceiver.setNameSuffix("MD");
        benefitInquiryInformationReceiver.setIdentificationCodeQualifier("34");
        benefitInquiryInformationReceiver.setIdentificationCode("111223333");
//        benefitInquiryInformationReceiver.setReferenceIdentificationQualifier("EO");
//        benefitInquiryInformationReceiver.setReferenceIdentification("477563928");
        benefitInquiryInformationReceiver.setAddressInformation1("201 PARK AVENUE");
        benefitInquiryInformationReceiver.setAddressInformation2("SUITE 300");
        benefitInquiryInformationReceiver.setCityName("KANSAS CITY");
        benefitInquiryInformationReceiver.setStateOrProvinceCode("MO");
        benefitInquiryInformationReceiver.setPostalCode("64108");

        Assert.assertTrue(benefitInquiryInformationReceiver.validate());
        Assert.assertNotEquals(x12, benefitInquiryInformationReceiver.toX12String());
    }
}
