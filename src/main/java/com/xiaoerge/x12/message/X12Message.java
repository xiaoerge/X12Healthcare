package com.xiaoerge.x12.message;

import com.xiaoerge.x12.control.InterchangeEnvelope;

/**
 * Created by xiaoerge on 5/23/16.
 */
public class X12Message implements IMessage {

    private InterchangeEnvelope interchangeEnvelope;

    public X12Message() { interchangeEnvelope = new InterchangeEnvelope(); }
    public X12Message(String s) {
        interchangeEnvelope = new InterchangeEnvelope(s);
    }

    public InterchangeEnvelope getInterchangeEnvelope() {
        return interchangeEnvelope;
    }

    public boolean validate() {
        return interchangeEnvelope.validate();
    }
    public int size() {
        return interchangeEnvelope.size();
    }
    public String toX12String() {
        return interchangeEnvelope.toX12String();
    }
    public String toString() { return toX12String(); }
}
