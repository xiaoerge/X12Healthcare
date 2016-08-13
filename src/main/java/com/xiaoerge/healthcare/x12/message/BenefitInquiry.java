package com.xiaoerge.healthcare.x12.message;

import com.xiaoerge.healthcare.x12.X12Message;
import com.xiaoerge.healthcare.x12.benefit.inquiry.BenefitInquiryTransaction;
import com.xiaoerge.healthcare.x12.control.FunctionalGroup;
import com.xiaoerge.healthcare.x12.control.InterchangeEnvelope;

/**
 * Created by xiaoerge on 5/23/16.
 */
public class BenefitInquiry extends X12Message {
    public BenefitInquiry(String s) {
        super(s);
    }
    public BenefitInquiry(X12Message message) {
        super(message);

        InterchangeEnvelope envelope = getInterchangeEnvelope();
        for (FunctionalGroup group : envelope.getFunctionalGroups()) {
            for(int i = 0; i < group.getTransactions().size(); i++) {
                group.getTransactions().set(i, new BenefitInquiryTransaction(group.getTransactions().get(i)));
            }
        }
    }
}
