package com.techNarayana.ejobzz.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techNarayana.ejobzz.controller.controllerHelper.CompanyControllerHelper;
import com.techNarayana.ejobzz.domain.EmployerDomain;

@Controller
@Scope("prototype")
public class CompanypasswordController {
	@Autowired
	CompanyControllerHelper companyhelper;
	
	@RequestMapping(value="ChangeCompanyPassword.do")
	public String ChangePassword(HttpServletRequest request,Model model){
		
		return "ChangeCompanypassword";
	}
	
	
	@RequestMapping(value="ChangeCompanyPasswordPost.do")
	public String changePasswordPost(HttpServletRequest request){
		System.out.println("changing Password");

		EmployerDomain dom=(EmployerDomain)request.getSession().getAttribute("company");
		if(dom== null){

			return "redirect:/Login.do";
		}
	
		String currentPwd=dom.getPassword();
		String currPWd=(String)request.getParameter("currentPassword");
		String newPwd=(String)request.getParameter("newPassword");
		String confPwd=(String)request.getParameter("rePassword");

		if(!currentPwd.equals(currPWd)){
			request.setAttribute("notMatch", "Enter valid Current Password");
			return "ChangeCompanypassword";
		}

		try{
			if(!newPwd.equals(confPwd)){
				request.setAttribute("notMatch", "Passwords do not match");
				return "ChangeCompanypassword";
			}
			companyhelper.ChangePassword(newPwd,dom.getCompanyKey());

			request.setAttribute("successAlert", "password Succfully changed");
			dom.setPassword(newPwd);
			request.getSession().setAttribute("company", dom);
		}catch(Exception e){
			request.setAttribute("fail", "Changing password Failed");
			return "ChangeCompanypassword";
		}
		request.setAttribute("success", "password Succfully changed");
		return "homeCompany1";
	}
}
