<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="icon" href="img/icon.png" />
	<title>Ojek Panas | Sign Up</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script src="js/validation.js"></script>
</head>
<body>
	<div id="signup-rectangle">
		<div class="title"><span>SIGN UP</span></div>
		<form name="register-form" action="http://localhost:7000/IdentityService/Register" method="POST" onsubmit="return validateForm1()">
			<table class="form" border="0">
				<tr>
					<td><label class="label" for="fullname">Your Name</label></td>
					<td colspan="2"><input class="text-field" type="text" name="fullname" id="fullname"></td>
				</tr>
				<tr>
					<td><label class="label" for="username">Username</label></td>
					<td><input class="small-text-field" type="text" name="username" id="username" onblur="validate_username('username', this.value)"></td>
					<td><div id="txtHint"></div></td>
				</tr>
				<tr>
					<td><label class="label" for="email">Email</label></td>
					<td><input class="small-text-field" type="email" name="email" id="email" onblur="validate_email('email', this.value)"></td>
					<td><div id="txtHint1"></div></td>
				</tr>
				<tr>
					<td><label class="label" for="pass">Password</label></td>
					<td colspan="2"><input class="text-field" type="password" name="pass" id="pass"></td>
				</tr>
				<tr>
					<td><label class="label" for="cpass">Confirm Password</label></td>
					<td colspan="2"><input class="text-field" type="password" name="cpass" id="cpass"></td>
				</tr>
				<tr>
					<td><label class="label" for="phone">Phone Number</label></td>
					<td colspan="2"><input class="text-field" type="text" name="phone" id="phone"></td>
				</tr>
			</table><br>
			<div class="form-group">
				<input class="checkbox-box" type="checkbox" name="is-driver" id="is-driver"><p class="checkbox-text">Also sign me up as a driver!</p>
			</div>
			<div class="empty-space"></div>

			<div class="block-container">
				<div class="no-account"><a class="link-format" href="Login.jsp">Already have an account?</a></div>
				<button class="button-index" name="register" value="submit">REGISTER</button>
			</div>
		</form>
	</div>
</body>
</html>