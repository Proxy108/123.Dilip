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
<link rel="stylesheet"href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">

<style type="text/css">
 .modal {
  position: fixed;
  top: 10%;
  left: 50%;
  z-index: 1050;
  height: 165px;
  width: 560px;
  margin-left: -280px;
  background-color: #ffffff;
  border: 1px solid #999;
  border: 1px solid rgba(0, 0, 0, 0.3);
  *border: 1px solid #999;
  -webkit-border-radius: 6px;
     -moz-border-radius: 6px;
          border-radius: 6px;
  outline: none;
  -webkit-box-shadow: 0 3px 7px rgba(0, 0, 0, 0.3);
     -moz-box-shadow: 0 3px 7px rgba(0, 0, 0, 0.3);
          box-shadow: 0 3px 7px rgba(0, 0, 0, 0.3);
  -webkit-background-clip: padding-box;
     -moz-background-clip: padding-box;
          background-clip: padding-box;
} 

</style>


</head>

 <c:if test="${sessionScope.lUser == null || empty sessionScope.lUser}">
	<c:redirect url="/Login.do" />
</c:if> 
<body class="top-navigation gray-bg">
	

<div class="content_middle">
   <div class="content-middle">
					<div class="content-middle-in" style="background:#FFF; margin-top:25px;" >
					<ul id="flexiselDemo1" >			
						<li><img src="images/1.png"/></li>
						<li><img src="images/2.png"/></li>
						<li><img src="images/3.png"/></li>
						<li><img src="images/4.png"/></li>
						<li><img src="images/5.png"/></li>
						<li><img src="images/6.png"/></li>
						<li><img src="images/7.png"/></li>
						<li><img src="images/8.png"/></li>
						<li><img src="images/9.png"/></li>
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
                
   	  <div class="container" style="margin-top:30px">
      <div class="cat">
         <h3>Jobs by Category</h3>
          <a href="#"> <p>Accounts Jobs</p></a>
         <a href="#"> <p>Interior Design Jobs</p></a>
         <a href="#"> <p>Automobile Jobs</p></a>
         <a href="#"> <p>Bank Jobs</p></a>
         <a href="#"> <p>BPO Jobs</p></a>
         <a href="#"> <p>Construction Jobs</p></a>
        <a href="#">   <p>Consultant Jobs</p></a>
         <a href="#"> <p>Content Writing Jobs</p></a>
         <a href="#"> <p>Corporate Planning Jobs</p></a>
         <a href="#"> <p>Design Engineer Jobs</p></a>
         <a href="#"> <p>Export Import Jobs</p></a>
         <a href="#"> <p>Accounts Jobs</p></a>
         <a href="#"> <p>Interior Design Jobs</p></a>
         <a href="#"> <p>Automobile Jobs</p></a>
         <a href="#"> <p>Bank Jobs</p></a>
         <a href="#"> <p>BPO Jobs</p></a>
         <a href="#"> <p>Construction Jobs</p></a>
         <a href="#"> <p>Consultant Jobs</p></a>
         <a href="#"> <p>Content Writing Jobs</p></a>
         <a href="#"> <p>Corporate Planning Jobs</p></a>
         <a href="#"> <p>Design Engineer Jobs</p></a>
         <a href="#"> <p>Export Import Jobs</p></a>
          <a href="#"> <p>Accounts Jobs</p></a>
         <a href="#"> <p>Interior Design Jobs</p></a>
         <a href="#"> <p>Automobile Jobs</p></a>
         <a href="#"> <p>Bank Jobs</p></a>
         <a href="#"> <p>BPO Jobs</p></a>
         <a href="#"> <p>Construction Jobs</p></a>
        <a href="#">   <p>Consultant Jobs</p></a>
         <a href="#"> <p>Content Writing Jobs</p></a>
         <a href="#"> <p>Corporate Planning Jobs</p></a>
         <a href="#"> <p>Design Engineer Jobs</p></a>
         <a href="#"> <p>Export Import Jobs</p></a>
         <a href="#"> <p>Accounts Jobs</p></a>
         <a href="#"> <p>Interior Design Jobs</p></a>
         <a href="#"> <p>Automobile Jobs</p></a>
         <a href="#"> <p>Bank Jobs</p></a>
         <a href="#"> <p>BPO Jobs</p></a>
         <a href="#"> <p>Construction Jobs</p></a>
         <a href="#"> <p>Consultant Jobs</p></a>
         <a href="#"> <p>Content Writing Jobs</p></a>
         <a href="#"> <p>Corporate Planning Jobs</p></a>
         <a href="#"> <p>Design Engineer Jobs</p></a>
         <a href="#"> <p>Export Import Jobs</p></a>
     
         </div>
         
         
      
         <div class="main">
      	<div class="conte">
      		<h3>Resume Headline:<strong >${jobseekerRegisterDTO.resumeTitle }</strong></h3>
      <!--   <h3>Profile Snapshot<a href="UpdateviewJobProfile.do"
									class="btn btn-edit  pull-right">Edit Profile</a></h3> -->
        <div class="table">
        <div class="left"style="text-transform: capitalize;">
        <h4>Name:<strong> ${lUser.name}</strong></h4>
        <h4>Designation:<strong>${designation }</strong></h4>
        <h4>Current Company:<strong>${company }</strong></h4>
        <h4>Current Location:<strong>${jobseekerRegisterDTO.location }</strong></h4>
        <h4>Current Salary(CTC):<strong>${sallac }lakh(s)${saltous } thousand(s)</strong></h4>
        <h4>Email:<strong>${jobseekerRegisterDTO.email }</strong></h4>
        <h4>Contact No:<strong>${jobseekerRegisterDTO.contactNo }</strong></h4>
         <h4>Job Intrested Location:<strong>${jobseekerRegisterDTO.jobIntrestLocations }</strong></h4>
        <h4>Total Experience:<strong>${jobseekerRegisterDTO.totalExp }</strong></h4>
         <h4>DOB:<strong>${jobseekerRegisterDTO.dob }</strong></h4>
         <h4>Gender:<strong>${jobseekerRegisterDTO.gender }</strong></h4>
         
        <h4>KeySkills:<strong>${jobseekerRegisterDTO.keySkills }</strong></h4>
        </div>
        <div class="right">
        <img src="${pic}">
        </div>
      
        
        </div>
        </div>
       
        <a href="downloadFile.do?id=${lUser.jsid}" class="btn btn-primary">Download Resume</a>
		<a href="viewJobProfile.do"><button class="btn btn-primary" >View & Update Profile</button></a>

        
        	
     
        
        </div>
        
        	
         <div class="cat">
         <h3>Jobs by Category</h3>
         <center><img src="images/n.gif"/></center><br>
         <center><img src="images/n1.gif"/></center><br>
         <center><img src="images/n2.gif"/></center><br>
         <center><img src="images/n3.gif"/></center><br>
         <center><img src="images/n4.gif"/></center><br>
         <center><img src="images/n5.gif"/></center><br>
         <center><img src="images/n6.gif"/></center><br>
         <center><img src="images/n.gif"/></center><br>
         <center><img src="images/n1.gif"/></center><br>
         <center><img src="images/n2.gif"/></center><br>
         <center><img src="images/n3.gif"/></center><br>
         <center><img src="images/n4.gif"/></center><br>
         <center><img src="images/n5.gif"/></center><br>
         <center><img src="images/n6.gif"/></center><br>
         </div>      
      

   	  </div>
      
      
      
   </div>
 
   
	
    <script src="js/bootstrap.min.js"></script>

	
	
<jsp:include page="footer.jsp" />

</body>
</html>