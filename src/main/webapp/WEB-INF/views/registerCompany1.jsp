
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<script src="js/ajax.js" type="text/javascript"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link href="css/datepicker.css" rel="stylesheet" type="text/css" />
<link href="css/plugins/chosen/chosen.css" rel="stylesheet">
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
<jsp:include page="header.jsp"></jsp:include>

<body class="top-navigation gray-bg">
	<div id="modal-form" class="modal fade" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-body">
					<div class="row">
						<div class="col-sm-6 b-r">
							<h3 class="m-t-none m-b">Sign in</h3>

							<p>Sign in today for more expirience.</p>

							<form role="form">
								<div class="form-group">
									<label>Email</label> <input type="email"
										placeholder="Enter email" class="form-control">
								</div>
								<div class="form-group">
									<label>Password</label> <input type="password"
										placeholder="Password" class="form-control">
								</div>
							</form>
						</div>
						<div class="col-sm-6">
							<h4>Not a member?</h4>
							<p>You can create an account:</p>
							<p class="text-center">
								<a href=""><i class="fa fa-sign-in big-icon"></i></a>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<form:form name="form" commandName="companyCommand"
		action="takeCompanyOrder.do" method="post" enctype="multipart/form-data">
		<div class="ibox-content">
			<div class="wrapper wrapper-content">
				<div class="container">
					<table style="float: right;">
						<tbody>
							<tr>
								<td></td>
							</tr>
							<tr>
								<td colspan="2" class="bold">Your Order Preview:</td>
							</tr>
							<tr>
								<td valign="top">Buy 700 Quick Job Posting and Get 50
									Posting Free</td>
								<td valign="top" nowrap="">: Rs. ${sessionScope.amount}</td>
							</tr>
							<tr>
								<td id="service_tax">Service Tax (14%)</td>
								<td nowrap="" id="tax_cur">: Rs. ${sessionScope.taxAmt}</td>
							</tr>
							<tr>
								<td class="Form_bold" align="right">Total Price</td>
								<td class="Form_bold" nowrap="" id="tot_price">: Rs.
									${sessionScope.totalAmt}</td>
							</tr>
						</tbody>
					</table>


					<div class="row">

						<div class="ibox-content">
							<h3>
								<b>Register Your Company:</b>
							</h3>
							<br />
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Company Name</label>
									<div class="col-md-4">
										<form:input path="name" class="form-control" />
									</div>
								</div>
							</div>
							<br />
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Email(Login)</label>

									<div class="col-md-4">
										<form:input path="email" class="form-control" />
									</div>
								</div>
							</div>
							<br />
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Password(Login)</label>

									<div class="col-md-4">
										<form:password path="password" class="form-control" />
									</div>
								</div>
							</div>

							<br />
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Phone No.</label>

									<div class="col-md-4">
										<form:input path="phoneNo" class="form-control" />
									</div>
								</div>
							</div>
							<br />
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Industry Type</label>

									<div class="col-md-4">
										<form:input path="type" class="form-control" />
									</div>
								</div>
							</div>
							<br />
							<div class="row">
								<div class="form-group">

									<label class="col-sm-2 control-label">Address </label>
									<div class="col-md-4">
										<form:textarea path="address" id="address" rows="3"
											class="form-control"></form:textarea>
									</div>
								</div>
							</div>
							<br />
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Country </label>

									<div class="col-md-4">
										<form:select path="country" name="country"
											placeholder="country" class="form-control">
											<form:option value="india" selected="selected">India</form:option>
										</form:select>
									</div>
								</div>
							</div>
							<br />
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">State </label>


									<div class="col-md-4">
										<form:select path="state" name="state" id="state"
											placeholder="state" class="form-control"
											onchange="getDistricts(this.value)">
											<form:option value="0" selected="selected">Select</form:option>
											<c:forEach items="${stateList}" var="state1">
												<form:option value="${state1.name}">${state1.name}</form:option>
											</c:forEach>
										</form:select>
									</div>
								</div>
							</div>
							<br />
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">City</label>
									<div class="col-md-4">
										<form:select path="city" name="city" id="city"
											placeholder="city" class="form-control">
											<form:option value="0" selected="selected">Select</form:option>
										</form:select>
									</div>
								</div>
							</div>
							<br />
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Pin code</label>

									<div class="col-md-4">
										<form:input path="pin" class="form-control" />
									</div>
								</div>
							</div>
							<br />
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Contact Person </label>

									<div class="col-md-4">
										<form:input path="contactPersionName" class="form-control" />
									</div>
								</div>
							</div>
							<br />

							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Upload Company
										Logo</label>
									<div class="col-md-4">
										<input type="file" name="file" id="picfile" class="filestyle"
											data-buttonName="btn-primary" />
									</div>


								</div>
							</div>

						</div>
					
						<div class="hr-line-dashed"></div>
						<br />
						<div class="form-group">
							<div class="col-sm-4 col-sm-offset-2">
								<form:button class="btn btn-primary" type="submit">Submit</form:button>
								<form:button class="btn btn-white" type="reset">Reset</form:button>
								<a href="orderLogin.do" class="btn btn-primary">Login</a>

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
	<hr/>
	<form:form name="form" commandName="companyCommand"
		action="takeCompanyOrder.do" method="post" >
		user Id : <form:input path="email" class="form-control" /><br/>
		Password : <form:input path="password" class="form-control" /><br/>
		<form:button class="btn btn-primary" type="submit">Submit</form:button>
	</form:form>	
	

	<script src="js/jquery-2.1.1.js"></script>
	<script type="text/javascript" src="js/city_state.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/bootstrap-datepicker.js"></script>
	<script src="js/date.js" type="text/javascript"></script>
	<script src="js/plugins/chosen/chosen.jquery.js"></script>
	<script type="text/javascript" src="js/bootstrap-filestyle.js"></script>
	<script src="js/DilipJs/ajax.js" type="text/javascript"></script>
	<!-- JSKnob -->
	<script type="text/javascript">
$(document).ready(function(){
	$(":file").filestyle({buttonName: "btn btn-primary"});
});
	
</script>
</body>
</html>
<jsp:include page="footer.jsp" />
