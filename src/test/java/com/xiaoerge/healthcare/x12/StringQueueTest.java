package com.xiaoerge.healthcare.x12;

import com.xiaoerge.healthcare.x12.segment.ISA;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by xiaoerge on 5/30/16.
 */
public class StringQueueTest {

    @Test
    public void testStringQueueCreate() {
        String x12 = "ISA*00*          *01*SECRET    *ZZ*SUBMITTERS   ID*ZZ*RECEIVERS    ID*030101*1253*^*00602*000000905*0*T*:~" +
                "GS*HC*SUBMITTERS Code*RECEIVERS Code*20160524*0616*126*X*005010X222A1~" +
                "ST*270*1234*005010X279A1~" +
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
                "SE*13*1234~" +
                "GE*1*0616~" +
                "IEA*1*0616~";

        StringQueue stringQueue = new StringQueue(x12);

        Assert.assertTrue(stringQueue.getHeader().startsWith("ISA"));
        Assert.assertTrue(stringQueue.getContent().startsWith("GS"));
        Assert.assertTrue(stringQueue.getTrailer().startsWith("IEA"));
    }

    public void testStringQueueLoop() {

        String x12 = "ISA*00*          *01*SECRET    *ZZ*SUBMITTERS   ID*ZZ*RECEIVERS    ID*030101*1253*^*00602*000000905*0*T*:~" +
                "GS*HC*SUBMITTERS Code*RECEIVERS Code*20160524*0616*126*X*005010X222A1~" +
                "ST*270*1234*005010X279A1~" +
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
                "SE*13*1234~" +
                "GE*1*0616~" +
                "IEA*1*0616~";

        StringQueue stringQueue = new StringQueue(x12);

        while (stringQueue.hasNext()) {
            Assert.assertNotEquals(stringQueue.getHeader(), stringQueue.getNext());
            Assert.assertNotEquals(stringQueue.getTrailer(), stringQueue.getNext());

            Assert.assertTrue(!stringQueue.getNext().startsWith("ISA"));
            Assert.assertTrue(!stringQueue.getNext().startsWith("GS"));
            Assert.assertTrue(!stringQueue.getNext().startsWith("GE"));
            Assert.assertTrue(!stringQueue.getNext().startsWith("IEA"));
            Assert.assertTrue(stringQueue.getNext().endsWith("~"));
        }
    }
}
