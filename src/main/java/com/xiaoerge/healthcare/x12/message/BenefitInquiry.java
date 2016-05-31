package com.xiaoerge.healthcare.x12.message;

/**
 * Created by xiaoerge on 5/23/16.
 */
public class BenefitInquiry extends X12Message {
    public BenefitInquiry(String s) {
        super(s);
    }
    public BenefitInquiry(X12Message message) {
        super(message);
    }
}
