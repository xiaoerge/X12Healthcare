package com.xiaoerge.healthcare.x12.control;

import com.xiaoerge.healthcare.x12.StringQueue;
import com.xiaoerge.healthcare.x12.message.IMessage;
import com.xiaoerge.healthcare.x12.segment.GE;
import com.xiaoerge.healthcare.x12.segment.GS;

/**
 * Created by xiaoerge on 5/23/16.
 */
public class FunctionalGroup implements IMessage
{
    private GS gs;
    private Transaction transaction;
    private GE ge;

    public FunctionalGroup() {
        super();
        gs = new GS();
        transaction = new Transaction();
        ge = new GE();
    }
    public FunctionalGroup(String s) {

        StringQueue stringQueue = new StringQueue(s);
        String header = stringQueue.getHeader(), content = stringQueue.getContent(), trailer = stringQueue.getTrailer();

        gs = new GS(header);
        transaction = new Transaction(content);
        ge = new GE(trailer);
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public boolean validate() {
        return gs.validate() && transaction.validate() && ge.validate();
    }

    public int size() {
        return 2 + transaction.size();
    }

    public String toX12String() {
        return gs.toX12String() + transaction.toX12String() + ge.toX12String();
    }
}
