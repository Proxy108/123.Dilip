
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<!-- <script src="js/ajax.js" type="text/javascript"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link href="css/datepicker.css" rel="stylesheet" type="text/css" />
<link href="css/plugins/chosen/chosen.css" rel="stylesheet"> -->
<jsp:include page="header.jsp"></jsp:include>
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
								<br />
						<div class="form-group">
							<div class="col-sm-4 col-sm-offset-2">
								<a href="buySubscription.do" class="btn btn-primary">Buy</a>
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
	<script type="text/javascript" src="js/bootstrap-filestyle.js"></script> -->
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
