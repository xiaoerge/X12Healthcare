package com.xiaoerge.x12.message;

import com.xiaoerge.x12.message.control.InterchangeEnvelope;

/**
 * Created by xiaoerge on 5/23/16.
 */
public class X12Message extends MessageLoop {

    private InterchangeEnvelope interchangeEnvelope;

    public X12Message() { interchangeEnvelope = new InterchangeEnvelope(); }
    public X12Message(String s) {
        interchangeEnvelope = new InterchangeEnvelope(s);
    }
    public X12Message(X12Message message) {
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
