package com.techNarayana.ejobzz.domain;

import java.beans.Transient;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="jobSkills")
public class JobSeekerSkillsDomain {
	public Integer skillId;
	public String skillName;
	public String version;
	public String expyears;
	public String expmonths;
	public String lastused;
	public String skilid;
	private JobseekerRegisterDomain skill;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name ="skillId", unique = true, nullable = false)
	public Integer getSkillId() {
		return skillId;
	}
	public void setSkillId(Integer skillId) {
		this.skillId = skillId;
	}
	@Column(name = "skillName")
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	@Column(name = "version")
	public String getVersion() {
		return version;
	}
	
	public void setVersion(String version) {
		this.version = version;
	}
	@Column(name = "expyears")
	public String getExpyears() {
		return expyears;
	}
	
	public void setExpyears(String expyears) {
		this.expyears = expyears;
	}
	@Column(name = "expmonths")
	public String getExpmonths() {
		return expmonths;
	}
	public void setExpmonths(String expmonths) {
		this.expmonths = expmonths;
	}
	@ManyToOne
	@JoinColumn(name = "jsid")  
	public JobseekerRegisterDomain getSkill() {
		return skill;
	}
	public void setSkill(JobseekerRegisterDomain skill) {
		this.skill = skill;
	}
	@Column(name = "lastused")
	public String getLastused() {
		return lastused;
	}
	public void setLastused(String lastused) {
		this.lastused = lastused;
	}
	@Transient
	@Column(name = "skilid")
	public String getSkilid() {
		return skilid;
	}
	public void setSkilid(String skilid) {
		this.skilid = skilid;
	}
	@Override
	public String toString() {
		return "JobSeekerSkillsDomain [skillId=" + skillId + ", skillName="
				+ skillName + ", version=" + version + ", expyears=" + expyears
				+ ", expmonths=" + expmonths + ", lastused=" + lastused
				+ ", skilid=" + skilid + "]";
	}
	
	
	
}
