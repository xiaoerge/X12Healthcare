package com.xiaoerge.healthcare.x12;

import com.xiaoerge.healthcare.x12.control.FunctionalGroup;
import com.xiaoerge.healthcare.x12.control.InterchangeEnvelope;
import com.xiaoerge.healthcare.x12.control.Transaction;
import com.xiaoerge.healthcare.x12.message.BenefitInquiry;
import com.xiaoerge.healthcare.x12.message.X12Message;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Created by xiaoerge on 5/28/16.
 */
public class X12Parser {

    public static X12Message fromX12Message(String s) {

        X12Message message = new X12Message(s);
        InterchangeEnvelope envelope = message.getInterchangeEnvelope();
        List<FunctionalGroup> groups = envelope.getFunctionalGroups();

        Transaction transaction = groups.get(0).getTransactions().get(0);

        if (transaction.getTransactionSetIDCode().equals("270")) {
            return new BenefitInquiry(message);
        }

        return message;
    }
}
