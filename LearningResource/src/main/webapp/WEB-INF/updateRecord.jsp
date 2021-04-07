<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="head.jsp" />
<title>Update Record</title>
</head>
<body>
	<jsp:include page="nav.jsp" />
	<div class="container">
		<h2>Update a Record:</h2>
		<%-- TODO: Could dynamically bind type of record (textbook, journal, etc.) --%>
		<form action="recordUpdated.do" method="POST">
			<table class="doNotShadeRows">
				<tr>
					<td>ID:</td>
					<td>${textbook.id}</td>
					<td><input type="hidden" name="id" value="${textbook.id}" />
						<input type="hidden" name="oldTitle" value="${textbook.title}" /></td>
				</tr>
				<tr>
					<td>Author:</td>
					<td>${textbook.author}</td>
					<td><input type="text" name="author" />
				</tr>
				<tr>
					<td>Title:</td>
					<td>${textbook.title}</td>
					<td><input type="text" name="title" /></td>
				</tr>
				<tr>
					<td>Subtitle:</td>
					<td>${textbook.subtitle}</td>
					<td><input type="text" name="subtitle" /></td>
				</tr>
				<tr>
					<td>Edition:</td>
					<td>${textbook.edition}</td>
					<td><input type="text" name="edition" /></td>
				</tr>
				<tr>
					<td>Year:</td>
					<td>${textbook.year}</td>
					<td><input type="text" name="year" /></td>
				</tr>
				<tr>
					<td>Length:</td>
					<td>${textbook.length}</td>
					<td><input type="text" name="length" /></td>
				</tr>
			</table>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>

		<form action="home.do">
			<button type="submit" class="btn btn-secondary">Return Home</button>
		</form>
	</div>
</body>
</html>