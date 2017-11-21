<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

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
	
	<% if (!userNavbar.isFinding()) { %>
		<form method="POST" onsubmit="" action="Findingorder.jsp?id_active=<%= request.getParameter("id_active") %>">
			<input type="hidden" name="finding" value="1" />
			<button id="findorder" type="submit" class="button button-order">FIND ORDER</button>
		</form>
	<% } else { %>
		<p id="textorder" class="text-center text-font-order">Finding order...</p>
		
		<form method="POST" onsubmit="" action="Findingorder.jsp?id_active=<%= request.getParameter("id_active") %>">
			<input type="hidden" name="finding" value="0" />
			<button id="findorder" type="submit" class="button button-order" style="background-color: red;">CANCEL</button>
		</form>
	<% } %>

</body>

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