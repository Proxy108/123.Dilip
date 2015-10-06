package com.techNarayana.ejobzz.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techNarayana.ejobzz.controller.controllerHelper.JobSeekerRegisterControllerHelper;
import com.techNarayana.ejobzz.domain.EmployerDomain;
import com.techNarayana.ejobzz.domain.EmployerSubscriptionDomain;
import com.techNarayana.ejobzz.domain.JobSeekerExperienceDomain;
import com.techNarayana.ejobzz.domain.JobseekerRegisterDomain;
import com.techNarayana.ejobzz.dto.CandidateExpResponseBean;
import com.techNarayana.ejobzz.dto.CandidateResponseBean;
import com.techNarayana.ejobzz.dto.EasysearchDTO;
import com.techNarayana.ejobzz.dto.ITSearchDto;
import com.techNarayana.ejobzz.service.CompanyService;
import com.techNarayana.ejobzz.service.JobSeekerRegisterService;
import com.techNarayana.ejobzz.util.DatabaseCommUtils;

@Controller
@Scope(value="prototype")
public class EasySearchcontroller {
	@Autowired 
	JobSeekerRegisterControllerHelper helper;
	public static Logger logger=Logger.getLogger(SearchController.class);
	@Autowired 
	JobSeekerRegisterService service;
	@Autowired 
	DatabaseCommUtils databaseCommUtil;
	@Autowired
	CompanyService companyService;
	@RequestMapping(value="easySearch.do" ,method={RequestMethod.GET,RequestMethod.POST})
	public String viewSearch(Model model){
		
		EasysearchDTO dto=new EasysearchDTO();

		
		model.addAttribute("EasysearchDTO", dto);
		return "EasySearch";
	}
//	easySearchPost
	
	
	@RequestMapping(value="easySearchPost.do" ,method={RequestMethod.GET,RequestMethod.POST})
	public String search(@ModelAttribute EasysearchDTO dto,Model model,HttpSession session){
		EmployerDomain company=(EmployerDomain)session.getAttribute("employer");
		List<JobseekerRegisterDomain> list=service.getJobseekerEasySearch(dto);
		
		Set<JobseekerRegisterDomain> setList=new HashSet<JobseekerRegisterDomain>(list);
		
		
	
		
		Set<CandidateResponseBean> cadidateList=new HashSet<CandidateResponseBean>();
		String excludeProperties[]={"domain","edomain","sdomain","lan"};
	
		CandidateResponseBean candResponseBean=null;
		for (JobseekerRegisterDomain jsrd  : setList) {
			candResponseBean=new CandidateResponseBean();
			BeanUtils.copyProperties(jsrd, candResponseBean,excludeProperties);
			if(candResponseBean.getJobIntrestLocations()!=null && !candResponseBean.getJobIntrestLocations().isEmpty()){
				candResponseBean.setLocation(databaseCommUtil.getLocationById(Integer.parseInt(candResponseBean.getLocation())));
			}
			if(candResponseBean.getJobIntrestLocations()!=null && !candResponseBean.getJobIntrestLocations().isEmpty()){
				String [] mulloc=candResponseBean.getJobIntrestLocations().split(",");
				String loc="";
				for (int i = 0; i < mulloc.length; i++) {

					String str=databaseCommUtil.getLocationById(Integer.parseInt(mulloc[i]));
					if(!str.isEmpty() && loc.isEmpty()){
						loc=str;
					}else if(!loc.isEmpty()){
						loc=loc+","+str;
					}
				}

				candResponseBean.setJobIntrestLocations(loc);
			}
			cadidateList.add(candResponseBean);
		}
		
			
			
			for (CandidateResponseBean cadidate : cadidateList) {
				CandidateExpResponseBean candExpResponseBean=new CandidateExpResponseBean();
				JobSeekerExperienceDomain jobSeekerExperienceDomain=service.getCandidateCurrentJob(cadidate.jsid);
				String excludeProperties1[]={"job"};
				jobSeekerExperienceDomain=service.setindustryTypeName(jobSeekerExperienceDomain);
				BeanUtils.copyProperties(jobSeekerExperienceDomain,candExpResponseBean ,excludeProperties1);
				cadidate.setExp(candExpResponseBean);
				cadidateList.add(cadidate);
			}
			
		model.addAttribute("JobSeekerList",cadidateList);
		//session.setAttribute("JobSeekerList",cadidateList);
		model.addAttribute("noOfJobs",cadidateList.size());
		session.setAttribute("EasysearchDTO", dto);
		model.addAttribute("EasysearchDTO", dto);
		List<EmployerSubscriptionDomain> empSubList= new ArrayList<EmployerSubscriptionDomain>();
		empSubList=companyService.getCompanySubscriptionBasedOnType("Package", company.getCompanyKey());
		if(empSubList.size()>0){
			model.addAttribute("subscribed", "1");
		}
		return "easySearchResumes";
	}
	
	
	@RequestMapping(value="easySearchagain.do" ,method={RequestMethod.GET,RequestMethod.POST})
	public String easySearchagain(Model model,HttpServletRequest request,HttpSession session){
		EmployerDomain company=(EmployerDomain)session.getAttribute("employer");
		//Set<CandidateResponseBean> cadidateList= (HashSet<CandidateResponseBean>)session.getAttribute("JobSeekerList");
		EasysearchDTO dto=(EasysearchDTO)session.getAttribute("EasysearchDTO");
		
		String param1=request.getParameter("KeyofWord");
		String easy=dto.getEasySearch();
		String param=easy.concat(",").concat(param1);
		dto.setEasySearch(param);
List<JobseekerRegisterDomain> list=service.getJobseekerEasySearch(dto);
		
		Set<JobseekerRegisterDomain> setList=new HashSet<JobseekerRegisterDomain>(list);
		
		
	
		
		Set<CandidateResponseBean> cadidateList=new HashSet<CandidateResponseBean>();
		String excludeProperties[]={"domain","edomain","sdomain","lan"};
	
		CandidateResponseBean candResponseBean=null;
		for (JobseekerRegisterDomain jsrd  : setList) {
			candResponseBean=new CandidateResponseBean();
			BeanUtils.copyProperties(jsrd, candResponseBean,excludeProperties);
			/*if(candResponseBean.getJobIntrestLocations()!=null && !candResponseBean.getJobIntrestLocations().isEmpty()){
				candResponseBean.setLocation(databaseCommUtil.getLocationById(Integer.parseInt(candResponseBean.getLocation())));
			}
			if(candResponseBean.getJobIntrestLocations()!=null && !candResponseBean.getJobIntrestLocations().isEmpty()){
				String [] mulloc=candResponseBean.getJobIntrestLocations().split(",");
				String loc="";
				for (int i = 0; i < mulloc.length; i++) {

					String str=databaseCommUtil.getLocationById(Integer.parseInt(mulloc[i]));
					if(!str.isEmpty() && loc.isEmpty()){
						loc=str;
					}else if(!loc.isEmpty()){
						loc=loc+","+str;
					}
				}

				candResponseBean.setJobIntrestLocations(loc);
			}*/
			cadidateList.add(candResponseBean);
		}
		
			
			
			for (CandidateResponseBean cadidate : cadidateList) {
				CandidateExpResponseBean candExpResponseBean=new CandidateExpResponseBean();
				JobSeekerExperienceDomain jobSeekerExperienceDomain=service.getCandidateCurrentJob(cadidate.jsid);
				String excludeProperties1[]={"job"};
				BeanUtils.copyProperties(jobSeekerExperienceDomain,candExpResponseBean ,excludeProperties1);
				cadidate.setExp(candExpResponseBean);
				cadidateList.add(cadidate);
			}
			
		model.addAttribute("JobSeekerList",cadidateList);
		//session.setAttribute("JobSeekerList",cadidateList);
		model.addAttribute("noOfJobs",cadidateList.size());
		session.setAttribute("EasysearchDTO", dto);
		model.addAttribute("EasysearchDTO", dto);
		List<EmployerSubscriptionDomain> empSubList= new ArrayList<EmployerSubscriptionDomain>();
		empSubList=companyService.getCompanySubscriptionBasedOnType("Package", company.getCompanyKey());
		if(empSubList.size()>0){
			model.addAttribute("subscribed", "1");
		}
		return "easySearchResumes";
	}
}
