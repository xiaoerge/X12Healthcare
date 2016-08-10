package com.xiaoerge.healthcare.x12.benefit;

import com.xiaoerge.healthcare.x12.IMessage;
import com.xiaoerge.healthcare.x12.segment.*;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by xiaoerge on 6/11/16.
 */
public class BenefitSubscriber implements IMessage {
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
    private HL subscriberLevel;
    private List<TRN> subscriberTraces;
    private NM1 subscriberName;
    private List<REF> additionalIdentification;
    private N3 subscriberAddress;
    private N4 subscriberCityState;
    private PRV providerInformation;
    private DMG subscriberDemographic;
    private INS multipleBirthSequenceNumber;
    private HI subscriberHealthCareDiagnosisCode;
    private DTP subscriberDate;
    private EQ subscriberEligibility;
    private AMT subscriberSpendDown;
    private AMT subscriberTotalBilledAmount;
    private III subscriberAdditionalEligibility;
    private REF subscriberAdditionalInformation;
    private DTP subscriberEligibilityDate;

    public BenefitSubscriber() {
        subscriberLevel = new HL();
        subscriberTraces = new ArrayList<TRN>();
        subscriberName = new NM1();
        additionalIdentification = new ArrayList<REF>();
        subscriberAddress = new N3();
        subscriberCityState = new N4();
        providerInformation = new PRV();
        subscriberDemographic = new DMG();
        multipleBirthSequenceNumber = new INS();
        subscriberHealthCareDiagnosisCode = new HI();
        subscriberDate = new DTP();
        subscriberEligibility = new EQ();
        subscriberSpendDown = new AMT();
        subscriberTotalBilledAmount = new AMT();
        subscriberAdditionalEligibility = new III();
        subscriberAdditionalInformation = new REF();
        subscriberEligibilityDate = new DTP();
    }
    public BenefitSubscriber(String s) {
    }

    public boolean validate() {
        return false;
    }

    public String toX12String() {
        return null;
    }

    public boolean isEmpty() {
        return false;
    }
}
