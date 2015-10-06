package com.techNarayana.ejobzz.dto;


public class JobSeekerExperienceDTO {
	
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
	private JobseekerRegisterDTO job;
	
	public Integer getJseid() {
		return jseid;
	}
	public void setJseid(Integer jseid) {
		this.jseid = jseid;
	}
	public JobseekerRegisterDTO getJob() {
		return job;
	}
	public void setJob(JobseekerRegisterDTO job) {
		this.job = job;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Integer getCurrentsalLackh() {
		return currentsalLackh;
	}
	public void setCurrentsalLackh(Integer currentsalLackh) {
		this.currentsalLackh = currentsalLackh;
	}
	public Integer getCurrentsalThousand() {
		return currentsalThousand;
	}
	public void setCurrentsalThousand(Integer currentsalThousand) {
		this.currentsalThousand = currentsalThousand;
	}
	public String getCurrencyType() {
		return currencyType;
	}
	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}
	public Integer getJoinedyear() {
		return joinedyear;
	}
	public void setJoinedyear(Integer joinedyear) {
		this.joinedyear = joinedyear;
	}
	public Integer getJoinedmonth() {
		return joinedmonth;
	}
	public void setJoinedmonth(Integer joinedmonth) {
		this.joinedmonth = joinedmonth;
	}
	public Integer getEndingyear() {
		return endingyear;
	}
	public void setEndingyear(Integer endingyear) {
		this.endingyear = endingyear;
	}
	public Integer getEndingmonth() {
		return endingmonth;
	}
	public void setEndingmonth(Integer endingmonth) {
		this.endingmonth = endingmonth;
	}
	public String getJobProfileDesc() {
		return jobProfileDesc;
	}
	public void setJobProfileDesc(String jobProfileDesc) {
		this.jobProfileDesc = jobProfileDesc;
	}
	
	public String getIndustryType() {
		return industryType;
	}
	public void setIndustryType(String industryType) {
		this.industryType = industryType;
	}
	
	public String getEmployeeType() {
		return employeeType;
	}
	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}
	@Override
	public String toString() {
		return "JobSeekerExperienceDTO [jseid=" + jseid + ", companyName="
				+ companyName + ", designation=" + designation
				+ ", industryType=" + industryType + ", currentsalLackh="
				+ currentsalLackh + ", currentsalThousand="
				+ currentsalThousand + ", currencyType=" + currencyType
				+ ", joinedyear=" + joinedyear + ", joinedmonth=" + joinedmonth
				+ ", endingyear=" + endingyear + ", endingmonth=" + endingmonth
				+ ", jobProfileDesc=" + jobProfileDesc + "]";
	}
	
	
	


}
