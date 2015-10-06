package com.techNarayana.ejobzz.dto;

public class JobSeekerLanguageDTO {
	public Integer jlid;
	public String langname;
	public String lread;
	public String lwrite;
	public String lspeak;
	public String profeciency;
	public String lid;
	public JobseekerRegisterDTO lang;
	public Integer getJlid() {
		return jlid;
	}
	public void setJlid(Integer jlid) {
		this.jlid = jlid;
	}
	public String getLangname() {
		return langname;
	}
	public void setLangname(String langname) {
		this.langname = langname;
	}
	
	public String getProfeciency() {
		return profeciency;
	}
	public void setProfeciency(String profeciency) {
		this.profeciency = profeciency;
	}
	
	
	
	
	public String getLread() {
		return lread;
	}
	public void setLread(String lread) {
		this.lread = lread;
	}
	public String getLwrite() {
		return lwrite;
	}
	public void setLwrite(String lwrite) {
		this.lwrite = lwrite;
	}
	public String getLspeak() {
		return lspeak;
	}
	public void setLspeak(String lspeak) {
		this.lspeak = lspeak;
	}
	public JobseekerRegisterDTO getLang() {
		return lang;
	}
	public void setLang(JobseekerRegisterDTO lang) {
		this.lang = lang;
	}
	
	
	public String getLid() {
		return lid;
	}
	public void setLid(String lid) {
		this.lid = lid;
	}
	@Override
	public String toString() {
		return "JobSeekerLanguageDTO [jlid=" + jlid + ", langname=" + langname
				+ ", read=" + lread + ", write=" + lwrite + ", speak=" + lspeak
				+ ", profeciency=" + profeciency + ", lid=" + lid + ", lang="
				+ lang + "]";
	}
	
	
}
