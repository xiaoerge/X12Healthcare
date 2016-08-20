package com.xiaoerge.x12.benefit.inquiry;

import com.xiaoerge.x12.message.MessageBase;
import com.xiaoerge.x12.segment.*;
import com.xiaoerge.x12.util.StringQueue;

/**
 * Created by xiaoerge on 8/13/16.
 */
public class BenefitInquirySubscriberEligibility extends MessageBase {

    private EQ subscriberEligibility;
    private AMT subscriberSpendDown;
    private AMT subscriberTotalBilledAmount;
    private III subscriberAdditionalEligibility;
    private REF subscriberAdditionalInformation;
    private DTP subscriberEligibilityDate;

    public BenefitInquirySubscriberEligibility() {
        subscriberEligibility = new EQ();
        subscriberSpendDown = new AMT();
        subscriberTotalBilledAmount = new AMT();
        subscriberAdditionalEligibility = new III();
        subscriberAdditionalInformation = new REF();
        subscriberEligibilityDate = new DTP();
    }
    public BenefitInquirySubscriberEligibility(String s) {
        this();
        StringQueue stringQueue = new StringQueue(s);

        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("EQ"))
            subscriberEligibility = new EQ(stringQueue.getNext());
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("AMT"))
            subscriberSpendDown = new AMT(stringQueue.getNext());
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("AMT"))
            subscriberTotalBilledAmount = new AMT(stringQueue.getNext());
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("III"))
            subscriberAdditionalEligibility = new III(stringQueue.getNext());
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("REF"))
            subscriberAdditionalInformation = new REF(stringQueue.getNext());
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("DTP"))
            subscriberEligibilityDate = new DTP(stringQueue.getNext());
    }

    public void loadDefinition() {
        messagesDefinition.clear();

        messagesDefinition.add(subscriberEligibility);
        messagesDefinition.add(subscriberSpendDown);
        messagesDefinition.add(subscriberTotalBilledAmount);
        messagesDefinition.add(subscriberAdditionalEligibility);
        messagesDefinition.add(subscriberAdditionalInformation);
        messagesDefinition.add(subscriberEligibilityDate);
    }

    public EQ getSubscriberEligibility() {
        return subscriberEligibility;
    }

    public void setSubscriberEligibility(EQ subscriberEligibility) {
        this.subscriberEligibility = subscriberEligibility;
    }

    public AMT getSubscriberSpendDown() {
        return subscriberSpendDown;
    }

    public void setSubscriberSpendDown(AMT subscriberSpendDown) {
        this.subscriberSpendDown = subscriberSpendDown;
    }

    public AMT getSubscriberTotalBilledAmount() {
        return subscriberTotalBilledAmount;
    }

    public void setSubscriberTotalBilledAmount(AMT subscriberTotalBilledAmount) {
        this.subscriberTotalBilledAmount = subscriberTotalBilledAmount;
    }

    public III getSubscriberAdditionalEligibility() {
        return subscriberAdditionalEligibility;
    }

    public void setSubscriberAdditionalEligibility(III subscriberAdditionalEligibility) {
        this.subscriberAdditionalEligibility = subscriberAdditionalEligibility;
    }

    public REF getSubscriberAdditionalInformation() {
        return subscriberAdditionalInformation;
    }

    public void setSubscriberAdditionalInformation(REF subscriberAdditionalInformation) {
        this.subscriberAdditionalInformation = subscriberAdditionalInformation;
    }

    public DTP getSubscriberEligibilityDate() {
        return subscriberEligibilityDate;
    }

    public void setSubscriberEligibilityDate(DTP subscriberEligibilityDate) {
        this.subscriberEligibilityDate = subscriberEligibilityDate;
    }
}
