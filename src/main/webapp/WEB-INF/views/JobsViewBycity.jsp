<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Jobs By City</title>
<jsp:include page="header.jsp"/>

</head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Jobs</title>
</head>
<body class="top-navigation gray-bg">
		<div class="ibox-content">
			<div class="wrapper wrapper-content">
				<div class="container">
					<div class="row">

						<div class="ibox-content">
							
							<div class="alert alert-success">(${noOfJobs}) Jobs Found !  </div>
							
							
		
		
		<c:forEach items="${joblist}" var="job"> 
		<a href="">
		<div class="ibox-content" id="searchtext">
                        <div class="list-group">
                            <a class="list-group-item" href="jobDetails.do?jobId=${job.jKey}">
                         					<h3 class="list-group-item-heading" style="color:black; font-style:bold">${job.title}</h3>
                               

                                <p class="list-group-item-text">
		
					<font style="color:green;">${job.company.name}</font><br/>
					Exp : ${job.minExpYear} years ${job.minExpMonth}months - ${job.maxExpYear} years ${job.maxExpMonth} months Loc : ${job.location}<br/>
					Skills :  ${job.keySkills}<br/>
					Descriptions : ${job.shortDescriptions}<br/>
					Package : ${job.minSal} - ${job.maxSal}<br/>
					</p>		</a>	
				</div>
			</div>
	 
			</c:forEach>
		</div>
		</div>
		</div>
		</div>
		</div>
<!-- <script src="js/jquery-2.1.1.js"></script>
<script src="http://jqueryvalidation.org/files/dist/jquery.validate.min.js"></script>
<script src="http://jqueryvalidation.org/files/dist/additional-methods.min.js"></script>

<script type="text/javascript" src="jquery.validate.js"></script>

	<script src="js/bootstrap.min.js"></script>
	<script src="js/bootbox.js"></script>
	<script type="text/javascript" src="js/bootstrap-filestyle.js"></script>
	<script src="js/inspinia.js"></script>	
	<script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>
	<script src="js/plugins/slimscroll/jquery.slimscroll.min.js"></script> -->
	
	<jsp:include page="footer.jsp"/>
</body>
</html>