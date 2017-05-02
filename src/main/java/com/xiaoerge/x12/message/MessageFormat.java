package com.xiaoerge.x12.message;

import java.util.regex.Pattern;

public class MessageFormat {
    private String dataElementSeparator = "*";
    private String componentElementSeparator = "\\";
    private String segmentTerminator = "~";
    private String repetitionSeparator = "^";
    private String suffix = null;
    
    public MessageFormat() {
	}
    public MessageFormat(String s) throws MessageFormatException {
    	if (s==null || s.length()<106) {
    		throw new MessageFormatException();
    	}
    	String s2 = s.substring(0, 108);
    	dataElementSeparator = s2.substring(3,4);
    	segmentTerminator = s2.substring(105,106);
    	String[] fields = s.split(Pattern.quote(dataElementSeparator.toString()));
    	repetitionSeparator = fields[11].substring(0,1);
    	componentElementSeparator = fields[16].substring(0,1);
    	String s3 = s2.substring(106,107);
    	if (s2.charAt(106) == '\r' && s2.charAt(107)=='\n') {
    		suffix = "\r\n";
    	} else if (s2.charAt(106) == '\r') {
    		suffix = "\r";
    	} else if (s2.charAt(106) == '\n') {
    		suffix = "\n";
    	}
    }
    
	public String getDataElementSeparator() {
    	return dataElementSeparator;
    }
    public String getComponentElementSeparator() {
    	return componentElementSeparator;
    }
    public String getSegmentTerminator() {
    	return segmentTerminator;
    }
    public String getRepetitionSeparator() {
    	return repetitionSeparator;
    }
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
}
