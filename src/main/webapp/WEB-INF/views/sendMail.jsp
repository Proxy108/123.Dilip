<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>


<jsp:include page="adminHeader.jsp"></jsp:include>
<style>
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
</style>

</head>

<body class="top-navigation gray-bg">

	<form:form name="form" commandName="mailCommand"
		action="mailPreview.do" method="post">
		<div class="ibox-content">
			<div class="wrapper wrapper-content">
				<div class="container">
					<div class="row">

						<div class="ibox-content">
							<h4>
								<b>Contact Selected Candidate(s)</b>
							</h4>
							<br />
						 <div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label"><font color="red">*</font>Your Email ID:</label>
									<div class="col-md-4">
										<form:input path="emailId" class="form-control" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label"><font color="red">*</font>Subject / Job
										Title:</label>
									<div class="col-md-4">
										<form:input path="subject" class="form-control" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Email (Ejobzz Registered):</label>
									<div class="col-md-4">
										<form:input path="recruiterEmailId" class="form-control" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Job Experience:</label>
									<div class="col-md-2">
										<form:input path="jobExpFrom" class="form-control"  placeholder="yy.mm"/>
									</div>
									<div class="col-md-1">
										to
										</div>
									<div class="col-md-2">
										<form:input path="jobExpTo" class="form-control" placeholder="yy.mm"/>
									</div>
									
								</div>
							</div>
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Job CTC:</label>
									<div class="col-md-2">
										<form:select path="ctcFromLac" name="state" class="form-control">
											
											<form:option value="0">0</form:option>	
											<form:option value="1">1</form:option>
											<form:option value="2">2</form:option>
											<form:option value="3">3</form:option>
											<form:option value="4">4</form:option>
											<form:option value="5">5</form:option>
						
										</form:select>
									</div>
										<div class="col-md-1">
										Lacs to
										</div>
										
									<div class="col-md-2">
										<form:select path="ctcToLac" name="state" class="form-control">
											
											<form:option value="0">0</form:option>	
											<form:option value="1">1</form:option>
											<form:option value="2">2</form:option>
											<form:option value="3">3</form:option>
											<form:option value="4">4</form:option>
											<form:option value="5">5</form:option>
						
										</form:select>
									</div>
								</div>	
							</div>
							<br/>
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Other Salary
										Details:</label>
									<div class="col-md-4">
										<form:input path="otherSalaryDetails" class="form-control" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group">
								<label class="col-sm-2 control-label"></label>
								<label class="col-sm-6 control-label\">Specify salary details like incentives, reimbursements, breakup of salary, or "Best in the Industry" etc.</label>
								</div>
							</div><br/>	
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Job Location :</label>
									<div class="col-md-4">
										<form:input path="jobLoc" class="form-control" />
									</div>
								</div>
							</div>
							
							<br/>
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label"><font color="red">*</font> Message:</label>
									<div class="col-md-5">
										<form:textarea path="message" class="form-control" style="width: 100%; height: 126px;"/>
									</div>
								</div>
							</div>
							<br/>
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Signature :</label>
									<div class="col-md-5">
										<form:textarea path="signature" class="form-control" style="width: 100%; height: 50px;"/>
									</div>
								</div>
							</div>
							
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label"></label>
									<div class="col-md-5">
									<font color="green" size="2" style="float:right;">Maximum characters 250</font>
									</div>
								</div>
							</div>
							<br />

						</div>

						<div class="hr-line-dashed"></div>
						<div class="form-group">
							<div class="col-sm-4 col-sm-offset-2">
								<form:button class="btn btn-primary" type="submit">Review & Send</form:button>
								<form:button class="btn btn-white" type="reset">Cancel</form:button>

							</div>
						</div>
					</div>
					<div class="col-lg-4">
						<div class="ibox float-e-margins"></div>
					</div>
				</div>
			</div>
		</div>
	</form:form>


	<!-- <script src="js/jquery-2.1.1.js"></script>
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