package com.techNarayana.ejobzz.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="employer_jobseeker_accessed")
public class EmployerJobSeekerAccessedDomain implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Column(name="jsid")
	private Integer jsid;
	
	@Column(name="email")
	private boolean email;
	
	@Column(name="sms")
	private boolean sms;
	
	@Column(name="call")
	private boolean call;
	
	@Column(name="downloaded")
	private boolean downloaded;
	
	@Column(name="quantity")
	private Integer quantity;
	
	@Column(name="creates")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createtsDate;
	
	@Column(name="modifyts")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifytsDate;
	
	// one to many relations
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cid", nullable = false)
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
