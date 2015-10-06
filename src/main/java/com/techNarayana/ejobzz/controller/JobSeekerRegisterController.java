package com.techNarayana.ejobzz.controller;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.techNarayana.ejobzz.controller.controllerHelper.JobSeekerRegisterControllerHelper;
import com.techNarayana.ejobzz.domain.JobSeekerEducationDetailsDomain;
import com.techNarayana.ejobzz.domain.JobSeekerExperienceDomain;
import com.techNarayana.ejobzz.domain.JobSeekerLanguageDomain;
import com.techNarayana.ejobzz.domain.JobSeekerSkillsDomain;
import com.techNarayana.ejobzz.domain.JobseekerRegisterDomain;
import com.techNarayana.ejobzz.dto.JobResponseBean;
import com.techNarayana.ejobzz.dto.JobSeekerEducationDetailsDTO;
import com.techNarayana.ejobzz.dto.JobSeekerExperienceDTO;
import com.techNarayana.ejobzz.dto.JobSeekerLanguageDTO;
import com.techNarayana.ejobzz.dto.JobSeekerSkillsDTO;
import com.techNarayana.ejobzz.dto.JobseekerRegisterDTO;
import com.techNarayana.ejobzz.service.CompanyService;
import com.techNarayana.ejobzz.service.JobSeekerRegisterService;
import com.techNarayana.ejobzz.util.DatabaseCommUtils;
import com.techNarayana.ejobzz.util.FilePath;
import com.techNarayana.ejobzz.util.PasswordEncrypit;

@Controller
@Scope(value="prototype")
public class JobSeekerRegisterController {
	@Autowired 
	JobSeekerRegisterControllerHelper helper;
	@Autowired 
	JobSeekerRegisterService service;
	@Autowired
	FilePath filepath;
	@Autowired 
	CompanyService companyService;
	@Autowired
	private DatabaseCommUtils databaseCommUtil;

	@Autowired
	@Qualifier("jobSeekerValidator")
	private Validator validator;

	private static Logger logger=Logger.getLogger(JobSeekerRegisterController.class);
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@RequestMapping(value={"showjobseekerRegister.do"},method={RequestMethod.GET,RequestMethod.POST})
	public String getLogin(Model model,HttpServletRequest request){

		JobseekerRegisterDTO job=new JobseekerRegisterDTO();

		model.addAttribute("jobseekerRegisterDTO",job);
		model.addAttribute("location", databaseCommUtil.getAllLocations());
		return "jobseekersregister";
		
	}

	@RequestMapping(value={"createRegister.do"},method={RequestMethod.POST})
	public String createRegister(@ModelAttribute JobseekerRegisterDTO dto,BindingResult result,Model model,HttpServletRequest request){

		if(result.hasErrors()){
			return	"jobseekersregister";
		}

		try {
			JobseekerRegisterDomain dom = helper.createJobseekerRegister(dto);

			JobSeekerExperienceDTO jobExpSet=new JobSeekerExperienceDTO();

			dto.setEdto(jobExpSet);

			JobSeekerEducationDetailsDTO jobEduSet=new JobSeekerEducationDetailsDTO();

			dto.setDto(jobEduSet);
			BeanUtils.copyProperties(dom, dto);

			
			model.addAttribute("years",helper.getYears());
			model.addAttribute("months",helper.getMonths());
			model.addAttribute("skillmonth",helper.getMonth());
			model.addAttribute("lac",helper.getsalaryInlackhs());
			model.addAttribute("thousand",helper.getsalaryInThousands());
			model.addAttribute("expyears",helper.getInteger());
			model.addAttribute("jobseekerRegisterDTO",dto);
			model.addAttribute("industryList", databaseCommUtil.getAllIndustryTypesList());
			model.addAttribute("university", databaseCommUtil.getAllUniversities());
			model.addAttribute("id",dom.getJsid());
			model.addAttribute("success","Congratulations!  Your are a Ejobzz Member now, Let Us Create Your Proffessional Profile");



			return "jobSeekerExperience";
		} catch (Exception e) {
			model.addAttribute("fail","Sorry!  please fill the necessary details ");
			model.addAttribute("years",helper.getYears());
			model.addAttribute("months",helper.getMonths());
			model.addAttribute("skillmonth",helper.getMonth());
			model.addAttribute("lac",helper.getsalaryInlackhs());
			model.addAttribute("thousand",helper.getsalaryInThousands());
			model.addAttribute("expyears",helper.getInteger());
			model.addAttribute("university", databaseCommUtil.getAllUniversities());
			model.addAttribute("industryList", databaseCommUtil.getAllIndustryTypesList());
			model.addAttribute("id",dto.getJsid());
			e.printStackTrace();
			return "jobseekersregister";
		}

	}
	@RequestMapping(value={"EditupdateEduandExpdetails.do"},method={RequestMethod.GET,RequestMethod.POST})
	public String updateEducationandExperiencedetails(@ModelAttribute("jobseekerRegisterDTO") JobseekerRegisterDTO dto,HttpServletRequest request,Model model){


		try {
			JobseekerRegisterDomain dt= helper.getJobseekerRegister(dto.getJsid());
			String jseid=null;
			String jeid=null;
			for (JobSeekerExperienceDomain job : dt.getDomain()) {
				jseid=String.valueOf(job.getJseid());
			}
			for (JobSeekerEducationDetailsDomain edu : dt.getEdomain()) {
				jeid=String.valueOf(edu.getEid());
			}


			JobseekerRegisterDTO jobseeker=helper.updateEducationandExperiencedetails(dto,dt,jseid,jeid);
			HttpSession session=request.getSession(true);
			HashSet<JobSeekerSkillsDTO> skdto=new HashSet<JobSeekerSkillsDTO>();
			System.out.println(dt.getSdomain().size());
			if(dt.getSdomain()!=null){
				skdto=helper.getjobskills(dt);
			}

		
			model.addAttribute("jobseekerRegisterDTO",jobseeker);
			jobseeker.setLocation(databaseCommUtil.getLocationById(Integer.parseInt(jobseeker.getLocation())));
			String [] mulloc=jobseeker.getJobIntrestLocations().split(",");
			for (int i = 0; i < mulloc.length; i++) {
				jobseeker.setJobIntrestLocations(databaseCommUtil.getLocationById(Integer.parseInt(mulloc[i])));
			}
			String []paths=helper.resumePath(dto.getJsid());

			if(!paths[1].equals("") | paths[1]!=null){
				model.addAttribute("pic","profilepic/"+paths[1]);
			}
			else{
				model.addAttribute("pic","img/images.jpg");
			}

			model.addAttribute("skillset",skdto);
			
			JobSeekerExperienceDomain expdom=helper.getJobseekerRegisterDomain(dto.getJsid());


			model.addAttribute("company", expdom.getCompanyName());
			model.addAttribute("designation", expdom.getDesignation());
			model.addAttribute("sallac", expdom.getCurrentsalLackh());
			model.addAttribute("saltous", expdom.getCurrentsalThousand());
			
			System.out.println(jobseeker.resumeTitle+"JOBZZ"+jobseeker.location+""+jobseeker.totalExp+""+jobseeker.keySkills);
			session.setAttribute("lUser", jobseeker);
			return "jobseekerLoginPageView";
		} catch (Exception e) {
			request.setAttribute("success","sorry to update job experience Details");
			e.printStackTrace();
			return "jobSeekerExperience";

		}

	}
	@RequestMapping(value="/downloadFile.do", method={RequestMethod.POST,RequestMethod.GET})
	public void downloadResume(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String resumeId = ServletRequestUtils.getRequiredStringParameter(request, "id");

		String []paths=helper.resumePath(Integer.parseInt(resumeId));

		String path=filepath.getResumePath()+"resume/"+paths[0];
		String ext[]=paths[0].split("\\.");


		try{
			File f=new File(path);

			response.setContentType("application/octet-stream");
			response.setContentLength((int)f.length());
			response.setHeader("Content-Disposition","attachment; filename=\"" +"resume."+ext[1] +"\"");
			DataInputStream in=new DataInputStream(new FileInputStream(f));
			FileCopyUtils.copy(in, response.getOutputStream());
		}catch(Exception ex){
			PrintWriter pw=response.getWriter();
			pw.print("File not found");
		}


	}
	@RequestMapping(value={"UpdateProfilepic.do"},method={RequestMethod.GET,RequestMethod.POST})
	public String UpdateProfilepic(HttpServletRequest request,Model model,HttpSession session,@RequestParam("file") MultipartFile file){
		try {
			JobseekerRegisterDTO dto=(JobseekerRegisterDTO)session.getAttribute("lUser");
			if(dto==null){
				return "redirect:/Login.do";
			}
			JobseekerRegisterDomain dom= helper.getJobseekerRegister(dto.getJsid());
			String []paths=helper.resumePath(dto.jsid);
			String filename=helper.updateProfilepic(dto,file,filepath.getUserfilepicPath()+"profilepic/"+paths[0]);
			GetModelObject(dto, model, dom);
			if(!paths[1].equals("") | paths[1]!=null){
				model.addAttribute("pic","profilepic/"+filename);
			}
			else{
				model.addAttribute("pic","img/images.jpg");
			}


			session.setAttribute("lUser", dto);
			model.addAttribute("success","Succesfully added User details");
		} catch (Exception e) {
			model.addAttribute("fail","Sorry unable to add User details");
			e.printStackTrace();
		}

		return "jobseekerLoginPageView";
	}


	@RequestMapping(value={"viewJobProfile.do"},method={RequestMethod.POST,RequestMethod.GET})
	public String viewandUpdate(HttpServletRequest request,Model model,HttpSession session,HttpServletResponse response){
		JobseekerRegisterDTO dto=(JobseekerRegisterDTO)session.getAttribute("lUser");
		if(dto==null){
			return "redirect:/Login.do";
		}

		JobseekerRegisterDomain dom=helper.getJobseekerRegister(dto.getJsid());
		JobSeekerExperienceDomain expdom=helper.getJobseekerRegisterDomain(dto.getJsid());

		BeanUtils.copyProperties(dom, dto);



		GetModelObject(dto, model, dom);

		

		model.addAttribute("company", expdom.getCompanyName());
		model.addAttribute("designation", expdom.getDesignation());
		model.addAttribute("sallac", expdom.getCurrentsalLackh());
		model.addAttribute("saltous", expdom.getCurrentsalThousand());
		dto.setLocation(databaseCommUtil.getLocationById(Integer.parseInt(dto.getLocation())));
		
		String [] mulloc=dto.getJobIntrestLocations().split(",");
		String loc="";
		for (int i = 0; i < mulloc.length; i++) {
			
			String str=databaseCommUtil.getLocationById(Integer.parseInt(mulloc[i]));
			if(!str.isEmpty() && loc.isEmpty()){
				 loc=str;
			}else if(!loc.isEmpty()){
				 loc=loc+","+str;
			}
		}
		
		dto.setJobIntrestLocations(loc);
		model.addAttribute("jobseekerRegisterDTO",dto);
		return "jobseekerViewandUpdate";
	}


	@RequestMapping(value={"UpdateviewJobProfile.do"},method={RequestMethod.GET,RequestMethod.POST})
	public String UpdateviewJobProfile(@ModelAttribute JobseekerRegisterDTO dt, HttpServletRequest request,Model model,HttpSession session,HttpServletResponse response){
		JobseekerRegisterDTO dto=(JobseekerRegisterDTO)session.getAttribute("lUser");
		if(dto==null){
			return "redirect:/Login.do";
		}
		Integer jsid=dto.getJsid();
		JobseekerRegisterDomain dom=helper.getJobseekerRegister(jsid);

		BeanUtils.copyProperties(dom, dto);
		
		GetModelObject(dto, model, dom);
		
		model.addAttribute("jobseekerRegisterDTO",dto);
	model.addAttribute("location", databaseCommUtil.getAllLocations());
		return "jobseekerEditViewUpdate";
	}

	@RequestMapping(value={"UpdateandviewJobProfile.do"},method={RequestMethod.GET,RequestMethod.POST})
	public String UpdateandviewJobProfile(@ModelAttribute JobseekerRegisterDTO dt, HttpServletRequest request,Model model,HttpSession session,HttpServletResponse response){
		try {
			JobseekerRegisterDTO dto=(JobseekerRegisterDTO)session.getAttribute("lUser");
			if(dto==null){
				return "redirect:/Login.do";
			}
			Integer jsid=dto.getJsid();
			JobseekerRegisterDomain dom=helper.getJobseekerRegister(jsid);
			BeanUtils.copyProperties(dom, dto);
			String []paths=helper.resumePath(dto.jsid);
			helper.updateprofileDetails(dt,dto,paths);
			GetModelObject(dto, model, dom);

			model.addAttribute("success","Succesfully added User details");
		} catch (Exception e) {
			model.addAttribute("fail","Sorry unable to add User details");
			e.printStackTrace();
			logger.debug(e);
		}
		return "forward:viewJobProfile.do";

	}
	@RequestMapping(value={"UpdateProfileResume.do"},method={RequestMethod.GET,RequestMethod.POST})
	public String UpdateJobProfileResume(HttpServletRequest request,Model model,HttpSession session,@RequestParam("file") MultipartFile file){
		try {
			JobseekerRegisterDTO dto=(JobseekerRegisterDTO)session.getAttribute("lUser");
			if(dto==null){
				return "redirect:Login.do";
			}
			String res=(String)session.getAttribute("resume");
			helper.updateResume(dto,file,res);


			String []paths=helper.resumePath(dto.getJsid());
			session.setAttribute("resume",filepath.getResumePath()+"resume\\"+paths[0]);

			JobseekerRegisterDomain dom= helper.getJobseekerRegister(dto.getJsid());
			GetModelObject(dto, model, dom);

			model.addAttribute("success","Succesfully Updated your  Resume ");
		} catch (Exception e) {
			model.addAttribute("fail","Sorry! we are unable to read your Resume ");
			e.printStackTrace();
		}

		return "forward:viewJobProfile.do";
	}

	@RequestMapping(value="DeleteResume.do",method={RequestMethod.GET,RequestMethod.POST})
	public String DeleteResumeJobseeker(@RequestParam("id") Integer id,JobseekerRegisterDTO dto,Model model){
		try {
			String []paths=helper.resumePath(id);
			helper.deleteResume(id,paths[0]);

			JobseekerRegisterDomain dom=helper.getJobseekerRegister(id);
			BeanUtils.copyProperties(dom, dto);
			GetModelObject(dto, model, dom);

			model.addAttribute("success","Successfully Deleted your resume ");
		} catch (Exception e) {
			model.addAttribute("fail","Sorry!  please fill the necessary details ");
		}

		return "jobseekerViewandUpdate";

	}
	@RequestMapping(value="EditSkills.do",method={RequestMethod.GET,RequestMethod.POST})
	public String EditSkills(@RequestParam("id") Integer id,Model model,@ModelAttribute JobseekerRegisterDTO dto,HttpSession session){
		dto=(JobseekerRegisterDTO)session.getAttribute("lUser");
		if(dto==null){
			return "redirect:Login.do";
		}
		JobseekerRegisterDomain dom=helper.getJobseekerRegister(id);
		BeanUtils.copyProperties(dom, dto);
		HashSet<JobSeekerSkillsDTO> skdto=null;
		if(dom.getSdomain()!=null){
			skdto=helper.getjobskillsFromData(dom);

			model.addAttribute("skillset",skdto);
		}
		model.addAttribute("skillmonth",helper.getMonth());
		model.addAttribute("expyears",helper.getInteger());
		model.addAttribute("years",helper.getYears());
		model.addAttribute("jobseekerRegisterDTO",dto);

		return "EditJobseekerSkills";

	}
	@RequestMapping(value="UpdateSkills.do" ,method={RequestMethod.GET,RequestMethod.POST})
	public String UpdateSkills(@ModelAttribute JobseekerRegisterDTO dto,Model model){


		JobseekerRegisterDomain jobdom=helper.getJobseekerRegister(dto.getJsid());
		HashSet<JobSeekerSkillsDomain> dom=helper.getSkillsDto(dto);
		jobdom.setSdomain(dom);
		helper.updateJobskills(jobdom);

		JobseekerRegisterDomain jobdomain=helper.getJobseekerRegister(dto.getJsid());
		BeanUtils.copyProperties(jobdomain, dto);
		String []paths=helper.resumePath(dto.getJsid());
		HashSet<JobSeekerSkillsDTO> skdto=helper.getjobskills(jobdomain);
		model.addAttribute("skillset",skdto);
		model.addAttribute("pic","profilepic/"+paths[1]);
		model.addAttribute("modifyts",helper.ConvertJavaDateintoStringDate(dto.getModifyts()));
		model.addAttribute("jobseekerRegisterDTO",dto);
		model.addAttribute("success","Succesfully Updated  Skills ");

		return "forward:viewJobProfile.do";
	}

	@RequestMapping(value="DeleteSkills.do" ,method={RequestMethod.GET,RequestMethod.POST})
	public String deleteSkills (@RequestParam("id") Integer id,@ModelAttribute JobseekerRegisterDTO dto,Model model,HttpSession session){

		JobseekerRegisterDTO dto1=(JobseekerRegisterDTO)session.getAttribute("lUser");
		if(dto1==null){
			return "redirect:/Login.do";
		}
		helper.deleteSkills(id);

		JobseekerRegisterDomain jobdom=helper.getJobseekerRegister(dto1.getJsid());
		model.addAttribute("expyears",helper.getInteger());

		HashSet<JobSeekerSkillsDTO> skdto=helper.getjobskills(jobdom);
		model.addAttribute("skillset",skdto);
		model.addAttribute("years",helper.getYears());
		model.addAttribute("jobseekerRegisterDTO",dto1);

		return "EditJobseekerSkills";	
	}

	@RequestMapping(value="EditExperience.do" ,method={RequestMethod.GET,RequestMethod.POST})
	public String UpdateExperienceAnEducation (@RequestParam("id") Integer id,@ModelAttribute JobseekerRegisterDTO dto,Model model,HttpSession session ){

		JobseekerRegisterDTO dto1=(JobseekerRegisterDTO)session.getAttribute("lUser");
		if(dto1==null){
			return "redirect:/Login.do";
		}
		JobseekerRegisterDomain dom=helper.getJobseekerRegister(dto1.getJsid());


		BeanUtils.copyProperties(dom, dto1);

		GetModelObject(dto1, model, dom);
		List<JobSeekerExperienceDomain> expDomain=dom.getDomain();
		for (int i = 0; i <expDomain.size(); i++) {
			JobSeekerExperienceDTO dt=new JobSeekerExperienceDTO();
			JobSeekerExperienceDomain domain=expDomain.get(i);
			if(domain.getJseid()==id)
			{
				BeanUtils.copyProperties(domain, dt);
				
				dto1.setEdto(dt);

			}
			model.addAttribute("industryList", databaseCommUtil.getAllIndustryTypesList());
			model.addAttribute("jobseekerRegisterDTO", dto1);
		}
		return "EditjobseekerExperience";	
	}

	@RequestMapping(value="UpdateExperience.do" ,method={RequestMethod.GET,RequestMethod.POST})
	public String updateExperienceDetails (@ModelAttribute JobseekerRegisterDTO dto,Model model,HttpSession session ){

		JobseekerRegisterDomain dom=helper.getJobseekerRegister(dto.getJsid());
		JobSeekerExperienceDTO expDTO=dto.getEdto();
		helper.updateExperienceDetails(dom, expDTO);
		/*dom=helper.getJobseekerRegister(dto.getJsid());*/
		BeanUtils.copyProperties(dom, dto,new String[]{"lan"});
		GetModelObject(dto, model, dom);

		model.addAttribute("success","Succesfully Updated  Employment ");
		return "forward:viewJobProfile.do";

	}

	@RequestMapping(value="addEmployer.do" ,method={RequestMethod.GET,RequestMethod.POST})
	public String addEmployer (@RequestParam("id") Integer id ,@ModelAttribute JobseekerRegisterDTO dto,Model model){
		dto.setJsid(id);
		JobseekerRegisterDomain dom=helper.getJobseekerRegister(dto.getJsid());
		model.addAttribute("industryList", databaseCommUtil.getAllIndustryTypesList());

		GetModelObject(dto, model, dom);


		return "addEmployer";

	}
	@RequestMapping(value="addEmployerPost.do" ,method={RequestMethod.GET,RequestMethod.POST})
	public String createNewEmployer (@ModelAttribute JobseekerRegisterDTO dto,Model model){

		JobseekerRegisterDomain dom=helper.getJobseekerRegister(dto.getJsid());

		helper.createNewEmployer(dom,dto);

		GetModelObject(dto, model, dom);


		return "forward:viewJobProfile.do";

	}


	public Model GetModelObject(JobseekerRegisterDTO dto,Model model,JobseekerRegisterDomain dom){

		HashSet<JobSeekerSkillsDTO> skdto=null;
		String []paths=helper.resumePath(dto.getJsid());
		String st=helper.checkAndConvertFile(paths[0],"resume/"+paths[0]);
		logger.debug("RESUME Content"+st);
		if(dom.getSdomain()!=null){
			skdto=helper.getjobskills(dom);
		}
		
		
		int[] year = {0,0} ;
		List<JobSeekerExperienceDomain> expDomain=dom.getDomain();
		List<JobSeekerExperienceDTO> expDTO=new ArrayList<JobSeekerExperienceDTO>();
		for (JobSeekerExperienceDomain jobDomain : expDomain) {
			JobSeekerExperienceDTO edto=new JobSeekerExperienceDTO();
			BeanUtils.copyProperties(jobDomain, edto);

			expDTO.add(edto);
			year=helper.diffbwdates(jobDomain);

		}
		List<JobSeekerEducationDetailsDomain> edudom=dom.getEdomain();


		List<JobSeekerEducationDetailsDTO>  eduDTO=new ArrayList<JobSeekerEducationDetailsDTO>();
		for (JobSeekerEducationDetailsDomain edom : edudom) {
			JobSeekerEducationDetailsDTO edto=new JobSeekerEducationDetailsDTO();
			
			BeanUtils.copyProperties(edom, edto);
			
			edto.setUniversity(databaseCommUtil.getUniversityById(Integer.parseInt(edom.getUniversity())));

			eduDTO.add(edto);


		}
		Collections.sort(expDTO, new Comparator<JobSeekerExperienceDTO>() {
			public int compare(JobSeekerExperienceDTO v1, JobSeekerExperienceDTO v2) {
				return v1.getEmployeeType().compareTo(v2.getEmployeeType());
			}
		});
		List<JobSeekerLanguageDTO> langdto=null;
		if(dom.getSdomain()!=null){
			langdto=helper.getlanguages(dom);
			System.out.println(langdto.size()+"AAAAAAAAA");
			model.addAttribute("langDetails",langdto);
		}

		model.addAttribute("jobseekerRegisterDTO",dto);


		model.addAttribute("year",year[0]);
		model.addAttribute("mont",year[1]);

		model.addAttribute("expDTO", expDTO);
		model.addAttribute("eduDTO", eduDTO);
		model.addAttribute("skillset",skdto);
	
		
		
	
		model.addAttribute("jobseekerRegisterDTO",dto);
		model.addAttribute("expyears",helper.getInteger());
		model.addAttribute("st",st);
		if(!paths[1].isEmpty() && paths[1]!=null){
			model.addAttribute("pic","profilepic/"+paths[1]);
		}
		else{
			model.addAttribute("pic","img/images.jpg");
		}
		model.addAttribute("modifyts",helper.ConvertJavaDateintoStringDate(dto.getModifyts()));

		model.addAttribute("years",helper.getYears());
		model.addAttribute("months",helper.getMonths());
		model.addAttribute("lac",helper.getsalaryInlackhs());
		model.addAttribute("thousand",helper.getsalaryInThousands());
		return model;
	}
	@RequestMapping(value="DeleteEmployer.do" ,method={RequestMethod.GET,RequestMethod.POST})
	public String DeleteEmployer(@RequestParam("id") Integer id,JobseekerRegisterDTO dto,Model model,HttpSession session){
		dto=(JobseekerRegisterDTO)session.getAttribute("lUser");
		if(dto== null){

			return "redirect:/Login.do";
		}
		helper.deleteEmployer(id);	
		JobseekerRegisterDomain dom=helper.getJobseekerRegister(dto.getJsid());

		BeanUtils.copyProperties(dom, dto,new String[]{"lan"});
		GetModelObject(dto, model, dom);

		return "forward:viewJobProfile.do";

	}
	@RequestMapping(value="addEducationPost.do" ,method={RequestMethod.GET,RequestMethod.POST})
	public String createNewEducation (@ModelAttribute JobseekerRegisterDTO dto,Model model){

		JobseekerRegisterDomain dom=helper.getJobseekerRegister(dto.getJsid());

		helper.saveEducation(dto.getDto(), dom);

		GetModelObject(dto, model, dom);


		return "forward:viewJobProfile.do";

	}
	@RequestMapping(value="editEducation.do" ,method={RequestMethod.GET,RequestMethod.POST})
	public String editEducation(@RequestParam("id") Integer eid,JobseekerRegisterDTO dto,Model model){

		JobSeekerEducationDetailsDomain domain=helper.editEducation(eid);
		JobSeekerEducationDetailsDTO dt=new JobSeekerEducationDetailsDTO();
		BeanUtils.copyProperties(domain,dt );
		dto.setDto(dt);
		model.addAttribute("university",databaseCommUtil.getAllUniversities());
		model.addAttribute("jobseekerRegisterDTO",dto);
		model.addAttribute("years",helper.getYears());
		return "editEducation";

	}

	@RequestMapping(value="UpdateEducation.do" ,method={RequestMethod.GET,RequestMethod.POST})
	public String UpdateEducation(JobseekerRegisterDTO dto,Model model){
		JobseekerRegisterDomain dom=helper.getJobseekerRegister(dto.getJsid());
		JobSeekerEducationDetailsDTO dt=dto.getDto();
		System.out.println(dt.etype+"ABCDE");
		helper.UpdateEducation(dt,dom);
		dom=helper.getJobseekerRegister(dto.getJsid());
		GetModelObject(dto, model, dom);

		BeanUtils.copyProperties(dom,dto );

		model.addAttribute("jobseekerRegisterDTO",dto);
		model.addAttribute("years",helper.getYears());
		return "forward:viewJobProfile.do";

	}
	@RequestMapping(value="addEducation.do" ,method={RequestMethod.GET,RequestMethod.POST})
	public String addEducation(JobseekerRegisterDTO dto,Model model){

		model.addAttribute("years",helper.getYears());
		model.addAttribute("university",databaseCommUtil.getAllUniversities());
		model.addAttribute("jobseekerRegisterDTO",dto);
		return "addEducation";

	}


	@RequestMapping(value="DeleteEducation.do" ,method={RequestMethod.GET,RequestMethod.POST})
	public String DeleteEducation(@RequestParam("id") Integer id,JobseekerRegisterDTO dto,Model model,HttpSession session){
		dto=(JobseekerRegisterDTO)session.getAttribute("lUser");
		if(dto== null){

			return "redirect:/Login.do";
		}
		helper.deleteEducation(id);	
		JobseekerRegisterDomain dom=helper.getJobseekerRegister(dto.getJsid());

		BeanUtils.copyProperties(dom, dto,new String[]{"lan"});
		GetModelObject(dto, model, dom);

		return "forward:viewJobProfile.do";

	}
	@RequestMapping(value="ChangePassword.do")
	public String ChangePassword(HttpServletRequest request,Model model){

		return "jobseekerChangePassword";
	}

	@RequestMapping(value="jobSeekerLogin.do" )
	public String jobseekerLogin(HttpServletRequest request,Model model){

		return "jobseeker";
	}

	@RequestMapping(value="ChangePasswordPost.do")
	public String changePasswordPost(HttpServletRequest request){
		System.out.println("changing Password");

		JobseekerRegisterDTO dto=(JobseekerRegisterDTO)request.getSession().getAttribute("lUser");
		if(dto== null){

			return "redirect:/Login.do";
		}
		PasswordEncrypit encrypt=new PasswordEncrypit("");
		String currentPwd=encrypt.decrypt(dto.getPassword());
		String currPWd=(String)request.getParameter("currentPassword");
		String newPwd=(String)request.getParameter("newPassword");
		String confPwd=(String)request.getParameter("rePassword");
		logger.debug("curren "+currentPwd+" new p "+newPwd+ " from ui "+currPWd);
		//System.out.println("curren "+currentPwd+" new p "+newPwd+ " from ui "+currPWd);
		if(!currentPwd.equals(currPWd)){
			request.setAttribute("notMatch", "Enter valid Current Password");
			return "jobseekerChangePassword";
		}

		try{
			if(!newPwd.equals(confPwd)){
				request.setAttribute("notMatch", "Passwords do not match");
				return "jobseekerChangePassword";
			}

			helper.ChangePassword(encrypt.encrypt(newPwd), dto.getJsid());

			request.setAttribute("success", "password Succfully changed");
			dto.setPassword(encrypt.encrypt(newPwd));
			request.getSession().setAttribute("lUser", dto);
		}catch(Exception e){
			request.setAttribute("fail", "Changing password Failed");
			return "jobseekerChangePassword";
		}
		request.setAttribute("success", "password Succfully changed");
		return "redirect:/viewJobProfile.do";
	}
	@RequestMapping(value="jobsByskill.do")
	public String jobsByskill(HttpServletRequest request,Model model){

		return "jobsBySkill";
	}

	@RequestMapping(value="jobsBycity.do")
	public String jobsBycity(HttpServletRequest request,Model model){
		model.addAttribute("location", databaseCommUtil.getAllLocations());
		return "jobsBycity";
	}

	@RequestMapping(value="jobsByDesign.do")
	public String jobsBydesign(HttpServletRequest request,Model model){

		return "jobsByDesignation";
	}

	@RequestMapping(value="jobsByCompany.do")
	public String jobsByCompany(HttpServletRequest request,Model model){

		return "jobsByCompany";
	}

	@RequestMapping(value="GetJobsByCity.do" ,method={RequestMethod.GET,RequestMethod.POST})
	public String AllJobs(@RequestParam("city") String city,Model model,HttpServletRequest request){
		List<JobResponseBean>listJobBasedOncity=helper.getJobsBycity(city);
		List<JobResponseBean>listJobOncity=new ArrayList<JobResponseBean>();
		for (JobResponseBean jobResponseBean : listJobBasedOncity) {
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
			listJobOncity.add(jobResponseBean);
		}
		

		model.addAttribute("noOfJobs", listJobOncity.size());
		model.addAttribute("joblist", listJobOncity);

		return "JobsSearch";

	}

	@RequestMapping(value="GetJobsBySkill.do" ,method={RequestMethod.GET,RequestMethod.POST})
	public String JobsByskill(@RequestParam("skill") String skill,Model model,HttpServletRequest request){
		List<JobResponseBean>listJobBasedOnskill=helper.getJobsByskill(skill);
		List<JobResponseBean>listJobOnskill=new ArrayList<JobResponseBean>();
		for (JobResponseBean jobResponseBean : listJobBasedOnskill) {
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
			listJobOnskill.add(jobResponseBean);
		}
		

		model.addAttribute("noOfJobs", listJobOnskill.size());
		model.addAttribute("joblist", listJobOnskill);

		return "JobsSearch";

	}
	@RequestMapping(value="GetJobsByDesignation.do" ,method={RequestMethod.GET,RequestMethod.POST})
	public String GetJobsByDesignation(@RequestParam("design") String design,Model model,HttpServletRequest request){
		List<JobResponseBean>listJobBasedOndesign=helper.GetJobsByDesignation(design);
		List<JobResponseBean>listJobOndesign=new ArrayList<JobResponseBean>();
		for (JobResponseBean jobResponseBean : listJobBasedOndesign) {
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
			listJobOndesign.add(jobResponseBean);
		}
		model.addAttribute("noOfJobs", listJobOndesign.size());
		model.addAttribute("joblist", listJobOndesign);

		return "JobsSearch";

	}

	@RequestMapping(value="GetJobsByCompany.do" ,method={RequestMethod.GET,RequestMethod.POST})
	public String GetJobsByCompany(@RequestParam("design") String design,Model model,HttpServletRequest request){
		List<JobResponseBean>listJobBasedOncompany=helper.GetJobsByDesignation(design);
		List<JobResponseBean>listJobOncompny=new ArrayList<JobResponseBean>();
		for (JobResponseBean jobResponseBean : listJobBasedOncompany) {
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
			listJobOncompny.add(jobResponseBean);
		}
		model.addAttribute("noOfJobs", listJobOncompny.size());
		model.addAttribute("joblist", listJobOncompny);

		return "JobsSearch";

	}
	@RequestMapping(value="EazySearch.do" ,method={RequestMethod.GET,RequestMethod.POST})
	public String EasySearch(Model model,HttpServletRequest request){


		return "EasySearch";

	}


	@RequestMapping(value="panel.do" ,method={RequestMethod.GET,RequestMethod.POST})
	public String Panel(Model model,HttpServletRequest request){


		return "panelpreview";

	}

	@RequestMapping(value="addLanguage.do" ,method={RequestMethod.GET,RequestMethod.POST})
	public String addLanguage(@RequestParam("id") Integer id,JobseekerRegisterDTO dto,Model model){
		JobseekerRegisterDomain dom=helper.getJobseekerRegister(id);
		System.out.println(dom.getLang().size()+"SIZZ");
		BeanUtils.copyProperties(dom, dto);
		List<JobSeekerLanguageDTO> langdto=null;
		if(dom.getSdomain()!=null){
			langdto=helper.getjobsLangDetails(dom);
			System.out.println(langdto.size()+"AAAAAAAAA");
			model.addAttribute("langDetails",langdto);
		}

		model.addAttribute("jobseekerRegisterDTO",dto);


		return "addLangauage";

	}


	@RequestMapping(value="UpdateLanguage.do" ,method={RequestMethod.GET,RequestMethod.POST})
	public String UpdateLanguage(@ModelAttribute JobseekerRegisterDTO dto,Model model){


		JobseekerRegisterDomain jobdom=helper.getJobseekerRegister(dto.getJsid());

		ArrayList<JobSeekerLanguageDomain> landom=helper.getLangDto(dto);
		jobdom.setLang(landom);

		helper.updateLanguage(jobdom);

		JobseekerRegisterDomain jobdomain=helper.getJobseekerRegister(dto.getJsid());
		BeanUtils.copyProperties(jobdomain, dto);
		String []paths=helper.resumePath(dto.getJsid());
		ArrayList<JobSeekerLanguageDTO> landto=helper.getlanguages(jobdomain);
		model.addAttribute("langDetails",landto);
		model.addAttribute("pic","profilepic/"+paths[1]);
		model.addAttribute("modifyts",helper.ConvertJavaDateintoStringDate(dto.getModifyts()));
		model.addAttribute("jobseekerRegisterDTO",dto);
		model.addAttribute("success","Succesfully Updated  Language ");

		return "forward:viewJobProfile.do";
	}
	@RequestMapping(value="DeleteLanguage.do" ,method={RequestMethod.GET,RequestMethod.POST})
	public String DeleteLanguage (@RequestParam("id") Integer id,@ModelAttribute JobseekerRegisterDTO dto,Model model,HttpSession session){

		JobseekerRegisterDTO dto1=(JobseekerRegisterDTO)session.getAttribute("lUser");
		if(dto1==null){
			return "redirect:/Login.do";
		}

		helper.deletelanguage(id);

		JobseekerRegisterDomain jobdom=helper.getJobseekerRegister(dto1.getJsid());
		model.addAttribute("expyears",helper.getInteger());

		ArrayList<JobSeekerLanguageDTO> landto=helper.getlanguages(jobdom);
		model.addAttribute("langDetails",landto);
		model.addAttribute("years",helper.getYears());
		model.addAttribute("jobseekerRegisterDTO",dto1);

		return "EditJobseekerSkills";	
	}

}
