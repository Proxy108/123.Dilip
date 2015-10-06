<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Jobseeker Login page</title>
<jsp:include page="header.jsp" />

 </head>
<br/><br/><br/>
<body class="top-navigation gray-bg">
<div class="ibox-content">
		<c:if test="${not empty success}">
			<div class="alert alert-success" role="alert">${success}</div>
		</c:if>
		<c:if test="${not empty fail}">
			<div class=" alert alert-error">
				<strong>Fail!</strong>${fail}</div>
		</c:if>
		<h1><b>Jobseeker Login</b></h1><br/><br/><br/>
	<div class="wrapper wrapper-content animated fadeInUp">

<form  id="jobseekerLoginForm" action="" method="POST" onsubmit="return submitJobForm()" >

								<div class="row">
								<div class="form-group">
									<label class="col-sm-2 " style="margin-left: 74px;">Email Id</label>

									<div class="col-md-4">


										
										<input type="email" name="email" id="email" class="form-control" ></input>
									</div>
								</div>
							</div>
							<br />
								<div class="row">
								<div class="form-group">
									<label class="col-sm-2 " style="margin-left: 74px;">Password</label>

									<div class="col-md-4">


										<input type="password" name="password" id="password" class="form-control" ></input>
									</div>
								</div>
							</div>
								<div id="wrongUserid" class="form-group" style="color:red;font-style:bold;"></div>
							<br />
							
							<div class="hr-line-dashed"></div>
							<div class="form-group">
								<div class="col-sm-4 col-sm-offset-4">
									<input type="submit" class="btn btn-primary"
										value="Login" />
									<button class="btn btn-white" type="reset">Reset</button>

								</div>
							</div>
</form>

</div></div><br/><br/><br/><br/><br/><br/>



<script type="text/javascript">
 

 
 
 function submitJobForm() {
	    $.ajax({type:'POST', url: 'jobLoginProcess.do', data:$('#jobseekerLoginForm').serialize(), success: function(response) {
	        
	        if(response=="0")
	        	$(location).attr('href',"LoginProcess.do");
	        else{
	        	$('#wrongUserid').html("Wrong Email or Password!");
	        	}
	    }});

	    return false;
	}
</script>
   

<jsp:include page="footer.jsp"></jsp:include>	
</body>

</html>