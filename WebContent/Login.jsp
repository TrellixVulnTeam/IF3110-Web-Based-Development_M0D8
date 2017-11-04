<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="icon" href="img/icon.png" />
	<title>Ojek Panas | Login</title>
	<link rel="stylesheet" type="text/css" href="./css/style.css">
</head>
<body>
	<div id="signin-rectangle">
		<div class="title"><span>LOGIN</span></div>
		<script src="js/validation.js"></script>
		<form method="POST" action="http://localhost:7000/IdentityService/Login" name="myForm" onsubmit="return validateForm()">
			<table class="form" border="0">
				<tr>
					<td><label class="label" for="username">Username</label></td>
					<td><input class="text-field" type="text" name="username" id="username" maxlength="20"></td>
				</tr>
				<tr>
					<td><label class="label" for="pass">Password</label></td>
					<td><input class="text-field" type="password" name="pass" id="pass" maxlength="16"></td>
				</tr>
			</table>
			<div class="empty-space"></div>
			<div class="block-container">
				<div class="no-account"><a class="link-format"> <!-- href="signup.php" --> Don't have an account?</a></div>
				<button class="button-index" name="login">GO!</button>
			</div>
		</form>
	</div>
</body>
</html>