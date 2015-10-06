<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.techNarayana.ejobzz.dto.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Jobseeker Education</title>
<jsp:include page="jobseekerLoginHeadder.jsp" />


<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
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
					<form:form id="education" commandName="jobseekerRegisterDTO"
						class="form-horizontal" action="addEducationPost.do" method="POST" onkeyup="return submitform()"
						>
						<h3>
							<b>Update Your Employment Details:</b>
						</h3>
						<br />
						<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label"></label>

									<div class="col-md-4">
										<form:select path="dto.etype" name="etype" id="etype"
											class="form-control" placeholder="etype">
											<form:option value="">Select</form:option>
										<form:option value="SSLC/class 10">SSLC/class 10</form:option>
										<form:option value="PUC/class 12">PUC/class 12</form:option>
										<form:option value="UG">Graduation</form:option>
										<form:option value="PG">Post Graduation</form:option>
										<form:option value="PHD">Phd/Doctarate</form:option>
										
										</form:select>
										<label for="etype" class="error" id="etype-error"></label>
									</div>
								</div>
								
							</div>
							<br />
						<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Education Name</label>

									<div class="col-md-4">


										<form:hidden path="jsid" value="${lUser.jsid}" ></form:hidden>
									
										<form:input path="dto.ename" class="form-control" name="ename"  id="ename"></form:input>
									</div>
								</div>
							</div>
							
							<br />
							
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label"></label>

									<div class="col-md-4">
										<form:select path="dto.courseType" name="courseType"
											class="form-control" placeholder="Years">
											<form:option value="F">Full Time</form:option>
											<form:option value="P">Part Time</form:option>
											<form:option value="C">Corresponding</form:option>
										</form:select>
									</div>
								</div>
							</div>
							<br />
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Specialization</label>

									<div class="col-md-4">
									<form:input path="dto.specialization" name="specialization" class="form-control" ></form:input>
										
									</div>
								</div>
							</div>
							<br />
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">University</label>

									<div class="col-md-4">
										<form:select path="dto.university" name="university"
											class="form-control" required="true">
											<c:forEach items="${university}" var="uns">
											<form:option value="${uns.id}">${uns.uname}</form:option>
										
											</c:forEach>	</form:select>
									</div>
								</div>
							</div>
							<br />
							
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Graduate Year</label>

									<div class="col-md-4">
										<form:select path="dto.graduateYear" name="graduateYear"
											class="form-control">

											<form:option value=""> Select Year</form:option>
											<form:options items="${years}" />
										</form:select>
									</div>
								</div>
							</div>
							<br />
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



	<!-- <script src="js/jquery-2.1.1.js"></script>
	<script src="js/bootstrap.min.js"></script> -->
	<script src="http://jqueryvalidation.org/files/dist/jquery.validate.min.js"></script>
<script src="http://jqueryvalidation.org/files/dist/additional-methods.min.js"></script>
	<!-- <script src="js/inspinia.js"></script>	
  <script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>
	<script src="js/plugins/slimscroll/jquery.slimscroll.min.js"></script>  -->
<script type="text/javascript">

$.validator.addMethod("emailerror", function(value, element) {
	var isSuccess = false;
	 var retMsg=$.ajax({type:'POST', url: 'CheckUserEdu.do',  data: { etype: $("#etype").val(), 
		  jsid: $("#jsid").val() }
		  
		  })
		 
	return true;
	},"already this exist");

 $(document).ready(function(){
		
	
		$("#education").validate({
			
		    rules: {
		    
		    	"dto.etype":{
		    		required:true,
		    		emailerror:true 
		    		
		             
		    	},
		    	
		    	"dto.ename":{
		    		required:true,
		    		 lettersonly: true
		    	},
		    	"dto.courseType":{
		    		required:true
		    		
		    	},
		    	"dto.university":{
		    		required:true
		    		
		    	},
		    	"dto.graduateYear":{
		    		required:true
		    		
		    	}
		
		    },
		    messages:{
		    	"dto.etype":{
		    		required:"Please select Education Type"
		    			
		    	},
		    	"dto.ename":{
		    		required:"Please Enter Education name",
		    		lettersonly:"Please Enter valid Education name"
		    	},
		    	"dto.courseType":{
		    		required:"Please Enter Education name"
		    		
		    	},
		    	"dto.university":{
		    		required:"Please Enter Name of Board Or University"
		    		
		    	},
		    	"dto.graduateYear":{
		    		required:"Please Select Year of Completion"
		    		
		    	}
		    }
		    }).form();

 
 });
</script>
</body>
</html>