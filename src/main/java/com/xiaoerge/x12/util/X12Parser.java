package com.xiaoerge.x12.util;

import com.xiaoerge.x12.message.X12MessageLoopBase;
import com.xiaoerge.x12.message.benefit.inquiry.BenefitInquiry;
import com.xiaoerge.x12.message.benefit.response.BenefitResponse;
import com.xiaoerge.x12.message.claim.payment.ClaimPayment;
import com.xiaoerge.x12.message.control.FunctionalGroup;
import com.xiaoerge.x12.message.control.InterchangeEnvelope;
import com.xiaoerge.x12.message.control.Transaction;

import java.util.List;

/**
 * Created by xiaoerge on 5/28/16.
 */
public class X12Parser {

    public static X12MessageLoopBase fromX12Message(String s) {

        X12MessageLoopBase message = new X12MessageLoopBase(s);
        InterchangeEnvelope envelope = message.getInterchangeEnvelope();
        List<FunctionalGroup> groups = envelope.getFunctionalGroups();

        Transaction transaction = groups.get(0).getTransactions().get(0);

        if (transaction.getTransactionSetHeader().getTransactionSetIDCode().equals("270")) {
            return new BenefitInquiry(message);
        }
        else if (transaction.getTransactionSetHeader().getTransactionSetIDCode().equals("271")) {
            return new BenefitResponse(message);
        }
        else if (transaction.getTransactionSetHeader().getTransactionSetIDCode().equals("835")) {
            return new ClaimPayment(message);
        }

        return message;
    }
}
