package com.techNarayana.ejobzz.service;

import java.util.List;

import com.techNarayana.ejobzz.domain.EmployerDomain;
import com.techNarayana.ejobzz.domain.EmployerSubscriptionDomain;
import com.techNarayana.ejobzz.domain.JobDomain;
import com.techNarayana.ejobzz.dto.EmployerDto;

public interface CompanyService {
	
	public EmployerDomain ChangePassword(String newPwd, Integer companyKey);
	public EmployerDomain forGotpassword(String userName);
	public EmployerDomain createCompany(EmployerDomain domain);
	public JobDomain createJob(JobDomain domain);
	public Integer getMaxKeyId();
	public EmployerDomain getCompanyBassedOnEmailAndPassword(EmployerDto comapnyDto);
	public EmployerDomain getCompanyBasedKey(Integer key);
	public EmployerDomain updateCompany(EmployerDomain companyDomain);
	public EmployerSubscriptionDomain createCompanySubscription(EmployerSubscriptionDomain esd);
	public List<EmployerSubscriptionDomain> getCompanySubscriptionBasedOnType(String type,Integer employerId);
	public EmployerSubscriptionDomain updateCompanySubscription(EmployerSubscriptionDomain esd);
	public EmployerSubscriptionDomain getCompanySubscriptionBasedOnId(Integer id);
	public List<EmployerSubscriptionDomain> getCompanySubscriptionBasedEmployerId(Integer employerId);
	
}
