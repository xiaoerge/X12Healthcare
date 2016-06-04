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
        String x12 = "HL*1* *20*1~";
        HL hl = new HL(x12);

        Assert.assertEquals(true, hl.validate());
        Assert.assertEquals(x12, hl.toString());
        Assert.assertEquals("1", hl.getHierarchicalIDNumber());
        Assert.assertEquals(" ", hl.getHierarchicalParentIDNumber());
        Assert.assertEquals("20", hl.getHierarchicalLevelCode());
        Assert.assertEquals("1", hl.getHierarchicalChildCode());
    }

    @Test
    public void testCreateISA() {
        String x12 = "HL*1* *20*1~";
        HL hl = new HL();

        hl.setHierarchicalIDNumber("1");
        hl.setHierarchicalParentIDNumber(" ");
        hl.setHierarchicalLevelCode("20");
        hl.setHierarchicalChildCode("1");

        Assert.assertEquals(true, hl.validate());
        Assert.assertEquals(x12, hl.toString());
    }

    @Test
    public void testParseNM1() {
        String x12 = "NM1*1P*1*JONES*MARCUS*A*MR*MD*34*111223333*AA*BB*C~";
        NM1 nm1 = new NM1(x12);

        Assert.assertEquals(true, nm1.validate());
        Assert.assertEquals(x12, nm1.toString());
        Assert.assertEquals("1P", nm1.getEntityIdentifierCode());
        Assert.assertEquals("1", nm1.getEntityTypeQualifier());
        Assert.assertEquals("JONES", nm1.getNameLastOrOrganizationName());
        Assert.assertEquals("MARCUS", nm1.getNameFirst());
        Assert.assertEquals("A", nm1.getNameMiddle());
        Assert.assertEquals("MR", nm1.getNamePrefix());
        Assert.assertEquals("MD", nm1.getNameSuffix());
        Assert.assertEquals("34", nm1.getIdentificationCodeQualifier());
        Assert.assertEquals("111223333", nm1.getIdentificationCode());
        Assert.assertEquals("AA", nm1.getEntityRelationshipCode());
        Assert.assertEquals("BB", nm1.getEntityIdentifierCodeNotUsed());
        Assert.assertEquals("C", nm1.getNameLastOrOrganizationNameNotUsed());
    }

    @Test
    public void testCreateNM1() {
        String x12 = "NM1*1P*1*JONES*MARCUS*A*MR*MD*34*111223333*AA*BB*C~";
        NM1 nm1 = new NM1();

        nm1.setEntityIdentifierCode("1P");
        nm1.setEntityTypeQualifier("1");
        nm1.setNameLastOrOrganizationName("JONES");
        nm1.setNameFirst("MARCUS");
        nm1.setNameMiddle("A");
        nm1.setNamePrefix("MR");
        nm1.setNameSuffix("MD");
        nm1.setIdentificationCodeQualifier("34");
        nm1.setIdentificationCode("111223333");
        nm1.setEntityRelationshipCode("AA");
        nm1.setEntityIdentifierCodeNotUsed("BB");
        nm1.setNameLastOrOrganizationNameNotUsed("C");

        Assert.assertEquals(true, nm1.validate());
        Assert.assertEquals(x12, nm1.toString());
    }

    @Test
    public void testParseREF() {
        String x12 = "REF*EO*477563928**ZZ~";
        REF ref = new REF(x12);

        Assert.assertEquals(true, ref.validate());
        Assert.assertEquals(x12, ref.toString());
        Assert.assertEquals("EO", ref.getReferenceIdentificationQualifier());
        Assert.assertEquals("477563928", ref.getReferenceIdentification());
        Assert.assertEquals("", ref.getDescription());
        Assert.assertEquals("ZZ", ref.getReferenceIdentifier());
    }

    @Test
    public void testCreateREF() {
        String x12 = "REF*EO*477563928**ZZ~";
        REF ref = new REF();

        ref.setReferenceIdentificationQualifier("EO");
        ref.setReferenceIdentification("477563928");
        ref.setDescription("");
        ref.setReferenceIdentifier("ZZ");

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
        String x12 = "N4*KANSAS CITY*MO*64108*USA*1*2*3~";
        N4 n4 = new N4(x12);

        Assert.assertEquals(true, n4.validate());
        Assert.assertEquals(x12, n4.toString());
        Assert.assertEquals("KANSAS CITY", n4.getCityName());
        Assert.assertEquals("MO", n4.getStateOrProvinceCode());
        Assert.assertEquals("64108", n4.getPostalCode());
        Assert.assertEquals("USA", n4.getCountryCode());
        Assert.assertEquals("1", n4.getLocationQualifier());
        Assert.assertEquals("2", n4.getLocationIdentifier());
        Assert.assertEquals("3", n4.getCountrySubdivisionCode());
    }

    @Test
    public void testCreateN4() {
        String x12 = "N4*KANSAS CITY*MO*64108*USA*1*2*3~";
        N4 n4 = new N4();

        n4.setCityName("KANSAS CITY");
        n4.setStateOrProvinceCode("MO");
        n4.setPostalCode("64108");
        n4.setCountryCode("USA");
        n4.setLocationIdentifier("2");
        n4.setLocationQualifier("1");
        n4.setCountrySubdivisionCode("3");

        Assert.assertEquals(true, n4.validate());
        Assert.assertEquals(x12, n4.toString());
    }

    @Test
    public void testParsePRV() {
        String x12 = "PRV*RF*PXC*207Q00000X*PA*AA*AAA~";
        PRV prv = new PRV(x12);

        Assert.assertEquals(true, prv.validate());
        Assert.assertEquals(x12, prv.toString());
        Assert.assertEquals("RF", prv.getProviderCode());
        Assert.assertEquals("PXC", prv.getReferenceIdentificationQualifier());
        Assert.assertEquals("207Q00000X", prv.getReferenceIdentification());
        Assert.assertEquals("PA", prv.getStateOrProvinceCode());
        Assert.assertEquals("AA", prv.getProviderSpecialtyInformation());
        Assert.assertEquals("AAA", prv.getProviderOrganizationCode());
    }

    @Test
    public void testCreatePRV() {
        String x12 = "PRV*RF*PXC*207Q00000X*PA*AA*AAA~";
        PRV prv = new PRV();

        prv.setProviderCode("RF");
        prv.setReferenceIdentificationQualifier("PXC");
        prv.setReferenceIdentification("207Q00000X");
        prv.setStateOrProvinceCode("PA");
        prv.setProviderSpecialtyInformation("AA");
        prv.setProviderOrganizationCode("AAA");

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

    @Test
    public void testParseDMG() {
        String x12 = "DMG*D8*19430917*M*M*A*US*USA*A*1*2*3~";
        DMG dmg = new DMG(x12);

        Assert.assertEquals(true, dmg.validate());
        Assert.assertEquals(x12, dmg.toString());
        Assert.assertEquals("D8", dmg.getDateTimePeriodFormatQualifier());
        Assert.assertEquals("19430917", dmg.getDateTimePeriod());
        Assert.assertEquals("M", dmg.getGenderCode());
        Assert.assertEquals("M", dmg.getMaritalStatusCode());
        Assert.assertEquals("A", dmg.getCompositeRaceOrEthnicityInformation());
        Assert.assertEquals("US", dmg.getCitizenshipStatusCode());
        Assert.assertEquals("USA", dmg.getCountryCode());
        Assert.assertEquals("A", dmg.getBasisOfVerificationCode());
        Assert.assertEquals("1", dmg.getQuantity());
        Assert.assertEquals("2", dmg.getCodeListQualifierCode());
        Assert.assertEquals("3", dmg.getIndustryCode());
    }

    @Test
    public void testCreateDMG() {
        String x12 = "DMG*D8*19430917*M*M*A*US*USA*A*1*2*3~";
        DMG dmg = new DMG();

        dmg.setDateTimePeriodFormatQualifier("D8");
        dmg.setDateTimePeriod("19430917");
        dmg.setGenderCode("M");
        dmg.setMaritalStatusCode("M");
        dmg.setCompositeRaceOrEthnicityInformation("A");
        dmg.setCitizenshipStatusCode("US");
        dmg.setCountryCode("USA");
        dmg.setBasisOfVerificationCode("A");
        dmg.setQuantity("1");
        dmg.setCodeListQualifierCode("2");
        dmg.setIndustryCode("3");

        Assert.assertEquals(true, dmg.validate());
        Assert.assertEquals(x12, dmg.toString());
    }

    @Test
    public void testParseINS() {
        String x12 = "INS*Y*18*AAA*BBB*C*D*CO*EM*S*N*D8*HHMM*C*New York*NY*USA*3~";
        INS ins = new INS(x12);

        Assert.assertEquals(true, ins.validate());
        Assert.assertEquals(x12, ins.toString());
        Assert.assertEquals("Y", ins.getYesNoConditionOrResponseCode());
        Assert.assertEquals("18", ins.getIndividualRelationshipCode());
        Assert.assertEquals("AAA", ins.getMaintenanceTypeCode());
        Assert.assertEquals("BBB", ins.getMaintenanceReasonCode());
        Assert.assertEquals("C", ins.getBenefitStatusCode());
        Assert.assertEquals("D", ins.getMedicareStatusCode());
        Assert.assertEquals("CO", ins.getConsolidatedOmnibusBudgetReconciliationActQualifying());
        Assert.assertEquals("EM", ins.getEmploymentStatusCode());
        Assert.assertEquals("S", ins.getStudentStatusCode());
        Assert.assertEquals("N", ins.getYesNoConditionOrResponseCode2());
        Assert.assertEquals("D8", ins.getDateTimePeriodFormatQualifier());
        Assert.assertEquals("HHMM", ins.getDateTimePeriod());
        Assert.assertEquals("C", ins.getConfidentialityCode());
        Assert.assertEquals("New York", ins.getCityName());
        Assert.assertEquals("NY", ins.getStateOrProvinceCode());
        Assert.assertEquals("USA", ins.getCountryCode());
        Assert.assertEquals("3", ins.getNumber());
    }

    @Test
    public void testCreateINS() {
        String x12 = "INS*Y*18*AAA*BBB*C*D*CO*EM*S*N*D8*HHMM*C*New York*NY*USA*3~";
        INS ins = new INS();

        ins.setYesNoConditionOrResponseCode("Y");
        ins.setIndividualRelationshipCode("18");
        ins.setMaintenanceTypeCode("AAA");
        ins.setMaintenanceReasonCode("BBB");
        ins.setBenefitStatusCode("C");
        ins.setMedicareStatusCode("D");
        ins.setConsolidatedOmnibusBudgetReconciliationActQualifying("CO");
        ins.setEmploymentStatusCode("EM");
        ins.setStudentStatusCode("S");
        ins.setYesNoConditionOrResponseCode2("N");
        ins.setDateTimePeriodFormatQualifier("D8");
        ins.setDateTimePeriod("HHMM");
        ins.setConfidentialityCode("C");
        ins.setCityName("New York");
        ins.setStateOrProvinceCode("NY");
        ins.setCountryCode("USA");
        ins.setNumber("3");

        Assert.assertEquals(true, ins.validate());
        Assert.assertEquals(x12, ins.toString());
    }
}
