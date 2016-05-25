package com.xiaoerge.x12;

import org.junit.Assert;
import org.junit.Test;
import com.xiaoerge.x12.segment.GS;
import com.xiaoerge.x12.segment.ISA;

/**
 * Created by xiaoerge on 5/23/16.
 */
public class X12MessageTest {

    @Test
    public void testParseISA() {
        String x12 = "ISA*00*...*01*SECRET*ZZ*SUBMITTERS...ID*ZZ*RECEIVERS...ID*030101*1253*^*00602*000000905*0*T*:~";
        ISA isa = new ISA(x12);

        Assert.assertEquals(x12, isa.toString());
        Assert.assertEquals(true, isa.validate());
        Assert.assertEquals(16, isa.size());
        Assert.assertEquals("00", isa.getAuthInfoQualifier());
        Assert.assertEquals("...", isa.getAuthInformation());
        Assert.assertEquals("01", isa.getSecurityInfoQualifier());
        Assert.assertEquals("SECRET", isa.getSecurityInformation());
        Assert.assertEquals("ZZ", isa.getInterchangeIDQualifierSender());
        Assert.assertEquals("SUBMITTERS...ID", isa.getInterchangeSenderID());
        Assert.assertEquals("ZZ", isa.getInterchangeIDQualifierReceiver());
        Assert.assertEquals("RECEIVERS...ID", isa.getInterchangeReceiverID());
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
        String x12 = "ISA*00*...*01*SECRET*ZZ*SUBMITTERS...ID*ZZ*RECEIVERS...ID*030101*1253*^*00602*000000905*0*T*:~";
        ISA isa = new ISA();

        isa.setAuthInfoQualifier("00");
        isa.setAuthInformation("...");
        isa.setSecurityInfoQualifier("01");
        isa.setSecurityInformation("SECRET");
        isa.setInterchangeIDQualifierSender("ZZ");
        isa.setInterchangeSenderID("SUBMITTERS...ID");
        isa.setInterchangeIDQualifierReceiver("ZZ");
        isa.setInterchangeReceiverID("RECEIVERS...ID");
        isa.setInterchangeDate("030101");
        isa.setInterchangeTime("1253");
        isa.setRepetitionSeparator("^");
        isa.setInterchangeControlVersionNumber("00602");
        isa.setInterchangeControlNumber("000000905");
        isa.setAcknowledgmentRequested("0");
        isa.setUsageIndicator("T");
        isa.setComponentElementSeparator(":");

        Assert.assertEquals(x12, isa.toString());
    }

    @Test
    public void testParseGS() {
        String x12 = "GS*HC*SUBMITTERS...Code*RECEIVERS...Code*20160524*0616*126*X*005010X222A1~";
        GS gs = new GS(x12);

        Assert.assertEquals(x12, gs.toString());
        Assert.assertEquals(true, gs.validate());
        Assert.assertEquals("HC", gs.getFunctionalIDCode());
        Assert.assertEquals("SUBMITTERS...Code", gs.getApplicationSendersCode());
        Assert.assertEquals("RECEIVERS...Code", gs.getApplicationReceiversCode());
        Assert.assertEquals("20160524", gs.getDate());
        Assert.assertEquals("0616", gs.getTime());
        Assert.assertEquals("126", gs.getGroupControlNumber());
        Assert.assertEquals("X", gs.getResponsibleAgencyCode());
        Assert.assertEquals("005010X222A1", gs.getVersionReleaseIndustryIDCode());
    }

    @Test
    public void testCreateGS() {
        String x12 = "GS*HC*SUBMITTERS...Code*RECEIVERS...Code*20160524*0616*126*X*005010X222A1~";
        GS gs = new GS();

        gs.setFunctionalIDCode("HC");
        gs.setApplicationSendersCode("SUBMITTERS...Code");
        gs.setApplicationReceiversCode("RECEIVERS...Code");
        gs.setDate("20160524");
        gs.setTime("0616");
        gs.setGroupControlNumber("126");
        gs.setResponsibleAgencyCode("X");
        gs.setVersionReleaseIndustryIDCode("005010X222A1");

        Assert.assertEquals(x12, gs.toString());
    }
}
