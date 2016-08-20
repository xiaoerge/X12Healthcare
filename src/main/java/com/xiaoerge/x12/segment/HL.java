package com.xiaoerge.x12.segment;

import com.xiaoerge.x12.annotation.Declaration;
import com.xiaoerge.x12.annotation.Definition;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 4, name = "HL")
public class HL extends Segment {
    public HL() {
        super();
    }
    public HL(String content) {
        super(content);
    }

    @Definition(position = 1, minLength = 1, maxLength = 12)
    public String getHierarchicalIDNumber() {return getByPosition(); }

    @Definition(position = 2, minLength = 1, maxLength = 12)
    public String getHierarchicalParentIDNumber() {return getByPosition(); }

    @Definition(position = 3, minLength = 1, maxLength = 2)
    public String getHierarchicalLevelCode() {return getByPosition(); }

    @Definition(position = 4, minLength = 1, maxLength = 1)
    public String getHierarchicalChildCode() {return getByPosition(); }

    public void setHierarchicalIDNumber(String s) { collection[1] = s;}
    public void setHierarchicalParentIDNumber(String s) { collection[2] = s;}
    public void setHierarchicalLevelCode(String s) { collection[3] = s;}
    public void setHierarchicalChildCode(String s) { collection[4] = s;}
}
