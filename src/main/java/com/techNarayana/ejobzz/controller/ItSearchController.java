package com.techNarayana.ejobzz.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import com.techNarayana.ejobzz.dto.MailDto;
import com.techNarayana.ejobzz.dto.RoleSearchDto;
import com.techNarayana.ejobzz.dto.SearchDTO;
import com.techNarayana.ejobzz.service.CompanyService;
import com.techNarayana.ejobzz.service.JobSeekerRegisterService;
import com.techNarayana.ejobzz.util.DatabaseCommUtils;
import com.techNarayana.ejobzz.util.EmailAPI;
import com.techNarayana.ejobzz.util.FilePath;

@Controller
@Scope(value="prototype")
public class ItSearchController {
	@Autowired 
	JobSeekerRegisterControllerHelper helper;
	@Autowired 
	JobSeekerRegisterService service;
	
	@Autowired 
	EmailAPI emailAPI;
	
	@Autowired
	CompanyService companyService;
	@Autowired 
	FilePath filepath;
	@Autowired
	private DatabaseCommUtils databaseCommUtil;
	public static Logger logger=Logger.getLogger(ItSearchController.class);
	@RequestMapping(value="itSearch.do" ,method={RequestMethod.GET,RequestMethod.POST})
	public String viewSearch(Model model){
		
		SearchDTO dto=new SearchDTO();

		model.addAttribute("years",helper.getYears());
		model.addAttribute("months",helper.getMonths());
		model.addAttribute("lac",helper.getsalaryInlackhs());
		model.addAttribute("thousand",helper.getsalaryInThousands());
		model.addAttribute("expyears",helper.getInteger());
		
		model.addAttribute("distList", databaseCommUtil.getDistrictAllList());
		model.addAttribute("industryList", databaseCommUtil.getAllIndustryTypesList());
		model.addAttribute("SearchDTO", dto);
		model.addAttribute("location", databaseCommUtil.getAllLocations());
		return "itSearch";
	}
	
	@RequestMapping(value="itSearchResumepost.do" ,method={RequestMethod.GET,RequestMethod.POST})
	public String search(@ModelAttribute SearchDTO isdto,Model model,HttpSession session){
		EmployerDomain company=(EmployerDomain)session.getAttribute("employer");
		List<JobseekerRegisterDomain> list=service.getJobSeekerBasedOnSkillCriteria(isdto);
		Set<JobseekerRegisterDomain> setList=new HashSet<JobseekerRegisterDomain>(list);
		Set<JobseekerRegisterDomain> setList1= new HashSet<JobseekerRegisterDomain>();
		//Finding inside resume
		
		for (JobseekerRegisterDomain jobseekerRegisterDomain : setList) {
			

			boolean flag=true;
			if(isdto.getExcludingkey() !=null && !isdto.getExcludingkey().isEmpty() ){
				// finding excluding key words
				String keys[]=isdto.getExcludingkey().split(",");
				for (int i = 0; i < keys.length; i++) {
					if(helper.findWordIntoResume("resume/"+jobseekerRegisterDomain.getResumePath(), keys[i]))
					{
						flag=false;
						break;
					}else{
						flag=true;
					}
				}
			}

			boolean allKeyflag=true;
			if(isdto.getAllKeyWords() !=null && !isdto.getAllKeyWords().isEmpty() ){
				//finding for all key words 	
				if(flag==true){	
					String allKeys[]=isdto.getAllKeyWords().split(",");
					for (int j = 0; j < allKeys.length; j++) {
						if(helper.findWordIntoResume("resume/"+jobseekerRegisterDomain.getResumePath(), allKeys[j]))
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
			if(isdto.getAnyKeyWords() !=null && !isdto.getAnyKeyWords().isEmpty()){
				//finding for any key words
				if(allKeyflag==true){
					String anyKeys[]=isdto.getAnyKeyWords().split(",");
					for (int j = 0; j < anyKeys.length; j++) {
						if(helper.findWordIntoResume("resume/"+jobseekerRegisterDomain.getResumePath(), anyKeys[j]))
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

			if(anyKeyflag==true && allKeyflag== true && flag==true){
				setList1.add(jobseekerRegisterDomain);
			}

			//if find in resume options are empty
			if(isdto.getExcludingkey() == null && isdto.getExcludingkey().isEmpty() && isdto.getAnyKeyWords() == null && isdto.getAnyKeyWords().isEmpty() && isdto.getAllKeyWords() ==null && isdto.getAllKeyWords().isEmpty())
			{
				setList1.addAll(setList);
			}
		}
		//coping data
		Set<CandidateResponseBean> cadidateList=new HashSet<CandidateResponseBean>();
		String excludeProperties[]={"domain","edomain","sdomain","lan"};

		CandidateResponseBean candResponseBean=null;
		for (JobseekerRegisterDomain jsrd  : setList1) {
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

		//setting current job to candidate list

		for (CandidateResponseBean cadidate : cadidateList) {
			CandidateExpResponseBean candExpResponseBean=new CandidateExpResponseBean();
			JobSeekerExperienceDomain jobSeekerExperienceDomain=service.getCandidateCurrentJob(cadidate.jsid);
			String excludeProperties1[]={"job"};
			jobSeekerExperienceDomain=service.setindustryTypeName(jobSeekerExperienceDomain);
			BeanUtils.copyProperties(jobSeekerExperienceDomain,candExpResponseBean ,excludeProperties1);
			cadidate.setExp(candExpResponseBean);
			cadidateList.add(cadidate);
		}
			session.setAttribute("adminjobList",cadidateList);
			session.setAttribute("SearchDTO", isdto);
			model.addAttribute("SearchDTO",isdto);
			model.addAttribute("noOfJobs",cadidateList.size());
			model.addAttribute("location", databaseCommUtil.getAllLocations());
			List<EmployerSubscriptionDomain> empSubList= new ArrayList<EmployerSubscriptionDomain>();
			empSubList=companyService.getCompanySubscriptionBasedOnType("Package", company.getCompanyKey());
			if(empSubList.size()>0){
				model.addAttribute("subscribed", "1");
			}
				model.addAttribute("JobSeekerList",cadidateList);
				if(cadidateList.size()<=0){
					
					return "ItsearchError";
				}else{
					model.addAttribute("JobSeekerList",cadidateList);
					
					
					return "itSearchResumes";
				}
				
				
			
	
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="Searchagain.do" ,method={RequestMethod.GET,RequestMethod.POST})
	public String ItSearch( Model model,HttpServletRequest request,HttpSession session){
		EmployerDomain company=(EmployerDomain)session.getAttribute("employer");
		Set<CandidateResponseBean> cadidateList= (HashSet<CandidateResponseBean>)session.getAttribute("adminjobList");
		SearchDTO isdto=(SearchDTO)session.getAttribute("SearchDTO");
		Set<CandidateResponseBean> cadidateList1=new HashSet<CandidateResponseBean>();
		String param1=request.getParameter("anyKeyofWord");
		String param2=request.getParameter("allKeyofWord");
		String param3=request.getParameter("excludeKeyofWord");
		
		for (CandidateResponseBean candidateResponseBean : cadidateList) {
			
			boolean flag=true;
			if(param3 !=null && !param3.isEmpty() ){
				// finding excluding key words
				String keys[]=param3.split(",");
				
				for (int i = 0; i < keys.length; i++) {
					
					
					if(helper.findWordIntoResume("resume/"+candidateResponseBean.getResumePath(), keys[i]))
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
						if(helper.findWordIntoResume("resume/"+candidateResponseBean.getResumePath(), allKeys[j]))
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
						if(helper.findWordIntoResume("resume/"+candidateResponseBean.getResumePath(), anyKeys[j]))
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
				/*if(candidateResponseBean.getJobIntrestLocations()!=null && !candidateResponseBean.getJobIntrestLocations().isEmpty()){
					candidateResponseBean.setLocation(databaseCommUtil.getLocationById(Integer.parseInt(candidateResponseBean.getLocation())));
				}
				if(candidateResponseBean.getJobIntrestLocations()!=null && !candidateResponseBean.getJobIntrestLocations().isEmpty()){
					String [] mulloc=candidateResponseBean.getJobIntrestLocations().split(",");
					String loc="";
					for (int i = 0; i < mulloc.length; i++) {

						String str=databaseCommUtil.getLocationById(Integer.parseInt(mulloc[i]));
						if(!str.isEmpty() && loc.isEmpty()){
							loc=str;
						}else if(!loc.isEmpty()){
							loc=loc+","+str;
						}
					}

					candidateResponseBean.setJobIntrestLocations(loc);
				}
				*/
				cadidateList1.add(candidateResponseBean);
			}

			//if find in resume options are empty
			if(isdto.getExcludingkey() == null && isdto.getExcludingkey().isEmpty() && isdto.getAnyKeyWords() == null && isdto.getAnyKeyWords().isEmpty() && isdto.getAllKeyWords() ==null && isdto.getAllKeyWords().isEmpty())
			{
				cadidateList1.addAll(cadidateList);
			}
			
		}
		//session.setAttribute("JobSeekerList",cadidateList1);
		model.addAttribute("noOfJobs",cadidateList1.size());
		session.setAttribute("SearchDTO", isdto);

		model.addAttribute("SearchDTO",isdto);
		model.addAttribute("location", databaseCommUtil.getAllLocations());
		List<EmployerSubscriptionDomain> empSubList= new ArrayList<EmployerSubscriptionDomain>();
		empSubList=companyService.getCompanySubscriptionBasedOnType("Package", company.getCompanyKey());
		if(empSubList.size()>0){
			model.addAttribute("subscribed", "1");
		}
		if(cadidateList1.size()<=0){
			
			return "ItsearchError";
		}else{
			model.addAttribute("JobSeekerList",cadidateList1);
			
			
			
			return "itSearchResumes";
		}
		
		
		
		
		
	}
	
	
	@RequestMapping(value="modifySearch.do" ,method={RequestMethod.GET,RequestMethod.POST})
	public String modifyItSearch(@ModelAttribute SearchDTO isdto, Model model,HttpServletRequest request,HttpSession session){
		model.addAttribute("years",helper.getYears());
		model.addAttribute("months",helper.getMonths());
		model.addAttribute("lac",helper.getsalaryInlackhs());
		model.addAttribute("thousand",helper.getsalaryInThousands());
		model.addAttribute("expyears",helper.getInteger());

		model.addAttribute("distList", databaseCommUtil.getDistrictAllList());
		model.addAttribute("industryList", databaseCommUtil.getAllIndustryTypesList());
		model.addAttribute("location", databaseCommUtil.getAllLocations());
		model.addAttribute("SearchDTO",isdto);
		
		return "itSearch";
	}
	
	@RequestMapping(value="modifyadminSearch.do" ,method={RequestMethod.GET,RequestMethod.POST})
	public String modifyadminSearch(@ModelAttribute ITSearchDto isdto, Model model,HttpServletRequest request,HttpSession session){
		model.addAttribute("years",helper.getYears());
		model.addAttribute("months",helper.getMonths());
		model.addAttribute("lac",helper.getsalaryInlackhs());
		model.addAttribute("thousand",helper.getsalaryInThousands());
		model.addAttribute("expyears",helper.getInteger());

		model.addAttribute("distList", databaseCommUtil.getDistrictAllList());
		model.addAttribute("industryList", databaseCommUtil.getAllIndustryTypesList());
		model.addAttribute("location", databaseCommUtil.getAllLocations());
		model.addAttribute("ITSearchDto",isdto);
		
		return "advSearch";
	}
	@RequestMapping(value="modifyeasySearch.do" ,method={RequestMethod.GET,RequestMethod.POST})
	public String EasySearchSearch(@ModelAttribute EasysearchDTO easyDto, Model model,HttpServletRequest request,HttpSession session){
		
		model.addAttribute("EasysearchDTO",easyDto);
		
		return "EasySearch";
	}
	
	@RequestMapping(value="modifyroleSearch.do" ,method={RequestMethod.GET,RequestMethod.POST})
	public String RoleSearchSearch(@ModelAttribute RoleSearchDto dto, Model model,HttpServletRequest request,HttpSession session){
		model.addAttribute("years",helper.getYears());
		model.addAttribute("months",helper.getMonths());
		model.addAttribute("lac",helper.getsalaryInlackhs());
		model.addAttribute("thousand",helper.getsalaryInThousands());
		model.addAttribute("expyears",helper.getInteger());
		model.addAttribute("location", databaseCommUtil.getAllLocations());
		model.addAttribute("distList", databaseCommUtil.getDistrictAllList());
		model.addAttribute("industryList", databaseCommUtil.getAllIndustryTypesList());
		model.addAttribute("RoleSearchDto",dto);
		
		return "roleSearch";
	}
	@RequestMapping(value="template.do" ,method={RequestMethod.GET,RequestMethod.POST})
	public void template(Model model,HttpServletRequest request,HttpSession session,HttpServletResponse response){
		String st=(String)request.getParameter("val");
		
		
		if(st!=null && !st.isEmpty())
		{	
			
			session.setAttribute("emailID", st);
		}
		String txt="";
		if(st != null){
			
			txt="0";
		}
		else{
			txt="1";
		}
		response.setContentType("text/html");
		try {
			System.out.println("inside print writer");
			response.getWriter().write(txt);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value="bulkmailPreview.do" ,method={RequestMethod.GET,RequestMethod.POST})
	public String bulkmailPreview(@ModelAttribute MailDto mailCommand,Model model,HttpServletRequest request){
		
		System.out.println("---Inside contact--- "+mailCommand.getEmailId());
	
		model.addAttribute("mailCommand",mailCommand);
		
		logger.debug("---end contact--- ");
		return "bulkmailPreview";
	}
	
	@RequestMapping(value="modifybulkContact.do" ,method={RequestMethod.GET,RequestMethod.POST})
	public String modifybulkContact(@ModelAttribute MailDto mailCommand,Model model,HttpServletRequest request){
		
		System.out.println(mailCommand);
		logger.debug("---Inside contact--- ");
		
		model.addAttribute("mailCommand",mailCommand);
		logger.debug("---end contact--- ");
		return "sendbulkmail";
	}
	
	@RequestMapping(value="contactbulk.do" ,method={RequestMethod.GET,RequestMethod.POST})
	public String contactbulk(Model model,HttpServletRequest request){
		
		
		
		logger.debug("---Inside contact--- ");
		MailDto mailCommand=new MailDto();
		model.addAttribute("mailCommand",mailCommand);
		//model.addAttribute("emailID",email);
		logger.debug("---end contact--- ");
		return "sendbulkmail";
	}
	
	@RequestMapping(value="sendbulkMail.do" ,method={RequestMethod.GET,RequestMethod.POST})
	public String sendbulkMailToCandidate(@ModelAttribute MailDto mailCommand,Model model,HttpServletRequest request){
	
		String emailId=(String)request.getSession().getAttribute("emailID");
		String emailIds[]=emailId.split(",");
	for (int i = 0; i < emailIds.length; i++) {
		
	
		logger.debug("---Inside contact--- ");
		model.addAttribute("mailCommand",mailCommand);
		
		String htmlmail="<b>Subject:</b>"+ mailCommand.subject+"<br/><b>Experience required for the Job:</b>"+ mailCommand.getJobExpFrom()+" - "+ mailCommand.getJobExpTo()+"<br/>"+
				 "<b>Annual Salary of the Job: </b>"+mailCommand.getCtcFromLac()+ " - " + mailCommand.getCtcToLac()+" Lacs - salary details<br/><br/><center> <input type='button' value='Reply'></center> <br/><b> Dear Candidate,<br/><br/></b>"+mailCommand.getMessage()+"<br/><br/>"+mailCommand.getSignature();
		htmlmail+="<br/><br/><font size='0.5'>Disclaimer:Technarayana Pvt Ltd. neither guarantees nor offers any warranty about the credentials of the offer. The responsibility of checking the authenticity of offers/correspondence lies with you. If you consider the content of this email inappropriate or spam, you may: Report abuse by forwarding this email to: compliance@ejobzz.com Advisory: Please do not pay any money to anyone who promises to find you a job. This could be in the form of a registration fee, or document processing fee or visa charges or any other pretext. The money could be asked for upfront or it could be asked after trust has been built after some correspondence has been exchanged. Also please note that in case you get a job offer or a letter of intent without having been through an interview process it is probably a scam and you should contact compliance@ejobzz.com for advise.</font>";
		final String NOTIFICATION_BODY = new StringBuffer().append(htmlmail).toString();
		
		
		emailAPI.sendHTMLMail(emailIds[i], mailCommand.getRecruiterEmailId(), mailCommand.getSubject(), NOTIFICATION_BODY);
		System.out.println("plain mail sent...");
	
		model.addAttribute("htmlmail", htmlmail);
	}
		logger.debug("---end contact--- ");
		return "previewMail";
	}
	
}
