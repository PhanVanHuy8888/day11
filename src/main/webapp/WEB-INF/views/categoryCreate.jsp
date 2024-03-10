<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Category</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">

</head>
<body>
	<section class = "container">
		<h3>Category Create</h3>
		<p> ${errorString}</p>
		
		<form method="POST" action="${pageContext.request.contextPath }/categoryCreate">
			<table class="table table-bordered">
				<tr>
					<td>Category Id</td>
					<td><input type="text" name="categoryId" value="${category.getCategoryId() }"/></td>
				</tr>
				<tr>
					<td>Category Name</td>
					<td><input type="text" name="categoryName" value="${category.getCategoryName() }"/></td>
				</tr>
				<tr>
					<td>
						<button type="submit" class="btn btn-success">Lưu</button>
						<a href="categoryList" class="btn btn-danger">Quay Lai</a>
					</td>
				</tr>
			</table>
		</form>
	</section>
</body>
</html>