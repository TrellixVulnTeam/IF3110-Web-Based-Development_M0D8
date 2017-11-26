<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.DataOutputStream"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.net.HttpURLConnection"%>
<%@page import="java.net.URL"%>
<%@page import="org.json.JSONObject"%>
<%@page import="org.json.JSONArray"%> 
<%
// Get list of available driver
		String url = "http://localhost:8080/api/avals/users";
	     URL connection = new URL(url);
	     HttpURLConnection con = (HttpURLConnection) connection.openConnection();

	     //add reuqest header
	     con.setRequestMethod("POST");
	     // Send post request
	     con.setDoOutput(true);
	     DataOutputStream wr = new DataOutputStream(con.getOutputStream());
	     wr.flush();
	     wr.close();
	     
	     BufferedReader in = new BufferedReader(
	              new InputStreamReader(con.getInputStream()));
	      String inputLine;
	      StringBuilder resp = new StringBuilder();
	      while ((inputLine = in.readLine()) != null) {
	        resp.append(inputLine);
	      }
	      
	      in.close();
	      con.disconnect();

	     JSONObject obj = new JSONObject("{\"data\"=" + resp + "}");
	     JSONArray aval_users = obj.getJSONArray("data");    
	     
	     boolean isFinding;
	     
	     if (aval_users.length() == 0) {
	    	 isFinding = false;
	     } else {
	    	 int len = aval_users.length();
		     int a;
		     boolean found = false;
	    	 
	    	// check if driver is available
	    	 for (a = 0; a< len; a++) {
		    	 if (Integer.parseInt(request.getParameter("id_active")) == (aval_users.getJSONObject(a).getInt("id"))) {
		    		 found = true;
		    		 break;
		    	 }
		     }
	    	 if (!found) {
	    		 isFinding = false;
	    	 } else {
	    		 isFinding = true;
	    	 }
		    
	     }
	     out.println("<script> isFinding = " + isFinding + "; </script>");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Order</title>
	
	<link rel="icon" href="img/icon.png" />
	<link rel="stylesheet" href="css/style.css">
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
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
	
	<div id="order-header">
	  <div class="floating-box-left-chat">LOOKING FOR AN ORDER</div>
	</div>
	
	<% if (!isFinding) { %>
		<form method="POST">
			<button id="findOrderButton" type="submit" class="button button-order" name="findOrderButton">FIND ORDER</button>
		</form>
	<% } else { %>
		<p id="textorder" class="text-center text-font-order">Finding order...</p>
		
		<form method="POST">
			<button id="cancelButton" type="submit" class="button button-order" style="background-color: red;" name="cancelButton">CANCEL</button>
		</form>
	<% } %>

</body>

<%
if(request.getParameter("findOrderButton")!=null || request.getParameter("cancelButton")!=null) {
		 url = "http://localhost:8080/api/avals/changestat";
	      connection = new URL(url);
	      con = (HttpURLConnection) connection.openConnection();

	     String status;
	     if (request.getParameter("findOrderButton")!=null) {
	    	 status = "true";
	     } else {
	    	 status = "false";
	     }
	     
	     //add reuqest header
	     con.setRequestMethod("POST");
	     String urlParameters = "id="+request.getParameter("id_active")+
	              "&status=" + status + "&customer=0";
	     // Send post request
	     con.setDoOutput(true);
	      wr = new DataOutputStream(con.getOutputStream());
	      wr.writeBytes(urlParameters);
	     wr.flush();
	     wr.close();
	     
	      in = new BufferedReader(
	              new InputStreamReader(con.getInputStream()));
	       inputLine = "";
	       resp = new StringBuilder();
	      while ((inputLine = in.readLine()) != null) {
	        resp.append(inputLine);
	      }
	      
	      in.close();
	      con.disconnect();

	      obj = new JSONObject("{\"data\"=" + resp + "}");
	      aval_users = obj.getJSONArray("data");  
	     
	     response.sendRedirect("Findorder.jsp?id_active=" + request.getParameter("id_active"));
	     
	}
%>

<%
	out.println("<script>id = " + request.getParameter("id_active") + "</script>");
%>

<script src="https://cdn.rawgit.com/mgalante/jquery.redirect/master/jquery.redirect.js"></script>

<script>
	cancelled = false;
	callout = function () {
		if (isFinding && !cancelled) {
			$.ajax({        
	            type : 'POST',
	            url : "http://localhost:8080/api/avals/status",
	            //contentType : 'application/json',
	            //dataType: 'json',
	            data: {id:id},
	            success : function(response) {
	                if (response == false) {
	                	$.ajax({        
	                        type : 'POST',
	                        url : "http://localhost:8080/api/avals/customer",
	                        //contentType : 'application/json',
	                        //dataType: 'json',
	                        data: {id:id},
	                        success : function(response) {
	                            if (response != "0") {
	                            	$.redirect('driver_chat.jsp?id_active=' + id, {'id_customer': response});
	                            	//window.location = ('driver_chat.jsp?id_active=' + id, {'id_customer': response});
	                            }
	                        }
	              		});
	                }
	            }
	       
	  		})
	  		.always(function() {
	  			setTimeout(callout, 2000);
	  		});
		}
	};

	callout();
	
	/*if (isFinding) {
		$( document ).ready(function() {
		    foundOrder = false;
		    while (!foundOrder) {
		    	setTimeout(function() {
		    	 $.ajax({        
		             type : 'POST',
		             url : "http://localhost:8080/api/avals/status",
		             //contentType : 'application/json',
		             //dataType: 'json',
		             data: {id:id},
		             success : function(response) {
		            	 alert(response);
		                 //if (response == false) {
		                //	 foundOrder = true;
		                 //}
		             }
		        
		   		});
		    	}, 2000);
		    }
		});
	}*/
</script>


<!--script>
	function onClickButtonOrder() {
		var btn = document.getElementById("findorder");
		var txt = document.getElementById("textorder");
		if (btn.style.backgroundColor != "red") { // green
			btn.style.backgroundColor = "red";
			txt.innerHTML = "Finding order...";
			btn.innerText = "CANCEL";
			
		} else {
			btn.style.backgroundColor = "#85D507";
			txt.innerHTML = "";
			btn.innerText = "FIND ORDER";	
		}
	}
</script-->

</html>