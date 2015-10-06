package com.techNarayana.ejobzz.dto;

import java.util.Date;

import com.techNarayana.ejobzz.domain.EmployerDomain;

public class EmployerSubscriptionDto {
	
	private Integer id;
	
	private Integer sid;
	
	private Integer cid;
	
	private Integer quantity;
	
	private Date createtsDate;
	
	private Date modifytsDate;
	
	//one to many relations
	
	private EmployerDomain employerDomain;
	
	
	private String expiry;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
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

	public String getExpiry() {
		return expiry;
	}

	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}

	public EmployerDomain getEmployerDomain() {
		return employerDomain;
	}

	public void setEmployerDomain(EmployerDomain employerDomain) {
		this.employerDomain = employerDomain;
	}
	
}
