<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Category</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
</head>
<body>
	<section class="container mt-5">
		<h1>LOẠI SÁCH</h1>
		<form class="row row-cols-lg-auto g-3 align-items-center search"
			method="post">
			<div class="col-12">
				<label class="visually-hidden" for="inlineFormInputGroupUsername">Book
					Name</label>
				<div class="input-group">
					<div class="input-group-text">Book Name</div>
					<input type="text" class="form-control" name="categoryName"
						value="${cateName}" id="categoryName"
						placeholder="Category Name">
				</div>
			</div>
			<div class="col-12">
				<button type="submit" class="btn btn-primary">Search</button>
			</div>
		</form>
		<p style="color: red;">${errorString}</p>
		<p>${sql}</p>
		<table class="table table-bordered">
			<thead style="background: #f1f1f1">
				<tr>
					<th>Id</th>
					<th>Name</th>					
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${category}" var="category">
					<tr>
						<td>${category.getCategoryId()}</td>	
						<td>${category.getCategoryName()}</td>
						<td><a class="btn btn-warning"
							href="categoryEdit?code=${category.getCategoryId()}">Edit</a> <a
							class="btn btn-danger"
							href="categoryDelete?code=${category.getCategoryId()}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<a href="categoryCreate" class="btn btn-primary">Create Category</a>
	</section>
</body>
</html>