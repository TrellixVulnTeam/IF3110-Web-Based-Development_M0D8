<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
    String mytoken = "";
    Cookie[] mycookies = request.getCookies();
    if (mycookies != null) {
        for (int i = 0; i < mycookies.length; ++i) {
        	if (mycookies[i].getName().equals("token")) {
        		mytoken = mycookies[i].getValue();
        			break;
        	}
        }
    }
%>

<jsp:useBean id="historyDriverProxy" scope="request" class="com.services.HistoryServiceProxy" />
<jsp:useBean id="historyDriverProxyUser" scope="request" class="com.services.UserServiceProxy" />
<%
	historyDriverProxy.setEndpoint("http://localhost:8000/WebService/History");
	historyDriverProxyUser.setEndpoint("http://localhost:8000/WebService/User");
	String idStr = request.getParameter("id_active");
	int id = Integer.parseInt(idStr);
	
	com.services.History[] hist = null;
	try{
		hist = historyDriverProxy.getHistoryAsDriver(mytoken, id);		
	} catch (com.services.TokenException tex) {
		response.sendRedirect("LogoutServlet");
	}
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
                <a href="Order.jsp?id_active=<%= request.getParameter("id_active") %>" class="list-item-order">ORDER</a>
                <a href="Historyorder.jsp?id_active=<%= request.getParameter("id_active") %>" class="active-history">HISTORY</a>
                <a href="Profile.jsp?id_active=<%= request.getParameter("id_active") %>" class="list-item-profile">MY PROFILE</a>
            </div>
        </div>
    </div>
    <div class="floating-box-left-mo2">TRANSACTIONS HISTORY</div>
    <div id="mini-navbar">
        <table>
            <tr>
                <td class="mini-navbar" onclick="location.href='Historyorder.jsp?id_active=<%= request.getParameter("id_active") %>'">
                    <a href="Historyorder.jsp?id_active=<%= request.getParameter("id_active") %>">MY PREVIOUS ORDERS</a>
                </td>
                <td class="selected-navbar" onclick="location.href='Historydriver.jsp?id_active=<%= request.getParameter("id_active") %>'">
                    <a href="Historydriver.jsp?id_active=<%= request.getParameter("id_active") %>">DRIVER HISTORY</a>
                </td>
            </tr>
        </table>
    </div>
    <div class="empty-space"></div>
    
    <% if (hist != null && hist.length > 0) {
    		for (int i = 0; i < hist.length; ++i) {
    			int idc = hist[i].getIdCustomer();
    			
    			com.services.User cust;	
    			try{
    				cust = historyDriverProxyUser.getUser(mytoken, idc);	
    			} catch (com.services.TokenException tex) {
    				response.sendRedirect("LogoutServlet");
    			}
    			
    			int idd = hist[i].getIdDriver();
    			int ido = hist[i].getId(); %>
    			<div class="history-list-item">
    				<table width="670px">
    					<tr>
    						<td rowspan="6" width="28"><img class="square-image" src="<%= cust.getImagePath() %>" alt="User Profile Picture"></td>
    						<td rowspan="6" class="horizontal-space" width="10px"></td>
    						<td colspan="2" class="history-date"><%= hist[i].getDate().toString() %></td>
    						<td width="100" rowspan="2"><div class="hide-button"><a href="Hidedriver?id_active=<%= id %>&id_order=<%= ido %>" id="<%= ido %>" onclick="hidebutton(this.id)">HIDE</a></div></td>
    					</tr>
    					<tr>
    						<td colspan="2" class="history-driver-name"><%= cust.getName() %></td>
    					</tr>
    					<tr>
    						<td colspan="2" class="history-route"><%= hist[i].getPickUp() %> - <%= hist[i].getDestination() %></td>
    					</tr>
    					<tr>
    						<td colspan="2" class="history-rating">gave <font color="orange"><%= hist[i].getRating() %></font> stars for this order</td>
    					</tr>
    					<tr>
    						<td colspan="2"> and left comment:</td>
    					</tr>
    					<tr>
    						<td class="horizontal-space-small"></td>
    						<td colspan="2"><%= hist[i].getFeedback() %></td>
    					</tr>
    					<tr><td class="vertical-space"></td></tr>
    				</table>
    			</div>
    <%		}
    } else { %> 
    	<div class="nothing">Nothing to display &#128514;</div>;
    <% } %>
</body>
</html>