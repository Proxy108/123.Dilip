<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title>Search Error</title>


 <script src="js/page.js"></script>


<jsp:include page="adminHeader.jsp"></jsp:include>
</head>


<body class="top-navigation gray-bg">
	<div class="wrapper wrapper-content">
	
		<div class="row">

			
			<br/><br/><br/><br/>
			<div class="col-lg-12">
				<div class="ibox float-e-margins">
					
					<div class="ibox-title">
					
						
							<div class="alert alert-danger">No relevant matches found. Please modify your search criteria. 
							</div>
						
					
					</div>
					
					<input type='hidden' id='current_page' />  
<input type='hidden' id='show_per_page' /> 

					<div class="ibox-content inspinia-timeline" id="test">
					 
				
				<form:form name="form" commandName="ITSearchDto" action="modifyadminSearch.do" method="post" >
								<form:hidden path="anyKeyWords" ></form:hidden>
								<form:hidden path="allKeyWords"  />
								<form:hidden path="excludingkey"  />
						
								<form:hidden path="minExpYear"  />
								<form:hidden path="maxExpYear"  />
								<form:hidden path="minSalLac"  />
								<form:hidden path="minSalThousand"  />
								<form:hidden path="maxSalLac"  />
								<form:hidden path="maxSalThousand"  />
								
								<form:hidden path="location"  />
								<form:hidden path="preferedLocation"  />
								<form:hidden path="industryType"  />
								<form:hidden path="currentEmployer"  />
								
								<form:hidden path="excludeEmployer"  />
								<form:hidden path="desingnation"  />
								<form:hidden path="ugQualification"  />
								<form:hidden path="institute"  />
								
								<form:hidden path="passingYearFrom"  />
								<form:hidden path="passingYearTo"  />
								<form:hidden path="activeDays"  />
								
								<center><form:button class="btn btn-primary" type="submit" >Modify Search</form:button>&nbsp;&nbsp;&nbsp;&nbsp;<a href="advSearch.do" class="btn btn-primary" >New Search</a></center>
						 </form:form>
			
							
							
							</div>
						</div>


	




	</div>
	</div></div><br/><br/><br/><br/><br/>
	
<jsp:include page="footer.jsp"></jsp:include>
</body></html>
