<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

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


<body class="top-navigation gray-bg">
	<form:form name="createJobForm" id="createJobForm" commandName="jobCommand" action="createJob.do"
		method="post">
		<div class="ibox-content">
			<div class="wrapper wrapper-content">
				<div class="container">
					<div class="row">

						<div class="ibox-content">

							<div class="alert alert-success"></div>

							<h3>
								<b>Post a job :</b>
							</h3>
							<br />
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Job Title</label>
									<div class="col-md-4">
										<form:input path="title" id="title" class="form-control" />
									</div>
								</div>
							</div>
							<br />
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Job Industry Type</label>
									<div class="col-md-4">
										<form:select path="industryType" class="chosen-select"
											multiple="true" style="width:350px;">
											<form:option value="" >-- Select Industry --</form:option>
											<c:forEach items="${industryList}" var="ind">
	      										<form:option value="${ind.id}" >${ind.iname}</form:option> 
											</c:forEach>
									</form:select>
									</div>
								</div>
							</div>
							<br />
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Short
										Descriptions</label>

									<div class="col-md-4">
										<form:input path="shortDescriptions" id="shortDescriptions"
											class="form-control" />
									</div>
								</div>
							</div>
							<br />
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Descriptions</label>

									<div class="col-md-4">
										<form:input path="descriptions" id="descriptions"
											class="form-control" />
									</div>
								</div>
							</div>

							<br />
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Skills </label>

									<div class="col-md-4">
										<form:input path="keySkills" id="keySkills"
											class="form-control" />
									</div>
								</div>
							</div>
							<br />
							<div class="row">
								<div class="form-group">

									<label class="col-sm-2 control-label">Notice Period </label>

									<div class="col-md-2">
										<form:select path="noticePeriod" name="noticePeriod"
											id="noticePeriod" class="form-control">

											<form:option value="" selected="selected">Months</form:option>
											<form:options items="${months}" />

										</form:select>
									</div>

								</div>
							</div>
							<br />
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Min Exp</label>
									<div class="col-md-2">
										<form:select path="minExpYear" name="minExpYear"
											id="minExpYear" class="form-control">

											<form:option value="" selected="selected">-- Select Min Exp Years --</form:option>
											<form:options items="${years}" />

										</form:select>

									</div>
									<div class="col-md-2">
										<form:select path="maxExpYear" name="maxExpYear"
											id="maxExpYear" class="form-control">

											<form:option value="" selected="selected">-- Select Max Exp Years --</form:option>
											<form:options items="${years}" />

										</form:select>

									</div>

								</div>
							</div>
							<br />
						<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Salary :</label>
									<div class="col-md-2">
										<form:input path="minSal" name="minSal" id="minSal" placeholder="Minimum "	class="form-control"/>
										<font size="1">Minimum</font>
									</div>
									<div class="col-md-2">
										<form:input path="maxSal" name="maxSal" id="maxSal" placeholder="Maximum"
											class="form-control"/>
											<font size="1">Maximum</font>
									</div>
								</div>
							</div>
							<br />
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Location </label>

									<div class="col-md-4">
										<form:select path="location" id="location"
											data-placeholder="Select Location " class="chosen-select"
											multiple="true" style="width:350px;">
											<form:option value="">-- Select Location --</form:option>
											<c:forEach items="${location}" var="loc">
												<form:option value="${loc.id}">${loc.lname}</form:option>
											</c:forEach>
										</form:select>
									</div>
								</div>
							</div>
							<br />
							<form:hidden path="companyId" class="form-control" />
							<form:hidden path="status" class="form-control" />
						</div>
						<input type="hidden" name="esid" value="${esid}">
						<div class="hr-line-dashed"></div>
						<div class="form-group">
							<div class="col-sm-4 col-sm-offset-2">
								<form:button class="btn btn-primary" type="submit">Submit</form:button>
								<form:button class="btn btn-white" type="reset">Reset</form:button>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form:form>

	<br />
	<br />
	<br />

	<script type="text/javascript">

 $.validator.addMethod("emailpattern", function(value, element) {
	var re = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
    return re.test(value);
}, "please enter valid Email Id");
 /* $.validator.addMethod('selectcheck', function (value) {
	    return (value != '0');
	}, "year required"); */
	$.validator.addMethod("valueNotEquals", function(value, element, arg){
		  return arg != value;
		 }, "Please Select ");	
	$.validator.setDefaults({ ignore: ":hidden:not(.chosen-select)" }) //for all select having
	
	
	$(document).ready(function(){

 	
$("#createJobForm").validate({
	
    rules: {
    	
    	title:{
    		 required: true,
    		 minlength: 4
    		
    	},
    	industryType: {
    		required:true,
    		multipleSelectOptionsSelected: 1
    		 
        }, 

        shortDescriptions: { 
          required: true,
          minlength:10 

        } , 

        descriptions: { 
            required: true,
            minlength:10
       },
      
       keySkills: {
    	   required: true,       
       },
       
    noticePeriod:{
  		 required: true,
  	},

  	minExpYear:{
   		 required: true,
   	},
   		
   	maxExpYear:{
      		 required: true,
    },
    minSal:{
       		 required: true,
       		valueNotEquals: "-1"
    },
	maxSal:{
       		required: true,
       		valueNotEquals: "-1"
	},
    location:{
	 		 required: true,
  			 minlength: 4
  	}    
 },
   
messages:{
	
	title:{
		 required:"Please enter title ",
		 lettersonly:"Please enter at least 4 letters"
	 },
	 
	 location:{
		 required: "Please select",
	 },
	 descriptions:{
		 required:"Please enter descriptions ",
		 lettersonly:"Please enter at least 4 letters"
	 },
	 shortDescriptions:{
		 required:"Please enter short descriptions ",
		 lettersonly:"Please enter at least 4 letters"
	 },
	 
	 industryType:{
		 required: "Please select",
	 },
	 keySkills:{
		 required:"Please select ",
	 },
	 noticePeriod:{
		 required:"Please select",
	 },
	 minExpYear:{
		 required:"Please select",
	 },
	 maxExpYear:{
		 required:"Please select",
	 }
}

});


});	

</script>

	<jsp:include page="footer.jsp"></jsp:include>
</body>





</html>
