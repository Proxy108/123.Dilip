package com.techNarayana.ejobzz.serviceImpl;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techNarayana.ejobzz.dao.JobSeekerRegisterDao;
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
import com.techNarayana.ejobzz.service.JobSeekerRegisterService;
import com.techNarayana.ejobzz.util.DatabaseCommUtils;
import com.techNarayana.ejobzz.util.PasswordEncrypit;

@Service
@Transactional
public class JobSeekerRegisterServiceImpl implements JobSeekerRegisterService{
@Autowired
JobSeekerRegisterDao jobSeekerRegisterDao;
@Autowired
DatabaseCommUtils databaseCommUtil;
	@Override
	public void createRegister(JobseekerRegisterDomain register) throws ConstraintViolationException {
		PasswordEncrypit encrpt=new PasswordEncrypit("");
		register.setPassword(encrpt.encrypt(register.getPassword()));
		jobSeekerRegisterDao.createRegister(register);
	}
	@Override
	public boolean checkUser(String userName,String password) {
		System.out.println(userName+" BEFORE Encrypt "+password);
		PasswordEncrypit decrypt= new PasswordEncrypit("");
		password=decrypt.encrypt(password);
		System.out.println(userName+" AFTER Encrypt "+password);
		return jobSeekerRegisterDao.checkUser(userName,password);
	}
	
	@Override
	public Integer maxId() {
		
		return jobSeekerRegisterDao.maxId();
	}
	@Override
	public JobseekerRegisterDomain getJobseekerRegister(int id) {
		
		return jobSeekerRegisterDao.getJobseekerRegister(id);
	}
	@Override
	public JobseekerRegisterDTO updateEducationandExperiencedetails(JobseekerRegisterDTO dto,JobseekerRegisterDomain dt,String jseid,String jeid) {
		
		return jobSeekerRegisterDao.updateEducationandExperiencedetails(dto,dt,jseid,jeid);
	}
	@Override
	public JobseekerRegisterDTO findUser(String email, String password)throws DAOException {
		
		return jobSeekerRegisterDao.findUser(email,password);
	}
	@Override
	public String[]  getresumePath(int id) {
		
		return jobSeekerRegisterDao.getresumePath(id);
	}
	@Override
	public JobseekerRegisterDTO updateProfilepic(JobseekerRegisterDTO dto,String filename) {
		
		return jobSeekerRegisterDao.updateProfilepic(dto,filename);
	}
	@Override
	public JobseekerRegisterDTO updateprofileDetails(JobseekerRegisterDTO dto,String []paths) {
		
		return jobSeekerRegisterDao.updateprofileDetails(dto,paths);
	}
	@Override
	public JobseekerRegisterDTO updateResume(JobseekerRegisterDTO dto,
			String fileName1) {
		
		return jobSeekerRegisterDao.updateResume(dto, fileName1);
	}
	@Override
	public JobseekerRegisterDomain deleteResume(Integer id) {
		
		return jobSeekerRegisterDao.deleteResume(id);
	}
	@Override
	public boolean checkUser(String userName) {
		
		return jobSeekerRegisterDao.checkUser(userName);
	}
	@Override
	public JobseekerRegisterDomain updateJobskills(JobseekerRegisterDomain dom) {
		
		return jobSeekerRegisterDao.updateJobskills(dom);
	}
	@Override
	public void deleteSkills(Integer id
			) {
		
		 jobSeekerRegisterDao.deleteSkills(id);
	}
	@Override
	public JobseekerRegisterDomain updateExperienceDetails(JobseekerRegisterDomain dom,
			JobSeekerExperienceDTO expDTO) {
		return jobSeekerRegisterDao.updateExperienceDetails(dom,expDTO);
		
	}
	@Override
	public void createNewEmployer(JobseekerRegisterDomain dom,JobseekerRegisterDTO dto) {
		jobSeekerRegisterDao.createNewEmployer(dom,dto);
		
	}
	@Override
	public void deleteEmployer(Integer id) {
		jobSeekerRegisterDao.deleteEmployer(id);
		
	}
	@Override
	public JobSeekerEducationDetailsDomain editEducation(Integer eid) {
		
		return jobSeekerRegisterDao.editEducation(eid);
	}
	@Override
	public void UpdateEducation(JobSeekerEducationDetailsDTO dt,JobseekerRegisterDomain dom) {
		jobSeekerRegisterDao.UpdateEducation(dt, dom);
		
	}
	@Override
	public void saveEducation(JobSeekerEducationDetailsDTO dto,
			JobseekerRegisterDomain dom) {
		jobSeekerRegisterDao.saveEducation(dto,dom);
		
	}
	@Override
	public void deleteEducation(Integer id) {
		jobSeekerRegisterDao.deleteEducation(id);
		
	}
	@Override
	public void ChangePassword(String encrypt, Integer jsid) {
		jobSeekerRegisterDao.ChangePassword(encrypt,jsid);
		
	}
	@Override
	public boolean checkUserEmail(String userName) {
		
		return jobSeekerRegisterDao.checkUserEmail(userName);
	}
	@Override
	public Boolean CheckUserEdu(String etype,Integer userid) {
		
		return jobSeekerRegisterDao.CheckUserEdu( etype, userid);
	}
	@Override
	public List<JobDomain> getJobsBycity(String city) {
		return jobSeekerRegisterDao.getJobsBycity(city);
		
	}
	@Override
	public List<JobDomain> getJobsByskill(String skill) {
		return jobSeekerRegisterDao.getJobsByskill(skill);
		
	}
	@Override
	public List<JobDomain> GetJobsByDesignation(String design) {
		return jobSeekerRegisterDao.GetJobsByDesignation(design);
		
	}
	
	@Override
	public List<JobseekerRegisterDomain> getJobSeekerBasedOnCriteria(
			ITSearchDto isdto) {

		return jobSeekerRegisterDao.getJobSeekerBasedOnCriteria(isdto);
	}
	@Override
	public JobSeekerExperienceDomain getJobseekerRegisterDomain(Integer jsid) {
		
		return jobSeekerRegisterDao.getJobseekerRegisterDomain(jsid);
	}
	@Override
	public JobseekerRegisterDomain updateLanguage(JobseekerRegisterDomain dom) {
		
		return jobSeekerRegisterDao.updateLanguage(dom);
	}
	@Override
	public JobSeekerExperienceDomain getCandidateCurrentJob(Integer jsid) {
		return jobSeekerRegisterDao.getCandidateCurrentJob(jsid);
	}
	@Override
	public List<JobseekerRegisterDomain> getJobSeekerBasedOnSkillCriteria(
			SearchDTO isdto) {
		
		return jobSeekerRegisterDao.getJobSeekerBasedOnSkillCriteria(isdto);
	}
	@Override
	public void deletelanguage(Integer id) {
		jobSeekerRegisterDao.deletelanguage(id);
		
	}
	@Override
	public List<JobseekerRegisterDomain> getJobseekerEasySearch(EasysearchDTO dto) {
		
		return jobSeekerRegisterDao.getJobseekerEasySearch(dto);
	}
	@Override
	public List<JobseekerRegisterDomain> getJobSeekerBasedOnRole(
			RoleSearchDto dto) {
		
		return jobSeekerRegisterDao.getJobSeekerBasedOnRole(dto);
	}
	@Override
	public String findUser(String userName) {
		// TODO Auto-generated method stub
		return jobSeekerRegisterDao.findUser(userName);
	}
	@Override
	public JobseekerRegisterDTO getJobseekerDomain(JobseekerRegisterDTO dto) {
		// TODO Auto-generated method stub
		return jobSeekerRegisterDao.getJobseekerDomain(dto);
	}
	@Override
	public JobSeekerExperienceDomain setindustryTypeName(JobSeekerExperienceDomain jobSeekerExperienceDomain) {
		// TODO Auto-generated method stub
		
		if(jobSeekerExperienceDomain.getIndustryType()!=null && !jobSeekerExperienceDomain.getIndustryType().isEmpty()){
			String [] mulind=jobSeekerExperienceDomain.getIndustryType().split(",");
			for (int i = 0; i < mulind.length; i++) {
			String industry=databaseCommUtil.getIndustryById(Integer.parseInt(mulind[i]));
			String loc="";
			if(!industry.isEmpty() && industry.isEmpty()){
				loc=industry;
			}else if(!loc.isEmpty()){
				loc=loc+","+industry;
			}
			jobSeekerExperienceDomain.setIndustryType(loc);
			}
			
		}
		return jobSeekerExperienceDomain;
	}

}
