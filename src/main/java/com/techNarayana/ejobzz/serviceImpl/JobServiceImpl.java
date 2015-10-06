package com.techNarayana.ejobzz.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techNarayana.ejobzz.dao.JobDao;
import com.techNarayana.ejobzz.domain.JobApplyDomain;
import com.techNarayana.ejobzz.domain.JobDomain;
import com.techNarayana.ejobzz.domain.SubscriptionDomain;
import com.techNarayana.ejobzz.service.JobService;
@Service
@Transactional
public class JobServiceImpl implements JobService{
	
	@Autowired
	JobDao jobDao;
	
	@Override
	public List<JobDomain> getAllJobs(){
		return jobDao.getAllJobs();
	}

	@Override
	public JobDomain getJobBasedOnKey(Integer key) {
		
		return jobDao.getJobBasedOnKey(key);
	}

	@Override
	public List<JobDomain> getJobsBasedOnCriteria(String skills,
			String location, int exp, double salary) {
		return jobDao.getJobsBasedOnCriteria(skills, location, exp, salary);
		
	}

	@Override
	public List<JobDomain> getJobsBassedOnCompanyId(Integer id) {
		
		return jobDao.getJobsBassedOnCompanyId(id);
	}

	@Override
	public JobDomain updateJob(JobDomain jobDomain) {
		return jobDao.updateJob(jobDomain);
	}

	@Override
	public JobDomain deleteJob(JobDomain jobDomain) {
		
		return jobDao.deleteJob(jobDomain);
	}

	@Override
	public JobDomain applyJob(JobApplyDomain domain) {
		return jobDao.applyJob(domain);
		
	}

	@Override
	public List<SubscriptionDomain> getSubscription(String postingType) {
		
		return jobDao.getSubscription(postingType);
	}

	
	@Override
	public SubscriptionDomain getSubscription(Integer key) {
		
		return jobDao.getSubscription(key);
	}


}


