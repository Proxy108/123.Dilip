package com.techNarayana.ejobzz.daoImpl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techNarayana.ejobzz.dao.CompanyDao;
import com.techNarayana.ejobzz.domain.EmployerDomain;
import com.techNarayana.ejobzz.domain.EmployerSubscriptionDomain;
import com.techNarayana.ejobzz.domain.JobDomain;
import com.techNarayana.ejobzz.dto.EmployerDto;

@Repository
@Transactional
public class CompanyDaoImpl implements CompanyDao {

	@Autowired
	public SessionFactory sessionfactory;



	@Override
	public EmployerDomain createCompany(EmployerDomain domain) {
		sessionfactory.getCurrentSession().save(domain);
		return domain;
	}
	@Override
	public Integer getMaxKeyId(){
		@SuppressWarnings("rawtypes")
		List maxId=sessionfactory.getCurrentSession().createQuery("select Max(e.companyKey) FROM EmployerDomain e").list();
		Integer id=null;
		for (@SuppressWarnings("rawtypes")
		Iterator iterator = maxId.iterator(); iterator.hasNext();) {
			id = (Integer) iterator.next();
		}
		return id;
	}
	@Override
	public EmployerDomain getCompanyBassedKey(Integer key) {
		return (EmployerDomain)sessionfactory.getCurrentSession().get(EmployerDomain.class, key);
	}
	@Override
	public EmployerDomain getCompanyBassedOnEmailAndPassword(EmployerDto companyDto) {
		@SuppressWarnings("unchecked")
		List<EmployerDomain> list=sessionfactory.getCurrentSession().createQuery("FROM EmployerDomain company WHERE company.email ='"+companyDto.getEmail()+"' AND company.password='"+companyDto.getPassword()+"'").list();
		EmployerDomain domain=null;

		for (@SuppressWarnings("rawtypes")
		Iterator iterator = list.iterator(); iterator.hasNext();) {
			domain = (EmployerDomain) iterator.next();
		}
		return domain;
	}
	@Override
	public JobDomain createJob(JobDomain domain) {
		sessionfactory.getCurrentSession().save(domain);
		return domain;
	}
	@Override
	public EmployerDomain updateCompany(EmployerDomain companyDomain) {
		sessionfactory.getCurrentSession().update(companyDomain);
		return companyDomain;
	}
	@Override
	public EmployerSubscriptionDomain createCompanySubscription(EmployerSubscriptionDomain esd) {
		sessionfactory.getCurrentSession().save(esd);
		return esd;
	}
	@Override
	public List<EmployerSubscriptionDomain> getCompanySubscriptionBasedOnType(String type,Integer employerId) {
		@SuppressWarnings("unchecked")
		List<EmployerSubscriptionDomain> list=sessionfactory.getCurrentSession().createQuery("FROM EmployerSubscriptionDomain esd WHERE esd.status ='A' AND esd.subscriptionType='"+type+"' AND esd.employerDomain.companyKey="+ employerId).list();
		return list;
	}
	@Override
	public EmployerSubscriptionDomain updateCompanySubscription(EmployerSubscriptionDomain esd){
		sessionfactory.getCurrentSession().update(esd);
		return esd;
	}
	@Override
	public EmployerSubscriptionDomain getCompanySubscriptionBasedOnId(Integer id) {
		
		return (EmployerSubscriptionDomain)sessionfactory.getCurrentSession().get(EmployerSubscriptionDomain.class, id);
	}
	@Override
	public List<EmployerSubscriptionDomain> getCompanySubscriptionBasedEmployerId(Integer employerId) {
		@SuppressWarnings("unchecked")
		List<EmployerSubscriptionDomain> list=sessionfactory.getCurrentSession().createQuery("FROM EmployerSubscriptionDomain esd WHERE esd.status ='A' AND esd.employerDomain.companyKey="+ employerId).list();
		return list;
	}
	@Override
	public EmployerDomain ChangePassword(String newPwd, Integer companyKey) {
		EmployerDomain dom=(EmployerDomain)sessionfactory.getCurrentSession().get(EmployerDomain.class, companyKey);
		dom.setPassword(newPwd);
		sessionfactory.getCurrentSession().update(dom);
		
		sessionfactory.getCurrentSession().flush();
		return dom;
	}
	@Override
	public EmployerDomain forGotpassword(String userName) {
		Criteria cr=sessionfactory.getCurrentSession().createCriteria(EmployerDomain.class);
		cr.add(Restrictions.eq("email", userName));
		EmployerDomain domain=(EmployerDomain)cr.uniqueResult();
		return domain;
	}
}
