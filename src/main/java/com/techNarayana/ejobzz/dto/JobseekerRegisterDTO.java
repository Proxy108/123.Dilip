package com.techNarayana.ejobzz.dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class JobseekerRegisterDTO {

	public Integer jsid;
	public String name;
	public String email;
	public String userType;
	public String password;
	public String location;
	public String jobIntrestLocations;
	public String contactNo;
	public String keySkills;
	public String address;
	public String country;
	public String state;
	public String city;
	public String pin;
	public String dob;
	public String textResume;
	public String gender;
	public MultipartFile profilePicPath;
	public MultipartFile resumePath;
	public String status;
	public Date creates;
	public Date modifyts;
	public double totalExp;
	public String resumeTitle;
	public String designation;
	public JobSeekerExperienceDTO edto;
	public JobSeekerEducationDetailsDTO dto;
	public JobSeekerSkillsDTO skills;
	public JobSeekerLanguageDTO lan;
	
	public Integer getJsid() {
		return jsid;
	}
	public void setJsid(Integer jsid) {
		this.jsid = jsid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getJobIntrestLocations() {
		return jobIntrestLocations;
	}
	public void setJobIntrestLocations(String jobIntrestLocations) {
		this.jobIntrestLocations = jobIntrestLocations;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getKeySkills() {
		return keySkills;
	}
	public void setKeySkills(String keySkills) {
		this.keySkills = keySkills;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}


	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}


	public MultipartFile getProfilePicPath() {
		return profilePicPath;
	}
	public void setProfilePicPath(MultipartFile profilePicPath) {
		this.profilePicPath = profilePicPath;
	}
	public MultipartFile getResumePath() {
		return resumePath;
	}
	public void setResumePath(MultipartFile resumePath) {
		this.resumePath = resumePath;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreates() {
		return creates;
	}
	public void setCreates(Date creates) {
		this.creates = creates;
	}
	public Date getModifyts() {
		return modifyts;
	}
	public void setModifyts(Date modifyts) {
		this.modifyts = modifyts;
	}
	public double getTotalExp() {
		return totalExp;
	}
	public void setTotalExp(double totalExp) {
		this.totalExp = totalExp;
	}
	
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getResumeTitle() {
		return resumeTitle;
	}
	public void setResumeTitle(String resumeTitle) {
		this.resumeTitle = resumeTitle;
	}
	public JobSeekerExperienceDTO getEdto() {
		return edto;
	}
	public void setEdto(JobSeekerExperienceDTO edto) {
		this.edto = edto;
	}
	public JobSeekerEducationDetailsDTO getDto() {
		return dto;
	}
	public void setDto(JobSeekerEducationDetailsDTO dto) {
		this.dto = dto;
	}
	
	public JobSeekerSkillsDTO getSkills() {
		return skills;
	}
	public void setSkills(JobSeekerSkillsDTO skills) {
		this.skills = skills;
	}
	public JobSeekerLanguageDTO getLan() {
		return lan;
	}
	public void setLan(JobSeekerLanguageDTO lan) {
		this.lan = lan;
	}
	public String getTextResume() {
		return textResume;
	}
	public void setTextResume(String textResume) {
		this.textResume = textResume;
	}
	@Override
	public String toString() {
		return "JobseekerRegisterDTO [jsid=" + jsid + ", name=" + name
				+ ", email=" + email + ", userType=" + userType + ", password="
				+ password + ", location=" + location
				+ ", jobIntrestLocations=" + jobIntrestLocations
				+ ", contactNo=" + contactNo + ", keySkills=" + keySkills
				+ ", address=" + address + ", country=" + country + ", state="
				+ state + ", city=" + city + ", pin=" + pin + ", dob=" + dob
				+ ", gender=" + gender + ", profilePicPath=" + profilePicPath
				+ ", resumePath=" + resumePath + ", status=" + status
				+ ", creates=" + creates + ", modifyts=" + modifyts
				+ ", totalExp=" + totalExp + ", resumeTitle=" + resumeTitle
				+ ", designation=" + designation + "]";
	}
	


}
