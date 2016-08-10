package com.xiaoerge.healthcare.x12;

import com.xiaoerge.healthcare.x12.benefit.*;
import com.xiaoerge.healthcare.x12.control.*;
import com.xiaoerge.healthcare.x12.message.*;
import com.xiaoerge.healthcare.x12.segment.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by xiaoerge on 5/23/16.
 */
public class BenefitInquiryTest {

    @Test
    public void testParseBenefitInquiry() {
        String x12 = "ISA*00*          *01*SECRET    *ZZ*SUBMITTERS   ID*ZZ*RECEIVERS    ID*030101*1253*^*00602*000000905*0*T*:~" +
                "GS*HC*SUBMITTERS Code*RECEIVERS Code*20160524*0616*126*X*005010X222A1~" +
                    "ST*270*1234*005010X279A1~" +
                        "BHT*0022*13*10001234*20060501*1319~" +
                            "HL*1**20*1~" + //loop
                            "NM1*PR*2*ABC COMPANY*****PI*842610001~" +
                                "HL*2*1*21*1~" +
                                "NM1*1P*2*BONE AND JOINT CLINIC*****SV*2000035~" +
                                    "HL*3*2*22*0~" +
                                    "TRN*1*93175-012547*9877281234~" +
                                    "NM1*IL*1*SMITH*ROBERT****MI*11122333301~" +
                                    "DMG*D8*19430519~" +
                                    "DTP*291*D8*20060501~" +
                                    "EQ*30~" +

                            "HL*4**20*1~" + //new loop
                            "NM1*PR*2*ABC COMPANY*****PI*842610001~" +
                                "HL*5*4*21*1~" +
                                "NM1*1P*2*BONE AND JOINT CLINIC*****SV*2000035~" +
                                    "HL*6*5*22*0~" +
                                    "TRN*1*93175-012547*9877281234~" +
                                    "NM1*IL*1*SMITH*ROBERT****MI*11122333301~" +
                                    "DMG*D8*19430519~" +
                                    "DTP*291*D8*20060501~" +
                                    "EQ*30~" +
                    "SE*13*1234~" +
                "GE*1*0616~" +
                "IEA*1*0616~";

        BenefitInquiry message = (BenefitInquiry) X12Parser.fromX12Message(x12);
        InterchangeEnvelope envelope = message.getInterchangeEnvelope();

        Assert.assertEquals("ISA*00*          *01*SECRET    *ZZ*SUBMITTERS   ID*ZZ*RECEIVERS    ID*030101*1253*^*00602*000000905*0*T*:~",
                envelope.getTransactionSetHeader().toString());
        Assert.assertEquals("IEA*1*0616~", envelope.getTransactionSetTrailer().toString());

        for (FunctionalGroup group : envelope.getFunctionalGroups()) {
            Assert.assertEquals("GS*HC*SUBMITTERS Code*RECEIVERS Code*20160524*0616*126*X*005010X222A1~", group.getFunctionalGroupHeader().toString());
            Assert.assertEquals("GE*1*0616~", group.getFunctionalGroupTrailer().toString());

            for(Transaction transaction : group.getTransactions()) {
                BenefitInquiryTransaction benefitInquiryTransaction = (BenefitInquiryTransaction) transaction;
                Assert.assertEquals("270", benefitInquiryTransaction.getTransactionSetHeader().getTransactionSetIDCode());
                Assert.assertEquals("1234", benefitInquiryTransaction.getTransactionSetHeader().getTransactionSetControlNumber());

                System.out.println(benefitInquiryTransaction.toX12String());
            }
        }

        Assert.assertTrue(message.validate());
        Assert.assertEquals(message.toX12String(), message.toString());
        //Assert.assertEquals(x12, message.toString());
    }
}
