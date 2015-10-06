package com.techNarayana.ejobzz.dto;

public class SubscriptionDTO {
	public Integer sid;
	public String postingType;
	public String name;
	public Integer validityDays;
	public Double amount;
	public Integer quantity;
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

