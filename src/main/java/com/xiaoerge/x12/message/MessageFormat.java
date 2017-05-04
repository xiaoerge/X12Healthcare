package com.xiaoerge.x12.message;

import java.util.regex.Pattern;

public class MessageFormat {
    private String dataElementSeparator = "*";
    private String componentElementSeparator = "\\";
    private String segmentTerminator = "~";
    private String repetitionSeparator = "^";
    private String suffix = "";
    
    public MessageFormat() {
	}
    
	public String getDataElementSeparator() {
    	return dataElementSeparator;
    }
	public void setDataElementSeparator(String dataElementSeparator) {
		this.dataElementSeparator = dataElementSeparator;
	}
    public String getComponentElementSeparator() {
    	return componentElementSeparator;
    }
	public void setComponentElementSeparator(String componentElementSeparator) {
		this.componentElementSeparator = componentElementSeparator;
	}
    public String getSegmentTerminator() {
    	return segmentTerminator;
    }
	public void setSegmentTerminator(String segmentTerminator) {
		this.segmentTerminator = segmentTerminator;
	}
    public String getRepetitionSeparator() {
    	return repetitionSeparator;
    }
	public void setRepetitionSeparator(String repetitionSeparator) {
		this.repetitionSeparator = repetitionSeparator;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
}
