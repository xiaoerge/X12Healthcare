package com.xiaoerge.x12.message.claim.payment;

import com.xiaoerge.x12.message.X12MessageBase;
import com.xiaoerge.x12.message.control.FunctionalGroup;
import com.xiaoerge.x12.message.control.InterchangeEnvelope;

/**
 * Created by xiaoerge on 9/3/16.
 */
public class ClaimPayment extends X12MessageBase {
    public ClaimPayment(String s) {
        super(s);
        parse();
    }
    public ClaimPayment(X12MessageBase message) {
        super(message);
        parse();
    }

    private void parse() {
        InterchangeEnvelope envelope = getInterchangeEnvelope();
        for (FunctionalGroup group : envelope.getFunctionalGroups()) {
            for(int i = 0; i < group.getTransactions().size(); i++) {
                group.getTransactions().set(i, new ClaimPaymentTransaction(group.getTransactions().get(i)));
            }
        }
    }
}
