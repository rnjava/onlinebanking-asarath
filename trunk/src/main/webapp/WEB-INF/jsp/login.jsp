<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>Online Banking | Customer Login</title>
<%
	String contextPath = request.getContextPath();
%>
<link href="<%=contextPath%>/css/style.css" rel="stylesheet" type="text/css">
<link href="<%=contextPath%>/css/nokia.css" rel="stylesheet" type="text/css">
</head>
<body>
<form:form method="post" action="login" commandName="loginForm">
  <table width="100%"  border="0">
    <tr>
      <td height="28">
        <table width="100%"  border="0" align="center">

          <tr>
            <th width="22%" scope="col"><img src="<%=contextPath%>/images/${loginForm.tenantId}.gif" width="178" height="31"></th>
            <th width="78%" align="left" scope="col"><table width="100%"  border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <th width="27%" scope="col"><div align="left" class="clsLabel"></div></th>
                  <th width="44%" rowspan="2" scope="col">&nbsp;</th>
                  <th width="29%" scope="col"><div align="right" class="style2 style4 style5"></div></th>
                </tr>
                <tr>
                  <td class="clsLabelRed"></td>
                  <td><div align="right" class="style4 style2 style5"><strong></strong></div></td>
                </tr>
            </table></th>
          </tr>
          <form:hidden path="tenantId" value="${loginForm.tenantId}"/>
          <tr>
            <th ></th>
          </tr>
        </table>       <hr class="horizantalline">
      </td>
    </tr>
    <tr>
      <td height="20%" >
          <table width="50%" class="tableColorLigthGrey" align ="center" >
            <tr class="tableHeader">
              <td colspan="4"  scope="col"><strong>Please Login here</strong></td>
            </tr>

			<tr>
			<td colspan="4" class="clsError" scope="col"> 
		      	  <form:errors path="*" cssClass="error" />
			</td>
			</tr>

            <tr>
              <td width="45%" class="clsLabel"  scope="col"> <div align="right">User ID</div></td>
              <td width="55%" class="tableLeftAlign" ><span class="contentverylightbrown">
			   <form:input path="userName" cssStyle="clsTextMandatory" />
              </span> </td>
            </tr>

			<tr>
              <td width="45%" class="clsLabel"  scope="col"> <div align="right">Password</div></td>
              <td width="55%" class="tableLeftAlign" ><span class="contentverylightbrown">
                 <form:password path="password" cssStyle="clsTextMandatory" />
              	</span>
            </tr>
            <tr>
              <td align="center" colspan="4"  scope="col">
              <p align="center"><input type="submit" value="Login" class="button"/></p>
              </td>
            </tr>
	 </table>
		</td>
    </tr>
  </table>
</form:form>
</body>
</html>
