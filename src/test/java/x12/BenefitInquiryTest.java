package x12;

import org.junit.Assert;
import org.junit.Test;
import x12.segment.ISA;

/**
 * Created by xiaoerge on 5/23/16.
 */
public class BenefitInquiryTest  {

    @Test
    public void testParseISA() {
        String x12 = "ISA*00*...*01*SECRET*ZZ*SUBMITTERS...ID*ZZ*RECEIVERS...ID*030101*1253*^*00602*000000905*0*T*:~";

        ISA isa = new ISA(x12, Character.toString('*'));

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
}
