<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Registration blank</title>
<link href="bootstrap/css/bootstrap.css" rel="stylesheet">
<style>
.container {
	width: 940px;
	.
	center-block
	();
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<h1 class="text-center">Sign Up for a New Bank Account:</h1>
		</div>
		<div class="col-xs-4">
			<form role="form" name="registryForm" method="POST"
				action="SignUpController">
				<div class="form-group">
					<label for="firstName">First name:</label> <input type="text"
						class="form-control" name="firstName" placeholder="John"
						pattern="[A-Z][a-z]{3,}" maxlength="14" required />
				</div>
				<div class="form-group">
					<label for="lastName">Last name:</label> <input type="text"
						class="form-control" name="lastName" placeholder="Jonson"
						pattern="[A-Z][a-z]{3,}" maxlength="14" required />
				</div>


				<div class="form-group">
					<label for="email">Email:</label> <input type="email"
						class="form-control" name="email" placeholder="john98@gmail.com"
						maxlength="30" required />
				</div>
				<div class="form-group">
					<label for="passportSeria">Passport seria:</label> <input
						type="text" class="form-control" name="passportSeria"
						placeholder="MP2346421" pattern="[A-Z][A-Z][0-9]{7}" maxlength="9"
						required />
				</div>



				<div class="form-group">
					<label for="login">Login:</label> <input type="text"
						class="form-control" name="login" pattern="^[a-z0-9_-]{3,9}$"
						maxlength="9" required />
				</div>
				<div class="form-group">
					<label for="password">Password:</label> <input type="password"
						class="form-control" name="password" maxlength="10" required />
				</div>
				<div class="form-group">
					<label for="retypePassword">Retype Password :</label> <input
						type="password" class="form-control" name="retypePassword"
						maxlength="10" required />
				</div>

				<button type="submit" class="btn btn-success">Submit</button>



			</form>
		</div>
	</div>
</body>
</html>
