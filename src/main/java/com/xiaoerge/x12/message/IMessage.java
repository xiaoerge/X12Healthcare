package com.xiaoerge.x12.message;

import com.xiaoerge.x12.control.FunctionalGroup;
import com.xiaoerge.x12.control.InterchangeEnvelope;
import com.xiaoerge.x12.control.Transaction;

/**
 * Created by xiaoerge on 5/28/16.
 */
public interface IMessage {

    public abstract boolean validate();
    public abstract int size();
    public abstract String toX12String();
}
