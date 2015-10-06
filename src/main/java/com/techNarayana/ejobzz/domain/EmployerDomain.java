package com.techNarayana.ejobzz.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="companyprofile")

public class EmployerDomain implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cid")
	private Integer companyKey;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="contactNo")
	private String phoneNo;
	
	@Column(name="type")
	private String type;
	
	@Column(name="address")
	private String address;
	
	@Column(name="country")
	private String country;
	
	@Column(name="state")
	private String state;
	
	@Column(name="city")
	private String city;
	
	@Column(name="pin")
	private Integer pin;
	
	@Column(name="contactPersion")
	private String contactPersionName;
	
	@Column(name="logoPath")
	private String imgPath;
	
	@Column(name="status")
	private char status;
	
	@Column(name="creates")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createtsDate;
	
	@Column(name="modifyts")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifytsDate;
	
	@Column(name="password")
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
	private Date lastjobPosted;
	
	// one to many mapping definition
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employerDomain")
	private Set<EmployerSubscriptionDomain> subscriptionRecords = new HashSet<EmployerSubscriptionDomain>(0);
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employerDomain")
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

	public int getTodayAccessedResumes() {
		return todayAccessedResumes;
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

	public void setTodayAccessedResumes(int todayAccessedResumes) {
		this.todayAccessedResumes = todayAccessedResumes;
	}
	
	public Date getLastjobPosted() {
		return lastjobPosted;
	}

	public void setLastjobPosted(Date lastjobPosted) {
		this.lastjobPosted = lastjobPosted;
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

	public Date getLastResumeAccessed() {
		return lastResumeAccessed;
	}

	public void setLastResumeAccessed(Date lastResumeAccessed) {
		this.lastResumeAccessed = lastResumeAccessed;
	}

	public Date getLastJobPosted() {
		return lastjobPosted;
	}

	public void setLastJobPosted(Date lastjobPosted) {
		this.lastjobPosted = lastjobPosted;
	}
	
}
