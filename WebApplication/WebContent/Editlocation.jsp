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

<jsp:useBean id="locationProxy" scope="request" class="com.services.UserServiceProxy" />
<%
	locationProxy.setEndpoint("http://localhost:8000/WebService/User");
	String idStr = request.getParameter("id_active");
	int id = Integer.parseInt(idStr);
	
	com.services.User user = null;
	String redirect = "";
	try{
		user = locationProxy.getUser(mytoken, id);	
	} catch (com.services.TokenException tex) {
		redirect = "LogoutServlet";
		user = new com.services.User();
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="icon" href="img/icon.png" />
	<title>Ojek Panas | Edit</title>
	<link rel="stylesheet" type="text/css" href="./css/style.css">
	<script type="text/javascript" src="./js/editlocation.js"></script>
    <script type="text/javascript" src="js/validation.js"></script>
</head>
<body>
	<div class="edit-title">
        <span>EDIT PREFERRED LOCATIONS</span>
    </div>
    
    <div id="edit-profile-content">
    	<div id="edit-location-list">
    		<table id="preferredlocation" class="border-table" width="550px">

		    	<tr>
		    		<th>No</th>
		    		<th>Location</th>
		    		<th colspan="2">Actions</th>
		    	</tr>
		    	<% if (user.getPreferredLocations() != null && user.getPreferredLocations().length > 0)
		    		for (int i = 0; i < user.getPreferredLocations().length; ++i) { 
		    			String val = user.getPreferredLocations(i).getLocation(); %>
		    			<tr id="tabel<%= val %>">
		    				<td><%= i+1 %></td>
		    				<td id="data<%= val %>"><%= val %></td>
		    				<td class="pencil-image"><a href="javascript:" id="<%= val %>" name="pencil" class="pencil" onclick="return editdata(this.id, this.name)"><img id="image<%= val %>" width="20px" height="20px" src="img/pencil.png"></a>
		    					<center><a href="javascript:" id="save<%= val %>" name="<%= idStr %>" class="functionalSave"  onclick="return savedata(this.id, this.name)"><img id="imagefunc<%= val %>" width="20px" height="20px" src="img/save.png" style="display:none;"></a></center>
		    					</td>
		    				<td class="cancel-image"><a href="DeleteLocation?id_active=<%= idStr %>&loc=<%= val %>" class="confirmation" onclick="return confirm_delete()"><img src="img/cancel.png" width="20px" height="20px"></a></td>
		    				</tr>
		    	<% 	} %>
		    </table>
		    <div class="small-empty-space"></div>
    		<div class="small-title">
        		<span>ADD NEW LOCATIONS:</span>
    		</div>
    		<form method="POST" action="InsertLocation?id_active=<%= request.getParameter("id_active") %>" onsubmit="return validateAddLocation()">
    			<table width="550px">
    				<tr>
    					<td>
    						<input class="text-field" type="text" name="newloc" id="newloc">
    					</td>
    					<td><button class="save-button" name="addloc">ADD</button></td>
    				</tr>
    			</table>

    		</form>
    		<div class="small-empty-space"></div>
    		<input type="button" class="back-button" value="BACK" onclick="window.location.href='Profile.jsp?id_active=<%= request.getParameter("id_active") %>'">
    	</div>

    </div>	
</body>
</html>

<%
	if (redirect != "") {
		response.sendRedirect(redirect);
	}
%>