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

        while(stringQueue.hasNext()) {
            String next = stringQueue.getNext();
            if (next.startsWith("EQ")) {
                dependentEligibility = new EQ(next);
            }
            else if (next.startsWith("III")) {
                dependentAdditionalEligibility = new III(next);
            }
            else if (next.startsWith("REF")) {
                dependentAdditionalInformation = new REF(next);
            }
            else if (next.startsWith("DTP")) {
                dependentEligibilityDate = new DTP(next);
            }
        }
    }

    public void loadDefinition() {
        messagesDefinition.clear();

        messagesDefinition.add(dependentEligibility);
        messagesDefinition.add(dependentAdditionalEligibility);
        messagesDefinition.add(dependentAdditionalInformation);
        messagesDefinition.add(dependentEligibilityDate);
    }
}
