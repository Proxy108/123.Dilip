package com.techNarayana.ejobzz.dao;

import java.util.List;

import com.techNarayana.ejobzz.domain.EmployerDomain;
import com.techNarayana.ejobzz.domain.EmployerSubscriptionDomain;
import com.techNarayana.ejobzz.domain.JobDomain;
import com.techNarayana.ejobzz.dto.EmployerDto;

public interface CompanyDao {
	public EmployerDomain createCompany(EmployerDomain domain);
	public Integer getMaxKeyId();
	public EmployerDomain getCompanyBassedOnEmailAndPassword(EmployerDto comapnyDto);
	public JobDomain createJob(JobDomain domain);
	public EmployerDomain getCompanyBassedKey(Integer key);
	public EmployerDomain updateCompany(EmployerDomain companyDomain);
	public EmployerSubscriptionDomain createCompanySubscription(EmployerSubscriptionDomain esd);
	public List<EmployerSubscriptionDomain> getCompanySubscriptionBasedOnType(String type,Integer employerId);
	public EmployerSubscriptionDomain updateCompanySubscription(EmployerSubscriptionDomain esd);
	public EmployerSubscriptionDomain getCompanySubscriptionBasedOnId(Integer id);
	public List<EmployerSubscriptionDomain> getCompanySubscriptionBasedEmployerId(Integer employerId) ;
	public EmployerDomain ChangePassword(String newPwd, Integer companyKey);
	public EmployerDomain forGotpassword(String userName);
	
}
