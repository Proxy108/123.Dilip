<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">		
<script src="js/page.js"></script>
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
<style type="text/css">
 #content p{text-indent:20px;text-align:justify;}

	#pagingControls ul{display:inline;padding-left:0.5em}

	#pagingControls li{ position: relative;
  float: left;
  padding: 6px 12px;
  margin-left: -1px;
  line-height: 1.42857143;
  color: #1B242F;
  text-decoration: none;
  background-color: #fff;
  border: 1px solid #ddd;}  

</style>
<jsp:include page="header.jsp"></jsp:include>

</head>


<body class="top-navigation gray-bg">
		<div class="ibox-content">
			<div class="wrapper wrapper-content">
				<div class="container">
					<div class="row">

						<div class="ibox-content">
							
							<div class="alert alert-success">(${noOfJobs}) Jobs Found !  </div>
		<!-- <select name="perpage" id="perpage">
		<option value="10">10</option>
		<option value="20">20</option>
		<option value="30">30</option>
		<option value="40">40</option>
		</select>	 -->				
							<div class="timeline-item" id='contents'>
		<div class="row">
		
		<c:forEach items="${jobsAndCompanyList}" var="job"> 
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
		<div id="pagingControls" class="pagination pagination-panel pull-right"></div>
		</div>
		</div></div>
		</div>
		</div>
		
			
	<script type="text/javascript">
	
	var pager = new Imtech.Pager();
	
		$(document).ready(function() {
		
	
		    pager.paragraphsPerPage =10; // set amount elements per page
	
		    pager.pagingContainer = $('#contents'); // set of main container
	
		    pager.paragraphs = $('div.list-group', pager.pagingContainer); // set of required containers
	
		    pager.showPage(1);

		});
	</script>	

<jsp:include page="footer.jsp"/>
 </body></html>