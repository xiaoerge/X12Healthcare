package com.xiaoerge.x12.control;

import com.xiaoerge.x12.message.IMessage;
import com.xiaoerge.x12.segment.BHT;
import com.xiaoerge.x12.segment.SE;
import com.xiaoerge.x12.segment.ST;
import com.xiaoerge.x12.segment.Segment;

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

    public String toString() {
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
