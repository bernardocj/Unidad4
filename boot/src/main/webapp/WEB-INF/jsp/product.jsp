<%@page language="java" contentType="text/html; charset=UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE-edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<title>Product Sample | Home</title>
<link rel="stylesheet" href="static/css/bootstrap.min.css">
<link rel="stylesheet" href="static/css/style.css">
</head>
<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Bootsample</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="new-product">New Product</a></li>
					<li><a href="all-products">All Products</a></li>
				</ul>
			</div>
		</div>
	</div>

	<c:choose>
		<c:when test="${mode=='MODE_HOME'}">
			<div class="container">
				<div class="jumbotron text-center" id="homeDiv">
					<h1>Welcome to Products Manager</h1>

				</div>
			</div>
		</c:when>

		<c:when test="${mode=='MODE_PRODUCTS'}">
			<div class="container text-center" id="productsDiv">
				<h3>My Products</h3>
				<hr />
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>Product Name</th>
								<th>Product Description</th>
								<th>Date Entry</th>
								<th>Quantity</th>
								<th>Status</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="product" items="${products}">
								<tr>
									<td>${product.id}</td>
									<td>${product.name}</td>
									<td>${product.description}</td>
									<td><fmt:formatDate pattern="dd-MM-yyyy"
											value="${product.dateEntry}" /></td>
									<td>${product.quantity }</td>
									<td>${product.status==true?"ACTIVE":"INACTIVE"}</td>
									<td><a href="update-product?id=${product.id}"><span
											class="glyphicon glyphicon-pencil"></span> </a></td>

									<td><a href="delete-product?id=${product.id}"> <span
											class="glyphicon glyphicon-trash"></span>
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
		<c:when
			test="${mode=='MODE_NEW_PRODUCT' || mode=='MODE_UPDATE_PRODUCT'}">
			<div class="container text-center">
				<h3>Manage Product</h3>
				<hr />
				<form class="form-horizontal" method="POST" action="save-product">
					<input type="hidden" name="id" value="${product.id}" />
					<div class="form-group">
						<label class="control-label col-sm-3">Product Name:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="name"
								value="${product.name}" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-3">Product Description:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="description"
								value="${product.description}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3">Quantity:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="quantity"
								value="${product.quantity}" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-3">Status:</label>
						<div class="col-sm-7">
							<input type="radio" class="col-sm-1" name="status" value="true" />
							<div class="col-sm-2">ACTIVE</div>
							<input type="radio" class="col-sm-1" name="status" value="false"
								checked="checked" />
							<div class="col-sm-2">INACTIVE</div>
						</div>
					</div>

					<div class="form-group">
						<input type="submit" class="btn btn-primary" value="Save" />
					</div>

				</form>
			</div>
		</c:when>
	</c:choose>
	<script type="text/javascript" src="/static/js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="static/js/bootstrap.min.js"></script>
</body>
</html>