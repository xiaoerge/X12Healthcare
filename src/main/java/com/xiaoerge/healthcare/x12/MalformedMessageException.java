package com.xiaoerge.healthcare.x12;

/**
 * Created by xiaoerge on 5/30/16.
 */
public class MalformedMessageException extends Exception {
    public MalformedMessageException() {
        super();
    }
    public MalformedMessageException(String message) {
        super(message);
    }
    public MalformedMessageException(String message, Throwable throwable) {
        super(message, throwable);
    }
    public MalformedMessageException(Throwable throwable) {
        super(throwable);
    }
}
