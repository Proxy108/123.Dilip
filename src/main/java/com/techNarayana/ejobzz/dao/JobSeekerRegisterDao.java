package com.techNarayana.ejobzz.dao;

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

public interface JobSeekerRegisterDao {
	public void createRegister(JobseekerRegisterDomain register) throws ConstraintViolationException;
	
	 public boolean checkUser(String userName,String password );
	 public Integer maxId();

	public JobseekerRegisterDomain getJobseekerRegister(int id);

	public JobseekerRegisterDTO updateEducationandExperiencedetails(JobseekerRegisterDTO dto,JobseekerRegisterDomain dt,String jseid,String jeid);

	public JobseekerRegisterDTO findUser(String email, String password) throws DAOException;

	public String[]  getresumePath(int id);

	public JobseekerRegisterDTO updateProfilepic(JobseekerRegisterDTO dto,String filename);

	public JobseekerRegisterDTO updateprofileDetails(JobseekerRegisterDTO dto,String []paths);

	public JobseekerRegisterDTO updateResume(JobseekerRegisterDTO dto,
			String fileName1);

	public JobseekerRegisterDomain deleteResume(Integer id);

	public boolean checkUser(String userName);

	public JobseekerRegisterDomain updateJobskills(JobseekerRegisterDomain dom);

	public void deleteSkills(Integer id);

	public JobseekerRegisterDomain updateExperienceDetails(JobseekerRegisterDomain dom,
			JobSeekerExperienceDTO expDTO);

	public void createNewEmployer(JobseekerRegisterDomain dom,JobseekerRegisterDTO dto);

	public void deleteEmployer(Integer id);

	public JobSeekerEducationDetailsDomain editEducation(Integer eid);

	public void UpdateEducation(JobSeekerEducationDetailsDTO dt,JobseekerRegisterDomain dom);

	public void saveEducation(JobSeekerEducationDetailsDTO dto,
			JobseekerRegisterDomain dom);

	public void deleteEducation(Integer id);

	public void ChangePassword(String encrypt, Integer jsid);

	public boolean checkUserEmail(String userName);

	public Boolean CheckUserEdu(String etype,Integer userid);

	public List<JobDomain> getJobsBycity(String city);
	public List<JobDomain> getJobsByskill(String Skill);
	public List<JobDomain> GetJobsByDesignation(String design);

	public List<JobseekerRegisterDomain> getJobSeekerBasedOnCriteria(
			ITSearchDto isdto);

	public JobSeekerExperienceDomain getJobseekerRegisterDomain(Integer jsid);

	public JobseekerRegisterDomain updateLanguage(JobseekerRegisterDomain dom);

	public JobSeekerExperienceDomain getCandidateCurrentJob(Integer jsid);

	public List<JobseekerRegisterDomain> getJobSeekerBasedOnSkillCriteria(
			SearchDTO isdto);

	public void deletelanguage(Integer id);

	public List<JobseekerRegisterDomain> getJobseekerEasySearch(EasysearchDTO dto);

	public List<JobseekerRegisterDomain> getJobSeekerBasedOnRole(
			RoleSearchDto dto);

	public String findUser(String userName);

	public JobseekerRegisterDTO getJobseekerDomain(JobseekerRegisterDTO dto);
}
