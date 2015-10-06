<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.*"%>


<html>

<head>

  <jsp:include page="header.jsp" />

  
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

	<div class="ibox-content">
		<c:if test="${not empty success}">
						<div class="alert alert-success" role="alert" id="alert">
							${success}</div>
					</c:if>
					<c:if test="${not empty fail}">
						<div class=" alert alert-error">
							<strong>Fail!</strong>${fail}</div>
					</c:if>
		<div class="wrapper wrapper-content">
			<div class="container">
				<div class="row">

					<div class="ibox-content">



						<form:form  id="myform" commandName="jobseekerRegisterDTO" class="form-horizontal" action="createRegister.do" enctype="multipart/form-data" method="POST" >

							<h3>
								<b>Create Your Profile Details:</b>
							</h3>
							<br />
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Full Name<font color="red">*</font></label>

									<div class="col-md-4">
										<form:input path="name" name="name" id="name" class="form-control" />
								<br />
									<span class="error"><form:errors
											path="name" /></span>
									<div id="missing_name_div_msg" style="display: none">
										<font color="red"> Please enter name</font>
									</div>
									<div id="pmissing_name_div_msg" style="display: none">
										<font color="red"> Please enter valid paymentTerms</font>
									</div>
								</div>
										</div>
							</div>
							<br />
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Email Id<font color="red">*</font></label>

									<div class="col-md-4">
										<form:input path="email"  name="email" id="email" class="form-control" onblur="isEmailRegistered(this)" />
									
									<br />
									<span class="error"><form:errors
											path="email" /></span>
									<div id="missing_email_div_msg" style="display: none">
										<font color="red"> Please enter Email Id</font>
									</div>
									<div id="pmissing_email_div_msg" style="display: none">
										<font color="red"> Please enter valid Email Id</font>
									</div>
									
									<div id='email-error' style="color:red;"></div>
								</div>
								</div>
							</div>
							<br />
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Password<font color="red">*</font></label>

									<div class="col-md-4">
										<form:password path="password" name="password" id="password"
											class="form-control" />
									</div>
								</div>
							</div>
							<br />
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Confirm Password<font color="red">*</font></label>

									<div class="col-md-4">
										<input type="password" name="confirmPassword" id="confirmPassword"
											class="form-control" />
									</div>
								</div>
							</div>
							<br />
							<div class="row">
								 <div class="form-group">
									<label class="col-sm-2 control-label">Location</label>

									<div class="input-group"> 
									 <!--  <div class="input-group"> -->
                			<div class=" col-md-4">
									 <form:select id="location" path="location" data-placeholder="Choose a Country..." class="chosen-select" style="width:370px;" tabindex="1" required="true" >
									<c:forEach items="${location}" var="loc">
											<form:option value="${loc.id}">${loc.lname}</form:option>
										
											</c:forEach>
											
										</form:select>
									</div>
								</div>
							</div></div>
							<br />
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Job Intrested
										Location<font color="red">*</font></label>

									<div class="col-md-4">
									
											<form:select path="jobIntrestLocations" name="jobIntrestLocations" id="jobIntrestLocations"
											class="chosen-select" style="width:370px;" multiple="true" tabindex="1"  required="true">
											 <optgroup label="Select Locations"/>
											<c:forEach items="${location}" var="loc">
											<form:option value="${loc.id}">${loc.lname}</form:option>
										
											</c:forEach>
										</form:select>
										<label for="jobIntrestLocations" class="error" id="jobIntrestLocations-error"></label>
									</div>
										
								</div>
						
							</div>
								
							<br />
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Mobile No<font color="red">*</font></label>

									<div class="col-md-4">
										<form:input path="contactNo" name="contactNo" id="contactNo"
											class="form-control" />
											<span class="error"><form:errors
											path="contactNo" /></span>
									<div id="missing_contactNo_div_msg" style="display: none">
										<font color="red"> Please enter Email Id</font>
									</div>
									<div id="pmissing_contactNo_div_msg" style="display: none">
										<font color="red"> Please enter valid Email Id</font>
									</div>
									</div>
								</div>
							</div>
							<br />
								<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Total Expirence</label>
									<div class="col-md-4">
										<form:input path="totalExp" name="totalExp" id="totalExp"  class="form-control" tabindex="4" />
									</div>
								</div>
							</div>
							<br />
							
						
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Designation
										<font color="red">*</font></label>

									<div class="col-md-4">
									
											<form:select path="designation" name="designation" id="designation"
											class="chosen-select" style="width:370px;"  tabindex="4"  required="true">
											 <optgroup label="Select Designation">
											<form:option value="Java Developer">Java Developer</form:option>
											<form:option value="Php Developer">Php Developer</form:option>
											<form:option value="Ui designer">Ui designer</form:option>
											<form:option value="HTML Designer">HTML Designer</form:option>
											<form:option value="Senior Ui Developer">Senior Ui Developer</form:option>
											
										</form:select>
										<label for="designation" class="error" id="designation-error"></label>
									</div>
										
								</div>
						
							</div><br />
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Key Skills <font color="red">*</font></label>
									  <div class="input-group">
									<div class="col-md-4">
										<form:select path="keySkills" name="keySkills" id="keySkills"
											class="chosen-select" style="width:380px;" multiple="true" tabindex="4" required="true">
											<optgroup label="Select KeySkills">
											<form:option value="Java">Java</form:option>
											<form:option value="javascript">javascript</form:option>
											<form:option value="Css">Css</form:option>
											<form:option value="Html">Html</form:option>
											<form:option value="Spring">Spring</form:option>
											<form:option value="Hibernate">Hibernate</form:option>
										</form:select>
										<label for="keySkills" class="error" id="keySkills-error"></label>
									</div>
									
									</div>
									
								</div>
							</div>
							<br />
						
														<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label" >Gender<font color="red">*</font></label>
									<div class="col-md-4">
										<form:radiobutton path="gender"  value="Male"/>Male 
										<form:radiobutton path="gender"  value="Female"/>Female
										<form:radiobutton path="gender"  value="Others"/>Others



									</div>
								</div>
							</div>
							<br />
							
							<div class="row">
								<div class="form-group">
									<label for="datepicker1" class="col-sm-2 control-label">Date Of birth
										</label>
									<div class="col-md-4">
										<form:input  path="dob" name="dob" placeholder="Date Of Birth"
											id="datepicker1" data-date-format="dd-mm-yyyy"
											class="form-control" />
									</div>
								</div>
							</div>
							
							
							
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Profile pic</label>
									<div class="col-md-4">
										<input type="file" name="profilePicPath" id="picfile" class="filestyle" data-buttonName="btn-primary" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">ResumeTitle</label>
									<div class="col-md-4">
										<form:input path="resumeTitle" name="resumeTitle" id="resumeTitle" class="form-control" />
									</div>
								</div>
							</div>
							<br />
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Resume <font color="red">*</font></label>
									<div class="col-md-4">
										<input type="file" name="resumePath" id="resumePath" class="filestyle"  data-buttonName="btn-primary" />
									</div>
									
								</div>
								<label  for="resumePath" class="error" id="resumePath-error"></label>
							</div>
							<!-- <input type="checkbox" id="check"   onchange="valueChanged()"/> -->
							<a id="check" >I  have text  Resume </a>
						<br />	
								<div id="textresumebox" style="display: none;">
								<div class="row" >
								<div class="form-group">
									<label class="col-sm-2 control-label">Resume <font color="red">*</font></label>
									<div class="col-md-4">
										<form:textarea path="textResume" name="textResume" id="textResume" cols="100" rows="10"></form:textarea>
									</div>
									
								</div>
								<label  for="textResume" class="error" id="textResume-error"></label>
							</div></div>
							<div class="hr-line-dashed"></div>
							<div class="form-group">
								<div class="col-sm-4 col-sm-offset-2">
									<input type="submit" class="btn btn-primary"
										value="create Your Profile" />
									<button class="btn btn-white" type="reset">Reset</button>

								</div>
							</div>


						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>



  
    
   

 

<script type="text/javascript">

$(document).ready(function(){
	
	

	$('#datepicker1').datepicker().on('changeDate', function(ev){
			$(this).datepicker('hide');

		});
});

 $(document).ready(
	    function(){
	        $("#check").click(function () {
	        	 $("#textresumebox").show();
	        });

	    }); 
	    
	    
 function isEmailRegistered(email){
	 email=email.trim();
		if(email != '' ){
			
			   $.ajax({
			  type: "POST",
			  url: "CheckUserEmail.do",
			  data:'email='+email.value,
			  cache: false,
			  success: function(response){
				  	if(response == 'A' || response == 65){
				  	
				  		document.getElementById('email-error').innerHTML="Email already registered!";
				  		email.focus();
				  	}
				  	else
				  		$('#email-error').empty();
			  },
			  error: function(){      
			   alert('Error while request..');
			  }
			 }); 
		  }
		}

	


</script> 

 
<script type="text/javascript">

 $.validator.addMethod("emailpattern", function(value, element) {
	var re = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
    return re.test(value);
}, "please enter valid Email Id");


$(document).ready(function(){
	
 	
$("#myform").validate({
	
    rules: {
    
    	
    	name:{
    		 required: true,
    		 minlength: 4
    		
    	},
    	  email: {
    		
            required: true,
            emailpattern: true
          
            
        }, 
    	password: { 
          required: true,
             minlength: 6,
             maxlength: 15

        } , 

         confirmPassword: { 
             equalTo: "#password",
              minlength: 6,
              maxlength: 15
        }, 
        gender:{
        	 required: true
        }
        ,
        contactNo: { 
            required: true,
            number: true,
             minlength: 10,
             maxlength: 15
       },
      
       location: {
    	   required: true,
    	   loc: true
           
       },
       jobIntrestLocations:{
    	   required: true,
    	   minlength: 2
       },
       designation:{
    	   required: true
    	 
       },
       keySkills:{
    	   required: true
    	 
       },
       pin: {
    	   required: false ,
    	   number: true,
    	   minlength: 6,
           maxlength: 6
           
       },
       dob:{
    	   required : false,
           
       },
       picfile: {
 	      required: false,
 	     accept: "jpg|jpeg|png|gif"
 	    },
       resumePath: {
    	      required: true,
    	      extension: "doc|docx|pdf"
    	    }
    	    
    	    },
   
messages:{
	
	 name:{
		 required:"Please enter your name",
		 lettersonly:"Please enter letters only"
	 },
	email:{
		
		 required: "Please enter  Email Id",
			email:"Please enter valid Email Id"
			
				
	},  
	password: { 
          required:"Please enter the password",
          maxlength:"Please  enter less than 15 characters"

        },
       
    contactNo: { 
    	required:"Please enter the Mobile No",
    		number:"Please enter Numbers only",
    		minlength:"please enter atleast 10 digits ",
    		maxlength:"please enter atmost 15 digits "
    },
    gender:{
    	required:"Please select gender"
   }
   ,
  location:{
	  
	  required:"Please select location",
		  minlength: "Please select location"
  },
  jobIntrestLocations:{
	  
	  required:"Please select job intrested locations",
		  minlength: "Please select job intrested locations"
  },
  
 pin:{
	  
	  required:"Please enter pin Code",
		  minlength:"Please enter correct pin code",
		  maxlength:"Please enter correct pin code"
  },
  designation:{
	  required:"Please select Designation"
  },
  keySkills:{
	   required:"Please select KeySkills"
	 
 },
  picfile: {
	  
	  accept: "Please select only jpg,jpeg,png,gif format file"
	    },
    resumePath: { 
       		 required:"Please select the resume file",
        	extension:"Please select only  docx,doc,pdf file"
      }
    
}

});


});	

</script>


<jsp:include page="footer.jsp"></jsp:include>

</body>




</html>

