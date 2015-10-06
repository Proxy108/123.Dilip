package com.techNarayana.ejobzz.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="educationdetails")
public class JobSeekerEducationDetailsDomain {
	public Integer eid;
	public String ename;
	public String university;
	public Integer graduateYear;
	public String specialization;
	public String etype;
	public String courseType;
	private JobseekerRegisterDomain job1;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "eid", unique = true, nullable = false)
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	
	@Column(name = "ename")
	public String getEname() {
		return ename;
	}
	
	public void setEname(String ename) {
		this.ename = ename;
	}
	@Column(name = "university" )
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	
	@Column(name = "graduateYear" )
	
	public Integer getGraduateYear() {
		return graduateYear;
	}
	public void setGraduateYear(Integer graduateYear) {
		this.graduateYear = graduateYear;
	}
	@Column(name = "specialization" )
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	@OneToOne
	@JoinColumn(name = "jsid")
	public JobseekerRegisterDomain getJob1() {
		return job1;
	}
	public void setJob1(JobseekerRegisterDomain job1) {
		this.job1 = job1;
	}
	@Column(name = "courseType" )
	public String getCourseType() {
		return courseType;
	}
	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}
	@Column(name = "etype" )
	public String getEtype() {
		return etype;
	}
	public void setEtype(String etype) {
		this.etype = etype;
	}
	
	
	@Override
	public String toString() {
		return "JobSeekerEducationDetailsDomain [eid=" + eid + ", ename="
				+ ename + ", university=" + university + ", graduateYear="
				+ graduateYear + ", specialization=" + specialization + "]";
	}
	
	
	
	
}
