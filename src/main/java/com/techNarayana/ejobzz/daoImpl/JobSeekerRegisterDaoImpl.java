package com.techNarayana.ejobzz.daoImpl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techNarayana.ejobzz.dao.JobSeekerRegisterDao;
import com.techNarayana.ejobzz.domain.JobDomain;
import com.techNarayana.ejobzz.domain.JobSeekerEducationDetailsDomain;
import com.techNarayana.ejobzz.domain.JobSeekerExperienceDomain;
import com.techNarayana.ejobzz.domain.JobSeekerLanguageDomain;
import com.techNarayana.ejobzz.domain.JobSeekerSkillsDomain;
import com.techNarayana.ejobzz.domain.JobseekerRegisterDomain;
import com.techNarayana.ejobzz.dto.EasysearchDTO;
import com.techNarayana.ejobzz.dto.ITSearchDto;
import com.techNarayana.ejobzz.dto.JobSeekerEducationDetailsDTO;
import com.techNarayana.ejobzz.dto.JobSeekerExperienceDTO;
import com.techNarayana.ejobzz.dto.JobseekerRegisterDTO;
import com.techNarayana.ejobzz.dto.RoleSearchDto;
import com.techNarayana.ejobzz.dto.SearchDTO;
import com.techNarayana.ejobzz.exception.DAOException;
import com.techNarayana.ejobzz.util.PasswordEncrypit;

@Repository
@Transactional
public class JobSeekerRegisterDaoImpl implements JobSeekerRegisterDao{

	@Autowired
	SessionFactory sessionFactory;
	Logger logger=Logger.getLogger(JobSeekerRegisterDaoImpl.class);
	@Override
	public void createRegister(JobseekerRegisterDomain register) throws ConstraintViolationException {

		register.setUserType("S");
		register.setStatus("A");
		register.setCreates(new java.util.Date());
		register.setModifyts(new java.util.Date());

		sessionFactory.getCurrentSession().save(register);

		JobSeekerExperienceDomain jobSeekerExp=new JobSeekerExperienceDomain();
		jobSeekerExp.setEmployeeType("C");
		jobSeekerExp.setJob(register);

		JobSeekerEducationDetailsDomain jobSeekerEdu=new JobSeekerEducationDetailsDomain();
		jobSeekerEdu.setJob1(register);

		sessionFactory.getCurrentSession().save(jobSeekerExp);
		sessionFactory.getCurrentSession().save(jobSeekerEdu);



	}

	public boolean checkUser(String userName,String password ){
		Query query=sessionFactory.getCurrentSession().createQuery("select count(*) from JobseekerRegisterDomain rt where rt.email=? and rt.password=? ");
		query .setParameter(0, userName);

		query .setParameter(1, password);
		@SuppressWarnings("rawtypes")
		List list=query.list();
		Long cnt=(Long)list.get(0);
		if(cnt != 0)
			return false;
		else
			return true;

	}



	public Integer maxId() {

		return (Integer)sessionFactory.getCurrentSession().createQuery("select MAX(jsid) from JobseekerRegisterDomain sd").list().get(0);
	}

	@Override
	public JobseekerRegisterDomain getJobseekerRegister(int id) {
		JobseekerRegisterDTO dto= new JobseekerRegisterDTO();
		JobseekerRegisterDomain domain=	(JobseekerRegisterDomain)sessionFactory.getCurrentSession().get(JobseekerRegisterDomain.class, id);

		BeanUtils.copyProperties(domain, dto,new String []{"edto","dto","domain","edomain","profilePicPath","resumePath"});
		JobSeekerExperienceDTO expdto=new JobSeekerExperienceDTO();
		List<JobSeekerExperienceDomain> dom=domain.getDomain();
		System.out.println("domain barta ide"+dom.toString());
		/*System.out.println("JOBSEEKEREXPERIENCEDOMAIN");
		Criteria cr=sessionFactory.getCurrentSession().createCriteria(JobSeekerExperienceDomain.class);
		cr.add(Restrictions.eq("job", domain));
		cr.add(Restrictions.eq("employeeType", "C"));
		JobSeekerExperienceDomain dom=(JobSeekerExperienceDomain)cr.list();
		System.out.println("JOBSEEKEREXPERIENCEDOMAIN"+dom.toString());*/



		if(dom!=null){
			BeanUtils.copyProperties(dom, expdto);
			dto.setEdto(expdto);
		}

		JobSeekerEducationDetailsDTO edudto=new JobSeekerEducationDetailsDTO();
		List<JobSeekerEducationDetailsDomain> domedu=domain.getEdomain();
		//System.out.println(domain.getEdomain());
		BeanUtils.copyProperties(domedu, edudto);
		dto.setDto(edudto);


		return domain;
	}
	@Override
	public JobSeekerExperienceDomain getJobseekerRegisterDomain(Integer id) {
		JobseekerRegisterDTO dto= new JobseekerRegisterDTO();
		JobseekerRegisterDomain domain=	(JobseekerRegisterDomain)sessionFactory.getCurrentSession().get(JobseekerRegisterDomain.class, id);

		BeanUtils.copyProperties(domain, dto,new String []{"edto","dto","domain","edomain","profilePicPath","resumePath"});
		JobSeekerExperienceDTO expdto=new JobSeekerExperienceDTO();

		System.out.println("JOBSEEKEREXPERIENCEDOMAIN");
		Criteria cr=sessionFactory.getCurrentSession().createCriteria(JobSeekerExperienceDomain.class);
		cr.add(Restrictions.eq("job", domain));
		cr.add(Restrictions.eq("employeeType", "C"));
		JobSeekerExperienceDomain dom=(JobSeekerExperienceDomain)cr.uniqueResult();

		if(dom!=null){
			BeanUtils.copyProperties(dom, expdto);
			dto.setEdto(expdto);
		}

		JobSeekerEducationDetailsDTO edudto=new JobSeekerEducationDetailsDTO();

		List<JobSeekerEducationDetailsDomain> domedu=domain.getEdomain();
		//System.out.println(domain.getEdomain());
		BeanUtils.copyProperties(domedu, edudto);
		dto.setDto(edudto);


		return dom;
	}

	@Override
	public JobseekerRegisterDTO updateEducationandExperiencedetails(JobseekerRegisterDTO dto,JobseekerRegisterDomain dt,String jseid,String jeid) {
		dt.setModifyts(new java.util.Date());
		sessionFactory.getCurrentSession().update(dt);
		JobseekerRegisterDomain rdom=(JobseekerRegisterDomain)sessionFactory.getCurrentSession().get(JobseekerRegisterDomain.class, dto.getJsid());
		BeanUtils.copyProperties(rdom, dto);

		JobSeekerExperienceDomain jobSeekerExp=(JobSeekerExperienceDomain)sessionFactory.getCurrentSession().get(JobSeekerExperienceDomain.class, Integer.parseInt(jseid));
		JobSeekerExperienceDTO jsedto=dto.getEdto();
		jsedto.setJseid(jobSeekerExp.getJseid());
		BeanUtils.copyProperties(jsedto, jobSeekerExp);



		JobSeekerEducationDetailsDomain edudetails=(JobSeekerEducationDetailsDomain)sessionFactory.getCurrentSession().get(JobSeekerEducationDetailsDomain.class, Integer.parseInt(jeid));
		JobSeekerEducationDetailsDTO edudto=dto.getDto();
		edudto.setEid(edudetails.getEid());
		BeanUtils.copyProperties(edudto, edudetails);
		Set<JobSeekerSkillsDomain>dom=dt.getSdomain();


		sessionFactory.getCurrentSession().update(jobSeekerExp);
		sessionFactory.getCurrentSession().update(edudetails);
		for (JobSeekerSkillsDomain jobSeekerSkillsDomain : dom) {
			jobSeekerSkillsDomain.setSkill(dt);
			sessionFactory.getCurrentSession().saveOrUpdate(jobSeekerSkillsDomain);
		}
		dto.setEdto(jsedto);
		dto.setDto(edudto);



		return dto;	
	}

	@SuppressWarnings("unused")
	@Override
	public JobseekerRegisterDTO findUser(String email, String password) throws DAOException {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JobseekerRegisterDomain.class);
		criteria.add(Restrictions.eq("email", email).ignoreCase());
		//criteria.add(Restrictions.eq("password", password));
		JobseekerRegisterDomain domain=(JobseekerRegisterDomain)criteria.uniqueResult();
		List<JobSeekerEducationDetailsDomain> jedomain=domain.getEdomain();
		List<JobSeekerExperienceDomain> expdomain=domain.getDomain();
		JobseekerRegisterDTO dto=  new JobseekerRegisterDTO();
		if(domain!=null){

			String dbPass=domain.getPassword();
			PasswordEncrypit encrypter = new PasswordEncrypit("");  
			String decrypted = encrypter.decrypt(dbPass);
			if(password.equals(decrypted)){

				JobSeekerEducationDetailsDTO jedto=new JobSeekerEducationDetailsDTO();
				JobSeekerExperienceDTO expDto=new JobSeekerExperienceDTO();
				BeanUtils.copyProperties(domain, dto);
				BeanUtils.copyProperties(jedomain, jedto);

				for (JobSeekerExperienceDomain jobSeekerExperienceDomain : expdomain) {
					BeanUtils.copyProperties(jobSeekerExperienceDomain, expDto);
					dto.setEdto(expDto);
				}
				dto.setDto(jedto);
				return dto;
			}
			else
			{
				throw new DAOException("Please enter valid Password");
			}

		}
		return dto;



	}

	@Override
	public String [] getresumePath(int id) {

		JobseekerRegisterDomain domain=(JobseekerRegisterDomain)sessionFactory.getCurrentSession().get(JobseekerRegisterDomain.class, id);
		String resume=domain.getResumePath();
		String profilepic=domain.getProfilePicPath();
		if(resume==null){
			resume="";
		}
		if(profilepic==null){
			profilepic="";
		}
		String [] path={resume,profilepic};
		return path;
	}

	@Override
	public JobseekerRegisterDTO updateProfilepic(JobseekerRegisterDTO dto,String filename) {
		JobseekerRegisterDomain domain=(JobseekerRegisterDomain)sessionFactory.getCurrentSession().get(JobseekerRegisterDomain.class, dto.getJsid());


		domain.setProfilePicPath(filename);
		domain.setModifyts(new Date());
		sessionFactory.getCurrentSession().update(domain);
		return dto;
	}

	@Override
	public JobseekerRegisterDTO updateprofileDetails(JobseekerRegisterDTO dto,String []paths) {
		JobseekerRegisterDomain domain=new JobseekerRegisterDomain();

		BeanUtils.copyProperties(dto, domain);
		domain.setResumePath(paths[0]);
		domain.setProfilePicPath(paths[1]);
		domain.setModifyts(new Date());
		sessionFactory.getCurrentSession().update(domain);
		JobSeekerExperienceDomain jobSeekerExp=new JobSeekerExperienceDomain();
		JobSeekerExperienceDTO edto=dto.getEdto();
		jobSeekerExp.setJob(domain);
		BeanUtils.copyProperties(edto, jobSeekerExp);
		sessionFactory.getCurrentSession().update(jobSeekerExp);
		JobSeekerEducationDetailsDomain dom=new JobSeekerEducationDetailsDomain();
		dom.setJob1(domain);
		/*JobSeekerEducationDetailsDTO eddto=dto.getDto();
		BeanUtils.copyProperties(eddto, dom);


		sessionFactory.getCurrentSession().update(dom);*/
		return dto;
	}

	@Override
	public JobseekerRegisterDTO updateResume(JobseekerRegisterDTO dto,
			String fileName) {
		JobseekerRegisterDomain domain=(JobseekerRegisterDomain)sessionFactory.getCurrentSession().get(JobseekerRegisterDomain.class, dto.getJsid());
		domain.setResumePath(fileName);
		domain.setModifyts(new Date());

		sessionFactory.getCurrentSession().update(domain);
		return dto;
	}

	@Override
	public JobseekerRegisterDomain deleteResume(Integer id) {
		JobseekerRegisterDomain domain=(JobseekerRegisterDomain)sessionFactory.getCurrentSession().get(JobseekerRegisterDomain.class, id);
		domain.setResumePath("");
		domain.setModifyts(new Date());
		sessionFactory.getCurrentSession().update(domain);
		return domain;

	}

	@Override
	public JobseekerRegisterDomain updateJobskills(JobseekerRegisterDomain dom) {
		Set<JobSeekerSkillsDomain>jobdom=dom.getSdomain();

		for (JobSeekerSkillsDomain jobSeekerSkillsDomain : jobdom) {
			String skillid=jobSeekerSkillsDomain.getSkillId().toString();
			jobSeekerSkillsDomain.setSkill(dom);
			if(skillid.equals("0")){
				sessionFactory.getCurrentSession().save(jobSeekerSkillsDomain);
			}else{
				sessionFactory.getCurrentSession().merge(jobSeekerSkillsDomain);
			}
		}
		return dom;
	}

	@Override
	public void deleteSkills(Integer id) {

		JobSeekerSkillsDomain dom=(JobSeekerSkillsDomain)sessionFactory.getCurrentSession().get(JobSeekerSkillsDomain.class, id);
		if(dom!=null){
			sessionFactory.getCurrentSession().delete(dom);
		}else{}




	}

	@Override
	public JobseekerRegisterDomain updateExperienceDetails(JobseekerRegisterDomain dom,
			JobSeekerExperienceDTO expDTO) {
		JobSeekerExperienceDomain expDom=new JobSeekerExperienceDomain();

		BeanUtils.copyProperties(expDTO, expDom);
		expDom.setJob(dom);
		if(expDom.getEmployeeType().equalsIgnoreCase("c")){
			List<JobSeekerExperienceDomain> domai=dom.getDomain();
			for (JobSeekerExperienceDomain exp : domai) {
				exp.setEmployeeType("P");
				sessionFactory.getCurrentSession().update(exp);
			}
			sessionFactory.getCurrentSession().merge(expDom);
		}else{
			sessionFactory.getCurrentSession().merge(expDom);	
		}

		dom=(JobseekerRegisterDomain)sessionFactory.getCurrentSession().get(JobseekerRegisterDomain.class, dom.getJsid());
		return dom;
	}

	@Override
	public void createNewEmployer(JobseekerRegisterDomain dom,JobseekerRegisterDTO dto) {
		JobSeekerExperienceDomain domain=new JobSeekerExperienceDomain();

		BeanUtils.copyProperties(dto.getEdto(), domain);
		domain.setJob(dom);
		if(domain.getEmployeeType().equalsIgnoreCase("c")){
			List<JobSeekerExperienceDomain> domai=dom.getDomain();
			for (JobSeekerExperienceDomain exp : domai) {
				exp.setEmployeeType("P");
				sessionFactory.getCurrentSession().update(exp);
			}
			sessionFactory.getCurrentSession().save(domain);
		}else{
			sessionFactory.getCurrentSession().save(domain);	
		}


	}

	@Override
	public void deleteEmployer(Integer id) {
		JobSeekerExperienceDomain dom= (JobSeekerExperienceDomain)sessionFactory.getCurrentSession().get(JobSeekerExperienceDomain.class, id);

		sessionFactory.getCurrentSession().delete(dom);
	}

	@Override
	public JobSeekerEducationDetailsDomain editEducation(Integer eid) {
		JobSeekerEducationDetailsDomain dom=(JobSeekerEducationDetailsDomain)sessionFactory.getCurrentSession().get(JobSeekerEducationDetailsDomain.class, eid);
		return  dom;
	}

	@Override
	public void UpdateEducation(JobSeekerEducationDetailsDTO dt,JobseekerRegisterDomain dom) {
		JobSeekerEducationDetailsDomain doma=new JobSeekerEducationDetailsDomain();
		BeanUtils.copyProperties(dt,doma);
		doma.setJob1(dom);
		sessionFactory.getCurrentSession().update(doma);


	}

	@Override
	public void saveEducation(JobSeekerEducationDetailsDTO dto,
			JobseekerRegisterDomain dom) {
		JobSeekerEducationDetailsDomain domain=new JobSeekerEducationDetailsDomain();
		BeanUtils.copyProperties(dto, domain);
		domain.setJob1(dom);
		sessionFactory.getCurrentSession().save(domain);
	}

	@Override
	public void deleteEducation(Integer id) {
		JobSeekerEducationDetailsDomain dom=(JobSeekerEducationDetailsDomain)sessionFactory.getCurrentSession().get(JobSeekerEducationDetailsDomain.class, id);
		if(dom!=null){
			sessionFactory.getCurrentSession().delete(dom);
		}

	}

	@Override
	public void ChangePassword(String encrypt, Integer jsid) {

		JobseekerRegisterDomain dom=(JobseekerRegisterDomain)sessionFactory.getCurrentSession().get(JobseekerRegisterDomain.class, jsid);
		dom.setPassword(encrypt);
		sessionFactory.getCurrentSession().update(dom);
		System.out.println(dom.toString()+"dom.t");
		sessionFactory.getCurrentSession().flush();
	}


	@Override
	public boolean checkUserEmail(String userName) {
		Query query=sessionFactory.getCurrentSession().createQuery("select count(*) from JobseekerRegisterDomain rt where rt.email=? ");
		query .setParameter(0, userName);

		@SuppressWarnings("rawtypes")
		List list=query.list();
		Long cnt=(Long)list.get(0);
		if(cnt != 0){
			System.out.println("false"+cnt);
			return false;
		}
		else{
			System.out.println("TRUE");
			return true;

		}}

	@Override
	public boolean checkUser(String userName) {

		Query query=sessionFactory.getCurrentSession().createQuery("select count(*) from JobseekerRegisterDomain rt where rt.email=? ");
		query .setParameter(0, userName);

		@SuppressWarnings("rawtypes")
		List list=query.list();
		Long cnt=(Long)list.get(0);
		if(cnt != 0){
			System.out.println("false"+cnt);
			return false;
		}
		else{
			System.out.println("TRUE");
			return true;

		}
	}

	@Override
	public Boolean CheckUserEdu(String etype,Integer userid) {

		Query query=sessionFactory.getCurrentSession().createSQLQuery("select count(*) from educationdetails rt where rt.etype=? and rt.jsid=?");
		query .setParameter(0, etype);
		query .setParameter(1, userid);
		@SuppressWarnings("rawtypes")
		List list=query.list();
		Number  cnt=(Number )list.get(0);
		int ct=cnt.intValue();
		if(ct != 0){
			System.out.println("true"+ct);
			return true;
		}
		else{
			System.out.println("false"+ct);
			return false;

		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<JobDomain> getJobsBycity(String city) {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JobDomain.class);
		if(!city.equals("")){
			criteria.add(Restrictions.like("location", city,MatchMode.ANYWHERE));
		}
		List<JobDomain> jobs=criteria.list();
		System.out.println(jobs.size()+"LOCATION");
		return jobs;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<JobDomain> getJobsByskill(String skill) {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JobDomain.class);

		criteria.add(Restrictions.like("keySkills", skill,MatchMode.ANYWHERE));

		List<JobDomain> jobs=criteria.list();
		System.out.println(jobs.size()+"LOCATION");
		return jobs;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<JobDomain> GetJobsByDesignation(String design) {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JobDomain.class);

		criteria.add(Restrictions.like("title", design,MatchMode.ANYWHERE));
		List<JobDomain> jobs=criteria.list();
		System.out.println(jobs.size()+"LOCATION");
		return jobs;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<JobseekerRegisterDomain> getJobSeekerBasedOnCriteria(ITSearchDto isdto){

		System.out.println("isdto = "+isdto);
		// getting candidate from experience table
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JobseekerRegisterDomain.class,"jobgReg");

		criteria.createAlias("jobgReg.domain", "expDomain"); // inner join by default
		criteria.createAlias("jobgReg.edomain", "eduDomain");
		//criteria.add(Restrictions.eq("contact.lastName", "Test"));


		if(isdto.getIndustryType() != null && !isdto.getIndustryType().isEmpty())
		{
			System.out.println("getIndustryType");
			boolean flag=false;
			String indType[]=isdto.getIndustryType().split(",");
			for (int i = 0; i < indType.length; i++) {
				if(!indType[i].equalsIgnoreCase("any"))
					flag=true;


			}
			if(flag){
				for (int i = 0; i < indType.length; i++) {
					criteria.add(Restrictions.like("expDomain.industryType",indType[i] , MatchMode.ANYWHERE));
					System.out.println(indType[i]+"");
				}	
			}
		}

		if(isdto.getCurrentEmployer() != null && !isdto.getCurrentEmployer().isEmpty())
		{	
			System.out.println("getCurrentEmployer");
			String empArr[]=isdto.getCurrentEmployer().split(",");
			for (int i = 0; i < empArr.length; i++) {
				criteria.add(Restrictions.like("expDomain.companyName", empArr[i] , MatchMode.ANYWHERE));
			}
		}
		if(isdto.getExcludeEmployer() != null && !isdto.getExcludeEmployer().isEmpty())
		{	
			System.out.println("getExcludeEmployer");
			String empArr[]=isdto.getExcludeEmployer().split(",");
			for (int i = 0; i < empArr.length; i++) {
				criteria.add(Restrictions.not(Restrictions.like("expDomain.companyName", empArr[i] , MatchMode.ANYWHERE)));
			}
		}

		if(isdto.getDesingnation() != null && !isdto.getDesingnation().isEmpty())
		{
			System.out.println("getDesingnation");
			criteria.add(Restrictions.like("expDomain.designation",isdto.getDesingnation().trim() , MatchMode.EXACT));
		}
		if(isdto.getMinSalLac() != 0 && isdto.getMaxSalLac() != 0 )
		{
			System.out.println("getMinSalLac");
			criteria.add(Restrictions.between("expDomain.currentsalLackh",isdto.getMinSalLac() , isdto.getMaxSalLac()));
		}
		if(isdto.getMinSalThousand() != 0 && isdto.getMaxSalThousand() != 0)
		{
			System.out.println("getMinSalThousand");
			criteria.add(Restrictions.between("expDomain.currentsalThousand",isdto.getMinSalThousand() , isdto.getMaxSalThousand()));
		}

		// end experience table

		// getting candidate from education table


		if(isdto.getUgQualification() != null && !isdto.getUgQualification().isEmpty())
		{
			System.out.println("getUgQualification");
			criteria.add(Restrictions.like("eduDomain.ename",isdto.getUgQualification().trim() , MatchMode.EXACT));
		}
		if(isdto.getInstitute() != null && !isdto.getInstitute().isEmpty())
		{	
			System.out.println("getInstitute");
			criteria.add(Restrictions.like("eduDomain.university",isdto.getInstitute().trim() , MatchMode.EXACT));
		}
		if(isdto.getPassingYearFrom() !=0  && isdto.getPassingYearTo() != 0)
		{	
			System.out.println("getPassingYearFrom and getPassingYearTo" );
			criteria.add(Restrictions.between("eduDomain.graduateYear",isdto.getPassingYearFrom() , isdto.getPassingYearTo()));
		}

		// end candidate from education table

		//getting candidate from jobseeker table

		// active date
		if(isdto.getActiveDays() != null && isdto.getActiveDays() != 0)
		{
			System.out.println("getActiveDays");
			Date date = new Date();
			Calendar cal = Calendar.getInstance();
			Calendar cal1 = Calendar.getInstance();
			//days
			if(isdto.getActiveDays() == 7 || isdto.getActiveDays() == 15){
				cal.add(Calendar.DATE, -isdto.getActiveDays());
				cal.set(Calendar.HOUR_OF_DAY, 0);
				cal.set(Calendar.MINUTE, 0);
				cal.set(Calendar.SECOND, 0);
				//end date
				cal1.add(Calendar.DATE, -isdto.getActiveDays());
				cal1.set(Calendar.HOUR_OF_DAY, 23);
				cal1.set(Calendar.MINUTE, 59);
				cal1.set(Calendar.SECOND, 59);
			}
			else if(isdto.getActiveDays() == 1 || isdto.getActiveDays() == 2 || isdto.getActiveDays() == 3 || isdto.getActiveDays() == 6 || isdto.getActiveDays() == 9 )
			{
				cal.add(Calendar.MONTH, -isdto.getActiveDays());
				cal.set(Calendar.HOUR_OF_DAY, 0);
				cal.set(Calendar.MINUTE, 0);
				cal.set(Calendar.SECOND, 0);

				cal1.add(Calendar.MONTH, -isdto.getActiveDays());
				cal1.set(Calendar.HOUR_OF_DAY, 23);
				cal1.set(Calendar.MINUTE, 59);
				cal1.set(Calendar.SECOND, 59);
			}	
			else{
				cal.add(Calendar.YEAR, -isdto.getActiveDays());
				cal.set(Calendar.HOUR_OF_DAY, 0);
				cal.set(Calendar.MINUTE, 0);
				cal.set(Calendar.SECOND, 0);

				cal1.add(Calendar.YEAR, -isdto.getActiveDays());
				cal1.set(Calendar.HOUR_OF_DAY, 23);
				cal1.set(Calendar.MINUTE, 59);
				cal1.set(Calendar.SECOND, 59);
			}
			Date sDate=cal.getTime();
			Date eDate=cal1.getTime();

			criteria.add(Restrictions.ge("jobgReg.modifyts", sDate));
			criteria.add(Restrictions.ge("jobgReg.modifyts", eDate));
		}	

		if(isdto.getMinExpYear() !=null && isdto.getMinExpYear() != 0 && isdto.getMaxExpYear() != 0 && isdto.getMaxExpYear() !=null){
			System.out.println("getMinExpYear");
			criteria.add(Restrictions.between("jobgReg.totalExp",isdto.getMinExpYear() , isdto.getMaxExpYear()));
		}

		if(isdto.getLocation() != null && !isdto.getLocation().isEmpty()){
			System.out.println("getLocation");
			criteria.add(Restrictions.like("jobgReg.location",isdto.getLocation().trim(),MatchMode.ANYWHERE));
		}

		if(isdto.getPreferedLocation() != null && !isdto.getPreferedLocation().isEmpty()){
			System.out.println("getPreferedLocation");

			String locArr[]=isdto.getPreferedLocation().split(",");
			for (int i = 0; i < locArr.length; i++) {
				criteria.add(Restrictions.like("jobgReg.jobIntrestLocations", locArr[i] , MatchMode.ANYWHERE));

			}
			//criteria.add(Restrictions.like("jobgReg.jobIntrestLocations",isdto.getPreferedLocation()));
		}

		List<JobseekerRegisterDomain> list=criteria.list();
		System.out.println("Get size: "+ list.size());

		return list;
	}

	@Override
	public JobseekerRegisterDomain updateLanguage(JobseekerRegisterDomain dom) {
		List<JobSeekerLanguageDomain>jobdom=dom.getLang();

		for (JobSeekerLanguageDomain jobSeekerLanguageDomain : jobdom) {
			String skillid=jobSeekerLanguageDomain.getJlid().toString();
			System.out.println();
			jobSeekerLanguageDomain.setLanguage(dom);	
			System.out.println("HHHHHHHHHHHHH"+jobSeekerLanguageDomain.toString());
			if(skillid.equals("0")){
				sessionFactory.getCurrentSession().save(jobSeekerLanguageDomain);
			}else{
				sessionFactory.getCurrentSession().merge(jobSeekerLanguageDomain);
			}
		}
		return dom;
	}
	@SuppressWarnings("unchecked")
	@Override
	public JobSeekerExperienceDomain getCandidateCurrentJob(Integer jsid){

		List<JobSeekerExperienceDomain> jobList=(List<JobSeekerExperienceDomain>)sessionFactory.getCurrentSession().createQuery("from JobSeekerExperienceDomain jsd where jsd.job.jsid= "+ jsid +" AND employeeType='C'").list();
		if(jobList.size() > 0)
			return jobList.get(0);
		else
			return new JobSeekerExperienceDomain();

	}
	@Override
	public List<JobseekerRegisterDomain> getJobSeekerBasedOnSkillCriteria(
			SearchDTO isdto) {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JobseekerRegisterDomain.class,"jobgReg");

		criteria.createAlias("jobgReg.domain", "expDomain"); // inner join by default
		criteria.createAlias("jobgReg.edomain", "eduDomain");
		criteria.createAlias("jobgReg.sdomain", "jobskill");



		Disjunction disjunction = Restrictions.disjunction();
		

		if(isdto.getSkill1() != null && !isdto.getSkill1().isEmpty()){
			Criterion skill1 = Restrictions.ilike("jobskill.skillName", isdto.getSkill1(), MatchMode.ANYWHERE);
			Criterion exp1 = null;
			if(isdto.getSkillexp1().equalsIgnoreCase("any")){


				exp1= Restrictions.or(Restrictions.between("jobskill.expyears", "0", "40"),Restrictions.ilike("jobgReg.keySkills", isdto.getSkillexp1(),MatchMode.ANYWHERE));
			}else{
				exp1 = Restrictions.or(Restrictions.ge("jobskill.expyears", isdto.getSkillexp1()),Restrictions.ilike("jobgReg.keySkills", isdto.getSkillexp1(),MatchMode.ANYWHERE));
			}
			Criterion cr1= Restrictions.or(skill1,exp1);
			disjunction.add(cr1);
		}

		if(isdto.getSkill2() != null && !isdto.getSkill2().isEmpty()){
			Criterion skill2 = Restrictions.ilike("jobskill.skillName", isdto.getSkill2(), MatchMode.ANYWHERE);

			Criterion exp2 = null;
			if(isdto.getSkillexp2().equalsIgnoreCase("any")){
				exp2= Restrictions.or(Restrictions.between("jobskill.expyears", "0", "40"),Restrictions.ilike("jobgReg.keySkills", isdto.getSkillexp2(),MatchMode.ANYWHERE));
			}else{
				exp2 = Restrictions.or(Restrictions.ge("jobskill.expyears", isdto.getSkillexp2()),Restrictions.ilike("jobgReg.keySkills", isdto.getSkillexp2(),MatchMode.ANYWHERE));
			}
			Criterion cr2= Restrictions.or(skill2,exp2);
			disjunction.add(cr2);
		}

		if(isdto.getSkill3() != null && !isdto.getSkill3().isEmpty()){
			Criterion skill3 = Restrictions.ilike("jobskill.skillName",isdto.getSkill3(), MatchMode.ANYWHERE);
			Criterion exp3 = null;
			if(isdto.getSkillexp3().equalsIgnoreCase("any")){
				exp3 = Restrictions.or(Restrictions.between("jobskill.expyears", "0", "40"),Restrictions.ilike("jobgReg.keySkills", isdto.getSkillexp3(),MatchMode.ANYWHERE));

			}else{
				exp3 = Restrictions.or(Restrictions.ge("jobskill.expyears", isdto.getSkillexp3()),Restrictions.ilike("jobgReg.keySkills", isdto.getSkillexp3(),MatchMode.ANYWHERE));
			}
			Criterion cr3= Restrictions.or(skill3,exp3); 

			disjunction.add(cr3);
		}
		if(isdto.getSkill4() != null && !isdto.getSkill4().isEmpty()){
			Criterion skill4 = Restrictions.ilike("jobskill.skillName",isdto.getSkill4(), MatchMode.ANYWHERE);
			Criterion exp4 = null;
			if(isdto.getSkillexp4().equalsIgnoreCase("any")){
				exp4= Restrictions.or(Restrictions.between("jobskill.expyears", "0", "40"),Restrictions.ilike("jobgReg.keySkills", isdto.getSkillexp4(),MatchMode.ANYWHERE));
			}else{
				exp4 = Restrictions.or(Restrictions.ge("jobskill.expyears", isdto.getSkillexp4()),Restrictions.ilike("jobgReg.keySkills", isdto.getSkillexp4(),MatchMode.ANYWHERE));
			}
			Criterion cr4= Restrictions.or(skill4,exp4);  
			disjunction.add(cr4);
		}
		if(isdto.getSkill5() != null && !isdto.getSkill5().isEmpty()){
			Criterion skill5 = Restrictions.ilike("jobskill.skillName",isdto.getSkill5(), MatchMode.ANYWHERE);
			Criterion exp5 = null;
			if(isdto.getSkillexp5().equalsIgnoreCase("any")){
				exp5= Restrictions.or(Restrictions.between("jobskill.expyears", "0", "40"),Restrictions.ilike("jobgReg.keySkills", isdto.getSkillexp5(),MatchMode.ANYWHERE));
			}else{
				exp5 = Restrictions.or(Restrictions.ge("jobskill.expyears", isdto.getSkillexp5()),Restrictions.ilike("jobgReg.keySkills", isdto.getSkillexp5(),MatchMode.ANYWHERE));
			}
			Criterion cr5= Restrictions.or(skill5,exp5);  
			disjunction.add(cr5);
		}

		criteria.add(disjunction);


		
		
		if(isdto.getIndustryType() != null && !isdto.getIndustryType().isEmpty())
		{
			System.out.println("getIndustryType");
			boolean flag=false;
			String indType[]=isdto.getIndustryType().split(",");
			for (int i = 0; i < indType.length; i++) {
				if(!indType[i].equalsIgnoreCase("any"))
					flag=true;


			}
			if(flag){
				for (int i = 0; i < indType.length; i++) {
					criteria.add(Restrictions.like("expDomain.industryType",indType[i] , MatchMode.EXACT));
				}	
			}
		}

		if(isdto.getCurrentEmployer() != null && !isdto.getCurrentEmployer().isEmpty())
		{	
			System.out.println("getCurrentEmployer");
			String empArr[]=isdto.getCurrentEmployer().split(",");
			for (int i = 0; i < empArr.length; i++) {
				criteria.add(Restrictions.like("expDomain.companyName", empArr[i] , MatchMode.ANYWHERE));
			}
		}
		if(isdto.getExcludeEmployer() != null && !isdto.getExcludeEmployer().isEmpty())
		{	
			System.out.println("getExcludeEmployer");
			String empArr[]=isdto.getExcludeEmployer().split(",");
			for (int i = 0; i < empArr.length; i++) {
				criteria.add(Restrictions.not(Restrictions.like("expDomain.companyName", empArr[i] , MatchMode.ANYWHERE)));
			}
		}

		if(isdto.getDesingnation() != null && !isdto.getDesingnation().isEmpty())
		{
			System.out.println("getDesingnation");
			criteria.add(Restrictions.like("expDomain.designation",isdto.getDesingnation().trim() , MatchMode.EXACT));
		}
		if(isdto.getMinSalLac() != 0 && isdto.getMaxSalLac() != 0 )
		{
			System.out.println("getMinSalLac");
			criteria.add(Restrictions.between("expDomain.currentsalLackh",isdto.getMinSalLac() , isdto.getMaxSalLac()));
		}
		if(isdto.getMinSalThousand() != 0 && isdto.getMaxSalThousand() != 0)
		{
			System.out.println("getMinSalThousand");
			criteria.add(Restrictions.between("expDomain.currentsalThousand",isdto.getMinSalThousand() , isdto.getMaxSalThousand()));
		}

		// end experience table

		// getting candidate from education table


		if(isdto.getUgQualification() != null && !isdto.getUgQualification().isEmpty())
		{
			System.out.println("getUgQualification");
			criteria.add(Restrictions.like("eduDomain.ename",isdto.getUgQualification().trim() , MatchMode.EXACT));
		}
		if(isdto.getInstitute() != null && !isdto.getInstitute().isEmpty())
		{	
			System.out.println("getInstitute");
			criteria.add(Restrictions.like("eduDomain.university",isdto.getInstitute().trim() , MatchMode.EXACT));
		}
		if(isdto.getPassingYearFrom() !=0  && isdto.getPassingYearTo() != 0)
		{	
			System.out.println("getPassingYearFrom and getPassingYearTo" );
			criteria.add(Restrictions.between("eduDomain.graduateYear",isdto.getPassingYearFrom() , isdto.getPassingYearTo()));
		}

		// end candidate from education table

		//getting candidate from jobseeker table

		// active date
		if(isdto.getActiveDays() != null && isdto.getActiveDays() != 0)
		{
			System.out.println("getActiveDays");
			Date date = new Date();
			Calendar cal = Calendar.getInstance();
			Calendar cal1 = Calendar.getInstance();
			//days
			if(isdto.getActiveDays() == 7 || isdto.getActiveDays() == 15){
				cal.add(Calendar.DATE, -isdto.getActiveDays());
				cal.set(Calendar.HOUR_OF_DAY, 0);
				cal.set(Calendar.MINUTE, 0);
				cal.set(Calendar.SECOND, 0);
				//end date
				cal1.add(Calendar.DATE, -isdto.getActiveDays());
				cal1.set(Calendar.HOUR_OF_DAY, 23);
				cal1.set(Calendar.MINUTE, 59);
				cal1.set(Calendar.SECOND, 59);
			}
			else if(isdto.getActiveDays() == 1 || isdto.getActiveDays() == 2 || isdto.getActiveDays() == 3 || isdto.getActiveDays() == 6 || isdto.getActiveDays() == 9 )
			{
				cal.add(Calendar.MONTH, -isdto.getActiveDays());
				cal.set(Calendar.HOUR_OF_DAY, 0);
				cal.set(Calendar.MINUTE, 0);
				cal.set(Calendar.SECOND, 0);

				cal1.add(Calendar.MONTH, -isdto.getActiveDays());
				cal1.set(Calendar.HOUR_OF_DAY, 23);
				cal1.set(Calendar.MINUTE, 59);
				cal1.set(Calendar.SECOND, 59);
			}	
			else{
				cal.add(Calendar.YEAR, -isdto.getActiveDays());
				cal.set(Calendar.HOUR_OF_DAY, 0);
				cal.set(Calendar.MINUTE, 0);
				cal.set(Calendar.SECOND, 0);

				cal1.add(Calendar.YEAR, -isdto.getActiveDays());
				cal1.set(Calendar.HOUR_OF_DAY, 23);
				cal1.set(Calendar.MINUTE, 59);
				cal1.set(Calendar.SECOND, 59);
			}
			Date sDate=cal.getTime();
			Date eDate=cal1.getTime();

			criteria.add(Restrictions.ge("jobgReg.modifyts", sDate));
			criteria.add(Restrictions.ge("jobgReg.modifyts", eDate));
		}	



		if(isdto.getLocation() != null && !isdto.getLocation().isEmpty()){
			System.out.println("getLocation");
			criteria.add(Restrictions.like("jobgReg.location",isdto.getLocation().trim(),MatchMode.ANYWHERE));
		}

		if(isdto.getPreferedLocation() != null && !isdto.getPreferedLocation().isEmpty()){
			System.out.println("getPreferedLocation");

			String locArr[]=isdto.getPreferedLocation().split(",");
			for (int i = 0; i < locArr.length; i++) {
				criteria.add(Restrictions.like("jobgReg.jobIntrestLocations", locArr[i] , MatchMode.ANYWHERE));

			}
			//criteria.add(Restrictions.like("jobgReg.jobIntrestLocations",isdto.getPreferedLocation()));
		}


		@SuppressWarnings("unchecked")
		List<JobseekerRegisterDomain> list=criteria.list();
		System.out.println("Get size: "+ list.size());

		return list;
	}




	@Override
	public void deletelanguage(Integer id) {


		JobSeekerLanguageDomain dom=(JobSeekerLanguageDomain)sessionFactory.getCurrentSession().get(JobSeekerLanguageDomain.class, id);
		if(dom!=null){
			sessionFactory.getCurrentSession().delete(dom);
		}else{}	
	}

	@Override
	public List<JobseekerRegisterDomain> getJobseekerEasySearch(EasysearchDTO dto) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JobseekerRegisterDomain.class,"jobgReg");

		criteria.createAlias("jobgReg.domain", "expDomain"); // inner join by default
		criteria.createAlias("jobgReg.edomain", "eduDomain");
		criteria.createAlias("jobgReg.sdomain", "jobskill");
		
		String allKeywords[]=dto.getEasySearch().split(",");

		Disjunction disjunction = Restrictions.disjunction();
		for(int i=0;i<allKeywords.length;i++){
			
			if(allKeywords[i] != null && !allKeywords[i].isEmpty())
			{
				
				Criterion cr1=Restrictions.ilike("expDomain.companyName",allKeywords[i].trim() , MatchMode.ANYWHERE);
				logger.debug("COMPANY NAME"+cr1.toString());
				disjunction.add(cr1);
			}

			if(allKeywords[i] != null && !allKeywords[i].isEmpty())
			{
				System.out.println("getUgQualification");
				Criterion cr2=Restrictions.ilike("expDomain.designation",allKeywords[i].trim() , MatchMode.ANYWHERE);
				logger.debug("DESIGNATION"+cr2.toString());
				disjunction.add(cr2);
			}
			if(allKeywords[i] != null && !allKeywords[i].isEmpty())
			{
				Criterion cr3=Restrictions.ilike("jobgReg.location",allKeywords[i].trim() , MatchMode.ANYWHERE);
				logger.debug("location"+cr3.toString());
				disjunction.add(cr3);
			}

			if(allKeywords[i] != null && !allKeywords[i].isEmpty() && allKeywords[i].matches("-?\\d+(\\.\\d+)?"))
			{
				int sal=Integer.parseInt(allKeywords[i]);
				Criterion cr3=Restrictions.le("expDomain.currentsalLackh",sal );
				disjunction.add(cr3);
			}
			if(allKeywords[i] != null && !allKeywords[i].isEmpty() && allKeywords[i].matches("-?\\d+(\\.\\d+)?"))
			{
				double exp=Double.parseDouble(allKeywords[i].trim());
				System.out.println("getUgQualification");
				Criterion cr4=Restrictions.le("jobgReg.totalExp",exp );
				disjunction.add(cr4);
			}

			if(allKeywords[i] != null && !allKeywords[i].isEmpty())
			{
				System.out.println("getUgQualification");
				Criterion cr5=Restrictions.ilike("jobgReg.keySkills",allKeywords[i].trim() , MatchMode.ANYWHERE);
				disjunction.add(cr5);
			}
			criteria.add(disjunction);
		}
		@SuppressWarnings("unchecked")
		List<JobseekerRegisterDomain> list=criteria.list();
		return list;
	}

	@Override
	public List<JobseekerRegisterDomain> getJobSeekerBasedOnRole(RoleSearchDto isdto) {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JobseekerRegisterDomain.class,"jobgReg");

		criteria.createAlias("jobgReg.domain", "expDomain"); // inner join by default
		criteria.createAlias("jobgReg.edomain", "eduDomain");
		//criteria.add(Restrictions.eq("contact.lastName", "Test"));


		if(isdto.getIndustryType() != null && !isdto.getIndustryType().isEmpty())
		{
			System.out.println("getIndustryType");
			boolean flag=false;
			String indType[]=isdto.getIndustryType().split(",");
			for (int i = 0; i < indType.length; i++) {
				if(!indType[i].equalsIgnoreCase("any"))
					flag=true;


			}
			if(flag){
				for (int i = 0; i < indType.length; i++) {
					criteria.add(Restrictions.like("expDomain.industryType",indType[i] , MatchMode.EXACT));
				}	
			}
		}

		if(isdto.getCurrentEmployer() != null && !isdto.getCurrentEmployer().isEmpty())
		{	
			System.out.println("getCurrentEmployer");
			String empArr[]=isdto.getCurrentEmployer().split(",");
			for (int i = 0; i < empArr.length; i++) {
				criteria.add(Restrictions.like("expDomain.companyName", empArr[i] , MatchMode.ANYWHERE));
			}
		}
		if(isdto.getExcludeEmployer() != null && !isdto.getExcludeEmployer().isEmpty())
		{	
			System.out.println("getExcludeEmployer");
			String empArr[]=isdto.getExcludeEmployer().split(",");
			for (int i = 0; i < empArr.length; i++) {
				criteria.add(Restrictions.not(Restrictions.like("expDomain.companyName", empArr[i] , MatchMode.ANYWHERE)));
			}
		}

		if(isdto.getDesingnation() != null && !isdto.getDesingnation().isEmpty())
		{
			System.out.println("getDesingnation");
			criteria.add(Restrictions.like("expDomain.designation",isdto.getDesingnation().trim() , MatchMode.EXACT));
		}
		if(isdto.getMinSalLac() != 0 && isdto.getMaxSalLac() != 0 )
		{
			System.out.println("getMinSalLac");
			criteria.add(Restrictions.between("expDomain.currentsalLackh",isdto.getMinSalLac() , isdto.getMaxSalLac()));
		}
		if(isdto.getMinSalThousand() != 0 && isdto.getMaxSalThousand() != 0)
		{
			System.out.println("getMinSalThousand");
			criteria.add(Restrictions.between("expDomain.currentsalThousand",isdto.getMinSalThousand() , isdto.getMaxSalThousand()));
		}

		// end experience table

		// getting candidate from education table


		if(isdto.getUgQualification() != null && !isdto.getUgQualification().isEmpty())
		{
			System.out.println("getUgQualification");
			criteria.add(Restrictions.like("eduDomain.ename",isdto.getUgQualification().trim() , MatchMode.EXACT));
		}
		if(isdto.getInstitute() != null && !isdto.getInstitute().isEmpty())
		{	
			System.out.println("getInstitute");
			criteria.add(Restrictions.like("eduDomain.university",isdto.getInstitute().trim() , MatchMode.EXACT));
		}
		if(isdto.getPassingYearFrom() !=0  && isdto.getPassingYearTo() != 0)
		{	
			System.out.println("getPassingYearFrom and getPassingYearTo" );
			criteria.add(Restrictions.between("eduDomain.graduateYear",isdto.getPassingYearFrom() , isdto.getPassingYearTo()));
		}

		// end candidate from education table

		//getting candidate from jobseeker table

		// active date
		if(isdto.getActiveDays() != null && isdto.getActiveDays() != 0)
		{
			System.out.println("getActiveDays");
			Date date = new Date();
			Calendar cal = Calendar.getInstance();
			Calendar cal1 = Calendar.getInstance();
			//days
			if(isdto.getActiveDays() == 7 || isdto.getActiveDays() == 15){
				cal.add(Calendar.DATE, -isdto.getActiveDays());
				cal.set(Calendar.HOUR_OF_DAY, 0);
				cal.set(Calendar.MINUTE, 0);
				cal.set(Calendar.SECOND, 0);
				//end date
				cal1.add(Calendar.DATE, -isdto.getActiveDays());
				cal1.set(Calendar.HOUR_OF_DAY, 23);
				cal1.set(Calendar.MINUTE, 59);
				cal1.set(Calendar.SECOND, 59);
			}
			else if(isdto.getActiveDays() == 1 || isdto.getActiveDays() == 2 || isdto.getActiveDays() == 3 || isdto.getActiveDays() == 6 || isdto.getActiveDays() == 9 )
			{
				cal.add(Calendar.MONTH, -isdto.getActiveDays());
				cal.set(Calendar.HOUR_OF_DAY, 0);
				cal.set(Calendar.MINUTE, 0);
				cal.set(Calendar.SECOND, 0);

				cal1.add(Calendar.MONTH, -isdto.getActiveDays());
				cal1.set(Calendar.HOUR_OF_DAY, 23);
				cal1.set(Calendar.MINUTE, 59);
				cal1.set(Calendar.SECOND, 59);
			}	
			else{
				cal.add(Calendar.YEAR, -isdto.getActiveDays());
				cal.set(Calendar.HOUR_OF_DAY, 0);
				cal.set(Calendar.MINUTE, 0);
				cal.set(Calendar.SECOND, 0);

				cal1.add(Calendar.YEAR, -isdto.getActiveDays());
				cal1.set(Calendar.HOUR_OF_DAY, 23);
				cal1.set(Calendar.MINUTE, 59);
				cal1.set(Calendar.SECOND, 59);
			}
			Date sDate=cal.getTime();
			Date eDate=cal1.getTime();

			criteria.add(Restrictions.ge("jobgReg.modifyts", sDate));
			criteria.add(Restrictions.ge("jobgReg.modifyts", eDate));
		}	

		

		if(isdto.getLocation() != null && !isdto.getLocation().isEmpty()){
			System.out.println("getLocation");
			criteria.add(Restrictions.like("jobgReg.location",isdto.getLocation().trim(),MatchMode.ANYWHERE));
		}

		if(isdto.getPreferedLocation() != null && !isdto.getPreferedLocation().isEmpty()){
			System.out.println("getPreferedLocation");

			String locArr[]=isdto.getPreferedLocation().split(",");
			for (int i = 0; i < locArr.length; i++) {
				criteria.add(Restrictions.like("jobgReg.jobIntrestLocations", locArr[i] , MatchMode.ANYWHERE));

			}
			//criteria.add(Restrictions.like("jobgReg.jobIntrestLocations",isdto.getPreferedLocation()));
		}

		@SuppressWarnings("unchecked")
		List<JobseekerRegisterDomain> list=criteria.list();
		System.out.println("Get size: "+ list.size());
		return list;
	}
	@Override
	public String findUser(String email) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JobseekerRegisterDomain.class);
		criteria.add(Restrictions.eq("email", email).ignoreCase());

		JobseekerRegisterDomain dom=(JobseekerRegisterDomain)criteria.uniqueResult();
		if(dom !=null){
			PasswordEncrypit encrypt= new PasswordEncrypit("");
			String pass=encrypt.decrypt(dom.getPassword());

			return pass;
		}else{
			return null;
		}

	}

	@Override
	public JobseekerRegisterDTO getJobseekerDomain(JobseekerRegisterDTO dto) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JobseekerRegisterDomain.class);
		criteria.add(Restrictions.eq("email", dto.getEmail()).ignoreCase());
		JobseekerRegisterDomain dom=(JobseekerRegisterDomain)criteria.uniqueResult();
		PasswordEncrypit encrypt= new PasswordEncrypit("");
		System.out.println(dto.getPassword()+"  Password"+dto.getPassword());
		
		
		if(dto.getPassword().equals(encrypt.decrypt(dom.getPassword()))){
			System.out.println("DDDDDDD");
		BeanUtils.copyProperties(dom, dto,new String[]{"edto","lan","dto","skills"});
		return dto;
		}else{
			return null;
		}
		
		
	}

}
