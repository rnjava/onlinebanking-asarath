<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-US" lang="en-US" class="chrome chrome-22 webkit">
	<head>
	<%
		String contextPath = request.getContextPath();
	%>
		<title>Online Banking | Tenant Administration | Search Tenant</title>
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
	<script>
		function clearSearchText() 
		{
			document.getElementById('searchText').value="";
		}
	</script>				

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
									href="adminlogin" title="Sign Off">Sign Off</a>
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
						href="adminloginsuccess?profileid=<core:out value="${form.staffProfileId}"/>&tenantid=<core:out value="${form.tenantId}"/>"
						title="Customer Transaction">Tenant Administration</a></li>
					<!-- <li><a id="Transfers_topnav" name="Transfers_topnav"
						rel="nav-mod-content3"
						href="createuser?profileid=<core:out value="${form.staffProfileId}"/>&tenantid=<core:out value="${form.tenantId}"/>"
						title="Create New Accounts">User Management</a></li> -->
				</ul>
			</div>


			<div class="sub-nav-box no_print">
				<div class="sub-nav" id="nav-mod-content1">

					<ul>
						<li><a id="Accounts_topnav" name="Accounts_topnav_borneo_AO"
							href="adminloginsuccess?profileid=<core:out value="${form.staffProfileId}"/>&tenantid=<core:out value="${form.tenantId}"/>"
							title="Add New Tenant">Add New Tenant</a></li>
							<li><a id="Accounts_topnav" name="Accounts_topnav_borneo_AO"
							class="selected"
							href="searchtenant?profileid=<core:out value="${form.staffProfileId}"/>&tenantid=<core:out value="${form.tenantId}"/>"
							title="Search Tenant">Search Tenant</a></li>	
							<li><a id="Accounts_topnav" name="Accounts_topnav_borneo_AO"
							href="createuser?profileid=<core:out value="${form.staffProfileId}"/>&tenantid=<core:out value="${form.tenantId}"/>"
							title="Create Tenant User">Create Tenant User</a></li>															
													
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
								<span class="title-text">Search Tenant</span>
							</h2>
						</div>
			<div class="db-inner-module">	
		<form:form method="post" action="findtenantsubmit" commandName="form"  onsubmit="return true;" name="findtenant">					
	        <table>
		     	 <tr>
	             	<td colspan="4" align="center">
    						<div class="clsError"><form:errors path="*" cssClass="error" /></div>
						<core:if test="${not empty successMessage}">
    						<div class="clsSuccess" >${successMessage}</div>
						</core:if>
	             	</td>
	            </tr>
		        <tr>
		        	<td><label id="trans-mode-label" for="trans-mode-label"><strong>&nbsp;&nbsp; Search By : </strong></label></td>
		        		<td><form:radiobutton path="searchType" value="I" onclick="javascript:clearSearchText();"/> Tenant ID</td>
		        	<td><form:radiobutton path="searchType" value="N" onclick="javascript:clearSearchText();"/> TenantName</td>
		        	<td>Value : <form:input path="searchText" maxlength="100"/></td>
		        </tr>
		        <tr>	
		        	<td colspan="4" align="center">
		        		<a class="button" href="javascript:document.findtenant.submit();" title="Find Tenant">
							<span>Submit</span></a>
						<a class="button" 
							href="searchtenant?profileid=<core:out value="${form.staffProfileId}"/>&tenantid=<core:out value="${form.tenantId}"/>" 
							title="Cancel"><span>Cancel</span></a>
					</td>
		        	<form:hidden path="staffProfileId" value="${form.staffProfileId}"/>
					<form:hidden path="tenantId" value="${form.tenantId}"/>
		        </tr>
	        </table>
	       </form:form>
			<div class="clearboth"></div> <br/>	
	<core:if test="${not empty tenantList}">			
      	<table class="transaction-records">
			<thead>
				<tr>
					<th class="date" scope="col" style="width: 106px; "><strong>Tenant ID</strong></th>					
					<th class="desc" scope="col" style="width: 292px; "><strong>Tenant Name</strong></th>
					<th class="type" scope="col" style="width: 50px; "><strong>Primary Contact</strong></th>
					<th class="status" scope="col" style="width: 61px; "><strong>Phone No</strong></th>
					<th class="amount" scope="col" style="width: 99px; "><strong>Email</strong></th>
					<th class="balance" scope="col" style="width: 113px; "><strong>Address</strong></th>
				</tr>
			</thead>
			<tbody>
			
			 <core:forEach items="${tenantList}" var="tenantobj">
				<tr class="record transType-transfer cleared">
					<td class="date-action" rel="49">
						<span><core:out value="${tenantobj.tenantId}" /></span>
					</td>
					<td class="description TL_NPI_TransDesc" rel="12">
					<span class=><core:out value="${tenantobj.tenantName}" /></span> 
					</td>
					<td class="type">
						<span><core:out value="${tenantobj.primaryContact}" /></span>
					</td>
					<td class="status"><span><core:out value="${tenantobj.phoneNo}" /></span></td>
					<td class="amount TL_NPI_Amt isDebit"><core:out value="${tenantobj.emailAddress}" /></td>
					<td class="balance TL_NPI_Amt"><core:out value="${tenantobj.address}" /></td>
				</tr>
				<div class="clearboth"></div>
				</core:forEach>
			
				</tbody>
		</table>
		</core:if>	        

	   		</div>			
				<div class="clearboth"></div>				
			</div>
	 </div>
</td>
</tr>
</table>
</body>
</html>