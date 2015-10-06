package com.techNarayana.ejobzz.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="job")
public class JobDomain implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="jid")
	private Integer jKey;
	
	@Column(name="positionName")
	private String title;
	
	@Column(name="shortDescriptions")
	private String shortDescriptions;
	
	@Column(name="descriptions")
	private String descriptions;
	
	@Column(name="keySkills")
	private String keySkills;
	
	@Column(name="industryType")
	private String industryType;
	
	@Column(name="noticePeriod")
	private Integer noticePeriod;
	
	@Column(name="minExpYear")
	private Integer minExpYear;
	
	@Column(name="minExpMonth")
	private Integer minExpMonth;
	
	@Column(name="maxExpYear")
	private Integer maxExpYear;
	
	@Column(name="maxExpMonth")
	private Integer maxExpMonth;
	
	@Column(name="minSalary")
	private double minSal;
	
	@Column(name="maxSalary")
	private double maxSal;
	
	@Column(name="location")
	private String location;
	
	@Column(name="job_type")
	private String jobType;
	
	@Column(name="cid")
	private Integer companyId;
	
	@Column(name="status")
	private char status;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="creates")
	private Date createtsDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modifyts")
	private Date modifytsDate;
	
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
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	
}