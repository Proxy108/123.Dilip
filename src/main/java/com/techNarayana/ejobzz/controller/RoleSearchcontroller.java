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
import com.techNarayana.ejobzz.dto.RoleSearchDto;
import com.techNarayana.ejobzz.service.CompanyService;
import com.techNarayana.ejobzz.service.JobSeekerRegisterService;
import com.techNarayana.ejobzz.util.DatabaseCommUtils;
import com.techNarayana.ejobzz.util.Email;
import com.techNarayana.ejobzz.util.FilePath;

@Controller
@Scope(value="prototype")
public class RoleSearchcontroller {
	@Autowired 
	JobSeekerRegisterControllerHelper helper;
	public static Logger logger=Logger.getLogger(SearchController.class);
	@Autowired 
	JobSeekerRegisterService service;
	@Autowired 
	Email email;
	@Autowired
	FilePath filepath;
	@Autowired
	CompanyService companyService;
	@Autowired
	private DatabaseCommUtils databaseCommUtil;
	@RequestMapping(value="roleSearch.do" ,method={RequestMethod.GET,RequestMethod.POST})
	public String viewSearch(Model model){
		
		RoleSearchDto dto=new RoleSearchDto();

		model.addAttribute("years",helper.getYears());
		model.addAttribute("months",helper.getMonths());
		model.addAttribute("lac",helper.getsalaryInlackhs());
		model.addAttribute("thousand",helper.getsalaryInThousands());
		model.addAttribute("expyears",helper.getInteger());
		
		model.addAttribute("distList", databaseCommUtil.getDistrictAllList());
		model.addAttribute("industryList", databaseCommUtil.getAllIndustryTypesList());
		model.addAttribute("location", databaseCommUtil.getAllLocations());
		model.addAttribute("RoleSearchDto", dto);
		return "roleSearch";
	}
	
	@RequestMapping(value="roleSearchResumepost.do" ,method={RequestMethod.GET,RequestMethod.POST})
	public String search(@ModelAttribute RoleSearchDto dto,Model model,HttpSession session){
	System.out.println(dto.getIndustryType()+"IIIII"+"dto.");
	EmployerDomain company=(EmployerDomain)session.getAttribute("employer");
		List<JobseekerRegisterDomain> list=service.getJobSeekerBasedOnRole(dto);
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
			session.setAttribute("RoleSearchDto", dto);	
			session.setAttribute("JobSeekerList", cadidateList);	
		model.addAttribute("JobSeekerList",cadidateList);
		model.addAttribute("noOfJobs",cadidateList.size());
		model.addAttribute("RoleSearchDto", dto);
		model.addAttribute("location", databaseCommUtil.getAllLocations());
		List<EmployerSubscriptionDomain> empSubList= new ArrayList<EmployerSubscriptionDomain>();
		empSubList=companyService.getCompanySubscriptionBasedOnType("Package", company.getCompanyKey());
		if(empSubList.size()>0){
			model.addAttribute("subscribed", "1");
		}
		if(cadidateList.size()<=0){
			
			return "RolesearchError";
		}else{
			model.addAttribute("JobSeekerList",cadidateList);
			
			
			
			return "roleSearchResumes";
		}
		
		
	
	}
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="RefineSearchRole.do" ,method={RequestMethod.GET,RequestMethod.POST})
	public String ItSearch( Model model,HttpServletRequest request,HttpSession session){
		EmployerDomain company=(EmployerDomain)session.getAttribute("employer");
		Set<CandidateResponseBean> cadidateList= (HashSet<CandidateResponseBean>)session.getAttribute("JobSeekerList");
		RoleSearchDto isdto=(RoleSearchDto)session.getAttribute("RoleSearchDto");
		Set<CandidateResponseBean> cadidateList1=new HashSet<CandidateResponseBean>();
		String param1=request.getParameter("anyKeyofWord");
		String param2=request.getParameter("allKeyofWord");
		String param3=request.getParameter("excludeKeyofWord");
		String resumePath=filepath.getResumePath();
		for (CandidateResponseBean candidateResponseBean : cadidateList) {
			
			boolean flag=true;
			if(param3 !=null && !param3.isEmpty() ){
				// finding excluding key words
				String keys[]=param3.split(",");
				
				for (int i = 0; i < keys.length; i++) {
					
					
					if(helper.findWordIntoResume(resumePath+"resume\\"+candidateResponseBean.getResumePath(), keys[i]))
					{
						
						flag=false;
						break;
						
					}else{
						flag=true;
						
					}
				}
			}

			boolean allKeyflag=true;
			if(param1 !=null && !param1.isEmpty() ){
				//finding for all key words 	
				if(flag==true){	
					String allKeys[]=param1.split(",");
					for (int j = 0; j < allKeys.length; j++) {
						System.out.println(candidateResponseBean.getResumePath()+"RESUME PATH");
						if(helper.findWordIntoResume(resumePath+"resume\\"+candidateResponseBean.getResumePath(), allKeys[j]))
						{
							allKeyflag=true;
						}else
						{
							allKeyflag=false;
							break;
						}
					}
				}
				else
					allKeyflag=false;
			}	
			boolean anyKeyflag=true;	
			if(param2 !=null && !param2.isEmpty()){
				//finding for any key words
				if(allKeyflag==true){
					String anyKeys[]=param2.split(",");
					for (int j = 0; j < anyKeys.length; j++) {
						System.out.println(candidateResponseBean.getResumePath()+"RESUME PATH");
						if(helper.findWordIntoResume(resumePath+"resume\\"+candidateResponseBean.getResumePath(), anyKeys[j]))
						{
							anyKeyflag=true;
							break;
						}else{

							anyKeyflag=false;
						}
					}
				}
				else{
					anyKeyflag=false;
				}
			}
			System.out.println(anyKeyflag+" anyKeyflag "+allKeyflag+" allKeyflag "+flag+"  flag");
			if(anyKeyflag==true && allKeyflag== true && flag==true){
				
				cadidateList1.add(candidateResponseBean);
			}

			//if find in resume options are empty
			if(param1 == null && param1.isEmpty() && param2 == null && param2.isEmpty() && param3 ==null && param3.isEmpty())
			{
				cadidateList1.addAll(cadidateList);
			}
			
		}
		//session.setAttribute("JobSeekerList",cadidateList1);
		model.addAttribute("noOfJobs",cadidateList1.size());
		session.setAttribute("RoleSearchDto", isdto);
		model.addAttribute("location", databaseCommUtil.getAllLocations());
		model.addAttribute("RoleSearchDto",isdto);
		List<EmployerSubscriptionDomain> empSubList= new ArrayList<EmployerSubscriptionDomain>();
		empSubList=companyService.getCompanySubscriptionBasedOnType("Package", company.getCompanyKey());
		if(empSubList.size()>0){
			model.addAttribute("subscribed", "1");
		}
		if(cadidateList1.size()<=0){
			
			return "RolesearchError";
		}else{
			model.addAttribute("JobSeekerList",cadidateList1);
			
			
			
			return "roleSearchResumes";
		}
		
		
		
		
		
	}
	
}
