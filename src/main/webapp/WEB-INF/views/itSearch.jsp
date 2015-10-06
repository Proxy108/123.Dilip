
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>


  
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
<jsp:include page="adminHeader.jsp"></jsp:include>



</head>
<body class="top-navigation gray-bg">
	<form:form commandName="SearchDTO" class="form-horizontal" action="itSearchResumepost.do"
		method="POST" onsubmit="validate_import()">
		<div class="ibox-content">
			<div class="wrapper wrapper-content">
				<div class="container">
					<div class="row">

						<div class="ibox-content">

							<h3>
								<center>IT Search</center>
							</h3>
							<hr/>
							
						
							<div class="row">
								<div class="form-group" >
									<label class="col-sm-2 control-label" >IT Skill 1</label>

									<div class="col-md-2" >
										<form:input path="skill1" class="form-control" placeholder="Seprate with comma(,)" ></form:input>
									</div>
								

									<div class="col-md-2" >
										<form:select path="skillexp1" name="skillexp1"
											id="skillexp1" class="form-control">

											<form:option value="any">Any</form:option>
											<form:option value="0">leass than 1 year</form:option>
											<form:option value="1"> 1 year and above</form:option>
											<form:option value="2"> 2 year and above</form:option>
											<form:option value="3"> 3 year and above</form:option>
											<form:option value="4"> 4 year and above</form:option>
											<form:option value="5"> 5 year and above</form:option>
											</form:select>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group" >
									<label class="col-sm-2 control-label" >IT Skill 2</label>

									<div class="col-md-2" >
										<form:input path="skill2" class="form-control" placeholder="Seprate with comma(,)" ></form:input>
									</div>
								

									<div class="col-md-2" >
										<form:select path="skillexp2" name="skillexp2"
											id="skillexp2" class="form-control">

											<form:option value="any">Any</form:option>
											<form:option value="1">leass than 1 year</form:option>
											<form:option value="0"> 1 year and above</form:option>
											<form:option value="2"> 2 year and above</form:option>
											<form:option value="3"> 3 year and above</form:option>
											<form:option value="4"> 4 year and above</form:option>
											<form:option value="5"> 5 year and above</form:option>
											</form:select>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group" >
									<label class="col-sm-2 control-label" >IT Skill 3</label>

									<div class="col-md-2" >
										<form:input path="skill3" class="form-control" placeholder="Seprate with comma(,)" ></form:input>
									</div>
								

									<div class="col-md-2" >
										<form:select path="skillexp3" name="skillexp3"
											id="skillexp3" class="form-control">

											<form:option value="any">Any</form:option>
											<form:option value="1">leass than 1 year</form:option>
											<form:option value="0"> 1 year and above</form:option>
											<form:option value="2"> 2 year and above</form:option>
											<form:option value="3"> 3 year and above</form:option>
											<form:option value="4"> 4 year and above</form:option>
											<form:option value="5"> 5 year and above</form:option>
											</form:select>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group" >
									<label class="col-sm-2 control-label" >IT Skill 4</label>

									<div class="col-md-2" >
										<form:input path="skill4" class="form-control" placeholder="Seprate with comma(,)" ></form:input>
									</div>
								

									<div class="col-md-2" >
										<form:select path="skillexp4" name="skillexp4"
											id="skillexp4" class="form-control">

											<form:option value="any">Any</form:option>
											<form:option value="1">leass than 1 year</form:option>
											<form:option value="0"> 1 year and above</form:option>
											<form:option value="2"> 2 year and above</form:option>
											<form:option value="3"> 3 year and above</form:option>
											<form:option value="4"> 4 year and above</form:option>
											<form:option value="5"> 5 year and above</form:option>
											</form:select>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group" >
									<label class="col-sm-2 control-label" >IT Skill 5</label>

									<div class="col-md-2" >
										<form:input path="skill5" class="form-control" placeholder="Seprate with comma(,)" ></form:input>
									</div>
								

									<div class="col-md-2" >
										<form:select path="skillexp5" name="skillexp5"
											id="skillexp5" class="form-control">

											<form:option value="any">Any</form:option>
											<form:option value="0">leass than 1 year</form:option>
											<form:option value="1"> 1 year and above</form:option>
											<form:option value="2"> 2 year and above</form:option>
											<form:option value="3"> 3 year and above</form:option>
											<form:option value="4"> 4 year and above</form:option>
											<form:option value="5"> 5 year and above</form:option>
											</form:select>
									</div>
								</div>
							</div>
							
							<div class="row">
								<div class="form-group" >
									<label class="col-sm-2 control-label" >Any Key Word</label>

									<div class="col-md-4" >
										<form:input path="anyKeyWords" class="form-control" placeholder="Seprate with comma(,)" ></form:input>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">All Key Word</label>

									<div class="col-md-4">
										<form:input path="allKeyWords" class="form-control" placeholder="Seprate with comma(,)"></form:input>
									</div>
								</div>
							</div>

							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Excluding key
										Word</label>

									<div class="col-md-4">
										<form:input path="excludingkey" name="excludingkey"
											class="form-control" placeholder="Seprate with comma(,)"/>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Total Experience:
									</label>
									<div class="col-md-2">
										<form:input path="minExpYear" id="minExpYear"
											class="form-control"/>							

									</div>
									<div class="col-md-2">
										<form:input path="maxExpYear" name="maxExpYear"
											id="maxExpYear" class="form-control"/>
									</div>

								</div>
							</div>

							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Annual Salary:</label>

									<div class="col-md-2">
										<form:select path="minSalLac" name="maxExpYear"
											id="maxExpYear" class="form-control">

											<form:option value="0">Lac</form:option>
											<c:forEach items="${lac}" var="lac1">
	      										<form:option value="${lac1}" >${lac1}</form:option> 
											</c:forEach>

										</form:select>
									</div>

									<div class="col-md-2">
										<form:select path="minSalThousand" name="maxExpYear"
											id="maxExpYear" class="form-control">

											<form:option value="0">Thousands</form:option>
											<c:forEach items="${thousand}" var="thousand1">
	      										<form:option value="${thousand1}" >${thousand1}</form:option> 
											</c:forEach>
										</form:select>

									</div>
									<label class="col-sm-1 control-label"> To </label>
									<div class="col-md-2">
										<form:select path="maxSalLac" name="maxExpYear"
											id="maxExpYear" class="form-control">

											<form:option value="0">Lac</form:option>
											<c:forEach items="${lac}" var="lac1">
	      										<form:option value="${lac1}" >${lac1}</form:option> 
											</c:forEach>
										</form:select>
									</div>
									<div class="col-md-2">
										<form:select path="maxSalThousand" name="maxExpYear"
											id="maxExpYear" class="form-control">

											<form:option value="0">Thousands</form:option>
											<c:forEach items="${thousand}" var="thousand1">
	      										<form:option value="${thousand1}" >${thousand1}</form:option> 
											</c:forEach>
											
										</form:select>
									</div>
								</div>
							</div>
							
							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Candidate's
										Current Location:</label>
									<div class="col-md-4">
										<form:select path="location"
											data-placeholder="Select Location" class="chosen-select"
											 style="width:350px;">
											<form:option value="" >-- Select Location --</form:option>
											<c:forEach items="${location}" var="loc">
	      										<form:option value="${loc.id}" >${loc.lname}</form:option> 
											</c:forEach>
										</form:select>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group">

									<label class="col-sm-2 control-label">Prefered Location</label>
									<div class="col-md-4">
										<form:select path="preferedLocation"
											data-placeholder="Select Location" class="chosen-select"
											multiple="true" style="width:350px;">
											<c:forEach items="${location}" var="loc">
	      										<form:option value="${loc.id}" >${loc.lname}</form:option> 
											</c:forEach>
										</form:select>
									</div>
								</div>

							</div>

							<!-- employement details  -->
							<div class="row" >
								<div class="form-group">
									<label class="col-sm-2 control-label">Employment Details </label>
								</div>
							</div>
							<div class="row">
										
 							<div class="form-group">
									 <label
										class="col-sm-2 control-label">Industry Type: </label>

									<div class="col-md-4">
										<form:select path="industryType"
											data-placeholder="Select Industry type" class="chosen-select"
											multiple="true" style="width:350px;">
											<form:option value="" >-- Select Industry --</form:option>
											<c:forEach items="${industryList}" var="ind">
	      										<form:option value="${ind.id}" >${ind.iname}</form:option> 
											</c:forEach>
										</form:select>
											
									</div>
								</div>
								</div>
								<div class="row">
								<div class="form-group">
									 <label
										class="col-sm-2 control-label">Employers: </label>

									<div class="col-md-4">
										<form:input path="currentEmployer" 
											class="form-control" />
									</div>
								</div>
								</div>
								<div class="row">
								<div class="form-group">
									 <label
										class="col-sm-2 control-label">Exclude Employers: </label>

									<div class="col-md-4">
										<form:input path="excludeEmployer" 
											class="form-control" />
									</div>
								</div></div>
								<div class="row">
								<div class="form-group">
									 <label
										class="col-sm-2 control-label">Designation: </label>

									<div class="col-md-4">
										<form:input path="desingnation" 
											class="form-control" />
									</div>
								</div>

							</div>

							
							

							<!-- employement ends -->

							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Educational
										Details </label>
								</div>
							</div>
							<div class="row">
								<div class="form-group">
									 <label
										class="col-sm-2 control-label">Ug Qualification: </label>

									<div class="col-md-4">
										<form:input path="ugQualification" name="ugQualification"
											class="form-control" />
									</div>
									<!-- <div class="col-md-2">
										<input type="text" name="months" class="form-control" />
									</div> -->
								</div>
								<div class="form-group">
									 <label
										class="col-sm-2 control-label">Institute Name: </label>

									<div class="col-md-4">
										<form:input path="institute" 
											class="form-control" />
									</div>
									
								</div>
								<div class="form-group">
									 <label
										class="col-sm-2 control-label">Year of Passing</label>
									<div class="col-md-2">
										<form:select path="passingYearFrom" class="form-control">
										<form:option value="0" >From</form:option>
											<c:forEach items="${years}" var="year">
	      										<form:option value="${year}" >${year}</form:option> 
											</c:forEach>
										</form:select>
									</div>
									<div class="col-md-2">
										<form:select path="passingYearTo" class="form-control">
										<form:option value="0" >To</form:option>
											<c:forEach items="${years}" var="year">
	      										<form:option value="${year}" >${year}</form:option> 
											</c:forEach>
											</form:select>
									</div>

							</div>
							</div>

							<div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Additional Filters </label>
								</div>
							</div>

								
							<div class="row">
								<div class="form-group">
								
									<label class="col-sm-2 control-label">Candidates Active
										in Last:</label>

									<div class="col-md-2">
										<form:select path="activeDays" class="form-control">
											<form:option value="7">7 days</form:option>
											<form:option value="15">15 days</form:option>
											<form:option value="1">1 month </form:option>
											<form:option value="2">2 month </form:option>
											<form:option value="3">3 month </form:option>
											<form:option value="6">6 month </form:option>
											<form:option value="9">9 month </form:option>
											<form:option value="11">1 years </form:option>
											<form:option value="0" selected="true">All </form:option>
										</form:select>
									</div>

								</div>
							</div>

							<%-- <div class="row">
								<div class="form-group">
								
									<label class="col-sm-2 control-label">Notice Period</label>

									<div class="col-md-2">
										<form:select path="noticePeriod" class="form-control">
											<form:option value="-1">Any</form:option>
											<form:option value="0">Currently serving Notice period</form:option>
											<form:option value="15">15 days/less </form:option>
											<form:option value="30">1 month </form:option>
											<form:option value="60">2 months </form:option>
											<form:option value="180">3 months </form:option>
											<form:option value="180+">More than 3 months </form:option>
										</form:select>
									</div>

								</div>
							</div>
 --%>
							<!-- <div class="row">
								<div class="form-group">
									<label class="col-sm-2 control-label">Resume Per page</label>

									<div class="col-md-4">
										<select type="text" name="years" class="form-control" >
										<option value="current employer">20</option>
										<option value="current employer">30</option>
										<option value="current employer">40</option>
										<option value="current employer">60</option>
										<option value="current employer">80</option>
										<option value="current employer">100</option>
										<option value="current employer">150</option>
										</select>
									</div>
									
								</div> -->
						</div>
						<br/>
						<center><button type="submit" class="btn btn-primary">Find
							Resumes</button>
						<button type="reset" class="btn btn-primary">Reset</button></center>

					</div>
				</div>
			</div>
		</div>
	</form:form>


   
  
</body>
</html>