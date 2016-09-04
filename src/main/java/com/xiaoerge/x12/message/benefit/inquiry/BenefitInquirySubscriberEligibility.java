package com.xiaoerge.x12.message.benefit.inquiry;

import com.xiaoerge.x12.message.MessageBase;
import com.xiaoerge.x12.message.segment.*;
import com.xiaoerge.x12.util.StringQueue;

/**
 * Created by xiaoerge on 8/13/16.
 */
public class BenefitInquirySubscriberEligibility extends MessageBase {

    private EQ eligibility;
    private AMT spendDown;
    private AMT totalBilledAmount;
    private III additionalEligibility;
    private REF additionalInformation;
    private DTP eligibilityDate;

    public BenefitInquirySubscriberEligibility() {
        eligibility = new EQ();
        spendDown = new AMT();
        totalBilledAmount = new AMT();
        additionalEligibility = new III();
        additionalInformation = new REF();
        eligibilityDate = new DTP();
    }
    public BenefitInquirySubscriberEligibility(String s) {
        this();
        StringQueue stringQueue = new StringQueue(s);

        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("EQ"))
            eligibility = new EQ(stringQueue.getNext());
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("AMT"))
            spendDown = new AMT(stringQueue.getNext());
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("AMT"))
            totalBilledAmount = new AMT(stringQueue.getNext());
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("III"))
            additionalEligibility = new III(stringQueue.getNext());
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("REF"))
            additionalInformation = new REF(stringQueue.getNext());
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("DTP"))
            eligibilityDate = new DTP(stringQueue.getNext());
    }

    public void loadDefinition() {
        messagesDefinition.clear();

        messagesDefinition.add(eligibility);
        messagesDefinition.add(spendDown);
        messagesDefinition.add(totalBilledAmount);
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

    public AMT getSpendDown() {
        return spendDown;
    }

    public void setSpendDown(AMT spendDown) {
        this.spendDown = spendDown;
    }

    public AMT getTotalBilledAmount() {
        return totalBilledAmount;
    }

    public void setTotalBilledAmount(AMT totalBilledAmount) {
        this.totalBilledAmount = totalBilledAmount;
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
