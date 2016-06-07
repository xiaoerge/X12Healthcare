package com.xiaoerge.healthcare.x12;

import com.xiaoerge.healthcare.x12.loop.InformationSource;
import com.xiaoerge.healthcare.x12.loop.InformationReceiver;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by xiaoerge on 6/5/16.
 */
public class LoopTest {

    @Test
    public void testParseInformationSource() {
        String x12 = "HL*1**20*1~NM1*PR*2*ACE INSURANCE COMPANY*****PI*87728~";
        InformationSource informationSource = new InformationSource(x12);

        Assert.assertTrue(informationSource.validate());
        Assert.assertEquals(x12, informationSource.toX12String());
        Assert.assertEquals("1", informationSource.getHierarchicalIDNumber());
        Assert.assertEquals("20", informationSource.getHierarchicalLevelCode());
        Assert.assertEquals("1", informationSource.getHierarchicalChildCode());
        Assert.assertEquals("PR", informationSource.getEntityIdentifierCode());
        Assert.assertEquals("2", informationSource.getEntityTypeQualifier());
        Assert.assertEquals("ACE INSURANCE COMPANY", informationSource.getNameLastOrOrganizationName());
        Assert.assertEquals("PI", informationSource.getIdentificationCodeQualifier());
        Assert.assertEquals("87728", informationSource.getIdentificationCode());
    }

    @Test
    public void testCreateInformationSource() {
        String x12 = "HL*1**20*1~NM1*PR*2*ACE INSURANCE COMPANY*****PI*87728~";
        InformationSource informationSource = new InformationSource();

        informationSource.setHierarchicalIDNumber("1");
        informationSource.setHierarchicalLevelCode("20");
        informationSource.setHierarchicalChildCode("1");
        informationSource.setEntityIdentifierCode("PR");
        informationSource.setEntityTypeQualifier("2");
        informationSource.setNameLastOrOrganizationName("ACE INSURANCE COMPANY");
        informationSource.setIdentificationCodeQualifier("PI");
        informationSource.setIdentificationCode("87728");

        Assert.assertTrue(informationSource.validate());
        Assert.assertEquals(x12, informationSource.toX12String());
    }

    @Test
    public void testParseInformationReceiver() {
        String x12 = "HL*2*1*21*1~" +
                "NM1*1P*1*JONES*MARCUS***MD*34*111223333~" +
                "REF*EO*477563928~" +
                "N3*201 PARK AVENUE*SUITE 300~" +
                "N4*KANSAS CITY*MO*64108~";
        InformationReceiver informationReceiver = new InformationReceiver(x12);

        Assert.assertTrue(informationReceiver.validate());
        Assert.assertEquals(x12, informationReceiver.toX12String());
        Assert.assertEquals("2", informationReceiver.getHierarchicalIDNumber());
        Assert.assertEquals("1", informationReceiver.getHierarchicalParentIDNumber());
        Assert.assertEquals("21", informationReceiver.getHierarchicalLevelCode());
        Assert.assertEquals("1", informationReceiver.getHierarchicalChildCode());
        Assert.assertEquals("1P", informationReceiver.getEntityIdentifierCode());
        Assert.assertEquals("1", informationReceiver.getEntityTypeQualifier());
        Assert.assertEquals("JONES", informationReceiver.getNameLastOrOrganizationName());
        Assert.assertEquals("MARCUS", informationReceiver.getNameFirst());
        Assert.assertEquals("MD", informationReceiver.getNameSuffix());
        Assert.assertEquals("34", informationReceiver.getIdentificationCodeQualifier());
        Assert.assertEquals("111223333", informationReceiver.getIdentificationCode());
        Assert.assertEquals("EO", informationReceiver.getReferenceIdentificationQualifier());
        Assert.assertEquals("477563928", informationReceiver.getReferenceIdentification());
        Assert.assertEquals("201 PARK AVENUE", informationReceiver.getAddressInformation1());
        Assert.assertEquals("SUITE 300", informationReceiver.getAddressInformation2());
        Assert.assertEquals("KANSAS CITY", informationReceiver.getCityName());
        Assert.assertEquals("MO", informationReceiver.getStateOrProvinceCode());
        Assert.assertEquals("64108", informationReceiver.getPostalCode());
    }

    @Test
    public void testCreateInformationReceiver() {
        String x12 = "HL*2*1*21*1~" +
                "NM1*1P*1*JONES*MARCUS***MD*34*111223333~" +
                "REF*EO*477563928~" +
                "N3*201 PARK AVENUE*SUITE 300~" +
                "N4*KANSAS CITY*MO*64108~";
        InformationReceiver informationReceiver = new InformationReceiver();

        informationReceiver.setHierarchicalIDNumber("2");
        informationReceiver.setHierarchicalParentIDNumber("1");
        informationReceiver.setHierarchicalLevelCode("21");
        informationReceiver.setHierarchicalChildCode("1");
        informationReceiver.setEntityIdentifierCode("1P");
        informationReceiver.setEntityTypeQualifier("1");
        informationReceiver.setNameLastOrOrganizationName("JONES");
        informationReceiver.setNameFirst("MARCUS");
        informationReceiver.setNameSuffix("MD");
        informationReceiver.setIdentificationCodeQualifier("34");
        informationReceiver.setIdentificationCode("111223333");
        informationReceiver.setReferenceIdentificationQualifier("EO");
        informationReceiver.setReferenceIdentification("477563928");
        informationReceiver.setAddressInformation1("201 PARK AVENUE");
        informationReceiver.setAddressInformation2("SUITE 300");
        informationReceiver.setCityName("KANSAS CITY");
        informationReceiver.setStateOrProvinceCode("MO");
        informationReceiver.setPostalCode("64108");

        Assert.assertTrue(informationReceiver.validate());
        Assert.assertEquals(x12, informationReceiver.toX12String());
    }
}
