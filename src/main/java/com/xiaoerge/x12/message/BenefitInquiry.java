package com.xiaoerge.x12.message;

import com.xiaoerge.x12.benefit.inquiry.BenefitInquiryTransaction;
import com.xiaoerge.x12.control.FunctionalGroup;
import com.xiaoerge.x12.control.InterchangeEnvelope;

/**
 * Created by xiaoerge on 5/23/16.
 */
public class BenefitInquiry extends X12MessageBase {
    public BenefitInquiry(String s) {
        super(s);
        parse();
    }
    public BenefitInquiry(X12MessageBase message) {
        super(message);
        parse();
    }

    private void parse() {
        InterchangeEnvelope envelope = getInterchangeEnvelope();
        for (FunctionalGroup group : envelope.getFunctionalGroups()) {
            for(int i = 0; i < group.getTransactions().size(); i++) {
                group.getTransactions().set(i, new BenefitInquiryTransaction(group.getTransactions().get(i)));
            }
        }
    }
}
