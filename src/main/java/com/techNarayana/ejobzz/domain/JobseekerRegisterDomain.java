package com.techNarayana.ejobzz.domain;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
@Entity
@Table(name="jobseeker")
public class JobseekerRegisterDomain {
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
	public String textResume;
	public String status;
	public Date creates;
	public Date modifyts;
	public double totalExp;
	public String resumeTitle;
	public String designation;
	public List<JobSeekerExperienceDomain> domain;
	public List<JobSeekerEducationDetailsDomain> edomain;
	public Set<JobSeekerSkillsDomain> sdomain;
	public List<JobSeekerLanguageDomain> lang;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "jsid", unique = true, nullable = false)
	public Integer getJsid() {
		return jsid;
	}
	public void setJsid(Integer jsid) {
		this.jsid = jsid;
	}
	
	@Column(name = "name")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "email", unique = true, nullable = false)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name = "userType",  nullable = false)
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	@Column(name = "password",  nullable = false)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name = "location")
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Column(name = "jobInterestLocations")
	public String getJobIntrestLocations() {
		return jobIntrestLocations;
	}
	public void setJobIntrestLocations(String jobIntrestLocations) {
		this.jobIntrestLocations = jobIntrestLocations;
	}
	@Column(name = "contactNo")
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	@Column(name = "keySkills")
	public String getKeySkills() {
		return keySkills;
	}
	public void setKeySkills(String keySkills) {
		this.keySkills = keySkills;
	}
	@Column(name = "address")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Column(name = "country")
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Column(name = "state")
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Column(name = "city")
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Column(name = "pin")
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	@Column(name = "dob")
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	@Column(name = "gender")
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	@Column(name = "profilePicPath")
	public String getProfilePicPath() {
		return profilePicPath;
	}
	public void setProfilePicPath(String profilePicPath) {
		this.profilePicPath = profilePicPath;
	}
	@Column(name = "resumePath")
	public String getResumePath() {
		return resumePath;
	}
	public void setResumePath(String resumePath) {
		this.resumePath = resumePath;
	}
	@Column(name = "textResume")
	public String getTextResume() {
		return textResume;
	}
	public void setTextResume(String textResume) {
		this.textResume = textResume;
	}
	@Column(name = "status")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Column(name = "creates")
	public Date getCreates() {
		return creates;
	}
	public void setCreates(Date creates) {
		this.creates = creates;
	}
	@Column(name = "modifyts")
	public Date getModifyts() {
		return modifyts;
	}
	public void setModifyts(Date modifyts) {
		this.modifyts = modifyts;
	}
	@Column(name = "totalExp")
	public double getTotalExp() {
		return totalExp;
	}
	public void setTotalExp(double totalExp) {
		this.totalExp = totalExp;
	}
	@Column(name = "resumeTitle")
	public String getResumeTitle() {
		return resumeTitle;
	}
	public void setResumeTitle(String resumeTitle) {
		this.resumeTitle = resumeTitle;
	}
	@Column(name = "designation")
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	@OneToMany(mappedBy = "job",fetch=FetchType.EAGER) 
	@Fetch(FetchMode.SELECT)
	public List<JobSeekerExperienceDomain> getDomain() {
		return domain;
	}
	public void setDomain(List<JobSeekerExperienceDomain> domain) {
		this.domain = domain;
	}
	@OneToMany(mappedBy = "job1",fetch=FetchType.EAGER) 
	@Fetch(FetchMode.SELECT)
	public List<JobSeekerEducationDetailsDomain> getEdomain() {
		return edomain;
	}
	
	public void setEdomain(List<JobSeekerEducationDetailsDomain> edomain) {
		this.edomain = edomain;
	}
	
	
	
	@OneToMany(mappedBy = "skill",fetch=FetchType.EAGER) 
	public Set<JobSeekerSkillsDomain> getSdomain() {
		return sdomain;
	}
	public void setSdomain(Set<JobSeekerSkillsDomain> sdomain) {
		this.sdomain = sdomain;
	}
	
	
	
	@OneToMany(mappedBy = "language",fetch=FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	public List<JobSeekerLanguageDomain> getLang() {
		return lang;
	}
	public void setLang(List<JobSeekerLanguageDomain> lang) {
		this.lang = lang;
	}
	
	
	
	@Override
	public String toString() {
		return "JobseekerRegisterDomain [jsid=" + jsid + ", name=" + name
				+ ", email=" + email + ", userType=" + userType + ", password="
				+ password + ", location=" + location
				+ ", jobIntrestLocations=" + jobIntrestLocations
				+ ", contactNo=" + contactNo + ", keySkills=" + keySkills
				+ ", address=" + address + ", country=" + country + ", state="
				+ state + ", city=" + city + ", pin=" + pin + ", dob=" + dob
				+ ", gender=" + gender + ", profilePicPath=" + profilePicPath
				+ ", resumePath=" + resumePath + ", status=" + status
				+ ", creates=" + creates + ", modifyts=" + modifyts
				+ "]";
	}
	
	
	


}
