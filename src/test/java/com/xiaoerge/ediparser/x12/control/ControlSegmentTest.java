package com.xiaoerge.ediparser.x12.control;

import com.xiaoerge.ediparser.x12.segment.*;
import org.junit.*;

/**
 * Created by xiaoerge on 5/23/16.
 */
public class ControlSegmentTest {

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
        GE gs = new GE();

        gs.setNumberOfTransactionsSetsIncluded("1");
        gs.setGroupControlNumber("0616");

        Assert.assertEquals(true, gs.validate());
        Assert.assertEquals(x12, gs.toString());
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
}
