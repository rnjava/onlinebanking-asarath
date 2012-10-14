<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	String contextPath = request.getContextPath();
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/css/mouseovertabs.css" />

<script src="<%=contextPath%>/js/mouseovertabs.js" type="text/javascript">

/***********************************************
* Mouseover Tabs Menu- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
* This notice MUST stay intact for legal use
* Visit Dynamic Drive at http://www.dynamicdrive.com/ for this script and 100s more
***********************************************/

</script>
<title>Spring3Example</title>
</head>
<body>
<div id="mytabsmenu" class="tabsmenuclass">
<ul>
<li><a href="http://www.javascriptkit.com" rel="gotsubmenu[selected]">JavaScript Kit</a></li>
<li><a href="http://www.cssdrive.com" rel="gotsubmenu">CSS Drive</a></li>
<li><a href="http://www.codingforums.com">No Sub Menu</a></li>
</ul>
</div>

<div id="mysubmenuarea" class="tabsmenucontentclass">

<!--1st link within submenu container should point to the external submenu contents file-->
<a href="<%=contextPath%>/submenucontents.htm" style="visibility:hidden">Sub Menu contents</a>

</div>

<script type="text/javascript">
//mouseovertabsmenu.init("tabs_container_id", "submenu_container_id", "bool_hidecontentsmouseout")
mouseovertabsmenu.init("mytabsmenu", "mysubmenuarea", true)

</script>
<h3>Welcome <core:out value="${loginForm.userName}" /></h3>
<table>
	<tr>
		<td><a href="login.html">Back</a></td>
	</tr>
</table>
</body>
</html>