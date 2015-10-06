<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Jobseeker Education</title>
<jsp:include page="header.jsp" />

   <link rel="stylesheet" href="http://jqueryvalidation.org/files/demo/site-demos.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
 <%-- <c:if test="${sessionScope.lUser == null || empty sessionScope.lUser}">
	<c:redirect url="/Login.do" />
</c:if>  --%>
<body class="top-navigation gray-bg">

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
					<%-- <form:form id="experience" commandName="jobseekerRegisterDTO"
						class="form-horizontal" action="addEmployerPost.do" method="POST"
						> --%>
					<h3></h3>
					 <div class="row">
                <div class="col-lg-12">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>Custom responsive table </h5>
                            <div class="ibox-tools">
                                
                                <a class="close-link">
                                    <i class="fa fa-times"></i>
                                </a>
                            </div>
                        </div>
                        <div class="ibox-content">
                           <!--  <div class="row">
                                <div class="col-sm-5 m-b-xs"><select class="input-sm form-control input-s-sm inline">
                                    <option value="0">Option 1</option>
                                    <option value="1">Option 2</option>
                                    <option value="2">Option 3</option>
                                    <option value="3">Option 4</option>
                                </select>
                                </div>
                                <div class="col-sm-4 m-b-xs">
                                    <div data-toggle="buttons" class="btn-group">
                                        <label class="btn btn-sm btn-white"> <input type="radio" id="option1" name="options"> Day </label>
                                        <label class="btn btn-sm btn-white active"> <input type="radio" id="option2" name="options"> Week </label>
                                        <label class="btn btn-sm btn-white"> <input type="radio" id="option3" name="options"> Month </label>
                                    </div>
                                </div>
                                <div class="col-sm-3">
                                    <div class="input-group"><input type="text" placeholder="Search" class="input-sm form-control"> <span class="input-group-btn">
                                        <button type="button" class="btn btn-sm btn-primary"> Go!</button> </span></div>
                                </div>
                            </div> -->
                            <form action="">
                            <div class="table-responsive">
                                <table class="table table-striped">
                                    <thead>
                                    <tr>

                                        <th></th>
                                        <th>Project </th>
                                      <!--   <th>Completed </th> -->
                                      <!--   <th>Task</th>
                                        <th>Date</th>
                                        <th>Action</th> -->
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td><input type="radio"  checked class="i-checks" name="input[]"></td>
                                       
                                    </tr>
                                    <tr>
                                        <td><input type="radio" class="i-checks" name="input[]"></td>
                                        <td>Alpha project</td>
                                        
                                    </tr>
                                    <tr>
                                        <td><input type="radio" class="i-checks" name="input[]"></td>
                                        <td>Betha project</td>
                                       
                                    </tr>
                                    <tr>
                                        <td><input type="radio" class="i-checks" name="input[]"></td>
                                        <td>Gamma project</td>
                                       
                                    </tr>
                                    </tbody>
                                </table>
                                <input type="submit" class="btn btn-primary"
										value="Update Your Profile" />
                            </div>
                           
                            </form>
                            <div class="table-responsive">
                                <table class="table table-striped">
                                    <thead>
                                    <tr>

                                        <th></th>
                                        <th>Project </th>
                                        <th>Completed </th>
                                        <th>Task</th>
                                        <th>Date</th>
                                        <th>Action</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td><input type="radio"  checked class="i-checks" name="input[]"></td>
                                        <td>Project<small>This is example of project</small></td>
                                        <td><span class="pie">0.52/1.561</span></td>
                                        <td>20%</td>
                                        <td>Jul 14, 2013</td>
                                        <td><a href="#"><i class="fa fa-check text-navy"></i></a></td>
                                    </tr>
                                    <tr>
                                        <td><input type="radio" class="i-checks" name="input[]"></td>
                                        <td>Alpha project</td>
                                        <td><span class="pie">6,9</span></td>
                                        <td>40%</td>
                                        <td>Jul 16, 2013</td>
                                        <td><a href="#"><i class="fa fa-check text-navy"></i></a></td>
                                    </tr>
                                    <tr>
                                        <td><input type="radio" class="i-checks" name="input[]"></td>
                                        <td>Betha project</td>
                                        <td><span class="pie">3,1</span></td>
                                        <td>75%</td>
                                        <td>Jul 18, 2013</td>
                                        <td><a href="#"><i class="fa fa-check text-navy"></i></a></td>
                                    </tr>
                                    <tr>
                                        <td><input type="radio" class="i-checks" name="input[]"></td>
                                        <td>Gamma project</td>
                                        <td><span class="pie">4,9</span></td>
                                        <td>18%</td>
                                        <td>Jul 22, 2013</td>
                                        <td><a href="#"><i class="fa fa-check text-navy"></i></a></td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>

                        </div>
                    </div>
                </div>

            </div>
					
						<div class="hr-line-dashed"></div>
							<div class="form-group">
								<div class="col-sm-4 col-sm-offset-2">
									<input type="submit" class="btn btn-primary"
										value="Update Your Profile" />
									<button class="btn btn-white" type="reset">Reset</button>
									<a href="viewJobProfile.do"class="btn btn-info" >Cancel</a>
								</div>
							</div>
				

				</div>
			</div>
		</div>
	</div>



	<!-- <script src="js/jquery-2.1.1.js"></script>
	<script type="text/javascript" src="js/city_state.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/bootstrap-datepicker.js"></script>
	<script src="js/date.js" type="text/javascript"></script>
	<script src="js/plugins/chosen/chosen.jquery.js"></script>
	<script type="text/javascript" src="js/bootstrap-filestyle.js"></script>
	<script src="js/plugins/datapicker/bootstrap-datepicker.js"></script> -->
	<script src="http://jqueryvalidation.org/files/dist/jquery.validate.min.js"></script>
<script src="http://jqueryvalidation.org/files/dist/additional-methods.min.js"></script>


	
	<script type="text/javascript">
$(document).ready(function(){

 var config = {
                '.chosen-select'           : {},
                '.chosen-select-deselect'  : {allow_single_deselect:true},
                '.chosen-select-no-single' : {disable_search_threshold:10},
                '.chosen-select-no-results': {no_results_text:'Oops, nothing found!'},
                '.chosen-select-width'     : {width:"95%"}
            }
            for (var selector in config) {
                $(selector).chosen(config[selector]);
            }
 
  $('#data_1 .input-group.date').datepicker().on('changeDate', function(ev){
		$(this).datepicker('hide');

	});



	
});
</script>
<script type="text/javascript">
/* $.validator.addMethod("dateComparison",function(value,element) {
	 alert("hi");
	
	var jyear=$("#joinedyear").val();
	
	var jmonth=$("#joinedyear").val();
	var eyear=$("#joinedyear").val();
	var emonth=$("#endingmonth").val();
	var jDate= new Date(jyear,jmonth,0,0,0,0,0);
	 var eDate= new Date(eyear,emonth,0,0,0,0,0);
	 
	
	 var jtime=jDate.getTime();
	 var etime=eDate.getTime();
	 alert(jtime+"zdfgdfsgh"+etime);
	 if (jtime >= etime) 
       result= false;
	 return true;
	 
	
},"The ending date must be a later date than the start date"); */


 
</script>
</body>
</html>