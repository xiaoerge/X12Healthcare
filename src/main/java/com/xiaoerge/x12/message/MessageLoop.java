package com.xiaoerge.x12.message;

import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoerge on 5/28/16.
 */
public abstract class MessageLoop {
    protected final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
    protected final List<MessageLoop> messagesDefinition = new ArrayList<MessageLoop>();
    protected MessageFormat messageFormat;

    public abstract void loadDefinition();

    public boolean validate() {
        if (messagesDefinition.size() == 0) loadDefinition();

        for (MessageLoop message : messagesDefinition) {
            if (!message.validate()) return false;
        }
        return true;
    }

    public String toX12String() {
        if (messagesDefinition.size() == 0) loadDefinition();

        StringBuilder stringBuilder = new StringBuilder();

        for (MessageLoop message : messagesDefinition) {
            stringBuilder.append(message.toX12String());
        }

        return stringBuilder.toString();
    }

    public boolean isEmpty() {
        if (messagesDefinition.size() == 0) loadDefinition();

        for (MessageLoop message : messagesDefinition) {
            if (!message.isEmpty()) return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return toX12String();
    }
    
    public MessageFormat getMessageFormat() {
    	return messageFormat;
    }
}
