package com.xiaoerge.x12.util;

import com.xiaoerge.x12.message.MessageFormat;

/**
 * Created by xiaoerge on 5/30/16.
 */
public class StringQueue {

    MessageFormat mf;
    private int pointer;
    private String[] message;
    
    public StringQueue(String s) {
    	mf = new MessageFormat();
        message = s.split(mf.getSegmentTerminator());
        pointer = 0;
    }
    public StringQueue(String s, MessageFormat mf) {
    	this.mf = mf;
        message = s.split(mf.getSegmentTerminator());
        pointer = 0;
    }
    public int size() {
        return message.length;
    }

    public String format(String s) {
    	if (mf.getSuffix()!=null) return s.trim() + mf.getSegmentTerminator()  + mf.getSuffix();
    	else return s.trim() + mf.getSegmentTerminator();
    }
    public String getNext() {
        return format(message[pointer++]);
    }
    public String peekNext() { return format(message[pointer]); }
    public void reset() {
        pointer = 0;
    }

    public boolean hasNext() {
        return pointer >= 0 && pointer < message.length;
    }
}
