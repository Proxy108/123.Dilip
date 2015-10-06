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
<title>Jobs By Designation</title>
<jsp:include page="header.jsp"/>
<!-- <link rel="stylesheet" href="http://jqueryvalidation.org/files/demo/site-demos.css">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="font-awesome/css/font-awesome.css" rel="stylesheet">
<link href="css/animate.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"> -->
</head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body class="top-navigation gray-bg">
		<div class="ibox-content" >
			<div class="wrapper wrapper-content" >
				<div class="container">
					
		
		<div class="row">
				<style>
				
				.ibox-content h3	{	line-height:25px;}</style>
						<div class="ibox-content">
							
						<h3>Jobs By Designation</h3>
						<a href="GetJobsByDesignation.do?design=java developer"><h3>java developer</h3></a>
						<a href="GetJobsByDesignation.do?design=php developer"><h3>php developer</h3></a>
							<a href="GetJobsByDesignation.do?design=c developer"><h3>c developer</h3></a>
		
						<a href="GetJobsByDesignation.do?design=web Designer"><h3>web Designer</h3></a>
						<a href="GetJobsByDesignation.do?design=Database administrator"><h3>Database administrator</h3></a>
		
						<a href="GetJobsByDesignation.do?design=associate software engineer"><h3>associate software engineer</h3></a>
						<a href="GetJobsByDesignation.do?design=sr. java developer software engineer"><h3>sr. java developer software engineer</h3></a>
						<a href="GetJobsByDesignation.do?design=team lead software engineer"><h3>team lead software engineer</h3></a>
						<a href="GetJobsByDesignation.do?design=associate developer"><h3>associate developer</h3></a>
						<a href="GetJobsByDesignation.do?design=Ui designer"><h3>Ui designer</h3></a>
		
		</div>
		
		
		</div>
		</div>
		</div>
		</div>
<!-- <script src="js/jquery-2.1.1.js"></script>
<script src="http://jqueryvalidation.org/files/dist/jquery.validate.min.js"></script>
<script src="http://jqueryvalidation.org/files/dist/additional-methods.min.js"></script>

<script type="text/javascript" src="jquery.validate.js"></script>

	<script src="js/bootstrap.min.js"></script>
	<script src="js/bootbox.js"></script>
	<script type="text/javascript" src="js/bootstrap-filestyle.js"></script>
		<script src="js/inspinia.js"></script>	
	<script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>
	<script src="js/plugins/slimscroll/jquery.slimscroll.min.js"></script> -->
		<jsp:include page="footer.jsp"/>
</body>
</html>