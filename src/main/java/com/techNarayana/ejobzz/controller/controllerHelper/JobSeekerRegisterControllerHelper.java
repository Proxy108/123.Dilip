package com.techNarayana.ejobzz.controller.controllerHelper;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.io.FilenameUtils;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.HWPFDocumentCore;
import org.apache.poi.hwpf.converter.WordToHtmlConverter;
import org.apache.poi.hwpf.converter.WordToHtmlUtils;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.converter.core.FileURIResolver;
import org.apache.poi.xwpf.converter.core.XWPFConverterException;
import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;

import com.techNarayana.ejobzz.domain.EmployerDomain;
import com.techNarayana.ejobzz.domain.EmployerSubscriptionDomain;
import com.techNarayana.ejobzz.domain.JobDomain;
import com.techNarayana.ejobzz.domain.JobSeekerEducationDetailsDomain;
import com.techNarayana.ejobzz.domain.JobSeekerExperienceDomain;
import com.techNarayana.ejobzz.domain.JobSeekerLanguageDomain;
import com.techNarayana.ejobzz.domain.JobSeekerSkillsDomain;
import com.techNarayana.ejobzz.domain.JobseekerRegisterDomain;
import com.techNarayana.ejobzz.dto.CompanyDto;
import com.techNarayana.ejobzz.dto.EmployerDto;
import com.techNarayana.ejobzz.dto.JobResponseBean;
import com.techNarayana.ejobzz.dto.JobSeekerEducationDetailsDTO;
import com.techNarayana.ejobzz.dto.JobSeekerExperienceDTO;
import com.techNarayana.ejobzz.dto.JobSeekerLanguageDTO;
import com.techNarayana.ejobzz.dto.JobSeekerSkillsDTO;
import com.techNarayana.ejobzz.dto.JobseekerRegisterDTO;
import com.techNarayana.ejobzz.exception.DAOException;
import com.techNarayana.ejobzz.service.CompanyService;
import com.techNarayana.ejobzz.service.JobSeekerRegisterService;
import com.techNarayana.ejobzz.util.EmailAPI;
import com.techNarayana.ejobzz.util.FilePath;

@Component
public class JobSeekerRegisterControllerHelper {
	@Autowired
	JobSeekerRegisterService service;
	@Autowired 
	CompanyService companyService;
	@Autowired
	FilePath filePath;
	@Autowired
	EmailAPI emailAPI;
	
	
	public int countEmployerSubscriptionsBasedOnType(Set<EmployerSubscriptionDomain> subset) {
		int count=0;
		for (EmployerSubscriptionDomain employerSubscriptionDomain : subset) {
			count += employerSubscriptionDomain.getQuantity();
		}
		return count;
	}
	
	public String renameFile(String name) {
		Integer maxId = service.maxId();
		String nameExtArr[] = name.split("\\.");
		if (maxId == null)
			maxId = 0;
		maxId++;
		return maxId.toString().concat("." + nameExtArr[1]);
	}

	public String renameExistFile(String name,Integer maxId,String Path) {
		File index = new File(filePath.getResumePath()+Path);
		if(index.exists()){
			index.delete();
			System.out.println("file deleted");
		}
		String nameExtArr[] = name.split("\\.");
		if (maxId == null)
			maxId = 0;

		return maxId.toString().concat("." + nameExtArr[1]);
	}

	public JobseekerRegisterDomain createJobseekerRegister(JobseekerRegisterDTO dto){
		JobseekerRegisterDomain register = null;
		try {
			MultipartFile file1=dto.getProfilePicPath();
			MultipartFile file2=dto.getResumePath();
			register = new JobseekerRegisterDomain();
			InputStream inputStream = null;
			OutputStream outputStream = null;
			String name1 = file1.getOriginalFilename();
			String fileName1 = null;
			String name2 = file2.getOriginalFilename();
			String fileName2 = null;
			String foldername1="profilepic";
			String foldername2="resume";


			String excludeProperties[]={"profilePicPath","resumePath"};
			BeanUtils.copyProperties(dto, register,excludeProperties);

			if(name1.isEmpty() || name1==null){

			}
			else if(!name1.isEmpty() && name1!=null){
				fileName1 = renameFile(name1);
				fileName1=transferFiles(fileName1, name1, inputStream, outputStream, file1,foldername1);
				register.setProfilePicPath(fileName1);
			}
			if(name2.length() ==0 ||name2==null){

			}else if(!name2.isEmpty() && name2!=null){
				fileName2 = renameFile(name2);
				fileName2=transferFiles(fileName2, name2, inputStream, outputStream, file2,foldername2);


				register.setResumePath(fileName2);

			}
			
			service.createRegister(register);
			try {
				emailAPI.sendHTMLMail(dto.getEmail(),dto.getEmail(), "EJobzz Registereration Mail","<h1>Congratualtions! Successfully Registred to Ejobzz</h1><br/><br/><font size='0.5'>Disclaimer:Technarayana pvt ltd neither guarantees nor offers any warranty about the credentials of the offer. The responsibility of checking the authenticity of offers/correspondence lies with you. If you consider the content of this email inappropriate or spam, you may: Report abuse by forwarding this email to: compliance@ejobzz.com Advisory: Please do not pay any money to anyone who promises to find you a job. This could be in the form of a registration fee, or document processing fee or visa charges or any other pretext. The money could be asked for upfront or it could be asked after trust has been built after some correspondence has been exchanged. Also please note that in case you get a job offer or a letter of intent without having been through an interview process it is probably a scam and you should contact compliance@ejobzz.com for advise.</font>" );
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			
			
		} catch (ConstraintViolationException e) {
			
			e.printStackTrace();
		} catch (BeansException e) {
			
			e.printStackTrace();
		}
		
		return register;

	}
	public String updateProfilepic(JobseekerRegisterDTO dto,MultipartFile file,String path){

		dto.setProfilePicPath(file);
		MultipartFile file1=dto.getProfilePicPath();


		InputStream inputStream = null;
		OutputStream outputStream = null;
		String name1 = file1.getOriginalFilename();
		String fileName1 = null;
		String foldername1="profilepic";
		Integer maxId=dto.getJsid();

		if(name1.isEmpty() || name1==null){

		}
		else{
			fileName1 = renameExistFile(name1,maxId,path);
			System.out.println("saghfcjdgashfjg"+fileName1);
			fileName1=transferFiles(fileName1, name1, inputStream, outputStream, file1,foldername1);
			service.updateProfilepic(dto,fileName1);
		}

		return fileName1;
	}

	public boolean findWordIntoResume(String resume,String word){
		
		String ext = FilenameUtils.getExtension(resume);
		String st="";
		if(ext.equalsIgnoreCase("docx")){
			st=extractTextFromDocx(resume);
		}else if(ext.equalsIgnoreCase("doc")){
			st=Extractfromdoc(resume);
		}else if(ext.equalsIgnoreCase("pdf")){
			st=PdfToString(resume);

		}
		
		return st.toLowerCase().contains(word.toLowerCase());
		
		// displayText.
		
	}
	public String Extractfromdoc(String resume){
		System.out.println("resume : "+ resume);
		System.out.println("filePath.getResumePath() : "+ filePath.getResumePath());
		FileInputStream fis;
		HWPFDocument document = null;
		try {
			fis = new FileInputStream(filePath.getResumePath()+""+resume);
			document = new HWPFDocument(fis);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {}


		@SuppressWarnings("resource")
		WordExtractor extractor = new WordExtractor(document);
		String rawText = extractor.getText();

		
		@SuppressWarnings("static-access")
		String displayText = extractor.stripFields(rawText);
		
		return displayText;
	}
	
	public String extractTextFromDocx(String resume)  {
		FileInputStream fis = null;
		XWPFDocument doc = null;
		try {
			fis = new FileInputStream(filePath.getResumePath()+""+resume);
			doc = new XWPFDocument(fis);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		@SuppressWarnings("resource")
		XWPFWordExtractor ex = new XWPFWordExtractor(doc);
		String text = ex.getText();
		return text;
	}
	public String transferFiles( String filename,String name,InputStream inputStream,OutputStream outputStream,MultipartFile file,String folderName){

		try {

			inputStream = file.getInputStream();

			File newFile = new File(
					filePath.getResumePath()+folderName);
			
			if (!newFile.exists())
				newFile.mkdir();
			newFile = new File(newFile, filename);
			if (!newFile.exists()) {
				newFile.createNewFile();
			}
			
			outputStream = new FileOutputStream(newFile);
			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);

			}
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}



		return filename;
	}

	public JobseekerRegisterDomain getJobseekerRegister(int id) {
		return service.getJobseekerRegister(id);

	}

	public JobseekerRegisterDTO updateEducationandExperiencedetails(JobseekerRegisterDTO dto,JobseekerRegisterDomain dt,String jseid,String jeid) {

		if(dto.getSkills()!=null){
			HashSet<JobSeekerSkillsDomain>dom=getSkills(dto);
			dt.setSdomain(dom);
		}
		if(dto.getLan()!=null){
			/*HashSet<JobSeekerSkillsDomain>dom=getSkills(dto);*/
			ArrayList<JobSeekerLanguageDomain>doms=getlanguage(dto);
			dt.setLang(doms);
		}
		return service.updateEducationandExperiencedetails(dto,dt,jseid,jeid);
	}


	public JobseekerRegisterDTO findUser(String email, String password)throws DAOException {

		return service.findUser(email,password);
	}

	public List<Integer> getYears(){
		List<Integer> lst=new ArrayList<Integer>();
		int year = Calendar.getInstance().get(Calendar.YEAR);

		for(int i=year;i>year-46;i--){

			lst.add(i);

		}
		return lst;
	}
	public List<Integer> getMonth(){
		List<Integer> lst=new ArrayList<Integer>();
		

		for (int i = 0; i <12; i++) {

			lst.add(i);

		}
		return lst;
	}
	public HashMap<Integer, String> getMonths(){

		HashMap<Integer, String> MonthDetails = new HashMap<Integer, String>();

		String[] months = new DateFormatSymbols().getShortMonths();
		for (int i = 0; i <12; i++) {
			String month = months[i];

			MonthDetails .put(i, month);
		}

		return MonthDetails;
	}
	public List<Integer> getsalaryInlackhs(){
		List<Integer> lst=new ArrayList<Integer>();

		for(int i=0;i<=50;i++){

			lst.add(i);

		}
		return lst;
	}
	public List<Integer> getInteger(){
		List<Integer> lst=new ArrayList<Integer>();

		for(int i=0;i<=50;i++){

			lst.add(i);
		}
		return lst;
	}
	public List<Integer> getsalaryInThousands(){
		List<Integer> lst=new ArrayList<Integer>();

		for(int i=0;i<100;){

			lst.add(i);
			i=i+5;

		}
		return lst;
	}

	//get the resume name from database
	public String []  resumePath(int id){
		//return service.getresumePath(id);
		String st[]=service.getresumePath(id);
		return st;
	}
	//converting doc resume into html string
	public String WordDocToHtmlConverter(String Resume){
		HWPFDocumentCore wordDocument = null;
		try {
			//here resume will be resume="resume\\"+resumename
			File f=new File(filePath.getResumePath()+Resume);
			if(f.exists())
				wordDocument = WordToHtmlUtils.loadDoc(new FileInputStream(f));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		WordToHtmlConverter wordToHtmlConverter = null;

		try {
			wordToHtmlConverter = new WordToHtmlConverter(
					DocumentBuilderFactory.newInstance().newDocumentBuilder()
					.newDocument());
			System.out.println(wordDocument.getDocumentText());
			wordToHtmlConverter.processDocument(wordDocument);
		} catch (ParserConfigurationException e) {
			
			e.printStackTrace();
		}
		
		Document htmlDocument = wordToHtmlConverter.getDocument();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		DOMSource domSource = new DOMSource(htmlDocument);
		StreamResult streamResult = new StreamResult(out);

		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer serializer = null;
		try {
			serializer = tf.newTransformer();
		} catch (TransformerConfigurationException e) {
			
			e.printStackTrace();
		}
		serializer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		serializer.setOutputProperty(OutputKeys.INDENT, "yes");
		serializer.setOutputProperty(OutputKeys.METHOD, "html");
		try {
			serializer.transform(domSource, streamResult);
		} catch (TransformerException e) {
			
			e.printStackTrace();
		}
		try {
			out.close();

		} catch (IOException e) {
			
			e.printStackTrace();
		}

		String result = new String(out.toByteArray());
		
		
		System.out.println(result);
		if(result.length()>=1){
			return result.replaceAll("font-size:[0-9]{0,4}pt", "font-size:10pt");

		}
		else{
			return result="";
		}
	}


	//convering DOCX to html string
	public String WordDocxToHtml(String Resume){
		InputStream in = null;
		XWPFDocument document = null;
		try {
			in = new FileInputStream(new File(filePath.getResumePath()+""+Resume));
			document = new XWPFDocument(in);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}catch (IOException e) {
			
			e.printStackTrace();
		}


		XHTMLOptions options = XHTMLOptions.create().URIResolver(new FileURIResolver(new File("word/media")));

		OutputStream out = new ByteArrayOutputStream();


		try {
			XHTMLConverter.getInstance().convert(document, out, options);
		} catch (XWPFConverterException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		String html=out.toString();


		if(html.length()>=0){
			html=html.replaceAll("margin\\-left+\\:[0-9]{0,4}\\.[0-9]{0,4}pt", "margin-left:0.0pt").replaceAll("margin\\-right+\\:[0-9]{0,4}\\.[0-9]{0,4}pt", "margin-right:00.0pt").replaceAll("width\\:[0-9]{0,4}\\.[0-9]{0,4}pt", "width:560pt").replaceAll("margin\\-top+\\:[0-9]{0,4}\\.[0-9]{0,4}pt", "margin-top:0.0pt").replaceAll("margin\\-bottom+\\:[0-9]{0,4}\\.[0-9]{0,4}pt", "margin-bottom:0.0pt");
			return html;}
		else{
			return html="";
		}
	}
	public String checkAndConvertFile(String resumeName,String resumepath){
		String ext = FilenameUtils.getExtension(resumeName);
		String st="";
		if(ext.equalsIgnoreCase("docx")){
			st=WordDocxToHtml(resumepath);
		}else if(ext.equalsIgnoreCase("doc")){
			st=WordDocToHtmlConverter(resumepath);	
		}else if(ext.equalsIgnoreCase("pdf")){
			st=PdfToString(resumepath);

		}else if(ext.equalsIgnoreCase("")){

		}

		return st;

	}

	//convering PDF to html string
	public String PdfToString(String res){
		String	fileName=filePath.getResumePath()+res;
		PDFParser parser;
		String parsedText = null;
		PDFTextStripper pdfStripper = null;
		PDDocument pdDoc = null;
		COSDocument cosDoc = null;
		File file = new File(fileName);
		if (!file.isFile()) {
			System.err.println("File " + fileName + " does not exist.");
			return null;
		}
		try {
			parser = new PDFParser(new FileInputStream(file));
		} catch (IOException e) {
			System.err.println("Unable to open PDF Parser. " + e.getMessage());
			return null;
		}
		try {
			parser.parse();
			cosDoc = parser.getDocument();
			pdfStripper = new PDFTextStripper();
			pdDoc = new PDDocument(cosDoc);
			parsedText = pdfStripper.getText(pdDoc);
		} catch (Exception e) {
			System.err
			.println("An exception occured in parsing the PDF Document."
					+ e.getMessage());
		} finally {
			try {
				if (cosDoc != null)
					cosDoc.close();
				if (pdDoc != null)
					pdDoc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		parsedText=toHtml(parsedText);
		if(parsedText.length()>=1){
			return parsedText.replaceAll("\\?", "");
		}else{
			return parsedText="";	
		}
	}

	public static String toHtml( String string )
	{


		BufferedReader st = new BufferedReader( new StringReader( string ) );
		StringBuffer buf = new StringBuffer( "<html><body>" );

		try
		{
			String str = st.readLine();

			while( str != null )
			{
				if( str.equalsIgnoreCase( "<br/>" ) )
				{
					str = "<br>";
				}

				buf.append( str );

				if( !str.equalsIgnoreCase( "<br>" ) )
				{
					buf.append( "<br>" );
				}

				str = st.readLine();
			}
		}
		catch( IOException e )
		{
			e.printStackTrace();
		}

		buf.append( "</body></html>" );
		string = buf.toString();
		return string;
	}
	public JobseekerRegisterDTO updateprofileDetails(JobseekerRegisterDTO dt,
			JobseekerRegisterDTO dto,String []paths) {
		dto.setName(dt.getName());
		dto.setEmail(dt.getEmail());
		dto.setLocation(dt.getLocation());
		dto.setJobIntrestLocations(dt.getJobIntrestLocations());
		dto.setContactNo(dt.getContactNo());
		dto.setDob(dt.getDob());
		dto.setGender(dt.getGender());
		dto.setCity(dt.getCity());
		dto.setPin(dt.getPin());
		dto.setResumeTitle(dt.getResumeTitle());
		dto.setKeySkills(dt.getKeySkills());
		dto.setTotalExp(dt.getTotalExp());

		dto.setEdto(dto.getEdto());


		service.updateprofileDetails(dto,paths);
		return dto;


	}


	public JobseekerRegisterDTO updateResume(JobseekerRegisterDTO dto, MultipartFile file,String path) {

		Integer jsid=dto.getJsid();
		dto.setProfilePicPath(file);
		MultipartFile file1=dto.getProfilePicPath();
		InputStream inputStream = null;
		OutputStream outputStream = null;
		String name1 = file1.getOriginalFilename();
		String fileName1 = null;
		String foldername1="resume";
		fileName1 = renameExistFile(name1,jsid,path);
		if(name1.isEmpty() || name1==null){

		}
		else{
			fileName1=transferFiles(fileName1, name1, inputStream, outputStream, file1,foldername1);
		}
		service.updateResume(dto,fileName1);
		return dto;

	}

	public String ConvertJavaDateintoStringDate(Date d){
		DateFormat df = new SimpleDateFormat("MMM dd yyyy");

		String reportDate="";
		if(d!=null ){
			reportDate = df.format(d);
		}
		else{
			reportDate="";
		}
		// Print what date is today!
		System.out.println("Report Date: " + reportDate);
		return reportDate;
	}
	public JobseekerRegisterDomain deleteResume(int jsid,String path) {


		boolean b=DeleteresumeFile(filePath.getResumePath()+"resume\\"+path);
		JobseekerRegisterDomain dom=null;

		if(b){
			dom=service.deleteResume(jsid);
			System.out.println("resume deleted");
		}

		return dom;


	}
	public boolean DeleteresumeFile(String Path) {
		File index = new File(filePath.getResumePath()+Path);

		if(index.exists()){
			index.delete();
			return true;
		}
		return false;

	}
	public int [] diffbwdates(JobSeekerExperienceDomain edto){
		int diffMonth = 0;
		int yea = 0;
		int mont = 0;



		Calendar startCalendar = null;
		Calendar endCalendar = null;

		try {
			Integer month1=edto.getJoinedmonth();
			Integer year1=edto.getJoinedyear();

			Integer month2=edto.getEndingmonth();
			Integer year2=edto.getEndingyear();
			System.out.println(month1+"MONTH"+month2+"YEAR"+year1+""+year2);
			Calendar calendar = Calendar.getInstance();
			if(month1!=null || year1!=null){

				calendar.clear();
				calendar.set(Calendar.MONTH, month1);
				calendar.set(Calendar.YEAR, year1);

			}
			Date date1 = calendar.getTime();
			if(month2!=null || year2!=null){
				calendar.set(Calendar.MONTH, month2);
				calendar.set(Calendar.YEAR, year2);
			}
			Date date2 = calendar.getTime();
			startCalendar = new GregorianCalendar();
			startCalendar.setTime(date1);

			endCalendar = new GregorianCalendar();
			endCalendar.setTime(date2);

			int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
			diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);

			yea = diffMonth/12;
			mont = diffMonth%12;
		} catch (Exception e) {

			e.printStackTrace();
		}
		int st[]={yea,mont};

		return st;
	}

	public HashSet<JobSeekerSkillsDomain> getSkills(JobseekerRegisterDTO dto){
		JobSeekerSkillsDTO jsdto=dto.getSkills();

		List<String> skills=Arrays.asList(jsdto.getSkillName().split(","));
		List<String> version=Arrays.asList(jsdto.getVersion().split(",",skills.size()));

		List<String> expyears=Arrays.asList(jsdto.getExpyears().split(",",skills.size()));
		List<String> expmonths=Arrays.asList(jsdto.getExpmonths().split(",",skills.size()));

		List<String> lastused=Arrays.asList(jsdto.getLastused().split(",",skills.size()));
		HashSet<JobSeekerSkillsDomain> dom=new HashSet<JobSeekerSkillsDomain>();
		for(int i=0;i<skills.size();i++){

			JobSeekerSkillsDomain jb=new JobSeekerSkillsDomain();


			if(skills.get(i).equals("")){
				jb.setSkillName("");
			}else{
				jb.setSkillName(skills.get(i));
			}
			if(skills.get(i).equals("")){
				jb.setVersion("");
			}else{

				jb.setVersion(version.get(i));
			}
			if(skills.get(i).equals("")){
				jb.setExpyears("0");
			}else{

				jb.setExpyears(expyears.get(i));
			}
			if(skills.get(i).equals("")){
				jb.setExpmonths("0");
			}else{

				jb.setExpmonths(expmonths.get(i));	
			}
			if(skills.get(i).equals("")){
				jb.setLastused("");
			}else{

				jb.setLastused(lastused.get(i));
			}


			dom.add(jb);
		}

		return dom;
	}
	public ArrayList<JobSeekerLanguageDomain> getlanguage(JobseekerRegisterDTO dto){
		JobSeekerLanguageDTO jsdto=dto.getLan();

		List<String> skills=Arrays.asList(jsdto.getLangname().split(","));
		
		List<String> version=Arrays.asList(jsdto.getProfeciency().split(",",skills.size()));

		List<String> expyears=Arrays.asList(jsdto.getLread().split(",",skills.size()));
		List<String> expmonths=Arrays.asList(jsdto.getLwrite().split(",",skills.size()));

		List<String> lastused=Arrays.asList(jsdto.getLspeak().split(",",skills.size()));
		ArrayList<JobSeekerLanguageDomain> dom=new ArrayList<JobSeekerLanguageDomain>();
		for(int i=0;i<skills.size();i++){

			JobSeekerLanguageDomain jb=new JobSeekerLanguageDomain();



			if(skills.get(i).equals("")){
				jb.setLangname("");
			}else{
				jb.setLangname(skills.get(i));
			}
			if(skills.get(i).equals("")){
				jb.setProfeciency("");
			}else{

				jb.setProfeciency(version.get(i));
			}

			if(skills.get(i).equals("")){
				jb.setLread("");
			}else{

				jb.setLread(expyears.get(i));
			}
			if(skills.get(i).equals("")){
				jb.setLwrite("");
			}else{

				jb.setLwrite(expmonths.get(i));
			}

			if(skills.get(i).equals("")){
				jb.setLspeak("");
			}else{

				jb.setLspeak(lastused.get(i));
			}

			dom.add(jb);
		}

		return dom;
	}
	public HashSet<JobSeekerSkillsDTO> getjobskillsFromData(JobseekerRegisterDomain dom){
		HashSet<JobSeekerSkillsDTO> skdto = new HashSet<JobSeekerSkillsDTO>();
		Set<JobSeekerSkillsDomain> skdom=dom.getSdomain();
		for (JobSeekerSkillsDomain jobSeekerSkillsDomain : skdom) {
			JobSeekerSkillsDTO sdto=new JobSeekerSkillsDTO();
			BeanUtils.copyProperties(jobSeekerSkillsDomain, sdto,new String []{"skill"});

			skdto.add(sdto);

		}

		return skdto;


	}

	public List<JobSeekerLanguageDTO> getjobsLangDetails(JobseekerRegisterDomain dom){
		List<JobSeekerLanguageDTO> landto = new ArrayList<JobSeekerLanguageDTO>();
		Set<JobSeekerLanguageDomain>landom=new HashSet<JobSeekerLanguageDomain>(dom.getLang());
		List<JobSeekerLanguageDomain> lst=new ArrayList<JobSeekerLanguageDomain>(landom);

		for (JobSeekerLanguageDomain jobSeekerLanguageDomain : lst) {
			JobSeekerLanguageDTO ldto=new JobSeekerLanguageDTO();
			BeanUtils.copyProperties(jobSeekerLanguageDomain, ldto,new String [] {"language"});
			System.out.println(jobSeekerLanguageDomain.toString()+"fetching Jobseeker language detailas");
			landto.add(ldto);
		}

		return landto;


	}
	public HashSet<JobSeekerSkillsDTO> getjobskills(JobseekerRegisterDomain dom){
		HashSet<JobSeekerSkillsDTO> skdto = new HashSet<JobSeekerSkillsDTO>();
		Set<JobSeekerSkillsDomain> skdom=dom.getSdomain();
		for (JobSeekerSkillsDomain jobSeekerSkillsDomain : skdom) {
			JobSeekerSkillsDTO sdto=new JobSeekerSkillsDTO();

			sdto.setSkillId(jobSeekerSkillsDomain.getSkillId());

			if(jobSeekerSkillsDomain.getSkillName().equals("")){
				sdto.setSkillName("<font color='red'>Not Mentioned</font>");
			}
			else{
				sdto.setSkillName(jobSeekerSkillsDomain.getSkillName());
			}
			if(jobSeekerSkillsDomain.getVersion().equals("")){
				sdto.setVersion("<font color='red'>Not Mentioned</font>");
			}
			else{
				sdto.setVersion(jobSeekerSkillsDomain.getVersion());
			}
			if(jobSeekerSkillsDomain.getLastused().equals("")){
				sdto.setLastused("<font color='red'>Not Mentioned</font>");
			}
			else{
				sdto.setLastused(jobSeekerSkillsDomain.getLastused());
			}

			if(jobSeekerSkillsDomain.getExpyears().equals("")){
				sdto.setExpyears("<font color='red'>Not Mentioned</font>");
			}
			else{
				sdto.setExpyears(jobSeekerSkillsDomain.getExpyears());
			}

			if(jobSeekerSkillsDomain.getExpmonths().equals("")){
				sdto.setExpmonths("<font color='red'>Not Mentioned</font>");
			}
			else{
				sdto.setExpmonths(jobSeekerSkillsDomain.getExpmonths());
			}



			System.out.println(sdto.toString()+"SKILLS ");
			skdto.add(sdto);
		}

		return skdto;
	}
	public HashSet<JobSeekerSkillsDomain> getSkillsDto(JobseekerRegisterDTO dto){
		JobSeekerSkillsDTO jsdto=dto.getSkills();


		List<String> skillId=Arrays.asList(jsdto.getSkilid().split(","));

		List<String> skills=Arrays.asList(jsdto.getSkillName().split(",",skillId.size()));
		List<String> version=Arrays.asList(jsdto.getVersion().split(",",skillId.size()));

		List<String> expyears=Arrays.asList(jsdto.getExpyears().split(",",skillId.size()));
		List<String> expmonths=Arrays.asList(jsdto.getExpmonths().split(",",skillId.size()));

		List<String> lastused=Arrays.asList(jsdto.getLastused().split(",",skillId.size()));
		HashSet<JobSeekerSkillsDomain> dom=new HashSet<JobSeekerSkillsDomain>();
		for(int i=0;i<skills.size();i++){

			JobSeekerSkillsDomain jb=new JobSeekerSkillsDomain();

			jb.setSkillId(Integer.valueOf(skillId.get(i)));
			if(skills.get(i).equals("")){
				jb.setSkillName("");
			}else{
				jb.setSkillName(skills.get(i));
			}
			if(skills.get(i).equals("")){
				jb.setVersion("");
			}else{

				jb.setVersion(version.get(i));
			}
			jb.setExpyears(expyears.get(i));
			jb.setExpmonths(expmonths.get(i));
			jb.setLastused(lastused.get(i));

			dom.add(jb);
		}
		return dom;

	}


	public ArrayList<JobSeekerLanguageDTO> getlanguages(JobseekerRegisterDomain dom){
		ArrayList<JobSeekerLanguageDTO> skdto = new ArrayList<JobSeekerLanguageDTO>();
		Set<JobSeekerLanguageDomain>landom=new HashSet<JobSeekerLanguageDomain>(dom.getLang());
		List<JobSeekerLanguageDomain> lst=new ArrayList<JobSeekerLanguageDomain>(landom);

		for (JobSeekerLanguageDomain jobSeekerLangDomain : lst) {
			JobSeekerLanguageDTO sdto=new JobSeekerLanguageDTO();

			sdto.setJlid(jobSeekerLangDomain.getJlid());

			if(jobSeekerLangDomain.getLangname().equals("")){
				sdto.setLangname("<font color='red'>Not Mentioned</font>");
			}
			else{
				sdto.setLangname(jobSeekerLangDomain.getLangname());
			}
			if(jobSeekerLangDomain.getProfeciency().equals("")){
				sdto.setProfeciency("<font color='red'>Not Mentioned</font>");
			}
			else{
				sdto.setProfeciency(jobSeekerLangDomain.getProfeciency());
			}
			if(jobSeekerLangDomain.getLread().equals("Yes")){
				sdto.setLread("<img src='images/Right.png' />");
			}
			else{
				sdto.setLread("<img src='images/images.png' />");
			}
			/*<center><img src="images/Right.png" /></center>*/
			if(jobSeekerLangDomain.getLwrite().equals("Yes")){
				sdto.setLwrite("<img src='images/Right.png' />");
			}
			else{
				sdto.setLwrite("<img src='images/images.png' />");
			}

			if(jobSeekerLangDomain.getLspeak().equals("Yes")){
				sdto.setLspeak("<img src='images/Right.png' />");
			}
			else{
				sdto.setLspeak("<img src='images/images.png' />");
			}



			System.out.println(sdto.toString()+"SKILLS ");
			skdto.add(sdto);
		}

		return skdto;
	}
	public ArrayList<JobSeekerLanguageDomain> getLangDto(JobseekerRegisterDTO dto){
		JobSeekerLanguageDTO jsdto=dto.getLan();


		System.out.println(jsdto.toString()+"Aaaaaaa");
		//	BeanUtils.copyProperties(j, target);
		List<String> skillId=Arrays.asList(jsdto.getLid().split(","));

		List<String> skills=Arrays.asList(jsdto.getLangname().split(",",skillId.size()));
		List<String> version=Arrays.asList(jsdto.getProfeciency().split(",",skillId.size()));

		List<String> expyears=Arrays.asList(jsdto.getLread().split(",",skillId.size()));
		List<String> expmonths=Arrays.asList(jsdto.getLwrite().split(",",skillId.size()));

		List<String> lastused=Arrays.asList(jsdto.getLspeak().split(",",skillId.size()));
		ArrayList<JobSeekerLanguageDomain> dom=new ArrayList<JobSeekerLanguageDomain>();
		for(int i=0;i<skills.size();i++){

			JobSeekerLanguageDomain jb=new JobSeekerLanguageDomain();

			jb.setJlid((Integer.valueOf(skillId.get(i))));
			if(skills.get(i).equals("")){
				jb.setLangname("");
			}else{
				jb.setLangname(skills.get(i));
			}
			if(skills.get(i).equals("")){
				jb.setProfeciency("");
			}else{

				jb.setProfeciency(version.get(i));
			}

			if(skills.get(i).equals("")){
				jb.setLread("");
			}else{

				jb.setLread(expyears.get(i));
			}
			if(skills.get(i).equals("")){
				jb.setLwrite("");
			}else{

				jb.setLwrite(expmonths.get(i));
			}

			if(skills.get(i).equals("")){
				jb.setLspeak("");
			}else{

				jb.setLspeak(lastused.get(i));
			}


			dom.add(jb);
		}
		return dom;

	}
	public JobseekerRegisterDomain updateJobskills(JobseekerRegisterDomain dom) {
		return service.updateJobskills(dom);

	}
	public JobseekerRegisterDomain updateLanguage(JobseekerRegisterDomain dom) {
		return service.updateLanguage(dom);

	}
	public void deleteSkills(Integer id) {
		service.deleteSkills(id);

	}

	public JobseekerRegisterDomain updateExperienceDetails(JobseekerRegisterDomain dom,
			JobSeekerExperienceDTO expDTO) {



		JobseekerRegisterDomain regdom=service.updateExperienceDetails(dom,expDTO);
		return regdom;
	}

	public void createNewEmployer(JobseekerRegisterDomain dom,JobseekerRegisterDTO dto) {
		service.createNewEmployer(dom,dto);

	}

	public void deleteEmployer(Integer id) {

		service.deleteEmployer(id);
	}

	public JobSeekerEducationDetailsDomain editEducation(Integer eid) {
		return service.editEducation(eid);
	}

	public void UpdateEducation(JobSeekerEducationDetailsDTO dt,JobseekerRegisterDomain dom) {
		service.UpdateEducation(dt,dom);

	}

	public void saveEducation(JobSeekerEducationDetailsDTO dto,JobseekerRegisterDomain dom) {
		service.saveEducation(dto,dom);

	}

	public void deleteEducation(Integer id) {
		service.deleteEducation(id);

	}

	public void ChangePassword(String encrypt, Integer jsid) {

		service.ChangePassword(encrypt,jsid);
	}

	public boolean checkUserEmail(String userName){
		return service.checkUserEmail(userName);
	}
	public boolean checkUser(String userName, String password) {
		// TODO Auto-generated method stub
		return service.checkUser(userName,password);
	}

	public Boolean CheckUserEdu(String etype,Integer userid) {
		// TODO Auto-generated method stub
		return service.CheckUserEdu( etype, userid);
	}




	public List<JobResponseBean> iterate(String city,List<JobDomain> listJobBasedOncity ){

		List<JobResponseBean> jobResponseBeanList = new ArrayList<JobResponseBean>();
		for (JobDomain jobDomain : listJobBasedOncity) {

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
			jobResponseBeanList.add(jobResponseBean);
		}
		return jobResponseBeanList;
	}

	public List<JobResponseBean> getJobsByskill(String city) {
		List<JobDomain>listJobBasedOncity=service.getJobsByskill( city);
		return iterate(city,listJobBasedOncity);

	}
	public List<JobResponseBean> GetJobsByDesignation(String design) {
		List<JobDomain>listJobBasedOncity=service.GetJobsByDesignation( design);
		return iterate(design,listJobBasedOncity);

	}

	public List<JobResponseBean> getJobsBycity(String city) {
		List<JobDomain>listJobBasedOncity=service.getJobsBycity( city);
		return iterate(city,listJobBasedOncity);

	}

	
	public JobSeekerExperienceDomain getJobseekerRegisterDomain(Integer jsid) {
		JobSeekerExperienceDomain dom = service.getJobseekerRegisterDomain(jsid);
		String company="";
		String designation="";
		Integer sallackh=0;
		Integer sallthousand=0;
		if(dom!=null){
			
			 company=dom.getCompanyName();
			 designation=dom.getDesignation();
			 sallackh=dom.getCurrentsalLackh();
			 sallthousand=dom.getCurrentsalThousand();
			if(company!=null && !company.isEmpty()){
				dom.setCompanyName(company);
			}
			if(designation!=null && !designation.isEmpty()){
				dom.setDesignation(designation);
			}
			if(sallackh!=null){
				dom.setCurrentsalLackh(sallackh);
			}
			if(sallthousand!=null){
				dom.setCurrentsalThousand(sallthousand);
			}
		}else{
			 dom = new JobSeekerExperienceDomain();
			dom.setCompanyName("<font color='red'> Not mentioned</font>");
			dom.setDesignation("<font color='red'> Not mentioned</font>");
			dom.setCurrentsalLackh(sallackh);
			dom.setCurrentsalThousand(sallthousand);
		}
		
		return dom;
	}

	public void deletelanguage(Integer id) {
		service.deletelanguage(id);

	}

	public String findUser(String userName) {
		return service.findUser(userName);
		
	}

	public JobseekerRegisterDTO getJobseekerDomain(JobseekerRegisterDTO dto) {
	return service.getJobseekerDomain(dto);
		
	}
}
