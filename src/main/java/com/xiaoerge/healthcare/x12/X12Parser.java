package com.xiaoerge.healthcare.x12;

import com.xiaoerge.healthcare.x12.message.BenefitInquiry;
import com.xiaoerge.healthcare.x12.message.X12Message;

/**
 * Created by xiaoerge on 5/28/16.
 */
public class X12Parser {

    public static X12Message fromX12Message(String s) {

        X12Message message = new X12Message(s);

        String id = message.getInterchangeEnvelope().getFunctionalGroup().getTransaction().getTransactionSetIDCode();
        if (id.equals("270")) {
            return new BenefitInquiry(message);
        }

        return message;
    }
}
