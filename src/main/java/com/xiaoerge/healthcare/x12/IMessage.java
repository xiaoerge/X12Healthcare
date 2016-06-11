package com.xiaoerge.healthcare.x12;

/**
 * Created by xiaoerge on 5/28/16.
 */
public interface IMessage {

    public abstract boolean validate();
    public abstract String toX12String();
    public abstract boolean isEmpty();
}
