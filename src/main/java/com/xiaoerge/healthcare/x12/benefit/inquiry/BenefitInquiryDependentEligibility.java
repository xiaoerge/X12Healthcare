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

    private List<EQ> dependentEligibility;
    private Map<EQ, III> dependentAdditionalEligibility;
    private Map<EQ, REF> dependentAdditionalInformation;
    private Map<EQ, DTP> dependentEligibilityDate;

    public BenefitInquiryDependentEligibility() {
        dependentEligibility = new ArrayList<EQ>();
        dependentAdditionalEligibility = new Hashtable<EQ, III>();
        dependentAdditionalInformation = new Hashtable<EQ, REF>();
        dependentEligibilityDate = new Hashtable<EQ, DTP>();
    }
    public BenefitInquiryDependentEligibility(String s) {
        this();
        StringQueue stringQueue = new StringQueue(s);
        EQ key = null;

        int repeat = 99; //loop goes up to 99
        for(int i = 0; i < repeat && stringQueue.hasNext(); i++) {
            String next = stringQueue.getNext();

            if (next.startsWith("EQ")) {
                key = new EQ(next);
                dependentEligibility.add(key);
            }
            else if (next.startsWith("III")) {
                if (key != null) dependentAdditionalEligibility.put(key, new III(next));
            }
            if (next.startsWith("REF")) {
                if (key != null) dependentAdditionalInformation.put(key, new REF(next));
            }
            if (next.startsWith("DTP")) {
                if (key != null) dependentEligibilityDate.put(key, new DTP(next));
            }
        }
    }

    public void loadDefinition() {
        messagesDefinition.clear();

        for (EQ key : dependentEligibility) {
            messagesDefinition.add(key);

            III iiiVal = dependentAdditionalEligibility.get(key);
            if (iiiVal != null) messagesDefinition.add(iiiVal);

            REF refVal = dependentAdditionalInformation.get(key);
            if (refVal != null) messagesDefinition.add(refVal);

            DTP dtpVal = dependentEligibilityDate.get(key);
            if (dtpVal != null) messagesDefinition.add(dtpVal);
        }
    }
}
