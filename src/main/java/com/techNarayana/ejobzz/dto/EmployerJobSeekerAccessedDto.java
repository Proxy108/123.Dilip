package com.techNarayana.ejobzz.dto;

import java.util.Date;

import com.techNarayana.ejobzz.domain.EmployerDomain;

public class EmployerJobSeekerAccessedDto {

	private Integer id;
	
	private Integer jsid;
	
	private Integer cid;
	
	private boolean email;
	
	private boolean sms;
	
	private boolean call;
	
	private boolean downloaded;
	
	private Integer quantity;
	
	private Date createtsDate;
	
	private Date modifytsDate;
	
	// one to many relations
	
	private EmployerDomain employerDomain;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getJsid() {
		return jsid;
	}

	public void setJsid(Integer jsid) {
		this.jsid = jsid;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public boolean isEmail() {
		return email;
	}

	public void setEmail(boolean email) {
		this.email = email;
	}

	public boolean isSms() {
		return sms;
	}

	public void setSms(boolean sms) {
		this.sms = sms;
	}

	public boolean isCall() {
		return call;
	}

	public void setCall(boolean call) {
		this.call = call;
	}

	public boolean isDownloaded() {
		return downloaded;
	}

	public void setDownloaded(boolean downloaded) {
		this.downloaded = downloaded;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
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

	public EmployerDomain getEmployerDomain() {
		return employerDomain;
	}

	public void setEmployerDomain(EmployerDomain employerDomain) {
		this.employerDomain = employerDomain;
	}
	
}
