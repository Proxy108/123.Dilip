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
<title>Forgot Password</title>
<jsp:include page="header.jsp" />

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

<form  id="myform" action="ForgotCompanyPasswordPost.do" method="POST" >
					<br/><br/>
								<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Email Id</label>

									<div class="col-md-4">


										
										<input type="email" name="email" id="email" class="form-control" ></input>
									</div>
								</div>
							</div>
							<br />
								
							<div class="hr-line-dashed"></div>
							<div class="form-group">
								<div class="col-sm-4 col-sm-offset-2">
									<input type="submit" class="btn btn-primary"
										value="Request Password" />
									<button class="btn btn-white" type="reset">Reset</button>

								</div>
							</div>
</form>
<br/><br/>

</div></div>


<script src="http://jqueryvalidation.org/files/dist/jquery.validate.min.js"></script>
<script src="http://jqueryvalidation.org/files/dist/additional-methods.min.js"></script>

<script type="text/javascript" src="jquery.validate.js"></script>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>