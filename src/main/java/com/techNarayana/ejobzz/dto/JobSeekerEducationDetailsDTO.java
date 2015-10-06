package com.techNarayana.ejobzz.dto;



public class JobSeekerEducationDetailsDTO {
	public Integer eid;
	public String ename;
	public String university;
	public Integer graduateYear;
	public String specialization;
	public String courseType;
	public String etype;
	public Integer jsid;
	private JobseekerRegisterDTO edu;
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public Integer getGraduateYear() {
		return graduateYear;
	}
	public void setGraduateYear(Integer graduateYear) {
		this.graduateYear = graduateYear;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public Integer getJsid() {
		return jsid;
	}
	public void setJsid(Integer jsid) {
		this.jsid = jsid;
	}
	
	
	public JobseekerRegisterDTO getEdu() {
		return edu;
	}
	public void setEdu(JobseekerRegisterDTO edu) {
		this.edu = edu;
	}
	public String getEtype() {
		return etype;
	}
	public void setEtype(String etype) {
		this.etype = etype;
	}
	
	public String getCourseType() {
		return courseType;
	}
	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}
	@Override
	public String toString() {
		return "JobSeekerEducationDetailsDTO [eid=" + eid + ", ename=" + ename
				+ ", university=" + university + ", graduateYear=" + graduateYear
				+ ", specialization=" + specialization + ", jsid=" + jsid + "]";
	}
	
	


}
