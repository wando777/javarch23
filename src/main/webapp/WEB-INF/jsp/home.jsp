<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<meta charset="ISO-8859-1">
<title>My SellingApp home page</title>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<div class="container-fluid">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link active" href="/">SellingApp</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="/sellers">Sellers</a></li>
				<li class="nav-item"><a class="nav-link" href="/products">Products</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="/clothes">Clothes</a></li>
				<li class="nav-item"><a class="nav-link" href="/tissues">Tissues</a></li>
			</ul>
			<c:if test="${not empty collection}">
				<form class="d-flex" action="/${route}/search">
					<input class="form-control me-2" type="text" name="searchField"
						placeholder="Search">
					<button class="btn btn-primary" type="submit">Search</button>
				</form>
			</c:if>
		</div>
	</nav>

	<div class="container mt-3">

		<span class="badge rounded-pill bg-primary">Sellers: ${countSeller}</span>
		<span class="badge rounded-pill bg-secondary">Products: ${countProduct}</span>
		<span class="badge rounded-pill bg-success">Clothes: ${countClothing}</span>
		<span class="badge rounded-pill bg-danger">Tissues: ${countTissue}</span>

		<c:if test="${not empty collection}">
			<h2>SellingApp</h2>
			<p>Product Selling Management App:</p>
			<table class="table">
				<thead class="table-dark">
					<tr>
						<th>${title}</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${collection}">
						<tr>
							<td>${item}</td>
							<td><a href="/${route}/${item.id}/delete">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
		<c:if test="${not empty object}">
			<h2>AppVenda</h2>
			<hr>
			<div class="alert alert-success">
				<strong>Success!</strong> ${object}
			</div>
		</c:if>
	</div>
</body>
</html>