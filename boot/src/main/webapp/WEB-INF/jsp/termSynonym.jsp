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
<title>TermSynonym Sample | Home</title>
<link rel="stylesheet" href="static/css/bootstrap.min.css">
<link rel="stylesheet" href="static/css/style.css">
</head>
<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Bootsample</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="new-term">New Term Synonym</a></li>
					<li><a href="all-terms">All Term Synonyms</a></li>
				</ul>
			</div>
		</div>
	</div>

	<c:choose>
		<c:when test="${mode=='MODE_HOME'}">
			<div class="container">
				<div class="jumbotron text-center" id="homeDiv">
					<h1>Welcome Term Synonyms Manager</h1>

				</div>
			</div>
		</c:when>

		<c:when test="${mode=='MODE_TERMS'}">
			<div class="container text-center" id="termSynonymsDiv">
				<h3>My Term Synonyms</h3>
				<hr />
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>Term Synonym</th>
								<th>Acc Synonym</th>
								<th>Synonym Type Id</th>
								<th>Synonym Category Id</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="termsynonym" items="${termSynonyms}">
								<tr>
									<td>${termsynonym.id}</td>
									<td>${termsynonym.termSynonym}</td>
									<td>${termsynonym.accSynonym}</td>
									<td>${termsynonym.synonymTypeId}</td>
									<td>${termsynonym.synonymCategoryId}</td>
									<td><a href="update-term?id=${termsynonym.id}"><span
											class="glyphicon glyphicon-pencil"></span> </a></td>

									<td><a href="delete-term?id=${termsynonym.id}"> <span
											class="glyphicon glyphicon-trash"></span>
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
		<c:when test="${mode=='MODE_NEW_TERM' || mode=='MODE_UPDATE_TERM'}">
			<div class="container text-center">
				<h3>Manage Term Synonym</h3>
				<hr />
				<form class="form-horizontal" method="POST" action="save-term">
					<input type="hidden" name="id" value="${termsynonym.id}" />

					<div class="form-group">
						<label class="control-label col-sm-3">Term Synonym:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="termSynonym"
								value="${termsynonym.termSynonym}" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-3">Acc Synonym:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="accSynonym"
								value="${termsynonym.accSynonym}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3">Synonym Type Id:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="synonymTypeId"
								value="${termsynonym.synonymTypeId}" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-3">Synonym Category Id:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="synonymCategoryId"
								value="${termsynonym.synonymCategoryId}" />
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