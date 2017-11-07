<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<jsp:useBean id="profileProxy" scope="request" class="com.services.UserServiceProxy" />
<%
profileProxy.setEndpoint("http://localhost:8000/WebService/User");
String idStr = request.getParameter("id_active");
int id = Integer.parseInt(idStr);
com.services.User user = profileProxy.getUser(id);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <link rel="icon" href="img/icon.png" />
  <title>Ojek Panas | Profile</title>
  <link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div id="navbar">
	  <%@include file="Navbar.jsp" %>
	  <div class="after-box">
	    <div class="centered">
	      <a href="Order.jsp?id_active=<%= request.getParameter("id_active") %>" class="list-item-order">ORDER </a>
	      <a href="Historyorder.jsp?id_active=<%= request.getParameter("id_active") %>" class="list-item-history">HISTORY </a>
	      <a href="Profile.jsp?id_active=<%= request.getParameter("id_active") %>" class="active-profile">MY PROFILE</a>
	    </div>
	  </div>
	</div>
	
	<div id="profile-header">
	  <div class="floating-box-left-p">
	    <span>MY PROFILE</span>
	  </div>
	  <div class="floating-box-right-p">
	    <a href="Editprofile.jsp?id_active=<%= request.getParameter("id_active") %>"><img src="img/pencil.png" width="30px" height="30px"></a>
	  </div>
	</div>
	
	<div id="profile-content">
	  <img class="picture" src="<%= user.getImagePath() %>"/>
      <p class="username">@<%= user.getUsername() %></p>
      <p class="data"><%= user.getName() %></p>
	
	  <% if (user.isDriver()) {%>
	  	<p class="data">Driver | <font color="orange">&#9734;<%= user.getStar() %></font> (<%= user.getVote() %>) </p>
	  <% } else {%>
	  	<p class="data">Non-Driver</p>
	  <% } %>
	
	  <p class="data">&#9993; <%= user.getEmail() %></p>
	  <p class="data">&#9743; <%= user.getPhoneNumber() %></p>
	</div>
	<%
		String print = "";
		if (user.isDriver()) { %>
			<div id="preferred-header">
				<div class="floating-box-left-1">
					<span>PREFERRED LOCATIONS:</span>
	<%  	for (int i = 0; i < user.getPreferredLocations().length; ++i) { %>
				<div id="triangle"><ul><li><%= user.getPreferredLocations(i).getLocation() %>	
	<%		}
			for (int i = 0; i < user.getPreferredLocations().length; ++i) { %>
				</li></ul></div>
	<% 		} %>
			</div>
			<div class="floating-box-right-p">
				<a href="Editlocation.jsp?id_active=<%= request.getParameter("id_active") %>">
				<img src="img/pencil.png" width="30px" height="30px" /> </a>
			</div>
			</div>
	<% 		 
		}%>
</body>
</html>