<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<style>
td {
    font-family: Verdana,Arial,Helvetica,sans-serif;
    font-size: 12px;
}
table[Attributes Style] {
    width: 98%;
    border-top-width: 0px;
    border-right-width: 0px;
    border-bottom-width: 0px;
    border-left-width: 0px;
    -webkit-margin-start: auto;
    -webkit-margin-end: auto;
    border-spacing: 0px;
}
user agent stylesheettable {
    white-space: normal;
    line-height: normal;
    font-weight: normal;
    font-size: medium;
    font-variant: normal;
    font-style: normal;
    color: -webkit-text;
    text-align: start;
}
user agent stylesheettable {
    display: table;
    border-collapse: separate;
    border-spacing: 2px;
    border-color: grey;
}
Inherited from 
body {
    font-family: Verdana,Arial,Helvetica,sans-serif;
    font-size: 12px;
    margin: 0;
    padding: 0;
}
body {
    font-family: Verdana, Arial, Helvetica, sans-serif;
    font-size: 11px;
    margin: 0px;
    padding: 0px;
    height: 900px;
}
</style>


<title>Untitled Document</title>
</head>

<body>

<table width="980" border="0" align="center" cellpadding="0" cellspacing="0" style="margin-top:40px; margin-bottom:40px">

<tbody><tr>
<td valign="top" style="padding-right:20px;">
    <table width="415" border="0" align="right" cellpadding="0" cellspacing="0">

<tbody><tr>
       <td colspan="3">
<div style="width:237; margin:0px 0px 0px 0px;">
<script type="text/javascript" src="http://livehelp.monsterindia.com/livehelp_js.php?department=11&amp;serversession=1&amp;pingtimes=10"></script>
</div>


<div style="width:265px; z-index:1000; position:absolute; margin:-27px 0px 0px 156px;"><a href="#"><img width="265" height="27" border="0" src="https://media4.monsterindia.com/v2/recruiter/2.1/new_pages/ecomm/btn_already_member.png"></a></div>

</td>
    </tr>
</tbody></table></td>
			  </tr>
<tr>
  <td valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tbody><tr>
    <!--   <td width="6"><img src="https://media4.monsterindia.com/v2/recruiter/2.1/new_pages/ecomm/corner_1.jpg" width="6" height="6"></td>
      <td colspan="3" style="border-top:solid 1px #d3d3d3"><img src="https://media4.monsterindia.com/v2/recruiter/2.1/new_pages/trans.gif" width="1" height="1"></td>
      <td width="6"><img src="https://media4.monsterindia.com/v2/recruiter/2.1/new_pages/ecomm/corner_2.jpg" width="6" height="6"></td>
 -->
    </tr>
    <tr>
      <td style="border-left:solid 1px #d3d3d3">&nbsp;</td>
      <td width="50%" valign="top" style="background:url(https://media4.monsterindia.com/v2/recruiter/2.1/new_pages/ecomm/bg_1.jpg) repeat-x left top; padding:20px;"><table width="100%" border="0" cellspacing="0" cellpadding="4">
	 <tbody><tr>
                    <td width="35%">Name<span class="txt_red">*</span></td>
                    <td width="2%">:                      </td>
                    <td width="65%"><input name="person_name" type="text" class="border_purple small_1" size="26" value="" onblur="checkValue();"></td>
                  </tr>
                  <tr>
                    <td>Email<span class="txt_red">*</span></td>
                    <td>:                      </td>
                    <td><input name="email" type="text" class="border_purple small_1" size="26" value="" onblur="checkValue();"></td>
                  </tr>
                  <tr>
                    <td>Phone Number<span class="txt_red">*</span></td>
                    <td>:                      </td>
                    <td>
		<input name="stdcode" type="text" class="border_purple small_1" value="" size="4" onblur="checkValue();">&nbsp;<input name="phone" type="text" class="border_purple small_1" size="17" value="" onblur="checkValue();"></td>
                  </tr>
                  <tr>
                    <td nowrap="">Company Name<span class="txt_red">*</span></td>
                    <td>:                      </td>
                    <td><input name="email" type="text" class="border_purple small_1" size="26" value="" onblur="checkValue();"></td>
                  </tr>
                  

                  <tr>
                    <td>Company Type<span class="txt_red">*</span></td>
                    <td>: </td>
                    <td><select>
						<option>Corporate (based in India)</option>
						<option>Corporate (based outside India)</option>
						<option>Placement Agency</option>
					</select></td>

                  </tr>

                  <tr>
                    <td>Mobile<span class="txt_red">*</span></td>
                    <td>:                      </td>
                    <td><input name="mobile" type="text" class="border_purple small_1" size="26" value="" onblur="checkValue();"></td>
                  </tr>
                  <tr>
                    <td valign="top">Address<span class="txt_red">*</span></td>
                    <td valign="top">:                      </td>
                    <td valign="top"><textarea name="address" cols="28" class="border_purple small_1"></textarea></td>
                  </tr>

                  <tr>
                    <td>City<span class="txt_red">*</span></td>
                    <td>:</td>
                    <td><input name="city" type="text" class="border_purple small_1" size="26" value=""></td>
                  </tr>
		<tr>
                    <td>State<span class="txt_red">*</span></td>
                    <td>:</td>
                    <td><input name="state" type="text" class="border_purple small_1" size="26" value=""></td>
                  </tr>
                   <tr>
				   <td>Pincode/Zip Code<span class="txt_red">*</span></td>
					<td>:</td>
                    <td><input name="zip" type="text" class="border_purple small_1" size="26" value=""></td>
                  </tr>        
			<tr>
                    <td>Country<span class="txt_red">*</span></td>
                    <td>:</td>
                    <td>
						<select>
						<option selected> India </option>
						</select>
					</td>
                  </tr>       
            </tbody></table>

           </td>
      <td width="14" valign="top"><img src="https://media4.monsterindia.com/v2/recruiter/2.1/new_pages/ecomm/divider_shadow.jpg" width="14" height="211"></td>
      <td width="50%" valign="top" style="background:url(https://media4.monsterindia.com/v2/recruiter/2.1/new_pages/ecomm/bg_2.jpg) repeat-x left top; padding:20px"><table width="100%" border="0" cellspacing="0" cellpadding="5">
			<tbody><tr><td>  
			</td></tr>
			<tr><td colspan="2" class="bold"> Your Order Preview: </td></tr>
		<tr>
        		              <td valign="top">Buy 700 Quick Job Posting and Get 50 Posting Free</td><td valign="top" nowrap="">: Rs. ${amount}</td>
	                    </tr><tr>
		<td id="service_tax">Service Tax (14%)</td>
		<input type="hidden" name="servicetax" id="servicetax" value="14">
			<input type="hidden" name="amt" id="amt" value="${amount}">
			<input type="hidden" name="curr" id="curr" value="Rs.">
                      <td nowrap="" id="tax_cur">: Rs. ${taxAmt}</td>
                    </tr>
                    <tr>
                      <td class="Form_bold" align="right">Total Price</td>
                      <td class="Form_bold" nowrap="" id="tot_price">: Rs. ${totalAmt}</td>
                    </tr>
                  </tbody></table>        
        <br>
	<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
                      <tbody><tr>
<td height="1" colspan="3" align="right" class="Form_bold"></td>
</tr>
                    </tbody></table>

			       <br>
		
		 <table width="100%" border="0" cellpadding="4" cellspacing="0">
          <tbody><tr>
            <td width="7%" class="heading_4"><input type="checkbox" name="terms_chk" value="checkbox"></td>
            <td width="93%" class="heading_4"><a href="" target="_blank" class="heading_4">I have read and I agree to the terms of service</a></td>
          </tr>
        </tbody></table>
		
         <table width="100%" border="0" cellspacing="0" cellpadding="5">
				<tbody><tr>
				<td>
				<span style="width:237; margin:0px 0px 0px 0px;"><input type="submit" value="Pay now" title="Pay Now"></span>
				<!-- <span class="bold">Select Payment Mode</span>-->
             <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tbody><tr>
                  <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tbody><tr>
                      <!--<td width="45%">
					  <label for="select"></label>
									<span id="fancypaymentButton" class="yui-button yui-menu-button" style="background-color: rgb(255, 255, 255);"><span class="first-child"><button type="button"><em style="width: 150px;">- Select -</em></button></span></span>
									
									
								<div id="fancypaymentSelectionMenu" class="yui-module yui-overlay yui-button-menu yui-menu-button-menu" style="visibility: hidden; z-index: 1001; left: 827.5px; top: 586px;"><div class="bd"><div class="selectionMenu"><div class="ulDiv" style="width: 170px; height: 57px; overflow: auto;"><div class="liDiv selected"><a href="#" tabindex="-1" class="txt_black heading_4">- Select -</a></div><div class="liDiv"><a href="#" tabindex="-1" class="txt_black heading_4">Online Payment</a></div><div class="liDiv"><a href="#" tabindex="-1" class="txt_black heading_4">Wire Transfer - Payment</a></div></div></div></div></div></td>
								 <td width="55%"><span style="width:237; margin:0px 0px 0px 0px;"><input type="image" src="https://media4.monsterindia.com/v2/recruiter/2.1/buttons/pay_now_trans.gif" alt="Pay Now" border="0" align="bottom" title="Pay Now" onclick="return validate(this)"></span></td>-->
							 </tr>
                    </tbody></table>
                    <span style="width:237; margin:0px 0px 0px 0px;"></span></td>
                </tr>
              </tbody></table>
					
				</td>
			</tr>
		</tbody></table>
		
		</td>

      <td style="border-right:solid 1px #d3d3d3">&nbsp;</td>
	  
	  
    </tr>
	
	
	
	<tr>
	<td style="border-left:solid 1px #d3d3d3" class="bg_green2">&nbsp;</td>
	<td height="40" class="bg_green2" colspan="3"><div style="float:right;"><img width="128" height="36" src="https://media4.monsterindia.com//v2/recruiter/2.1/ecomm/dinner_club.gif"></div><div style="float:right; margin-right:10px; margin-top:4px;"><img width="77" height="27" src="https://media4.monsterindia.com//v2/recruiter/2.1/ecomm/Internetbanking.gif"></div>
	 <div style="float:right; margin-right:10px;margin-top:4px;"><img width="88" height="27" src="https://media4.monsterindia.com//v2/recruiter/2.1/ecomm/AmericanXpress.gif"></div><div style="float:right; margin-right:10px;margin-top:4px;"><img width="78" height="27" src="https://media4.monsterindia.com//v2/recruiter/2.1/ecomm/mastercard.gif"></div><div style="float:right; margin-right:10px;margin-top:4px;"><img width="51" height="29" src="https://media4.monsterindia.com//v2/recruiter/2.1/ecomm/verfied_by_visa.jpg"></div></td>
	<td style="border-right:solid 1px #d3d3d3" class="bg_green1">&nbsp;</td>
	</tr>
	



    <tr>
      <td><img src="https://media4.monsterindia.com/v2/recruiter/2.1/new_pages/ecomm/corner_4.jpg" width="6" height="6"></td>
      <td colspan="3" style="border-bottom:solid 1px #d3d3d3"><img src="https://media4.monsterindia.com/v2/recruiter/2.1/new_pages/trans.gif" width="1" height="1"></td>
      <td><img src="https://media4.monsterindia.com/v2/recruiter/2.1/new_pages/ecomm/corner_3.jpg" width="6" height="6"></td>
    </tr>
  </tbody></table></td>
</tr>

</tbody></table>
</body>
</html>
