<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add/Edit Skills </title>
<jsp:include page="jobseekerLoginHeadder.jsp" />


<style type="text/css">

.table	{	width:100%; float:none !important;}
.form-control{float: left;
margin:10px;
}
.btn-danger {
float: left;
margin:10px;
}

 .modal {
  position: fixed;
  top: 10%;
  left: 50%;
  z-index: 1050;
  height: 165px;
  width: 560px;
  margin-left: -280px;
  background-color: #ffffff;
  border: 1px solid #999;
  border: 1px solid rgba(0, 0, 0, 0.3);
  *border: 1px solid #999;
  -webkit-border-radius: 6px;
     -moz-border-radius: 6px;
          border-radius: 6px;
  outline: none;
  -webkit-box-shadow: 0 3px 7px rgba(0, 0, 0, 0.3);
     -moz-box-shadow: 0 3px 7px rgba(0, 0, 0, 0.3);
          box-shadow: 0 3px 7px rgba(0, 0, 0, 0.3);
  -webkit-background-clip: padding-box;
     -moz-background-clip: padding-box;
          background-clip: padding-box;
} 
.bootbox modal{
left: 47% !imporant;
}
</style>
    <script src="js/bootstrap.min.js"></script>

 <script src="js/bootbox.js"></script>
</head>


<body class="top-navigation gray-bg">
<div class="ibox-content">
	<form:form commandName="jobseekerRegisterDTO"
							class="form-horizontal" action="UpdateSkills.do"
							method="POST">
				<form:hidden path="jsid" value="${lUser.jsid}"/>			
			<table  border="1"	class="table table-striped table-bordered table-hover"		id="itemTable" width="100%" style="border-color: #111111; float:left;">
		<tr bgcolor="#e6e6e6">
			
			
			<td width="4%" align="center"/>
			<td width="4%" align="center"><b>Skill Name</b></td>
			
			<td width="4%" align="center"><b>Version</b></td>
			<td width="4%" align="center"><b>Last Used </b></td>
			<td width="4%" align="center"><b>Experience Years</b></td>
			<td width="4%" align="center"><b>Experience Months</b></td>
			<td width="4%" align="center"><b>Action</b></td>
			
			
		</tr>

</table>
						
			<script type="text/javascript">
			 function deleteSkill(val){
					
				 bootbox.confirm("Are you sure you want to Delete  ?", function(result) { 
						if(result == true){
							var dataString='id='+val;
							$.ajax({
								type: "POST",
								url: "DeleteSkills.do",
								data: dataString,
								cache: false,
								success: function(){
									 window.location.reload(true);
									
									}
							
							
						});
						}
						
						
					});
				} 
function dis(){
	
	
		<c:forEach var="skill" items="${skillset}">
		
		var skillid='${skill.skillId}';
		
		
	var newTextBoxDiv = $(document.createElement('div')).attr("id", 'TextBoxDiv' + skillid);
    newTextBoxDiv.html('<table id="ta'+skillid+'" width="100%"  border=0><tr>' + 
    		
    		'<td width="4%"><form:hidden  path="skills.skillId" class="form-control"  value="${skill.skillId}" ></form:hidden></td>'+
		 	  	'<td width="4%"><form:input  path="skills.skillName" class="form-control" value="${skill.skillName}"  ></form:input></td>'+ 
		 	  '<td width="4%"><form:input  path="skills.version" class="form-control"   value="${skill.version}"></form:input></td>'+
		
		 	'<td width="4%"><form:select path="skills.lastused" name="lastused"  class="form-control"><form:option value="${skill.lastused}" >${skill.lastused} </form:option><form:options items="${years}" /></form:select></td>'+
		 	  '<td width="4%"><form:select path="skills.expyears" name="expyears" class="form-control"><form:option value="${skill.expyears}" >${skill.expyears} </form:option><form:options items="${expyears}" /></form:select></td>'+
		 	 
		 	'<td width="4%"><form:select path="skills.expmonths" name="expmonths"  class="form-control"><form:option value="${skill.expmonths}" >${skill.expmonths} </form:option><form:options items="${skillmonth}" /></form:select></td>'+
		 	  
		 	    '<td width="4%"> <a  onclick="deleteSkill('+skillid+')";   id="danger" class="btn btn-danger"><i class="icon-trash icon-white"></i>Delete </a></td>'+
		 	   '<td style="display:none;"><form:hidden  path="skills.skilid" class="form-control"  value="${skill.skillId}"></form:hidden></td></tr>'+
		 	 
		 	    '</table>');
			newTextBoxDiv.appendTo("#TextBoxesGroup");	
			
			</c:forEach>
		

}

</script>	
	
				<div id="TextBoxesGroup"></div>					
		 <script type="text/javascript">dis();</script>							



<!-- <script src="js/jquery-2.1.1.js"></script -->

	<input type="button" id="AddSkills" class="btn btn-primary " value="Add Skills" />
	<script type="text/javascript">
	 $('#AddSkills').click(function(event) {
		 
		var fileIndexs = $('#TextBoxesGroup tr').length-1;
		
 		var val=fileIndexs;
 		
 		
		 	
		 
		 	var newTextBoxDiv = $(document.createElement('div')).attr("id", 'TextBoxDiv' + val);
            newTextBoxDiv.html('<table id="ta'+val+'"  width="100%" border=0><tr>' + 
            		
            		'<td style="display:none;" ><form:hidden  path="skills.skillId"  id="proUnit'+val+'" name="proUnit'+val+'"  ></form:hidden></td>'+
 			 	  	'<td width="1%"><form:input  path="skills.skillName" class="form-control"  id="proUnit'+val+'" name="proUnit'+val+'" value=""></form:input></td>'+ 
 			 	  '<td width="1%"><form:input  path="skills.version" class="form-control"  id="proUnit'+val+'" name="proUnit'+val+'" value=""></form:input></td>'+
 			 	'<td width="1%"><form:select path="skills.lastused" name="lastused"  class="form-control"><form:option value="0" >Select Last Used </form:option><form:options items="${years}" /></form:select></td>'+
 			 	  '<td width="1%"><form:select path="skills.expyears" name="expyears" class="form-control"><form:option value="0"> Select Year</form:option><form:options items="${expyears}" /></form:select></td>'+ 
 			 	 '<td style="display:none;" ><form:hidden  path="skills.skilid" class="form-control" id="proUnit'+skillid+'" value="0" ></form:hidden></td>'+ 
 			 	   
 			 	'<td width="1%"><form:select path="skills.expmonths" name="expmonths" class="form-control"><form:option value="0"> Select Month</form:option><form:options items="${skillmonth}" /></form:select></td></tr>'+
 			 	 
 			 	    '</table>');
 	 			newTextBoxDiv.appendTo("#TextBoxesGroup");
 	 			
	 	 				
	 	 				
	 	 				
								 	 			
					
					event.preventDefault();
				
				
					

				});
	
	</script>
		<input type="submit" class="btn btn-primary"  value="Submit"/>
		<a href="viewJobProfile.do" class="btn btn-info" >Cancel</a>
	</form:form></div>
<!-- <script type="text/javascript" src="js/city_state.js"></script>
	<script type="text/javascript" src="js/bootstrap-datepicker.js"></script>
	<script src="js/date.js" type="text/javascript"></script>
	<script src="js/plugins/chosen/chosen.jquery.js"></script>
	<script type="text/javascript" src="js/bootstrap-filestyle.js"></script>
	<script src="js/inspinia.js"></script>	
  <script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>
	<script src="js/plugins/slimscroll/jquery.slimscroll.min.js"></script>  -->
</body>
</html>