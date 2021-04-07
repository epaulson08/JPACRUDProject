<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet" href="styles.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>
<title>Learning Resource Tracker</title>
</head>
<body>
	<div class="container">
		<nav class="navbar-expand-md navbar-light bg-light">
			<button type="button" class="navbar-toggler" data-toggle="collapse"
				data-target="#navbar">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbar">
				<ul class="navbar-nav nav">
					<li class="nav-item"><a class="nav-link" href="home.do">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="seeAll.do">List
							All Records</a></li>
					<li class="nav-item"><a class="nav-link"
						href="goToCreateRecord.do">Create Record</a></li>
					<%-- TODO: pages for search by ID and keyword --%>
				</ul>
			</div>
		</nav>
	</div>

	<section>
		<div class="container">
			<h1>LearnDB</h1>
			<hr>
			<div>
				<h3 class="indexLink">
					<a href="seeAll.do">See All Records</a>
				</h3>
				<h3 class="indexLink">
					<a href="gotoCreateRecord.do">Create Record</a>
				</h3>
				<br />
				<form action="searchByTitle.do" method="GET">
					<div class="form-row">
						<div class="col">
							<h3 class="indexHeader">
								<label for="searchByTitle">Search by Title:</label>
							</h3>
						</div>
						<div class="col">
							<input type="text" name="title" id="searchByTitle"
								class="form-control" />
						</div>
						<div class="col">
							<button type="submit" class="btn btn-primary">Submit</button>
						</div>
					</div>
				</form>
				<form action="searchByAuthor.do" method="GET">
					<div class="form-row">
						<div class="col">
							<h3 class="indexHeader">
								<label for="searchByAuthor">Search By Author:</label>
							</h3>
						</div>
						<div class="col">
							<input type="text" name="author" id="searchByAuthor"
								class="form-control" />
						</div>
						<div class="col">
							<button type="submit" class="btn btn-primary">Submit</button>
						</div>
					</div>
				</form>
				<form action="searchRecordByID.do" method="GET">
					<div class="form-row">
						<div class="col">
							<h3 class="indexHeader">
								<label for="searchByID">Find record by ID:</label>
							</h3>
						</div>
						<div class="col">
							<input type="text" name="id" class="form-control" id="searchByID" />
						</div>
						<div class="col">
							<button type="submit" class="btn btn-primary">Submit</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</section>
</body>
</html>