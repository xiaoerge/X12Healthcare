package com.xiaoerge.healthcare.x12.segment;

import com.xiaoerge.healthcare.x12.annotation.Declaration;
import com.xiaoerge.healthcare.x12.annotation.Definition;
import com.xiaoerge.healthcare.x12.enumeration.Required;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(requiredSize = 3, fieldSize = 4, name = "HL")
public class HL extends Segment {
    public HL() {
        super();
    }
    public HL(String content) {
        super(content);
    }

    @Definition(required = Required.REQUIRED, position = 1, minLength = 1, maxLength = 12)
    public String getHierarchicalIDNumber() {return collection[1];}

    @Definition(required = Required.NOTUSED, position = 2, minLength = 1, maxLength = 12)
    public String getHierarchicalParentIDNumber() {return collection[2];}

    @Definition(required = Required.REQUIRED, position = 3, minLength = 1, maxLength = 2)
    public String getHierarchicalLevelCode() {return collection[3];}

    @Definition(required = Required.REQUIRED, position = 4, minLength = 1, maxLength = 1)
    public String getHierarchicalChildCode() {return collection[4];}

    public void setHierarchicalIDNumber(String s) { collection[1] = s;}
    public void setHierarchicalParentIDNumber(String s) { collection[2] = s;}
    public void setHierarchicalLevelCode(String s) { collection[3] = s;}
    public void setHierarchicalChildCode(String s) { collection[4] = s;}
}
