<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head><%@ page isELIgnored="false"%>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css"
	integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

<title>Books</title>
</head>
<body>

	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th scope="col">BookCode</th>
				<th scope="col">BookName</th>
				<th scope="col">Author</th>
				<th scope="col">DateAdded</th>
				<th scope="col">Actions</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${list}" var="list">
				<tr>
					<th scope="row">${list.bookCode}</th>
					<td>${list.bookName}</td>
					<td>${list.author}</td>
					<td>${list.dateAdded}</td>
					<td><a href="deleteBookAndRedirect/${list.bookCode}"> <i
							class="fas fa-trash text-danger" style="font-size: 30px;"></i></a> <a
						href="editBookAndRedirect/${list.bookCode}"> <i
							class="fas fa-pen-nib text-primary" style="font-size: 30px;"></i></a>
					</td>

				</tr>>
			</c:forEach>
		</tbody>

	</table>

	<div class="container text-center">
		<form method="post" action="addAnother"
			class="form-inline my-2 my-lg-0">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Add
				Another Book</button>
		</form>
	</div>






	<!-- Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
		crossorigin="anonymous">
		
	</script>

</body>
</html>