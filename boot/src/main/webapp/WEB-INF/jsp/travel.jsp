<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Pragma" content="no-cache"> 
    <meta http-equiv="Cache-Control" content="no-cache"> 
    <meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">
    
    <title>Travel Manager | Home</title>
    
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
     <link href="static/css/style.css" rel="stylesheet">
</head>
<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Bootsample</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="new-travel">New Travel</a></li>
					<li><a href="all-travels">All Travels</a></li>
				</ul>
			</div>
		</div>
	</div>

	<c:choose>
		<c:when test="${mode=='MODE_HOME'}">
			<div class="container">
				<div class="jumbotron text-center" id="homeDiv">
					<h1>Welcome to Task Manager</h1>

				</div>
			</div>
		</c:when>


		<c:when test="${mode=='MODE_TRAVELS'}">
			<div class="container text-center" id="productsDiv">
				<h3>My Travels</h3>
				<hr />
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>Place</th>
								<th>Transport</th>
								<th>Date Registry</th>
								<th>Cost</th>
								<th>Date Start</th>
								<th>Date Finish</th>
								<th>Validated</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="travel" items="${travels}">
								<tr>
									<td>${travel.id}</td>
									<td>${travel.place}</td>
									<td>${travel.transport}</td>
									<td><fmt:formatDate pattern="dd-MM-yyyy"
											value="${travel.dateRegistry}" /></td>
									<td>${travel.cost }</td>
									<td>${travel.dateStart }</td>
									<td>${travel.dateFinish }</td>
									
									<td>${travel.validated==true?"YES":"NO"}</td>
									<td><a href="update-travel?id=${travel.id}"><span
											class="glyphicon glyphicon-pencil"></span> </a></td>

									<td><a href="delete-travel?id=${travel.id}"> <span
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
			test="${mode=='MODE_NEW_TRAVEL' || mode=='MODE_UPDATE_TRAVEL'}">
			<div class="container text-center">
				<h3>Manage Travel</h3>
				<hr />
				<form class="form-horizontal" method="POST" action="save-travel">
					<input type="hidden" name="id" value="${travel.id}" />
					<div class="form-group">
						<label class="control-label col-sm-3">Place:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="place"
								value="${travel.place}" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-3">Transport:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="transport"
								value="${travel.transport}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3">Cost:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="cost"
								value="${travel.cost}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3">Date Start:</label>
						<div class="col-sm-7">
							<input type="date" class="form-control" name="dateStart"
								value="${travel.dateStart}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3">Date Finish:</label>
						<div class="col-sm-7">
						
							<input type="date"  class="form-control" name="dateFinish"
								value="${travel.dateFinish}" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-3">Validated:</label>
						<div class="col-sm-7">
							<input type="radio" class="col-sm-1" name="validated" value="true" />
							<div class="col-sm-2">YES</div>
							<input type="radio" class="col-sm-1" name="validated" value="false"
								checked="checked" />
							<div class="col-sm-2">NO</div>
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