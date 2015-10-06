package com.techNarayana.ejobzz.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="jobseekersexperience")
public class JobSeekerExperienceDomain {
	
	public Integer jseid;
	public String companyName;
	public String designation;
	public String industryType;
	public Integer currentsalLackh;
	public Integer currentsalThousand;
	public String currencyType;
	public String employeeType;
	public Integer joinedyear;
	public Integer joinedmonth;
	public Integer endingyear;
	public Integer endingmonth;
	public String jobProfileDesc;
	
	
	public JobseekerRegisterDomain job;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name ="jseid", unique = true, nullable = false)
	public Integer getJseid() {
		return jseid;
	}
	public void setJseid(Integer jseid) {
		this.jseid = jseid;
	}
	@Column(name = "companyName")
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	@Column(name = "designation")
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	@Column(name = "currentsalLackh")
	public Integer getCurrentsalLackh() {
		return currentsalLackh;
	}
	public void setCurrentsalLackh(Integer currentsalLackh) {
		this.currentsalLackh = currentsalLackh;
	}
	@Column(name = "currentsalThousand")
	public Integer getCurrentsalThousand() {
		return currentsalThousand;
	}
	public void setCurrentsalThousand(Integer currentsalThousand) {
		this.currentsalThousand = currentsalThousand;
	}
	@Column(name = "currencyType")
	public String getCurrencyType() {
		return currencyType;
	}
	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}
	
	@Column(name = "joinedyear")
	public Integer getJoinedyear() {
		return joinedyear;
	}
	public void setJoinedyear(Integer joinedyear) {
		this.joinedyear = joinedyear;
	}
	@Column(name = "joinedmonth")
	public Integer getJoinedmonth() {
		return joinedmonth;
	}
	public void setJoinedmonth(Integer joinedmonth) {
		this.joinedmonth = joinedmonth;
	}
	@Column(name = "endingyear")
	public Integer getEndingyear() {
		return endingyear;
	}
	public void setEndingyear(Integer endingyear) {
		this.endingyear = endingyear;
	}
	@Column(name = "endingmonth")
	public Integer getEndingmonth() {
		return endingmonth;
	}
	public void setEndingmonth(Integer endingmonth) {
		this.endingmonth = endingmonth;
	}
	@Column(name = "jobProfileDesc")
	public String getJobProfileDesc() {
		return jobProfileDesc;
	}
	public void setJobProfileDesc(String jobProfileDesc) {
		this.jobProfileDesc = jobProfileDesc;
	}
	
	@ManyToOne
	@JoinColumn(name = "jsid")  
	public JobseekerRegisterDomain getJob() {
		return job;
	}
	@Column(name = "industryType")
	public void setJob(JobseekerRegisterDomain job) {
		this.job = job;
	}
	public String getIndustryType() {
		return industryType;
	}
	public void setIndustryType(String industryType) {
		this.industryType = industryType;
	}
	
	@Column(name = "employeeType")
	public String getEmployeeType() {
		return employeeType;
	}
	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}
	@Override
	public String toString() {
		return "JobSeekerExperienceDomain [jseid=" + jseid + ", companyName="
				+ companyName + ", designation=" + designation
				+ ", industryType=" + industryType + ", currentsalLackh="
				+ currentsalLackh + ", currentsalThousand="
				+ currentsalThousand + ", currencyType=" + currencyType
				+ ", joinedyear=" + joinedyear + ", joinedmonth=" + joinedmonth
				+ ", endingyear=" + endingyear + ", endingmonth=" + endingmonth
				+ ", jobProfileDesc=" + jobProfileDesc + "]";
	}
	
	
	
}
