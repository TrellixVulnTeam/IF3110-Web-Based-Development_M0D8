<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<jsp:useBean id="sampleUserServiceProxyid" scope="session" class="com.services.UserServiceProxy" />
<%
sampleUserServiceProxyid.setEndpoint("http://localhost:8003/WebService/User");
String idStr = request.getParameter("id_active");
int id = Integer.parseInt(idStr);
com.services.User user = sampleUserServiceProxyid.getUser(id);
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
	
	  <% if (true) {%>
	  	<p class="data">Driver | <font color="orange">&#9734;<%= user.getStar() %></font> (<%= user.getVote() %>) </p>
	  <% } else {%>
	  	<p class="data">Non-Driver</p>
	  <% } %>
	
	  <p class="data">&#9993; <%= user.getEmail() %></p>
	  <p class="data">&#9743; <%= user.getPhoneNumber() %></p>
	</div>
</body>
</html>