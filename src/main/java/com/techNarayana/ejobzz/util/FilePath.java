package com.techNarayana.ejobzz.util;


import java.io.Serializable;

import org.springframework.stereotype.Service;
@Service
public class FilePath implements Serializable {

	private static final long serialVersionUID = 8251297103173599909L;
	private String companyFilePath;
	private String resumePath;
	private String userfilepicPath;
	
	public String getCompanyFilePath() {
		return companyFilePath;
	}
	public void setCompanyFilePath(String companyFilePath) {
		this.companyFilePath = companyFilePath;
	}
	public String getResumePath() {
		return resumePath;
	}
	public void setResumePath(String resumePath) {
		this.resumePath = resumePath;
	}
	public String getUserfilepicPath() {
		return userfilepicPath;
	}
	public void setUserfilepicPath(String userfilepicPath) {
		this.userfilepicPath = userfilepicPath;
	}
	

}
