package com.xiaoerge.healthcare.x12.benefit;

import com.sun.org.apache.bcel.internal.generic.DNEG;
import com.xiaoerge.healthcare.x12.IMessage;
import com.xiaoerge.healthcare.x12.StringQueue;
import com.xiaoerge.healthcare.x12.segment.*;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by xiaoerge on 6/11/16.
 */
public class BenefitSubscriber extends IMessage {
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

        messagesDefinition.add(subscriberLevel);
        messagesDefinition.addAll(subscriberTraces);
        messagesDefinition.add(subscriberName);
        messagesDefinition.addAll(additionalIdentification);
        messagesDefinition.add(subscriberAddress);
        messagesDefinition.add(subscriberCityState);
        messagesDefinition.add(providerInformation);
        messagesDefinition.add(subscriberDemographic);
        messagesDefinition.add(multipleBirthSequenceNumber);
        messagesDefinition.add(subscriberHealthCareDiagnosisCode);
        messagesDefinition.add(subscriberDate);
        messagesDefinition.add(subscriberEligibility);
        messagesDefinition.add(subscriberSpendDown);
        messagesDefinition.add(subscriberTotalBilledAmount);
        messagesDefinition.add(subscriberAdditionalEligibility);
        messagesDefinition.add(subscriberAdditionalInformation);
        messagesDefinition.add(subscriberEligibilityDate);
    }
    public BenefitSubscriber(String s) {
        this();
        StringBuilder stringBuilder = new StringBuilder();
        StringQueue stringQueue = new StringQueue(s);

        //todo parsing
    }
}
