package com.techNarayana.ejobzz.dao;

import java.util.List;

import com.techNarayana.ejobzz.domain.JobApplyDomain;
import com.techNarayana.ejobzz.domain.JobDomain;
import com.techNarayana.ejobzz.domain.SubscriptionDomain;

public interface JobDao {
	public List<JobDomain> getAllJobs();
	public JobDomain getJobBasedOnKey(Integer key);
	public List<JobDomain> getJobsBasedOnCriteria(String skills,String location,int exp,double salary);
	public List<JobDomain> getJobsBassedOnCompanyId(Integer id);
	public JobDomain updateJob(JobDomain jobDomain);
	public  JobDomain deleteJob(JobDomain jobDomain);
	public JobDomain applyJob(JobApplyDomain domain);
	public List<SubscriptionDomain> getSubscription(String postingType);
	public SubscriptionDomain getSubscription(Integer key) ;
}
