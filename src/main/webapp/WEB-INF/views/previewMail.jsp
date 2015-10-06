
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<head>
<!-- <link href="css/bootstrap.min.css" rel="stylesheet">
<link href="font-awesome/css/font-awesome.css" rel="stylesheet">

<link href="css/animate.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet"> -->
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
	<div class="ibox-content">
			<div class="wrapper wrapper-content">
				<div class="container">

						<div class="ibox-content">
	
		
						<b>Below is the format of mail which will go out to jobseeker, please review it and send the mail</b><br/><br/>
						${htmlmail}
						
				</div>				
			</div>
		</div>
		</div>

		






	
