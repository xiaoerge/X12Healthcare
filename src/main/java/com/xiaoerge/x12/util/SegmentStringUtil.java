package com.xiaoerge.x12.util;

import com.xiaoerge.x12.message.MessageFormat;
import com.xiaoerge.x12.message.segment.HL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xiaoerge on 8/13/16.
 */
public class SegmentStringUtil {

    private static final Logger logger = LoggerFactory.getLogger(SegmentStringUtil.class);
    /**
     * split a string "EQ***~EQ***~EQ***~III***~EQ***~REF***~DTP***~"
     * into array of ["EQ***~", "EQ***~", "EQ***~III***~", "EQ***~REF***~DTP***~"]
     * by calling split(string2Split);
     *
     * precondition, string2split must start with segment
     * */
    public static String[] split(String string2Split, String segment, MessageFormat mf) {
        if (string2Split.length() == 0 || !string2Split.startsWith(segment)) {
            logger.warn("String2Split is empty or not starting with "+segment);
            return new String[0];
        }

        StringQueue stringQueue = new StringQueue(string2Split, mf);
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

    /**
     * HL*1**20*1~NM1*PR*2*ABC COMPANY*****PI*842610001~
     HL*2*1*21*1~NM1*1P*2*BONE AND JOINT CLINIC*****SV*2000035~
     HL*3*2*22*0~TRN*1*93175-012547*9877281234~NM1*IL*1*SMITH*ROBERT****MI*11122333301~DMG*D8*19430519~DTP*291*D8*20060501~EQ*30~
     HL*4**20*1~NM1*PR*2*ABC COMPANY*****PI*842610001~
     HL*5*4*21*1~NM1*1P*2*BONE AND JOINT CLINIC*****SV*2000035~
     HL*6*5*22*0~TRN*1*93175-012547*9877281234~NM1*IL*1*SMITH*ROBERT****MI*11122333301~DMG*D8*19430519~DTP*291*D8*20060501~EQ*30~

     join the list above to
     HL*1**20*1~NM1*PR*2*ABC COMPANY*****PI*842610001~
        HL*2*1*21*1~NM1*1P*2*BONE AND JOINT CLINIC*****SV*2000035~
        HL*3*2*22*0~TRN*1*93175-012547*9877281234~NM1*IL*1*SMITH*ROBERT****MI*11122333301~DMG*D8*19430519~DTP*291*D8*20060501~EQ*30~

     HL*4**20*1~NM1*PR*2*ABC COMPANY*****PI*842610001~
        HL*5*4*21*1~NM1*1P*2*BONE AND JOINT CLINIC*****SV*2000035~
        HL*6*5*22*0~TRN*1*93175-012547*9877281234~NM1*IL*1*SMITH*ROBERT****MI*11122333301~DMG*D8*19430519~DTP*291*D8*20060501~EQ*30~
     * */
    public static String[] joinLevel(String[] array, MessageFormat mf) {
        Stack<String> stack = new Stack<String>();
        for (String s : array) {
            StringQueue stringQueue = new StringQueue(s, mf);
            if (new HL(stringQueue.getNext(), mf).getHierarchicalParentIDNumber().equals("")) {
                stack.push(s);
            }
            else {
                stack.push(stack.pop().concat(s));
            }
        }
        return stack.toArray(new String[stack.size()]);
    }
}
