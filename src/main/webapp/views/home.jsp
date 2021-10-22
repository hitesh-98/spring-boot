<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head><%@ page isELIgnored="false"%>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<link rel="stylesheet" href="./style.css">

<title>Books Management</title>
</head>
<body>

	<header>

		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarTogglerDemo03"
				aria-controls="navbarTogglerDemo03" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<a class="navbar-brand">E-Book Portal</a>

			<div class="collapse navbar-collapse" id="navbarTogglerDemo03">

				<form method="post" action="logout" class="form-inline my-2 my-lg-0">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Logout</button>
				</form>

				<form method="post" action="getAllBooks"
					class="offset-md-1 form-inline my-2 my-lg-0">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Display
						Books</button>
				</form>

			</div>
		</nav>

	</header>

	<div align="center">
		<h3>Welcome</h3>
	</div>

	<form action="addBookAndRedirect" method="post" modelAttribute="book">
		<div class="container col-md-5">
			<div class="card">
				<div class="card-body">

					<fieldset class="form-group">
						<label>Book Code</label> <input type="text" class="form-control"
							name="bookCode" required="required" />
					</fieldset>

					<fieldset class="form-group">
						<label>Book Name</label> <input type="text" class="form-control"
							name="bookName" />
					</fieldset>

					<fieldset class="form-group">
						<label>Author</label> <input type="text" class="form-control"
							name="author" />
					</fieldset>

					<fieldset class="form-group">
						<label>Date Added</label> <input type="text" class="form-control"
							name="dateAdded" />
					</fieldset>

					<button type="submit" class="btn btn-success">Add Book</button>

				</div>
			</div>
		</div>
	</form>

	<!-- Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
		crossorigin="anonymous">
		
	</script>


</body>
</html>