/**
 * 
 */
package com.techNarayana.ejobzz.dto;

/**
 * @author hkit solns
 * Written by Dilip  
 */
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class CompanyDto {
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
	private Integer resumeAccess;
	private Integer jobPosts;
	
	
	public CompanyDto(){}
	public CompanyDto(Integer companyKey, String name, String email,
			String phoneNo, String type, String address, String country,
			String state, String city, Integer pin, String contactPersionName,
			String imgPath, MultipartFile file, char status, Date createtsDate,
			Date modifytsDate, String password, Integer resumeAccess,
			Integer jobPosts) {
		super();
		this.companyKey = companyKey;
		this.name = name;
		this.email = email;
		this.phoneNo = phoneNo;
		this.type = type;
		this.address = address;
		this.country = country;
		this.state = state;
		this.city = city;
		this.pin = pin;
		this.contactPersionName = contactPersionName;
		this.imgPath = imgPath;
		this.file = file;
		this.status = status;
		this.createtsDate = createtsDate;
		this.modifytsDate = modifytsDate;
		this.password = password;
		this.resumeAccess = resumeAccess;
		this.jobPosts = jobPosts;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		 this.password=password;
	}
	
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

	public Integer getResumeAccess() {
		return resumeAccess;
	}

	public void setResumeAccess(Integer resumeAccess) {
		this.resumeAccess = resumeAccess;
	}

	public Integer getJobPosts() {
		return jobPosts;
	}

	public void setJobPosts(Integer jobPosts) {
		this.jobPosts = jobPosts;
	}

	@Override
	public String toString() {
		return "CompanyDto [companyKey=" + companyKey + ", name=" + name
				+ ", email=" + email + ", phoneNo=" + phoneNo + ", type="
				+ type + ", address=" + address + ", country=" + country
				+ ", state=" + state + ", city=" + city + ", pin=" + pin
				+ ", contactPersionName=" + contactPersionName + ", imgPath="
				+ imgPath + ", file=" + file + ", status=" + status
				+ ", createtsDate=" + createtsDate + ", modifytsDate="
				+ modifytsDate + ", password=" + password + ", resumeAccess="
				+ resumeAccess + ", jobPosts=" + jobPosts + "]";
	}
	

}
