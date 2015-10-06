
function isEmailRegistered(email){
	
	if(email != '' ){
		   $.ajax({
		  type: "POST",
		  url: "getUser.do",
		  data:'email='+email.value,
		  cache: false,
		  success: function(response){
			  	if(response == 'A' || response == 65){
			  		document.getElementById('emailMsg').innerHTML="Email already registered!";
			  		email.focus();
			  	}
			  	else
			  		$('#emailMsg').empty();
		  },
		  error: function(){      
		   //alert('Error while request..');
		  }
		 }); 
	  }
	}

function getDistricts(stateName){
	var options ='<option value="Select">Select</option>';
	  $.ajax({
	  type: "POST",
	  url: "getDistricts.do",
	  data:'stateName='+stateName,
	  dataType: 'json',
	  cache: false,
	  success: function(response){
	 	  
          for (var i = 0; i < response.list.length; i++) {
            options += '<option value="' + response.list[i] + '">' + response.list[i] + '</option>';
          }
          $("#city").html(options);
	  },
	  error: function(){      
	   //alert('Error while request..');
	  }
	 });
	
}

function getDistrictsUserReg(stateName){
	var options ='<option value="Select">Select</option>';
	  $.ajax({
	  type: "POST",
	  url: "getDistricts.do",
	  data:'stateName='+stateName,
	  dataType: 'json',
	  cache: false,
	  success: function(response){
          for (var i = 0; i < response.list.length; i++) {
            options += '<option value="' + response.list[i] + '">' + response.list[i] + '</option>';
          }
          $("#billToAddressCity").html(options);
	  },
	  error: function(){      
	   //alert('Error while request..');
	  }
	 });
	
}
function getDistrictsUserReg1(stateName){
	var options ='<option value="Select">Select</option>';
	  $.ajax({
	  type: "POST",
	  url: "getDistricts.do",
	  data:'stateName='+stateName,
	  dataType: 'json',
	  cache: false,
	  success: function(response){
	 	  
          for (var i = 0; i < response.list.length; i++) {
            options += '<option value="' + response.list[i] + '">' + response.list[i] + '</option>';
          }
          $("#shippingToAddressCity").html(options);
	  },
	  error: function(){      
	   //alert('Error while request..');
	  }
	 });
	  
	  
	
}




function putDistrict(){
	document.getElementById('state').value=document.getElementById('districtsList').value;
}

function getCategoryByParentId(){
	var id=document.getElementById('category').value;
	var hiddenFild=document.getElementById('categoryId');
	hiddenFild.value=id;
	if(id>0){
	$("#subCategory1").empty();
	$("#subCategory2").empty();
	var options ='<option value="0">Select</option>';
	  $.ajax({
	  type: "POST",
	  url: "getSubCategoryByParentId.do",
	  data:'Id='+id,
	  dataType: 'json',
	  cache: false,
	  success: function(response){
	 	  
          for (var i = 0; i < response.list.length; i++) {
            options += '<option value="' + response.list[i][0] + '">' + response.list[i][1] + '</option>';
          }
          $("#subCategory1").html(options);
          $("#subCategory2").html('<option value="0">Select</option>');
	  },
	  error: function(){      
	   //alert('Error while request..');
	  }
	 });
	 }else{
		 	$("#subCategory1").empty();
			$("#subCategory2").empty();
			$("#subCategory1").html('<option value="0">Select</option>');
	        $("#subCategory2").html('<option value="0">Select</option>');
	 }
}


function getCategoryByParentIdForAddItem(){
	var id=document.getElementById('category').value;
	var hiddenFild=document.getElementById('categoryId');
	if(id>0){
	$("#subCategory1").empty();
	$("#subCategory2").empty();
	var options ='<option value="0">Select</option>';
	  $.ajax({
	  type: "POST",
	  url: "getSubCategoryByParentId.do",
	  data:'Id='+id,
	  dataType: 'json',
	  cache: false,
	  success: function(response){
	 	  
          for (var i = 0; i < response.list.length; i++) {
            options += '<option value="' + response.list[i][0] + '">' + response.list[i][1] + '</option>';
          }
          $("#subCategory1").html(options);
          $("#subCategory2").html('<option value="0">Select</option>');
	  },
	  error: function(){      
	   //alert('Error while request..');
	  }
	 });
	 }else{
		 	$("#subCategory1").empty();
			$("#subCategory2").empty();
			$("#subCategory1").html('<option value="0">Select</option>');
	        $("#subCategory2").html('<option value="0">Select</option>');
	 }
}

///////////////////////////////////////////////////////////////////////////////
function getCategoryByParentId1(){
	var id=document.getElementById('category').value;
	/*if(id>0){
	var options ='<option value="0">Select</option>';
	
	$("#subCategory2").empty();
	
	$.ajax({
	  type: "POST",
	  url: "getSubCategoryByParentId.do",
	  data:'Id='+id,
	  dataType: 'json',
	  cache: false,
	  success: function(response){
		  
		  
          for (var i = 0; i < response.list.length; i++) {
            options += '<option value="' + response.list[i][0] + '">' + response.list[i][1] + '</option>';
          }
          $("#subCategory2").html(options);
	  },
	  error: function(){      
	   alert('Error while request..');
	  }
	  
	 }
	);
	}else
	{
		
			$("#subCategory2").empty();
	        $("#subCategory2").html('<option value="0">Select</option>');
	 
	}  */
}

//////////////////////////////////////////////////////////////////////////////

function addItemToMultipleMenues(){
	var flag="true";
	var id=document.getElementById('subCategory1').value;
	var hiddenFild=document.getElementById('categoryId');
	var arrVal=hiddenFild.value.split(",");
	for (var int = 0; int < arrVal.length; int++) {
		if( arrVal[int] == id ){
			flag="false";
			alert($("#subCategory1 :selected").text() +" Already added");
			break;
		}
	}
	if(flag == "true" && id != 0){
		if(hiddenFild.value == 0 || hiddenFild.value== "0")
			hiddenFild.value = id;
		else
			hiddenFild.value = hiddenFild.value + "," +id;
		
		var arr=hiddenFild.value.split(",");
		var buttonToAdd="<div style='background:#5E2D79;color:#ccc;padding:2px;margin-top:5px;'>"+$("#subCategory1 :selected").text()+"</div>";
		$('#menuShow').append(buttonToAdd);
		//alert($("#subCategory1 :selected").text()+" added and Total menues:"+arr.length);
	}
	/*if(id>0){
	var options ='<option value="0">Select</option>';
	
	$("#subCategory2").empty();
	
	$.ajax({
	  type: "POST",
	  url: "getSubCategoryByParentId.do",
	  data:'Id='+id,
	  dataType: 'json',
	  cache: false,
	  success: function(response){
		  
		  
          for (var i = 0; i < response.list.length; i++) {
            options += '<option value="' + response.list[i][0] + '">' + response.list[i][1] + '</option>';
          }
          $("#subCategory2").html(options);
	  },
	  error: function(){      
	   //alert('Error while request..');
	  }
	  
	 }
	);
	}else
	{
			$("#subCategory2").empty();
	        $("#subCategory2").html('<option value="0">Select</option>');
	}*/  
}
function setParentIdOnHidden(){
	var id=document.getElementById('subCategory2').value;
	var hiddenFild=document.getElementById('categoryId');
	hiddenFild.value=id;
	
}
function getMenues(){
	$.ajax({
		  type: "POST",
		  url: "header.do",
		  dataType: "html",
		  cache: false,
		  success: function(response){
			  //$('menues').html(response);
			  //document.getElementById('menues').innerHTML=response;
			  alert(response);
			  $("#menues").append(response);
			  },
			  error: function(){      
			   //alert('Error while request..');
			  }
	});			  
		
}

function getCategoryAllDetailsById(){
	var id=document.getElementById('category').value;
	var hiddenFild=document.getElementById('categoryId');
	hiddenFild.value=id;
	if(id>0){
	$("#subCategory1").empty();
	$("#subCategory2").empty();
	var options ='<option value="0">Select</option>';
	  $.ajax({
	  type: "POST",
	  url: "getSubCategoryByParentId.do",
	  data:'Id='+id,
	  dataType: 'json',
	  cache: false,
	  success: function(response){
	 	  
          for (var i = 0; i < response.list.length; i++) {
            options += '<option value="' + response.list[i][0] + '">' + response.list[i][1] + '</option>';
          }
          $("#subCategory1").html(options);
          $("#subCategory2").html('<option value="0">Select</option>');
	  },
	  error: function(){      
	   //alert('Error while request..');
	  }
	 });
	 }else{
		 	$("#subCategory1").empty();
			$("#subCategory2").empty();
			$("#subCategory1").html('<option value="0">Select</option>');
	        $("#subCategory2").html('<option value="0">Select</option>');
	 }
	
	//Getting all menu data...
	var imagePath='';
	$.ajax({
		  type: "POST",
		  url: "getCategoryById.do",
		  data:'Id='+id,
		  dataType: 'json',
		  cache: false,
		  success: function(response){
		 	  
	          //$("#categoryName").html(response.list[0]);
			  document.getElementById('categoryName').value=response.list[0];
	          $("#categoryShortDescription").html(response.list[1]);
	          $("#description").html(response.list[2]);
	          imagePath = response.list[4];
	          getImage(imagePath);
	          var options ='';
	          var optVal=String.fromCharCode(response.list[3]);
	          	if(optVal == 'A' || optVal == 'a'){
	          	 options += '<option value="' + optVal + '" selected>' + optVal + '</option>';
	          	 options += '<option value="D"> D </option>';
	          	}
	          	else{
	          		options += '<option value="' + optVal + '" selected>' + optVal + '</option>';
		          	options += '<option value="A"> A </option>';	
	          	}
	          		
	          $("#status").html(options);
	          $("#imageFile").html(response.list[4]);
	         // $("#image").html();
	          document.getElementById('image').innerHTML='<div><img src="response.list[4]" height="50px" width="50px"></img></div>';
	          
		  },
		  error: function(){      
		   //alert('Error while request..');
		  }
		 });
	
}
function getImage(imgPath){
	$.ajax({
		  			type: "POST",
		  			url :"getImage.do?imgPath="+imgPath,             
		  			contentType: "image/png",
		  			dataType: 'text',
		        success: function(data) { 
		        	$('#showImg').html('<img id="blah" src="data:image/png;base64,' + data + '" />');
		        }
		    });
}
function getCategoryAllDetailsByIdForSubMenu(){
	var id=document.getElementById('subCategory1').value;
	var hiddenFild=document.getElementById('categoryId');
	hiddenFild.value=id;
//Getting all menu data...
	
	$.ajax({
		  type: "POST",
		  url: "getCategoryById.do",
		  data:'Id='+id,
		  dataType: 'json',
		  cache: false,
		  success: function(response){
		 	  
	            
			  document.getElementById('categoryName').value=response.list[0];
	          $("#categoryShortDescription").html(response.list[1]);
	          $("#description").html(response.list[2]);
	          getImage(response.list[4]);
	          var options ='<option>Select</option>';
	          var optVal=String.fromCharCode(response.list[3]);
	          	if(optVal == 'A' || optVal == 'a'){
	          	 options += '<option value="' + optVal + '" selected>' + optVal + '</option>';
	          	 options += '<option value="D"> D </option>';
	          	}
	          	else{
	          		options += '<option value="' + optVal + '" selected>' + optVal + '</option>';
		          	options += '<option value="A"> A </option>';	
	          	}
	          $("#status").html(options);
	          $("#imageFile").html(response.list[4]);
	         // $("#image").html();
	          document.getElementById('image').innerHTML='<div><img src="response.list[4]" height="50px" width="50px"></img></div>';
	          
		  },
		  error: function(){      
		   //alert('Error while request..');
		  }
		 });
	}

