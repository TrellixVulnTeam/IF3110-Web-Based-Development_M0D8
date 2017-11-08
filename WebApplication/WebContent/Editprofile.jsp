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

<jsp:useBean id="editProfileProxy" scope="request" class="com.services.UserServiceProxy" />
<%
	editProfileProxy.setEndpoint("http://localhost:8000/WebService/User");
	String idStr = request.getParameter("id_active");
	int id = Integer.parseInt(idStr);
	
	com.services.User user;	
	try{
		user = editProfileProxy.getUser(mytoken, id);		
	} catch (com.services.TokenException tex) {
		response.sendRedirect("LogoutServlet");
	}
%>

<%
	if (request.getMethod().equals("POST")) {
		if (request.getParameter("yourname") != null) {
			user.setName(request.getParameter("yourname"));
		}
		if (request.getParameter("phone") != null) {
			user.setPhoneNumber(request.getParameter("phone"));
		}
		if (request.getParameter("isdriver") != null) {
			user.setDriver(true);
		} else {
			user.setDriver(false);
		}
		
		try{
			editProfileProxy.saveUser(mytoken, user);		
		} catch (com.services.TokenException tex) {
			response.sendRedirect("LogoutServlet");
		}
		
		response.sendRedirect("http://localhost:9000/WebApplication/Profile.jsp?id_active=" + request.getParameter("id_active"));
		/* response.sendRedirect("http://localhost:9000/WebApplication/Profile.jsp?id_active=" + request.getParameter("id_active")); */
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="icon" href="img/icon.png" />
	<title>Ojek Panas | Edit</title>
	<link rel="stylesheet" type="text/css" href="./css/style.css">
	<script src="js/validation.js"></script>
</head>
<body>
	<div class="edit-title">
        <span>EDIT PROFILE INFORMATION</span>
    </div>

    <div id="edit-profile-content">
    <script src="js/validation.js"></script>
    <form onsubmit="return validateEditProfileForm()" method="POST" action="Uploadfile.jsp?id_active=<%= request.getParameter("id_active") %>"  name="editpicture-form" enctype="multipart/form-data">
    	<table>
	    	<tr>
	    		<td rowspan="2"><img class="square-image" id="output" src="<%= user.getImagePath() %>" alt="Profile Picture"></td>
	    		<td class="horizontal-space"></td>
	    		<td class="bottom-table"><label class="label">Update profile picture</label></td>
	    	</tr>
	    	<tr>
	    		<td class="horizontal-space"></td>
	    		<td class="upper-table"><input type="file" name="user_image" id="user_image" accept="image/*" onchange="return uploadFileHandler(event)"></td>
	    		<td><input type="submit" value="Change picture">
	    	</tr>
	    </table>
	</form>
	<form onsubmit="return validateEditProfileForm()" method="POST" action="Editprofile.jsp?id_active=<%= request.getParameter("id_active") %>"  name="editprofile-form">
	    <table>
	    	<tr>
	    		<td colspan="3" class="vertical-space"></td>
	    	</tr>
	    	<tr>
	    		<td><label class="label" for="yourname">Your Name</label></td>
	    		<td class="horizontal-space"></td>
	    		<td><input class="text-field" type="text" name="yourname" id="yourname" value="<%= user.getName() %>"></td>
	    	</tr>
	    	<tr>
	    		<td><label class="label" for="phone">Phone</label></td>
	    		<td class="horizontal-space"></td>
	    		<td><input class="text-field" type="text" name="phone" id="phone" value="<%= user.getPhoneNumber() %>"></td>
	    	</tr>
	    	<tr>
	    		<td><label class="label" for="isdriver">Status Driver</label></td>
	    		<td class="horizontal-space"></td>
	    		<td class="content-right">
		    		<label class="switch">
		    			<% if (!user.isDriver()) { %>
		    				<input name="isdriver" id="isdriver" type="checkbox">
		    			<% } else { %>
		    				<input name="isdriver" id="isdriver" type="checkbox" checked>
		    			<% } %>
	  					<span class="slider round"></span>
					</label>
				</td>
	    	</tr>
	    	<tr>
	    		<td colspan="3" class="vertical-space"></td>
	    	</tr>
	    	<tr>
	    		<td><input type="button" class="back-button" value="BACK" onclick="window.location.href='profile.php?id_active=<%= request.getParameter("id_active") %>'"></td>
	    		<td class="horizontal-space"></td>
	    		<td><button class="save-button" name="editprofile" value="submit">SAVE</button></td>
	    	</tr>
	    </table>
    </form>
    </div>
</body>
</html>