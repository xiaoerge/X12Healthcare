package com.xiaoerge.healthcare.x12;

import com.xiaoerge.healthcare.x12.loop.BenefitInformationSource;
import com.xiaoerge.healthcare.x12.loop.BenefitInformationReceiver;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by xiaoerge on 6/5/16.
 */
public class LoopTest {

    @Test
    public void testParseInformationSource() {
        String x12 = "HL*1**20*1~NM1*PR*2*ACE INSURANCE COMPANY*****PI*87728~";
        BenefitInformationSource benefitInformationSource = new BenefitInformationSource(x12);

        Assert.assertTrue(benefitInformationSource.validate());
        Assert.assertEquals(x12, benefitInformationSource.toX12String());
        Assert.assertEquals("1", benefitInformationSource.getHierarchicalIDNumber());
        Assert.assertEquals("20", benefitInformationSource.getHierarchicalLevelCode());
        Assert.assertEquals("1", benefitInformationSource.getHierarchicalChildCode());
        Assert.assertEquals("PR", benefitInformationSource.getEntityIdentifierCode());
        Assert.assertEquals("2", benefitInformationSource.getEntityTypeQualifier());
        Assert.assertEquals("ACE INSURANCE COMPANY", benefitInformationSource.getNameLastOrOrganizationName());
        Assert.assertEquals("PI", benefitInformationSource.getIdentificationCodeQualifier());
        Assert.assertEquals("87728", benefitInformationSource.getIdentificationCode());
    }

    @Test
    public void testCreateInformationSource() {
        String x12 = "HL*1**20*1~NM1*PR*2*ACE INSURANCE COMPANY*****PI*87728~";
        BenefitInformationSource benefitInformationSource = new BenefitInformationSource();

        benefitInformationSource.setHierarchicalIDNumber("1");
        benefitInformationSource.setHierarchicalLevelCode("20");
        benefitInformationSource.setHierarchicalChildCode("1");
        benefitInformationSource.setEntityIdentifierCode("PR");
        benefitInformationSource.setEntityTypeQualifier("2");
        benefitInformationSource.setNameLastOrOrganizationName("ACE INSURANCE COMPANY");
        benefitInformationSource.setIdentificationCodeQualifier("PI");
        benefitInformationSource.setIdentificationCode("87728");

        Assert.assertTrue(benefitInformationSource.validate());
        Assert.assertEquals(x12, benefitInformationSource.toX12String());
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
