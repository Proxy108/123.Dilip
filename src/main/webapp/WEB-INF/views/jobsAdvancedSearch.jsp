<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<link href="css/bootstrap.min.css" rel="stylesheet"/>
<link href="css/style.css" rel="stylesheet"/>
<link rel="stylesheet"	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"/>
<link href="css/datepicker.css" rel="stylesheet" type="text/css" />
<link href="css/plugins/chosen/chosen.css" rel="stylesheet"/>
<body class="top-navigation gray-bg">

	<div class="ibox-content">
		<div class="wrapper wrapper-content">
			<div class="container">
				<div class="row">

					<div class="ibox-content">



						<form:form commandName="jobseekerRegisterDTO"
							class="form-horizontal" action="advancedJobserchPost.do"
							method="POST">

							<h3>
								<b>Advanced Search </b> 
							</h3>
							<br />
							<div class="row">
							<div class="form-group">
								<label class="col-sm-2 control-label">Key Skills</label>

								<div class="col-md-4">
									<input name="keySkills" class="form-control"></input>
								</div>

							</div>
							</div>
							<br />
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Location</label>

									<div class="col-md-4">
										<input name="location" name="location" class="form-control"></input>
									</div>
								</div>
							</div>
							<br />
							<div class="row">
							<div class="form-group">
								<label class="col-sm-2 control-label">Experience</label>

								<div class="col-md-2">



									<input name="years" class="form-control" placeholder="years"></input>
								</div>
								
								

								<div class="col-md-2">
									<input name="months" name="months" class="form-control"
										placeholder="months"></input>
								</div>
								<label class="col-sm-1 control-label">months</label>
							</div>
							</div>
							<br />
							<br />
							<div class="row">
							<div class="form-group">
								<label class="col-sm-2 control-label"> Salary</label>

								<div class="col-md-2">

									<input name="minSal" class="form-control" placeholder="Min Sal"></input>

								</div>
								<div class="col-md-2">

									<input name="maxSal" class="form-control" placeholder="Max Sal"></input>
								</div>
							</div>
</div>

							<br />

							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Industry Type</label>

									<div class="col-md-4">
										<input name="industryType" name="industryType"
											class="form-control"></input>
									</div>
								</div>
							</div>
							<br />
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Job Type</label>

									<div class="col-md-4">
										<input type="radio" name="jobType" name="jobType"
											>All Jobs
											<input type="radio" name="jobType" name="jobType"
											>Company jobs
											<input type="radio" name="jobType" name="jobType"
											>Consultant jobs
									</div>
								</div>
							</div>
							<br />
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Sort By</label>

									<div class="col-md-4">
										<input type="radio" name="sortby" name="sortby"
											>Relevance
											<input type="radio" name="sortby" name="sortby"
											>Date
											
									</div>
								</div>
							</div>
							<br />
						
							<div class="col-sm-4">
								<button class="btn btn-sm btn-primary pull-right m-t-n-xs"
									type="submit">
									<strong>Search</strong>
								</button>
							</div>



						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="js/city_state.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/bootstrap-datepicker.js"></script>
	<script src="js/date.js" type="text/javascript"></script>
	<script src="js/plugins/chosen/chosen.jquery.js"></script>
</body>
</html>

