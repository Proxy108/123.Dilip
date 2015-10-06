package com.techNarayana.ejobzz.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Table(name="joblang")
public class JobSeekerLanguageDomain {
	public Integer jlid;
	public String langname;
	public String lread;
	public String lwrite;
	public String lspeak;
	public String profeciency;
	public String lid;

	private JobseekerRegisterDomain language;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "jlid", nullable = false)
	public Integer getJlid() {
		return jlid;
	}
	public void setJlid(Integer jlid) {
		this.jlid = jlid;
	}
	@Column(name = "langname")
	public String getLangname() {
		return langname;
	}
	public void setLangname(String langname) {
		this.langname = langname;
	}
	@Column(name = "lread")
	
	public String getLread() {
		return lread;
	}
	public void setLread(String lread) {
		this.lread = lread;
	}
	
	
	
	@Column(name = "lwrite")
	public String getLwrite() {
		return lwrite;
	}
	public void setLwrite(String lwrite) {
		this.lwrite = lwrite;
	}
	@Column(name = "lspeak")
	public String getLspeak() {
		return lspeak;
	}
	public void setLspeak(String lspeak) {
		this.lspeak = lspeak;
	}
	@Column(name = "profeciency")
	public String getProfeciency() {
		return profeciency;
	}
	public void setProfeciency(String profeciency) {
		this.profeciency = profeciency;
	}
	@ManyToOne
	@JoinColumn(name = "jsid")  
	public JobseekerRegisterDomain getLanguage() {
		return language;
	}
	public void setLanguage(JobseekerRegisterDomain language) {
		this.language = language;
	}
	@Transient	
	@Column(name = "lid")
	public String getLid() {
		return lid;
	}
	public void setLid(String lid) {
		this.lid = lid;
	}
	@Override
	public String toString() {
		return "JobSeekerLanguageDomain [jlid=" + jlid + ", langname="
				+ langname + ", read=" + lread + ", write=" + lwrite + ", speak="
				+ lspeak + ", profeciency=" + profeciency + ", lid=" + lid
				+ "]";
	}

}
