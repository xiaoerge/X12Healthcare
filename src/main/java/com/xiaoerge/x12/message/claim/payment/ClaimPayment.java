package com.xiaoerge.x12.message.claim.payment;

import com.xiaoerge.x12.message.MessageFormat;
import com.xiaoerge.x12.message.MessageFormatException;
import com.xiaoerge.x12.message.X12Message;
import com.xiaoerge.x12.message.control.FunctionalGroup;
import com.xiaoerge.x12.message.control.InterchangeEnvelope;

/**
 * Created by xiaoerge on 9/3/16.
 */
public class ClaimPayment extends X12Message {

    public ClaimPayment() {
        super();
    }
    public ClaimPayment(String s, MessageFormat mf) {
        super(s, mf);
        parse();
    }
    public ClaimPayment(X12Message message) {
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

    //todo load definition
}
