package com.xiaoerge.x12.message;

/**
 * Created by xiaoerge on 5/23/16.
 */
public class BenefitInquiry implements IMessage {
    public boolean validate() {
        return false;
    }

    public String toX12String() {
        return "";
    }

    public int size() {
        return 0;
    }
}
