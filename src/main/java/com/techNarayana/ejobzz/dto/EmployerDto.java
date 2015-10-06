/**
 * 
 */
package com.techNarayana.ejobzz.dto;

/**
 * @author hkit solns
 * Written by Dilip  
 */
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;

import org.springframework.web.multipart.MultipartFile;

import com.techNarayana.ejobzz.domain.EmployerJobSeekerAccessedDomain;
import com.techNarayana.ejobzz.domain.EmployerSubscriptionDomain;

public class EmployerDto {
	private Integer companyKey;
	private String name;
	private String email;
	private String phoneNo;
	private String type;
	private String address;
	private String country;
	private String state;
	private String city;
	private Integer pin;
	private String contactPersionName;
	private String imgPath;
	private MultipartFile file;
	private char status;
	private Date createtsDate;
	private Date modifytsDate;
	
	private String password;
	
	@Column(name="today_accessed_resumes_qty" , nullable = false, columnDefinition = "int default 0")
	private int todayAccessedResumes;
	
	@Column(name="today_posted_jobs_qty" , nullable = false, columnDefinition = "int default 0")
	private int todayPostedJobs;
	
	@Column(name="total_accessed_resumes_qty" , nullable = false, columnDefinition = "int default 0")
	private int totalAccessedResumes;
	
	@Column(name="total_posted_jobs_qty" , nullable = false, columnDefinition = "int default 0")
	private int totalPostedJobs;
	
	@Column(name="last_resume_accessed_date")
	private Date lastResumeAccessed;
	
	@Column(name="last_job_posted_date")
	private Date lastPobPosted;
	
	// one to many mapping definition
	private Set<EmployerSubscriptionDomain> subscriptionRecords = new HashSet<EmployerSubscriptionDomain>(0);
	
	private Set<EmployerJobSeekerAccessedDomain> accessedJobSeekerRecords = new HashSet<EmployerJobSeekerAccessedDomain>(0);

	public Integer getCompanyKey() {
		return companyKey;
	}

	public void setCompanyKey(Integer companyKey) {
		this.companyKey = companyKey;
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

	public String getPhoneNo() {
		return phoneNo;
	}

	public int getTodayAccessedResumes() {
		return todayAccessedResumes;
	}

	public void setTodayAccessedResumes(int todayAccessedResumes) {
		this.todayAccessedResumes = todayAccessedResumes;
	}

	
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public Integer getPin() {
		return pin;
	}

	public void setPin(Integer pin) {
		this.pin = pin;
	}

	public String getContactPersionName() {
		return contactPersionName;
	}

	public void setContactPersionName(String contactPersionName) {
		this.contactPersionName = contactPersionName;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<EmployerSubscriptionDomain> getSubscriptionRecords() {
		return subscriptionRecords;
	}

	public void setSubscriptionRecords(
			Set<EmployerSubscriptionDomain> subscriptionRecords) {
		this.subscriptionRecords = subscriptionRecords;
	}

	public Set<EmployerJobSeekerAccessedDomain> getAccessedJobSeekerRecords() {
		return accessedJobSeekerRecords;
	}

	public void setAccessedJobSeekerRecords(
			Set<EmployerJobSeekerAccessedDomain> accessedJobSeekerRecords) {
		this.accessedJobSeekerRecords = accessedJobSeekerRecords;
	}

	public int getTodayPostedJobs() {
		return todayPostedJobs;
	}

	public void setTodayPostedJobs(int todayPostedJobs) {
		this.todayPostedJobs = todayPostedJobs;
	}

	public int getTotalAccessedResumes() {
		return totalAccessedResumes;
	}

	public void setTotalAccessedResumes(int totalAccessedResumes) {
		this.totalAccessedResumes = totalAccessedResumes;
	}

	public int getTotalPostedJobs() {
		return totalPostedJobs;
	}

	public void setTotalPostedJobs(int totalPostedJobs) {
		this.totalPostedJobs = totalPostedJobs;
	}


	public void setLastResumeAccessed(Date lastResumeAccessed) {
		this.lastResumeAccessed = lastResumeAccessed;
	}
	
	
}
