package com.xiaoerge.x12.message;

import com.xiaoerge.x12.message.control.InterchangeEnvelope;

/**
 * Created by xiaoerge on 5/23/16.
 */
public class X12MessageLoopBase extends MessageLoopBase {

    private InterchangeEnvelope interchangeEnvelope;

    public X12MessageLoopBase() { interchangeEnvelope = new InterchangeEnvelope(); }
    public X12MessageLoopBase(String s) {
        interchangeEnvelope = new InterchangeEnvelope(s);
    }
    public X12MessageLoopBase(X12MessageLoopBase message) {
        this.interchangeEnvelope = message.getInterchangeEnvelope();
    }

    public InterchangeEnvelope getInterchangeEnvelope() {
        return interchangeEnvelope;
    }

    public void loadDefinition() {
        messagesDefinition.clear();

        messagesDefinition.add(interchangeEnvelope);
    }
}
