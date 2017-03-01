<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Web Bank</title>
<link href="bootstrap/css/bootstrap.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="row">
					<h1 class="text-center">Welcome</h1>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-7 col-md-offset-3">
				<div class="row">
					<div class="col-md-8">
						<form class="form-horizontal" role="form" name="loginForm"
							method="POST" action="LoginController">
							<div class="form-group">
								<label for="login" class="col-sm-4 control-label">Login:</label>
								<div class="col-sm-7">
									<input type="text" class="form-control" name="login"
										maxlength="9" required>
								</div>
							</div>
							<div class="form-group">
								<label for="password" class="col-sm-4 control-label">Password
									:</label>
								<div class="col-sm-7">
									<input type="password" class="form-control" name="password"
										maxlength="10" required>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-7 col-md-offset-4">
									<button type="submit" class="btn btn-success btn-lg btn-block">Sign
										in</button>
								</div>
							</div>
						</form>
						<form class="form-horizontal" role="form" name="regitryForm"
							method="POST" action="MoveToRegistryController">
							<div class="form-group">
								<div class="col-sm-7 col-md-offset-4">
									<button type="submit" class="btn btn-primary btn-lg btn-block">Sign
										up</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
