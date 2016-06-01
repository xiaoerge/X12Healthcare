package com.xiaoerge.healthcare.x12;

/**
 * Created by xiaoerge on 5/30/16.
 */
public class StringQueue {

    private int pointer;
    private String[] message;
    public StringQueue(String s) {
        message = s.split("~");
        message = (message.length >= 3) ? message : new String[]{"", "", ""};
        pointer = 1;
    }
    public int size() {
        return message.length;
    }

    public String getHeader() {
        return message[0]+"~";
    }

    public String getTrailer() {
        return message[message.length-1]+"~";
    }

    public String getContent() {
        StringBuilder builder = new StringBuilder();

        for (int i = 1; i < message.length - 1; i++) {
            builder.append(message[i]+"~");
        }
        return builder.toString();
    }

    public String getNext() {
        return message[pointer++];
    }

    public void reset() {
        pointer = 1;
    }

    //ignores header and trailer because we have methods for them
    public boolean hasNext() {
        return pointer > 0 && pointer < message.length-1;
    }
}
