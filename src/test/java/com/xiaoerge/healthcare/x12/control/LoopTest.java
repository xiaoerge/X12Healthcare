package com.xiaoerge.healthcare.x12.control;

import com.xiaoerge.healthcare.x12.benefit.inquiry.BenefitInquiryInformationSource;
import com.xiaoerge.healthcare.x12.benefit.inquiry.BenefitInformationReceiver;
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
        BenefitInformationReceiver benefitInformationReceiver = new BenefitInformationReceiver(x12);

        Assert.assertTrue(benefitInformationReceiver.validate());
        Assert.assertEquals(x12, benefitInformationReceiver.toX12String());
        Assert.assertEquals("2", benefitInformationReceiver.getHierarchicalIDNumber());
        Assert.assertEquals("1", benefitInformationReceiver.getHierarchicalParentIDNumber());
        Assert.assertEquals("21", benefitInformationReceiver.getHierarchicalLevelCode());
        Assert.assertEquals("1", benefitInformationReceiver.getHierarchicalChildCode());
        Assert.assertEquals("1P", benefitInformationReceiver.getEntityIdentifierCode());
        Assert.assertEquals("1", benefitInformationReceiver.getEntityTypeQualifier());
        Assert.assertEquals("JONES", benefitInformationReceiver.getNameLastOrOrganizationName());
        Assert.assertEquals("MARCUS", benefitInformationReceiver.getNameFirst());
        Assert.assertEquals("MD", benefitInformationReceiver.getNameSuffix());
        Assert.assertEquals("34", benefitInformationReceiver.getIdentificationCodeQualifier());
        Assert.assertEquals("111223333", benefitInformationReceiver.getIdentificationCode());
//        Assert.assertEquals("EO", benefitInformationReceiver.getReferenceIdentificationQualifier());
//        Assert.assertEquals("477563928", benefitInformationReceiver.getReferenceIdentification());
        Assert.assertEquals("201 PARK AVENUE", benefitInformationReceiver.getAddressInformation1());
        Assert.assertEquals("SUITE 300", benefitInformationReceiver.getAddressInformation2());
        Assert.assertEquals("KANSAS CITY", benefitInformationReceiver.getCityName());
        Assert.assertEquals("MO", benefitInformationReceiver.getStateOrProvinceCode());
        Assert.assertEquals("64108", benefitInformationReceiver.getPostalCode());
    }

    @Test
    public void testCreateInformationReceiver() {
        String x12 = "HL*2*1*21*1~" +
                "NM1*1P*1*JONES*MARCUS***MD*34*111223333~" +
                "REF*EO*477563928~" +
                "N3*201 PARK AVENUE*SUITE 300~" +
                "N4*KANSAS CITY*MO*64108~";
        BenefitInformationReceiver benefitInformationReceiver = new BenefitInformationReceiver();

        benefitInformationReceiver.setHierarchicalIDNumber("2");
        benefitInformationReceiver.setHierarchicalParentIDNumber("1");
        benefitInformationReceiver.setHierarchicalLevelCode("21");
        benefitInformationReceiver.setHierarchicalChildCode("1");
        benefitInformationReceiver.setEntityIdentifierCode("1P");
        benefitInformationReceiver.setEntityTypeQualifier("1");
        benefitInformationReceiver.setNameLastOrOrganizationName("JONES");
        benefitInformationReceiver.setNameFirst("MARCUS");
        benefitInformationReceiver.setNameSuffix("MD");
        benefitInformationReceiver.setIdentificationCodeQualifier("34");
        benefitInformationReceiver.setIdentificationCode("111223333");
//        benefitInformationReceiver.setReferenceIdentificationQualifier("EO");
//        benefitInformationReceiver.setReferenceIdentification("477563928");
        benefitInformationReceiver.setAddressInformation1("201 PARK AVENUE");
        benefitInformationReceiver.setAddressInformation2("SUITE 300");
        benefitInformationReceiver.setCityName("KANSAS CITY");
        benefitInformationReceiver.setStateOrProvinceCode("MO");
        benefitInformationReceiver.setPostalCode("64108");

        Assert.assertTrue(benefitInformationReceiver.validate());
        Assert.assertNotEquals(x12, benefitInformationReceiver.toX12String());
    }
}
