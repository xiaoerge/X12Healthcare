package com.xiaoerge.x12;

import com.xiaoerge.x12.control.InterchangeEnvelope;
import com.xiaoerge.x12.message.BenefitInquiry;
import com.xiaoerge.x12.message.X12Message;

/**
 * Created by xiaoerge on 5/28/16.
 */
public class X12Parser {

    public static X12Message fromX12Message(String s) {

        X12Message message = new X12Message(s);
        return message;
    }
}
