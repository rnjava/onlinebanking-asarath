<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
	<title>Online Banking</title>
</head>
<body>
<h2>Contact Manager</h2>
<form:form method="post" action="addContact">

	<table>
	<tr>
		<td><form:label path="userName">UserName</form:label></td>
		<td><form:input path="userName" /></td> 
	</tr>
	<tr>
		<td><form:label path="password">Password</form:label></td>
		<td><form:password path="password" /></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="Login"/>
		</td>
	</tr>
</table>	
	
</form:form>
</body>
</html>
