
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>Bulk Mail Preview</title>
<!-- <link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link href="css/datepicker.css" rel="stylesheet" type="text/css" />
<link href="css/plugins/chosen/chosen.css" rel="stylesheet"> -->
<jsp:include page="adminHeader.jsp"></jsp:include>

<style>
.btn-file {
	position: relative;
	overflow: hidden;
}

.btn-file hidden[type=file] {
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
</style>

</head>

<body class="top-navigation gray-bg">

	<form:form name="form" commandName="mailCommand"
		action="sendbulkMail.do" method="post" >
		<div class="ibox-content">
			<div class="wrapper wrapper-content">
				<div class="container">

						<div class="ibox-content">
							<h4>
								<b>Contact Selected Candidate(s)</b>
							</h4>
							<br />
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Your Email ID:</label>
									<div class="col-md-4">
										${mailCommand.emailId}
										<form:hidden path="emailId" class="form-control" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">*Subject / Job
										Title:</label>
									<div class="col-md-4">
										${mailCommand.subject}
										<form:hidden path="subject" class="form-control" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Email:</label>
									<div class="col-md-4">
										${mailCommand.recruiterEmailId}
										<form:hidden path="recruiterEmailId" class="form-control" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Job Experience:</label>
									<div class="col-md-2">
										${mailCommand.jobExpFrom}
										<form:hidden path="jobExpFrom" class="form-control" />
									</div>
									<div class="col-md-1">
										 to
										</div>
									<div class="col-md-2">
										${mailCommand.jobExpTo}
										<form:hidden path="jobExpTo" class="form-control" />
									</div>
									<div class="col-md-0">
										In Years
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Job CTC:</label>
									<div class="col-md-2">
										${mailCommand.ctcFromLac}
										<form:hidden path="ctcFromLac" name="state" class="form-control"></form:hidden>
									</div>
										<div class="col-md-1">
										Lacs to
										</div>
										
									<div class="col-md-2">
										${mailCommand.ctcToLac}
										<form:hidden path="ctcToLac" name="state" class="form-control"></form:hidden>
									</div>
								</div>	
							</div>
							<br/>
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Other Salary
										Details:</label>
									<div class="col-md-4">
										${mailCommand.otherSalaryDetails}
										<form:hidden path="otherSalaryDetails" class="form-control" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Job Location :</label>
									<div class="col-md-4">
										${mailCommand.jobLoc}
										<form:hidden path="jobLoc" class="form-control" />
									</div>
								</div>
							</div>
							
							<br/>
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Message:</label>
									<div class="col-md-4">
										${mailCommand.message}
										<form:hidden path="message" class="form-control" />
									</div>
								</div>
							</div>
							<br/>
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Signature :</label>
									<div class="col-md-4">
										${mailCommand.signature}
										<form:hidden path="signature" class="form-control" />
									</div>
								</div>
							</div>
							<br />

						</div>

						<div class="hr-line-dashed"></div>
						<div class="form-group">
							<div class="col-sm-4 col-sm-offset-2">
								<form:button class="btn btn-primary" type="submit">Send</form:button>
								</form:form></br></br>
						<form:form name="form" commandName="mailCommand" action="modifybulkContact.do" method="post" >
								<form:hidden path="ctcToLac" name="state" class="form-control"></form:hidden>
								<form:hidden path="subject" class="form-control" />
								<form:hidden path="otherSalaryDetails" class="form-control" />
								<form:hidden path="otherSalaryDetails" class="form-control" />
								<form:hidden path="jobLoc" class="form-control" />
								<form:hidden path="message" class="form-control" />
								<form:hidden path="signature" class="form-control" />
								<form:hidden path="ctcFromLac" name="state" class="form-control"></form:hidden>
								<form:hidden path="jobExpTo" class="form-control" />
								<form:hidden path="jobExpFrom" class="form-control" />
								<form:hidden path="recruiterEmailId" class="form-control" />
								<form:hidden path="emailId" class="form-control" />
								<form:button class="btn btn-primary" type="submit">Modify</form:button>
						 </form:form>	
							
							</div>
						</div>
					</div>
					<div class="col-lg-4">
						<div class="ibox float-e-margins"></div>
					</div>
				</div>
			</div>
		</div>
	


<!-- 	<script src="js/jquery-2.1.1.js"></script>
	<script type="text/javascript" src="js/city_state.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/bootstrap-datepicker.js"></script>
	<script src="js/date.js" type="text/javascript"></script>
	<script src="js/plugins/chosen/chosen.jquery.js"></script>
	<script type="text/javascript" src="js/bootstrap-filestyle.js"></script>
	<script src="js/DilipJs/ajax.js" type="text/javascript"></script> -->
	<!-- JSKnob -->
	<script type="text/javascript">
		$(document).ready(function() {
			$(":file").filestyle({
				buttonName : "btn btn-primary"
			});
		});
	</script>
</body>





</html>
