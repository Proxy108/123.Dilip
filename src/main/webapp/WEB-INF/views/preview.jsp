<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="css/style2.css" />
<link rel="stylesheet"href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"/>
<jsp:useBean id="monthNames" class="java.text.DateFormatSymbols" />
<c:set value="${monthNames.months}" var="months" />
<title>${jobSeeker.name}</title>
</head>

<body>
<div class="wrap">
<div class="logo">
<img src="images/logo5.jpg" />
</div>


<div class="help">
<h2>Recruiter Helpline</h2>
<h4>1800 102 5558 | 0120-4960600</h4>
</div><br/><br/><br/><br/>
<c:if test="${not empty msg}">
<div class="alert alert-danger">${msg}</div>
</c:if>
<div class="main-details">

<div class="left">
<h4>${jobSeeker.name}</h4><br />
<p style="margin-top:60px">${jobSeeker.resumeTitle}</p>
</div>

<div class="right">
<div style="color: #0079d0;float: left;background:#ccc; padding:5px; background-position: 0 -194px; margin-right: 5px; font-weight: bold; cursor: pointer;"><a href="contact.do"> Send Mail </a> </div>
 <img src="${jobSeeker.profilePicPath}" width="50%"  style="float:right"/>
</div>

</div>

<div class="main-details">
<div class="left">
<c:forEach items="${jobSeeker.domain}" var="expDomain">
	<c:if test="${fn:contains(expDomain.employeeType, 'C')}">
 <P>Current Designation: ${expDomain.designation}</P>
<p>Current Company: ${expDomain.companyName}</p>
</c:if></c:forEach>
<p>Current Location:${jobSeeker.location}</p>
<p>Pref. Location: ${jobSeeker.jobIntrestLocations}</p>
<p>Date of Birth :${jobSeeker.dob}</p>
<p>Gender :${jobSeeker.gender}</p>
<p>Key Skills:${jobSeeker.keySkills}</p>
<p><i class="fa fa-phone"></i>&nbsp;&nbsp;Phone Number:</p>   
<p><i class="fa fa-envelope"></i>&nbsp;&nbsp;Email Id:</p>

</div>

<div class="right">
<p>Total Experience: ${jobSeeker.totalExp}</p>

<c:forEach items="${jobSeeker.domain}" var="expDomain">
	<c:if test="${fn:contains(expDomain.employeeType, 'C')}">
	
		<p>Annual Salary: ${empty expDomain.currentsalLackh ? '0' : expDomain.currentsalLackh } Lac(s) ${empty expDomain.currentsalThousand ? '0' : expDomain.currentsalThousand}  Thousand(s)</p>
	<p>Industry Type: ${expDomain.industryType}</p>	
	</c:if>
</c:forEach>


<c:forEach items="${jobSeeker.edomain}" var="eduDomain">

<c:if test="${fn:contains(eduDomain.etype, 'F')}">
	<p>Highest Degree: ${eduDomain.ename}</p>
	
</c:if>
</c:forEach>


<p>Address: ${jobSeeker.address} </p>
</div>



</div>


 <div class="content" style="text-transform: capitalize;">
<h4>Work Experience</h4><br />
<c:forEach items="${jobSeeker.domain}" var="expDomain">
<c:set var="jmon" value="${expDomain.joinedmonth}" />
<c:set var="emon" value="${expDomain.endingmonth}" />
<li style="font-size:90% !important;"><p style="font-size:90% !important;"><b > ${expDomain.companyName}  </b> as ${expDomain.designation}</p></li>
<p style="font-size:90% !important;">${months[jmon]}  ${expDomain.joinedyear}   to ${months[emon]} ${expDomain.endingyear}</p><br/>
<p style="font-size:90% !important;">  ${expDomain.jobProfileDesc}   </p><br/>
</c:forEach>

</div>

<div class="content" style="text-transform: capitalize;">
<h4>Education Details</h4><br />
<c:forEach items="${jobSeeker.edomain}" var="eduDomain">


<p style="font-size:90% !important;">${eduDomain.etype}:  ${eduDomain.ename} (${eduDomain.specialization} ) from ${eduDomain.university}  in ${eduDomain.graduateYear} </p><br/>
</c:forEach>

</div>
 
<div class="lang">

<div class="table">
	<div class="block1"> 
	<h5>Skill Name</h5>
	<c:forEach items="${jobSeeker.sdomain}" var="skillDomain">
		<p>${skillDomain.skillName}</p>
	
	</c:forEach>
</div>
<div class="block1"> 
	<h5>Version</h5>
	<c:forEach items="${jobSeeker.sdomain}" var="skillDomain">
		<p>${skillDomain.version}</p>
		
	</c:forEach>
</div>
<div class="block1"> 
	<h5>Last Used</h5>
	<c:forEach items="${jobSeeker.sdomain}" var="skillDomain">
		<p>${skillDomain.lastused}</p>
	
	</c:forEach>
</div>
<div class="block1"> 
	<h5>Last Used</h5>
	<c:forEach items="${jobSeeker.sdomain}" var="skillDomain">
		<p>${skillDomain.expyears} years(s) ${skillDomain.expmonths} month(s)</p>
	
	</c:forEach>
</div>
</div>





</div>

<div class="lang">
<h4>Languages Known</h4>
<div class="table">
<div class="block1">
<h5>Language</h5>
<c:forEach items="${jobSeeker.lang}" var="lan">
		
		<p>${lan.langname}</p>
</c:forEach>
	
</div>

<div class="block1">
<h5>Proficiency</h5>
 <c:forEach items="${jobSeeker.lang}" var="lan">
		<p>${lan.profeciency}</p>
</c:forEach> 
</div>
<div class="block1">
<h5>Read</h5>
<br/>
<c:forEach items="${jobSeeker.lang}" var="lan">
	
		<c:if test="${fn:contains(lan.lread, 'Yes')}">
			<center><img src="images/Right.png" /></center><br/>
		</c:if>
		<c:if test="${fn:contains(lan.lread, 'No')}">
			<center><img src="images/images.png" /></center><br/>
		</c:if>
</c:forEach>
 
</div>
<div class="block1">
<h5>Write</h5>
<br/>
<c:forEach items="${jobSeeker.lang}" var="lan">
		<c:if test="${fn:contains(lan.lwrite, 'Yes')}">
			<center><img src="images/Right.png" /></center><br/>
		</c:if>
		<c:if test="${fn:contains(lan.lwrite, 'No')}">
			<center><img src="images/images.png" /></center><br/>
		</c:if>
</c:forEach> 
</div>
<div class="block1">
<h5>Speak</h5>
<br/>
<c:forEach items="${jobSeeker.lang}" var="lan">
		<c:if test="${fn:contains(lan.lspeak, 'Yes')}">
			<center><img src="images/Right.png" /></center><br/>
		</c:if>
		<c:if test="${fn:contains(lan.lspeak, 'No')}">
			<center><img src="images/images.png" /></center><br/>
		</c:if>
</c:forEach>  
</div>
</div>
</div>
</div>

<div class="footer">
<ul>
<a href="#"><li>Careers</li></a>
<a href="#"><li>About Us </li></a>
<a href="#"><li>Clients </li></a>
<a href="#"><li>Terms & Conditions </li></a>
<a href="#"><li>FAQ's </li></a>
<a href="#"><li>Contact Us </li></a>
</ul>
<p>Our Partners: Jeevansathi Matrimonials - ICICIcommunities.org - 99acres - Real Estate In India</p>
<p>All rights reserved © 2015 Tech Narayana.</p>
</div>
</body>
</html>
