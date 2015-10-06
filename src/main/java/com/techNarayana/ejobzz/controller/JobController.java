package com.techNarayana.ejobzz.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techNarayana.ejobzz.controller.controllerHelper.JobSeekerRegisterControllerHelper;
import com.techNarayana.ejobzz.domain.EmployerDomain;
import com.techNarayana.ejobzz.domain.EmployerSubscriptionDomain;
import com.techNarayana.ejobzz.domain.JobApplyDomain;
import com.techNarayana.ejobzz.domain.JobDomain;
import com.techNarayana.ejobzz.domain.JobseekerRegisterDomain;
import com.techNarayana.ejobzz.domain.SubscriptionDomain;
import com.techNarayana.ejobzz.dto.EmployerDto;
import com.techNarayana.ejobzz.dto.JobDto;
import com.techNarayana.ejobzz.dto.JobResponseBean;
import com.techNarayana.ejobzz.dto.JobseekerRegisterDTO;
import com.techNarayana.ejobzz.dto.SubscriptionDTO;
import com.techNarayana.ejobzz.service.CompanyService;
import com.techNarayana.ejobzz.service.JobSeekerRegisterService;
import com.techNarayana.ejobzz.service.JobService;
import com.techNarayana.ejobzz.util.DatabaseCommUtils;
import com.techNarayana.ejobzz.util.EmailAPI;
import com.techNarayana.ejobzz.util.FilePath;

@Controller
public class JobController {
	public static Logger logger=Logger.getLogger(JobController.class);
	@Autowired
	CompanyService companyService;

	@Autowired
	JobService jobService;

	@Autowired
	private DatabaseCommUtils databaseCommUtil;
	@Autowired
	JobSeekerRegisterControllerHelper helper;
	@Autowired
	FilePath filePath;
	@Autowired
	EmailAPI emailApi;
	@Autowired
	JobSeekerRegisterService Service;
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping(value={"/getsubscription.do"},method={RequestMethod.GET,RequestMethod.POST})
	public String getsubscription(Model model,HttpServletRequest request,HttpSession session){

		String sid=request.getParameter("sid");
		System.out.println("sid :" +sid);
		SubscriptionDomain subscriptionDomain=jobService.getSubscription(Integer.parseInt(sid));

		Double amt=subscriptionDomain.getAmount();
		double taxAmt=(amt*14)/100;
		double totalAmt=amt+taxAmt;


		session.setAttribute("sid", sid);
		session.setAttribute("amount", amt);	
		session.setAttribute("taxAmt", taxAmt);	
		session.setAttribute("totalAmt", totalAmt);	
		
		EmployerDomain empDomain=(EmployerDomain)session.getAttribute("employer");
		//checking if employer already loged in then directly goes to conform page... 
		if(empDomain != null ){
			return "confirmOrder";
		}
		
		model.addAttribute("stateList",databaseCommUtil.getStateList());
		model.addAttribute("companyCommand",new EmployerDto());
		model.addAttribute("jobseekerRegisterDTO", new JobseekerRegisterDTO());

		return "getsubscription";
	}

	@RequestMapping(value={"/subscription.do"},method={RequestMethod.GET})
	public String subscription(Model model,HttpServletRequest request,HttpSession session){

		//getting subscriptions based on subscription type
		//quick subscription
		List<SubscriptionDomain> quickSubList=jobService.getSubscription("Quick");

		//Premium subscription
		List<SubscriptionDomain> premiumSubList=jobService.getSubscription("Premium");

		//Power subscription
		List<SubscriptionDomain> powerSubList=jobService.getSubscription("Power");

		//package subscription
		List<SubscriptionDomain> packSubList=jobService.getSubscription("package");

		//coping all the properties into subscriptionDto
		List<SubscriptionDTO> quickSubDtoList=new ArrayList<SubscriptionDTO>();

		List<SubscriptionDTO> premiumSubDtoList=new ArrayList<SubscriptionDTO>();

		List<SubscriptionDTO> powerSubDtoList=new ArrayList<SubscriptionDTO>();

		List<SubscriptionDTO> packSubDtoList=new ArrayList<SubscriptionDTO>();
		//copy data...
		for (SubscriptionDomain subscriptionDomain : quickSubList) {
			SubscriptionDTO subscriptionDTO2=new SubscriptionDTO();
			BeanUtils.copyProperties(subscriptionDomain,subscriptionDTO2);
			quickSubDtoList.add(subscriptionDTO2);
		}

		for (SubscriptionDomain subscriptionDomain : premiumSubList) {
			SubscriptionDTO subscriptionDTO2=new SubscriptionDTO();
			BeanUtils.copyProperties(subscriptionDomain,subscriptionDTO2);
			premiumSubDtoList.add(subscriptionDTO2);
		}

		for (SubscriptionDomain subscriptionDomain : powerSubList) {
			SubscriptionDTO subscriptionDTO2=new SubscriptionDTO();
			BeanUtils.copyProperties(subscriptionDomain,subscriptionDTO2);
			powerSubDtoList.add(subscriptionDTO2);
		}

		for (SubscriptionDomain subscriptionDomain : packSubList) {
			SubscriptionDTO subscriptionDTO2=new SubscriptionDTO();
			BeanUtils.copyProperties(subscriptionDomain,subscriptionDTO2);
			packSubDtoList.add(subscriptionDTO2);
		}

		logger.debug("quickSubList="+quickSubList.size());
		logger.debug("quickSubDtoList="+quickSubDtoList.size());

		model.addAttribute("quickSubDtoList", quickSubDtoList);
		model.addAttribute("premiumSubDtoList", premiumSubDtoList);
		model.addAttribute("powerSubDtoList", powerSubDtoList);
		model.addAttribute("packSubDtoList", packSubDtoList);

		return "subscription";
	}

	@RequestMapping(value={"/postJob.do"},method={RequestMethod.GET,RequestMethod.POST})
	public String postJob(Model model,HttpServletRequest request,HttpSession session,@RequestParam("job")String postingType){
		logger.debug("inside postJob.do");   

		EmployerDomain companyDomain=(EmployerDomain)session.getAttribute("employer");
		if(companyDomain == null){
			logger.debug("employer not loged in redirecting to home page");
			model.addAttribute("location", databaseCommUtil.getAllLocations());
			return "home";

		}

		JobDto jobDto=new JobDto();
		jobDto.setCompanyId(companyDomain.getCompanyKey());
		jobDto.setStatus('A');

		//getting available subscriptions...

		List<EmployerSubscriptionDomain> subList=companyService.getCompanySubscriptionBasedOnType(postingType,companyDomain.getCompanyKey());
		//checking subscription is there or not
		if(subList.size() > 0)
		{
			logger.debug("subscription is left");
			logger.debug("jobpost end");
			model.addAttribute("jobCommand",jobDto);
			model.addAttribute("esid",subList.get(0).getId());
			model.addAttribute("location", databaseCommUtil.getAllLocations());
			model.addAttribute("industryList", databaseCommUtil.getAllIndustryTypesList());
			model.addAttribute("years", helper.getInteger());
			model.addAttribute("months", helper.getMonth());
			return "postJob";

		}else{
			logger.debug("subscription is not left");
			logger.debug("jobpost end");
			//subscription is not left plz take subscription
			model.addAttribute("msg", "Plz buy subscription to post jobs ...");
			return "homeCompany";
		}
	}



	public int countSubscription(List<EmployerSubscriptionDomain> list){
		int count=0;
		for (EmployerSubscriptionDomain employerSubscriptionDomain : list) {
			count += employerSubscriptionDomain.getQuantity();
		}
		return count;
	}

	@RequestMapping(value={"/createJob.do"},method={RequestMethod.GET,RequestMethod.POST})
	public String authCompany(@ModelAttribute JobDto jobDto,Model model,@RequestParam("esid")Integer empSubId,HttpSession session){
		logger.debug("inside createJob.do");


		EmployerDomain companyDomain=(EmployerDomain)session.getAttribute("employer");
		if(companyDomain == null){
			logger.debug("employer not loged in redirecting to home page");
			model.addAttribute("location", databaseCommUtil.getAllLocations());
			return "home";
		}

		EmployerSubscriptionDomain esd=companyService.getCompanySubscriptionBasedOnId(empSubId);

		jobDto.setCreatetsDate(new Timestamp(new java.util.Date().getTime()));
		jobDto.setCompanyId(companyDomain.getCompanyKey());
		jobDto.setStatus('A');

		JobDomain jobDomain=new JobDomain();
		BeanUtils.copyProperties(jobDto, jobDomain);
		jobDomain.setJobType(esd.getSubscriptionType());
		//setting subscription data...
		logger.debug("checking subscription is left");

		if(esd.getQuantity() > 0){

			esd.setQuantity(esd.getQuantity()-1);
			//if quantity became 0 then set status D(disable)

			if(esd.getQuantity() == 0)
				esd.setStatus('D');

			esd.setModifytsDate(new Timestamp(new java.util.Date().getTime()));

			//updating company subscription
			companyService.updateCompanySubscription(esd);

			companyService.createJob(jobDomain);

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			c.setTime(new Date()); // Now use today date.
			String todayDate= sdf.format(c.getTime());

			companyDomain.setTodayPostedJobs(companyDomain.getTodayPostedJobs()+1);
			companyDomain.setTotalPostedJobs(companyDomain.getTotalPostedJobs()+1);
			companyDomain.setLastJobPosted(new Date());
			companyDomain.setModifytsDate(new Timestamp(new java.util.Date().getTime()));
			
			//companyDomain.setLastJobPosted(new Date(todayDate));
			companyService.updateCompany(companyDomain);

			//setting quick count
			List<EmployerSubscriptionDomain> quickList = companyService.getCompanySubscriptionBasedOnType("Quick",companyDomain.getCompanyKey());
			List<EmployerSubscriptionDomain> premiumList = companyService.getCompanySubscriptionBasedOnType("Premium",companyDomain.getCompanyKey());
			List<EmployerSubscriptionDomain> powerList = companyService.getCompanySubscriptionBasedOnType("Power",companyDomain.getCompanyKey());

			session.setAttribute("quickCount", countSubscription(quickList));
			session.setAttribute("premiumCount", countSubscription(premiumList));
			session.setAttribute("powerCount", countSubscription(powerList));

			//job posted successfully
			logger.debug("job posted successfully");
			logger.debug("createJob end");
			model.addAttribute("msg", "Job Psted Successfully...");
			return "homeCompany";
		}else
		{
			List<EmployerSubscriptionDomain> subList=companyService.getCompanySubscriptionBasedOnType(esd.getSubscriptionType(),companyDomain.getCompanyKey());
			//checking subscription is there or not
			if(subList.size() > 0)
			{
				logger.debug("subscription is left");
				EmployerSubscriptionDomain esd1=subList.get(0);
				esd1.setQuantity(esd.getQuantity()-1);

				//if quantity became 0 then set status D(disable)
				if(esd1.getQuantity() == 0)
					esd1.setStatus('D');

				esd1.setModifytsDate(new Timestamp(new java.util.Date().getTime()));
				jobDomain.setJobType(esd1.getSubscriptionType());
				//updating company subscription
				companyService.updateCompanySubscription(esd);

				companyService.createJob(jobDomain);

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Calendar c = Calendar.getInstance();
				c.setTime(new Date()); // Now use today date.
				String todayDate= sdf.format(c.getTime());

				companyDomain.setTodayPostedJobs(companyDomain.getTodayPostedJobs()+1);
				companyDomain.setTotalPostedJobs(companyDomain.getTotalPostedJobs()+1);
				companyDomain.setLastJobPosted(new Date());
				companyDomain.setModifytsDate(new Timestamp(new java.util.Date().getTime()));
				
				//companyDomain.setLastJobPosted(new Date(todayDate));
				companyService.updateCompany(companyDomain);

				//setting quick count
				List<EmployerSubscriptionDomain> quickList = companyService.getCompanySubscriptionBasedOnType("Quick",companyDomain.getCompanyKey());
				List<EmployerSubscriptionDomain> premiumList = companyService.getCompanySubscriptionBasedOnType("Premium",companyDomain.getCompanyKey());
				List<EmployerSubscriptionDomain> powerList = companyService.getCompanySubscriptionBasedOnType("Power",companyDomain.getCompanyKey());

				session.setAttribute("quickCount", countSubscription(quickList));
				session.setAttribute("premiumCount", countSubscription(premiumList));
				session.setAttribute("powerCount", countSubscription(powerList));

				//job posted successfully
				logger.debug("job posted successfully");
				logger.debug("createJob end");
				model.addAttribute("msg", "Job Psted Successfully...");
				return "homeCompany";
			}else{
				model.addAttribute("msg", "Dont have subscription to post this job plz buy subscription.");
				return "homeCompany";
			}	

		}	

	}
	@RequestMapping(value={"/getCompanyJobs.do"},method={RequestMethod.GET,RequestMethod.POST})
	public String getCompanyJobs(Model model,HttpServletRequest request,HttpSession session){

		EmployerDomain companyDomain=(EmployerDomain)session.getAttribute("employer");
		if(companyDomain == null){
			model.addAttribute("location", databaseCommUtil.getAllLocations());
			return "home";
		}
		try{
			Object obj = session.getAttribute("employer");
			EmployerDomain sesCompanyDomain=null;
			if(obj != null){
				sesCompanyDomain = (EmployerDomain)obj;
			} 
			else{
				//returning to company home page

				model.addAttribute("company", null);
				return "homeCompany";
			}
			List<JobDomain> jobDomainList=null;

			jobDomainList=jobService.getJobsBassedOnCompanyId(sesCompanyDomain.getCompanyKey());

			List<JobResponseBean> jobResponseBeanList = new ArrayList<JobResponseBean>();
			for (JobDomain jobDomain : jobDomainList) {

				//creating and coping properties JobResponseBean 
				JobResponseBean jobResponseBean= new JobResponseBean();
				String excludeProperties[]={"companyId"};
				BeanUtils.copyProperties(jobDomain, jobResponseBean,excludeProperties);


				//creating and coping properties Company
				EmployerDto companyDto=new EmployerDto();
				String excludeProperties1[]={"imgPath"};
				BeanUtils.copyProperties(companyDomain, companyDto,excludeProperties1);
				//companyDto.setImgPath(filePath.getCompanyFilePath()+"/"+companyDto.getImgPath());

				jobResponseBean.setCompany(companyDto);
				jobResponseBeanList.add(jobResponseBean);
			}
			model.addAttribute("noOfJobs", jobResponseBeanList.size());
			model.addAttribute("jobsAndCompanyList", jobResponseBeanList);
		}catch(Exception e){
			e.printStackTrace();
		}

		return "companyJobs";
	}
	@RequestMapping(value={"/getAllJobs.do"},method={RequestMethod.GET,RequestMethod.POST})
	public String getAllJobs(Model model,HttpServletRequest request){

		String skills=request.getParameter("skills");
		String location=request.getParameter("location");
		String experience=request.getParameter("experience");
		String salary=request.getParameter("salary");
		logger.debug(location+""+skills+"location+"+experience+"experience"+salary);
		List<JobDomain> jobDomainList=null;
		if(skills != null || location != null || experience != null || salary != null){
			int Exp=0;
			double doubleSalary=0;
			try{
				if(salary != null && !salary.isEmpty() ){
					doubleSalary=Double.parseDouble(salary);
					}else{
						doubleSalary=10;
					}
				if(experience != null && !experience.isEmpty()){
					Exp=Integer.parseInt(experience);
				}else{
					Exp=10;
				}
			}catch(Exception e){logger.debug("exp :");e.printStackTrace();}
			jobDomainList=jobService.getJobsBasedOnCriteria(skills, location, Exp, doubleSalary);
		}
		/*if(skills!=null && !skills.isEmpty()&& location!=null && !location.isEmpty()){
			int Exp=0;
			double doubleSalary=0;
			try{
				if(salary != null && !salary.isEmpty() )
					doubleSalary=Double.parseDouble(salary);
				if(experience != null && !experience.isEmpty())
					Exp=Integer.parseInt(experience);
			}catch(Exception e){logger.debug("exp :");e.printStackTrace();}
		}*/else
			jobDomainList = jobService.getAllJobs();

		List<JobResponseBean> jobResponseBeanList = new ArrayList<JobResponseBean>();
		for (JobDomain jobDomain : jobDomainList) {

			//creating and coping properties JobResponseBean 
			JobResponseBean jobResponseBean= new JobResponseBean();
			String excludeProperties[]={"companyId"};
			BeanUtils.copyProperties(jobDomain, jobResponseBean,excludeProperties);


			//creating and coping properties Company
			EmployerDto companyDto=new EmployerDto();
			EmployerDomain companyDomain = companyService.getCompanyBasedKey(jobDomain.getCompanyId());
			String excludeProperties1[]={"imgPath"};
			BeanUtils.copyProperties(companyDomain, companyDto ,excludeProperties1);
			
			//companyDto.setImgPath(((filePath.getCompanyFilePath()+companyDto.getImgPath()).trim()));
			jobResponseBean.setCompany(companyDto);
			String[]multiplelocation=jobResponseBean.getLocation().split(",");

			String loc="";
			for (int i = 0; i < multiplelocation.length; i++) {

				String str=databaseCommUtil.getLocationById(Integer.parseInt(multiplelocation[i]));
				if(!str.isEmpty() && loc.isEmpty()){
					loc=str;
				}else if(!loc.isEmpty()){
					loc=loc+","+str;
				}
			}
			jobResponseBean.setLocation(loc);
			jobResponseBeanList.add(jobResponseBean);
		}
		model.addAttribute("noOfJobs", jobResponseBeanList.size());
		model.addAttribute("jobsAndCompanyList", jobResponseBeanList);
		model.addAttribute("jobseekerRegisterDTO", new JobseekerRegisterDTO());
		return "searchedJobs";
	}


	@RequestMapping(value={"/jobDetails.do"},method={RequestMethod.GET,RequestMethod.POST})
	public String jobDetails(Model model,HttpServletRequest request,@RequestParam ("jobId") Integer jobId){

		JobDomain jobDomain=jobService.getJobBasedOnKey(jobId);

		//creating and coping properties JobResponseBean 
		JobResponseBean jobResponseBean= new JobResponseBean();
		String excludeProperties[]={"companyId"};
		BeanUtils.copyProperties(jobDomain, jobResponseBean,excludeProperties);

		EmployerDto companyDto=new EmployerDto();
		EmployerDomain companyDomain = companyService.getCompanyBasedKey(jobDomain.getCompanyId());
		//String excludeProperties1[]={"imgPath"};
		BeanUtils.copyProperties(companyDomain, companyDto);
		String companyLogo[]=filePath.getCompanyFilePath().split("/");
		companyDto.setImgPath(companyLogo[companyLogo.length-1]+"/"+companyDto.getImgPath());
		jobResponseBean.setCompany(companyDto);

		String[]multiplelocation=jobResponseBean.getLocation().split(",");

		String loc="";
		for (int i = 0; i < multiplelocation.length; i++) {

			String str=databaseCommUtil.getLocationById(Integer.parseInt(multiplelocation[i]));
			if(!str.isEmpty() && loc.isEmpty()){
				loc=str;
			}else if(!loc.isEmpty()){
				loc=loc+","+str;
			}
		}
		jobResponseBean.setLocation(loc);
		model.addAttribute("job", jobResponseBean);	

		return "jobDetails";
	}
	@RequestMapping(value={"/updateJob.do"},method={RequestMethod.GET,RequestMethod.POST})
	public String updateJob(Model model,HttpServletRequest request,@RequestParam ("jobId") Integer jobId){


		JobDomain jobDomain=jobService.getJobBasedOnKey(jobId);

		//creating and coping properties JobResponseBean 
		JobDto jobDto=new JobDto();
		BeanUtils.copyProperties(jobDomain, jobDto);
		model.addAttribute("jobCommand",jobDto);
		model.addAttribute("location", databaseCommUtil.getAllLocations());
		model.addAttribute("industryList", databaseCommUtil.getAllIndustryTypesList());
		model.addAttribute("years", helper.getInteger());
		model.addAttribute("months", helper.getMonth());

		return "updateJob";
	}
	@RequestMapping(value={"/jobUpdated.do"},method={RequestMethod.GET,RequestMethod.POST})
	public String jobUpdated(@ModelAttribute JobDto jobDto ,Model model,HttpServletRequest request,HttpSession session){

		logger.debug("inside jobupdated");
		EmployerDomain companyDomain=(EmployerDomain)session.getAttribute("employer");
		if(companyDomain == null){
			model.addAttribute("location", databaseCommUtil.getAllLocations());
			return "home";
		}
		//creating and coping properties JobResponseBean 
		JobDomain jobDomain=new JobDomain();
		BeanUtils.copyProperties(jobDto, jobDomain);
		try{
			jobDomain.setModifytsDate(new Timestamp(new java.util.Date().getTime()));
			jobService.updateJob(jobDomain);
			logger.debug("inside jobupdated try block");
		}catch(Exception e){
			e.printStackTrace();
		}
		model.addAttribute("successAlert","Updated...");
		model.addAttribute("jobCommand",jobDto);
		return "homeCompany1";
	}

	@RequestMapping(value={"/jobDeleted.do"},method={RequestMethod.GET,RequestMethod.POST})
	public String jobDeleted(Model model,HttpServletRequest request,@RequestParam ("jobId") Integer jobId,HttpSession session){

		logger.debug("inside deleted");
		EmployerDomain companyDomain=(EmployerDomain)session.getAttribute("employer");
		if(companyDomain == null){
			model.addAttribute("location", databaseCommUtil.getAllLocations());
			return "home";
		}
		//creating and coping properties JobResponseBean 
		JobDomain jobDomain=new JobDomain();
		jobDomain.setjKey(jobId);
		jobService.deleteJob(jobDomain);
		model.addAttribute("successAlert","Job Deleted...");
		return "homeCompany1";
	}


	@RequestMapping(value={"/applyJob.do"},method={RequestMethod.GET,RequestMethod.POST})
	public String applyJob(Model model,HttpServletRequest request,@RequestParam ("jId") Integer jobId,HttpSession session){
		JobseekerRegisterDTO dto=(JobseekerRegisterDTO)session.getAttribute("lUser");
		if(dto!=null){
			logger.debug("IDDDD"+dto.getJsid());
			JobseekerRegisterDomain jobdomain=Service.getJobseekerRegister(dto.getJsid());
			JobDomain jobDomain=jobService.getJobBasedOnKey(jobId);
			EmployerDomain companyDomain=companyService.getCompanyBasedKey(jobDomain.getCompanyId());
			logger.debug("inside deleted");

			JobApplyDomain domain=new JobApplyDomain();
			domain.setjId(jobId);
			domain.setJsId(dto.getJsid());
			domain.setCreates(new java.util.Date());
			jobService.applyJob(domain);


			emailApi.sendHTMLMail(companyDomain.getEmail(), companyDomain.getEmail(), "Jobs applied", "successfully applied jobs",jobdomain);

			model.addAttribute("success", "successfully applied for job");
			return "forward:jobDetails.do?jobId="+jobId;

		}else{
			model.addAttribute("fail", "Sorry this job expired");
			return "forward:jobDetails.do?jobId="+jobId;
		}

	}

	@RequestMapping(value={"/pricing.do"},method={RequestMethod.GET,RequestMethod.POST})
	public String pricing(Model model,HttpServletRequest request){


		return "pricingtable";
	}
}
