package com.xiaoerge.x12.message;

import com.xiaoerge.x12.message.benefit.response.BenefitResponse;
import com.xiaoerge.x12.message.benefit.response.BenefitResponseInformationReceiver;
import com.xiaoerge.x12.message.benefit.response.BenefitResponseInformationSource;
import com.xiaoerge.x12.message.benefit.response.BenefitResponseTransaction;
import com.xiaoerge.x12.message.control.FunctionalGroup;
import com.xiaoerge.x12.message.control.InterchangeEnvelope;
import com.xiaoerge.x12.util.X12Parser;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by xiaoerge on 5/23/16.
 */
public class BenefitResponseTest {

    @Test
    public void testParseBenefitInquiry() {
        String x12 = "ISA*00*          *01*SECRET    *ZZ*SUBMITTERS   ID*ZZ*RECEIVERS    ID*030101*1253*^*00602*000000905*0*T*:~" +
                "GS*HB*89070*RXXXXXX*20130122*16091723*171107529*X*005010X279A1~" +
                "ST*271*0001*005010X279A1~" +
                "BHT*0022*11*536*20130122*16091723~" +
                "HL*1**20*1~" +
                "NM1*PR*2*UNITED CONCORDIA*****NI*89070~" +
                "HL*2*1*21*1~" +
                "NM1*1P*1*PROVIDER*JOE****XX*1999999999~" +
                "HL*3*2*22*0~" +
                "TRN*2*171107529*9CTEXAMPLE*TRADINGPARTNER~" +
                "NM1*IL*1*DOE*JANE****MI*999999999~" +
                "N3*P O BOX 270~" +
                "N4*STREET TOWN*PA*1XXXX~" +
                "DMG*D8*19960605*F~" +
                "INS*Y*18*001*25~" +
                "DTP*307*D8*20121001~" +
                "EB*1*IND*35*IN*6P 058741003 CHIP SC3 PGH~" +
                "DTP*348*D8*20130101~" +
                "DTP*349*D8*20131231~" +
                "MSG*CLAIMS WILL BE PROCESSED ACCORDING TO BENEFIT AND MEMBERSHIP INFORMATION ON OUR FILES AT THE TIME OF PROCESSING. THEREFORE THE INFORMATION CONTAINED WITHIN DOES NOT GUARANTEE REIMBURSEMENT.~" +
                "MSG*GROUP PLAN PAYS IN NETWORK ONLY~" +
                "MSG*PAYMENT IS BASED ON PA CHIP SCHEDULE~" +
                "MSG*NO WAITING PERIOD APPLIES~" +
                "EB*F*IND****23*1500*****Y~" +
                "MSG*NO DEDUCTIBLE APPLIES~" +
                "EB*C*IND*38***32*5200*****Y~" +
                "EB*D*IND*23*****1****Y~" +
                "EB*D*IND******1****Y*AD:D0120~" +
                "HSD*FL*1***34*6~" +
                "EB*D*IND******1****Y*AD:D0150~" +
                "HSD*FL*1***34*6~" +
                "DTP*304*D8*20130114~" +
                "EB*D*IND******1****Y*AD:D0210~" +
                "HSD*FL*1***21*3~" +
                "EB*D*IND******1****Y*AD:D0274~" +
                "HSD*FL*1***34*6~" +
                "DTP*304*D8*20130114~" +
                "EB*D*IND******1****Y*AD:D0330~" +
                "HSD*FL*1***21*3~" +
                "DTP*304*D8*20130114~" +
                "EB*D*IND*41*****1****Y~" +
                "MSG*ORAL CANCER SCREENING IS INTEGRAL TO PROPHY EXAM~" +
                "EB*D*IND******1****Y*AD:D1110~" +
                "HSD*FL*1***34*6~" +
                "DTP*304*D8*20130114~" +
                "EB*D*IND******1****Y*AD:D1208~" +
                "HSD*FL*3***21*1~" +
                "DTP*304*D8*20130114~" +
                "EB*D*IND******1****Y*AD:D1351~" +
                "EB*F********S7*18**Y~" +
                "MSG*APPLIES TO 1ST MOLAR~" +
                "MSG*APPLIES TO 2ND MOLAR~" +
                "EB*D*IND*25*****1****Y~" +
                "EB*D*IND******1****Y*AD:D2393~" +
                "EB*D*IND******1****Y*AD:D2643~" +
                "EB*D*IND******1****Y*AD:D2750~" +
                "MSG*PORCELAIN IS COVERED ON POSTERIOR TEETH~" +
                "EB*D*IND*36*****1****Y~" +
                "MSG*PER TOOTH, PAID ON SEAT DATE~" +
                "MSG*NO MISSING TOOTH CLAUSE EXISTS~" +
                "EB*D*IND******1****Y*AD:D2630~" +
                "EB*D*IND******1****Y*AD:D2950~" +
                "EB*D*IND******1****Y*AD:D2954~" +
                "EB*D*IND*26*****1****Y~" +
                "EB*D*IND******1****Y*AD:D3330~" +
                "EB*D*IND*24*****1****Y~" +
                "EB*D*IND******1****Y*AD:D4260~" +
                "EB*D*IND******1****Y*AD:D4341~" +
                "EB*D*IND******1****Y*AD:D4381~" +
                "MSG*ARESTIN IS INTEGRAL TO PROPHY EXAM~" +
                "EB*D*IND******1****Y*AD:D4910~" +
                "EB*D*IND*39*****1****Y~" +
                "MSG*PER TOOTH, PAID ON SEAT DATE~" +
                "MSG*NO MISSING TOOTH CLAUSE EXISTS~" +
                "EB*D*IND******1****Y*AD:D5225~" +
                "EB*D*IND******1****Y*AD:D5670~" +
                "EB*D*IND******1****Y*AD:D5751~" +
                "EB*D*IND******1****Y*AD:D6750~" +
                "EB*D*IND******1****Y*AD:D6010~" +
                "EB*D*IND******1****Y*AD:D9910~" +
                "EB*D*IND******1****Y*AD:D9940~" +
                "EB*D*IND*40*****1****Y~" +
                "EB*D*IND******1****Y*AD:D7240~" +
                "EB*D*IND*38*****1****Y~" +
                "EB*D*IND**********Y*AD:D8040~" +
                "MSG*PERCENT OF COVERAGE CAN NOT BE DETERMINED~" +
                "SE*85*0001~" +
                "GE*1*171107529~" +
                "IEA*1*171107529~";

        BenefitResponse message = (BenefitResponse) X12Parser.fromX12Message(x12);
        InterchangeEnvelope envelope = message.getInterchangeEnvelope();
        FunctionalGroup group = envelope.getFunctionalGroups().get(0);
        BenefitResponseTransaction transaction = (BenefitResponseTransaction) group.getTransactions().get(0);

        Assert.assertEquals("ISA*00*          *01*SECRET    *ZZ*SUBMITTERS   ID*ZZ*RECEIVERS    ID*030101*1253*^*00602*000000905*0*T*:~", envelope.getTransactionSetHeader().toString());
        Assert.assertEquals("IEA*1*171107529~", envelope.getTransactionSetTrailer().toString());

        Assert.assertEquals(1, envelope.getFunctionalGroups().size());
        Assert.assertTrue(envelope.getFunctionalGroups().get(0).toString()
                .startsWith("GS*HB*89070*RXXXXXX*20130122*16091723*171107529*X*005010X279A1~"));
        Assert.assertTrue(envelope.getFunctionalGroups().get(0).toString()
                .endsWith("GE*1*171107529~"));

        Assert.assertEquals(1, group.getTransactions().size());
        Assert.assertEquals(1, transaction.getInformationSources().size());
        Assert.assertEquals("HL*1**20*1~" +
                "NM1*PR*2*UNITED CONCORDIA*****NI*89070~" +
                "HL*2*1*21*1~" +
                "NM1*1P*1*PROVIDER*JOE****XX*1999999999~" +
                "HL*3*2*22*0~" +
                "TRN*2*171107529*9CTEXAMPLE*TRADINGPARTNER~" +
                "NM1*IL*1*DOE*JANE****MI*999999999~" +
                "N3*P O BOX 270~" +
                "N4*STREET TOWN*PA*1XXXX~" +
                "DMG*D8*19960605*F~" +
                "INS*Y*18*001*25~" +
                "DTP*307*D8*20121001~" +
                "EB*1*IND*35*IN*6P 058741003 CHIP SC3 PGH~" +
                "DTP*348*D8*20130101~" +
                "DTP*349*D8*20131231~" +
                "MSG*CLAIMS WILL BE PROCESSED ACCORDING TO BENEFIT AND MEMBERSHIP INFORMATION ON OUR FILES AT THE TIME OF PROCESSING. THEREFORE THE INFORMATION CONTAINED WITHIN DOES NOT GUARANTEE REIMBURSEMENT.~" +
                "MSG*GROUP PLAN PAYS IN NETWORK ONLY~" +
                "MSG*PAYMENT IS BASED ON PA CHIP SCHEDULE~" +
                "MSG*NO WAITING PERIOD APPLIES~" +
                "EB*F*IND****23*1500*****Y~" +
                "MSG*NO DEDUCTIBLE APPLIES~" +
                "EB*C*IND*38***32*5200*****Y~" +
                "EB*D*IND*23*****1****Y~" +
                "EB*D*IND******1****Y*AD:D0120~" +
                "HSD*FL*1***34*6~" +
                "EB*D*IND******1****Y*AD:D0150~" +
                "HSD*FL*1***34*6~" +
                "DTP*304*D8*20130114~" +
                "EB*D*IND******1****Y*AD:D0210~" +
                "HSD*FL*1***21*3~" +
                "EB*D*IND******1****Y*AD:D0274~" +
                "HSD*FL*1***34*6~" +
                "DTP*304*D8*20130114~" +
                "EB*D*IND******1****Y*AD:D0330~" +
                "HSD*FL*1***21*3~" +
                "DTP*304*D8*20130114~" +
                "EB*D*IND*41*****1****Y~" +
                "MSG*ORAL CANCER SCREENING IS INTEGRAL TO PROPHY EXAM~" +
                "EB*D*IND******1****Y*AD:D1110~" +
                "HSD*FL*1***34*6~" +
                "DTP*304*D8*20130114~" +
                "EB*D*IND******1****Y*AD:D1208~" +
                "HSD*FL*3***21*1~" +
                "DTP*304*D8*20130114~" +
                "EB*D*IND******1****Y*AD:D1351~" +
                "EB*F********S7*18**Y~" +
                "MSG*APPLIES TO 1ST MOLAR~" +
                "MSG*APPLIES TO 2ND MOLAR~" +
                "EB*D*IND*25*****1****Y~" +
                "EB*D*IND******1****Y*AD:D2393~" +
                "EB*D*IND******1****Y*AD:D2643~" +
                "EB*D*IND******1****Y*AD:D2750~" +
                "MSG*PORCELAIN IS COVERED ON POSTERIOR TEETH~" +
                "EB*D*IND*36*****1****Y~" +
                "MSG*PER TOOTH, PAID ON SEAT DATE~" +
                "MSG*NO MISSING TOOTH CLAUSE EXISTS~" +
                "EB*D*IND******1****Y*AD:D2630~" +
                "EB*D*IND******1****Y*AD:D2950~" +
                "EB*D*IND******1****Y*AD:D2954~" +
                "EB*D*IND*26*****1****Y~" +
                "EB*D*IND******1****Y*AD:D3330~" +
                "EB*D*IND*24*****1****Y~" +
                "EB*D*IND******1****Y*AD:D4260~" +
                "EB*D*IND******1****Y*AD:D4341~" +
                "EB*D*IND******1****Y*AD:D4381~" +
                "MSG*ARESTIN IS INTEGRAL TO PROPHY EXAM~" +
                "EB*D*IND******1****Y*AD:D4910~" +
                "EB*D*IND*39*****1****Y~" +
                "MSG*PER TOOTH, PAID ON SEAT DATE~" +
                "MSG*NO MISSING TOOTH CLAUSE EXISTS~" +
                "EB*D*IND******1****Y*AD:D5225~" +
                "EB*D*IND******1****Y*AD:D5670~" +
                "EB*D*IND******1****Y*AD:D5751~" +
                "EB*D*IND******1****Y*AD:D6750~" +
                "EB*D*IND******1****Y*AD:D6010~" +
                "EB*D*IND******1****Y*AD:D9910~" +
                "EB*D*IND******1****Y*AD:D9940~" +
                "EB*D*IND*40*****1****Y~" +
                "EB*D*IND******1****Y*AD:D7240~" +
                "EB*D*IND*38*****1****Y~" +
                "EB*D*IND**********Y*AD:D8040~" +
                "MSG*PERCENT OF COVERAGE CAN NOT BE DETERMINED~", transaction.getInformationSources().get(0).toString());

        BenefitResponseInformationSource informationSource = transaction.getInformationSources().get(0);
        BenefitResponseInformationReceiver informationReceiver = informationSource.getInformationReceivers().get(0);

        Assert.assertEquals("HL*2*1*21*1~" +
                "NM1*1P*1*PROVIDER*JOE****XX*1999999999~" +
                "HL*3*2*22*0~" +
                "TRN*2*171107529*9CTEXAMPLE*TRADINGPARTNER~" +
                "NM1*IL*1*DOE*JANE****MI*999999999~" +
                "N3*P O BOX 270~" +
                "N4*STREET TOWN*PA*1XXXX~" +
                "DMG*D8*19960605*F~" +
                "INS*Y*18*001*25~" +
                "DTP*307*D8*20121001~" +
                "EB*1*IND*35*IN*6P 058741003 CHIP SC3 PGH~" +
                "DTP*348*D8*20130101~" +
                "DTP*349*D8*20131231~" +
                "MSG*CLAIMS WILL BE PROCESSED ACCORDING TO BENEFIT AND MEMBERSHIP INFORMATION ON OUR FILES AT THE TIME OF PROCESSING. THEREFORE THE INFORMATION CONTAINED WITHIN DOES NOT GUARANTEE REIMBURSEMENT.~" +
                "MSG*GROUP PLAN PAYS IN NETWORK ONLY~" +
                "MSG*PAYMENT IS BASED ON PA CHIP SCHEDULE~" +
                "MSG*NO WAITING PERIOD APPLIES~" +
                "EB*F*IND****23*1500*****Y~" +
                "MSG*NO DEDUCTIBLE APPLIES~" +
                "EB*C*IND*38***32*5200*****Y~" +
                "EB*D*IND*23*****1****Y~" +
                "EB*D*IND******1****Y*AD:D0120~" +
                "HSD*FL*1***34*6~" +
                "EB*D*IND******1****Y*AD:D0150~" +
                "HSD*FL*1***34*6~" +
                "DTP*304*D8*20130114~" +
                "EB*D*IND******1****Y*AD:D0210~" +
                "HSD*FL*1***21*3~" +
                "EB*D*IND******1****Y*AD:D0274~" +
                "HSD*FL*1***34*6~" +
                "DTP*304*D8*20130114~" +
                "EB*D*IND******1****Y*AD:D0330~" +
                "HSD*FL*1***21*3~" +
                "DTP*304*D8*20130114~" +
                "EB*D*IND*41*****1****Y~" +
                "MSG*ORAL CANCER SCREENING IS INTEGRAL TO PROPHY EXAM~" +
                "EB*D*IND******1****Y*AD:D1110~" +
                "HSD*FL*1***34*6~" +
                "DTP*304*D8*20130114~" +
                "EB*D*IND******1****Y*AD:D1208~" +
                "HSD*FL*3***21*1~" +
                "DTP*304*D8*20130114~" +
                "EB*D*IND******1****Y*AD:D1351~" +
                "EB*F********S7*18**Y~" +
                "MSG*APPLIES TO 1ST MOLAR~" +
                "MSG*APPLIES TO 2ND MOLAR~" +
                "EB*D*IND*25*****1****Y~" +
                "EB*D*IND******1****Y*AD:D2393~" +
                "EB*D*IND******1****Y*AD:D2643~" +
                "EB*D*IND******1****Y*AD:D2750~" +
                "MSG*PORCELAIN IS COVERED ON POSTERIOR TEETH~" +
                "EB*D*IND*36*****1****Y~" +
                "MSG*PER TOOTH, PAID ON SEAT DATE~" +
                "MSG*NO MISSING TOOTH CLAUSE EXISTS~" +
                "EB*D*IND******1****Y*AD:D2630~" +
                "EB*D*IND******1****Y*AD:D2950~" +
                "EB*D*IND******1****Y*AD:D2954~" +
                "EB*D*IND*26*****1****Y~" +
                "EB*D*IND******1****Y*AD:D3330~" +
                "EB*D*IND*24*****1****Y~" +
                "EB*D*IND******1****Y*AD:D4260~" +
                "EB*D*IND******1****Y*AD:D4341~" +
                "EB*D*IND******1****Y*AD:D4381~" +
                "MSG*ARESTIN IS INTEGRAL TO PROPHY EXAM~" +
                "EB*D*IND******1****Y*AD:D4910~" +
                "EB*D*IND*39*****1****Y~" +
                "MSG*PER TOOTH, PAID ON SEAT DATE~" +
                "MSG*NO MISSING TOOTH CLAUSE EXISTS~" +
                "EB*D*IND******1****Y*AD:D5225~" +
                "EB*D*IND******1****Y*AD:D5670~" +
                "EB*D*IND******1****Y*AD:D5751~" +
                "EB*D*IND******1****Y*AD:D6750~" +
                "EB*D*IND******1****Y*AD:D6010~" +
                "EB*D*IND******1****Y*AD:D9910~" +
                "EB*D*IND******1****Y*AD:D9940~" +
                "EB*D*IND*40*****1****Y~" +
                "EB*D*IND******1****Y*AD:D7240~" +
                "EB*D*IND*38*****1****Y~" +
                "EB*D*IND**********Y*AD:D8040~" +
                "MSG*PERCENT OF COVERAGE CAN NOT BE DETERMINED~", informationReceiver.toString());

        Assert.assertEquals(1, informationReceiver.getSubscribers().size());
        Assert.assertEquals(41, informationReceiver.getSubscribers().get(0).getEligibilities().size());
        Assert.assertEquals(0, informationReceiver.getSubscribers().get(0).getDependents().size());

        Assert.assertTrue(message.validate());
        Assert.assertEquals(x12, message.toString());
    }

    @Test
    public void testParseCreateBenefitInquiry() {
        String x12 = "ISA*00*          *01*SECRET    *ZZ*SUBMITTERS   ID*ZZ*RECEIVERS    ID*030101*1253*^*00602*000000905*0*T*:~" +
                "GS*HB*89070*RXXXXXX*20130122*16091723*171107529*X*005010X279A1~" +
                "ST*271*0001*005010X279A1~" +
                "BHT*0022*11*536*20130122*16091723~" +
                "HL*1**20*1~" +
                "NM1*PR*2*UNITED CONCORDIA*****NI*89070~" +
                "HL*2*1*21*1~" +
                "NM1*1P*1*PROVIDER*JOE****XX*1999999999~" +
                "HL*3*2*22*0~" +
                "TRN*2*171107529*9CTEXAMPLE*TRADINGPARTNER~" +
                "NM1*IL*1*DOE*JANE****MI*999999999~" +
                "N3*P O BOX 270~" +
                "N4*STREET TOWN*PA*1XXXX~" +
                "DMG*D8*19960605*F~" +
                "INS*Y*18*001*25~" +
                "DTP*307*D8*20121001~" +
                "EB*1*IND*35*IN*6P 058741003 CHIP SC3 PGH~" +
                "DTP*348*D8*20130101~" +
                "DTP*349*D8*20131231~" +
                "MSG*CLAIMS WILL BE PROCESSED ACCORDING TO BENEFIT AND MEMBERSHIP INFORMATION ON OUR FILES AT THE TIME OF PROCESSING. THEREFORE THE INFORMATION CONTAINED WITHIN DOES NOT GUARANTEE REIMBURSEMENT.~" +
                "MSG*GROUP PLAN PAYS IN NETWORK ONLY~" +
                "MSG*PAYMENT IS BASED ON PA CHIP SCHEDULE~" +
                "MSG*NO WAITING PERIOD APPLIES~" +
                "EB*F*IND****23*1500*****Y~" +
                "MSG*NO DEDUCTIBLE APPLIES~" +
                "EB*C*IND*38***32*5200*****Y~" +
                "EB*D*IND*23*****1****Y~" +
                "EB*D*IND******1****Y*AD:D0120~" +
                "HSD*FL*1***34*6~" +
                "EB*D*IND******1****Y*AD:D0150~" +
                "HSD*FL*1***34*6~" +
                "DTP*304*D8*20130114~" +
                "EB*D*IND******1****Y*AD:D0210~" +
                "HSD*FL*1***21*3~" +
                "EB*D*IND******1****Y*AD:D0274~" +
                "HSD*FL*1***34*6~" +
                "DTP*304*D8*20130114~" +
                "EB*D*IND******1****Y*AD:D0330~" +
                "HSD*FL*1***21*3~" +
                "DTP*304*D8*20130114~" +
                "EB*D*IND*41*****1****Y~" +
                "MSG*ORAL CANCER SCREENING IS INTEGRAL TO PROPHY EXAM~" +
                "EB*D*IND******1****Y*AD:D1110~" +
                "HSD*FL*1***34*6~" +
                "DTP*304*D8*20130114~" +
                "EB*D*IND******1****Y*AD:D1208~" +
                "HSD*FL*3***21*1~" +
                "DTP*304*D8*20130114~" +
                "EB*D*IND******1****Y*AD:D1351~" +
                "EB*F********S7*18**Y~" +
                "MSG*APPLIES TO 1ST MOLAR~" +
                "MSG*APPLIES TO 2ND MOLAR~" +
                "EB*D*IND*25*****1****Y~" +
                "EB*D*IND******1****Y*AD:D2393~" +
                "EB*D*IND******1****Y*AD:D2643~" +
                "EB*D*IND******1****Y*AD:D2750~" +
                "MSG*PORCELAIN IS COVERED ON POSTERIOR TEETH~" +
                "EB*D*IND*36*****1****Y~" +
                "MSG*PER TOOTH, PAID ON SEAT DATE~" +
                "MSG*NO MISSING TOOTH CLAUSE EXISTS~" +
                "EB*D*IND******1****Y*AD:D2630~" +
                "EB*D*IND******1****Y*AD:D2950~" +
                "EB*D*IND******1****Y*AD:D2954~" +
                "EB*D*IND*26*****1****Y~" +
                "EB*D*IND******1****Y*AD:D3330~" +
                "EB*D*IND*24*****1****Y~" +
                "EB*D*IND******1****Y*AD:D4260~" +
                "EB*D*IND******1****Y*AD:D4341~" +
                "EB*D*IND******1****Y*AD:D4381~" +
                "MSG*ARESTIN IS INTEGRAL TO PROPHY EXAM~" +
                "EB*D*IND******1****Y*AD:D4910~" +
                "EB*D*IND*39*****1****Y~" +
                "MSG*PER TOOTH, PAID ON SEAT DATE~" +
                "MSG*NO MISSING TOOTH CLAUSE EXISTS~" +
                "EB*D*IND******1****Y*AD:D5225~" +
                "EB*D*IND******1****Y*AD:D5670~" +
                "EB*D*IND******1****Y*AD:D5751~" +
                "EB*D*IND******1****Y*AD:D6750~" +
                "EB*D*IND******1****Y*AD:D6010~" +
                "EB*D*IND******1****Y*AD:D9910~" +
                "EB*D*IND******1****Y*AD:D9940~" +
                "EB*D*IND*40*****1****Y~" +
                "EB*D*IND******1****Y*AD:D7240~" +
                "EB*D*IND*38*****1****Y~" +
                "EB*D*IND**********Y*AD:D8040~" +
                "MSG*PERCENT OF COVERAGE CAN NOT BE" +
                "DETERMINED~" +
                "SE*85*0001~" +
                "GE*1*171107529~" +
                "IEA*1*171107529~";

        String x12271 = "ISA*00*          *00*          *ZZ*EMEDNYBAT      *ZZ*ETIN           *110101*0100*^*00501*000000001*0*T*:~GS*HB*EMEDNYBAT*ETIN*20110101*010000*1*X*005010X279A1~ST*271*00001*005010X279A1~BHT*0022*11*100270*20110101*010000~HL*1**20*1~NM1*PR*2*NYSDOH*****FI*141797357~PER*IC*eMedNY Provider Services*TE*8003439000*UR*www.emedny.org~HL*2*1*21*1~NM1*1P*2*Busy Provider*****XX*1234567891~HL*3*2*22*0~TRN*2*110010101000002*1141540488*274807891~NM1*IL*1*Patient Last Name*Patient First Name****MI*XX99999X~REF*SY*123456789~N3*123 Any Street~N4*Any Town*NY*11111~DMG*D8*10010101*M~DTP*472*D8*20100608~DTP*346*D8*20100601~DTP*102*D8*19940501~EB*1*IND*30**MA Eligible~MSG*35~MSG*46~MSG*49~MSG*95~MSG*RECERT MONTH=12~EB*B*IND*30****0~EB*1*IND*1~EB*1*IND*35~EB*1*IND*47~EB*1*IND*86~EB*1*IND*88~EB*N*IND*88~LS*2120~NM1*P3*2*Benefit Related Provider*****XX*1987654321~LE*2120~EB*1*IND*98~EB*1*IND*AL~EB*1*IND*MH~EB*1*IND*UC~EB*N*IND*CQ~LS*2120~NM1*P3*2*Benefit Related Provider*****XX*9995995661~LE*2120~EB*R*IND*30~REF*18*012345679C1~LS*2120~NM1*P4*2*MEDICARE ABD~LE*2120~SE*47*00001~GE*1*1~IEA*1*000000001~";

        BenefitResponse message = (BenefitResponse) X12Parser.fromX12Message(x12);
        BenefitResponse message2 = new BenefitResponse(message.toString());
        BenefitResponse message3 = (BenefitResponse) X12Parser.fromX12Message(x12271);

        Assert.assertEquals(x12, message.toString());
        Assert.assertEquals(x12, message2.toString());
        Assert.assertEquals(x12271, message3.toString());
    }
}
