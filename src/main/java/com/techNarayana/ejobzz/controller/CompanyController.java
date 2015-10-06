package com.techNarayana.ejobzz.controller;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techNarayana.ejobzz.controller.controllerHelper.EmployerControllerHelper;
import com.techNarayana.ejobzz.domain.EmployerDomain;
import com.techNarayana.ejobzz.domain.EmployerSubscriptionDomain;
import com.techNarayana.ejobzz.domain.SubscriptionDomain;
import com.techNarayana.ejobzz.dto.EmployerDto;
import com.techNarayana.ejobzz.dto.JobseekerRegisterDTO;
import com.techNarayana.ejobzz.service.CompanyService;
import com.techNarayana.ejobzz.service.JobService;
import com.techNarayana.ejobzz.util.DatabaseCommUtils;



@Controller
public class CompanyController {
	public static Logger logger=Logger.getLogger(CompanyController.class);
	@Autowired
	EmployerControllerHelper companyControllerHelper;

	@Autowired
	JobService jobService;

	@Autowired
	private DatabaseCommUtils databaseCommUtil;

	@Autowired
	CompanyService companyService;

	@RequestMapping(value={"/adminHeader.do"},method={RequestMethod.GET})
	public String adminHeader(Model model,HttpServletRequest request){
		return "adminHeader";
	}

	@RequestMapping(value={"/newEmployer.do"},method={RequestMethod.GET})
	public String registerCompany(Model model,HttpServletRequest request){
		logger.debug("---indide newEmployer.do---");

		model.addAttribute("stateList",databaseCommUtil.getStateList());
		model.addAttribute("industryList",databaseCommUtil.getAllIndustryTypesList());
		model.addAttribute("companyCommand",new EmployerDto());
		model.addAttribute("jobseekerRegisterDTO", new JobseekerRegisterDTO());

		logger.debug("---end newEmployer.do---");

		return "registerCompany";
	}

	@RequestMapping(value={"/createCompany.do"},method={RequestMethod.GET,RequestMethod.POST})
	public String createCompany(@ModelAttribute EmployerDto companyDto,Model model,HttpServletRequest request){

		logger.debug("insiside create company controller");
		EmployerDomain companyDomain=companyControllerHelper.createCompany(companyDto);
		model.addAttribute("msg","Welcome, Your account created");
		model.addAttribute("company", companyDomain);

		return "homeCompany";
	}
	@RequestMapping(value={"/buySubscription.do"},method={RequestMethod.GET,RequestMethod.POST})
	public String buySubscription(Model model,HttpServletRequest request,HttpSession session){
		
		logger.debug("inside buySubscription.do");
		EmployerDomain companyDomain=(EmployerDomain)session.getAttribute("employer");
		//checking if employer already loged in then directly goes to conform page... 
		if(companyDomain != null ){
		

		Integer sid=Integer.parseInt((session.getAttribute("sid")).toString());
		SubscriptionDomain subscriptionDomain=jobService.getSubscription(sid);

		//setting subscription details

		EmployerSubscriptionDomain employerSubscriptionDomain=new EmployerSubscriptionDomain();

		employerSubscriptionDomain.setEmployerDomain(companyDomain);

		//counting expiry date 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Now use today date.
		c.add(Calendar.DATE, subscriptionDomain.getValidityDays()); // Adding days
		String validityDate= sdf.format(c.getTime());
		//expiry date end
		employerSubscriptionDomain.setCreatetsDate(new Timestamp(new java.util.Date().getTime()));		
		employerSubscriptionDomain.setExpiry(validityDate);
		employerSubscriptionDomain.setStatus('A');
		employerSubscriptionDomain.setSid(sid);

				if(subscriptionDomain.getPostingType().equals("Package") && subscriptionDomain.getPremiumQuantity() > 0){
		
		
					employerSubscriptionDomain.setSubscriptionType("Premium");
					employerSubscriptionDomain.setQuantity(subscriptionDomain.getPremiumQuantity());
		
					//for resume access subscription validity...
					EmployerSubscriptionDomain employerSubscriptionDomain1=new EmployerSubscriptionDomain();
					employerSubscriptionDomain1.setCreatetsDate(new Timestamp(new java.util.Date().getTime()));		
					employerSubscriptionDomain1.setExpiry(validityDate);
					employerSubscriptionDomain1.setStatus('A');
					employerSubscriptionDomain1.setSid(sid);
					employerSubscriptionDomain1.setSubscriptionType(subscriptionDomain.getPostingType());
					employerSubscriptionDomain1.setQuantity(0);
		
		
					employerSubscriptionDomain1.setEmployerDomain(companyDomain);
					Set<EmployerSubscriptionDomain> es=new HashSet<EmployerSubscriptionDomain>();
					es.add(employerSubscriptionDomain1);
		
					companyService.createCompanySubscription(employerSubscriptionDomain1);
		
		
				}else{
					employerSubscriptionDomain.setSubscriptionType(subscriptionDomain.getPostingType());
					employerSubscriptionDomain.setQuantity(subscriptionDomain.getQuantity());
				}

		employerSubscriptionDomain.setEmployerDomain(companyDomain);
		Set<EmployerSubscriptionDomain> es=new HashSet<EmployerSubscriptionDomain>();
		es.add(employerSubscriptionDomain);

		companyService.createCompanySubscription(employerSubscriptionDomain);
		logger.debug("companySubscription created ");
		//automatically get updated... 
		// connect to payment ...
		// create order table.. and save payment datas...


		//deleting data from session...
		session.setAttribute("sid",null);
		session.setAttribute("amount", null);	
		session.setAttribute("taxAmt", null);	
		session.setAttribute("totalAmt", null);	

		logger.debug("end takeCompanyOrder.do");
			session.setAttribute("employer", companyDomain);
			//setting quick count
			List<EmployerSubscriptionDomain> quickList = companyService.getCompanySubscriptionBasedOnType("Quick",companyDomain.getCompanyKey());
			List<EmployerSubscriptionDomain> premiumList = companyService.getCompanySubscriptionBasedOnType("Premium",companyDomain.getCompanyKey());
			List<EmployerSubscriptionDomain> powerList = companyService.getCompanySubscriptionBasedOnType("Power",companyDomain.getCompanyKey());

			session.setAttribute("quickCount", countSubscription(quickList));
			session.setAttribute("premiumCount", countSubscription(premiumList));
			session.setAttribute("powerCount", countSubscription(powerList));

			model.addAttribute("msg","<b>Thanks for subscription</b>.");

			return "homeCompany";
		}else{
			model.addAttribute("msg","Error.. placing order please login first");
			return "home";
		}
	}	
	@RequestMapping(value={"/takeCompanyOrder.do"},method={RequestMethod.GET,RequestMethod.POST})
	public String takeCompanyOrder(@ModelAttribute EmployerDto employerDto,Model model,HttpServletRequest request,HttpSession session){

		logger.debug("inside takeCompanyOrder.do");

		Integer sid=Integer.parseInt((session.getAttribute("sid")).toString());
		SubscriptionDomain subscriptionDomain=jobService.getSubscription(sid);

		employerDto.setStatus('A');

		//creating employer account...
		EmployerDomain companyDomain=companyControllerHelper.createCompany(employerDto);


		//setting subscription details

		EmployerSubscriptionDomain employerSubscriptionDomain=new EmployerSubscriptionDomain();

		employerSubscriptionDomain.setEmployerDomain(companyDomain);

		//counting expiry date 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Now use today date.
		c.add(Calendar.DATE, subscriptionDomain.getValidityDays()); // Adding days
		String validityDate= sdf.format(c.getTime());
		//expiry date end
		employerSubscriptionDomain.setCreatetsDate(new Timestamp(new java.util.Date().getTime()));		
		employerSubscriptionDomain.setExpiry(validityDate);
		employerSubscriptionDomain.setStatus('A');
		employerSubscriptionDomain.setSid(sid);

		if(subscriptionDomain.getPostingType().equals("Package") && subscriptionDomain.getPremiumQuantity() > 0){


			employerSubscriptionDomain.setSubscriptionType("Premium");
			employerSubscriptionDomain.setQuantity(subscriptionDomain.getPremiumQuantity());

			//for resume access subscription validity...
			EmployerSubscriptionDomain employerSubscriptionDomain1=new EmployerSubscriptionDomain();
			employerSubscriptionDomain1.setCreatetsDate(new Timestamp(new java.util.Date().getTime()));		
			employerSubscriptionDomain1.setExpiry(validityDate);
			employerSubscriptionDomain1.setStatus('A');
			employerSubscriptionDomain1.setSid(sid);
			employerSubscriptionDomain1.setSubscriptionType(subscriptionDomain.getPostingType());
			employerSubscriptionDomain1.setQuantity(0);


			employerSubscriptionDomain1.setEmployerDomain(companyDomain);
			Set<EmployerSubscriptionDomain> es=new HashSet<EmployerSubscriptionDomain>();
			es.add(employerSubscriptionDomain1);

			companyService.createCompanySubscription(employerSubscriptionDomain1);


		}else{
			employerSubscriptionDomain.setSubscriptionType(subscriptionDomain.getPostingType());
			employerSubscriptionDomain.setQuantity(subscriptionDomain.getQuantity());
		}

		employerSubscriptionDomain.setEmployerDomain(companyDomain);
		Set<EmployerSubscriptionDomain> es=new HashSet<EmployerSubscriptionDomain>();
		es.add(employerSubscriptionDomain);

		companyService.createCompanySubscription(employerSubscriptionDomain);
		logger.debug("companySubscription created ");
		//automatically get updated... 
		// connect to payment ...
		// create order table.. and save payment datas...


		//deleting data from session...
		session.setAttribute("sid",null);
		session.setAttribute("amount", null);	
		session.setAttribute("taxAmt", null);	
		session.setAttribute("totalAmt", null);	

		logger.debug("end takeCompanyOrder.do");
		if(companyDomain != null){
			session.setAttribute("employer", companyDomain);
			//setting quick count
			List<EmployerSubscriptionDomain> quickList = companyService.getCompanySubscriptionBasedOnType("Quick",companyDomain.getCompanyKey());
			List<EmployerSubscriptionDomain> premiumList = companyService.getCompanySubscriptionBasedOnType("Premium",companyDomain.getCompanyKey());
			List<EmployerSubscriptionDomain> powerList = companyService.getCompanySubscriptionBasedOnType("Power",companyDomain.getCompanyKey());

			session.setAttribute("quickCount", countSubscription(quickList));
			session.setAttribute("premiumCount", countSubscription(premiumList));
			session.setAttribute("powerCount", countSubscription(powerList));

			model.addAttribute("msg","Welcome, Your account created <br/> <b>Thanks for subscription</b>.");

			return "homeCompany";
		}else{
			model.addAttribute("msg","Error.. creating company");
			return "home";
		}
	}

	// Login company

	@RequestMapping(value={"/loginCompany.do"},method={RequestMethod.GET})
	public String loginCompany(Model model,HttpServletRequest request){
		model.addAttribute("companyCommand",new EmployerDto());
		return "loginCompany";
	}
	//home company
	@RequestMapping(value={"/homeCompany.do"},method={RequestMethod.GET,RequestMethod.POST})
	public String homeCompany(Model model,HttpServletRequest request,HttpSession session){
		
		logger.debug("inside homeCompany.do");
		if(session.getAttribute("employer") == null)
		{
			model.addAttribute("msg", "Please login first");
			return "pleaseLogin";
		}
		
		if(session.getAttribute("orderMsg") != null){
			model.addAttribute("msg", session.getAttribute("orderMsg"));
			session.setAttribute("orderMsg",null);
		}	
		
		
		return "homeCompany";
	}
	@RequestMapping(value={"/orderLogin.do"},method={RequestMethod.GET})
	public String orderLogin(Model model,HttpServletRequest request){
		model.addAttribute("companyCommand",new EmployerDto());
		return "orderLogin";
	}

	@RequestMapping(value={"/authCompany.do"},method={RequestMethod.GET,RequestMethod.POST})
	public void authCompany(Model model,HttpServletRequest request,HttpServletResponse response){
		logger.debug("inside authCompany.do");

		String email=request.getParameter("email"); 
		String password=request.getParameter("password");

		EmployerDto companyDto=new EmployerDto();
		companyDto.setEmail(email);
		companyDto.setPassword(password);
		EmployerDomain companyDomain = companyService.getCompanyBassedOnEmailAndPassword(companyDto);


		String txt="";

		if(companyDomain != null){

			//get today date
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			c.setTime(new Date()); // Now use today date.
			String todayDate = sdf.format(c.getTime());
			Date date2=null;
			try {
				date2 = sdf.parse(todayDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			//setting default todays initial values in company profile table
				//based on last resume accessed date
					try {
						
						Date date1 = sdf.parse(companyDomain.getLastResumeAccessed().toString());
						//checking expiry date
						 if(date1.compareTo(date2)<0){
		
							//updating initial values for resume access..
							 companyDomain.setLastResumeAccessed(date2);
							 companyDomain.setTodayAccessedResumes(0);
							 
							logger.debug("today accessed resume initials setted");
		
						}else{
							logger.debug("you have already logined in today");
						}
						 date1 = sdf.parse(companyDomain.getLastJobPosted().toString());
						 if(date1.compareTo(date2)<0){
								
								//updating initial values for resume access..
								 companyDomain.setLastjobPosted(date2);;
								 companyDomain.setTodayPostedJobs(0);
								 
								logger.debug("today posted initials setted");
			
							}else{
								logger.debug("you have already logined in today");
							}
						 companyDomain=companyService.updateCompany(companyDomain); 	
						 
					} catch (ParseException e) {
						e.printStackTrace();
						logger.debug("ParseException "+e);
					}
					
			
			//end setting default todays initial values
			
			//checking subscription availability 
			List<EmployerSubscriptionDomain> esdList=companyService.getCompanySubscriptionBasedEmployerId(companyDomain.getCompanyKey());

			for (EmployerSubscriptionDomain employerSubscriptionDomain : esdList) {
				String expiryDate = employerSubscriptionDomain.getExpiry();
				try {
					
					Date date1 = sdf.parse(expiryDate);
					//checking expiry date
					 if(date1.compareTo(date2)<0){

						//subscription expired...
						employerSubscriptionDomain.setStatus('D');

						companyService.updateCompanySubscription(employerSubscriptionDomain);

						logger.debug("subscription disabled");

					}else{
						logger.debug("still subscription is there!!!");
					}
					 
				} catch (ParseException e) {
					e.printStackTrace();
					logger.debug("ParseException "+e);
				}

			}

			HttpSession session = request.getSession(true);
			session.setAttribute("employer", companyDomain);

			//setting subscriptions 
			List<EmployerSubscriptionDomain> quickList = companyService.getCompanySubscriptionBasedOnType("Quick",companyDomain.getCompanyKey());
			List<EmployerSubscriptionDomain> premiumList = companyService.getCompanySubscriptionBasedOnType("Premium",companyDomain.getCompanyKey());
			List<EmployerSubscriptionDomain> powerList = companyService.getCompanySubscriptionBasedOnType("Power",companyDomain.getCompanyKey());

			session.setAttribute("quickCount", countSubscription(quickList));
			session.setAttribute("premiumCount", countSubscription(premiumList));
			session.setAttribute("powerCount", countSubscription(powerList));

			txt="0";
		}
		else{
			txt="1";
		}
		response.setContentType("text/html");
		try {
			logger.debug("inside print writer");
			response.getWriter().write(txt);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value={"/employerOrderLogin.do"},method={RequestMethod.GET,RequestMethod.POST})
	public void employerOrderLogin(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		logger.debug("inside employerOrderLogin.do");
		HttpSession session1=request.getSession();
		System.out.println(" session1.getAttribute('sid') : "+session1.getAttribute("sid"));
		String email=request.getParameter("email"); 
		String password=request.getParameter("password");

		EmployerDto employerDto=new EmployerDto();
		employerDto.setEmail(email);
		employerDto.setPassword(password);
		
		EmployerDomain companyDomain = companyService.getCompanyBassedOnEmailAndPassword(employerDto);



		String txt="";

		if(companyDomain != null){
			
			
			//get today date
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			c.setTime(new Date()); // Now use today date.
			String todayDate = sdf.format(c.getTime());
			Date date2=null;
			try {
				date2 = sdf.parse(todayDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			//setting default todays initial values in company profile table
				//based on last resume accessed date
					try {
						
						Date date1 = sdf.parse(companyDomain.getLastResumeAccessed().toString());
						//checking expiry date
						 if(date1.compareTo(date2)<0){
		
							//updating initial values for resume access..
							 companyDomain.setLastResumeAccessed(date2);
							 companyDomain.setTodayAccessedResumes(0);
							 
							logger.debug("today accessed resume initials setted");
		
						}else{
							logger.debug("you have already logined in today");
						}
						 date1 = sdf.parse(companyDomain.getLastJobPosted().toString());
						 if(date1.compareTo(date2)<0){
								
								//updating initial values for resume access..
								 companyDomain.setLastjobPosted(date2);;
								 companyDomain.setTodayPostedJobs(0);
								 
								logger.debug("today posted initials setted");
			
							}else{
								logger.debug("you have already logined in today");
							}
						 companyDomain=companyService.updateCompany(companyDomain); 	
						 
					} catch (ParseException e) {
						e.printStackTrace();
						logger.debug("ParseException "+e);
					}
					
			
			//end setting default todays initial values

			//checking subscription availability 
			List<EmployerSubscriptionDomain> esdList=companyService.getCompanySubscriptionBasedEmployerId(companyDomain.getCompanyKey());
			try {
				date2 = sdf.parse(todayDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			for (EmployerSubscriptionDomain employerSubscriptionDomain : esdList) {
				String expiryDate = employerSubscriptionDomain.getExpiry();
				try {
					Date date1 = sdf.parse(expiryDate);
					//checking expiry date
					if(date1.compareTo(date2)>0){
						logger.debug("still subscription is there!!!");
					}else if(date1.compareTo(date2)<0){

						//subscription expired...
						employerSubscriptionDomain.setStatus('D');

						companyService.updateCompanySubscription(employerSubscriptionDomain);

						logger.debug("subscription disabled");

					}else if(date1.compareTo(date2)==0){
						logger.debug("still subscription is there!!!");
					}else{
						logger.debug("still subscription is there!!!");
					}
				} catch (ParseException e) {
					e.printStackTrace();
					logger.debug("ParseException "+e);
				}

			}
			// creating Subscription.... 

			//updating employer data  based on subscription
			Integer sid=Integer.parseInt((session.getAttribute("sid")).toString());
			SubscriptionDomain subscriptionDomain=jobService.getSubscription(sid);

			//setting subscription details

			EmployerSubscriptionDomain employerSubscriptionDomain=new EmployerSubscriptionDomain();

			employerSubscriptionDomain.setEmployerDomain(companyDomain);

			//counting expiry date 
			sdf = new SimpleDateFormat("yyyy-MM-dd");
			c = Calendar.getInstance();
			c.setTime(new Date()); // Now use today date.
			c.add(Calendar.DATE, subscriptionDomain.getValidityDays()); // Adding days
			String validityDate= sdf.format(c.getTime());

			//expiry date end
			employerSubscriptionDomain.setCreatetsDate(new Timestamp(new java.util.Date().getTime()));		
			employerSubscriptionDomain.setExpiry(validityDate);
			employerSubscriptionDomain.setStatus('A');
			employerSubscriptionDomain.setSid(sid);

			if(subscriptionDomain.getPostingType().equals("Package") && subscriptionDomain.getPremiumQuantity() > 0){


				employerSubscriptionDomain.setSubscriptionType("Premium");
				employerSubscriptionDomain.setQuantity(subscriptionDomain.getPremiumQuantity());

				//for resume access subscription validity...
				EmployerSubscriptionDomain employerSubscriptionDomain1=new EmployerSubscriptionDomain();
				employerSubscriptionDomain1.setCreatetsDate(new Timestamp(new java.util.Date().getTime()));		
				employerSubscriptionDomain1.setExpiry(validityDate);
				employerSubscriptionDomain1.setStatus('A');
				employerSubscriptionDomain1.setSid(sid);
				employerSubscriptionDomain1.setSubscriptionType(subscriptionDomain.getPostingType());
				employerSubscriptionDomain1.setQuantity(0);


				employerSubscriptionDomain1.setEmployerDomain(companyDomain);
				Set<EmployerSubscriptionDomain> es=new HashSet<EmployerSubscriptionDomain>();
				es.add(employerSubscriptionDomain1);

				companyService.createCompanySubscription(employerSubscriptionDomain1);


			}else{
				employerSubscriptionDomain.setSubscriptionType(subscriptionDomain.getPostingType());
				employerSubscriptionDomain.setQuantity(subscriptionDomain.getQuantity());
			}

			employerSubscriptionDomain.setEmployerDomain(companyDomain);
			Set<EmployerSubscriptionDomain> es=new HashSet<EmployerSubscriptionDomain>();
			es.add(employerSubscriptionDomain);

			companyService.createCompanySubscription(employerSubscriptionDomain);
			logger.debug("companySubscription created ");
			//automatically get updated... 
			// connect to payment ...
			// create order table.. and save payment datas...


			//deleting data from session...

			session.setAttribute("sid",null);
			session.setAttribute("amount", null);	
			session.setAttribute("taxAmt", null);	
			session.setAttribute("totalAmt", null);	
			session.setAttribute("orderMsg", "Congratulations your order has been taken.. <br/> thanks");	

			//Set<EmployerSubscriptionDomain> empSubDomainSet=companyDomain.getSubscriptionRecords();

			// end creating Subscription....	



			session.setAttribute("employer", companyDomain);

			//setting subscriptions 
			List<EmployerSubscriptionDomain> quickList = companyService.getCompanySubscriptionBasedOnType("Quick",companyDomain.getCompanyKey());
			List<EmployerSubscriptionDomain> premiumList = companyService.getCompanySubscriptionBasedOnType("Premium",companyDomain.getCompanyKey());
			List<EmployerSubscriptionDomain> powerList = companyService.getCompanySubscriptionBasedOnType("Power",companyDomain.getCompanyKey());

			session.setAttribute("quickCount", countSubscription(quickList));
			session.setAttribute("premiumCount", countSubscription(premiumList));
			session.setAttribute("powerCount", countSubscription(powerList));

			logger.debug("end employerOrderLogin.do");
			
			txt="0";//valid login 
			
		}
		else{
			txt="1"; //invalid login
		}
		response.setContentType("text/html");
		try {
			logger.debug("inside print writer");
			response.getWriter().write(txt);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	@RequestMapping(value = "getDistricts.do",method={RequestMethod.GET,RequestMethod.POST})
	public void getDistricts(Model model,HttpSession session,HttpServletRequest request,HttpServletResponse response) {
		logger.debug("in getDistricts method mapping----");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		String stateName=request.getParameter("stateName");
		List<String> districtsList= databaseCommUtil.getDistrictList(stateName);

		JSONArray jsonArr=new JSONArray();
		JSONObject result = new JSONObject();

		for (String  dist: districtsList) {
			jsonArr.put(dist);
		}

		try {
			result.put("list", jsonArr);
		} catch (JSONException e1) {
			e1.printStackTrace();
		}
		try {
			response.getWriter().write(result.toString());
		} catch (IOException e) {
			try {
				response.getWriter().write("Not Found");
			} catch (IOException e1) {
				e.printStackTrace();
			}

			e.printStackTrace();
		}

	}
	public int countSubscription(List<EmployerSubscriptionDomain> list){
		int count=0;
		for (EmployerSubscriptionDomain employerSubscriptionDomain : list) {
			count += employerSubscriptionDomain.getQuantity();
		}
		return count;
	}

	@RequestMapping(value={"CheckUserEmailExist.do"},method={RequestMethod.GET,RequestMethod.POST})

	public void checkUserEmail(HttpServletRequest request,HttpServletResponse response){
		String email=request.getParameter("email");
		EmployerDomain domain=companyService.forGotpassword(email);

		response.setContentType("text/html");
		try {
			if(domain!=null)
				response.getWriter().print("A");
			else
				response.getWriter().print("D"); 
		} 
		catch (IOException e) {
			e.printStackTrace();
		}


	}

}
