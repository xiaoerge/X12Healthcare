package com.xiaoerge.x12.message;

import com.xiaoerge.x12.loop.HierarchicalTransaction;

/**
 * Created by xiaoerge on 5/23/16.
 */
public interface IMessage
{
    public abstract boolean validate();
    public abstract int size();
}
