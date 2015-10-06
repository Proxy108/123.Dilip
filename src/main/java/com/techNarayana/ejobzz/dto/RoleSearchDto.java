package com.techNarayana.ejobzz.dto;

public class RoleSearchDto {
	
	private String industryType;
	private String designation;
	private double minExpYear;
	private double maxExpYear;
	private String anyKeyWords;
	private String allKeyWords;
	
	private String excludingkey;

	public String getAnyKeyWords() {
		return anyKeyWords;
	}
	public void setAnyKeyWords(String anyKeyWords) {
		this.anyKeyWords = anyKeyWords;
	}
	public String getAllKeyWords() {
		return allKeyWords;
	}
	public void setAllKeyWords(String allKeyWords) {
		this.allKeyWords = allKeyWords;
	}
	public String getExcludingkey() {
		return excludingkey;
	}
	public void setExcludingkey(String excludingkey) {
		this.excludingkey = excludingkey;
	}
	private Integer minSalLac;
	private Integer minSalThousand;
	
	private Integer maxSalLac;
	private Integer maxSalThousand;
	
	private boolean includeZeroSal;
	
	private String location;
	private String preferedLocation;
	
	
	private String functionalArea;
	
	private String excludeEmployer;
	private String currentEmployer;
	private String desingnation;
	
	private String ugQualification;
	private String institute;
	private Integer passingYearFrom;
	private Integer passingYearTo;

	
	private Integer candidateAgeFrom;
	private Integer candidateAgeTo;
	private Integer activeDays;
	private Integer noticePeriod;
	
	public String getIndustryType() {
		return industryType;
	}
	public void setIndustryType(String industryType) {
		this.industryType = industryType;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getMinExpYear() {
		return minExpYear;
	}
	public void setMinExpYear(double minExpYear) {
		this.minExpYear = minExpYear;
	}
	public double getMaxExpYear() {
		return maxExpYear;
	}
	public void setMaxExpYear(double maxExpYear) {
		this.maxExpYear = maxExpYear;
	}
	public Integer getMinSalLac() {
		return minSalLac;
	}
	public void setMinSalLac(Integer minSalLac) {
		this.minSalLac = minSalLac;
	}
	public Integer getMinSalThousand() {
		return minSalThousand;
	}
	public void setMinSalThousand(Integer minSalThousand) {
		this.minSalThousand = minSalThousand;
	}
	public Integer getMaxSalLac() {
		return maxSalLac;
	}
	public void setMaxSalLac(Integer maxSalLac) {
		this.maxSalLac = maxSalLac;
	}
	public Integer getMaxSalThousand() {
		return maxSalThousand;
	}
	public void setMaxSalThousand(Integer maxSalThousand) {
		this.maxSalThousand = maxSalThousand;
	}
	public boolean isIncludeZeroSal() {
		return includeZeroSal;
	}
	public void setIncludeZeroSal(boolean includeZeroSal) {
		this.includeZeroSal = includeZeroSal;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPreferedLocation() {
		return preferedLocation;
	}
	public void setPreferedLocation(String preferedLocation) {
		this.preferedLocation = preferedLocation;
	}
	public String getFunctionalArea() {
		return functionalArea;
	}
	public void setFunctionalArea(String functionalArea) {
		this.functionalArea = functionalArea;
	}
	public String getExcludeEmployer() {
		return excludeEmployer;
	}
	public void setExcludeEmployer(String excludeEmployer) {
		this.excludeEmployer = excludeEmployer;
	}
	public String getCurrentEmployer() {
		return currentEmployer;
	}
	public void setCurrentEmployer(String currentEmployer) {
		this.currentEmployer = currentEmployer;
	}
	public String getDesingnation() {
		return desingnation;
	}
	public void setDesingnation(String desingnation) {
		this.desingnation = desingnation;
	}
	public String getUgQualification() {
		return ugQualification;
	}
	public void setUgQualification(String ugQualification) {
		this.ugQualification = ugQualification;
	}
	public String getInstitute() {
		return institute;
	}
	public void setInstitute(String institute) {
		this.institute = institute;
	}
	public Integer getPassingYearFrom() {
		return passingYearFrom;
	}
	public void setPassingYearFrom(Integer passingYearFrom) {
		this.passingYearFrom = passingYearFrom;
	}
	public Integer getPassingYearTo() {
		return passingYearTo;
	}
	public void setPassingYearTo(Integer passingYearTo) {
		this.passingYearTo = passingYearTo;
	}
	public Integer getCandidateAgeFrom() {
		return candidateAgeFrom;
	}
	public void setCandidateAgeFrom(Integer candidateAgeFrom) {
		this.candidateAgeFrom = candidateAgeFrom;
	}
	public Integer getCandidateAgeTo() {
		return candidateAgeTo;
	}
	public void setCandidateAgeTo(Integer candidateAgeTo) {
		this.candidateAgeTo = candidateAgeTo;
	}
	public Integer getActiveDays() {
		return activeDays;
	}
	public void setActiveDays(Integer activeDays) {
		this.activeDays = activeDays;
	}
	public Integer getNoticePeriod() {
		return noticePeriod;
	}
	public void setNoticePeriod(Integer noticePeriod) {
		this.noticePeriod = noticePeriod;
	}
	
	
	
}
