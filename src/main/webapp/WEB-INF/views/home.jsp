<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>



<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Ejobzz Home</title>
	
   <jsp:include page="header.jsp"/>
</head>

	
<body class="top-navigation gray-bg">
<div class="content_middle">
   <div class="content-middle">
					<div class="content-middle-in" style="background:#FFF; margin-top:25px;" >
					<ul id="flexiselDemo1" >			
						<li><img src="images/1.png"/></li>
						<li><img src="images/2.png"/></li>
						<li><img src="images/3.png"/></li>
						<li><img src="images/4.png"/></li>
						<li><img src="images/5.png"/></li>
						<li><img src="images/6.png"/></li>
						<li><img src="images/7.png"/></li>
						<li><img src="images/8.png"/></li>
						<li><img src="images/9.png"/></li>
					</ul>
            	 	<script type="text/javascript">
		$(window).load(function() {
			$("#flexiselDemo1").flexisel({
				visibleItems: 4,
				animationSpeed: 1000,
				autoPlay: true,
				autoPlaySpeed: 2000,    		
				pauseOnHover: true,
				enableResponsiveBreakpoints: true,
		    	responsiveBreakpoints: { 
		    		portrait: { 
		    			changePoint:480,
		    			visibleItems: 1
		    		}, 
		    		landscape: { 
		    			changePoint:640,
		    			visibleItems: 2
		    		},
		    		tablet: { 
		    			changePoint:768,
		    			visibleItems: 3
		    		}
		    	}
		    });
		    
		});
	</script>
	<script type="text/javascript" src="js/jquery.flexisel.js"></script> 

					</div>
				</div>
                
   	  <div class="container" style="margin-top:30px">
      <div class="cat">
         <h3>Jobs by Category</h3>
          <a href="#" target="_blank"> <p>Accounts Jobs</p></a>
         <a href="#" target="_blank"> <p>Interior Design Jobs</p></a>
         <a href="#" target="_blank"> <p>Automobile Jobs</p></a>
         <a href="#" target="_blank"> <p>Bank Jobs</p></a>
         <a href="#" target="_blank"> <p>BPO Jobs</p></a>
         <a href="#" target="_blank"> <p>Construction Jobs</p></a>
        <a href="#" target="_blank">   <p>Consultant Jobs</p></a>
         <a href="#" target="_blank"> <p>Content Writing Jobs</p></a>
         <a href="#" target="_blank"> <p>Corporate Planning Jobs</p></a>
         <a href="#" target="_blank"> <p>Design Engineer Jobs</p></a>
         <a href="#" target="_blank"> <p>Export Import Jobs</p></a>
         <a href="#" target="_blank"> <p>Accounts Jobs</p></a>
         <a href="#" target="_blank"> <p>Interior Design Jobs</p></a>
         <a href="#" target="_blank"> <p>Automobile Jobs</p></a>
         <a href="#" target="_blank"> <p>Bank Jobs</p></a>
         <a href="#" target="_blank"> <p>BPO Jobs</p></a>
         <a href="#" target="_blank"> <p>Construction Jobs</p></a>
         <a href="#" target="_blank"> <p>Consultant Jobs</p></a>
         <a href="#" target="_blank"> <p>Content Writing Jobs</p></a>
         <a href="#" target="_blank"> <p>Corporate Planning Jobs</p></a>
         <a href="#" target="_blank"> <p>Design Engineer Jobs</p></a>
         <a href="#" target="_blank"> <p>Export Import Jobs</p></a>
         <!--<p>Merchandiser Jobs</p>
         <p>Fresher Jobs</p>
         <p>Medical Jobs</p>-->
         </div>
      <div class="sap_tabs">	
				     <div id="horizontalTab" style="display: block; width:100%; margin: 0px;">
						  <ul class="resp-tabs-list">
						  	  <li class="resp-tab-item " aria-controls="tab_item-0" role="tab"><span>All Sectors</span></li>
							  <li class="resp-tab-item" aria-controls="tab_item-1" role="tab"><span>Information Technology</span></li>
							  <li class="resp-tab-item" aria-controls="tab_item-2" role="tab"><span>Manufacturing</span></li>
						  	  <li class="resp-tab-item " aria-controls="tab_item-3" role="tab"><span>Services</span></li>
							  <div class="clearfix"></div>
						  </ul>				  	 
							<div class="resp-tabs-container">
							    <h2 class="resp-accordion resp-tab-active" role="tab" aria-controls="tab_item-0"><span class="resp-arrow"></span>Product Description</h2><div class="tab-1 resp-tab-content resp-tab-content-active" aria-labelledby="tab_item-0" style="display:block">
									<div class="facts" style="margin-left:20px;">
										<ul style="width:45%; float:left;">
											<a href="#" target="_blank"><li>Avago Technologies</li></a>
											<a href="#" target="_blank"><li>Calsoft Labs, An Alten Company</li></a>
											<a href="#" target="_blank"><li>e-Infochips</li></a>
											<a href="#" target="_blank"><li>Intel</li></a>
											<a href="#" target="_blank"><li>Marvell</li></a>
											<a href="#" target="_blank"><li>MAXIM Integrated</li></a>
											<a href="#" target="_blank"><li>Avago Technologies</li></a>
											<a href="#" target="_blank"><li>Calsoft Labs, An Alten Company</li></a>
											<a href="#" target="_blank"><li>e-Infochips</li></a>
											<a href="#" target="_blank"><li>Intel</li></a>
											<a href="#" target="_blank"><li>Marvell</li></a>
											<a href="#" target="_blank"><li>MAXIM Integrated</li></a>
											<a href="#" target="_blank"><li>Avago Technologies</li></a>
											<a href="#" target="_blank"><li>Calsoft Labs, An Alten Company</li></a>
											<a href="#" target="_blank"><li>e-Infochips</li></a>
											<a href="#" target="_blank"><li>Intel</li></a>
											<a href="#" target="_blank"><li>Marvell</li></a>
											<a href="#" target="_blank"><li>MAXIM Integrated</li></a>
											<a href="#" target="_blank"><li>Avago Technologies</li></a>
											<a href="#" target="_blank"><li>Calsoft Labs, An Alten Company</li></a>
											<a href="#" target="_blank"><li>e-Infochips</li></a>
											<a href="#" target="_blank"><li>Intel</li></a>
											<a href="#" target="_blank"><li>Marvell</li></a>
											<a href="#" target="_blank"><li>MAXIM Integrated</li></a>
										</ul>   
                                        
                                        <ul style="width:45%; float:left;">
											<a href="#" target="_blank"> <li>Avago Technologies</li></a>
											<a href="#" target="_blank"> <li>Calsoft Labs, An Alten Company</li></a>
											<a href="#" target="_blank"> <li>e-Infochips</li></a>
											<a href="#" target="_blank"> <li>Intel</li></a>
											<a href="#" target="_blank"> <li>Marvell</li></a>
											<a href="#" target="_blank"> <li>MAXIM Integrated</li></a>
											<a href="#" target="_blank">  <li>Avago Technologies</li></a>
											<a href="#" target="_blank"> <li>Calsoft Labs, An Alten Company</li></a>
											<a href="#" target="_blank"> <li>e-Infochips</li></a>
											<a href="#" target="_blank"><li>Intel</li></a>
											<a href="#" target="_blank"> <li>Marvell</li></a>
											<a href="#" target="_blank"> <li>MAXIM Integrated</li></a>
											<a href="#" target="_blank"> <li>Avago Technologies</li></a>
											<a href="#" target="_blank"> <li>Calsoft Labs, An Alten Company</li></a>
											<a href="#" target="_blank"><li>e-Infochips</li></a>
											<a href="#" target="_blank"><li>Intel</li></a>
											<a href="#" target="_blank"><li>Marvell</li></a>
											<a href="#" target="_blank"><li>MAXIM Integrated</li></a>
											<a href="#" target="_blank"><li>Avago Technologies</li></a>
											<a href="#" target="_blank"><li>Calsoft Labs, An Alten Company</li></a>
											<a href="#" target="_blank"><li>e-Infochips</li></a>
											<a href="#" target="_blank"><li>Intel</li></a>
											<a href="#" target="_blank"><li>Marvell</li></a>
											<a href="#" target="_blank"><li>MAXIM Integrated</li></a>
										</ul>      
							        </div>
							    	</div>
							      <h2 class="resp-accordion" role="tab" aria-controls="tab_item-1"><span class="resp-arrow"></span>Additional Information</h2><div class="tab-1 resp-tab-content" aria-labelledby="tab_item-1">
									<div class="facts" style="margin-left:20px;">									
										<ul style="width:45%; float:left;">
											<a href="#" target="_blank"> <li>Avago Technologies</li></a>
											<a href="#" target="_blank"> <li>Calsoft Labs, An Alten Company</li></a>
											<a href="#" target="_blank"> <li>e-Infochips</li></a>
											<a href="#" target="_blank"> <li>Intel</li></a>
											<a href="#" target="_blank"> <li>Marvell</li></a>
											<a href="#" target="_blank"> <li>MAXIM Integrated</li></a>
											<a href="#" target="_blank">  <li>Avago Technologies</li></a>
											<a href="#" target="_blank"> <li>Calsoft Labs, An Alten Company</li></a>
											<a href="#" target="_blank"> <li>e-Infochips</li></a>
											<a href="#" target="_blank"><li>Intel</li></a>
											<a href="#" target="_blank"> <li>Marvell</li></a>
											<a href="#" target="_blank"> <li>MAXIM Integrated</li></a>
											<a href="#" target="_blank"> <li>Avago Technologies</li></a>
											<a href="#" target="_blank"> <li>Calsoft Labs, An Alten Company</li></a>
											<a href="#" target="_blank"><li>e-Infochips</li></a>
											<a href="#" target="_blank"><li>Intel</li></a>
											<a href="#" target="_blank"><li>Marvell</li></a>
											<a href="#" target="_blank"><li>MAXIM Integrated</li></a>
											<a href="#" target="_blank"><li>Avago Technologies</li></a>
											<a href="#" target="_blank"><li>Calsoft Labs, An Alten Company</li></a>
											<a href="#" target="_blank"><li>e-Infochips</li></a>
											<a href="#" target="_blank"><li>Intel</li></a>
											<a href="#" target="_blank"><li>Marvell</li></a>
											<a href="#" target="_blank"><li>MAXIM Integrated</li></a>
										</ul>   
                                        
                                        <ul style="width:45%; float:left;">
											<a href="#" target="_blank"> <li>Avago Technologies</li></a>
											<a href="#" target="_blank"> <li>Calsoft Labs, An Alten Company</li></a>
											<a href="#" target="_blank"> <li>e-Infochips</li></a>
											<a href="#" target="_blank"> <li>Intel</li></a>
											<a href="#" target="_blank"> <li>Marvell</li></a>
											<a href="#" target="_blank"> <li>MAXIM Integrated</li></a>
											<a href="#" target="_blank">  <li>Avago Technologies</li></a>
											<a href="#" target="_blank"> <li>Calsoft Labs, An Alten Company</li></a>
											<a href="#" target="_blank"> <li>e-Infochips</li></a>
											<a href="#" target="_blank"><li>Intel</li></a>
											<a href="#" target="_blank"> <li>Marvell</li></a>
											<a href="#" target="_blank"> <li>MAXIM Integrated</li></a>
											<a href="#" target="_blank"> <li>Avago Technologies</li></a>
											<a href="#" target="_blank"> <li>Calsoft Labs, An Alten Company</li></a>
											<a href="#" target="_blank"><li>e-Infochips</li></a>
											<a href="#" target="_blank"><li>Intel</li></a>
											<a href="#" target="_blank"><li>Marvell</li></a>
											<a href="#" target="_blank"><li>MAXIM Integrated</li></a>
											<a href="#" target="_blank"><li>Avago Technologies</li></a>
											<a href="#" target="_blank"><li>Calsoft Labs, An Alten Company</li></a>
											<a href="#" target="_blank"><li>e-Infochips</li></a>
											<a href="#" target="_blank"><li>Intel</li></a>
											<a href="#" target="_blank"><li>Marvell</li></a>
											<a href="#" target="_blank"><li>MAXIM Integrated</li></a>
										</ul>      
							        </div>	
								</div>									
							      <h2 class="resp-accordion" role="tab" aria-controls="tab_item-2"><span class="resp-arrow"></span>Reviews</h2><div class="tab-1 resp-tab-content" aria-labelledby="tab_item-2">
									 <div class="facts" style="margin-left:20px;">
										<ul style="width:45%; float:left;">
											<a href="#" target="_blank"> <li>Avago Technologies</li></a>
											<a href="#" target="_blank"> <li>Calsoft Labs, An Alten Company</li></a>
											<a href="#" target="_blank"> <li>e-Infochips</li></a>
											<a href="#" target="_blank"> <li>Intel</li></a>
											<a href="#" target="_blank"> <li>Marvell</li></a>
											<a href="#" target="_blank"> <li>MAXIM Integrated</li></a>
											<a href="#" target="_blank">  <li>Avago Technologies</li></a>
											<a href="#" target="_blank"> <li>Calsoft Labs, An Alten Company</li></a>
											<a href="#" target="_blank"> <li>e-Infochips</li></a>
											<a href="#" target="_blank"><li>Intel</li></a>
											<a href="#" target="_blank"> <li>Marvell</li></a>
											<a href="#" target="_blank"> <li>MAXIM Integrated</li></a>
											<a href="#" target="_blank"> <li>Avago Technologies</li></a>
											<a href="#" target="_blank"> <li>Calsoft Labs, An Alten Company</li></a>
											<a href="#" target="_blank"><li>e-Infochips</li></a>
											<a href="#" target="_blank"><li>Intel</li></a>
											<a href="#" target="_blank"><li>Marvell</li></a>
											<a href="#" target="_blank"><li>MAXIM Integrated</li></a>
											<a href="#" target="_blank"><li>Avago Technologies</li></a>
											<a href="#" target="_blank"><li>Calsoft Labs, An Alten Company</li></a>
											<a href="#" target="_blank"><li>e-Infochips</li></a>
											<a href="#" target="_blank"><li>Intel</li></a>
											<a href="#" target="_blank"><li>Marvell</li></a>
											<a href="#" target="_blank"><li>MAXIM Integrated</li></a>
										</ul>   
                                        
                                        <ul style="width:45%; float:left;">
											<a href="#" target="_blank"> <li>Avago Technologies</li></a>
											<a href="#" target="_blank"> <li>Calsoft Labs, An Alten Company</li></a>
											<a href="#" target="_blank"> <li>e-Infochips</li></a>
											<a href="#" target="_blank"> <li>Intel</li></a>
											<a href="#" target="_blank"> <li>Marvell</li></a>
											<a href="#" target="_blank"> <li>MAXIM Integrated</li></a>
											<a href="#" target="_blank">  <li>Avago Technologies</li></a>
											<a href="#" target="_blank"> <li>Calsoft Labs, An Alten Company</li></a>
											<a href="#" target="_blank"> <li>e-Infochips</li></a>
											<a href="#" target="_blank"><li>Intel</li></a>
											<a href="#" target="_blank"> <li>Marvell</li></a>
											<a href="#" target="_blank"> <li>MAXIM Integrated</li></a>
											<a href="#" target="_blank"> <li>Avago Technologies</li></a>
											<a href="#" target="_blank"> <li>Calsoft Labs, An Alten Company</li></a>
											<a href="#" target="_blank"><li>e-Infochips</li></a>
											<a href="#" target="_blank"><li>Intel</li></a>
											<a href="#" target="_blank"><li>Marvell</li></a>
											<a href="#" target="_blank"><li>MAXIM Integrated</li></a>
											<a href="#" target="_blank"><li>Avago Technologies</li></a>
											<a href="#" target="_blank"><li>Calsoft Labs, An Alten Company</li></a>
											<a href="#" target="_blank"><li>e-Infochips</li></a>
											<a href="#" target="_blank"><li>Intel</li></a>
											<a href="#" target="_blank"><li>Marvell</li></a>
											<a href="#" target="_blank"><li>MAXIM Integrated</li></a>
										</ul>      
							     </div>	
							 </div>
                             							      <h2 class="resp-accordion" role="tab" aria-controls="tab_item-3"><span class="resp-arrow"></span>Additional Information</h2>
                         <div class="tab-1 resp-tab-content" aria-labelledby="tab_item-1">
									<div class="facts" style="margin-left:20px;">									
										<ul style="width:45%; float:left;">
											<a href="#" target="_blank"> <li>Avago Technologies</li></a>
											<a href="#" target="_blank"> <li>Calsoft Labs, An Alten Company</li></a>
											<a href="#" target="_blank"> <li>e-Infochips</li></a>
											<a href="#" target="_blank"> <li>Intel</li></a>
											<a href="#" target="_blank"> <li>Marvell</li></a>
											<a href="#" target="_blank"> <li>MAXIM Integrated</li></a>
											<a href="#" target="_blank">  <li>Avago Technologies</li></a>
											<a href="#" target="_blank"> <li>Calsoft Labs, An Alten Company</li></a>
											<a href="#" target="_blank"> <li>e-Infochips</li></a>
											<a href="#" target="_blank"><li>Intel</li></a>
											<a href="#" target="_blank"> <li>Marvell</li></a>
											<a href="#" target="_blank"> <li>MAXIM Integrated</li></a>
											<a href="#" target="_blank"> <li>Avago Technologies</li></a>
											<a href="#" target="_blank"> <li>Calsoft Labs, An Alten Company</li></a>
											<a href="#" target="_blank"><li>e-Infochips</li></a>
											<a href="#" target="_blank"><li>Intel</li></a>
											<a href="#" target="_blank"><li>Marvell</li></a>
											<a href="#" target="_blank"><li>MAXIM Integrated</li></a>
											<a href="#" target="_blank"><li>Avago Technologies</li></a>
											<a href="#" target="_blank"><li>Calsoft Labs, An Alten Company</li></a>
											<a href="#" target="_blank"><li>e-Infochips</li></a>
											<a href="#" target="_blank"><li>Intel</li></a>
											<a href="#" target="_blank"><li>Marvell</li></a>
											<a href="#" target="_blank"><li>MAXIM Integrated</li></a>
										</ul>   
                                        
                                        <ul style="width:45%; float:left;">
											<a href="#" target="_blank"> <li>Avago Technologies</li></a>
											<a href="#" target="_blank"> <li>Calsoft Labs, An Alten Company</li></a>
											<a href="#" target="_blank"> <li>e-Infochips</li></a>
											<a href="#" target="_blank"> <li>Intel</li></a>
											<a href="#" target="_blank"> <li>Marvell</li></a>
											<a href="#" target="_blank"> <li>MAXIM Integrated</li></a>
											<a href="#" target="_blank">  <li>Avago Technologies</li></a>
											<a href="#" target="_blank"> <li>Calsoft Labs, An Alten Company</li></a>
											<a href="#" target="_blank"> <li>e-Infochips</li></a>
											<a href="#" target="_blank"><li>Intel</li></a>
											<a href="#" target="_blank"> <li>Marvell</li></a>
											<a href="#" target="_blank"> <li>MAXIM Integrated</li></a>
											<a href="#" target="_blank"> <li>Avago Technologies</li></a>
											<a href="#" target="_blank"> <li>Calsoft Labs, An Alten Company</li></a>
											<a href="#" target="_blank"><li>e-Infochips</li></a>
											<a href="#" target="_blank"><li>Intel</li></a>
											<a href="#" target="_blank"><li>Marvell</li></a>
											<a href="#" target="_blank"><li>MAXIM Integrated</li></a>
											<a href="#" target="_blank"><li>Avago Technologies</li></a>
											<a href="#" target="_blank"><li>Calsoft Labs, An Alten Company</li></a>
											<a href="#" target="_blank"><li>e-Infochips</li></a>
											<a href="#" target="_blank"><li>Intel</li></a>
											<a href="#" target="_blank"><li>Marvell</li></a>
											<a href="#" target="_blank"><li>MAXIM Integrated</li></a>
										</ul>      
							        </div>	
								</div>									

					      </div>
					 </div>
                     
			  <script src="js/easyResponsiveTabs.js" type="text/javascript"></script>
		    <script type="text/javascript">
			    $(document).ready(function () {
			        $('#horizontalTab').easyResponsiveTabs({
			            type: 'default', //Types: default, vertical, accordion           
			            width: 'auto', //auto or any width like 600px
			            fit: true   // 100% fit in a container
			        });
			    });
			   
			   </script> 
	</div>
         <div class="cat">
         <h3>Jobs by Category</h3>
         <center><img src="images/n.gif"/></center><br>
         <center><img src="images/n1.gif"/></center><br>
         <center><img src="images/n2.gif"/></center><br>
         <center><img src="images/n3.gif"/></center><br>
         <center><img src="images/n4.gif"/></center><br>
         <center><img src="images/n5.gif"/></center><br>
         <center><img src="images/n6.gif"/></center><br>
         </div>      
       <div class="cont">

            
            <div class="offering">
   		  	  <div class="real">
   		  	  	<h4>Reality</h4>
   		  	  	<div class="col-sm-6">
   		  	  	  <ul class="service_grid">
   	   				<i class="s1"> </i>
   	   				 <li class="desc1 wow fadeInRight" data-wow-delay="0.4s">
   	   				   <p>Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum</p>
   	   				 </li>
   	   				 <div class="clearfix"> </div>
   	   			   </ul>
   	   			 </div>
   	   			 <div class="col-sm-6">
   		  	  	  <ul class="service_grid">
   	   				<i class="s2"> </i>
   	   				 <li class="desc1 wow fadeInRight" data-wow-delay="0.4s">
   	   				   <p>Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum</p>
   	   				 </li>
   	   				 <div class="clearfix"> </div>
   	   			   </ul>
   	   			 </div>
   	   			 <div class="clearfix"> </div>
   	   			 </div>
   		  	  </div>
               </div>

   	  </div>
      
   </div>
   
   <div class="content-middle">
					<div class="content-middle-in" style="background:#FFF; margin-top:15px; margin-bottom:15px;" >
					<ul id="flexiselDemo2" >			
						<li><img src="images/10.jpg"/></li>
						<li><img src="images/11.jpg"/></li>
						<li><img src="images/12.jpg"/></li>
						<li><img src="images/13.jpg"/></li>
						<li><img src="images/14.jpg"/></li>
						<li><img src="images/15.jpg"/></li>
						<li><img src="images/16.jpg"/></li>
						<li><img src="images/17.jpg"/></li>
						<li><img src="images/18.jpg"/></li>
					</ul>
            		

					</div>
				</div>
   <jsp:include page="footer.jsp"/>

</body >
</html>
