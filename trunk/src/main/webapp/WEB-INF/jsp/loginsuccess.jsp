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
<title>Online Banking - TODO</title>
</head>
<body style="display: block;">
 <table width="100%"  border="0">
   
<tr>
      <td height="28" align="center">
        <table width="75%" height="220"  border="0" align="center">
          <tr>
            <td height="20%" >  
              <table width="100%" align="center" class="tableColorLigthGrey"  >
                <tr>
                  <td colspan="6" class="tableHeader" scope="col"><div align="center">Account Details</div></td>
                </tr>
                <tr>
                  <td width="18%" class="clsLabelRightAlign" scope="col"></td>
                  <td width="32%" class="tableLeftAlign"><div align="left"><span class="">
                  <span class=""></span> </span></div></td>
                  <td width="16%" class="clsLabelRightAlign"></td>
                  <td width="34%" class="textAndale"><div align="left"></div>
                  </td>
                </tr>
                <tr>
                  <td class="clsLabelRightAlign" scope="col"></td>
                  <td class="tableLeftAlign"></td>
                  <td class="clsLabelRightAlign"></td>
                  <td class="textAndale"><div align="left"></div></td>
                </tr>
                <tr>
                  <td class="clsLabelRightAlign" scope="col"></td>
                  <td class="tableLeftAlign"></td>
                  <td class="clsLabelRightAlign"></td>
                  <td class="textAndale"><div align="left"></div></td>
                </tr>
                <tr>
                  <td class="clsLabelRightAlign" scope="col"></td>
                  <td class="tableLeftAlign"></td>
                  <td class="clsLabelRightAlign">&nbsp;</td>
                  <td class="textAndale">&nbsp;</td>
                </tr>
			  </table>
			</td>
          </tr>
          <tr>
            <td height="83">              
            <div align="center">
                <table width="100%"  border="0" cellpadding="0" cellspacing="1" class="tableColorLigthGrey"  widtd="100%">
                  <tr class="tableHeader" >
                    <td colspan="13" bordercolor="#996633"  scope="col">
                    	<div align="center">
							<div id="mytabsmenu" class="tabsmenuclass">
									<ul>
										<li><a href="http://www.javascriptkit.com" rel="gotsubmenu[selected]">Account</a></li>
										<li><a href="http://www.cssdrive.com" rel="gotsubmenu">Transfer</a></li>
										<li><a href="http://www.codingforums.com">Customer Support</a></li>
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
                    	</div>
                    </td>
                  </tr>
                  <tr class="clsRptLabel">
                    <td width="11%" bordercolor="#996633"  scope="col"><div align="center"></div></td>
                    <td width="14%" height="17" bordercolor="#996633"  scope="col"></div></td>
                    <td width="14%" bordercolor="#996633"  scope="col"><div align="center"></div></td>
                    <td width="7%" bordercolor="#996633"  scope="col"><div align="center"></div></td>
                    
                    <td width="8%" bordercolor="#996633"  scope="col"><div align="center"></div></td>
                    <td width="8%" bordercolor="#996633"  scope="col"><div align="center"></div></td>
                    <td width="12%" bordercolor="#996633"  scope="col"><div align="center"></div></td>
                    <td width="14%" bordercolor="#996633"  scope="col"><div align="center"></div></td>
                    </tr>
                  </tr>
                </table>
				<p class="clsLabel"><span ><span class="style6"></span></span></p>
              </div>
            </td>
          </tr>
        </table></td>
    </tr>
  </table>
</body>
</html>