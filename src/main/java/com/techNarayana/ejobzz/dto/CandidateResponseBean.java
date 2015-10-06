package com.techNarayana.ejobzz.dto;

import java.util.Date;

public class CandidateResponseBean {
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
	public String gender;
	public String profilePicPath;
	public String resumePath;
	public Double totalExp;
	public String status;
	public Date creates;
	public Date modifyts;
	public String resumeTittle;
	
	public String getResumeTittle() {
		return resumeTittle;
	}
	public void setResumeTittle(String resumeTittle) {
		this.resumeTittle = resumeTittle;
	}
	public CandidateExpResponseBean exp;
	
	public CandidateExpResponseBean getExp() {
		return exp;
	}
	public void setExp(CandidateExpResponseBean exp) {
		this.exp = exp;
	}
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
	public String getProfilePicPath() {
		return profilePicPath;
	}
	public void setProfilePicPath(String profilePicPath) {
		this.profilePicPath = profilePicPath;
	}
	public String getResumePath() {
		return resumePath;
	}
	public void setResumePath(String resumePath) {
		this.resumePath = resumePath;
	}
	public Double getTotalExp() {
		return totalExp;
	}
	public void setTotalExp(Double totalExp) {
		this.totalExp = totalExp;
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
	
}
