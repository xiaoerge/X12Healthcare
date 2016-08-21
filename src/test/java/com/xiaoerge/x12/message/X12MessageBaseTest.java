package com.xiaoerge.x12.message;

import com.xiaoerge.x12.benefit.inquiry.BenefitInquiryInformationSource;
import com.xiaoerge.x12.benefit.inquiry.BenefitInquiryTransaction;
import com.xiaoerge.x12.control.FunctionalGroup;
import com.xiaoerge.x12.control.InterchangeEnvelope;
import com.xiaoerge.x12.control.Transaction;
import com.xiaoerge.x12.util.X12Parser;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by xiaoerge on 5/23/16.
 */
public class X12MessageBaseTest {

    @Test(expected = ClassCastException.class)
    public void testParseBenefitInquiry() {
        String x12 = "ISA*00*          *01*SECRET    *ZZ*SUBMITTERS   ID*ZZ*RECEIVERS    ID*030101*1253*^*00602*000000905*0*T*:~" +
                "GS*HC*SUBMITTERS Code*RECEIVERS Code*20160524*0616*126*X*005010X222A1~" +
                "ST*99*1234*005010X279A1~" +
                "BHT*0022*13*10001234*20060501*1319~" +
                "HL*1**20*1~" +
                "NM1*PR*2*ABC COMPANY*****PI*842610001~" +
                "HL*2*1*21*1~" +
                "NM1*1P*2*BONE AND JOINT CLINIC*****SV*2000035~" +
                "HL*3*2*22*0~" +
                "TRN*1*93175-012547*9877281234~" +
                "NM1*IL*1*SMITH*ROBERT****MI*11122333301~" +
                "DMG*D8*19430519~" +
                "DTP*291*D8*20060501~" +
                "EQ*30~" +
                "HL*4**20*1~" +
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
                "IEA*1*024277220~";

        BenefitInquiry message = (BenefitInquiry) X12Parser.fromX12Message(x12);
    }

    @Test
    public void testCreateX12MessageBase() {
        X12MessageBase messageBase = new X12MessageBase();

        Assert.assertEquals("", messageBase.toString());
        Assert.assertEquals(true, messageBase.isEmpty());
    }
}
