package com.xiaoerge.healthcare.x12.benefit.inquiry;

import com.xiaoerge.healthcare.x12.IMessage;
import com.xiaoerge.healthcare.x12.StringQueue;
import com.xiaoerge.healthcare.x12.segment.*;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaoerge on 8/13/16.
 */
public class BenefitInquiryDependentEligibility extends IMessage {

    private EQ dependentEligibility;
    private III dependentAdditionalEligibility;
    private REF dependentAdditionalInformation;
    private DTP dependentEligibilityDate;

    public BenefitInquiryDependentEligibility() {
        dependentEligibility = new EQ();
        dependentAdditionalEligibility = new III();
        dependentAdditionalInformation = new REF();
        dependentEligibilityDate = new DTP();
    }
    public BenefitInquiryDependentEligibility(String s) {
        this();
        StringQueue stringQueue = new StringQueue(s);

        if (stringQueue.peekNext().startsWith("EQ")) dependentEligibility = new EQ(stringQueue.getNext());
        if (stringQueue.peekNext().startsWith("III")) dependentAdditionalEligibility = new III(stringQueue.getNext());
        if (stringQueue.peekNext().startsWith("REF")) dependentAdditionalInformation = new REF(stringQueue.getNext());
        if (stringQueue.peekNext().startsWith("DTP")) dependentEligibilityDate = new DTP(stringQueue.getNext());

        if (stringQueue.hasNext()) {
            logger.warn("Unexpected string in BenefitInquiryDependentEligibility");
        }
    }

    public void loadDefinition() {
        messagesDefinition.clear();

        messagesDefinition.add(dependentEligibility);
        messagesDefinition.add(dependentAdditionalEligibility);
        messagesDefinition.add(dependentAdditionalInformation);
        messagesDefinition.add(dependentEligibilityDate);
    }

    public EQ getDependentEligibility() {
        return dependentEligibility;
    }

    public void setDependentEligibility(EQ dependentEligibility) {
        this.dependentEligibility = dependentEligibility;
    }

    public III getDependentAdditionalEligibility() {
        return dependentAdditionalEligibility;
    }

    public void setDependentAdditionalEligibility(III dependentAdditionalEligibility) {
        this.dependentAdditionalEligibility = dependentAdditionalEligibility;
    }

    public REF getDependentAdditionalInformation() {
        return dependentAdditionalInformation;
    }

    public void setDependentAdditionalInformation(REF dependentAdditionalInformation) {
        this.dependentAdditionalInformation = dependentAdditionalInformation;
    }

    public DTP getDependentEligibilityDate() {
        return dependentEligibilityDate;
    }

    public void setDependentEligibilityDate(DTP dependentEligibilityDate) {
        this.dependentEligibilityDate = dependentEligibilityDate;
    }
}
