package com.xiaoerge.x12.util;

import com.xiaoerge.x12.control.FunctionalGroup;
import com.xiaoerge.x12.control.InterchangeEnvelope;
import com.xiaoerge.x12.control.Transaction;
import com.xiaoerge.x12.message.BenefitInquiry;
import com.xiaoerge.x12.message.BenefitResponse;
import com.xiaoerge.x12.message.X12MessageBase;

import java.util.List;
import java.util.Map;

/**
 * Created by xiaoerge on 5/28/16.
 */
public class X12Parser {

    public static X12MessageBase fromX12Message(String s) {

        X12MessageBase message = new X12MessageBase(s);
        InterchangeEnvelope envelope = message.getInterchangeEnvelope();
        List<FunctionalGroup> groups = envelope.getFunctionalGroups();

        Transaction transaction = groups.get(0).getTransactions().get(0);

        if (transaction.getTransactionSetHeader().getTransactionSetIDCode().equals("270")) {
            return new BenefitInquiry(message);
        }
        else if (transaction.getTransactionSetHeader().getTransactionSetIDCode().equals("271")) {
            return new BenefitResponse(message);
        }

        return message;
    }
}
