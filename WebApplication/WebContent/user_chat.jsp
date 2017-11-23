<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

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
	  <%@ include file="Navbar.jsp" %>
	  <div class="after-box">
	    <div class="centered">
	      <a href="Order.jsp?id_active=<%= request.getParameter("id_active") %>" class="active-order">ORDER</a>
	      <a href="Historyorder.jsp?id_active=<%= request.getParameter("id_active") %>" class="list-item-history">HISTORY</a>
	      <a href="Profile.jsp?id_active=<%= request.getParameter("id_active") %>" class="list-item-profile">MY PROFILE</a>
	    </div>
	  </div>
	</div>
	
	<%
		// TODO: check if still finding order, having order, etc
		if (userNavbar.isDriver()){  
			response.sendRedirect("Findorder.jsp?id_active=" + request.getParameter("id_active"));
		}
	%>
    
    <div id="order-header">
	  <div class="floating-box-left-mo">MAKE AN ORDER</div>
	    <ul class="list-centered">
	      <li class="order-active"><div class="circle">1</div>Select a Destination</li>
	      <li class="list-order"><div class="circle">2</div>Select a Driver</li>
	      <li class="list-order"><div class="circle">3</div>Chat Driver</li>
	      <li class="list-order"><div class="circle">4</div>Complete Your Order</li>
	    </ul>
	</div>
	
	<div id="order-chat">
	  <div class="chatbox">
		<div class="messagechat" ng-repeat="message in messages">
			<label> {{ message.text }} </label>
		</div>
		</div>
		<form class="inputform">
		<input type="text" class="inputbox" ng-model="formData.text ">
		<button type="submit" class="send" ng-click="createMessage()">Kirim</button>
		</form>	
		<input type="close-chat-button" class="close-chat-button" value="CLOSE" onclick="window.location.href='Completeorder.jsp?id_active=<%= request.getParameter("id_active") %>'">
	</div>
</body>
</html>