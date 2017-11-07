<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<jsp:useBean id="historyOrderProxy" scope="request" class="com.services.HistoryServiceProxy" />
<jsp:useBean id="historyOrderProxyUser" scope="request" class="com.services.UserServiceProxy" />
<%
	historyOrderProxy.setEndpoint("http://localhost:8000/WebService/History");
	historyOrderProxyUser.setEndpoint("http://localhost:8000/WebService/User");
	String idStr = request.getParameter("id_active");
	int id = Integer.parseInt(idStr);
	com.services.History[] hist = historyOrderProxy.getHistoryAsCustomer(id);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="icon" href="img/icon.png" />
	<title>Ojek Panas | History</title>
	<link rel="stylesheet" type="text/css" href="./css/style.css">
  	<script src="js/hide.js"></script>
</head>
<body>
	<div id="navbar">
    	<%@include file="Navbar.jsp" %>
    	<div class="after-box">
      		<div class="centered">
				<a href="Order.jsp?id_active=<%= request.getParameter("id_active") %>" class="active-order">ORDER</a>
	      		<a href="Historyorder.jsp?id_active=<%= request.getParameter("id_active") %>" class="list-item-history">HISTORY</a>
	      		<a href="Profile.jsp?id_active=<%= request.getParameter("id_active") %>" class="list-item-profile">MY PROFILE</a>
    		</div>
    	</div>
  	</div>
    <div class="floating-box-left-mo2">TRANSACTIONS HISTORY</div>
    
    <div id="mini-navbar">
	   	<table>
	   		<tr>
				<td class="selected-navbar" onclick="location.href='Historyorder.jsp?id_active=<%= request.getParameter("id_active") %>'">
					<a href="Historyorder.jsp?id_active=<%= request.getParameter("id_active") %>">MY PREVIOUS ORDERS</a>
				</td>
	   			<td class="mini-navbar" onclick="location.href='Historydriver.jsp?id_active=<%= request.getParameter("id_active") %>'">
	   				<a href="Historydriver.jsp?id_active=<%= request.getParameter("id_active") %>">DRIVER HISTORY</a>
	   			</td>
	   		</tr>
	   	</table>
    </div>
    <div class="empty-space"></div>
    
    <% if (hist != null && hist.length > 0) {
    		for (int i = 0; i < hist.length; ++i) {
    			if (!hist[i].isHiddenCust()) {
    			int idd = hist[i].getIdDriver();
    			com.services.User cust = historyOrderProxyUser.getUser(idd);
    			int idc = hist[i].getIdCustomer();
    			int ido = hist[i].getId(); %>
    			<div class="history-list-item">
    				<table width="670px" id="tabel<%= ido %>">
    					<tr>
    						<td rowspan="6" width="28"><img class="square-image" src="<%= cust.getImagePath() %>" alt="Driver Profile Picture"></td>
    						<td rowspan="6" class="horizontal-space" width="10px"></td>
    						<td colspan="2" class="history-date"><%= hist[i].getDate().toString() %></td>
    						<td width="100" rowspan="2"><div class="hide-button"><a href="Hideorder?id_active=<%= id %>&id_order=<%= ido %>" id="<%= ido %>" onclick="hidebutton(this.id)">HIDE</a></div></td>
    					</tr>
    					<tr>
    						<td colspan="2" class="history-driver-name"><%= cust.getName() %></td>
    					</tr>
    					<tr>
    						<td colspan="2" class="history-route"><%= hist[i].getPickUp() %> - <%= hist[i].getDestination() %></td>
    					</tr>
    					<tr>
    						<td colspan="2" class="history-rating">You rated <font color="orange">
    							<% for (int j = 0; j < hist[i].getRating(); ++j) { %>
    									&#9734;
    							<%	} %>
    						</font></td>
    					</tr>
    					<tr>
    						<td colspan="2">You commented:</td>
    					</tr>
    					<tr>
    						<td class="horizontal-space-small"></td>
    						<td colspan="2"><%= hist[i].getFeedback() %></td>
    					</tr>
    					<tr><td class="vertical-space"></td></tr>
    				</table>
    			</div>
    <%		}}
    } else { %> 
    	<div class="nothing">Nothing to display &#128514;</div>;
    <% } %>
    
</body>
</html>