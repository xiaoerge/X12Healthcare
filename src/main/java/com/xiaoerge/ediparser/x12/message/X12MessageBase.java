package com.xiaoerge.ediparser.x12.message;

import com.xiaoerge.ediparser.x12.control.InterchangeEnvelope;

/**
 * Created by xiaoerge on 5/23/16.
 */
public class X12MessageBase extends MessageBase {

    private InterchangeEnvelope interchangeEnvelope;

    public X12MessageBase() { interchangeEnvelope = new InterchangeEnvelope(); }
    public X12MessageBase(String s) {
        interchangeEnvelope = new InterchangeEnvelope(s);
    }
    public X12MessageBase(X12MessageBase message) {
        this.interchangeEnvelope = message.getInterchangeEnvelope();
    }

    public InterchangeEnvelope getInterchangeEnvelope() {
        return interchangeEnvelope;
    }

    public void loadDefinition() {

    }

    public boolean validate() {
        return interchangeEnvelope.validate();
    }
    public String toX12String() {
        return interchangeEnvelope.toX12String();
    }

    public boolean isEmpty() {
        return interchangeEnvelope.isEmpty();
    }

    public String toString() { return toX12String(); }
}
