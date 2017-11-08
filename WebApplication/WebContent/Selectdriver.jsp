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

<jsp:useBean id="selectDriverProxy" scope="request" class="com.services.UserServiceProxy" />
<% 
	selectDriverProxy.setEndpoint("http://localhost:8000/WebService/User");
	String pickup = "";
	String dest = "";
	String pref = "";
	String redirect = "";
	com.services.User driver = null;
	com.services.User[] others = null;
	if (request.getMethod().equals("POST")) {
		pickup = request.getParameter("pickup");
		dest = request.getParameter("dest");
		pref = "";
		try{
			if (request.getParameter("pref") != null) {
				pref = request.getParameter("pref");
				driver = selectDriverProxy.getPreferredDriver(mytoken, pref, pickup, dest);
			}
			others = selectDriverProxy.getDriver(mytoken, pickup, dest);
		} catch (com.services.TokenException tex) {
			redirect = "LogoutServlet";
		}
		
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Order</title>
	<link rel="icon" href="img/icon.png" />
	<link rel="stylesheet" href="css/style.css">
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
	
	<div id="order-header">
	  <div class="floating-box-left-mo">MAKE AN ORDER</div>
	    <ul class="list-centered">
	      <li class="list-order"><div class="circle">1</div>Select Destination</li>
	      <li class="order-active"><div class="circle">2</div>Select a Driver</li>
	      <li class="list-order"><div class="circle">3</div>Complete Your Order</li>
	    </ul>
	</div>
	
	<div id="order-page">
  <!-- PREFERRED DRIVERS -->
  <div class="preferred-driver">
    <p class="header-pref">PREFERRED DRIVERS:</p>

      <% if (driver == null || driver.getId() == 0 || !driver.isDriver()) { %>
      	<div class="nothing-driver">Nothing to display &#128514;</div>
      <% } else { %>
      	<form action="Completeorder.jsp?id_active=<%= request.getParameter("id_active") %>" method="POST">
      	<table>
          <tr>
            <td rowspan="3"><img src="<%= driver.getImagePath() %>" class="square-image"></td>
            <td class="horizontal-space"></td>
            <td class="horizontal-space"></td>
            <td class="data-name"><%= driver.getName() %></td>
          </tr>
          <tr>
            <td class="horizontal-space"></td>
            <td class="horizontal-space"></td>
            <td class="data-rating"><font color="orange">&#9734; <%= driver.getStar() %></font> (<%= driver.getVote() %> votes)</td>
          </tr>
          <tr>
            <td class="horizontal-space"></td>
            <td class="horizontal-space"></td>

            <input type="hidden" name="id_driver" value="<%= driver.getId() %>">
            <input type="hidden" name="pickup" value="<%= pickup %>">
            <input type="hidden" name="dest" value="<%= dest %>">

            <td>
              <br>
              <button class="button-choose">I CHOOSE YOU!</button>
            </td>
          </tr>
          </table>
        </form>
      <% } %>

        </div>
  <br><br>
  <!-- OTHER DRIVERS -->
  <div class="preferred-driver">
    <p class="header-pref">OTHER DRIVERS:</p>    

	<% if (others == null || others.length == 0) { %>
      	<div class="nothing-driver">Nothing to display &#128514;</div>
      <% } else { %>
      	<% for (int i = 0; i < others.length; ++i) { %>
      	<%
      		com.services.User drivers = others[i];
      	%>
      	<form action="Completeorder.jsp?id_active=<%= request.getParameter("id_active") %>" method="POST">
      	<table>
          <tr>
            <td rowspan="3"><img src="<%= drivers.getImagePath() %>" class="square-image"></td>
            <td class="horizontal-space"></td>
            <td class="horizontal-space"></td>
            <td class="data-name"><%= drivers.getName() %></td>
          </tr>
          <tr>
            <td class="horizontal-space"></td>
            <td class="horizontal-space"></td>
            <td class="data-rating"><font color="orange">&#9734; <%= drivers.getStar() %></font> (<%= drivers.getVote() %> votes)</td>
          </tr>
          <tr>
            <td class="horizontal-space"></td>
            <td class="horizontal-space"></td>

            <input type="hidden" name="id_driver" value="<%= drivers.getId() %>">
            <input type="hidden" name="pickup" value="<%= pickup %>">
            <input type="hidden" name="dest" value="<%= dest %>">

            <td>
              <br>
              <button class="button-choose">I CHOOSE YOU!</button>
            </td>
          </tr>
          </table>
        </form>
      <% }} %>
  </div>
</div>

</body>
</html>

<%
	if (redirect != "") {
		response.sendRedirect(redirect);
	}
%>