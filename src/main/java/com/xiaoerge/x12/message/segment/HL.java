package com.xiaoerge.x12.message.segment;

import com.xiaoerge.x12.annotation.Declaration;
import com.xiaoerge.x12.annotation.Definition;
import com.xiaoerge.x12.message.MessageFormat;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 4, name = "HL")
public class HL extends Segment {
    public HL() {
        super();
    }
    public HL(String content, MessageFormat mf) {
        super(content, mf);
    }

    @Definition(position = 1, minLength = 1, maxLength = 12)
    public String getHierarchicalIDNumber() {return getField(1); }

    @Definition(position = 2, minLength = 1, maxLength = 12)
    public String getHierarchicalParentIDNumber() {return getField(2); }

    @Definition(position = 3, minLength = 1, maxLength = 2)
    public String getHierarchicalLevelCode() {return getField(3); }

    @Definition(position = 4, minLength = 1, maxLength = 1)
    public String getHierarchicalChildCode() {return getField(4); }

    public void setHierarchicalIDNumber(String s) { setField(1,s);}
    public void setHierarchicalParentIDNumber(String s) { setField(2,s);}
    public void setHierarchicalLevelCode(String s) { setField(3,s);}
    public void setHierarchicalChildCode(String s) { setField(4,s);}
}
