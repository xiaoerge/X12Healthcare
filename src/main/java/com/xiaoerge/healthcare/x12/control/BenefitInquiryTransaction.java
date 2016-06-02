package com.xiaoerge.healthcare.x12.control;

import com.xiaoerge.healthcare.x12.StringQueue;
import com.xiaoerge.healthcare.x12.message.IMessage;
import com.xiaoerge.healthcare.x12.segment.BHT;
import com.xiaoerge.healthcare.x12.segment.SE;
import com.xiaoerge.healthcare.x12.segment.ST;

/**
 * Created by xiaoerge on 5/27/16.
 */
public class BenefitInquiryTransaction extends Transaction
{
    public BenefitInquiryTransaction() {
        super();
    }

    public BenefitInquiryTransaction(String s) {
        super(s);
    }

    public String getTransactionSetIDCode() {
        return super.getTransactionSetIDCode();
    }

    public boolean validate() {
        return super.validate();
    }

    public String toX12String() {
        return super.toX12String();
    }
}
