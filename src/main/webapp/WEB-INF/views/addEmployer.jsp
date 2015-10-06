<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.techNarayana.ejobzz.dto.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Jobseeker Education</title>
<jsp:include page="jobseekerLoginHeadder.jsp" />

   <link rel="stylesheet" href="http://jqueryvalidation.org/files/demo/site-demos.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
 <c:if test="${sessionScope.lUser == null || empty sessionScope.lUser}">
	<c:redirect url="/Login.do" />
</c:if> 
<body class="top-navigation gray-bg">

	<c:if test="${not empty success}">
		<div class="alert alert-success" role="alert">${success}</div>
	</c:if>
	<c:if test="${not empty fail}">
		<div class=" alert alert-error">
			<strong>Fail!</strong>${fail}</div>
	</c:if>
	<div class="wrapper wrapper-content">
		<div class="container">
			<div class="row">

				<div class="ibox-content">
					<form:form id="experience" commandName="jobseekerRegisterDTO"
						class="form-horizontal" action="addEmployerPost.do" method="POST"
						>
						<h3>
							<b>Update Your Employment Details:</b>
						</h3>
						<br />
						<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Company Name</label>

									<div class="col-md-4">


										<form:hidden path="jsid" value="${lUser.jsid}" ></form:hidden>
										<form:input path="edto.companyName" class="form-control" ></form:input>
									</div>
								</div>
							</div>
							
							<br />
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Designation</label>

									<div class="col-md-4">
										<form:input path="edto.designation" name="designation"
											class="form-control" ></form:input>
									</div>
								</div>
							</div>
							<br />
							

							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Select Employee Type</label>
									<div class="col-md-4">
	
 								<form:select path="edto.employeeType"
											name="employeeType" placeholder="employeeType"
											class="form-control" >
											
											<form:option value="C">Current Employer</form:option>
											<form:option value="P">Previous Employer</form:option>
											<form:option value="O">Other Employer</form:option>
								</form:select>

									</div>
								</div>
							</div>
							<br />
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Industry Type</label>

									<div class="col-md-4">
										<form:select path="edto.industryType"
											data-placeholder="Select Industry type" class="chosen-select"
											 style="width:350px;">
											<form:option value="" >-- Select Industry --</form:option>
											<c:forEach items="${industryList}" var="ind">
	      										<form:option value="${ind.id}" >${ind.iname}</form:option> 
											</c:forEach></form:select>
									</div>
								</div>
							</div>
							<br />
							<div class="row">
								<div class="form-group">

									<label class="col-sm-1 control-label">Experience From </label>

									<div class="col-sm-2">
										<%-- <c:forEach var="code" items="${years}"> --%>
										<form:select path="edto.joinedyear" name="joinedyear" id="joinedyear"
											class="form-control" placeholder="Years">
											<form:option value=" ">  Year</form:option>
											<form:options items="${years}" />
										</form:select>
										<%-- </c:forEach> --%>
									</div>
									<div class="col-sm-2">
										<form:select path="edto.joinedmonth" name="joinedmonth" id="joinedmonth"
											placeholder="Months" class="form-control ">
											<form:option value=""> Month</form:option>
											<c:forEach var="month" items="${months}">
												<form:option value="${month.key}">${month.value}</form:option>

											</c:forEach>
										</form:select>
									</div>
								<!-- </div>
							</div>
							<br />
							<div class="row">
								<div class="form-group"> -->
										<label class="col-sm-1 "> To </label>

									<div class="col-sm-2">
										<form:select path="edto.endingyear" name="endingyear" id="endingyear"
											placeholder="Years" class="form-control">
											<form:option value=""> Year</form:option>
											<%-- <form:option value="0">Fresher</form:option> --%>
											<form:options items="${years}" />
										</form:select>
									</div>
									<div class="col-sm-2">
										<form:select path="edto.endingmonth" name="endingmonth" id="endingmonth"
											placeholder="Months" class="form-control">
											<form:option value=""> Month</form:option>
											
											<c:forEach var="month" items="${months}">
												<form:option value="${month.key}">${month.value}</form:option>

											</c:forEach>

										</form:select>
									</div>
								</div>
							</div>
							<br />
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Currency Type</label>
									<div class="col-md-4">
										<form:radiobutton path="edto.currencyType" value="INR" />
										Indian Rupees
										<form:radiobutton path="edto.currencyType" value="USD" />
										USD



									</div>
								</div>
							</div>
							<br />
							<div class="row">
								<div class="form-group">

									<label class="col-sm-1 control-label">CTC </label>

									<div class="col-sm-2">
										<%-- <c:forEach var="code" items="${years}"> --%>
										<form:select path="edto.currentsalLackh" name="currentsalLackh" id="currentsalLackh"
											class="form-control" placeholder="Lackhs">
											
											<form:option value="0"> Salary In Lackhs</form:option>
										<form:options items="${lac}" />
										</form:select>
									
									</div>
									<div class="col-sm-2">
										<form:select path="edto.currentsalThousand" name="currentsalThousand" id="currentsalThousand"
											placeholder="Thousands" class="form-control ">
											<form:option value="0">Select</form:option>
												
											<form:option value="0"> Salary In Thousands</form:option>
										<form:options items="${lac}" />
										</form:select>
									</div></div></div>
									<br />
									
							



							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Job Profile Desc</label>
									<div class="col-md-4">
										<form:textarea path="edto.jobProfileDesc"
											name="jobProfileDesc" id="jobProfileDesc"
											class="form-control" value="" ></form:textarea>
									</div>

								</div>
							</div> 
						<div class="hr-line-dashed"></div>
							<div class="form-group">
								<div class="col-sm-4 col-sm-offset-2">
									<input type="submit" class="btn btn-primary"
										value="Update Your Profile" />
									<button class="btn btn-white" type="reset">Reset</button>
									<a href="viewJobProfile.do"class="btn btn-info" >Cancel</a>
								</div>
							</div>
					</form:form>

				</div>
			</div>
		</div>
	</div>


	<script src="http://jqueryvalidation.org/files/dist/jquery.validate.min.js"></script>
<script src="http://jqueryvalidation.org/files/dist/additional-methods.min.js"></script>


	
	<script type="text/javascript">
$(document).ready(function(){


 
  $('#data_1 .input-group.date').datepicker().on('changeDate', function(ev){
		$(this).datepicker('hide');

	});



	
});
</script>
<script type="text/javascript">


 $(document).ready(function(){
		
	
		$("#experience").validate({
			
		    rules: {
		    
		    	"edto.companyName":{
		    		required:true
		    	   
		    	},
		    	"edto.designation":{
		    		required:true
		    	   
		    	},
		    	"edto.joinedyear":{
		    		required:true,
		    		 number: true
		    	},
		    	"edto.joinedmonth":{
		    		required:true,
		    		 number: true
		    		
		    	},
		    	"edto.endingyear":{
		    		required:true,
		    		 number: true
		    		
		    	},
		    	"edto.endingmonth":{
		    		required:true,
		    		 number: true
		    		
		    		
		    	},
		    	"edto.jobProfileDesc":{
		    		required:true
		    		
		    		
		    	}
		    	
		
		    },
		    messages:{
		    	"edto.companyName":{
		    		required:"Please Enter Company Name"
		    			
		    	},
		    	"edto.designation":{
		    		required:"Please Enter designation"
		    	   
		    	},
		    	"edto.joinedmonth":{
		    		required:"Please Select joined Month",
		    		number:"Please Select joined  Year"
		    	},
		    	"edto.joinedyear":{
		    		required:"Please Select Joined Year",
		    		number:"Please Select joined  Year"
		    		
		    	},
		    	"edto.endingyear":{
		    		required:"Please Select Ending Year",
		    		number:"Please Select Ending  Year"
		    		
		    	},
		    	"edto.endingmonth":{
		    		required:"Please Select Ending Month",
		    		number:"Please Select Ending  Year"
		    		
		    		
		    	},
		    	"edto.jobProfileDesc":{
		    		required:"Please Enter jobProfileDesc",
		    		number:"Please Select Ending  Month"
				    	   
		    		
		    	}
		    }
		    }).form();

 
 });
</script>
</body>
</html>