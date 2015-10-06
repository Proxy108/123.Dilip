package com.techNarayana.ejobzz.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techNarayana.ejobzz.dao.JobDao;
import com.techNarayana.ejobzz.domain.JobApplyDomain;
import com.techNarayana.ejobzz.domain.JobDomain;
import com.techNarayana.ejobzz.domain.SubscriptionDomain;

@Repository
@Transactional
public class JobDaoImpl implements JobDao
{
	@Autowired
	SessionFactory sessionFactory;
	@SuppressWarnings("unchecked")
	
	@Override
	public List<JobDomain> getAllJobs(){
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(JobDomain.class);
				
		return (List<JobDomain>)cr.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<JobDomain> getJobsBasedOnCriteria(String skills,String location,int exp,double salary){
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(JobDomain.class);
		if(skills != null)
		{
			String skillArr[]=skills.split(",");
			for (int i = 0; i < skillArr.length; i++) {
				cr.add(Restrictions.like("keySkills", skillArr[i] , MatchMode.ANYWHERE));
			}
			
		}
		if(location != null){
			cr.add(Restrictions.like("location",location, MatchMode.ANYWHERE));
		}
		if(exp != 0){
			cr.add(Restrictions.between("maxExpYear", 0, exp));
		}
		if(salary != 0){
			cr.add(Restrictions.le("maxSal", salary));	
		}
		return (List<JobDomain>)cr.list();
	}
	
	@Override
	public JobDomain getJobBasedOnKey(Integer key) {
		return (JobDomain)sessionFactory.getCurrentSession().get(JobDomain.class, key);
	}

	@Override
	public List<JobDomain> getJobsBassedOnCompanyId(Integer id) {
		@SuppressWarnings("unchecked")
		List<JobDomain> jobList=(List<JobDomain>)sessionFactory.getCurrentSession().createQuery("from JobDomain jd where companyId= "+ id +" AND status='A'").list();
		return jobList;
	}

	@Override
	public JobDomain updateJob(JobDomain jobDomain) {
		System.out.println("inside dao");
		try{
			System.out.println("inside dao try block");
		sessionFactory.getCurrentSession().update(jobDomain);
		}catch(Exception e){
			e.printStackTrace();
		}
		return jobDomain;
	}

	@Override
	public JobDomain deleteJob(JobDomain jobDomain) {
		jobDomain=(JobDomain)sessionFactory.getCurrentSession().get(JobDomain.class, jobDomain.getjKey());
		sessionFactory.getCurrentSession().delete(jobDomain);
		return jobDomain;
	}

	@Override
	public JobDomain applyJob(JobApplyDomain domain) {
		sessionFactory.getCurrentSession().save(domain);
	return (JobDomain)sessionFactory.getCurrentSession().get(JobDomain.class, domain.getjId());
	}
	
	@Override
	public List<SubscriptionDomain> getSubscription(String postingType) {
		@SuppressWarnings("unchecked")
		List<SubscriptionDomain> subList=(List<SubscriptionDomain>)sessionFactory.getCurrentSession().createQuery("from SubscriptionDomain sd where sd.postingType = '"+ postingType+"'").list();
		return subList;
	}
	
	@Override
	public SubscriptionDomain getSubscription(Integer key) {
	return (SubscriptionDomain)sessionFactory.getCurrentSession().get(SubscriptionDomain.class, key);
	}
}
