package com.xiaoerge.healthcare.x12;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xiaoerge on 8/13/16.
 */
public class SegmentSplitter {

    private static final Logger logger = LoggerFactory.getLogger(SegmentSplitter.class);
    /**
     * Split a string "EQ***~EQ***~EQ***~III***~EQ***~REF***~DTP***~"
     * into array of ["EQ***~", "EQ***~", "EQ***~III***~", "EQ***~REF***~DTP***~"]
     * by calling Split(string2Split);
     *
     * precondition, string2split must start with segment
     * */
    public static String[] Split(String string2Split, String segment) {
        if (string2Split.length() == 0 || !string2Split.startsWith(segment)) {
            logger.warn("String2Split is empty or not start with "+segment);
            return new String[0];
        }

        StringQueue stringQueue = new StringQueue(string2Split);
        List<String> splitList = new ArrayList<String>();
        StringBuilder stringBuilder = new StringBuilder();
        boolean isFirst = true;

        while (stringQueue.hasNext()) {
            String peek = stringQueue.peekNext();
            String next = stringQueue.getNext();
            if (peek.startsWith(segment)) {
                if (isFirst) {
                    isFirst = false;
                }
                else {
                    splitList.add(stringBuilder.toString());
                    stringBuilder = new StringBuilder();
                }
            }
            stringBuilder.append(next);
        }
        if (stringBuilder.length() > 0) splitList.add(stringBuilder.toString());

        return splitList.toArray(new String[splitList.size()]);
    }
}
