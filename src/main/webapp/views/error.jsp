<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Page</title>
</head>
<body>

	<div style="text-align: center">
		<h2>Error occured while logging</h2>
		<h3>Login with correct Username and password</h3>

		<form method="post" action="retry" class="form-inline my-2 my-lg-0">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Retry</button>
		</form>
	</div>

</body>
</html>