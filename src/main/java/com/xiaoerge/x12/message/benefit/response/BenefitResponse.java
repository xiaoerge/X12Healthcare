package com.xiaoerge.x12.message.benefit.response;

import com.xiaoerge.x12.message.X12MessageLoopBase;
import com.xiaoerge.x12.message.control.FunctionalGroup;
import com.xiaoerge.x12.message.control.InterchangeEnvelope;

/**
 * Created by xiaoerge on 5/23/16.
 */
public class BenefitResponse extends X12MessageLoopBase {
    public BenefitResponse(String s) {
        super(s);
        parse();
    }
    public BenefitResponse(X12MessageLoopBase message) {
        super(message);
        parse();
    }

    private void parse() {
        InterchangeEnvelope envelope = getInterchangeEnvelope();
        for (FunctionalGroup group : envelope.getFunctionalGroups()) {
            for(int i = 0; i < group.getTransactions().size(); i++) {
                group.getTransactions().set(i, new BenefitResponseTransaction(group.getTransactions().get(i)));
            }
        }
    }
}
