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
    
    <title>Song Manager | Home</title>
    
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
     <link href="static/css/style.css" rel="stylesheet">
</head>
<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Bootsample</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="new-song">New Song</a></li>
					<li><a href="all-songs">All Songs</a></li>
				</ul>
			</div>
		</div>
	</div>

	<c:choose>
		<c:when test="${mode=='MODE_HOME'}">
			<div class="container">
				<div class="jumbotron text-center" id="homeDiv">
					<h1>Welcome to Songs Manager</h1>

				</div>
			</div>
		</c:when>



		<c:when test="${mode=='MODE_SONGS'}">
			<div class="container text-center" id="tasksDiv">
				<h3>My Songs</h3>
				<hr />
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>Name</th>
								<th>Artist</th>
								<th>Date Premier</th>
								<th>Format</th>
								<th>Album</th>
								<th>Cost</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="song" items="${songs}">
								<tr>
									<td>${song.id}</td>
									<td>${song.name}</td>
									<td>${song.artist}</td>
									<td>${song.datePremier}</td>
									<td>${song.format}</td>
									<td>${song.album}</td>
									<td>${song.cost}</td>
									
									<td><a href="update-song?id=${song.id}"><span
											class="glyphicon glyphicon-pencil"></span> </a></td>
									<td><a href="delete-song?id=${song.id}"> <span
											class="glyphicon glyphicon-trash"></span>
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
		<c:when test="${mode=='MODE_NEW_SONG' || mode=='MODE_UPDATE_SONG'}">
			<div class="container text-center">
				<h3>Manage Song</h3>
				<hr />
				<form class="form-horizontal" method="POST" action="save-song">
					<input type="hidden" name="id" value="${song.id}" />
					<div class="form-group">
						<label class="control-label col-sm-3">Name:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="name"
								value="${song.name}" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-3">Artist:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="artist"
								value="${song.artist}" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-3">Date Premier:</label>
						<div class="col-sm-7">
							<input type="date" class="col-sm-3" name="datePremier" 
							value="${song.datePremier }" />
							
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3">Format:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="format"
								value="${song.format}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3">Album:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="album"
								value="${song.album}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3">Cost:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="cost"
								value="${song.cost}" />
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