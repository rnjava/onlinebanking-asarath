<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-US" lang="en-US" class="chrome chrome-22 webkit">
	<head>
	<%
		String contextPath = request.getContextPath();
	%>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
		<title>Online Banking | Transfer Funds | Make Transfer</title>
		<link rel="shortcut icon" href="href="<%=contextPath%>/images/favicon.ico" type="image/ico"/>
		<link
			href="<%=contextPath%>/css/pipad-jawr.css"
			rel="stylesheet" type="text/css" media="all"/>
		<link
			href="<%=contextPath%>/css/pipad-jawr-print.css"
			rel="stylesheet" type="text/css" media="print"/>

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
							src="<%=contextPath%>/images/${form.tenantId}.gif"
							title=" logo"/>
					</div>
					<div class="fl-rt no_print">
						<div class="common-margin">
							<div class="fl-lt">
								<img alt="Online Banking"
									src="<%=contextPath%>/images/onlineBanking_en.gif"/>
							</div>
							<div class="sign-off">
								<a id="Sign_Off_header" name="Sign_Off_header"
									href="login?tenantid=<core:out value="${form.tenantId}"/>"
									title="Sign Off">Sign Off</a>
							</div>
						</div>
						<div class="clearboth"></div>
						</div>
						<div class="clearboth"></div>
					</div>
					<div class="clearboth"></div>
				</div>


        <!--  Top nav  -->
			<div id="nav-tier-2-module" class="nav-tier-2-module no_print">
				<ul class="nav2">
					<li><a id="Accounts_topnav" name="Accounts_topnav"
						rel="nav-mod-content1"
						href="accountsoverview?profileid=<core:out value="${form.profileId}"/>&tenantid=<core:out value="${form.tenantId}"/>"
						title="Accounts">Accounts</a></li>
					<li><a id="Transfers_topnav" name="Transfers_topnav"
						class="modal-link selected"  rel="nav-mod-content3"
						href="maketransfer?profileid=<core:out value="${form.profileId}"/>&tenantid=<core:out value="${form.tenantId}"/>"
						title="Transfers">Transfers</a></li>
					<!-- <li><a id="Customer_Service_topnav"
						name="Customer_Service_topnav" rel="nav-mod-content7 "
						href=""
						title="Customer Service">Customer Service</a></li>
						-->
				</ul>
			</div>


			<div class="sub-nav-box">
				<div class="sub-nav" id="nav-mod-content3">
					<ul>
						<li><a id="Make_Transfer" name="Make_Transfer" class="selected" href="maketransfer?profileid=<core:out value="${form.profileId}"/>&tenantid=<core:out value="${form.tenantId}"/>" title="Make Transfer">Make Transfer</a></li>
						<!-- <li><a id="Review_Transfer" name="Review_Transfer" href="" title="Review Transfers">Review Transfers</a></li>-->
						<li><a id="Add_Account" name="Add_Account" href="addrecipient?profileid=<core:out value="${form.profileId}"/>&tenantid=<core:out value="${form.tenantId}"/>" title="Add Recipient">Add Recipient</a></li>
						<!-- <li><a id="Manage_Account" name="Manage_Account" href="" title="Manage Accounts/Recipients">Manage Accounts/Recipients</a></li>-->
					</ul>
				</div>
			</div>
			<div class="clearboth"></div>
			
		</td>
	</tr>
</table>
</body>
</html>