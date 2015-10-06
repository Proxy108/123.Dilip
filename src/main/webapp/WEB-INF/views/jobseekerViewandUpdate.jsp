<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>E-Jobzz Profile</title>
<jsp:include page="jobseekerLoginHeadder.jsp" />
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">

<style type="text/css">
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

.modal-content {
	background-clip: padding-box;
	background-color: #FFFFFF;
	border: 1px solid rgba(0, 0, 0, 0);
	border-radius: 4px;
	box-shadow: 0 1px 3px rgba(0, 0, 0, 0.3);
	outline: 0 none;
	position: relative;
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
<jsp:useBean id="monthNames" class="java.text.DateFormatSymbols" />

</head>

<c:if test="${sessionScope.lUser == null || empty sessionScope.lUser}">
	<c:redirect url="/Login.do" />
</c:if>
<body class="top-navigation gray-bg">


	<div class="content_middle">
		<div class="content-middle">
			<div class="content-middle-in"
				style="background: #FFF; margin-top: 25px;">
				<ul id="flexiselDemo1">
					<li><img src="images/1.png" /></li>
					<li><img src="images/2.png" /></li>
					<li><img src="images/3.png" /></li>
					<li><img src="images/4.png" /></li>
					<li><img src="images/5.png" /></li>
					<li><img src="images/6.png" /></li>
					<li><img src="images/7.png" /></li>
					<li><img src="images/8.png" /></li>
					<li><img src="images/9.png" /></li>
				</ul>
				<script type="text/javascript">
		$(window).load(function() {
			$("#flexiselDemo1").flexisel({
				visibleItems: 4,
				animationSpeed: 1000,
				autoPlay: true,
				autoPlaySpeed: 2000,    		
				pauseOnHover: true,
				enableResponsiveBreakpoints: true,
		    	responsiveBreakpoints: { 
		    		portrait: { 
		    			changePoint:480,
		    			visibleItems: 1
		    		}, 
		    		landscape: { 
		    			changePoint:640,
		    			visibleItems: 2
		    		},
		    		tablet: { 
		    			changePoint:768,
		    			visibleItems: 3
		    		}
		    	}
		    });
		    
		});
	</script>
				<script type="text/javascript" src="js/jquery.flexisel.js"></script>

			</div>
		</div>

		<c:if test="${not empty success}">
			<div class="alert alert-success" role="alert">${success}</div>
		</c:if>
		<c:if test="${not empty fail}">
			<div class=" alert alert-error">
				<strong>Fail!</strong>${fail}</div>
		</c:if>
		<div class="container" style="margin-top: 30px">
			<div class="cat">
				<h3>Jobs by Category</h3>
				<a href="#">
					<p>Accounts Jobs</p>
				</a> <a href="#">
					<p>Interior Design Jobs</p>
				</a> <a href="#">
					<p>Automobile Jobs</p>
				</a> <a href="#">
					<p>Bank Jobs</p>
				</a> <a href="#">
					<p>BPO Jobs</p>
				</a> <a href="#">
					<p>Construction Jobs</p>
				</a> <a href="#">
					<p>Consultant Jobs</p>
				</a> <a href="#">
					<p>Content Writing Jobs</p>
				</a> <a href="#">
					<p>Corporate Planning Jobs</p>
				</a> <a href="#">
					<p>Design Engineer Jobs</p>
				</a> <a href="#">
					<p>Export Import Jobs</p>
				</a> <a href="#">
					<p>Accounts Jobs</p>
				</a> <a href="#">
					<p>Interior Design Jobs</p>
				</a> <a href="#">
					<p>Automobile Jobs</p>
				</a> <a href="#">
					<p>Bank Jobs</p>
				</a> <a href="#">
					<p>BPO Jobs</p>
				</a> <a href="#">
					<p>Construction Jobs</p>
				</a> <a href="#">
					<p>Consultant Jobs</p>
				</a> <a href="#">
					<p>Content Writing Jobs</p>
				</a> <a href="#">
					<p>Corporate Planning Jobs</p>
				</a> <a href="#">
					<p>Design Engineer Jobs</p>
				</a> <a href="#">
					<p>Export Import Jobs</p>
				</a> <a href="#">
					<p>Accounts Jobs</p>
				</a> <a href="#">
					<p>Interior Design Jobs</p>
				</a> <a href="#">
					<p>Automobile Jobs</p>
				</a> <a href="#">
					<p>Bank Jobs</p>
				</a> <a href="#">
					<p>BPO Jobs</p>
				</a> <a href="#">
					<p>Construction Jobs</p>
				</a> <a href="#">
					<p>Consultant Jobs</p>
				</a> <a href="#">
					<p>Content Writing Jobs</p>
				</a> <a href="#">
					<p>Corporate Planning Jobs</p>
				</a> <a href="#">
					<p>Design Engineer Jobs</p>
				</a> <a href="#">
					<p>Export Import Jobs</p>
				</a> <a href="#">
					<p>Accounts Jobs</p>
				</a> <a href="#">
					<p>Interior Design Jobs</p>
				</a> <a href="#">
					<p>Automobile Jobs</p>
				</a> <a href="#">
					<p>Bank Jobs</p>
				</a> <a href="#">
					<p>BPO Jobs</p>
				</a> <a href="#">
					<p>Construction Jobs</p>
				</a> <a href="#">
					<p>Consultant Jobs</p>
				</a> <a href="#">
					<p>Content Writing Jobs</p>
				</a> <a href="#">
					<p>Corporate Planning Jobs</p>
				</a> <a href="#">
					<p>Design Engineer Jobs</p>
				</a> <a href="#">
					<p>Export Import Jobs</p>
				</a>
				<!--<p>Merchandiser Jobs</p>
         <p>Fresher Jobs</p>
         <p>Medical Jobs</p>-->
			</div>


			<div class="main">
				<div class="conte">
					<h3>
						Profile Snapshot<a href="UpdateviewJobProfile.do"
							class="btn btn-edit  pull-right">Edit Profile</a>
					</h3>
					<div class="table">
						<div class="left">
							<h4>
								Name:<strong> ${lUser.name}</strong>
							</h4>
							<h4>
								Designation:<strong>${designation }</strong>
							</h4>
							<h4>
								Current Company:<strong>${company }</strong>
							</h4>
							<h4>
								Current Location:<strong>${jobseekerRegisterDTO.location }</strong>
							</h4>
							<h4>
								Current Salary(CTC):<strong>${sallac }lakh(s)${saltous }
									thousand(s)</strong>
							</h4>
							<h4>
								Email:<strong>${jobseekerRegisterDTO.email }</strong>
							</h4>
							<h4>
								Contact No:<strong>${jobseekerRegisterDTO.contactNo }</strong>
							</h4>
							<h4>
								Job Intrested Location:<strong>${jobseekerRegisterDTO.jobIntrestLocations }</strong>
							</h4>
							<h4>
								Total Experience:<strong>${jobseekerRegisterDTO.totalExp }</strong>
							</h4>
							<h4>
								DOB:<strong>${jobseekerRegisterDTO.dob }</strong>
							</h4>
							<h4>
								Gender:<strong>${jobseekerRegisterDTO.gender }</strong>
							</h4>
							<h4>
								City:<strong>${jobseekerRegisterDTO.city }</strong>
							</h4>
							<h4>
								KeySkills:<strong>${jobseekerRegisterDTO.keySkills }</strong>
							</h4>
						</div>
						<div class="right">
							<img src="${pic}">
						</div>


					</div>
				</div>

				<div class="conte">

					<h3>
						Company Details <a href="addEmployer.do?id=${lUser.jsid}"><i
							class="fa fa-plus"></i>Add Comapny</a>
					</h3>

					<div class="table">
						<div class="left">


							<c:choose>
							<%-- <fmt:parseNumber var="exp" value="${jobseekerRegisterDTO.totalExp }" /> --%>
							
							<%-- <c:if test="${exp >0}"> --%>
								<c:when test="${expDTO !=null}">
									<c:forEach var="exp" items="${expDTO}">

										
										<c:set value="${monthNames.months}" var="months" />
										<c:set value="${exp.joinedmonth }" var="month"></c:set>
										<c:set value="${exp.endingmonth }" var="tomonth"></c:set>
										<c:if test="${exp.employeeType eq 'C'}">
											<h4>Currenty Company</h4>
										</c:if>
										

										<h4>
											<strong>Company:</strong> ${exp.companyName }
										</h4>
										<h4>
											<strong>Designation:</strong> ${exp.designation }
										</h4>

										<h4>
										<strong>From:</strong><c:out value="${months[tomonth]}" />
											${exp.joinedyear }
											
										</h4>
										<h4>
											<strong>To: </strong>
											<c:out value="${months[month]}" />
											${exp.endingyear }
										</h4>
										
											<a href="EditExperience.do?id=${exp.jseid}" class="right">Edit
											</a>
											<a class="btn btn-edit  pull-right"
												onclick="deleteCompany(${exp.jseid})">Delete</a>
									
											
										<hr />

									</c:forEach>
								</c:when>
									
							</c:choose>
						</div>

					</div>
				</div>

				<div class="conte">
					<h3>
						Educational Details <a href="addEducation.do?id=${lUser.jsid}"><i
							class="fa fa-plus"></i>Add Education</a>
					</h3>

					<div class="table">

						<c:choose>
							<c:when test="${eduDTO !=null}">
								<c:forEach var="edu" items="${eduDTO}">

									<div class="left">



										<h4>${edu.ename }&nbsp;&nbsp;From ${edu.university } &nbsp; in&nbsp; 
											${edu.graduateYear }</h4>


									</div>
									<div class="right">
										<div class="del">
											<p>
												<a href="editEducation.do?id=${edu.eid}"
													class="btn btn-edit  pull-right">Edit </a>
											</p>


										</div>
										<div class="del">
											<p>
												<a class="btn btn-edit  pull-right"
													onclick="deleteEducation(${edu.eid})">Delete</a>
											</p>


										</div>
									</div>

								</c:forEach>
							</c:when>
						</c:choose>


					</div>
				</div>


				<div class="conte">
					<h3>
						Skill Details<a href="EditSkills.do?id=${lUser.jsid}"
							class="btn btn-info pull-right">Add/Edit</a>
					</h3>
					<div class="table">
						<h2 style="float: left; width: 20%;">Name</h2>
						<h2 style="float: left; width: 20%; text-align: center;">version</h2>
						<h2 style="float: left; width: 20%; text-align: center;">last
							Used</h2>
						<h2 style="float: left; width: 30%; text-align: center;">total
							Exp</h2>
						<c:choose>
							<c:when test="${skillset !=null}">
								<c:forEach var="skill" items="${skillset}">
									<div class="one">


										<h4>${skill.skillName}</h4>


									</div>



									<div class="two">

										<h4>${skill.version}</h4>

									</div>
									<div class="one">


										<h4>${skill.lastused }</h4>


									</div>
									<div class="three">
										<h4>${skill.expyears}years${skill.expmonths} months</h4>
									</div>
								</c:forEach>
							</c:when>
						</c:choose>
					</div>

				</div>

				<div class="conte">
					<h3>
						Language Details<a href="addLanguage.do?id=${lUser.jsid}"
							class="btn btn-info pull-right">Add/Edit</a>
					</h3>
					<div class="table">
						<c:choose>
							<c:when test="${langDetails !=null}">
								<c:forEach var="lan" items="${langDetails}">
									<div class="one">


										<h4>${lan.langname}</h4>


									</div>


									<div class="two">

										<h4>${lan.profeciency}</h4>

									</div>

									<div class="three">${lan.lread}</div>
									<div class="one">${lan.lread}</div>
									<div class="four">${lan.lread}</div>
								</c:forEach>
							</c:when>
						</c:choose>
					</div>

				</div>


				<a data-toggle="modal" href="#modal-forms">Upload Resume</a>
				<div class="conte"
					style="border: 1px solid black; float: left !important; width: 150% !important; margin-left: -138px; margin-bottom: 10px !important">
					<style>
p {
	background: white !important;
	margin: 10px;
}

h4, h3 {
	margin: 10px;
}
</style>
					<h3>
						



						<c:choose>
							<c:when test="${fn:length(st)<=0}">
								<p>${st}</p>
								<p>
									<b>Resume is not avilable please upload your Resume</b>
								</p>
							</c:when>
							<c:when test="${fn:length(st)>0}">
										 &nbsp;&nbsp;Attached Resume updated on <b>${modifyts}</b>
								<a href="downloadFile.do?id=${lUser.jsid}"><b>Download</b> </a>
								<a class="btn btn-edit " onclick="deleteresume(${lUser.jsid})"><b>Delete</b></a>
								<h3>Updated Resume</h3>
								<h4>Updated on: ${modifyts}</h4>
								<p>${st}</p>
							</c:when>
						</c:choose>
				</div>



			</div>


			<div class="cat">
				<h3>Jobs by Category</h3>
				<center>
					<img src="images/n.gif" />
				</center>
				<br>
				<center>
					<img src="images/n1.gif" />
				</center>
				<br>
				<center>
					<img src="images/n2.gif" />
				</center>
				<br>
				<center>
					<img src="images/n3.gif" />
				</center>
				<br>
				<center>
					<img src="images/n4.gif" />
				</center>
				<br>
				<center>
					<img src="images/n5.gif" />
				</center>
				<br>
				<center>
					<img src="images/n6.gif" />
				</center>
				<br>
				<center>
					<img src="images/n.gif" />
				</center>
				<br>
				<center>
					<img src="images/n1.gif" />
				</center>
				<br>
				<center>
					<img src="images/n2.gif" />
				</center>
				<br>
				<center>
					<img src="images/n3.gif" />
				</center>
				<br>
				<center>
					<img src="images/n4.gif" />
				</center>
				<br>
				<center>
					<img src="images/n5.gif" />
				</center>
				<br>
				<center>
					<img src="images/n6.gif" />
				</center>
				<br>
			</div>


		</div>


		<div id="page-wrapper" class="gray-bg">
			<div class="row border-bottom white-bg">
				<div class="col-lg-6">
					<div class="ibox float-e-margins">




						<div class="modal inmodal" id="modal-forms" tabindex="-1"
							role="dialog" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content animated bounceInRight">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">
											<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
										</button>

										<h4 class="modal-title">Uploda Resume(Doc,Docx,Pdf)</h4>

									</div>

									<form id="resume" role="form" action="UpdateProfileResume.do"
										method="post" enctype="multipart/form-data">
										<div class="modal-body">

											<div class="form-group">
												<label>Resume</label><br /> <input type="file" name="file"
													id="resumefile" placeholder="Upload file" class="filestyle"
													data-buttonName="btn-primary" />
											</div>

											<label for="resumefile" class="error" id="resumefile-error"></label>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-white"
												data-dismiss="modal">Close</button>
											<input type="submit" class="btn btn-primary"
												style="background-color: #357EBD !important"
												value="Upload Resume"></input>

										</div>

									</form>
								</div>


							</div>

						</div>
					</div>

				</div>
			</div>
		</div>


	</div>


	<script type="text/javascript">
$(document).ready(function(){
	
 	
	$("#resume").validate({
		
	    rules: {
	    
	    	
	    	file:{
	    		 required: true,
	    	      extension: "doc|docx|pdf"
	    	},
	    },
	    messages:{
	    	file:{
	    		 required:"Please select your resume",
	    		 extension:"Please select  resume in this formats(doc,docx,pdf) only"
	    	 }	
	    }
	    });
	
	
$("#picture").validate({
		
	    rules: {
	    
	    	
	    	file:{
	    		 required: true,
	    	      extension: "jpg|jpeg|png|gif"
	    	},
	    },
	    messages:{
	    	file:{
	    		 required:"Please select your picture",
	    		 extension:"Please select picture in this formats (jpg,jpeg,png gif)"
	    	 }	
	    }
	  
	    });
	});
$(":file").filestyle({buttonName: "btn btn-primary"});
</script>
	<script type="text/javascript" src="js/bootstrap-filestyle.js"></script>

	<script src="js/bootstrap.min.js"></script>

	<script src="js/bootbox.js"></script>
	<script type="text/javascript">
		
		
	
		 function deleteCompany(val){
				
			 bootbox.confirm("Are you sure you want to Delete Company Details  ?", function(result) { 
					if(result == true){
						var dataString='id='+val;
						$.ajax({
							type: "POST",
							url: "DeleteEmployer.do",
							data: dataString,
							cache: false,
							success: function(){
								 window.location.reload(true);
								
								}
						
						
					});
					}
					
					
				});
			} 
		 function deleteEducation(val){
				
			 bootbox.confirm("Are you sure you want to Delete Education Details  ?", function(result) { 
					if(result == true){
						var dataString='id='+val;
						$.ajax({
							type: "POST",
							url: "DeleteEducation.do",
							data: dataString,
							cache: false,
							success: function(){
								 window.location.reload(true);
								
								}
						
						
					});
					}
					
					
				});
			} 
		 
		 function deleteresume(val){
				
			 bootbox.confirm("Are you sure you want to Delete Resume ?", function(result) { 
					if(result == true){
						var dataString='id='+val;
						$.ajax({
							type: "POST",
							url: "DeleteResume.do",
							data: dataString,
							cache: false,
							success: function(){
								 window.location.reload(true);
								
								}
						
						
					});
					}
					
					
				});
			} 
	</script>

	<jsp:include page="footer.jsp" />

</body>
</html>