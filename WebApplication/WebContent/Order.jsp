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
<jsp:useBean id="profileProxy" scope="request" class="com.services.UserServiceProxy" />
<%
	profileProxy.setEndpoint("http://localhost:8000/WebService/User");
	String idStr = request.getParameter("id_active");
	int idA = Integer.parseInt(idStr);
	
	com.services.User userV = null;
	String redirect = "";
	try{
		userV = profileProxy.getUser(mytoken, idA);
	} catch (com.services.TokenException tex) {
		redirect = "LogoutServlet?id=" + request.getParameter("id_active") + "&e=" + profileProxy.getValidation(mytoken, Integer.parseInt(request.getParameter("id_active")));
		userV = new com.services.User();
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
	
	<div id="order-page">
	  <script src="js/validation.js"></script>
	  <form method="POST" onsubmit="return validateForm2()" name="myForm2" action="Selectdriver.jsp?id_active=<%= request.getParameter("id_active") %>">
	    <table border="0">
	      <tr>
	        <td><label class="label-order" for="pickup">Picking Point</label></td>
	        <td><input class="input-text" type="text" name="pickup" id="pickup" maxlength="200"></td>
	      </tr>
	      <tr>
	        <td><label class="label-order" for="dest">Destination</label></td>
	        <td><input class="input-text" type="text" name="dest" id="dest" maxlength="200"></td>
	      </tr>
	      <tr>
	        <td><label class="label-order" for="pref">Preferred Driver</label></td>
	        <td><input class="input-text" type="text" name="pref" id="pref" maxlength="200"></td>
	      </tr>
	    </table><br>
	    <button class="button-center" type="submit" name="submit">NEXT</button>
	  </form>
	</div>
</body>
</html>

<%
	if (redirect != "") {
		response.sendRedirect(redirect);
	}
%>