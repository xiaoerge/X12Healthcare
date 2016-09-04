package com.xiaoerge.x12.message.segment;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by xiaoerge on 5/23/16.
 */
public class SegmentTest {

    @Test(expected = NullPointerException.class)
    public void testParseError() {
        String x12 = "HL*1* *20*1~";
        ISA isa = new ISA(x12);

        //collection[0] is null because parse() failed prematurely due to invalid constructor call
        Assert.assertFalse(isa.validate());
    }

    @Test
    public void testParseISA() {
        String x12 = "ISA*00*          *01*SECRET    *ZZ*SUBMITTERS   ID*ZZ*RECEIVERS    ID*030101*1253*^*00602*000000905*0*T*:~";
        ISA isa = new ISA(x12);

        Assert.assertEquals(true, isa.validate());
        Assert.assertEquals(x12, isa.toString());
        Assert.assertEquals(16, isa.size());
        Assert.assertEquals("00", isa.getAuthInfoQualifier());
        Assert.assertEquals("          ", isa.getAuthInformation());
        Assert.assertEquals("01", isa.getSecurityInfoQualifier());
        Assert.assertEquals("SECRET    ", isa.getSecurityInformation());
        Assert.assertEquals("ZZ", isa.getInterchangeIDQualifierSender());
        Assert.assertEquals("SUBMITTERS   ID", isa.getInterchangeSenderID());
        Assert.assertEquals("ZZ", isa.getInterchangeIDQualifierReceiver());
        Assert.assertEquals("RECEIVERS    ID", isa.getInterchangeReceiverID());
        Assert.assertEquals("030101", isa.getInterchangeDate());
        Assert.assertEquals("1253", isa.getInterchangeTime());
        Assert.assertEquals("^", isa.getRepetitionSeparator());
        Assert.assertEquals("00602", isa.getInterchangeControlVersionNumber());
        Assert.assertEquals("000000905", isa.getInterchangeControlNumber());
        Assert.assertEquals("0", isa.getAcknowledgmentRequested());
        Assert.assertEquals("T", isa.getUsageIndicator());
        Assert.assertEquals(":", isa.getComponentElementSeparator());
    }

    @Test
    public void testCreateISA() {
        String x12 = "ISA*00*          *01*SECRET    *ZZ*SUBMITTERS   ID*ZZ*RECEIVERS    ID*030101*1253*^*00602*000000905*0*T*:~";
        ISA isa = new ISA();

        isa.setAuthInfoQualifier("00");
        isa.setAuthInformation("          ");
        isa.setSecurityInfoQualifier("01");
        isa.setSecurityInformation("SECRET    ");
        isa.setInterchangeIDQualifierSender("ZZ");
        isa.setInterchangeSenderID("SUBMITTERS   ID");
        isa.setInterchangeIDQualifierReceiver("ZZ");
        isa.setInterchangeReceiverID("RECEIVERS    ID");
        isa.setInterchangeDate("030101");
        isa.setInterchangeTime("1253");
        isa.setRepetitionSeparator("^");
        isa.setInterchangeControlVersionNumber("00602");
        isa.setInterchangeControlNumber("000000905");
        isa.setAcknowledgmentRequested("0");
        isa.setUsageIndicator("T");
        isa.setComponentElementSeparator(":");

        Assert.assertEquals(true, isa.validate());
        Assert.assertEquals(x12, isa.toString());
    }

    @Test
    public void testParseGS() {
        String x12 = "GS*HC*SUBMITTERS Code*RECEIVERS Code*20160524*0616*126*X*005010X222A1~";
        GS gs = new GS(x12);

        Assert.assertEquals(true, gs.validate());
        Assert.assertEquals(x12, gs.toString());
        Assert.assertEquals("HC", gs.getFunctionalIDCode());
        Assert.assertEquals("SUBMITTERS Code", gs.getApplicationSendersCode());
        Assert.assertEquals("RECEIVERS Code", gs.getApplicationReceiversCode());
        Assert.assertEquals("20160524", gs.getDate());
        Assert.assertEquals("0616", gs.getTime());
        Assert.assertEquals("126", gs.getGroupControlNumber());
        Assert.assertEquals("X", gs.getResponsibleAgencyCode());
        Assert.assertEquals("005010X222A1", gs.getVersionReleaseIndustryIDCode());
    }

    @Test
    public void testCreateGS() {
        String x12 = "GS*HC*SUBMITTERS Code*RECEIVERS Code*20160524*0616*126*X*005010X222A1~";
        GS gs = new GS();

        gs.setFunctionalIDCode("HC");
        gs.setApplicationSendersCode("SUBMITTERS Code");
        gs.setApplicationReceiversCode("RECEIVERS Code");
        gs.setDate("20160524");
        gs.setTime("0616");
        gs.setGroupControlNumber("126");
        gs.setResponsibleAgencyCode("X");
        gs.setVersionReleaseIndustryIDCode("005010X222A1");

        Assert.assertEquals(true, gs.validate());
        Assert.assertEquals(x12, gs.toString());
    }

    @Test
    public void testParseST() {
        String x12 = "ST*837*0001*005010X222A1~";
        ST st = new ST(x12);

        Assert.assertEquals(true, st.validate());
        Assert.assertEquals(x12, st.toString());
        Assert.assertEquals("837", st.getTransactionSetIDCode());
        Assert.assertEquals("0001", st.getTransactionSetControlNumber());
        Assert.assertEquals("005010X222A1", st.getImplementationConventionReference());
    }

    @Test
    public void testCreateST() {
        String x12 = "ST*837*0001*005010X222A1~";
        ST st = new ST();

        st.setTransactionSetIDCode("837");
        st.setTransactionSetControlNumber("0001");
        st.setImplementationConventionReference("005010X222A1");

        Assert.assertEquals(true, st.validate());
        Assert.assertEquals(x12, st.toString());
    }

    @Test
    public void testParseBHT() {
        String x12 = "BHT*0019*00*123*20160525*0616*00~";
        BHT bht = new BHT(x12);

        Assert.assertEquals(true, bht.validate());
        Assert.assertEquals(x12, bht.toString());
        Assert.assertEquals("0019", bht.getHierarchicalStructureCode());
        Assert.assertEquals("00", bht.getTransactionSetPurposeCode());
        Assert.assertEquals("123", bht.getReferenceIdentification());
        Assert.assertEquals("20160525", bht.getDate());
        Assert.assertEquals("0616", bht.getTime());
        Assert.assertEquals("00", bht.getTransactionTypeCode());
    }

    @Test
    public void testCreateBHT() {
        String x12 = "BHT*0019*00*123*20160525*0616*00~";
        BHT bht = new BHT();

        bht.setHierarchicalStructureCode("0019");
        bht.setTransactionSetPurposeCode("00");
        bht.setReferenceIdentification("123");
        bht.setDate("20160525");
        bht.setTime("0616");
        bht.setTransactionTypeCode("00");

        Assert.assertEquals(true, bht.validate());
        Assert.assertEquals(x12, bht.toString());
    }

    @Test
    public void testParseSE() {
        String x12 = "SE*1*0001~";
        SE se = new SE(x12);

        Assert.assertEquals(true, se.validate());
        Assert.assertEquals(x12, se.toString());
        Assert.assertEquals("1", se.getTransactionSegmentCount());
        Assert.assertEquals("0001", se.getTransactionSetControlNumber());
    }

    @Test
    public void testCreateSE() {
        String x12 = "SE*1*0001~";
        SE se = new SE();

        se.setTransactionSegmentCount("1");
        se.setTransactionSetControlNumber("0001");

        Assert.assertEquals(true, se.validate());
        Assert.assertEquals(x12, se.toString());
    }

    @Test
    public void testParseGE() {
        String x12 = "GE*1*0616~";
        GE gs = new GE(x12);

        Assert.assertEquals(true, gs.validate());
        Assert.assertEquals(x12, gs.toString());
        Assert.assertEquals("1", gs.getNumberOfTransactionsSetsIncluded());
        Assert.assertEquals("0616", gs.getGroupControlNumber());
    }

    @Test
    public void testCreateGE() {
        String x12 = "GE*1*0616~";
        GE ge = new GE();

        ge.setNumberOfTransactionsSetsIncluded("1");
        ge.setGroupControlNumber("0616");

        Assert.assertEquals(true, ge.validate());
        Assert.assertEquals(x12, ge.toString());
    }

    @Test
    public void testParseIEA() {
        String x12 = "IEA*1*024277220~";
        IEA iea = new IEA(x12);

        Assert.assertEquals(true, iea.validate());
        Assert.assertEquals(x12, iea.toString());
        Assert.assertEquals("1", iea.getNumberOfIncludedFunctionalGroups());
        Assert.assertEquals("024277220", iea.getInterchangeControlNumber());
    }

    @Test
    public void testCreateIEA() {
        String x12 = "IEA*1*024277220~";
        IEA iea = new IEA();

        iea.setNumberOfIncludedFunctionalGroups("1");
        iea.setInterchangeControlNumber("024277220");

        Assert.assertEquals(true, iea.validate());
        Assert.assertEquals(x12, iea.toString());
    }

    @Test
    public void testParseHL() {
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
    public void testCreateHL() {
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
        Assert.assertEquals("201 PARK AVENUE", n3.getAddressInformation1());
        Assert.assertEquals("SUITE 300", n3.getAddressInformation2());
    }

    @Test
    public void testCreateN3() {
        String x12 = "N3*201 PARK AVENUE*SUITE 300~";
        N3 n3 = new N3();

        n3.setAddressInformation1("201 PARK AVENUE");
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

    @Test
    public void testParseHI() {
        String x12 = "HI*BK:8901*BF:87200*BF:5559~";
        HI hi = new HI(x12);

        Assert.assertEquals(true, hi.validate());
        Assert.assertEquals(x12, hi.toString());
        Assert.assertEquals("BK:8901", hi.getHealthCareCodeInformation1());
        Assert.assertEquals("BF:87200", hi.getHealthCareCodeInformation2());
        Assert.assertEquals("BF:5559", hi.getHealthCareCodeInformation3());
    }

    @Test
    public void testCreateHI() {
        String x12 = "HI*BK:8901*BF:87200*BF:5559~";
        HI hi = new HI();

        hi.setHealthCareCodeInformation1("BK:8901");
        hi.setHealthCareCodeInformation2("BF:87200");
        hi.setHealthCareCodeInformation3("BF:5559");

        Assert.assertEquals(true, hi.validate());
        Assert.assertEquals(x12, hi.toString());
    }

    @Test
    public void testParseDTP() {
        String x12 = "DTP*291*D8*20051015~";
        DTP dtp = new DTP(x12);

        Assert.assertEquals(true, dtp.validate());
        Assert.assertEquals(x12, dtp.toString());
        Assert.assertEquals("291", dtp.getDateTimeQualifier());
        Assert.assertEquals("D8", dtp.getDateTimePeriodFormatQualifier());
        Assert.assertEquals("20051015", dtp.getDateTimePeriod());
    }

    @Test
    public void testCreateDTP() {
        String x12 = "DTP*291*D8*20051015~";
        DTP dtp = new DTP();

        dtp.setDateTimeQualifier("291");
        dtp.setDateTimePeriodFormatQualifier("D8");
        dtp.setDateTimePeriod("20051015");

        Assert.assertEquals(true, dtp.validate());
        Assert.assertEquals(x12, dtp.toString());
    }

    @Test
    public void testParseEQ() {
        String x12 = "EQ*30**FAM~";
        EQ eq = new EQ(x12);

        Assert.assertEquals(true, eq.validate());
        Assert.assertEquals(x12, eq.toString());
        Assert.assertEquals("30", eq.getServiceTypeCode());
        Assert.assertEquals("", eq.getCompositeMedicalProcedureIdentifier());
        Assert.assertEquals("FAM", eq.getCoverageLevelCode());
        Assert.assertEquals("", eq.getInsuranceTypeCode());
        Assert.assertEquals("", eq.getCompositeDiagnosisCodePointer());
    }

    @Test
    public void testCreateEQ() {
        String x12 = "EQ*30**FAM~";
        EQ eq = new EQ();

        eq.setServiceTypeCode("30");
        eq.setCompositeMedicalProcedureIdentifier("");
        eq.setCoverageLevelCode("FAM");
        eq.setInsuranceTypeCode("");
        eq.setCompositeDiagnosisCodePointer("");

        Assert.assertEquals(true, eq.validate());
        Assert.assertEquals(x12, eq.toString());
    }

    @Test
    public void testParseAMT() {
        String x12 = "AMT*R*37.5*D~";
        AMT amt = new AMT(x12);

        Assert.assertEquals(true, amt.validate());
        Assert.assertEquals(x12, amt.toString());
        Assert.assertEquals("R", amt.getAmountQualifierCode());
        Assert.assertEquals("37.5", amt.getMonetaryAmount());
        Assert.assertEquals("D", amt.getCreditDebitFlagCode());
    }

    @Test
    public void testCreateAMT() {
        String x12 = "AMT*R*37.5*D~";
        AMT amt = new AMT();

        amt.setAmountQualifierCode("R");
        amt.setMonetaryAmount("37.5");
        amt.setCreditDebitFlagCode("D");

        Assert.assertEquals(true, amt.validate());
        Assert.assertEquals(x12, amt.toString());
    }

    @Test
    public void testParseIII() {
        String x12 = "III*ZZ*21*AA*BB*1*2*CC*DD*EE~";
        III iii = new III(x12);

        Assert.assertEquals(true, iii.validate());
        Assert.assertEquals(x12, iii.toString());
        Assert.assertEquals("ZZ", iii.getCodeListQualifierCode());
        Assert.assertEquals("21", iii.getIndustryCode());
        Assert.assertEquals("AA", iii.getCodeCategory());
        Assert.assertEquals("BB", iii.getFreeFormMessageText());
        Assert.assertEquals("1", iii.getQuantity());
        Assert.assertEquals("2", iii.getCompositeUnitOfMeasure());
        Assert.assertEquals("CC", iii.getSurfaceLayerPositionCode1());
        Assert.assertEquals("DD", iii.getSurfaceLayerPositionCode2());
        Assert.assertEquals("EE", iii.getSurfaceLayerPositionCode3());
    }

    @Test
    public void testCreateIII() {
        String x12 = "III*ZZ*21*AA*BB*1*2*CC*DD*EE~";
        III iii = new III();

        iii.setCodeListQualifierCode("ZZ");
        iii.setIndustryCode("21");
        iii.setCodeCategory("AA");
        iii.setFreeFormMessageText("BB");
        iii.setQuantity("1");
        iii.setCompositeUnitOfMeasure("2");
        iii.setSurfaceLayerPositionCode1("CC");
        iii.setSurfaceLayerPositionCode2("DD");
        iii.setSurfaceLayerPositionCode3("EE");

        Assert.assertEquals(true, iii.validate());
        Assert.assertEquals(x12, iii.toString());
    }

    @Test
    public void testParseAAA() {
        String x12 = "AAA*Y*79*42*N~";
        AAA aaa = new AAA(x12);

        Assert.assertEquals(true, aaa.validate());
        Assert.assertEquals(x12, aaa.toString());
        Assert.assertEquals("Y", aaa.getYesNoConditionOrResponseCode());
        Assert.assertEquals("79", aaa.getAgencyQualifierCode());
        Assert.assertEquals("42", aaa.getRejectReasonCode());
        Assert.assertEquals("N", aaa.getFollowupActionCode());
    }

    @Test
    public void testCreateAAA() {
        String x12 = "AAA*Y*79*42*N~";
        AAA aaa = new AAA();

        aaa.setYesNoConditionOrResponseCode("Y");
        aaa.setAgencyQualifierCode("79");
        aaa.setRejectReasonCode("42");
        aaa.setFollowupActionCode("N");

        Assert.assertEquals(true, aaa.validate());
        Assert.assertEquals(x12, aaa.toString());
    }

    @Test
    public void testParsePER() {
        String x12 = "PER*IC*MEMBER SERVICES*TE*8005551654*FX*2128769304~";
        PER per = new PER(x12);

        Assert.assertEquals(true, per.validate());
        Assert.assertEquals(x12, per.toString());
        Assert.assertEquals("IC", per.getContactFunctionCode());
        Assert.assertEquals("MEMBER SERVICES", per.getName());
        Assert.assertEquals("TE", per.getCommunicationNumberQualifier1());
        Assert.assertEquals("8005551654", per.getCommunicationNumber1());
        Assert.assertEquals("FX", per.getCommunicationNumberQualifier2());
        Assert.assertEquals("2128769304", per.getCommunicationNumber2());
    }

    @Test
    public void testCreatePER() {
        String x12 = "PER*IC*MEMBER SERVICES*TE*8005551654*FX*2128769304~";
        PER per = new PER();

        per.setContactFunctionCode("IC");
        per.setName("MEMBER SERVICES");
        per.setCommunicationNumberQualifier1("TE");
        per.setCommunicationNumber1("8005551654");
        per.setCommunicationNumberQualifier2("FX");
        per.setCommunicationNumber2("2128769304");

        Assert.assertEquals(true, per.validate());
        Assert.assertEquals(x12, per.toString());
    }

    @Test
    public void testParseMPI() {
        String x12 = "MPI*C*AO*A**L3~";
        MPI mpi = new MPI(x12);

        Assert.assertEquals(true, mpi.validate());
        Assert.assertEquals(x12, mpi.toString());
        Assert.assertEquals("C", mpi.getInformationStatusCode());
        Assert.assertEquals("AO", mpi.getEmploymentStatusCode());
        Assert.assertEquals("A", mpi.getGovernmentServiceAffiliationCode());
        Assert.assertEquals("L3", mpi.getMilitaryServiceRankCode());
    }

    @Test
    public void testCreateMPI() {
        String x12 = "MPI*C*AO*A**L3~";
        MPI mpi = new MPI();

        mpi.setInformationStatusCode("C");
        mpi.setEmploymentStatusCode("AO");
        mpi.setGovernmentServiceAffiliationCode("A");
        mpi.setMilitaryServiceRankCode("L3");

        Assert.assertEquals(true, mpi.validate());
        Assert.assertEquals(x12, mpi.toString());
    }

    @Test
    public void testParseEB() {
        String x12 = "EB*C*FAM****23*600~";
        EB eb = new EB(x12);

        Assert.assertEquals(true, eb.validate());
        Assert.assertEquals(x12, eb.toString());
        Assert.assertEquals("C", eb.getEligibilityOrBenefitInformationCode());
        Assert.assertEquals("FAM", eb.getCoverageLevelCode());
        Assert.assertEquals("23", eb.getTimePeriodQualifier());
        Assert.assertEquals("600", eb.getMonetaryAmount());
    }

    @Test
    public void testCreateEB() {
        String x12 = "EB*C*FAM****23*600~";
        EB eb = new EB();

        eb.setEligibilityOrBenefitInformationCode("C");
        eb.setCoverageLevelCode("FAM");
        eb.setTimePeriodQualifier("23");
        eb.setMonetaryAmount("600");

        Assert.assertEquals(true, eb.validate());
        Assert.assertEquals(x12, eb.toString());
    }

    @Test
    public void testParseHSD() {
        String x12 = "HSD*VS*12*WK*3*34*1~";
        HSD hsd = new HSD(x12);

        Assert.assertEquals(true, hsd.validate());
        Assert.assertEquals(x12, hsd.toString());
        Assert.assertEquals("VS", hsd.getQuantityQualifier());
        Assert.assertEquals("12", hsd.getQuantity());
        Assert.assertEquals("WK", hsd.getUnitOrBasisForMeasurementCode());
        Assert.assertEquals("3", hsd.getSampleSelectionModulus());
        Assert.assertEquals("34", hsd.getTimePeriodQualifier());
        Assert.assertEquals("1", hsd.getNumberOfPeriods());
    }

    @Test
    public void testCreateHSD() {
        String x12 = "HSD*VS*12*WK*3*34*1~";
        HSD hsd = new HSD();

        hsd.setQuantityQualifier("VS");
        hsd.setQuantity("12");
        hsd.setUnitOrBasisForMeasurementCode("WK");
        hsd.setSampleSelectionModulus("3");
        hsd.setTimePeriodQualifier("34");
        hsd.setNumberOfPeriods("1");

        Assert.assertEquals(true, hsd.validate());
        Assert.assertEquals(x12, hsd.toString());
    }

    @Test
    public void testParseMSG() {
        String x12 = "MSG*Free form text is discouraged~";
        MSG msg = new MSG(x12);

        Assert.assertEquals(true, msg.validate());
        Assert.assertEquals(x12, msg.toString());
        Assert.assertEquals("Free form text is discouraged", msg.getFreeFormMessageText());
    }

    @Test
    public void testCreateMSG() {
        String x12 = "MSG*Free form text is discouraged~";
        MSG msg = new MSG();

        msg.setFreeFormMessageText("Free form text is discouraged");

        Assert.assertEquals(true, msg.validate());
        Assert.assertEquals(x12, msg.toString());
    }

    @Test
    public void testParseLS() {
        String x12 = "LS*2120~";
        LS ls = new LS(x12);

        Assert.assertEquals(true, ls.validate());
        Assert.assertEquals(x12, ls.toString());
        Assert.assertEquals("2120", ls.getLoopIdentifierCode());
    }

    @Test
    public void testCreateLS() {
        String x12 = "LS*2120~";
        LS ls = new LS();

        ls.setLoopIdentifierCode("2120");

        Assert.assertEquals(true, ls.validate());
        Assert.assertEquals(x12, ls.toString());
    }

    @Test
    public void testParseLE() {
        String x12 = "LE*2120~";
        LE le = new LE(x12);

        Assert.assertEquals(true, le.validate());
        Assert.assertEquals(x12, le.toString());
        Assert.assertEquals("2120", le.getLoopIdentifierCode());
    }

    @Test
    public void testCreateLE() {
        String x12 = "LE*2120~";
        LE ls = new LE();

        ls.setLoopIdentifierCode("2120");

        Assert.assertEquals(true, ls.validate());
        Assert.assertEquals(x12, ls.toString());
    }
}
