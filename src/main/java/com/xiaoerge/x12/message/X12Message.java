package com.xiaoerge.x12.message;

import com.xiaoerge.x12.loop.HierarchicalTransaction;
import com.xiaoerge.x12.loop.InterchangeEnvelope;

/**
 * Created by xiaoerge on 5/23/16.
 */
public class X12Message
{
    protected InterchangeEnvelope envelope;
    protected HierarchicalTransaction transaction;

    public String ToX12String()
    {
        StringBuilder builder = new StringBuilder();

        builder.append(envelope.toString());
        builder.append(transaction.toString());

        return builder.toString();
    }
}
