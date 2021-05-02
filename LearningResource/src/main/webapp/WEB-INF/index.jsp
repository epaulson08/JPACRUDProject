
<%-- TODO: fix Search By Author form --%>

<!DOCTYPE html>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<meta charset="UTF-8">
<jsp:include page="head.jsp" />
<title>Learning Resource Tracker</title>
</head>
<body>
<jsp:include page="nav.jsp" />
	<div class="container">
		<h2 class="display-3">LearnDB</h2>
		<p>A prototype app as I learn JPA/Hibernate, Spring Boot, and Spring MVC. Tasked with interfacing with a relational database and implementing CRUD (create/read/update/delete) functionality, what have I chosen to track? My textbook, collection of course... -Eric</p> 
		<hr>
		<h3>
			<a class="ceruleanLink" href="seeAll.do">See All Textbooks</a>
		</h3>
		<h3>
			<a class="ceruleanLink" href="gotoCreateRecord.do">Create Textbook</a>
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
		<!-- form action="searchRecordByID.do" method="GET">
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
		</form-->
	</div>
	<jsp:include page="foot.jsp" />
</body>
</html>