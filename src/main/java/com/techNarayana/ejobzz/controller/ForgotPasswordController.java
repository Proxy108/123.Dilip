package com.techNarayana.ejobzz.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techNarayana.ejobzz.controller.controllerHelper.JobSeekerRegisterControllerHelper;
import com.techNarayana.ejobzz.domain.EmployerDomain;
import com.techNarayana.ejobzz.service.CompanyService;
import com.techNarayana.ejobzz.util.EmailAPI;

@Controller
@Scope("prototype")
public class ForgotPasswordController {
	@Autowired
	JobSeekerRegisterControllerHelper helper;
	@Autowired
	EmailAPI emaiApi;
	@Autowired
	CompanyService companyService;
	@RequestMapping(value="ForgotPassword.do")
	public String ChangePassword(HttpServletRequest request,Model model){

		return "forgotPassword";
	}

	@RequestMapping(value="ForgotPasswordPost.do")
	public String changePasswordPost(HttpServletRequest request){
		String userName=(String)request.getParameter("email");
		String pass=helper.findUser(userName);
		if(pass!=null && !pass.isEmpty()){
			String msgbody="UserName:   "+userName+" <br/> "+"Password: "+pass+"<br/>";
			emaiApi.sendHTMLMail(userName, userName, "Password Request", msgbody);
			request.setAttribute("success","Password Has Sent to "+userName);
			return "forgotPassword";

		}else{
			request.setAttribute("fail"," Sorry Email Not Registered "+userName );
			return "forgotPassword";
		}
	}

	@RequestMapping(value="ForgotCompanyPassword.do")
	public String CompanyChangePassword(HttpServletRequest request,Model model){

		return "forgotCompanyPassword";
	}

	@RequestMapping(value="ForgotCompanyPasswordPost.do")
	public String CompanychangePasswordPost(HttpServletRequest request ){
		String userName=(String)request.getParameter("email");
		EmployerDomain domain=companyService.forGotpassword(userName);
		if(domain!=null){
			String msgbody="UserName:   "+domain.getEmail()+" <br/> "+"Password: "+domain.getPassword()+"<br/>";
			emaiApi.sendHTMLMail(domain.getEmail(), domain.getEmail(), "Password Request", msgbody);
			request.setAttribute("success","Password Has Sent to "+domain.getEmail());
			return "forgotCompanyPassword";
		}else{
			request.setAttribute("fail"," Sorry Email Not Registered "+userName );
			return "forgotCompanyPassword";
		}
	}

}
