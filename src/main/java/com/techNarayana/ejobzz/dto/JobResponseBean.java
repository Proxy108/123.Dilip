package com.techNarayana.ejobzz.dto;

public class JobResponseBean {
	private Integer jKey;
	private String title;
	private String shortDescriptions;
	private String descriptions;
	private String keySkills;
	private String industryType;
	private Integer noticePeriod;
	private Integer minExpYear;
	private Integer minExpMonth;
	private Integer maxExpYear;
	private Integer maxExpMonth;
	private double minSal;
	private double maxSal;
	private String location;
	private String status;
	private EmployerDto company;
	
	public Integer getMinExpYear() {
		return minExpYear;
	}
	public void setMinExpYear(Integer minExpYear) {
		this.minExpYear = minExpYear;
	}
	public Integer getMinExpMonth() {
		return minExpMonth;
	}
	public void setMinExpMonth(Integer minExpMonth) {
		this.minExpMonth = minExpMonth;
	}
	public Integer getMaxExpYear() {
		return maxExpYear;
	}
	public void setMaxExpYear(Integer maxExpYear) {
		this.maxExpYear = maxExpYear;
	}
	public Integer getMaxExpMonth() {
		return maxExpMonth;
	}
	public void setMaxExpMonth(Integer maxExpMonth) {
		this.maxExpMonth = maxExpMonth;
	}
	public Integer getjKey() {
		return jKey;
	}
	public void setjKey(Integer jKey) {
		this.jKey = jKey;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getShortDescriptions() {
		return shortDescriptions;
	}
	public void setShortDescriptions(String shortDescriptions) {
		this.shortDescriptions = shortDescriptions;
	}
	public String getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}
	public String getKeySkills() {
		return keySkills;
	}
	public void setKeySkills(String keySkills) {
		this.keySkills = keySkills;
	}
	public String getIndustryType() {
		return industryType;
	}
	public void setIndustryType(String industryType) {
		this.industryType = industryType;
	}
	public Integer getNoticePeriod() {
		return noticePeriod;
	}
	public void setNoticePeriod(Integer noticePeriod) {
		this.noticePeriod = noticePeriod;
	}
		
	public double getMinSal() {
		return minSal;
	}
	public void setMinSal(double minSal) {
		this.minSal = minSal;
	}
	public double getMaxSal() {
		return maxSal;
	}
	public void setMaxSal(double maxSal) {
		this.maxSal = maxSal;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public EmployerDto getCompany() {
		return company;
	}
	public void setCompany(EmployerDto company) {
		this.company = company;
	}
}
