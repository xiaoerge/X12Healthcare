package com.xiaoerge.healthcare.x12;

/**
 * Created by xiaoerge on 5/30/16.
 */
public class StringQueue {

    private int pointer;
    private String[] message;
    public StringQueue(String s) {
        message = s.split("~");
        pointer = 0;
    }
    public int size() {
        return message.length;
    }

    public String getNext() {
        return message[pointer++]+"~";
    }

    public void reset() {
        pointer = 0;
    }

    public boolean hasNext() {
        return pointer >= 0 && pointer < message.length;
    }
}
