<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
<jsp:include page="jobseekerLoginHeadder.jsp" />
<!-- <link rel="stylesheet" href="http://jqueryvalidation.org/files/demo/site-demos.css">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="font-awesome/css/font-awesome.css" rel="stylesheet">
<link href="css/animate.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
 -->
 </head>

<body class="top-navigation gray-bg">
<div class="ibox-content">
		<c:if test="${not empty success}">
			<div class="alert alert-success" role="alert">${success}</div>
		</c:if>
		<c:if test="${not empty fail}">
			<div class=" alert alert-error">
				<strong>Fail!</strong>${fail}</div>
		</c:if>
		
	<div class="wrapper wrapper-content animated fadeInUp">

<form  id="myform" action="ChangePasswordPost.do" method="POST" >

								<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Current Password</label>

									<div class="col-md-4">


										
										<input type="password" name="currentPassword" id="currentPassword" class="form-control" ></input>
										 <span  class="error" id="notMatch"><font color="red">  ${notMatch}</font></span>
									</div>
								</div>
							</div>
							<br />
								<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">New Password</label>

									<div class="col-md-4">


										 <input type="hidden"  value="${lUser.jsid}" ></input>  
										<input type="password" name="newPassword" id="newPassword" class="form-control" ></input>
									</div>
								</div>
							</div>
							<br />
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Confirm Password</label>

									<div class="col-md-4">
										<input type="password" name="rePassword"  id="rePassword"
											class="form-control" ></input>
									</div>
								</div>
							</div>
							<br />
							<div class="hr-line-dashed"></div>
							<div class="form-group">
								<div class="col-sm-4 col-sm-offset-2">
									<input type="submit" class="btn btn-primary"
										value="Change Password" />
									<button class="btn btn-white" type="reset">Reset</button>

								</div>
							</div>
</form>


</div></div>


<script src="http://jqueryvalidation.org/files/dist/jquery.validate.min.js"></script>
<script src="http://jqueryvalidation.org/files/dist/additional-methods.min.js"></script>

<script type="text/javascript" src="jquery.validate.js"></script>
<script type="text/javascript">
$("#myform").validate({
    rules: {
    	newPassword: { 
          required: true,
             minlength: 6,
             maxlength: 10,

        } , 

        rePassword: { 
             equalTo: "#newPassword",
              minlength: 6,
              maxlength: 10
        }


    },
messages:{
	newPassword: { 
          required:"the password is required"

        }
}

});
</script>
	<!-- <script src="js/bootstrap.min.js"></script>
	<script src="js/bootbox.js"></script>
	<script type="text/javascript" src="js/bootstrap-filestyle.js"></script>
		<script src="js/inspinia.js"></script>	
	<script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>
	<script src="js/plugins/slimscroll/jquery.slimscroll.min.js"></script> -->
</body>
</html>