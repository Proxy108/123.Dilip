package com.techNarayana.ejobzz.dto;

public class JobSeekerSkillsDTO {
	public Integer skillId;
	public String skillName;
	public String version;
	public String expyears;
	public String expmonths;
	public String lastused;
	public String skilid;
	public JobseekerRegisterDTO skill;
	
	public Integer getSkillId() {
		return skillId;
	}
	public void setSkillId(Integer skillId) {
		this.skillId = skillId;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getExpyears() {
		return expyears;
	}
	public void setExpyears(String expyears) {
		this.expyears = expyears;
	}
	public String getExpmonths() {
		return expmonths;
	}
	public void setExpmonths(String expmonths) {
		this.expmonths = expmonths;
	}
	public JobseekerRegisterDTO getSkill() {
		return skill;
	}
	public void setSkill(JobseekerRegisterDTO skill) {
		this.skill = skill;
	}
	
	
	public String getLastused() {
		return lastused;
	}
	public void setLastused(String lastused) {
		this.lastused = lastused;
	}
	public String getSkilid() {
		return skilid;
	}
	public void setSkilid(String skilid) {
		this.skilid = skilid;
	}
	@Override
	public String toString() {
		return "JobSeekerSkillsDTO [skillId=" + skillId + ", skillName="
				+ skillName + ", version=" + version + ", expyears=" + expyears
				+ ", expmonths=" + expmonths + ", lastused=" + lastused
				+ ", skilid=" + skilid + ", skill=" + skill + "]";
	}
	


}
