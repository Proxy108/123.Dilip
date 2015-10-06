package com.techNarayana.ejobzz.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="recruitersentmail")
public class MailDomain implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="mid")
	public Integer mid;
	
	@Column(name="emailId")
	public String emailId;
	
	@Column(name="subject")
	public String subject;
	
	@Column(name="recruiterEmailId")
	public String recruiterEmailId;
	
	@Column(name="jobExpFrom")
	public Double jobExpFrom;
	
	@Column(name="jobExpTo")
	public Double jobExpTo;
	
	@Column(name="ctcFromLac")
	public Integer ctcFromLac;
	
	@Column(name="ctcToLac")
	public Integer ctcToLac;
	
	@Column(name="otherSalaryDetails")
	public String otherSalaryDetails;
	
	@Column(name="jobLoc")
	public String jobLoc;
	
	@Column(name="message")
	public String message;
	
	@Column(name="signature")
	public String signature;
	
	@Column(name="cid")
	public Integer cid;
	
	@Column(name="createtsDate")
	private Date createtsDate;
	
	@Column(name="modifytsDate")
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
