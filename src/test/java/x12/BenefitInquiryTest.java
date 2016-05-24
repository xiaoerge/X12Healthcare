package x12;

import org.junit.Assert;
import org.junit.Test;
import x12.segment.ISA;

/**
 * Created by xiaoerge on 5/23/16.
 */
public class BenefitInquiryTest  {

    @Test
    public void testEmptyCollection() {
        String x12 = "ISA*00**01*SECRET*ZZ*SUBMITTERS ID*ZZ*RECEIVERS ID*030101*1253*^*00602*000000905*0*T*:~";

        ISA isa = new ISA(x12, Character.toString('*'));

        Assert.assertEquals(isa.toString(), x12);
        Assert.assertEquals(isa.validate(), true);
        Assert.assertEquals(isa.size(), 16);
        Assert.assertEquals(isa.getAuthorInfoQualifier(), "00");
    }
}
