package com.techNarayana.ejobzz.util;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techNarayana.ejobzz.domain.JobSeekerUniversity;
import com.techNarayana.ejobzz.domain.JobseekerLocationDomain;
import com.techNarayana.ejobzz.domain.Jobseekerindustry;
import com.techNarayana.ejobzz.domain.StateDomain;
@Repository
@Transactional
public class DatabaseCommUtils {
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@SuppressWarnings("unchecked")
	public List<StateDomain> getStateList(){
		List<StateDomain> state=(List<StateDomain>)sessionFactory.getCurrentSession().createCriteria(StateDomain.class).list();
		return state;
	}
	@SuppressWarnings("unchecked")
	public List<String> getDistrictList(String stateName)
	{
		Query query=sessionFactory.getCurrentSession().createSQLQuery("select id FROM states where name='"+stateName+"'");
		@SuppressWarnings("unchecked")
		List<Integer> rows = query.list();
		List<String> districtsList=null;
		for(Integer id : rows){
			@SuppressWarnings("unused")
			Query query1=sessionFactory.getCurrentSession().createSQLQuery("select name FROM districts where state_id="+id);
			districtsList= query1.list();
		}
		System.out.println(districtsList);
		return districtsList;
	}
	@SuppressWarnings("unchecked")
	public List<String> getDistrictAllList()
	{
		List<String> districtsList=null;
			Query query1=sessionFactory.getCurrentSession().createSQLQuery("select name FROM districts");
			districtsList= query1.list();
		return districtsList;
	}
	@SuppressWarnings("unchecked")
	public List<Jobseekerindustry> getAllIndustryTypesList()
	{
	
		Criteria cr=sessionFactory.getCurrentSession().createCriteria(Jobseekerindustry.class);
		List<Jobseekerindustry> industryList=(ArrayList<Jobseekerindustry>)cr.list();
		Collections.sort(industryList, new Comparator<Jobseekerindustry>() {
		    public int compare(Jobseekerindustry v1, Jobseekerindustry v2) {
		        return v1.getIname().compareTo(v2.getIname());
		    }
		});
		return industryList;
	}
	
@SuppressWarnings("unchecked")
	public  List<JobSeekerUniversity> getAllUniversities()
	{
	
	Criteria cr=sessionFactory.getCurrentSession().createCriteria(JobSeekerUniversity.class);
	List<JobSeekerUniversity> university=(ArrayList<JobSeekerUniversity>)cr.list();
	Collections.sort(university, new Comparator<JobSeekerUniversity>() {
	    public int compare(JobSeekerUniversity v1, JobSeekerUniversity v2) {
	        return v1.getUname().compareTo(v2.getUname());
	    }
	});
		return university;
	}

@SuppressWarnings("unchecked")
public String getUniversityById(Integer Id)
{
	String uname=null;
		Query query1=sessionFactory.getCurrentSession().createSQLQuery("select name FROM jobseeker_university where id="+Id);
		uname= (String) query1.uniqueResult();
	return uname;
}
@SuppressWarnings("unchecked")
public  List<JobseekerLocationDomain> getAllLocations()
{

Criteria cr=sessionFactory.getCurrentSession().createCriteria(JobseekerLocationDomain.class);
List<JobseekerLocationDomain> location=(ArrayList<JobseekerLocationDomain>)cr.list();

Collections.sort(location, new Comparator<JobseekerLocationDomain>() {
    public int compare(JobseekerLocationDomain v1, JobseekerLocationDomain v2) {
        return v1.getLname().compareTo(v2.getLname());
    }
});
	return location;
}

@SuppressWarnings("unchecked")
public String getLocationById(Integer Id)
{
	String uname=null;
		Query query1=sessionFactory.getCurrentSession().createSQLQuery("select lname FROM jobseeker_location where id="+Id);
		uname= (String) query1.uniqueResult();
	return uname;
}
@SuppressWarnings("unchecked")
public String getIndustryById(Integer Id)
{
	String iname=null;
		Query query1=sessionFactory.getCurrentSession().createSQLQuery("select name FROM industry_type where id="+Id);
		iname= (String) query1.uniqueResult();
	return iname;
}
}
