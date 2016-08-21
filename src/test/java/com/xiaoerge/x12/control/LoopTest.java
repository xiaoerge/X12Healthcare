package com.xiaoerge.x12.control;

import com.xiaoerge.x12.benefit.inquiry.BenefitInquiryInformationSource;
import com.xiaoerge.x12.benefit.inquiry.BenefitInquiryInformationReceiver;
import com.xiaoerge.x12.segment.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoerge on 6/5/16.
 */
public class LoopTest {

    @Test
    public void testParseInformationSource() {
        String x12 = "HL*1**20*1~NM1*PR*2*ACE INSURANCE COMPANY*****PI*87728~";
        BenefitInquiryInformationSource benefitInquiryInformationSource = new BenefitInquiryInformationSource(x12);
        HL hierarchicalLevel = benefitInquiryInformationSource.getHierarchicalLevel();
        NM1 individualOrOrganizationalName = benefitInquiryInformationSource.getIndividualOrOrganizationalName();

        Assert.assertTrue(benefitInquiryInformationSource.validate());
        Assert.assertEquals(x12, benefitInquiryInformationSource.toX12String());
        Assert.assertEquals("1", hierarchicalLevel.getHierarchicalIDNumber());
        Assert.assertEquals("20", hierarchicalLevel.getHierarchicalLevelCode());
        Assert.assertEquals("1", hierarchicalLevel.getHierarchicalChildCode());
        Assert.assertEquals("PR", individualOrOrganizationalName.getEntityIdentifierCode());
        Assert.assertEquals("2", individualOrOrganizationalName.getEntityTypeQualifier());
        Assert.assertEquals("ACE INSURANCE COMPANY", individualOrOrganizationalName.getNameLastOrOrganizationName());
        Assert.assertEquals("PI", individualOrOrganizationalName.getIdentificationCodeQualifier());
        Assert.assertEquals("87728", individualOrOrganizationalName.getIdentificationCode());
    }

    @Test
    public void testCreateInformationSource() {
        String x12 = "HL*1**20*1~NM1*PR*2*ACE INSURANCE COMPANY*****PI*87728~";
        BenefitInquiryInformationSource benefitInquiryInformationSource = new BenefitInquiryInformationSource();
        HL hierarchicalLevel = new HL();
        NM1 individualOrOrganizationalName = new NM1();

        hierarchicalLevel.setHierarchicalIDNumber("1");
        hierarchicalLevel.setHierarchicalLevelCode("20");
        hierarchicalLevel.setHierarchicalChildCode("1");
        individualOrOrganizationalName.setEntityIdentifierCode("PR");
        individualOrOrganizationalName.setEntityTypeQualifier("2");
        individualOrOrganizationalName.setNameLastOrOrganizationName("ACE INSURANCE COMPANY");
        individualOrOrganizationalName.setIdentificationCodeQualifier("PI");
        individualOrOrganizationalName.setIdentificationCode("87728");

        benefitInquiryInformationSource.setHierarchicalLevel(hierarchicalLevel);
        benefitInquiryInformationSource.setIndividualOrOrganizationalName(individualOrOrganizationalName);

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
        HL hierarchicalLevel = benefitInquiryInformationReceiver.getHierarchicalLevel();
        NM1 individualOrOrganizationalName = benefitInquiryInformationReceiver.getIndividualOrOrganizationalName();
        List<REF> referenceInformations = benefitInquiryInformationReceiver.getReferenceInformations();
        N3 partyLocation = benefitInquiryInformationReceiver.getAddress();
        N4 geographicLocation = benefitInquiryInformationReceiver.getCityStateZip();

        Assert.assertTrue(benefitInquiryInformationReceiver.validate());
        Assert.assertEquals(x12, benefitInquiryInformationReceiver.toX12String());
        Assert.assertEquals("2", hierarchicalLevel.getHierarchicalIDNumber());
        Assert.assertEquals("1", hierarchicalLevel.getHierarchicalParentIDNumber());
        Assert.assertEquals("21", hierarchicalLevel.getHierarchicalLevelCode());
        Assert.assertEquals("1", hierarchicalLevel.getHierarchicalChildCode());
        Assert.assertEquals("1P", individualOrOrganizationalName.getEntityIdentifierCode());
        Assert.assertEquals("1", individualOrOrganizationalName.getEntityTypeQualifier());
        Assert.assertEquals("JONES", individualOrOrganizationalName.getNameLastOrOrganizationName());
        Assert.assertEquals("MARCUS", individualOrOrganizationalName.getNameFirst());
        Assert.assertEquals("MD", individualOrOrganizationalName.getNameSuffix());
        Assert.assertEquals("34", individualOrOrganizationalName.getIdentificationCodeQualifier());
        Assert.assertEquals("111223333", individualOrOrganizationalName.getIdentificationCode());
        Assert.assertEquals("201 PARK AVENUE", partyLocation.getAddressInformation1());
        Assert.assertEquals("SUITE 300", partyLocation.getAddressInformation2());
        Assert.assertEquals("KANSAS CITY", geographicLocation.getCityName());
        Assert.assertEquals("MO", geographicLocation.getStateOrProvinceCode());
        Assert.assertEquals("64108", geographicLocation.getPostalCode());
    }

    @Test
    public void testCreateInformationReceiver() {
        String x12 = "HL*2*1*21*1~" +
                "NM1*1P*1*JONES*MARCUS***MD*34*111223333~" +
                "REF*EO*477563928~" +
                "N3*201 PARK AVENUE*SUITE 300~" +
                "N4*KANSAS CITY*MO*64108~";
        BenefitInquiryInformationReceiver benefitInquiryInformationReceiver = new BenefitInquiryInformationReceiver();
        HL hierarchicalLevel = new HL();
        NM1 individualOrOrganizationalName = new NM1();
        List<REF> referenceInformations = new ArrayList<REF>();
        N3 partyLocation = new N3();
        N4 geographicLocation = new N4();

        hierarchicalLevel.setHierarchicalIDNumber("2");
        hierarchicalLevel.setHierarchicalParentIDNumber("1");
        hierarchicalLevel.setHierarchicalLevelCode("21");
        hierarchicalLevel.setHierarchicalChildCode("1");
        individualOrOrganizationalName.setEntityIdentifierCode("1P");
        individualOrOrganizationalName.setEntityTypeQualifier("1");
        individualOrOrganizationalName.setNameLastOrOrganizationName("JONES");
        individualOrOrganizationalName.setNameFirst("MARCUS");
        individualOrOrganizationalName.setNameSuffix("MD");
        individualOrOrganizationalName.setIdentificationCodeQualifier("34");
        individualOrOrganizationalName.setIdentificationCode("111223333");
        partyLocation.setAddressInformation1("201 PARK AVENUE");
        partyLocation.setAddressInformation2("SUITE 300");
        geographicLocation.setCityName("KANSAS CITY");
        geographicLocation.setStateOrProvinceCode("MO");
        geographicLocation.setPostalCode("64108");

        REF ref = new REF();
        ref.setReferenceIdentificationQualifier("EO");
        ref.setReferenceIdentification("477563928");
        referenceInformations.add(ref);

        benefitInquiryInformationReceiver.setHierarchicalLevel(hierarchicalLevel);
        benefitInquiryInformationReceiver.setIndividualOrOrganizationalName(individualOrOrganizationalName);
        benefitInquiryInformationReceiver.setAddress(partyLocation);
        benefitInquiryInformationReceiver.setCityStateZip(geographicLocation);
        benefitInquiryInformationReceiver.setReferenceInformations(referenceInformations);

        Assert.assertTrue(benefitInquiryInformationReceiver.validate());
        Assert.assertEquals(x12, benefitInquiryInformationReceiver.toX12String());
    }
}
