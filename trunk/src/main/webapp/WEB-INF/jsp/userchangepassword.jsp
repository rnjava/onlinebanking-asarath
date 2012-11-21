<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-US" lang="en-US" class="chrome chrome-22 webkit">
	<head>
	<%
		String contextPath = request.getContextPath();
	%>
		<title>Online Banking | Customer Service | Change Password</title>
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
						<img alt="Logo"
							src="<%=contextPath%>/logos/${form.tenantId}.gif"
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


			<div id="nav-tier-2-module" class="nav-tier-2-module no_print">
				<ul class="nav2">
					<li><a id="Accounts_topnav" name="Accounts_topnav"
						class="modal-link" rel="nav-mod-content1"
						href="accountsoverview?profileid=<core:out value="${form.staffProfileId}"/>&tenantid=<core:out value="${form.tenantId}"/>"
						title="Accounts">Accounts</a></li>
					<li><a id="Transfers_topnav" name="Transfers_topnav"
						rel="nav-mod-content3"
						href="maketransfer?profileid=<core:out value="${form.staffProfileId}"/>&tenantid=<core:out value="${form.tenantId}"/>"
						title="Transfers">Transfers</a></li>
					<li><a id="Transfers_topnav" name="Transfers_topnav"
						class="selected"
						rel="nav-mod-content3"
						href="userchangepassword?profileid=<core:out value="${form.staffProfileId}"/>&tenantid=<core:out value="${form.tenantId}"/>"
						title="Create New Accounts">Customer Service</a></li>
				</ul>
			</div>


			<div class="sub-nav-box no_print">
				<div class="sub-nav" id="nav-mod-content1">

					<ul>
						<li><a class="selected"
							href="userchangepassword?profileid=<core:out value="${form.staffProfileId}"/>&tenantid=<core:out value="${form.tenantId}"/>"
							title="Accounts Overview">Change Password</a></li>
					</ul>
				</div>
			</div>			</div>
			<div class="clearboth"></div>

		<div class="db-inner-module">						
			<form:form method="post" action="userchangepasswordsubmit" commandName="form"  onsubmit="return true;" name="submitPassword">
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
					<a id="add-account-cancel-button" class="button" href="userchangepassword?profileid=<core:out value="${form.staffProfileId}"/>&tenantid=<core:out value="${form.tenantId}"/>" title="Cancel">
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