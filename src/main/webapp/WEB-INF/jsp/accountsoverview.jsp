<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-US" lang="en-US" class="chrome chrome-22 webkit">
	<head>
	<%
		String contextPath = request.getContextPath();
	%>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Bank of America | Online Banking | Accounts Overview</title>
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
						<img alt="Bank of America Logo"
							src="<%=contextPath%>/images/logo-hsbc.gif"
							title="Bank of America logo">
					</div>
					<div class="fl-rt no_print">
						<div class="common-margin">
							<div class="fl-lt">
								<img alt="Online Banking"
									src="<%=contextPath%>/images/onlineBanking_en.gif">
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
						href=""
						title="Transfers">Transfers</a></li>
					<li><a id="Customer_Service_topnav"
						name="Customer_Service_topnav" rel="nav-mod-content7 "
						href=""
						title="Customer Service">Customer Service</a></li>
				</ul>
			</div>


			<div class="sub-nav-box no_print">
				<div class="sub-nav" id="nav-mod-content1">

					<ul>
						<li><a id="Accounts_topnav" name="Accounts_topnav_borneo_AO"
							class="selected"
							href=""
							title="Accounts Overview">Accounts Overview</a></li>

						<li><a id="Account_Details_topnav"
							name="Account_Details_topnav"
							href=""
							title="Account Details">Account Details</a></li>

						<li><a
							href=""
							title="Statements &amp; Documents">Statements &amp; Documents</a></li>
						<li><a id="Alerts_topnav" name="Alerts_topnav"
							href=""
							title="Alerts">Alerts</a></li>
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
							<core:out value="${accountOverviewForm.profile.firstName}" />
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
								<div class="title-text">Accounts</div>
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

								<div class="account-row" rel="0" lang="en-us">
									<div class="left-column-content">
										<!--Printing Bankacclist size 6 -->
										<div class="fl-lt show-arrow">
											<a id="Show details for-0" name="Show details for-0"
												href="javascript:void(0);"
												title="Show details for MyAccess Checking - 7257 "
												class="show-details"> <span class="ada-hidden">Show
													details for MyAccess Checking - 7257</span></a>
										</div>
										<!--Printing Bankacclist size 6 -->
										<div class="fl-lt hide-arrow hide">
											<a id="Hide details for-0" name="Hide details for-0"
												href="javascript:void(0);"
												title="Hide details for MyAccess Checking - 7257 "
												class="hide-details"><span class="ada-hidden">Hide
													details for MyAccess Checking - 7257</span></a>
										</div>
										<div class="image-account ">
											<a id="MyAccess Checking - 7257"
												name="MyAccess Checking - 7257"
												href="">
												MyAccess Checking - 7257</a>
										</div>
										<div class="clearboth"></div>
									</div>
									<div class="right-column-content">$2,629.44</div>
									<div class="clearboth"></div>
									<div class="plt-23">
										<!-- eccAugustSwitch is true (Location 4) -->
										<a id="paperless-0" class="go-paperless" name="paperless-0"
											href="">Go
											Paperless<span class="ada-hidden">MyAccess Checking -
												7257</span>
										</a>
									</div>
									<!-- 941 before if -->
									<!--Printing Bankacclist size 6 -->
									<div class="hidden-account-details hide">
										<div class="top-gradient top-left"></div>
										<div class="top-gradient top-right"></div>
										<div class="hidden-content">
											<div class="fl-lt">
												<img
													src="<%=contextPath%>/images/GenericLogoMBNA.gif"
													alt="">
											</div>
											<div class="content-details">
												<!-- 979 div starts -->
												<div class="detail-subsection"></div>
												<div class="detail-subsection">

													<!-- keyValue4 is : acctDetails -->
													<div class="link-row ">
														<a id="View account details-0"
															name="View account details-0"
															href="">View
															account details<span class="raquo-link">»</span><span
															class="ada-hidden">MyAccess Checking - 7257</span>
														</a>
													</div>
													<!-- keyValue4 is : eCC -->
													<div class="link-row ">
														<a id="View Statements-0" name="View Statements-0"
															href="">View
															Statements<span class="raquo-link">»</span><span
															class="ada-hidden">MyAccess Checking - 7257</span>
														</a>
													</div>
													<div class="odp-view-link-row link-row " id="odpLink0">
														<a id="odpSummary-0" name="odpSummary-0"
															href="">View/Edit
															Overdraft Protection<span class="raquo-link">»</span><span
															class="ada-hidden">MyAccess Checking - 7257</span>
														</a>
													</div>
													<div class="odp-waiting" id="odpWaiting0">
														<img
															src="<%=contextPath%>/images/processing-no-text.gif"
															alt="processing overdraft protection information">
													</div>
													<div class="odp-info-row hide" id="primaryMessage0">
														<span class="bold"></span>
													</div>
													<div class="odp-link-row hide">
														<a></a>
													</div>
													<div class="odp-special-subsection ">
														<a id="custService-0" name="custService-0"
															href="">More
															Services<span class="raquo-link">»</span><span
															class="ada-hidden">MyAccess Checking - 7257</span>
														</a>
													</div>
												</div>
												<!-- 1170 div close-->
											</div>
											<div class="clearboth"></div>
										</div>
										<div class="corner bottom-left"></div>
										<div class="corner bottom-right"></div>
									</div>
									<!-- 1251 after if -->
								</div>
						<div class="account-row" rel="4" lang="en-us">
									<div class="left-column-content">
										<!--Printing Bankacclist size 6 -->
										<div class="fl-lt show-arrow">
											<a id="consumerCC_ajax_call-4" name="consumerCC_ajax_call-4"
												onclick="javascript:linkClickedAJAX(4,&#39;en_US&#39;);return false;"
												href="https://safe.bankofamerica.com/myaccounts/brain/DynamicAjax.go"
												title="Show details for Bank of America American Express Card - 4011 "
												class="show-details"> <span class="ada-hidden">Show
													details for Bank of America American Express Card - 4011</span></a>
										</div>
										<!--Printing Bankacclist size 6 -->
										<div class="fl-lt hide-arrow hide">
											<a id="Hide details for-4" name="Hide details for-4"
												href="javascript:void(0);"
												title="Hide details for Bank of America American Express Card - 4011 "
												class="hide-details"><span class="ada-hidden">Hide
													details for Bank of America American Express Card - 4011</span></a>
										</div>
										<div class="image-account ">
											<a id="Bank of America American Express Card - 4011"
												name="Bank of America American Express Card - 4011"
												href="">
												Bank of America American Express Card - 4011</a>
										</div>
										<div class="clearboth"></div>
									</div>
									<div class="right-column-content">$2,368.57</div>
									<div class="clearboth"></div>
									<!-- 941 before if -->
									<!--Printing Bankacclist size 6 -->
									<div class="hidden-account-details hide">
										<div class="top-gradient top-left"></div>
										<div class="top-gradient top-right"></div>
										<div class="hidden-content">
											<!-- testing - 6 -->
											<div class="fl-lt">
												<!-- testing - 7 -->
												<!-- testing - 8 -->
												<img
													src="<%=contextPath%>/images/c_cl_generic.gif"
													alt="">
											</div>
											<div class="content-details">
												<div class="info-row">
													<div class="fl-lt">Minimum payment: $15.00</div>
													<div class="fl-rt"></div>
													<div class="clearboth"></div>
												</div>
												<div class="info-row">
													<div class="fl-lt">Due on: 10/23/2012</div>
													<div class="fl-rt"></div>
													<div class="clearboth"></div>
												</div>
												<div class="link-row ">
													<a id="payNowCC-4" name="payNowCC-4"
														href="">Pay
														Now<span class="raquo-link">»</span><span
														class="ada-hidden">Bank of America American Express
															Card - 4011</span>
													</a>
												</div>

												<!-- keyValue4 is : acctDetailsCC -->
												<div class="link-row ">
													<a id="View account details-4"
														name="View account details-4"
														href="">View
														account details<span class="raquo-link">»</span><span
														class="ada-hidden">Bank of America American Express
															Card - 4011</span>
													</a>
												</div>
												<!-- keyValue4 is : eCC -->
												<div class="link-row ">
													<a id="View Statements-4" name="View Statements-4"
														href="">View
														Statements<span class="raquo-link">»</span><span
														class="ada-hidden">Bank of America American Express
															Card - 4011</span>
													</a>
												</div>
												<div class="odp-view-link-row link-row " id="odpLink4">
													<a id="odpSummary-4" name="odpSummary-4"
														href="">View/Edit
														Overdraft Protection<span class="raquo-link">»</span><span
														class="ada-hidden">Bank of America American Express
															Card - 4011</span>
													</a>
												</div>
												<div class="odp-waiting" id="odpWaiting4">
													<img
														src="<%=contextPath%>/images/processing-no-text.gif"
														alt="processing overdraft protection information">
												</div>
												<div class="odp-info-row hide" id="primaryMessage4">
													<span class="bold"></span>
												</div>
												<div class="odp-link-row hide">
													<a></a>
												</div>
												<div class="odp-special-subsection ">
													<a id="servicesCC-4" name="servicesCC-4"
														href="">More
														Services<span class="raquo-link">»</span><span
														class="ada-hidden">Bank of America American Express
															Card - 4011</span>
													</a>
												</div>
												<div class="special-subsection hide" id="piggyPop4">
													<div class="tra-bal-pig fl-lt">
														<img
															src="<%=contextPath%>/images/icon_ntrans_bt.gif"
															width="34" height="25" alt="Transfer Balance">
													</div>
													<div class="apr-content">
														<div class="before-expand hide" id="aprAlink4">
															<a name="learn_more"
																href=""
																title="Learn More"><span class="bold"><div
																		class="before-expand" id="aprA4"></div></span></a>
														</div>
														<div class="hide" id="aprAnolink4">
															<span class="bold" id="aprAA4"></span>&nbsp; <span
																id="aprB4"></span>
														</div>

														<div class="non-promo" id="nonpromoFee4"></div>

														<div class="apr hide" id="aprtab4">
															<table summary="Annual Percentage Rate" class="apr">
																<tbody>
																	<tr class="hidden">
																		<th>Promotional APR balance</th>
																		<th>Non-promotional variable APR</th>
																	</tr>
																	<tr>
																		<td class="border-right">
																			<div class="clearboth"></div>
																			<div class="bold-red-22" id="btRate4"></div> <!--  promotional APR balance transfer through -->
																			<div class="cca-desc" id="promo1Val4"></div>
																			<div class="cca-desc" id="promo2Val4"></div>
																			<div class="bold-red-12 mbtm-5" id="promo1ValB4"></div>
																			<div class="bold-red-12 mbtm-5" id="promo2ValB4"></div>

																		</td>
																		<td>
																			<!--    Non-promotional variable APR balance transfer thereafter: -->
																			<div class="cca-desc" id="nonpromo1Val4"></div>
																			<div class="cca-desc" id="nonpromo2Val4"></div>
																			<div class="bold-gray-20" id="nonpromo1ValB4"></div>
																			<div class="nonpromo2ValB" id="nonpromo2ValB4"></div>
																		</td>
																	</tr>

																</tbody>
															</table>
														</div>
														<div id="learn_more4">
															<a name="learn_more"
																href=""
																title="Learn more about this promotional offer on balance transfers">Learn
																more <img
																src="<%=contextPath%>/images/raquo.gif"
																alt="" width="10" height="8" class="raquo">
															</a>
														</div>

													</div>

													<div class="clearboth"></div>
												</div>
											</div>
											<div class="clearboth"></div>
										</div>
										<div class="corner bottom-left"></div>
										<div class="corner bottom-right"></div>
									</div>
									<!-- 1251 after if -->
								</div>
								<div class="account-row no-bottom-border" rel="5" lang="en-us">
									<div class="left-column-content">
										<!--Printing Bankacclist size 6 -->
										<div class="fl-lt show-arrow">
											<a id="consumerCC_ajax_call-5" name="consumerCC_ajax_call-5"
												onclick="javascript:linkClickedAJAX(5,&#39;en_US&#39;);return false;"
												href="https://safe.bankofamerica.com/myaccounts/brain/DynamicAjax.go"
												title="Show details for Bank of America Platinum Plus Visa - 0601 "
												class="show-details"> <span class="ada-hidden">Show
													details for Bank of America Platinum Plus Visa - 0601</span></a>
										</div>
										<!--Printing Bankacclist size 6 -->
										<div class="fl-lt hide-arrow hide">
											<a id="Hide details for-5" name="Hide details for-5"
												href="javascript:void(0);"
												title="Hide details for Bank of America Platinum Plus Visa - 0601 "
												class="hide-details"><span class="ada-hidden">Hide
													details for Bank of America Platinum Plus Visa - 0601</span></a>
										</div>
										<div class="image-account ">
											<a id="Bank of America Platinum Plus Visa - 0601"
												name="Bank of America Platinum Plus Visa - 0601"
												href="">
												Bank of America Platinum Plus Visa - 0601</a>
										</div>
										<div class="clearboth"></div>
									</div>
									<div class="right-column-content">$373.84</div>
									<div class="clearboth"></div>
									<!-- 941 before if -->
									<!--Printing Bankacclist size 6 -->
									<div class="hidden-account-details hide">
										<div class="top-gradient top-left"></div>
										<div class="top-gradient top-right"></div>
										<div class="hidden-content">
											<!-- testing - 6 -->
											<div class="fl-lt">
												<!-- testing - 7 -->
												<!-- testing - 8 -->
												<img
													src="<%=contextPath%>/images/c_cl_generic.gif"
													alt="">
											</div>
											<div class="content-details">
												<div class="info-row">
													<div class="fl-lt">Minimum payment: $0.00</div>
													<div class="fl-rt"></div>
													<div class="clearboth"></div>
												</div>
												<div class="info-row">
													<div class="fl-lt">Due on: 10/14/2012</div>
													<div class="fl-rt"></div>
													<div class="clearboth"></div>
												</div>
												<div class="link-row ">
													<a id="payNowCC-5" name="payNowCC-5"
														href="">Pay
														Now<span class="raquo-link">»</span><span
														class="ada-hidden">Bank of America Platinum Plus
															Visa - 0601</span>
													</a>
												</div>
												<div class="link-row ">
													<a id="View account details-5"
														name="View account details-5"
														href="">View
														account details<span class="raquo-link">»</span><span
														class="ada-hidden">Bank of America Platinum Plus
															Visa - 0601</span>
													</a>
												</div>
												<div class="link-row ">
													<a id="View Statements-5" name="View Statements-5"
														href="">View
														Statements<span class="raquo-link">»</span><span
														class="ada-hidden">Bank of America Platinum Plus
															Visa - 0601</span>
													</a>
												</div>
												<div class="link-row ">
													<a id="Create a ShopSafe account number-5"
														name="Create a ShopSafe account number-5"
														href=""
														target="_blank">Create a ShopSafe account number<span
														class="raquo-link">»</span><span class="ada-hidden">Bank
															of America Platinum Plus Visa - 0601</span></a>
												</div>
												<div class="odp-view-link-row link-row " id="odpLink5">
													<a id="odpSummary-5" name="odpSummary-5"
														href="">View/Edit
														Overdraft Protection<span class="raquo-link">»</span><span
														class="ada-hidden">Bank of America Platinum Plus
															Visa - 0601</span>
													</a>
												</div>
												<div class="odp-waiting" id="odpWaiting5">
													<img
														src="./Bank of America   Online Banking   Accounts Overview_files/processing-no-text.gif"
														alt="processing overdraft protection information">
												</div>
												<div class="odp-info-row hide" id="primaryMessage5">
													<span class="bold"></span>
												</div>
												<div class="odp-link-row hide">
													<a></a>
												</div>
												<div class="odp-special-subsection ">
													<a id="servicesCC-5" name="servicesCC-5"
														href="">More
														Services<span class="raquo-link">»</span><span
														class="ada-hidden">Bank of America Platinum Plus
															Visa - 0601</span>
													</a>
												</div>
												<div class="special-subsection hide" id="piggyPop5">
													<div class="tra-bal-pig fl-lt">
														<img
															src="./Bank of America   Online Banking   Accounts Overview_files/icon_ntrans_bt.gif"
															width="34" height="25" alt="Transfer Balance">
													</div>
													<div class="apr-content">
														<div class="before-expand hide" id="aprAlink5">
															<a name="learn_more"
																href=""
																title="Learn More"><span class="bold"><div
																		class="before-expand" id="aprA5"></div></span></a>
														</div>
														<div class="hide" id="aprAnolink5">
															<span class="bold" id="aprAA5"></span>&nbsp; <span
																id="aprB5"></span>
														</div>

														<div class="non-promo" id="nonpromoFee5"></div>

														<div class="apr hide" id="aprtab5">
															<table summary="Annual Percentage Rate" class="apr">
																<tbody>
																	<tr class="hidden">
																		<th>Promotional APR balance</th>
																		<th>Non-promotional variable APR</th>
																	</tr>
																	<tr>
																		<td class="border-right">
																			<div class="clearboth"></div>
																			<div class="bold-red-22" id="btRate5"></div> <!--  promotional APR balance transfer through -->
																			<div class="cca-desc" id="promo1Val5"></div>
																			<div class="cca-desc" id="promo2Val5"></div>
																			<div class="bold-red-12 mbtm-5" id="promo1ValB5"></div>
																			<div class="bold-red-12 mbtm-5" id="promo2ValB5"></div>

																		</td>
																		<td>
																			<!--    Non-promotional variable APR balance transfer thereafter: -->
																			<div class="cca-desc" id="nonpromo1Val5"></div>
																			<div class="cca-desc" id="nonpromo2Val5"></div>
																			<div class="bold-gray-20" id="nonpromo1ValB5"></div>
																			<div class="nonpromo2ValB" id="nonpromo2ValB5"></div>
																		</td>
																	</tr>

																</tbody>
															</table>
														</div>
														<div id="learn_more5">
															<a name="learn_more"
																href=""
																title="Learn more about this promotional offer on balance transfers">Learn
																more <img
																src="./Bank of America   Online Banking   Accounts Overview_files/raquo.gif"
																alt="" width="10" height="8" class="raquo">
															</a>
														</div>

													</div>

													<div class="clearboth"></div>
												</div>
											</div>
											<div class="clearboth"></div>
										</div>
										<div class="corner bottom-left"></div>
										<div class="corner bottom-right"></div>
									</div>
									<!-- 1251 after if -->
								</div>


							<div class="db-inner-corners tb-bottom-left"></div>
							<div class="db-inner-corners tb-bottom-right"></div>
						</div>
						<div class="db-outer-corners tb-bottom-left"></div>
						<div class="db-outer-corners tb-bottom-right"></div>
					</div>
				</div>
			</div>
</td>
</tr>
</table>
</body>
</html>