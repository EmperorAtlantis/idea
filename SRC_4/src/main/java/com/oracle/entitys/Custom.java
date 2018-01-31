package com.oracle.entitys;

import java.io.Serializable;
import java.sql.Date;


public class Custom implements Serializable{
    private Integer id;

    private String name;

    private String education;

    private String phoneNo;

    private String qq;

    private String email;

    private String customStatu;

    private Date createDate;

    private String inviteName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo == null ? null : phoneNo.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getCustomStatu() {
        return customStatu;
    }

    public void setCustomStatu(String customStatu) {
        this.customStatu = customStatu == null ? null : customStatu.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getInviteName() {
        return inviteName;
    }

    public void setInviteName(String inviteName) {
        this.inviteName = inviteName == null ? null : inviteName.trim();
    }

	@Override
	public String toString() {
		return "Custom [id=" + id + ", name=" + name + ", education="
				+ education + ", phoneNo=" + phoneNo + ", qq=" + qq
				+ ", email=" + email + ", customStatu=" + customStatu
				+ ", createDate=" + createDate + ", inviteName=" + inviteName
				+ "]";
	}
    
    
    
    
    
    
}