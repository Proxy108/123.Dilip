package com.techNarayana.ejobzz.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.techNarayana.ejobzz.controller.controllerHelper.JobSeekerRegisterControllerHelper;
import com.techNarayana.ejobzz.domain.JobSeekerExperienceDomain;
import com.techNarayana.ejobzz.dto.JobseekerRegisterDTO;
import com.techNarayana.ejobzz.exception.DAOException;
import com.techNarayana.ejobzz.service.JobSeekerRegisterService;
import com.techNarayana.ejobzz.util.DatabaseCommUtils;

@Controller
public class LoginController {
	@Autowired
	JobSeekerRegisterControllerHelper helper;

	@Autowired
	@Qualifier("loginValidator")
	private Validator validator;
	@Autowired
	DatabaseCommUtils databaseCommUtils;
	@Autowired 
	JobSeekerRegisterService service;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	private Logger logger=Logger.getLogger(LoginController.class);
	@RequestMapping(value={"/Login.do"},method={RequestMethod.GET,RequestMethod.POST})
	public String getLogin(Model model,HttpServletRequest request){

		JobseekerRegisterDTO jobseeker= new JobseekerRegisterDTO();
		model.addAttribute("jobseekerRegisterDTO", jobseeker);
	//	model.addAttribute("location", databaseCommUtils.getAllLocations());
		HttpSession session=request.getSession();
		session.setAttribute("location", databaseCommUtils.getAllLocations());
		return "home";
	}
	@RequestMapping(value={"jobSeekerLogin.do"},method={RequestMethod.GET,RequestMethod.POST})
	public String jobSeekerLogin(Model model,HttpServletRequest request){
		HttpSession session=request.getSession(false);

		if(session != null){

			JobseekerRegisterDTO jobseeker= new JobseekerRegisterDTO();
			model.addAttribute("jobseekerRegisterDTO", jobseeker);
			return "jobseekerLogin";

		}else{
			model.addAttribute("location", databaseCommUtils.getAllLocations());	
		}
		return "home";
	}

	@RequestMapping(value="LoginProcess.do",method={RequestMethod.GET,RequestMethod.POST})
	public String loginProcess(HttpServletRequest request,HttpSession session,Model model){
		JobseekerRegisterDTO dt=(JobseekerRegisterDTO)session.getAttribute("lUser");
		JobSeekerExperienceDomain expdom=helper.getJobseekerRegisterDomain(dt.getJsid());

		model.addAttribute("company", expdom.getCompanyName());
		model.addAttribute("designation", expdom.getDesignation());
		model.addAttribute("sallac", expdom.getCurrentsalLackh());
		model.addAttribute("saltous", expdom.getCurrentsalThousand());
		model.addAttribute("jobseekerRegisterDTO", dt);
		String []paths=helper.resumePath(dt.getJsid());
		if(!paths[1].isEmpty() && paths[1]!=null){
			model.addAttribute("pic","profilepic/"+paths[1]);
		}
		else{
			model.addAttribute("pic","img/images.jpg");
		}

		return "jobseekerLoginPageView";




	}
	public JobseekerRegisterDTO validateLoginuser(JobseekerRegisterDTO jobseeker,Model model,HttpServletRequest request) {
		System.out.println();


		try{

			jobseeker=helper.findUser(jobseeker.getEmail(), jobseeker.getPassword());

			if(jobseeker == null){
				model.addAttribute("invalid", "Invalid User Name/Password, enter valid User Name or Password");

				return jobseeker;
			}

		}catch(DAOException e){
			model.addAttribute("invalid", e.getMessage());
			return jobseeker;
		}
		String []paths=helper.resumePath(jobseeker.getJsid());
		HttpSession session=request.getSession(true);
		session.setAttribute("resume", "resume/"+paths[0]);
		System.out.println(paths[0]+"resume"+paths[1]);

		if(!paths[1].isEmpty() && paths[1]!=null){
			model.addAttribute("pic","profilepic/"+paths[1]);
		}
		else{
			model.addAttribute("pic","img/images.jpg");
		}

		session.setAttribute("lUser", jobseeker);

		return jobseeker;
	}
	@RequestMapping(value = { "/SignOut.do" }, method = RequestMethod.GET)
	public String signLegalOutUser(HttpServletRequest request,Model model,
			HttpServletResponse response) {
		//here we are making session false

		HttpSession session = request.getSession(false);
		logger.debug("Session Object"+session);
		if(session !=null ){
			JobseekerRegisterDTO jobseeker= new JobseekerRegisterDTO();
			model.addAttribute("jobseekerRegisterDTO", jobseeker);
			session.setAttribute("lUser", null);
			session.invalidate();

		}else{
			model.addAttribute("location", databaseCommUtils.getAllLocations());
		}
		return "home";
	}

	@RequestMapping(value={"CheckUserEmail.do"},method={RequestMethod.GET,RequestMethod.POST})

	public void checkUserEmail(HttpServletRequest request,HttpServletResponse response){
		String email=request.getParameter("email");
		Boolean res=helper.checkUserEmail(email);
		
		response.setContentType("text/html");
		try {
			if(res==true)
				response.getWriter().print("D");
			else
				response.getWriter().print("A"); 
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
	
	}

	@RequestMapping(value={"CheckUser.do"},method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public String CheckUser(HttpServletResponse response,HttpServletRequest request){


		String userName=request.getParameter("email");
		String password=request.getParameter("password");



		Boolean res=helper.checkUser(userName,password);
		System.out.println(res+"RESSS");
		return String.valueOf(res);
	}

	@RequestMapping(value={"CheckUserEdu.do"},method={RequestMethod.GET,RequestMethod.POST})

	public void CheckUserEdu(@RequestParam("etype") String etype,@RequestParam("jsid")Integer userid,HttpServletResponse response){
		System.out.println(etype+"etype"+userid+"jsid");
		logger.debug(etype+"etype"+userid+"jsid");
		Boolean res=helper.CheckUserEdu( etype, userid);

		response.setContentType("text/html");
		try {
			System.out.println("inside print writer");
			response.getWriter().write(res.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}


	}





	@RequestMapping(value={"/jobLoginProcess"},method={RequestMethod.GET,RequestMethod.POST})
	public void authCompany(Model model,HttpServletRequest request,HttpServletResponse response){
		System.out.println("inside authCompany.do method...!!! ");
		HttpSession session = request.getSession(false);
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String txt="";
		if(email!=null&& !email.isEmpty() && password!=null && !password.isEmpty()){
			JobseekerRegisterDTO dto=new JobseekerRegisterDTO();
			dto.setEmail(email);
			dto.setPassword(password);

		JobseekerRegisterDTO dt=helper.getJobseekerDomain(dto);
		
		if(dt != null){

			txt="0";
		}
		else{
			txt="1";
		}
		
		if(dt!=null){

			String []paths=helper.resumePath(dt.getJsid());
			session=request.getSession(true);

			session.setAttribute("resume", "resume//"+paths[0]);

			session.setAttribute("lUser", dt);
			JobSeekerExperienceDomain expdom=helper.getJobseekerRegisterDomain(dt.getJsid());

			System.out.println("company"+expdom.companyName);
			model.addAttribute("company", expdom.getCompanyName());
			model.addAttribute("designation", expdom.getDesignation());
			model.addAttribute("sallac", expdom.getCurrentsalLackh());
			model.addAttribute("saltous", expdom.getCurrentsalThousand());
			model.addAttribute("jobseekerRegisterDTO", dt);
			if(!paths[1].isEmpty() && paths[1]!=null){
				model.addAttribute("pic","profilepic/"+paths[1]);
			}
			else{
				model.addAttribute("pic","img/images.jpg");
			}
		}
		
		response.setContentType("text/html");
		try {
			System.out.println("inside print writer");
			response.getWriter().write(txt);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		else{
			txt="1";
			
			response.setContentType("text/html");
			try {
				System.out.println("inside print writer");
				response.getWriter().write(txt);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
