<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
	<form name="loginForm" method="POST" action="LoginController">
		<p>
			<label for="login">Login</label> <input type="text" name="login"
				value="">
		</p>
		<p>
			<label for="password">Password</label> <input type="password"
				name="password">
		</p>
		<p>
			<label for="submit">Enter account</label> <input type="submit"
				name="submit" value="Enter">
		</p>
	</form>
</body>
</html>