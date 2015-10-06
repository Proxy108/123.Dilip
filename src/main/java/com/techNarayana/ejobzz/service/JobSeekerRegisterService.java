package com.techNarayana.ejobzz.service;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;

import com.techNarayana.ejobzz.domain.JobDomain;
import com.techNarayana.ejobzz.domain.JobSeekerEducationDetailsDomain;
import com.techNarayana.ejobzz.domain.JobSeekerExperienceDomain;
import com.techNarayana.ejobzz.domain.JobseekerRegisterDomain;
import com.techNarayana.ejobzz.dto.EasysearchDTO;
import com.techNarayana.ejobzz.dto.ITSearchDto;
import com.techNarayana.ejobzz.dto.JobSeekerEducationDetailsDTO;
import com.techNarayana.ejobzz.dto.JobSeekerExperienceDTO;
import com.techNarayana.ejobzz.dto.JobseekerRegisterDTO;
import com.techNarayana.ejobzz.dto.RoleSearchDto;
import com.techNarayana.ejobzz.dto.SearchDTO;
import com.techNarayana.ejobzz.exception.DAOException;

public interface JobSeekerRegisterService {

	void createRegister(JobseekerRegisterDomain register) throws ConstraintViolationException;
	 public boolean checkUser(String userName,String password);
	 public boolean checkUserEmail(String userName);
	 public Integer maxId();
	 JobseekerRegisterDomain getJobseekerRegister(int id);
	 JobseekerRegisterDTO updateEducationandExperiencedetails(JobseekerRegisterDTO dto,JobseekerRegisterDomain dt,String jseid,String jeid);
	JobseekerRegisterDTO findUser(String email, String password)throws DAOException;
	public String [] getresumePath(int id);
	JobseekerRegisterDTO updateProfilepic(JobseekerRegisterDTO dto,String filename);
	JobseekerRegisterDTO updateprofileDetails(JobseekerRegisterDTO dto,String []paths);
	JobseekerRegisterDTO updateResume(JobseekerRegisterDTO dto, String fileName1);
	JobseekerRegisterDomain deleteResume(Integer jsid);
	boolean checkUser(String email);
	JobseekerRegisterDomain updateJobskills(JobseekerRegisterDomain dom);
	void deleteSkills(Integer id);
	JobseekerRegisterDomain updateExperienceDetails(JobseekerRegisterDomain dom,
			JobSeekerExperienceDTO expDTO);
	void createNewEmployer(JobseekerRegisterDomain dom,JobseekerRegisterDTO dto);
	void deleteEmployer(Integer id);
	JobSeekerEducationDetailsDomain editEducation(Integer eid);
	void UpdateEducation(JobSeekerEducationDetailsDTO dt,JobseekerRegisterDomain dom);
	void saveEducation(JobSeekerEducationDetailsDTO dto,
			JobseekerRegisterDomain dom);
	void deleteEducation(Integer id);
	void ChangePassword(String encrypt, Integer jsid);
	Boolean CheckUserEdu(String etype,Integer userid);
	List<JobDomain> getJobsBycity(String city);
	List<JobDomain> getJobsByskill(String skill);
	List<JobDomain> GetJobsByDesignation(String design);
	public List<JobseekerRegisterDomain> getJobSeekerBasedOnCriteria(ITSearchDto isdto);
	JobSeekerExperienceDomain getJobseekerRegisterDomain(Integer jsid);
	JobseekerRegisterDomain updateLanguage(JobseekerRegisterDomain dom);
	public JobSeekerExperienceDomain getCandidateCurrentJob(Integer jsid);
	List<JobseekerRegisterDomain> getJobSeekerBasedOnSkillCriteria(
			SearchDTO isdto);
	void deletelanguage(Integer id);
	List<JobseekerRegisterDomain> getJobseekerEasySearch(EasysearchDTO dto);
	List<JobseekerRegisterDomain> getJobSeekerBasedOnRole(RoleSearchDto dto);
	String findUser(String userName);
	JobseekerRegisterDTO getJobseekerDomain(JobseekerRegisterDTO dto);
	JobSeekerExperienceDomain setindustryTypeName(JobSeekerExperienceDomain exp);
}
