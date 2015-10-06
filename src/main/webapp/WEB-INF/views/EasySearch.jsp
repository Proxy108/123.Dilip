<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.*"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>Easy Search</title>


<jsp:include page="adminHeader.jsp"></jsp:include>
</head>
<body class="top-navigation gray-bg">
	<div class="ibox-content">
		<div class="wrapper wrapper-content">
			<div class="container">
				<div class="row">

					<div class="ibox-content">
						<form:form commandName="EasysearchDTO" class="form-horizontal" action="easySearchPost.do" method="POST">
							<h3>
								<b>EZ Search:</b>
							</h3>
							<div class="search">
								<div class="row">
									<div class="form-group">
										<label class="col-sm-2 control-label"> </label>


										<div class="col-md-6">
											<form:input path="easySearch" name="easySearch" class="form-control"
												placeholder="You can specify Keywords, Experience, Annual Salary and Location(s). Booleans are also allowed" />

										</div>

									</div>



								</div>
							</div>

							<br />





							<button type="submit" class="btn btn-primary">Find
								Resumes</button>
							<button type="reset" class="btn btn-primary">Reset</button>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>



	
</body>
</html>