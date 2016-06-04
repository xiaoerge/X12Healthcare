package com.xiaoerge.healthcare.x12.control;

import com.xiaoerge.healthcare.x12.StringQueue;
import com.xiaoerge.healthcare.x12.message.IMessage;
import com.xiaoerge.healthcare.x12.segment.BHT;
import com.xiaoerge.healthcare.x12.segment.SE;
import com.xiaoerge.healthcare.x12.segment.ST;
import com.xiaoerge.healthcare.x12.segment.Segment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoerge on 5/27/16.
 */
public class Transaction implements IMessage
{
    private ST st;
    private BHT bht;
    private SE se;

    private String content;

    public Transaction() {
        st = new ST();
        bht = new BHT();
        se = new SE();

        content = "";
    }

    public Transaction(String s) {
        StringQueue stringQueue = new StringQueue(s);
        StringBuilder builder = new StringBuilder();

        while (stringQueue.hasNext()) {
            String next = stringQueue.getNext();
            if (next.startsWith("ST")) {
                st = new ST(next);
            }
            else if (next.startsWith("BHT")) {
                bht = new BHT(next);
            }
            else if (next.startsWith("SE")) {
                se = new SE(next);
            }
            else {
                builder.append(next).append("~");
            }
        }
        content = builder.toString();
    }
    public String getContent() {
        return content;
    }

    public String getTransactionSetIDCode() {
        return st.getTransactionSetIDCode();
    }

    public boolean validate() {
        boolean b1 = st.validate();
        boolean b2 = bht.validate();
        boolean b3 = se.validate();
        return b1 && b2 && b3;
    }

    public String toX12String() {
        return st.toString() +
                bht.toString() +
                se.toString();
    }
}
