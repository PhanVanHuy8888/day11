<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Book</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
	integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

</head>
<body>
	<section class="container">
		<h3>Book Create</h3>
		<p>${errorString}</p>

		<form method="POST"
			action="${pageContext.request.contextPath }/bookCreate">
			<table class="table table-bordered">
				<tr>
					<td>Book Id</td>
					<td><input type="text" name="BookId"
						value="${book.bookId}" /></td>
				</tr>
				<tr>
					<td>Title</td>
					<td><input type="text" name="Title"
						value="${book.title}" /></td>
				</tr>
				<tr>
					<td>Author</td>
					<td><input type="text" name="Author"
						value="${book.author}" /></td>
				</tr>
				<tr>
					<td>Release</td>
					<td><input type="text" name="Release"
						value="${book.release}" /></td>
				</tr>
				<tr>
					<td>Price</td>
					<td><input type="text" name="Price" value="${book.price}" /></td>
				</tr>
				<tr>
					<td>Picture </td>
					<td><input type="text" name="Picture" value="${book.picture }"/></td>
				</tr>
				<tr>
					<td>
						<button type="submit" class="btn btn-success">Lưu</button> <a
						href="bookList" class="btn btn-danger">Quay Lai</a>
					</td>
				</tr>
			</table>
		</form>
	</section>
</body>
</html>
