package com.techNarayana.ejobzz.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="subscription")	
public class SubscriptionDomain implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="sid")
	public Integer sid;
	
	@Column(name="posting_type")
	public String postingType;
	
	@Column(name="validity_days")
	public Integer validityDays;
	
	@Column(name="amount")
	public Double amount;
	
	@Column(name="name")
	public String name;
	
	@Column(name="quantity")
	public Integer quantity;
	
	@Column(name="premium_quantity")
	public Integer premiumQuantity;
	
	public Integer getPremiumQuantity() {
		return premiumQuantity;
	}
	public void setPremiumQuantity(Integer premiumQuantity) {
		this.premiumQuantity = premiumQuantity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	
	
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getPostingType() {
		return postingType;
	}
	public void setPostingType(String postingType) {
		this.postingType = postingType;
	}
	public Integer getValidityDays() {
		return validityDays;
	}
	public void setValidityDays(Integer validityDays) {
		this.validityDays = validityDays;
	}
	@Override
	public String toString() {
		return "SubscriptionDomain [sid=" + sid + ", postingType="
				+ postingType + ", validityDays=" + validityDays + ", amount="
				+ amount + ", quantity=" + quantity + "]";
	}
	
}
