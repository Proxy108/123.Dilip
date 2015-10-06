package com.techNarayana.ejobzz.dto;

public class CandidateExpResponseBean {
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
	public Integer getJseid() {
		return jseid;
	}
	public void setJseid(Integer jseid) {
		this.jseid = jseid;
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
	public String getIndustryType() {
		return industryType;
	}
	public void setIndustryType(String industryType) {
		this.industryType = industryType;
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
	public String getEmployeeType() {
		return employeeType;
	}
	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
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
	@Override
	public String toString() {
		return "CandidateExpResponseBean [jseid=" + jseid + ", companyName="
				+ companyName + ", designation=" + designation
				+ ", industryType=" + industryType + ", currentsalLackh="
				+ currentsalLackh + ", currentsalThousand="
				+ currentsalThousand + ", currencyType=" + currencyType
				+ ", employeeType=" + employeeType + ", joinedyear="
				+ joinedyear + ", joinedmonth=" + joinedmonth + ", endingyear="
				+ endingyear + ", endingmonth=" + endingmonth
				+ ", jobProfileDesc=" + jobProfileDesc + "]";
	}
}
