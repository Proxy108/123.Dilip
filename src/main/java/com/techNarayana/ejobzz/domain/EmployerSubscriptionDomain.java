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
@Table(name="employer_subscription")
public class EmployerSubscriptionDomain implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Column(name="sid")
	private Integer sid;
	
	@Column(name="quantity")
	private Integer quantity;
	
	@Column(name="status")
	private char status;
	
	@Column(name="subscription_type")
	private String subscriptionType;
	
	@Column(name="creates")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createtsDate;
	
	@Column(name="modifyts")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifytsDate;
	
	//one to many relations
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cid", nullable = false)
	private EmployerDomain employerDomain;
	
	
	@Column(name="expiry")
	private String expiry;

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public String getSubscriptionType() {
		return subscriptionType;
	}

	public void setSubscriptionType(String subscriptionType) {
		this.subscriptionType = subscriptionType;
	}

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
