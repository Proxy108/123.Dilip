
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="font-awesome/css/font-awesome.css" rel="stylesheet">

<link href="css/plugins/iCheck/custom.css" rel="stylesheet">

<link href="css/plugins/chosen/chosen.css" rel="stylesheet">

<link href="css/plugins/colorpicker/bootstrap-colorpicker.min.css"
	rel="stylesheet">

<link href="css/plugins/cropper/cropper.min.css" rel="stylesheet">

<link href="css/plugins/switchery/switchery.css" rel="stylesheet">

<link href="css/plugins/jasny/jasny-bootstrap.min.css" rel="stylesheet">

<link href="css/plugins/nouslider/jquery.nouislider.css"
	rel="stylesheet">

<link href="css/plugins/datapicker/datepicker3.css" rel="stylesheet">

<link href="css/plugins/ionRangeSlider/ion.rangeSlider.css"
	rel="stylesheet">
<link href="css/plugins/ionRangeSlider/ion.rangeSlider.skinFlat.css"
	rel="stylesheet">

<link href="css/animate.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
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


<body class="top-navigation">
	<form:form name="form" commandName="companyCommand"
		action="authCompany.do" method="post" enctype="multipart/form-data">
		<div class="ibox-content">
			<div class="alert alert-success"></div>
			<h3>
				
			</h3>
			<div class="wrapper wrapper-content">
				<div class="container">
					<div class="row">

						<div class="ibox-content">
							<h3>
								<b> Company Login </b>
							</h3>
							<br />
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Email</label>
									<div class="col-md-4">
										<form:input path="email" class="form-control" />
									</div>
								</div>
							</div>
							<br />
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Password</label>

									<div class="col-md-4">
										<form:password path="password" class="form-control" />
									</div>
								</div>
							</div>
							<br/>
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label"></label>
									<div class="col-md-4">
										${wrongEmailOrPassword}
									</div>
								</div>
							</div>	
							
						</div>

						<div class="hr-line-dashed"></div>
						<div class="form-group">
							<div class="col-sm-4 col-sm-offset-2">
								<form:button class="btn btn-primary" type="submit">Submit</form:button>
								<form:button class="btn btn-white" type="reset">Reset</form:button>

							</div>
						</div>
	</div>
	</div>
	</div>
	</div>
	
	</form:form>
	
	<script src="js/jquery-2.1.1.js"></script>
	<script src="js/bootstrap.min.js"></script>

	<!-- Custom and plugin javascript -->
	<script src="js/inspinia.js"></script>
	<script src="js/plugins/pace/pace.min.js"></script>
	<script src="js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

	<!-- Chosen -->
	<script src="js/plugins/chosen/chosen.jquery.js"></script>

	<!-- JSKnob -->
	<script src="js/plugins/jsKnob/jquery.knob.js"></script>

	<!-- Input Mask-->
	<script src="js/plugins/jasny/jasny-bootstrap.min.js"></script>

	<!-- Data picker -->
	<script src="js/plugins/datapicker/bootstrap-datepicker.js"></script>

	<!-- NouSlider -->
	<script src="js/plugins/nouslider/jquery.nouislider.min.js"></script>

	<!-- Switchery -->
	<script src="js/plugins/switchery/switchery.js"></script>

	<!-- IonRangeSlider -->
	<script src="js/plugins/ionRangeSlider/ion.rangeSlider.min.js"></script>

	<!-- iCheck -->
	<script src="js/plugins/iCheck/icheck.min.js"></script>

	<!-- MENU -->
	<script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>

	<!-- Color picker -->
	<script src="js/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>

	<!-- Image cropper -->
	<script src="js/plugins/cropper/cropper.min.js"></script>
</body>





</html>
