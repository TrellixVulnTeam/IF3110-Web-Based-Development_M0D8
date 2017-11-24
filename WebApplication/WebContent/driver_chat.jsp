<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="swtMessage">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Order</title>
	<link rel="icon" href="img/icon.png" />
	<link rel="stylesheet" href="css/style.css">
	
	<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.16/angular.min.js"></script><!-- load angular -->

	<script src="js/controllers/main.js"></script> <!-- load up our controller -->
	<script src="js/services/messages.js"></script> <!-- load our message service -->
	<script src="js/core.js"></script> <!-- load our main application -->
	
</head>
<body ng-controller="mainController">
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
		//if (userNavbar.isDriver()){  
		//	response.sendRedirect("Findorder.jsp?id_active=" + request.getParameter("id_active"));
		//}
	%>
    
    <div id="order-header">
	  <div class="floating-box-left-chat" >LOOKING FOR AN ORDER</div>
	</div>
	
	<div id="order-chat-driver">
	  <div class="chatbox">
		<div class="messagechat" ng-repeat="message in messages">
			<label> {{ message.text }} </label>
		</div>
		</div>
		<form class="inputform">
		<input type="text" class="inputbox" ng-model="formData.text ">
		<button type="submit" class="send" ng-click="createMessage()">Kirim</button>
		</form>	
	</div>
</body>
</html>