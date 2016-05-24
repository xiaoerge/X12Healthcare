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

        Assert.assertEquals(isa.toString(), x12);
        Assert.assertEquals(isa.validate(), true);
        Assert.assertEquals(isa.size(), 16);
        Assert.assertEquals(isa.getAuthInfoQualifier(), "00");
        Assert.assertEquals(isa.getAuthInformation(), "...");
        Assert.assertEquals(isa.getSecurityInfoQualifier(), "01");
        Assert.assertEquals(isa.getSecurityInformation(), "SECRET");
        Assert.assertEquals(isa.getInterchangeIDQualifierSender(), "ZZ");
        Assert.assertEquals(isa.getInterchangeSenderID(), "SUBMITTERS...ID");
        Assert.assertEquals(isa.getInterchangeIDQualifierReceiver(), "ZZ");
        Assert.assertEquals(isa.getInterchangeReceiverID(), "RECEIVERS...ID");
        Assert.assertEquals(isa.getInterchangeDate(), "030101");
        Assert.assertEquals(isa.getInterchangeTime(), "1253");
        Assert.assertEquals(isa.getRepetitionSeparator(), "^");
        Assert.assertEquals(isa.getInterchangeControlVersionNumber(), "00602");
        Assert.assertEquals(isa.getInterchangeControlNumber(), "000000905");
        Assert.assertEquals(isa.getAcknowledgmentRequested(), "0");
        Assert.assertEquals(isa.getUsageIndicator(), "T");
        Assert.assertEquals(isa.getComponentElementSeparator(), ":");
    }
}
