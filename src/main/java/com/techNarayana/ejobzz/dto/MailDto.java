package com.techNarayana.ejobzz.dto;

import java.util.Date;

public class MailDto {
	public Integer mid;
	public String emailId;
	public String subject;
	public String recruiterEmailId;
	public Double jobExpFrom;
	public Double jobExpTo;
	public Integer ctcFromLac;
	public Integer ctcToLac;
	public String otherSalaryDetails;
	public String jobLoc;
	public String message;
	public String signature;
	public Integer cid;
	private Date createtsDate;
	private Date modifytsDate;
	
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getRecruiterEmailId() {
		return recruiterEmailId;
	}
	public void setRecruiterEmailId(String recruiterEmailId) {
		this.recruiterEmailId = recruiterEmailId;
	}
	public Double getJobExpFrom() {
		return jobExpFrom;
	}
	public void setJobExpFrom(Double jobExpFrom) {
		this.jobExpFrom = jobExpFrom;
	}
	public Double getJobExpTo() {
		return jobExpTo;
	}
	public void setJobExpTo(Double jobExpTo) {
		this.jobExpTo = jobExpTo;
	}
	public Integer getCtcFromLac() {
		return ctcFromLac;
	}
	public void setCtcFromLac(Integer ctcFromLac) {
		this.ctcFromLac = ctcFromLac;
	}
	public Integer getCtcToLac() {
		return ctcToLac;
	}
	public void setCtcToLac(Integer ctcToLac) {
		this.ctcToLac = ctcToLac;
	}
	public String getOtherSalaryDetails() {
		return otherSalaryDetails;
	}
	public void setOtherSalaryDetails(String otherSalaryDetails) {
		this.otherSalaryDetails = otherSalaryDetails;
	}
	public String getJobLoc() {
		return jobLoc;
	}
	public void setJobLoc(String jobLoc) {
		this.jobLoc = jobLoc;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Date getCreatetsDate() {
		return createtsDate;
	}
	public void setCreatetsDate(Date createtsDate) {
		this.createtsDate = createtsDate;
	}
	public Date getModifytsDate() {
		return modifytsDate;
	}
	public void setModifytsDate(Date modifytsDate) {
		this.modifytsDate = modifytsDate;
	}
	@Override
	public String toString() {
		return "MailDto [mid=" + mid + ", emailId=" + emailId + ", subject="
				+ subject + ", recruiterEmailId=" + recruiterEmailId
				+ ", jobExpFrom=" + jobExpFrom + ", jobExpTo=" + jobExpTo
				+ ", ctcFromLac=" + ctcFromLac + ", ctcToLac=" + ctcToLac
				+ ", otherSalaryDetails=" + otherSalaryDetails + ", jobLoc="
				+ jobLoc + ", message=" + message + ", signature=" + signature
				+ ", cid=" + cid + ", createtsDate=" + createtsDate
				+ ", modifytsDate=" + modifytsDate + "]";
	}
}
