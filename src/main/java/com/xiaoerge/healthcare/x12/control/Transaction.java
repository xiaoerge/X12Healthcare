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
    private List<Segment> segmentList;

    public Transaction() {
        st = new ST();
        bht = new BHT();
        se = new SE();
        segmentList = new ArrayList<Segment>();
    }

    public Transaction(String s) {

        StringQueue stringQueue = new StringQueue(s);
        String header = stringQueue.getHeader(), content = stringQueue.getContent(), trailer = stringQueue.getTrailer();

        StringQueue contentQueue = new StringQueue(content);

        st = new ST(header);
        bht = new BHT(contentQueue.getHeader());
        se = new SE(trailer);
        segmentList = new ArrayList<Segment>();
    }

    public String getTransactionSetIDCode() {
        return st.getTransactionSetIDCode();
    }

    public boolean validate() {
        boolean v = true;
        for (Segment segment : segmentList) {
            if (!segment.validate()) {
                v = false;
                break;
            }
        }
        return st.validate() && bht.validate() && se.validate() && v;
    }

    public String toX12String() {
        StringBuilder builder = new StringBuilder();
        builder.append(st.toString());
        builder.append(bht.toString());
        for (Segment segment : segmentList) {
            builder.append(segment.toString());
        }
        builder.append(se.toString());
        return builder.toString();
    }

    public int size() {
        return 3 + segmentList.size();
    }
}
