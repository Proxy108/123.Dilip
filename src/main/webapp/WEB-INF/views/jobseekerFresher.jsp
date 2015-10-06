<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.*"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>



 <jsp:include page="header.jsp" />

</head>


<body class="top-navigation gray-bg">

	<div class="ibox-content">
		<c:if test="${not empty success}">
			<div class="alert alert-success" role="alert">${success}</div>
		</c:if>
		<c:if test="${not empty fail}">
			<div class=" alert alert-error">
				<strong>Fail!</strong>${fail}</div>
		</c:if>
		<div class="wrapper wrapper-content">
			<div class="container">
				<div class="row">

					<div class="ibox-content">



						<form:form commandName="jobseekerRegisterDTO" id="EmpandEDu"
							class="form-horizontal" action="EditupdateEduandExpdetails.do"
							method="POST">

							<form:hidden path="jsid" value="${id}" ></form:hidden>
							
							<%-- <div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Company Name</label>

									<div class="col-md-4">


										<form:hidden path="jsid" value="${id}" ></form:hidden>
										<form:hidden path="edto.employeeType" value="C" ></form:hidden>
										<form:input path="edto.companyName" class="form-control" ></form:input>
									</div>
								</div>
							</div>
							<br />
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Industry Type</label>

									<div class="col-md-4">
										<form:input path="edto.industryType" name="industryType"
											class="form-control" ></form:input>
									</div>
								</div>
							</div>
							<br />
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Designation</label>

									<div class="col-md-4">
										<form:input path="edto.designation" name="designation" value="${jobseekerRegisterDTO.designation }"
											class="form-control" ></form:input>
									</div>
								</div>
							</div>
							<br />
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">CTC</label>

									<div class="col-md-2">
										<form:select path="edto.currentsalLackh" name="currentsalLackh"
											placeholder="Lackhs" class="form-control" >
											<form:option value="0"> Salary In Lackhs</form:option>
											<form:options items="${lac}" />
										</form:select>
									</div>

									<div class="col-md-2">
										<form:select path="edto.currentsalThousand"
											name="currentsalThousand" placeholder="Thousands"
											class="form-control" >
											<form:option value="0"> Salary In Thousands</form:option>
											<form:options items="${thousand}" />
										</form:select>
									</div>
								</div>
							</div>
							<br />

							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Currency Type</label>
									<div class="col-md-4">
										<form:radiobutton path="edto.currencyType" value="M" />
										Indian Rupees
										<form:radiobutton path="edto.currencyType" value="F" />
										USD



									</div>
								</div>
							</div>
							<br />

							<div class="row">
								<div class="form-group">

									<label class="col-sm-2 control-label">Experience From </label>

									<div class="col-md-2">
										<c:forEach var="code" items="${years}">
										<form:select path="edto.joinedyear" name="joinedyear"
											class="form-control" placeholder="Years">
											<form:option value="0"> Select Year</form:option>
											<form:options items="${years}" />
										</form:select>
										</c:forEach>
									</div>
									<div class="col-md-2">
										<form:select path="edto.joinedmonth" name="joinedmonth"
											placeholder="Months" class="form-control">
											<form:option value="0">Select Month</form:option>
											<c:forEach var="month" items="${months}">
												<form:option value="${month.key}">${month.value}</form:option>

											</c:forEach>
										</form:select>
									</div>
								</div>
							</div>
							<br />
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Experience To</label>

									<div class="col-md-2">
										<form:select path="edto.endingyear" name="endingyear"
											placeholder="Years" class="form-control">
											<form:option value="0"> Select Year</form:option>
											<form:option value="0">Fresher</form:option>
											<form:options items="${years}" />
										</form:select>
									</div>
									<div class="col-md-2">
										<form:select path="edto.endingmonth" name="endingmonth"
											placeholder="Months" class="form-control">
											<form:option value="0">Select Month</form:option>
											<form:option value="0">Fresher</form:option>
											<c:forEach var="month" items="${months}">
												<form:option value="${month.key}">${month.value}</form:option>

											</c:forEach>

										</form:select>
									</div>
								</div>
							</div>
							<br />

						<br />
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Job Profile Desc</label>
									<div class="col-md-4">
										<form:textarea path="edto.jobProfileDesc"
											name="jobProfileDesc" id="jobProfileDesc"
											class="form-control" value="" ></form:textarea>
									</div>

								</div>
							</div>

							<br /> --%>
							<h3>
								<b>Create Basic Educational Details: </b>
							</h3>
							<br />
							<div class="row">
								<div class="form-group">
								<label class="col-sm-2 control-label">Education Type</label>
							<div class="col-md-4">
							
										<form:select path="dto.etype" name="etype" id="etype"
											class="form-control" placeholder="etype">
											<form:option value="">Select</form:option>
										<form:option value="SSLC/class 10">SSLC/class 10</form:option>
										<form:option value="PUC/class 12">PUC/class 12</form:option>
										<form:option value="UG">Graduation</form:option>
										<form:option value="PG">Post Graduation</form:option>
										<form:option value="PHD">Phd/Doctarate</form:option>
										
										</form:select>
										<label for="etype" class="error" id="etype-error"></label>
									</div></div></div>
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Education Name</label>

									<div class="col-md-4">
										<form:input path="dto.ename" name="ename" class="form-control"  ></form:input>
									</div>
								</div>
							</div>
							<br />
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Specialization</label>

									<div class="col-md-4">
									<form:input path="dto.specialization" name="specialization" class="form-control" ></form:input>
										
									</div>
								</div>
							</div>
							<br />
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Board/University</label>

									<div class="col-md-4">
										<form:input path="dto.university" name="university"
											class="form-control" ></form:input>
									</div>
								</div>
							</div>
							<br />
							
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Completion Year</label>

									<div class="col-md-4">
										<form:select path="dto.graduateYear" name="graduateYear"
											class="form-control" required="true">

											<form:option value="0"> Select Year</form:option>
											<form:options items="${years}" />
										</form:select>
									</div>
									<label for="dto.graduateYear" class="error" id="dto.graduateYear-error"></label>
								</div>
							</div>
							<br />
							
				<TR><TD>NAME</TD></TR>
							<div id="TextBoxesGroup"></div>
	<input type="button" id="AddSkills" class="btn btn-primary " value="Add Skills" />
	
	<input type="hidden" id="countVariable" value="1"/>
	<script type="text/javascript">
	 $('#AddSkills').click(function(event) {
		 event.preventDefault();
		xLoc=window.pageXOffset;
        yLoc=window.pageYOffset;
		window.scrollTo(150,150); 
		var fileIndexs = $('#TextBoxesGroup tr').length-1;
		
 		var val=$('#countVariable').val();
 		
 		var pNo=val;
 	

		 	
		 
		 	var newTextBoxDiv = $(document.createElement('div')).attr("id", 'TextBoxDiv' + val);
            newTextBoxDiv.html('<table id="ta'+val+'" width="100%" border=0><tr>' + 
            		
            		'<td width="8%"><form:hidden  path="skills.skillId"  class="form-control" placeholder="skills"></form:hidden></td>'+
 			 	  	'<td width="8%"><form:input  path="skills.skillName" value=" " class="form-control" ></form:input></td>'+ 
 			 	  '<td width="8%"><form:input  path="skills.version" value=" " class="form-control" ></form:input></td>'+
 			 	 '<td width="8%"><form:select path="skills.lastused" value=" " name="lastused" placeholder="lastused" class="form-control"><form:options items="${years}" /></form:select></td>'+
 			 	 '<td width="8%"><form:select path="skills.expyears" value=" " name="expyears" placeholder="Years" class="form-control"><form:options items="${expyears}" /></form:select></td>'+
 			 	
 			 	   
 			 	    '<td width="8%"><form:input  path="skills.expmonths" value=" " class="form-control" ></form:input></td></tr>'+
 			 	 
 			 	    '</table>');
 	 			newTextBoxDiv.appendTo("#TextBoxesGroup");
 	 			
	 	 				
	 	 				
	 	 				
								 	 			
					
					event.preventDefault();
				
				
					

				});
	
	</script>
	 <c:set var="count" value="${id + 1}" scope="page"/>



				
	
							<div class="hr-line-dashed"></div>
							<div class="form-group">
								<div class="col-sm-4 col-sm-offset-2">
									<input type="submit" class="btn btn-primary"
										value="create Your Profile" />
									<button class="btn btn-white" type="reset">Reset</button>

								</div>
							</div>


						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
		

	<script type="text/javascript">
$.validator.addMethod("emailpattern", function(value, element) {
	return /^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/.test(value);
}, "please enter valid Email Id");

$.validator.setDefaults({ ignore: ":hidden:not(select)" });
$(document).ready(function(){
	
 	
$("#EmpandEDu").validate({
	
    rules: {
    
    	
    	"dto.ename":{
    		 required: true,
    		
    		
    	},
    	  "dto.specialization": {
    		
            required: true
          
        },
        "dto.university":{
        	 required: true
        },
        "dto.graduateYear":{
       	 required: true
       }
    	
    	    
    	    },
   
messages:{
	
	"dto.ename":{
		 required:"Please enter Education name"
		
	 },
	"dto.specialization":{
		
		 required: "Please enter Specialization"
			
			
				
	}, 
	"dto.university":{
		  required:"Please enter Board/University"
   },
	
   "dto.graduateYear":{
		  required:"Please enter Completion Year"
}
	
}

});


});		


</script> 
	
	
	<script type="text/javascript">
$(document).ready(function(){

 

	
 
	$(":file").filestyle({buttonName: "btn btn-primary"});
	
});
</script>



</body>





</html>

