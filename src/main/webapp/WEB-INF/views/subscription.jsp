<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="css/style3.css" />
<title>Untitled Document</title>
</head>
<script>
function writeSidAndAmount(sidAndAmount)
	{
		/* alert(sidAndAmount.value); */
		var arr=sidAndAmount.value.split(",");
		
		document.getElementById("sid").value=arr[0];
		document.getElementById("amount").value=arr[1];
	}
</script>
<body>

<div class="container">

<div class="cmp_tblwrap e_lt">
                <div class="cmp_tbl tbl1">
                	<div class="cmp_tblrow th">
                        <div class="cmp_tblcell cell1">Features</div>
						<div class="cmp_tblcell">Quick</div><div class="cmp_tblcell">Premium</div>
                        <div class="cmp_tblcell">Power</div></div>
                    <div class="cmp_tblrow">
                        <div class="cmp_tblcell cell1">Job Posting Validity</div>
                        <div class="cmp_tblcell">30 Days</div><div class="cmp_tblcell">60 Days</div>
                        <div class="cmp_tblcell">60 Days</div></div>
                    <div class="cmp_tblrow">
                        <div class="cmp_tblcell cell1">Response Management Software (MOHQ)</div>
                        <div class="cmp_tblcell"><div class="cross"></div></div><div class="cmp_tblcell"><div class="tick"></div></div>
                        <div class="cmp_tblcell"><div class="tick"></div></div></div>
                    <div class="cmp_tblrow">
                        <div class="cmp_tblcell cell1">Automated Segregation on Relevance</div>
                        <div class="cmp_tblcell"><div class="cross"></div></div><div class="cmp_tblcell"><div class="tick"></div></div>
                        <div class="cmp_tblcell"><div class="tick"></div></div></div>
                    <div class="cmp_tblrow">
                        <div class="cmp_tblcell cell1">Company Profile</div>
                        <div class="cmp_tblcell"><div class="cross"></div></div><div class="cmp_tblcell"><div class="tick"></div></div>
                        <div class="cmp_tblcell"><div class="tick"></div></div></div>
                    <div class="cmp_tblrow">
                        <div class="cmp_tblcell cell1">Job Bolding</div>
                        <div class="cmp_tblcell"><div class="cross"></div></div><div class="cmp_tblcell"><div class="cross"></div></div>
                        <div class="cmp_tblcell"><div class="tick"></div></div></div>
                    <div class="cmp_tblrow">
                        <div class="cmp_tblcell cell1">JD Character Limit</div>
                        <div class="cmp_tblcell">Unlimited</div><div class="cmp_tblcell">Unlimited</div>
                        <div class="cmp_tblcell">Unlimited</div></div>
                    <div class="cmp_tblrow">
						<div class="cmp_tblcell cell1">Function(s) / Location(s) per inventory</div>
                        <div class="cmp_tblcell">2 X 2</div><div class="cmp_tblcell">2 X 2</div>
                        <div class="cmp_tblcell">2 X 2</div></div>
                    <div class="cmp_tblrow">
                        <div class="cmp_tblcell cell1">Visibility on Monster's Alliances</div>
                        <div class="cmp_tblcell"><div class="cross"></div></div><div class="cmp_tblcell"><div class="cross"></div></div>
                        <div class="cmp_tblcell"><div class="tick"></div></div></div>
                </div>
            </div>
            
            <form action="getsubscription.do" method="post">
            
            <div class="cmp_tblwrap1 e_rt">
            	 <div class="cmp_tbl tbl1">
                	<div class="cmp_tblrow th">
                        <div class="cmp_tblcell">Quantity</div>
                       <div class="cmp_tblcell colr1">Quick Posting</div><div class="cmp_tblcell">Premium Posting</div><div class="cmp_tblcell colr1">Power Posting</div></div>
					<!-- loop start -->
					<c:set var="refreshSent" value="true"/>
					<c:forEach begin="0" end="${quickSubDtoList.size()-1}" var="i">
					
					<c:if test="${refreshSent}">
					
					
					<div class="cmp_tblrow ">
                        <div class="cmp_tblcell">${quickSubDtoList[i].quantity}</div>
						<div class="cmp_tblcell">
							<div class="check_wrap">
                                <div class="e_lt checkbox rad1"><input  type="radio" onclick="writeSidAndAmount(this);" name="posttingType" class="rad" data-class="rad1" value="${quickSubDtoList[i].sid},${quickSubDtoList[i].amount}" checked="checked"></div>
                                <div class="e_lt rupee_symbol other">&#x20B9;</div>
                                <div class="e_lt rupee_txt">${quickSubDtoList[i].amount}</div>
                                <div class="e_clr"></div>
                            </div>
						</div>
						
						
						<div class="cmp_tblcell">
							<div class="check_wrap">
                                <div class="e_lt checkbox rad1"><input type="radio" onclick="writeSidAndAmount(this);" name="posttingType" class="rad" data-class="rad1" value="${premiumSubDtoList[i].sid},${premiumSubDtoList[i].amount}"></div>
                                <div class="e_lt rupee_symbol other">&#x20B9;</div>
                                <div class="e_lt rupee_txt">${premiumSubDtoList[i].amount}</div>
                                <div class="e_clr"></div>
                            </div>
						</div>
						<div class="cmp_tblcell">
							<div class="check_wrap">
                                <div class="e_lt checkbox rad1"><input type="radio" onclick="writeSidAndAmount(this);" name="posttingType" class="rad" data-class="rad1" value="${powerSubDtoList[i].sid},${powerSubDtoList[i].amount}"></div>
                                <div class="e_lt rupee_symbol other">&#x20B9;</div>
                                <div class="e_lt rupee_txt">${powerSubDtoList[i].amount}</div>
                                <div class="e_clr"></div>
                            </div>
						</div>
						
						</div>
						<c:set var="refreshSent" value="true"/>
						</c:if>
						<input type="hidden" name="sid" id="sid" value="8"/> 
					</form>	
						<%-- <c:if test="${not refreshSent}">
					<div class="cmp_tblrow colr1">
                        <div class="cmp_tblcell">5 ${refreshSent}</div>
						<div class="cmp_tblcell">
							<div class="check_wrap">
                                <div class="e_lt checkbox rad1"><input type="radio" onclick="writeSidAndAmount(this);" name="quick_jp" class="rad" data-class="rad1" value="1391"></div>
                                <div class="e_lt rupee_symbol other"><del>?</del></div>
                                <div class="e_lt rupee_txt">3500</div>
                                <div class="e_clr"></div>
                            </div>
							</div>
						<div class="cmp_tblcell">
							<div class="check_wrap">
								<div class="e_lt checkbox rad2"><input type="radio" onclick="writeSidAndAmount(this);" name="premium_jp" class="rad" data-class="rad2" value="1399"></div>
                                <div class="e_lt rupee_symbol other"><del>?</del></div>
                                <div class="e_lt rupee_txt">5999</div>
                                <div class="e_clr"></div>
                            	</div>
							</div>
						<div class="cmp_tblcell">
							<div class="check_wrap">
								<div class="e_lt checkbox rad3"><input type="radio" onclick="writeSidAndAmount(this);" name="power_jp" class="rad" data-class="rad3" value="1407"></div>
                                <div class="e_lt rupee_symbol other"><del>?</del></div>
                                <div class="e_lt rupee_txt">29995</div>
                                <div class="e_clr"></div>
                            	</div>
							</div>
						</div>
						<c:set var="refreshSent" value="true"/>
						</c:if> --%>
						</c:forEach>
						</div>
						
	                   
 					 <div class="cmp_tbl tbl2">
                	<div class="cmp_tblrow btnw">
                        <div class="cmp_tblcell">&nbsp;</div>
						<div class="cmp_tblcell">
                        	<input type="submit" class="buy_btn" value="Buy Now"/>
							<a href="getsubscription.do" class="view_lnk jp_pop" data-id="quick">View Example</a>
                        </div>
						<div class="cmp_tblcell">
                        	<input type="submit" class="buy_btn" value="Buy Now"/>
							<a href="getsubscription.do" class="view_lnk jp_pop" data-id="premium">View Example</a>
                        </div>
						<div class="cmp_tblcell colr1">
                        	<input type="submit" class="buy_btn" value="Buy Now"/>
							<a href="javascript:void(0);" class="view_lnk jp_pop" data-id="power">View Example</a>
                        </div>
						</div>
                    </div>
                          </div>
				</form>
	<table border="2">
		<tr><th>Product Name</th><th> Duration </th><th>Rate card</th><th>Action</th></tr>
		<c:forEach items="${packSubDtoList}" var="packSubDto">
		<tr><td>${packSubDto.name}</td><td>${packSubDto.validityDays}</td><td>${packSubDto.amount}</td><td><a href="getsubscription.do?sid=${packSubDto.sid}"> <input type="button" class="buy_btn" value="Buy Now" /></a></td></tr>
		</c:forEach>
	</table>
</body>
</html>
