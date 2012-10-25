<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-US" lang="en-US" class="chrome chrome-22 webkit">
	<head>
	<%
		String contextPath = request.getContextPath();
	%>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>TODO | Online Banking | Accounts Overview</title>
		<meta name="Description" content="">
		<meta name="Keywords" content="">
		<link rel="shortcut icon" href="href="<%=contextPath%>/images/favicon.ico" type="image/ico">
		<link
			href="<%=contextPath%>/css/pipad-jawr.css"
			rel="stylesheet" type="text/css" media="all">
		<link
			href="<%=contextPath%>/css/pipad-jawr-print.css"
			rel="stylesheet" type="text/css" media="print">

	<style>
		body {
			display: none;
		}
	</style>

	<style>
	.mboxDefault {
		visibility: hidden;
	}
	</style>
</head>

<body style="display: block;">
	<noscript>&lt;style&gt;body{display : block;}&lt;/style&gt;
	</noscript>
  
  <table align ="center" width="50%"  border="0">
    <tr>
      <td> 

			<div class="olb-header-module">
				<div class="olb-skin">
					<div class="common-img-container print">
						<img alt=" Logo"
							src="<%=contextPath%>/images/logo-hsbc.gif"
							title=" logo">
					</div>
					<div class="fl-rt no_print">
						<div class="common-margin">
							<div class="fl-lt">
								<img alt="Online Banking"
									src="<%=contextPath%>/images/onlineBanking_en.gif">
							</div>
							<div class="sign-off">
								<a id="Sign_Off_header" name="Sign_Off_header"
									href="login.html"
									title="Sign Off">Sign Off</a>
							</div>
						</div>
						<div class="clearboth"></div>
						</div>
						<div class="clearboth"></div>
					</div>
					<div class="clearboth"></div>
				</div>


			<div id="nav-tier-2-module" class="nav-tier-2-module no_print">
				<ul class="nav2">
					<li><a id="Accounts_topnav" name="Accounts_topnav"
						class="modal-link selected" rel="nav-mod-content1"
						href=""
						title="Accounts">Accounts</a></li>
					<li><a id="Transfers_topnav" name="Transfers_topnav"
						rel="nav-mod-content3"
						href=""
						title="Transfers">Transfers</a></li>
					<li><a id="Customer_Service_topnav"
						name="Customer_Service_topnav" rel="nav-mod-content7 "
						href=""
						title="Customer Service">Customer Service</a></li>
				</ul>
			</div>


			<div class="sub-nav-box no_print">
				<div class="sub-nav" id="nav-mod-content1">

					<ul>
						<li><a id="Accounts_topnav" name="Accounts_topnav_borneo_AO"
							href="accountsoverview?profileid=<core:out value="${form.profileId}"/>&tenantid=<core:out value="${form.tenantId}"/>"
							title="Accounts Overview">Accounts Overview</a></li>

						<li><a id="Account_Details_topnav" class="selected"
							name="Account_Details_topnav"
							href="accountdetails?accountid=<core:out value="${form.accountId}"/>&tenantid=<core:out value="${form.tenantId}"/>"
							title="Account Details">Account Details</a></li>

						<li><a
							href=""
							title="Statements &amp; Documents">Statements &amp; Documents</a></li>
						<li><a id="Alerts_topnav" name="Alerts_topnav"
							href=""
							title="Alerts">Alerts</a></li>
					</ul>
				</div>
			</div>
			<div class="clearboth"></div>

		
				<div class="olb-account-page-title-appdata-module">
				<div class="page-title-control">
					<a name="skip-to-main-content"></a>
						<h1 class="short-page-title page-title-head" id="skip-to-h1">
						<span class="TL_NPI_AcctName">MyAccess Checking - 7257</span>
						</a></h1><a href="javascript:void(0);" name="page_title_acct_switcher_0">
				</a>
				</div>
			<div class="clearboth"></div>
			
			
	<div class="account-summary-module">
	<div class="ptop-10">
      <div class="left-col">
        <h2>Summary</h2>      
        <div>
          <div class="fl-lt">
          	Available balance (as of today):
          </div>
          <div class="fl-rt bold  TL_NPI_Amt">$2,529.44</div>		  
    	  
          <div class="clearboth"></div>
          </div>
          </div>
          </div>
        </div>
        
       <table class="transaction-records" summary="Account Activity table, made up of Date, Description, Type, Status, Dollar Amount, and Available balance columns.">
			<thead>
				<tr>
					<th class="date" scope="col" style="width: 106px; ">Date</th>					
					<th class="desc" scope="col" style="width: 292px; ">Description</th>
					<th class="type" scope="col" style="width: 50px; ">Type</th>
					<th class="status" scope="col" style="width: 61px; ">Status</th>
					<th class="amount" scope="col" style="width: 99px; ">Amount</th>
					<th class="balance" scope="col" style="width: 113px; ">Available<br/>Balance</th>
				</tr>
			</thead>
			<tbody>
			 <core:forEach items="${form.transactionList}" var="transaction">
				<tr class="record transType-transfer cleared">
					<td class="date-action" rel="49">
						<span><core:out value="${transaction.date}" /></span>
					</td>
					<td class="description TL_NPI_TransDesc" rel="12">
					<span class="transTitleForEditDesc"><core:out value="${transaction.description}" /></span> 
					</td>
					<td class="type">
						<span><core:out value="${transaction.type}" /></span>
					</td>
					<td class="status"><span><core:out value="${transaction.status}" /></span></td>
					<td class="amount TL_NPI_Amt isDebit"><core:out value="${transaction.amount}" /></td>
					<td class="balance TL_NPI_Amt"><core:out value="${transaction.availableBalance}" /></td>
				</tr>
				<div class="clearboth"></div>
				</core:forEach>
				</tbody>
		</table>
</td>
</tr>
</table>
</body>
</html>