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
<title> Add/Edit Language</title>
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
  width: 560px;
  height: 165px;
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

</style>

<script src="js/bootbox.js"></script>
	<script src="js/bootstrap.min.js"></script>

</head>


<body class="top-navigation gray-bg">
<div class="ibox-content">
	<form:form commandName="jobseekerRegisterDTO"
							class="form-horizontal" action="UpdateLanguage.do"
							method="POST">
						
				<form:hidden path="jsid" value="${lUser.jsid}"/>			
			<table border="1"	class="table table-striped table-bordered table-hover"		id="itemTable" width="100%" style="border-color: #111111">
		<tr bgcolor="#e6e6e6">
			
			
			<td width="1%" align="center"/>
			<td width="6%" align="center"><b>Language Name</b></td>
			<td width="4%" align="center"><b>proficiency</b></td>
			<td width="4%" align="center"><b>Read</b></td>
			<td width="4%" align="center"><b>Write </b></td>
			<td width="4%" align="center"><b>Speak</b></td>
			
			<td width="4%" align="center"><b>Action</b></td>
			
			
		</tr>


	</table>
							
		<script type="text/javascript">
		 function deleteLang(val){
			
		 bootbox.confirm("Are you sure you want to Delete ?", function(result) { 
				if(result == true){
					var dataString='id='+val;
					$.ajax({
						type: "POST",
						url: "DeleteLanguage.do",
						data: dataString,
						cache: false,
						success: function(){
							 window.location.reload(true);
							
							}
					
					
				});
				}
				
				
			});
		} 
function diss(){
		<c:forEach var="lan" items="${langDetails}" varStatus="status">
		
		var jlid='${lan.jlid}';
	
		
	
	var newTextBoxDiv = $(document.createElement('div')).attr("id", 'TextBoxDivs' + jlid);
    newTextBoxDiv.html('<table id="ta'+jlid+'" width="100%" border=0><tr>' + 
    		
    		'<td width="2%"><form:hidden  path="lan.jlid" style="width:80%;" id="jlid" name="jlid" value="${lan.jlid}" ></form:hidden></td>'+
    		
    		'<td width="2%"><form:input  path="lan.langname" style="width:80%;" id="langname" name="lan" class="form-control" value="${lan.langname}"  ></form:input></td>'+
    		'<td width="2%"><form:select path="lan.profeciency" name="profeciency" class="form-control"><form:option value="${lan.profeciency}" >${lan.profeciency} </form:option><form:option value="Beginer">Beginer</form:option><form:option value="Proficient">Proficient</form:option><form:option value="Expert">Expert</form:option></form:select></td>'+
    		'<td width="1%"><form:select path="lan.lread" name="lread" class="form-control"><form:option value="${lan.lread}" >${lan.lread} </form:option><form:option value="Yes">Yes</form:option><form:option value="No">No</form:option></form:select></td>'+
    		'<td width="1%"><form:select path="lan.lwrite" name="lread" class="form-control"><form:option value="${lan.lwrite}" >${lan.lwrite} </form:option><form:option value="Yes">Yes</form:option><form:option value="No">No</form:option></form:select></td>'+
    		'<td width="1%"><form:select path="lan.lspeak" name="lspeak" class="form-control"><form:option value="${lan.lspeak}" >${lan.lspeak} </form:option><form:option value="Yes">Yes</form:option><form:option value="No">No</form:option></form:select></td>'+
    		'<td style="display:none;"><form:hidden path="lan.lid" style="width:0%;" id="lid" name="lid" value="${lan.jlid}" ></form:hidden></td>'+
    		 '<td width="4%"> <a  onclick="deleteLang('+jlid+')";  id="danger" class="btn btn-danger"><i class="icon-trash icon-white"></i>Delete </a></td></tr>'+   
    		'</table>');
			newTextBoxDiv.appendTo("#TextBoxesGroups");	
			
			</c:forEach>
	}

</script>	
		<div id="TextBoxesGroups"></div>					
		 <script type="text/javascript">diss();</script>							


		


	<input type="button" id="AddLang" class="btn btn-primary " value="Add Language" />
	<script type="text/javascript">
	 $('#AddLang').click(function(event) {
		 
		 var fileIndexs = $('#TextBoxesGroups tr').length-1;
			
	 		var val=fileIndexs;
	 		
	 		
 	if(val<5){
		 
		 	var newTextBoxDiv = $(document.createElement('div')).attr("id", 'TextBoxDivs' + val);
            newTextBoxDiv.html('<table id="ta'+val+'" width="100%" border=0><tr>' + 
            		'<td width="2%"><form:hidden  path="lan.jlid" style="width:80%;" id="jlid'+val+'" name="jlid'+val+'"  ></form:hidden></td>'+
            		'<td width="2%"><form:input  path="lan.langname"   style="width:100%;" id="langname'+val+'" name="langname'+val+'" class="form-control"  ></form:input></td>'+
            		'<td width="1%"><form:select path="lan.profeciency" name="profeciency" class="form-control"><form:option value="Beginer">Beginer</form:option><form:option value="Proficient">Proficient</form:option><form:option value="Expert">Expert</form:option></form:select></td>'+
            		'<td width="1%"><form:select path="lan.lread" name="lread" class="form-control"><form:option value="Yes">Yes</form:option><form:option value="No">No</form:option></form:select></td>'+
            		'<td width="1%"><form:select path="lan.lwrite" name="lread" class="form-control"><form:option value="Yes">Yes</form:option><form:option value="No">No</form:option></form:select></td>'+
            		'<td width="1%"><form:select path="lan.lspeak" name="lspeak" class="form-control"><form:option value="Yes">Yes</form:option><form:option value="No">No</form:option></form:select></td>'+
					'<td width="2%"><form:hidden  path="lan.lid" style="width:80%;" id="lid'+val+'" name="lid'+val+'" value="0" ></form:hidden></td></tr>'+
 			 	    '</table>');
 	 			newTextBoxDiv.appendTo("#TextBoxesGroups");
 	 			
	 	 				
	 	 				
 	}else{
 		alert("sorry only 5 languages");
 	}		
								 	 			
					
					event.preventDefault();
				
				
					

				});
	
	</script>
		<input type="submit" class="btn btn-primary"  value="Submit"/>
		<a href="viewJobProfile.do" class="btn btn-info" >Cancel</a>
	</form:form></div>

</body>
</html>