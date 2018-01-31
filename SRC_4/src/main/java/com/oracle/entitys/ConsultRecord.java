package com.oracle.entitys;

import java.io.Serializable;
import java.sql.Date;

public class ConsultRecord implements Serializable{
	private Integer id;

	private String customName;
	
	private String customPhoneNo;
	
	private Integer customId;

	private String consultStatu;

	private Integer consultManId;

	private Date consultDate;

	private String result;


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

	public String getConsultStatu() {
		return consultStatu;
	}

	public void setConsultStatu(String consultStatu) {
		this.consultStatu = consultStatu == null ? null : consultStatu.trim();
	}

	public Integer getConsultManId() {
		return consultManId;
	}

	public void setConsultManId(Integer consultManId) {
		this.consultManId = consultManId;
	}

	public Date getConsultDate() {
		return consultDate;
	}

	public void setConsultDate(Date consultDate) {
		this.consultDate = consultDate;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result == null ? null : result.trim();
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
		return "ConsultRecord [id=" + id + ", customId=" + customId
				+ ", consultStatu=" + consultStatu + ", consultManId="
				+ consultManId + ", consultDate=" + consultDate + ", result="
				+ result + ", customName=" + customName + ", customPhoneNo="
				+ customPhoneNo + "]";
	}
	
	
	
	
	
}