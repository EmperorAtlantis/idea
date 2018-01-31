package com.oracle.entitys;

import java.io.Serializable;
import java.sql.Date;

public class CustomInfo implements Serializable{
	private Integer id;

	private String customName;

	private String customPhoneNo;
	
	private Integer customId;

	private Integer followManId;

	private String statu;

	private Date startDate;

	private Date planDate;

	private Date lastFollowDate;

	private String mark;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCustomId() {
		return customId;
	}

	public void setCustomId(Integer customId) {
		this.customId = customId;
	}

	public Integer getFollowManId() {
		return followManId;
	}

	public void setFollowManId(Integer followManId) {
		this.followManId = followManId;
	}

	public String getStatu() {
		return statu;
	}

	public void setStatu(String statu) {
		this.statu = statu == null ? null : statu.trim();
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getPlanDate() {
		return planDate;
	}

	public void setPlanDate(Date planDate) {
		this.planDate = planDate;
	}

	public Date getLastFollowDate() {
		return lastFollowDate;
	}

	public void setLastFollowDate(Date lastFollowDate) {
		this.lastFollowDate = lastFollowDate;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark == null ? null : mark.trim();
	}

	public String getCustomName() {
		return customName;
	}

	public void setCustomName(String customName) {
		this.customName = customName;
	}

	public String getCustomPhoneNo() {
		return customPhoneNo;
	}

	public void setCustomPhoneNo(String customPhoneNo) {
		this.customPhoneNo = customPhoneNo;
	}

	@Override
	public String toString() {
		return "CustomInfo [id=" + id + ", customId=" + customId + ", followManId=" + followManId + ", statu=" + statu + ", startDate=" + startDate
				+ ", planDate=" + planDate + ", lastFollowDate=" + lastFollowDate + ", mark=" + mark + ", customName=" + customName
				+ ", customPhoneNo=" + customPhoneNo + "]";
	}

}