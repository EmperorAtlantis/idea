package com.oracle.entitys;

import java.io.Serializable;

public class ResetPass implements Serializable{
    private Integer id;

    private String username;

	private String phoneNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo == null ? null : phoneNo.trim();
    }

	@Override
	public String toString() {
		return "ResetPass [id=" + id + ", username=" + username + ", phoneNo="
				+ phoneNo + "]";
	}
    
    
    
    
}