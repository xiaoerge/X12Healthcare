package com.xiaoerge.x12.message.benefit.inquiry;

import com.xiaoerge.x12.message.X12Message;
import com.xiaoerge.x12.message.control.FunctionalGroup;
import com.xiaoerge.x12.message.control.InterchangeEnvelope;

/**
 * Created by xiaoerge on 5/23/16.
 */
public class BenefitInquiry extends X12Message {
    public BenefitInquiry(String s) {
        super(s);
        parse();
    }
    public BenefitInquiry(X12Message message) {
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
