package com.oracle.entitys;

import java.io.Serializable;

public class Employee implements Serializable{
    private Integer id;

    private String username;

    private String pass;

    private String nickname;

    private String realname;

    private Integer jobInfoId;

    private Integer departmentId;

    private String phoneNo;

    private String officeTel;

    private String workStatu;

    private String dname;
    
    private String job;
    
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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
    	
        this.pass = pass == null ? null : pass.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public Integer getJobInfoId() {
        return jobInfoId;
    }

    public void setJobInfoId(Integer jobInfoId) {
        this.jobInfoId = jobInfoId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo == null ? null : phoneNo.trim();
    }

    public String getOfficeTel() {
        return officeTel;
    }

    public void setOfficeTel(String officeTel) {
        this.officeTel = officeTel == null ? null : officeTel.trim();
    }

    public String getWorkStatu() {
        return workStatu;
    }

    public void setWorkStatu(String workStatu) {
        this.workStatu = workStatu == null ? null : workStatu.trim();
    }

    
	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", username=" + username + ", pass="
				+ pass + ", nickname=" + nickname + ", realname=" + realname
				+ ", jobInfoId=" + jobInfoId + ", departmentId=" + departmentId
				+ ", phoneNo=" + phoneNo + ", officeTel=" + officeTel
				+ ", workStatu=" + workStatu + "]";
	}
    
    
   
    
    
}