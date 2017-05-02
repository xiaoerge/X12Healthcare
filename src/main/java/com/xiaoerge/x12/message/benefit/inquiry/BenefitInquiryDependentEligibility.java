package com.xiaoerge.x12.message.benefit.inquiry;

import com.xiaoerge.x12.message.MessageFormat;
import com.xiaoerge.x12.message.MessageLoop;
import com.xiaoerge.x12.message.segment.DTP;
import com.xiaoerge.x12.message.segment.EQ;
import com.xiaoerge.x12.message.segment.III;
import com.xiaoerge.x12.message.segment.REF;
import com.xiaoerge.x12.util.StringQueue;

/**
 * Created by xiaoerge on 8/13/16.
 */
public class BenefitInquiryDependentEligibility extends MessageLoop {

    private EQ eligibility;
    private III additionalEligibility;
    private REF additionalInformation;
    private DTP eligibilityDate;

    public BenefitInquiryDependentEligibility() {
        eligibility = new EQ();
        additionalEligibility = new III();
        additionalInformation = new REF();
        eligibilityDate = new DTP();
    }
    public BenefitInquiryDependentEligibility(String s, MessageFormat mf) {
        this();
        StringQueue stringQueue = new StringQueue(s, mf);

        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("EQ"))
            eligibility = new EQ(stringQueue.getNext(), mf);
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("III"))
            additionalEligibility = new III(stringQueue.getNext(), mf);
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("REF"))
            additionalInformation = new REF(stringQueue.getNext(), mf);
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("DTP"))
            eligibilityDate = new DTP(stringQueue.getNext(), mf);

        if (stringQueue.hasNext()) {
            logger.warn("Unexpected string in "+this.getClass().getName());
        }
    }

    public void loadDefinition() {
        messagesDefinition.clear();

        messagesDefinition.add(eligibility);
        messagesDefinition.add(additionalEligibility);
        messagesDefinition.add(additionalInformation);
        messagesDefinition.add(eligibilityDate);
    }

    public EQ getEligibility() {
        return eligibility;
    }

    public void setEligibility(EQ eligibility) {
        this.eligibility = eligibility;
    }

    public III getAdditionalEligibility() {
        return additionalEligibility;
    }

    public void setAdditionalEligibility(III additionalEligibility) {
        this.additionalEligibility = additionalEligibility;
    }

    public REF getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(REF additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public DTP getEligibilityDate() {
        return eligibilityDate;
    }

    public void setEligibilityDate(DTP eligibilityDate) {
        this.eligibilityDate = eligibilityDate;
    }
}
