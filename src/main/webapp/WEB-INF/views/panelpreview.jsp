<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>E-Jobzz Profile</title>
<jsp:include page="jobseekerLoginHeadder.jsp" />
<link href="css/bootstrap.min.css" rel="stylesheet">

 <link href="css/animate.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
   <link rel="stylesheet" href="http://jqueryvalidation.org/files/demo/site-demos.css">
   <style type="text/css">
   .kiran  { width:100%;
   			 height:200px;
   			 float:left;
   			 border:1px solid gray;
   			 }
   			 
   	.k		{ width:80%;
   			  height:200px;
              float:left;
   			}
   			
   	.k h2	{margin-left:10px;}	
   	
   	.k p	{margin-left:10px;}
   			 		 	 
   
   .k1		{width:20%;
   			     height:200px; 
				float:left;
   			}
   			
   	.k1 img	{width:110px;
   				 height:110px;
   				 float:right;
   				 margin-top:40px;
   				 margin-right:15px;
   				 border:1px solid black;
   				 }	
   			
   </style>
</head>
<c:if test="${sessionScope.lUser == null || empty sessionScope.lUser}">
	<c:redirect url="/Login.do" />
</c:if> 
<body class="top-navigation gray-bg">
<div class="ibox-content">

<div class="row">
		<div class="col-lg-12">
			<div class="ibox">

				<div class="ibox-content">

					<div class="row">
					 <div class="col-lg-10">
							
							

							<div class="panel panel-default">
							

								<!-- <div class="panel-body" >
								M.S (I.T.), Seeking Assignment in Software Development, Programming with an organization of repute	
								
								<img  src="profilepic/1.jpg">
								</div>
									
							
								</div>  -->
								
								<div class="kiran">
								<div class="k">
								<h2>Ambika Sharma</h2>
								<p>M.S (I.T.), Seeking Assignment in Software Development, Programming with an organization of repute
                                </p>
								</div>
								<div class="k1">
								
								<img src="profilepic/1.jpg">
								</div>
								</div>

							</div>
						</div> 
						
					
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script src="js/jquery-2.1.1.js"></script>
<script src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/bootstrap-filestyle.js"></script>
<script src="http://jqueryvalidation.org/files/dist/jquery.validate.min.js"></script>
<script src="http://jqueryvalidation.org/files/dist/additional-methods.min.js"></script>
<script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

<!-- Custom and plugin javascript -->
<script src="js/inspinia.js"></script>
<script src="js/plugins/pace/pace.min.js"></script>

<script src="js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
</body>
</html>