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
							title="logo"/>
					</div>
					<div class="fl-rt no_print">
						<div class="common-margin">
							<div class="fl-lt">
								<img alt="Online Banking"
									src="<%=contextPath%>/images/onlineBanking_en.gif"/>
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
						href="maketransfer"
						title="Transfers">Transfers</a></li>
					<!-- <li><a id="Customer_Service_topnav"
						name="Customer_Service_topnav" rel="nav-mod-content7 "
						href="customercare"
						title="Customer Service">Customer Service</a></li> -->
				</ul>
			</div>


			<div class="sub-nav-box no_print">
				<div class="sub-nav" id="nav-mod-content1">

					<ul>
						<li><a id="Accounts_topnav" name="Accounts_topnav_borneo_AO"
							class="selected"
							href="accountsoverview?profileid=<core:out value="${form.profile.id}"/>&tenantid=<core:out value="${form.tenantId}"/>"
							title="Accounts Overview">Accounts Overview</a></li>

						<li><a id="Account_Details_topnav"
							name="Account_Details_topnav"
							href="accountdetails?accountid=<core:out value="${form.firstAccountId}"/>&tenantid=<core:out value="${form.tenantId}"/>&profileid=<core:out value="${form.profile.id}"/>"
							title="Account Details">Account Details</a></li>
<!-- 
						<li><a
							href=""
							title="Statements &amp; Documents">Statements &amp; Documents</a></li>
						<li><a id="Alerts_topnav" name="Alerts_topnav"
							href=""
							title="Alerts">Alerts</a></li>-->
					</ul>
				</div>
			</div>
			<div class="clearboth"></div>

			<div class="olb-account-greeting-message-bdf-module">
				<div class="default-skin">
					<div class="fl-lt">
						<a class="ada-hidden" name="skip_to_main_content"></a>
						<h1 class="ada-hidden">Accounts Overview</h1>
						<div class="h2-bold-14">
						</div>
						<div class="h2-bold-14">
							<core:out value="${form.profile.firstName}" />&nbsp;
							<core:out value="${form.profile.lastName}" /> 
							- Personal Accounts
						</div>
						<div class="f-11">
							Protect your accounts and information, <a
								id="visit_the_Security_Center" name="visit_the_Security_Center"
								class="bold"
								href=""
								title="visit the Security Center">visit the Security Center</a>
						</div>
					</div>
					<div class="fl-rt">Last sign in: 10/12/2012 at 02:56 AM ET</div>
					<div class="clearboth"></div>
				</div>
			</div>

		<div class="olb-account-listing-module">
					<div class="thick-border-module">
						<!-- Business Accts -->
						<div class="db-outer-corners tb-top-left"></div>
						<div class="db-outer-corners tb-top-right"></div>
						<div class="alt-dark-blue-title">
							<h2>
								<span class="title-text">Accounts</span>
							</h2>
						</div>
						<div class="db-inner-module">
							<div class="db-inner-corners tb-top-left"></div>
							<div class="db-inner-corners tb-top-right"></div>
							<div>

								<div class="title-row">
									<div class="left-column-head">Bank Accounts</div>
									<div class="right-column-head">
										Balance<a id="footnote_a" name="footnote_a"
											href=""
											title="Important Information About Balances"><sup><span
												class="ada-hidden">Footnote&nbsp;</span>a</sup></a>
									</div>
									<div class="clearboth"></div>
								</div>
							  <core:forEach items="${form.accountList}" var="account">
								<div class="account-row" rel="0" lang="en-us">
									<div class="left-column-content">
										<div class="image-account ">
											<a href="accountdetails?accountid=<core:out value="${account.id}"/>&tenantid=<core:out value="${form.tenantId}"/>&profileid=<core:out value="${form.profile.id}"/>">
											<core:out value="${account.type}" /></a>
										</div>
										<div class="clearboth"></div>
									</div>
									<div class="right-column-content">$<core:out value="${account.balance}" /></div>
									<div class="clearboth"></div>
							<div class="db-inner-corners tb-bottom-left"></div>
							<div class="db-inner-corners tb-bottom-right"></div>
						</div>
						</core:forEach>
						<div class="db-outer-corners tb-bottom-left"></div>
						<div class="db-outer-corners tb-bottom-right"></div>
					</div>
				</div>
			</div>
	 </div>
</td>
</tr>
</table>
</body>
</html>