
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:if test="${sessionScope.lUser != null || empty sessionScope.lUser}">
	<jsp:include page="jobseekerLoginHeadder.jsp"></jsp:include>

</c:if>
<c:if test="${sessionScope.lUser == null || empty sessionScope.lUser}">
	<jsp:include page="header.jsp"></jsp:include>

</c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<title>Job Description</title>
<style>
/* .btn-file {
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
.col-sm-2{
width: 22.667%;
} */

label {
   line-height:30px !important;
}
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
</head>




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
							visibleItems : 4,
							animationSpeed : 1000,
							autoPlay : true,
							autoPlaySpeed : 2000,
							pauseOnHover : true,
							enableResponsiveBreakpoints : true,
							responsiveBreakpoints : {
								portrait : {
									changePoint : 480,
									visibleItems : 1
								},
								landscape : {
									changePoint : 640,
									visibleItems : 2
								},
								tablet : {
									changePoint : 768,
									visibleItems : 3
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



					<div class="list-group">

						<form action="applyJob.do?jId=" ${job.jKey}>
							<input type="hidden" value="${job.jKey}" name="jId" />
							<h1>Job Descriptions :</h1>
							<b>Role : ${job.title}</b><br /> Exp : ${job.minExpYear} years
							${job.minExpMonth}months - ${job.maxExpYear} years
							${job.maxExpMonth} months<br /> Location : ${job.location}<br />
							Skills : ${job.keySkills}<br /> Descriptions :
							${job.shortDescriptions}<br /> Package : ${job.minSal} -
							${job.maxSal}<br /> Descriptions :<br /> ${job.descriptions}<br />
							<hr />
							<h1>About company :</h1>
							<br>
							<div style="float: right; margin-right: 45%;">
								<img src="${job.company.imgPath}" width="150" />
							</div>
							<div style="float: left;">
								Name: <font style="color: green;">${job.company.name}</font><br>
								Industry type : ${job.company.type}<br> Address :
								${job.company.address},${job.company.city}<br> Contact
								Person : ${job.company.contactPersionName}<br>
								<br>
								<br>
								<br>
								<br>
								<c:if
									test="${sessionScope.lUser == null || empty sessionScope.lUser}">
									<!-- <button class="btn btn-primary" type="submit">Login & Apply</button><br><br> -->
									<a class="btn btn-primary" data-toggle="modal"
										href="#modal-forms">Login & Apply</a>
								</c:if>
								<c:if
									test="${sessionScope.lUser != null ||not empty sessionScope.lUser}">
									<button class="btn btn-primary" type="submit">Apply</button>
									<br>
									<br>
									
								</c:if>
							</div>
						</form>

					</div>





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
                                                   <input  name="email" id="email" class="form-control" />
                                        </div>
                                          <div class="form-group"><label>Password</label><br/>
                                                   <input type="password" name="password" id="password" class="form-control" />
                                        </div>
                              	 <div id="wrongUser" class="form-group" style="color:red;font-style:bold;"></div>  
                                     
                                        
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-white" data-dismiss="modal">Close</button>
                                            <input type="submit" class="btn btn-primary" onclick="return submitJobseekerForm()" ></input>
                                            
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

	 function submitJobseekerForm(){
		
		
    $.ajax({type:'POST', url: 'jobLoginProcess.do',data:$('#loginJobseekerForm').serialize() , success: function(response) {
    	
        if(response=="0")
        	location.reload();
        else{
        	
        	$('#wrongUser').html("Wrong Email or Password!");
        	}
    }});

    return false;
}


</script>
	<script type="text/javascript" src="js/bootstrap-filestyle.js"></script>

	<!-- <script src="js/bootstrap.min.js"></script>

	<script src="js/bootbox.js"></script> -->


	<jsp:include page="footer.jsp" />
</html>
