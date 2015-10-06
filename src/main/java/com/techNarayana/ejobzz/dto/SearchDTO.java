package com.techNarayana.ejobzz.dto;

public class SearchDTO {
	
	private String skill1;
	private String skill2;
	private String skill3;
	
	private String skill4;
	private String skill5;
	private String skillexp1;
	private String skillexp2;
	private String skillexp3;
	private String skillexp4;
	private String skillexp5;
	private String anyKeyWords;
	private String allKeyWords;
	
	private String excludingkey;

	private String resumeCheckBox;
	
	
	private double minExpYear;
	private double maxExpYear;
	

	private Integer minSalLac;
	private Integer minSalThousand;
	
	private Integer maxSalLac;
	private Integer maxSalThousand;
	
	private boolean includeZeroSal;
	
	private String location;
	private String preferedLocation;
	
	
	private String functionalArea;
	private String industryType;
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

	private double minSal;
	private double maxSal;
	
	
	
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
	public String getSkillexp1() {
		return skillexp1;
	}
	public void setSkillexp1(String skillexp1) {
		this.skillexp1 = skillexp1;
	}
	public String getSkillexp2() {
		return skillexp2;
	}
	public void setSkillexp2(String skillexp2) {
		this.skillexp2 = skillexp2;
	}
	public String getSkillexp3() {
		return skillexp3;
	}
	public void setSkillexp3(String skillexp3) {
		this.skillexp3 = skillexp3;
	}
	public String getSkillexp4() {
		return skillexp4;
	}
	public void setSkillexp4(String skillexp4) {
		this.skillexp4 = skillexp4;
	}
	public String getSkillexp5() {
		return skillexp5;
	}
	public void setSkillexp5(String skillexp5) {
		this.skillexp5 = skillexp5;
	}
	public String getResumeCheckBox() {
		return resumeCheckBox;
	}
	public void setResumeCheckBox(String resumeCheckBox) {
		this.resumeCheckBox = resumeCheckBox;
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
	public String getIndustryType() {
		return industryType;
	}
	public void setIndustryType(String industryType) {
		this.industryType = industryType;
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
	public String getSkill1() {
		return skill1;
	}
	public void setSkill1(String skill1) {
		this.skill1 = skill1;
	}
	public String getSkill2() {
		return skill2;
	}
	public void setSkill2(String skill2) {
		this.skill2 = skill2;
	}
	public String getSkill3() {
		return skill3;
	}
	public void setSkill3(String skill3) {
		this.skill3 = skill3;
	}
	public String getSkill4() {
		return skill4;
	}
	public void setSkill4(String skill4) {
		this.skill4 = skill4;
	}
	public String getSkill5() {
		return skill5;
	}
	public void setSkill5(String skill5) {
		this.skill5 = skill5;
	}
	
	
	
}
