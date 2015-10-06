<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<title>Ejobz | Home </title>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="css/datepicker3.css" rel="stylesheet">
   <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
  <link href="css/plugins/chosen/chosen.css" rel="stylesheet">
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<!-- Custom Theme files -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--webfont-->
	<link rel="stylesheet" href="css/reset1.css"> <!-- CSS reset -->
	<link rel="stylesheet" href="css/style1.css"> <!-- Gem style -->
	<script src="js/modernizr.js"></script> <!-- Modernizr -->
  <link rel="stylesheet" href="http://jqueryvalidation.org/files/demo/site-demos.css">

	<style type="text/css">
	.modal-footer .btn + .btn{
  background-color: #357EBD !important;
}
.modal-content {
  background-clip: padding-box;
  background-color: #FFFFFF;
  border: 1px solid rgba(0, 0, 0, 0);
  border-radius: 4px;
  box-shadow: 0 1px 3px rgba(0, 0, 0, 0.3);
  outline: 0 none;
  position: relative;
}
.btn-primary{
 background-color: #357EBD !important;
}
.modal-dialog {

  z-index: 1200;
}
.modal-body {
  padding: 20px 30px 30px 30px;
  background-color: #FFFFFF;
}
.inmodal .modal-body {
  background: #f8fafb;
}
.inmodal .modal-header {
  padding: 30px 15px;
  text-align: center;
}
.animated.modal.fade .modal-dialog {
  -webkit-transform: none;
  -ms-transform: none;
  -o-transform: none;
  transform: none;
}
.inmodal .modal-title {
  font-size: 26px;
}
.inmodal .modal-icon {
  font-size: 84px;
  color: #e2e3e3;
}
.modal-footer {
  margin-top: 0;
   background-color: #FFFFFF;
}
	
	
	</style>
<script>

// Get the <datalist> and <input> elements.
var dataList = document.getElementById('json-datalist');
var input = document.getElementById('ajax');

// Create a new XMLHttpRequest.
var request = new XMLHttpRequest();

// Handle state changes for the request.
request.onreadystatechange = function(response) {
  if (request.readyState === 4) {
    if (request.status === 200) {
      // Parse the JSON
      var jsonOptions = JSON.parse(request.responseText);
  
      // Loop over the JSON array.
      jsonOptions.forEach(function(item) {
        // Create a new <option> element.
        var option = document.createElement('option');
        // Set the value using the item in the JSON array.
        option.value = item;
        // Add the <option> element to the <datalist>.
        dataList.appendChild(option);
      });
      
      // Update the placeholder text.
      input.placeholder = "e.g. datalist";
    } else {
      // An error occured :(
      input.placeholder = "Couldn't load datalist options :(";
    }
  }
};

// Update the placeholder text.
input.placeholder = "Loading options...";

// Set up and make the request.
request.open('GET', 'https://s3-us-west-2.amazonaws.com/s.cdpn.io/4621/html-elements.json', true);
request.send();

</script>
<link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>

<script type="text/javascript" src="js/login.js"></script>
<script type="text/javascript" src="js/login1.js"></script>
<script src="js/jquery.easydropdown.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/bootbox.js"></script>
<!--Animation-->
<script src="js/wow.min.js"></script>
<link href="css/animate.css" rel='stylesheet' type='text/css' />
<script>
	new WOW().init();
</script>
<link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/megamenu.js"></script>
<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
<script src="js/simpleCart.min.js"> </script>



<div class="header">
		   <div class="col-sm-8 header-left" >
					 <div class="logo">
						<a href="index.html"><img src="images/logo.png" alt=""/></a>
					 </div>
					 <div class="menu">
						  <a class="toggleMenu" href="#"><img src="images/nav.png" alt="" /></a>
						    <ul class="megamenu skyblue">
		<!-- 	<li class="active grid"><a class="color1" href="index.html">Jobs</a></li> -->
			<li class="grid"><a class="color2" href="#">Jobs</a>
				<div class="megapanel">
					<div class="row">
						<div class="col1" style="float:left; width:40%;">
							<div class="h_nav">
								<h4>Jobs</h4>
								<ul>
										<li><a href="GetJobsByCity.do?city= " target="_blank">Browse All Jobs</a> </li>
								<li><a href="jobsBycity.do" target="_blank">Jobs By Location</a></li>
								<li><a href="jobsByskill.do" target="_blank">Jobs By Skill</a></li>
								<li><a href="jobsByDesign.do" target="_blank">Jobs By Designation</a></li>
								<li><a href="showjobseekerRegister.do" target="_blank">Post Your Resume</a></li>
								</ul>	
							</div>							
						</div>
						<div class="col1" style="float:left; width:40%;">
							<div class="h_nav">
								<h4>Jobs</h4>
								<ul>
									<li><a href="subscription.do" target="_blank">Pricing & Subscribe</a></li>
									<li><a href="#" target="_blank">Jobs by Location</a></li>
									<li><a href="#" target="_blank">Jobs by Skills</a></li>
									<li><a href="#" target="_blank">Jobs by Designation</a></li>
									<li><a href="#" target="_blank">Jobs by Category</a></li>
									<li><a href="#" target="_blank">Jobs by Company</a></li>
								</ul>	
							</div>							
						</div>
					</div>
					<div class="row">
						<div class="col2"></div>
						<div class="col1"></div>
						<div class="col1"></div>
						<div class="col1"></div>
						<div class="col1"></div>
					</div>
    				</div>
				</li>
			<li><a class="color4" href="#">Companies</a>
				<div class="megapanel">
					<div class="row">
						<div class="col1" style="float:left; width:40%;">
							<div class="h_nav">
								<h4>Jobs</h4>
								<ul>
									<li><a href="#" target="_blank">Browse all jobs</a></li>
									<li><a href="#" target="_blank">Jobs by Location</a></li>
									<li><a href="#" target="_blank">Jobs by Skills</a></li>
									<li><a href="#" target="_blank">Jobs by Designation</a></li>
									<li><a href="#" target="_blank">Jobs by Category</a></li>
									<li><a href="#" target="_blank">Jobs by Company</a></li>
								</ul>	
							</div>							
						</div>
						<div class="col1" style="float:left; width:40%;">
							<div class="h_nav">
								<h4>Jobs</h4>
								<ul>
									<li><a href="#" target="_blank">Browse all jobs</a></li>
									<li><a href="#" target="_blank">Jobs by Location</a></li>
									<li><a href="#" target="_blank">Jobs by Skills</a></li>
									<li><a href="#" target="_blank">Jobs by Designation</a></li>
									<li><a href="#" target="_blank">Jobs by Category</a></li>
									<li><a href="#" target="_blank">Jobs by Company</a></li>
								</ul>	
							</div>							
						</div>
						
					</div>
					<div class="row">
						<div class="col2"></div>
						<div class="col1"></div>
						<div class="col1"></div>
						<div class="col1"></div>
						<div class="col1"></div>
					</div>
    				</div>
				</li>				
				<li><a class="color5" href="#">Services</a>
				<div class="megapanel">
					<div class="row">
						<div class="col1" style="float:left; width:40%;">
							<div class="h_nav">
								<h4>Jobs</h4>
								<ul>
									<li><a href="#" target="_blank">Browse all jobs</a></li>
									<li><a href="#" target="_blank">Jobs by Location</a></li>
									<li><a href="#" target="_blank">Jobs by Skills</a></li>
									<li><a href="#" target="_blank">Jobs by Designation</a></li>
									<li><a href="#" target="_blank">Jobs by Category</a></li>
									<li><a href="#" target="_blank">Jobs by Company</a></li>
								</ul>	
							</div>							
						</div>
                        <div class="col1" style="float:left; width:40%;">
							<div class="h_nav">
								<h4>Jobs</h4>
								<ul>
									<li><a href="#" target="_blank">Browse all jobs</a></li>
									<li><a href="#" target="_blank">Jobs by Location</a></li>
									<li><a href="#" target="_blank">Jobs by Skills</a></li>
									<li><a href="#" target="_blank">Jobs by Designation</a></li>
									<li><a href="#" target="_blank">Jobs by Category</a></li>
									<li><a href="#" target="_blank">Jobs by Company</a></li>
								</ul>	
							</div>							
						</div>
					</div>
					<div class="row">
						<div class="col2"></div>
						<div class="col1"></div>
						<div class="col1"></div>
						<div class="col1"></div>
						<div class="col1"></div>
					</div>
    				</div>
				</li>
				<li><a class="color6" href="#">More</a>
				<div class="megapanel">
					<div class="row">
						<div class="col1" style="float:left; width:40%;">
							<div class="h_nav">
								<h4>Jobs</h4>
								<ul style="width:100% !important;float:left">
									<li><a href="#" target="_blank">Browse all jobs</a></li>
									<li><a href="#" target="_blank">Jobs by Location</a></li>
									<li><a href="#" target="_blank">Jobs by Skills</a></li>
									<li><a href="#" target="_blank">Jobs by Designation</a></li>
									<li><a href="#" target="_blank">Jobs by Category</a></li>
									<li><a href="#" target="_blank">Jobs by Company</a></li>
								</ul>	
							</div>							
						</div>
                        
                        <div class="col1" style="float:left; width:40%;">
							<div class="h_nav">
								<h4>Jobs</h4>
								<ul>
									<li><a href="#" target="_blank">Browse all jobs</a></li>
									<li><a href="#" target="_blank">Jobs by Location</a></li>
									<li><a href="#" target="_blank">Jobs by Skills</a></li>
									<li><a href="#" target="_blank">Jobs by Designation</a></li>
									<li><a href="#" target="_blank">Jobs by Category</a></li>
									<li><a href="#" target="_blank">Jobs by Company</a></li>
								</ul>	
							</div>							
						</div>
					</div>
					<div class="row">
						<div class="col2"></div>
						<div class="col1"></div>
						<div class="col1"></div>
						<div class="col1"></div>
						<div class="col1"></div>
					</div>
    				</div>
				</li>				
			
		 </ul>
							<script type="text/javascript" src="js/responsive-nav.js"></script>
				    </div>	
				                <div id="page-wrapper" class="gray-bg">
			<div class="row border-bottom white-bg">
				<div class="col-lg-6">
					<div class="ibox float-e-margins">



						
						 <div class="modal inmodal" id="modal-forms" tabindex="-1" role="dialog" aria-hidden="true">
                                <div class="modal-dialog">
                              <div class="modal-content animated bounceInRight"> 
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                                            <i class="fa fa-laptop modal-icon"></i>
                                            <h4 class="modal-title">Jobseeker Login</h4>
                                          
                                        </div>
                                      
                                       <form id="loginJobseekerForm" action="" method="post" >
                                         <div class="modal-body">
                                           
                                                    <div class="form-group"><label>Email Id</label><br/>
                                                   <input  name="email" id="email" class="form-control" required="true" />
                                        </div>
                                          <div class="form-group"><label>Password</label><br/>
                                                   <input type="password" name="password" id="password" class="form-control" required="true" />
                                        </div>
                              	 <div id="wrongUseridpass" class="form-group" style="color:red;font-style:bold;"></div>  
                                     
                                        
                                        </div>
                                      
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-white" data-dismiss="modal">Close</button>
                                            <input type="submit" class="btn btn-primary" onclick="return submitJobseekerForm()"  value="Login"></input>
                                            
                                        </div> 
                                       
                                         <a href="showjobseekerRegister.do" style="margin-top: -8%;float: left; margin-left: 5%;" >Click to Register </a><a href="ForgotPassword.do"style="margin-top: -8%;float: left;   margin-left: 27%;" > Forgot Password</a>
                                       </form>
                                </div>
                                      
                                        
                                        </div>
                                       
                                    </div>
                                </div>
                               
                                 </div>
                            </div>
					</div>
						<!----search-scripts---->
						<script src="js/classie.js"></script>
						<!-- <script src="js/uisearch.js"></script> -->
						<!-- <script>
							new UISearch( document.getElementById( 'sb-search' ) );
						</script> -->
						<!----//search-scripts---->						
	    		    <div class="clearfix"></div>
	    	    </div>
	            <div class="col-sm-4 header_right" >
	    		      <div id="loginContainer"><a href="#" target="_blank" id="loginButton"><img src="images/login.png"><span>Employer</span></a>
	    		   
						    <div id="loginBox">                
						        <form:form  id="loginForm"  action="" onsubmit="return submitForm()">
						                <fieldset id="body">
						                	<fieldset>
						                          <label for="email">Email Address</label>
						                         <input id="email" name="email"
														placeholder="Enter email" />
						                    </fieldset>
						                    <fieldset>
						                            <label for="password">Password</label>
						                            <input type="password" id="password" name="password"
														placeholder="Password" />
						                          	<div id="wrongUserIdOrPassword" class="form-group" style="color:red;font-style:bold;"></div>  
						                     </fieldset>
						                    <input type="submit" id="login" value="Sign in">
						                	<label for="checkbox"><input type="checkbox" id="checkbox"> <i>Remember me</i></label>
						            	</fieldset>
						                 <span style="width:80% !important;"><a href="ForgotCompanyPassword.do" target="_blank">Forgot your password?</a> <a href="newEmployer.do" target="_blank" style="float:right">Click to Register</a></span>
						                   <!-- <span style="width:50% !important;">New Employer<a href="registerCompany.do" target="_blank">Register</a></span> -->
							     </form:form> 
				              </div>
				            <a class="active" style="color: #fff;margin-left:12%;" data-toggle="modal"
										href="#modal-forms">Jobseeker Login</a> 
			             </div>
			              
		                 <div class="clearfix"></div>
	                 </div>
	      
	                <div class="clearfix"></div>
   </div>
   
 
   <div class="banner">
   	  <div class="container_wrap">
   		<h1>What are you looking for?</h1>
   		  <form action="getAllJobs.do" method="post">
   	       <div class="dropdown-buttons">   
            		  <div class="dropdown-button">           			
            			<select name="location" class="dropdown" tabindex="9" data-settings='{"wrapperClass":"flat"}'>
            				<option value="0"> Select Location </option>
            			<c:forEach items="${location}" var="loc">
            							
											<option value="${loc.id}">${loc.lname}</option>
										
											</c:forEach>
            			
					  </select>
					</div>
				     <div class="dropdown-button">
					  <select name="experience" class="dropdown" tabindex="9" data-settings='{"wrapperClass":"flat"}'>
            			<option value="0">Experience</option>	
						<option value="1"> <1 years</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
					  </select>
					 </div>
                     
                     <div class="dropdown-button">
					  <select name="salary" class="dropdown" tabindex="9" data-settings='{"wrapperClass":"flat"}'>
            			<option value="0">Salary</option>	
						<option value="1"> <1 lac </option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
					  </select>
					 </div>
				   </div>  
		  
            	<input type="text" id="default" name="skills" list="languages" multiple value="Skills, Designations, Companies" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Skills, Designations, Companies';}">
  
  <datalist id="languages">
    <option value="HTML">
    <option value="CSS">
    <option value="JavaScript">
    <option value="Java">
      <option value="Spring">
     <option value="Hibernate">
    <option value="Ruby">
    <option value="PHP">
    <option value="Go">
    <option value="Erlang">
    <option value="Python">
    <option value="C">
    <option value="C#">
    <option value="C++">
  </datalist>
			    <div class="contact_btn">
	               <label class="btn1 btn-2 btn-2g"><input name="submit" type="submit" id="submit" value="Search"></label>
	            </div>
			</form>        		
   		    <div class="clearfix"></div>
         </div>
   </div>
   <div class="content_top">
   
   	  <div class="container">
   		<div class="col-md-4 bottom_nav" style="width:100% !important">
        <nav class="main-nav" style="margin-top:-22px !important">
			<ul style="margin:0 !important">
				<!-- inser more links here -->
				<li></li>
			</ul>
		</nav>
   		   <div class="content_menu">
				<ul>
					<li><a href="#" target="_blank">Jobs By Companies</a></li>
					<li><a href="#" target="_blank">Jobs By Category</a></li>
				
					<li><a href="jobsBycity.do" target="_blank">Jobs By Location</a></li>
					<li><a href="jobsByskill.do" target="_blank">Jobs By Skill</a></li>
					<li><a href="jobsByDesign.do" target="_blank">Jobs By Designation</a></li>
				</ul>
                
                <div class="cd-user-modal"> <!-- this is the entire modal form, including the background -->
		<div class="cd-user-modal-container"> <!-- this is the container wrapper -->
			<ul class="cd-switcher">
				<li><a href="#0">Sign in</a></li>
				
			</ul>

			<div id="cd-login"> <!-- log in form -->
				
				
			
				
			
			</div> 
			
			
			
			

			<div id="cd-reset-password"> <!-- reset password form -->
				<p class="cd-form-message">Lost your password? Please enter your email address. You will receive a link to create a new password.</p>

				<form class="cd-form1">
					<p class="fieldset">
						<label class="image-replace cd-email" for="reset-email">E-mail</label>
						<input class="full-width has-padding has-border" id="reset-email" type="email" placeholder="E-mail">
						<span class="cd-error-message">Error message here!</span>
					</p>

					<p class="fieldset">
						<input class="full-width has-padding" type="submit" value="Reset password">
					</p>
				</form>

				<p class="cd-form-bottom-message"><a href="#0">Back to log-in</a></p>
			</div> <!-- cd-reset-password -->
			<a href="#0" class="cd-close-form">Close</a>
		</div> <!-- cd-user-modal-container -->
	</div>
    
    
   
   <!--  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script> -->
<script src="js/main.js"></script> <!-- Gem jQuery -->

			</div>
		</div>
		
   	</div>
   </div>
   <script type="text/javascript" src="js/bootstrap-datepicker.js"></script>
 <script src="js/chosen.jquery.js"></script>
<script type="text/javascript" src="js/bootstrap-filestyle.js"></script>
 
  
 <script >
 

 
 function submitForm() {
	    $.ajax({type:'POST', url: 'authCompany.do', data:$('#loginForm').serialize(), success: function(response) {
	        
	        if(response=="0")
	        	$(location).attr('href',"homeCompany.do");
	        else{
	        	$('#wrongUserIdOrPassword').html("Wrong Email or Password!");
	        	}
	    }});

	    return false;
	}
 
 function submitEmpLoginForm() {
	 alert("submitEmpLoginForm");
	    $.ajax({type:'POST', url: 'employerOrderLogin.do', data:$('#empLoginForm').serialize(), success: function(response) {
	        
	        if(response=="0"){
	        	$(location).attr('href',"homeCompany.do");
	        }
	        else{
	        	$('#wrongUseridpass').html("Wrong Email or Password!");
	        	}
	    }});

	    return false;
	}
 
 function submitJobseekerForm(){
		
		
	    $.ajax({type:'POST', url: 'jobLoginProcess.do',data:$('#loginJobseekerForm').serialize() , success: function(response) {
	    	
	        if(response=="0")
	        	$(location).attr('href',"LoginProcess.do");
	        else{
	        	
	        	$('#wrongUseridpass').html("Wrong Email or Password!");
	        	}
	    }});

	    return false;
	}

</script>

<script>
        $(document).ready(function(){

         
        var config = {
                '.chosen-select'           : {},
                '.chosen-select-deselect'  : {allow_single_deselect:true},
                '.chosen-select-no-single' : {disable_search_threshold:10},
                '.chosen-select-no-results': {no_results_text:'Oops, nothing found!'},
                '.chosen-select-width'     : {width:"95%"}
            }
            for (var selector in config) {
                $(selector).chosen(config[selector]);
            }

      
        });


    </script>
  
   <script src="http://jqueryvalidation.org/files/dist/jquery.validate.min.js"></script>
<script src="http://jqueryvalidation.org/files/dist/additional-methods.min.js"></script>
 <script type="text/javascript" src="jquery.validate.js"></script>
</head>