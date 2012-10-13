<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<link rel= "stylesheet" type="text/css" href="onlinebanking/css/nokia.css> 
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>TODO</title>
</head>
<body>
<form:form method="post" action="submitLogin">
<table align="center" width="100%" border="0" cellpadding="0" cellspacing="0"> <!-- Top most table -->
	<tr>
		<td valign="middle" align="center">
			<table align="center" width="715" border="0" cellpadding="0" cellspacing="0"> <!-- Top most table -->
				<tr>
					<td colspan="4" height="45"></td>
				</tr>
				<tr>
					<td align="left" valign="top"><img src=/onlinebanking/images/top_left.gif></td>
					<td align="left"><img src=/onlinebanking/images/top_grey.gif></td>
					<td background=/onlinebanking/images/top_grey_tile.gif></td>
					<td background=/onlinebanking/images/top_grey_tile.gif align="right"><img src=/onlinebanking/images/top_right.gif></td>

				</tr>
				<tr>
					<td background=/onlinebanking/images/white_left.gif align="right"></td>
					<td align="left"><img src=/onlinebanking/images/nokia_logo.gif></td>
					<td></td>
					<td align="right"><img src=/onlinebanking/images/image_1.gif></td>

				</tr>
				<tr>
					<td align="left"><img src=/onlinebanking/images/middle_grey.gif></td>
					<td background=/onlinebanking/images/grey_white.gif></td>
					<td bgcolor="#E7E9EA"></td>
					<td align="right"><img src=/onlinebanking/images/image_2.gif></td>
				</tr>
				<tr>
					<td background=/onlinebanking/images/left_tile.gif></td>
					<td background=/onlinebanking/images/login_box.gif align="left" valign="top" rowspan="2">
					<!-- Login Table Will Come Here -->
					
					<table width="100%"  border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td colspan="2" height="25"></td>
                      </tr>
					  <tr>
                        <td align="center" class="white" colspan="2">
                        Enter Username</td>

                      </tr>
					   <tr>
                        <td colspan="2" height="15"></td>
                      </tr>
					  <tr>
                        <td class="white" align="right">
                        UserName&nbsp;</td>
                        <td>
                        
                        <form:input path="userName"/>
                         </td>
                      </tr>
					  <tr>
                        <td colspan="2" height="10"></td>
                      </tr>
					  <tr>
                        <td class="white" align="right">Password&nbsp;</td>
                        <td>
                        <form:password path="password"/>
                        </td>
                      </tr>
					  <tr>
                        <td colspan="2" height="35" valign="bottom" align="right">
                        <input type="submit" value="Login" class="button"/>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                   	 </tr>
					  <tr>
                        <td></td>
                        <td></td>
                      </tr>
                    </table>
					
					</td>
					<td align="left" valign="top" bgcolor="#E7E9EA"><img src=/onlinebanking/images/channel_title.gif></td>
					<td align="right"><img src=/onlinebanking/images/image_3.gif></td>
				</tr>
				<tr>
					<td align="left"><img src=/onlinebanking/images/bottom_left.gif></td>
					<td bgcolor="#5678DD"></td>
					<td bgcolor="#5678DD"></td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td height="50" valign="bottom">
		<!-- Footer -->
			<table border="0" cellspacing="0" cellpadding="0" align="center">
	 			 <tr>
	 			 <td align="center" >
    				<!-- td align="center" >
    				</td-->
 		 		</tr>
			</table>
			<table border="0" cellspacing="0" cellpadding="0" align="center">
				<tr>
    				<td class="text" align="center"></td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</body>
</form:form>
</html>
