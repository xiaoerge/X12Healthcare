package com.xiaoerge.x12.message;

import com.xiaoerge.x12.loop.HierarchicalTransaction;

/**
 * Created by xiaoerge on 5/23/16.
 */
public class X12Message
{
    protected HierarchicalTransaction transaction;

    public String ToX12String()
    {
        StringBuilder builder = new StringBuilder();

        builder.append(transaction.toString());

        return builder.toString();
    }
}
