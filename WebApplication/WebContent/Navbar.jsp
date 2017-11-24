<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="navbarProxy" scope="request" class="com.services.UserServiceProxy" />

<%
    String token = "";
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (int i = 0; i < cookies.length; ++i) {
        	if (cookies[i].getName().equals("token")) {
        		token = cookies[i].getValue();
        			break;
        	}
        }
    }
%>
        	
<%
	navbarProxy.setEndpoint("http://localhost:8000/WebService/User");
	com.services.User userNavbar = null;
	String redirectNavbar = "";
	try{
		userNavbar = navbarProxy.getUser(token, Integer.parseInt(request.getParameter("id_active")));		
	} catch (com.services.TokenException tex) {
		redirectNavbar = "LogoutServlet";
		userNavbar = new com.services.User();
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="icon" href="img/icon.png" />
    <title>Ojek Panas</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="floating-box-left">
        <img src="img/logo.png" width="280px" height="95px">
    </div>
    <ul class="centered">
        <li class="list-item">
    </ul>
    <div class="floating-box-right">
        <span>Hi, <b>
		<%= userNavbar.getUsername() %>
        </b> !</span><br>
    
        <a href="LogoutServlet?id=<%= userNavbar.getId() %>">Logout</a>

    </div>
</body>
</html>

<%
	if (redirectNavbar != "") {
		response.sendRedirect(redirectNavbar);
	}
%>