
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<!-- Custom Theme files -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--webfont-->
	<link rel="stylesheet" href="css/reset1.css"> <!-- CSS reset -->
	<link rel="stylesheet" href="css/style1.css"> <!-- Gem style -->
	<script src="js/modernizr.js"></script> <!-- Modernizr -->
 <link href="css/plugins/chosen/chosen.css" rel="stylesheet">
<script>

// Get the <datalist> and <input> elements.
var dataList = document.getElementById('json-datalist');
var input = document.getElementById('ajax');

// Create a new XMLHttpRequest.
var request = new XMLHttpRequest();

// Handle state changes for the request.
request.onreadystatechange = function(response) {
  if (request.readyState === 4) {
    if (request.status === 200) {
      // Parse the JSON
      var jsonOptions = JSON.parse(request.responseText);
  
      // Loop over the JSON array.
      jsonOptions.forEach(function(item) {
        // Create a new <option> element.
        var option = document.createElement('option');
        // Set the value using the item in the JSON array.
        option.value = item;
        // Add the <option> element to the <datalist>.
        dataList.appendChild(option);
      });
      
      // Update the placeholder text.
      input.placeholder = "e.g. datalist";
    } else {
      // An error occured :(
      input.placeholder = "Couldn't load datalist options :(";
    }
  }
};

// Update the placeholder text.
input.placeholder = "Loading options...";

// Set up and make the request.
request.open('GET', 'https://s3-us-west-2.amazonaws.com/s.cdpn.io/4621/html-elements.json', true);
request.send();

</script>
<link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/login.js"></script>
<script type="text/javascript" src="js/login1.js"></script>
<script src="js/jquery.easydropdown.js"></script>
<!--Animation-->
<script src="js/wow.min.js"></script>
<link href="css/animate.css" rel='stylesheet' type='text/css' />
<script>
	new WOW().init();
</script>
<link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/megamenu.js"></script>
<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
<script src="js/simpleCart.min.js"> </script>
   <link rel="stylesheet" href="http://jqueryvalidation.org/files/demo/site-demos.css">

<div class="header">
		  <div class="col-sm-8 header-left">
					<div class="logo">
						<a href="index.html"><img src="images/logo.png" alt=""/></a>
					</div>
					<div class="menu">
						 <a class="toggleMenu" href="#"><img src="images/nav.png" alt="" /></a>
						   <ul class="megamenu skyblue">
			<!-- <li class="active grid"><a class="color1" href="index.html">Jobs</a></li> -->
			<li class="grid"><a class="color2" href="#">Jobs</a>
				<div class="megapanel" style="width:30% !important">
					<div class="row">
						<div class="col1" style="float:left; width:100%;">
							<div class="h_nav">
								<ul>
							<%-- 	<li><a href="postJob.do?companyId=${company.companyKey}" target="_blank">Post Quick Jobs(${sessionScope.company.jobPosts})</a> </li>
									<li><a href="postJob.do?companyId=${company.companyKey}" target="_blank">Post Premium Jobs(${sessionScope.company.jobPosts})</a> </li>
										<li><a href="postJob.do?companyId=${company.companyKey}" target="_blank">Post Power Jobs(${sessionScope.company.jobPosts})</a> </li>
								<li><a href="getCompanyJobs.do" >View Jobs</a></li> --%>
								<c:if test="${sessionScope.quickCount gt 0 }">
									<li><a href="postJob.do?job=Quick" target="_blank">Post Quick Jobs(${sessionScope.quickCount})</a> </li>
								</c:if>
								
								<c:if test="${sessionScope.premiumCount gt 0 }" >
								
									<li><a href="postJob.do?job=Premium" target="_blank">Post Premium Jobs(${sessionScope.premiumCount})</a></li>
								
								</c:if>
								
								<c:if test="${sessionScope.powerCount gt 0 }">
								
									<li><a href="postJob.do?job=Power" target="_blank">Post Power Jobs(${sessionScope.powerCount})</a> </li>
								
								</c:if>
																															
								<li><a href="getCompanyJobs.do" >View Jobs</a></li>
								</ul>	
							</div>							
						</div>
						
					</div>
					
				</li>
			
				
			<li><a class="color5" href="#">Search Resumes</a>
				<div class="megapanel" style="width:30% !important">
					<div class="row">
						<div class="col1" style="float:left; width:100%;">
							<div class="h_nav">
								<ul>
								<li><a href="advSearch.do" >AdvancedSearch</a></li>
								<li><a href="itSearch.do" >It Search</a></li>
								<li><a href="easySearch.do" >Easy Search</a> </li>
								<li><a href="roleSearch.do" >Role Search</a></li>
								</ul>	
							</div>							
						</div>
						
						
					</div>
					</div>
				</li>
			
			
			<li><a class="color5" href="#">More</a>
				<div class="megapanel" style="width:40% !important">
					<div class="row">
						<div class="col1" style="float:left; width:100%;">
							<div class="h_nav">
								<ul>
								<li><a href="" >Resume Downloads</a></li>
								<li><a href="" ></a></li>
								<li><a href="" ></a> </li>
								<li><a href="" ></a></li>
								</ul>	
								<%-- (${sessionScope.company.resumeAccess}) --%>
							</div>							
						</div>
					</div>
					</div>
				</li>
									
				
		<div class="col-sm-4 header_right" style="float:right;">
		  <ul class="megamenu skyblue">
		 <li><a class="color5" href="#">Ejobzz</a>
				<div class="megapanel"  style="width:100% !important">
					<div class="row">
						
							<div class="h_nav">
								
								<ul>
									<!-- <li><a href="UpdateviewJobProfile.do" target="_blank">Edit profile</a></li> -->
									<li><a href="ChangeCompanyPassword.do" target="_blank">Change password</a></li>
									<li><a href="SignOut.do" >Logout</a></li>
									
								</ul>	
							</div>							
					
                      
					</div>
					
    				</div>
				</li>			
		 
		 </ul> </div>	
		 </div>	
			
		</ul>
		 
							<script type="text/javascript" src="js/responsive-nav.js"></script>
				  
				    <!-- start search-->
				     <div class="search-box">
							<div id="sb-search" class="sb-search">
								<%-- <form>
									<input class="sb-search-input" placeholder="Enter your search term..." type="search" name="search" id="search">
									<input class="sb-search-submit" type="submit" value="">
									<span class="sb-icon-search"> </span>
								</form> --%>
							
							</div>
						</div>
						<!----search-scripts---->
						<script src="js/classie.js"></script>
						<script src="js/uisearch.js"></script>
						<script>
							new UISearch( document.getElementById( 'sb-search' ) );
						</script>
						<!----//search-scripts---->						
	   		   <div class="clearfix"></div>
	   	   </div>
	       
	               <div class="clearfix"></div>
   </div>
   <script type="text/javascript" src="js/responsive-nav.js"></script>
   <script src="js/classie.js"></script>
						<script src="js/uisearch.js"></script>
						<script>
							new UISearch( document.getElementById( 'sb-search' ) );
						</script>
						<script src="http://jqueryvalidation.org/files/dist/jquery.validate.min.js"></script>
<script src="http://jqueryvalidation.org/files/dist/additional-methods.min.js"></script>
<script src="js/chosen.jquery.js"></script>
<script>
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

      
        });


    </script>