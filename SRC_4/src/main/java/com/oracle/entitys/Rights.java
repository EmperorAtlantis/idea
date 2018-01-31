package com.oracle.entitys;

import java.io.Serializable;

public class Rights implements Serializable{
    private Integer rid;

    private String rightName;

    private String rightType;

    private String url;

    private Integer pid;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRightName() {
        return rightName;
    }

    public void setRightName(String rightName) {
        this.rightName = rightName == null ? null : rightName.trim();
    }

    public String getRightType() {
        return rightType;
    }

    public void setRightType(String rightType) {
        this.rightType = rightType == null ? null : rightType.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

	@Override
	public String toString() {
		return "Rights [rid=" + rid + ", rightName=" + rightName
				+ ", rightType=" + rightType + ", url=" + url + ", pid=" + pid
				+ "]";
	}

	
    
    
    
    
    
}