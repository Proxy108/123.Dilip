<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 <link rel="stylesheet" type="text/css" href="css/style2.css" />
<link rel="stylesheet"href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"/>
<jsp:include page="adminHeader.jsp" ></jsp:include>
<style >
.lang1 {
    width: 50%;

    margin-top: 25px;
    margin-left: 265px; }
</style>
</head>
<body>

<div class="wrap">
<c:if test="${not empty msg}">
<div style="">${msg}</div>
</c:if>

<div class="lang1">

<%-- <div class="table">
	<!-- <div class="block1"> --> 
	
		<p><b>${msg}</b></p>
	
	
<!-- </div> -->

</div> --%></div>

<div class="lang1">

<div class="table">
	<!-- <div class="block1"> --> 
	
		<p><b>Contact Us</p><br/>
<p>Landline: 0120-49600000000</p><br/>
<p>Email: admin@ejobzz.com</p><br/>
<p>Toll Free: 1800 102 5528</p>
</b></p>
	
	
<!-- </div> -->

</div>



</div>
</div>




<jsp:include page="footer.jsp" />

</body>
</html>
