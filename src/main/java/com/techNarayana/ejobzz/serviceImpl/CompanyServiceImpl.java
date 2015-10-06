package com.techNarayana.ejobzz.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techNarayana.ejobzz.dao.CompanyDao;
import com.techNarayana.ejobzz.domain.EmployerDomain;
import com.techNarayana.ejobzz.domain.EmployerSubscriptionDomain;
import com.techNarayana.ejobzz.domain.JobDomain;
import com.techNarayana.ejobzz.dto.EmployerDto;
import com.techNarayana.ejobzz.service.CompanyService;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService{
	
	@Autowired
	CompanyDao companyDao;
	
	@Override
	public EmployerDomain createCompany(EmployerDomain company) {
		System.out.println("comapny saved");
		return companyDao.createCompany(company);
		
	}
	public Integer getMaxKeyId(){
		return companyDao.getMaxKeyId();
	}
	@Override
	public EmployerDomain getCompanyBassedOnEmailAndPassword(EmployerDto comapnyDto) {

		return companyDao.getCompanyBassedOnEmailAndPassword(comapnyDto);
	}
	@Override
	public JobDomain createJob(JobDomain domain) {
		return companyDao.createJob(domain);
	}
	@Override
	public EmployerDomain getCompanyBasedKey(Integer key) {
		return companyDao.getCompanyBassedKey(key);
	}
	@Override
	public EmployerDomain updateCompany(EmployerDomain companyDomain){
		return companyDao.updateCompany(companyDomain);
	}
	@Override
	public EmployerSubscriptionDomain createCompanySubscription(EmployerSubscriptionDomain esd) {
		// TODO Auto-generated method stub
		return companyDao.createCompanySubscription(esd);
	}
	@Override
	public List<EmployerSubscriptionDomain> getCompanySubscriptionBasedOnType(String type,Integer employerId) {
		return companyDao.getCompanySubscriptionBasedOnType(type,employerId);
	}
	
	@Override
	public EmployerSubscriptionDomain updateCompanySubscription(EmployerSubscriptionDomain esd){
		return companyDao.updateCompanySubscription(esd);
	}
	@Override
	public EmployerSubscriptionDomain getCompanySubscriptionBasedOnId(Integer id) {
		// TODO Auto-generated method stub
		return companyDao.getCompanySubscriptionBasedOnId(id);
	}
	
	@Override
	public List<EmployerSubscriptionDomain> getCompanySubscriptionBasedEmployerId(Integer employerId) {
		// TODO Auto-generated method stub
		return companyDao.getCompanySubscriptionBasedEmployerId(employerId);
	}
	@Override
	public EmployerDomain ChangePassword(String newPwd, Integer companyKey) {
		// TODO Auto-generated method stub
		return companyDao.ChangePassword(newPwd,companyKey);
	}
	@Override
	public EmployerDomain forGotpassword(String userName) {
		// TODO Auto-generated method stub
		return companyDao.forGotpassword(userName);
	}
}
