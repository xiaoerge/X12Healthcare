package com.xiaoerge.healthcare.x12.benefit.inquiry;

import com.xiaoerge.healthcare.x12.IMessage;
import com.xiaoerge.healthcare.x12.StringQueue;
import com.xiaoerge.healthcare.x12.segment.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoerge on 8/13/16.
 */
public class BenefitInquiryDependentEligibility extends IMessage {

    private List<EQ> dependentEligibility;
    private List<III> dependentAdditionalEligibility;
    private List<REF> dependentAdditionalInformation;
    private List<DTP> dependentEligibilityDate;

    public BenefitInquiryDependentEligibility() {
        dependentEligibility = new ArrayList<EQ>();
        dependentAdditionalEligibility = new ArrayList<III>();
        dependentAdditionalInformation = new ArrayList<REF>();
        dependentEligibilityDate = new ArrayList<DTP>();
    }
    public BenefitInquiryDependentEligibility(String s) {
        this();
        StringQueue stringQueue = new StringQueue(s);

        //inquiry  99 times
        for(int i = 0; i < 99 && stringQueue.hasNext(); i++) {

        }
    }

    public void loadDefinition() {
        messagesDefinition.clear();
        //inquiry 2110D
    }
}
