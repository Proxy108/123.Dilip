<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<head>

<title>Easy Search</title>
 <script src="js/page.js"></script>
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
<style type="text/css">
 #content p{text-indent:20px;text-align:justify;}

	#pagingControls ul{display:inline;padding-left:0.5em}

	#pagingControls li{ position: relative;
  float: left;
  padding: 6px 12px;
  margin-left: -1px;
  line-height: 1.42857143;
  color: #1B242F;
  text-decoration: none;
  background-color: #fff;
  border: 1px solid #ddd;}  

</style>
<jsp:include page="adminHeader.jsp"></jsp:include>
</head>


<body class="top-navigation gray-bg">
	<div class="wrapper wrapper-content">
	
		<div class="row">

			<div class="col-lg-2"
				style="margin-left: 9%; background: #ffffff; margin-top: 3%;">
				<div class="ibox float-e-margins">

					<div class="ibox-content">


						<div class="feed-activity-list">

							<div class="feed-element">
								<b><center>Refine Result</center></b>
								<hr/>
								<form action="easySearchagain.do" method="post">
								<div class="row">
									<div class="form-group">
										<label class="col-sm-6 control-label">All Key Word</label>

										<div class="col-md-12">
											<input class="form-control" name="KeyofWord"
												placeholder="Seprate with comma(,)">
										</div>
									</div>

									
									
										<input type="submit" value="Search" class="btn btn-primary" />
							<input type="reset" value="Reset" class="btn" />
							
							</form>
								</div>
							</div>
						</div>

					</div>

				</div>


			</div>
			
			<div class="col-lg-8">
				<div class="ibox float-e-margins">
					
					<div class="ibox-title">
					
						<c:if test="${noOfJobs ne null}">
							<div class="alert alert-success">(${noOfJobs}) Jobs Found !
							</div>
						</c:if>
					
					</div>
					
					<input type='hidden' id='current_page' />  
<input type='hidden' id='show_per_page' /> 

					<div class="ibox-content inspinia-timeline" id="test">
					 
				<c:if test="${subscribed eq '1'}">
   

				 	<input type="checkbox" id="parentId" value="">Select All</input> 
		 			<button class="btn btn-primary" id="save_value" > SEND EMAIL</button> 
		 		</c:if>	<br/><br/><br/>
				<form:form name="form" commandName="EasysearchDTO" action="modifyeasySearch.do" method="post" >
				
						<form:hidden path="easySearch"/>
								
								
								<form:button class="btn btn-primary" type="submit">Modify</form:button>
								&nbsp;&nbsp;&nbsp;&nbsp;<a href="easySearch.do" class="btn btn-primary" >New Search</a>
						 </form:form>
						<div class="timeline-item" id='contents'>
							<div class="row">
							
							
								<c:forEach items="${JobSeekerList}" var="jobSeeker">
									<!-- <a href=""> -->
									<!-- <div class="ibox-content" id="searchtext">-->
							
									<div class="list-group-1">
									<c:if test="${subscribed eq '1'}">
									<input type="checkbox" id="emailchecked" name="emailchecked" class="checkbox1"value="${jobSeeker.email}"/>
									</c:if>
										<a class="list-group-item" href="preview.do?jsid=${jobSeeker.jsid}">
											<h4 class="list-group-item-heading" style="color: #0079D0; font-style: bold">Tittle...</h4>
											<div class="list-group-item-text">
											
												<b>${jobSeeker.name}</b><br/>
												Current Designation:&nbsp; ${jobSeeker.exp.designation}<br>
												Current Company :&nbsp; ${jobSeeker.exp.companyName}
												
											</div>
											<div class="list-group-item-text">
												Exp:&nbsp;${jobSeeker.totalExp} Years <br />
												CTC:&nbsp;${jobSeeker.exp.currentsalLackh} Lac(s)
												Current Location:&nbsp; ${jobSeeker.location}<br/>
												Pref Location:&nbsp;${jobSeeker.jobIntrestLocations}<br/>
											</div>
											Key Skills:&nbsp; <font color="green">${jobSeeker.keySkills}</font><br/>
											<font size="1">Last Modified:&nbsp; ${jobSeeker.modifyts}</font>
										</a>
										
										 
									</div>
								</c:forEach>


							</div>
							
						</div>
						 <div id="pagingControls" class="pagination pagination-panel pull-right"></div>
					</div>
					
					
			</div>
		</div><br/><br/>
		


		<script type="text/javascript">
		$(document).ready(function() {
		    $('#parentId').click(function(event) {  //on click 
		        if(this.checked) { // check select status
		            $('.checkbox1').each(function() { //loop through each checkbox
		                this.checked = true;  //select all checkboxes with class "checkbox1"               
		            });
		        }else{
		            $('.checkbox1').each(function() { //loop through each checkbox
		                this.checked = false; //deselect all checkboxes with class "checkbox1"                       
		            });         
		        }
		    });
		    
		});
		 $(function(){
		      $('#save_value').click(function(){
		    	  var email='';
		  
		        $(':checkbox:checked').each(function(i){
		      
		      if(email!='')
		         email=email+","+$(this).val();
		      else{
		    	  email=$(this).val();
		      } 
		        });
		       
		    if(email!=''){
		      
		        $.ajax({type:'POST',
		        	url: 'template.do', 
		        	data: {val:email},
		        	success: function(response) {
		        		
		        		 if(response=="0")
		        			 $(location).attr('href',"contactbulk.do");
		     	        else{
		     	        	alert("select Email Id");
		     	        	}
		        		
			       
			       
			    }
		        	});

		    }else{
		    	alert("select Email Id");
		    }
			
		
		      }); 
		    });
		
		

			
		</script>




	</div>
	</div>
	<script type="text/javascript">
	
	var pager = new Imtech.Pager();
	
		$(document).ready(function() {
	
		    pager.paragraphsPerPage = 1; // set amount elements per page
	
		    pager.pagingContainer = $('#contents'); // set of main container
	
		    pager.paragraphs = $('div.list-group-1', pager.pagingContainer); // set of required containers
	
		    pager.showPage(1);
		  
		});
	</script>
<jsp:include page="footer.jsp"></jsp:include>
<!-- 	<script src="js/jquery-2.1.1.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>
	<script src="js/plugins/slimscroll/jquery.slimscroll.min.js"></script> -->