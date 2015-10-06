package com.techNarayana.ejobzz.dto;

import java.util.Date;



public class JobDto {
	
	private Integer jKey;
	private String title;
	private String shortDescriptions;
	private String descriptions;
	private String keySkills;
	private String industryType;
	private Integer noticePeriod;
	private Integer minExpYear;
	private double minSal;
	private double maxSal;
	private Integer minExpMonth;
	private Integer maxExpYear;
	private Integer maxExpMonth;
	private String location;
	private Integer companyId;
	private char status;
	private Date createtsDate;
	private Date modifytsDate;
	
	
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
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
		return "JobDto [jKey=" + jKey + ", title=" + title
				+ ", shortDescriptions=" + shortDescriptions
				+ ", descriptions=" + descriptions + ", keySkills=" + keySkills
				+ ", industryType=" + industryType + ", noticePeriod="
				+ noticePeriod + ", minExpYear=" + minExpYear + ", minSal="
				+ minSal + ", maxSal=" + maxSal + ", minExpMonth="
				+ minExpMonth + ", maxExpYear=" + maxExpYear + ", maxExpMonth="
				+ maxExpMonth + ", location=" + location + ", companyId="
				+ companyId + ", status=" + status + ", createtsDate="
				+ createtsDate + ", modifytsDate=" + modifytsDate + "]";
	}
	
	
	}
