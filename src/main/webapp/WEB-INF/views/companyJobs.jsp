<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>Company Jobs</title>
<jsp:include page="adminHeader.jsp"></jsp:include>
<style>
.btn-file {
	position: relative;
	overflow: hidden;
}

.btn-file input[type=file] {
	position: absolute;
	top: 0;
	right: 0;
	min-width: 100%;
	min-height: 100%;
	font-size: 100px;
	text-align: right;
	filter: alpha(opacity = 0);
	opacity: 0;
	outline: none;
	background: white;
	cursor: inherit;
	display: block;
}
</style>
</head>


<body class="top-navigation">

	<div class="ibox-content">
		
				
		<div class="wrapper wrapper-content">
			<div class="container">
				<div class="row">

		<div class="ibox-content">
			<c:forEach items="${jobsAndCompanyList}" var="job"> 
		
				<div style="width:50%;margin-top:10px;margin-left:150px;">
					<div style="float:right;margin-top:10px;"><a href="updateJob.do?jobId=${job.jKey}"> Update </a><br/><br/>
						<a href="jobDeleted.do?jobId=${job.jKey}">Delete</a>
					</div>	
					<b>${job.title}</b><br/>
					<font style="color:green;">${job.company.name}</font><br/>
					Exp : ${job.minExpYear} years ${job.minExpMonth}months - ${job.maxExpYear} years ${job.maxExpMonth} months Loc : ${job.location}<br/>
					Skills :  ${job.keySkills}<br/>
					Descriptions : ${job.shortDescriptions}<br/>
					Package : ${job.minSal} - ${job.maxSal}<br/>
						
				</div>
				 
			</c:forEach>
					</div>
			</div>
		</div>
	</div>
	</div>
	
</body>





</html>
