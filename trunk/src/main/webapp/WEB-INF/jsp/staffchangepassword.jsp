<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-US" lang="en-US" class="chrome chrome-22 webkit">
	<head>
	<%
		String contextPath = request.getContextPath();
	%>
		<title>Online Banking | Staff</title>
		<link rel="shortcut icon" href="href="<%=contextPath%>/images/favicon.ico" type="image/ico"/>
		<link
			href="<%=contextPath%>/css/pipad-jawr.css"
			rel="stylesheet" type="text/css" media="all"/>
		<link
			href="<%=contextPath%>/css/pipad-jawr-print.css"
			rel="stylesheet" type="text/css" media="print"/>
		<link
			href="<%=contextPath%>/css/style.css"
			rel="stylesheet" type="text/css" media="all"/>	
					

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
									href="stafflogin?tenantid=<core:out value="${form.tenantId}"/>"
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
						class="modal-link" rel="nav-mod-content1"
						href="staffloginsuccess?profileid=<core:out value="${form.staffProfileId}"/>&tenantid=<core:out value="${form.tenantId}"/>"
						title="Customer Transaction">Customer Transaction</a></li>
					<li><a id="Transfers_topnav" name="Transfers_topnav"
						rel="nav-mod-content3"
						href="staffcreateaccount?profileid=<core:out value="${form.staffProfileId}"/>&tenantid=<core:out value="${form.tenantId}"/>"
						title="Create New Accounts">Open New Account</a></li>
					<li><a id="Transfers_topnav" name="Transfers_topnav"
						rel="nav-mod-content3 selected"
						href="staffchangepassword?profileid=<core:out value="${form.staffProfileId}"/>&tenantid=<core:out value="${form.tenantId}"/>"
						title="Create New Accounts">User Management</a></li>
						
				</ul>
			</div>


			<div class="sub-nav-box no_print">
				<div class="sub-nav" id="nav-mod-content1">

					<ul>
						<li><a id="Accounts_topnav" name="Accounts_topnav_borneo_AO"
							class="selected"
							href="staffchangepassword?profileid=<core:out value="${form.staffProfileId}"/>&tenantid=<core:out value="${form.tenantId}"/>"
							title="Accounts Overview">Change Password</a></li>
							<core:if test="${not empty role}">
						<li><a id="Accounts_topnav" name="Accounts_topnav_borneo_AO"
							href="staffcreatenewuser?profileid=<core:out value="${form.staffProfileId}"/>&tenantid=<core:out value="${form.tenantId}"/>"
							title="Accounts Overview">Create User</a></li>
							</core:if>
							
<!-- 
						<li><a id="Account_Details_topnav"
							name="Account_Details_topnav"
							href=""
							title="Account Details">Transfer Funds</a></li>

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
						</div>
						<!-- div class="f-11">
							Protect your accounts and information, <a
								id="visit_the_Security_Center" name="visit_the_Security_Center"
								class="bold"
								href=""
								title="visit the Security Center">visit the Security Center</a>
						</div-->
					</div>
					<!-- div class="fl-rt">Last sign in: 10/12/2012 at 02:56 AM ET</div-->
					<div class="clearboth"></div>
				</div>
			</div>

		<div class="olb-account-listing-module">
					<div class="thick-border-module">
						<div class="alt-dark-blue-title">
							<h2>
								<span class="title-text">Change Password</span>
							</h2>
						</div>
		<div class="db-inner-module">						
			<form:form method="post" action="staffchangepasswordsubmit" commandName="form"  onsubmit="return true;" name="submitPassword">
				<div class="clsError" align="center"><form:errors path="*" cssClass="error" /></div>
						<core:if test="${not empty successMessage}">
    						<div class="clsSuccess" >${successMessage}</div>
						</core:if>
	
				<div class="data-label">&nbsp;
					 <label id="recipient-last-name_label" for="recipient-last-name">Current Password *</label>
				</div>
				<div class="data-input">&nbsp;
					<form:password path="currentPassword" maxlength="40" value=""/>
				</div>
				<div class="data-label">&nbsp;
					 <label id="recipient-nick-name_label" for="recipient-nick-name">New Password *</label>
				</div>
				<div class="data-input">&nbsp;
					<form:password path="newPassword" maxlength="20" value=""/>
				</div>
				<div class="data-label">&nbsp;
					 <label id="recipient-account-number_label" for="recipient-account-number">Re-enter New Password *</label>
				</div>
				<div class="data-input">&nbsp;
					<form:password path="newPasswordRep" value=""/>
				</div><div class="clearboth"></div>		
				<div class="button-cont">
					<a id="add-account-continue-button" class="button mrt-15" href="javascript:document.submitPassword.submit();" title="Submmit">
							<span>Submit</span>
					</a>
					<a id="add-account-cancel-button" class="button" href="staffchangepassword?profileid=<core:out value="${form.staffProfileId}"/>&tenantid=<core:out value="${form.tenantId}"/>" title="Cancel">
						<span>Cancel</span></a>
				</div>
				
	        	<form:hidden path="staffProfileId" value="${form.staffProfileId}"/>
				<form:hidden path="tenantId" value="${form.tenantId}"/>
				<div class="clearboth"></div>				
			</form:form>
			</div>

			</div>
	 </div>
</td>
</tr>
</table>
</body>
</html>