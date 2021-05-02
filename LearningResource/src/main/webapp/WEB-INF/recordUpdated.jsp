<%-- FIXME: this page still refers to Textbook.author field (deprecated) --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="head.jsp" />
<title>Record Updated</title>
</head>
<body>
	<jsp:include page="nav.jsp" />
	<div class="container">
		<h2>You have successfully updated "${oldTitle}" to:</h2>

		<table>
			<tr>
				<th>ID:</th>
				<th>Title:</th>
				<th>Subtitle:</th>
				<th>Author</th>
				<th>Edition</th>
				<th>Year</th>
				<th>Length</th>
			</tr>
			<tr>
				<td>${textbook.id}</td>
				<td>${textbook.title}</td>
				<td>${textbook.subtitle}</td>
				<td>${textbook.author}</td>
				<td>${textbook.edition}</td>
				<td>${textbook.year}</td>
				<td>${textbook.length}pages</td>
			</tr>
		</table>

		<form action="home.do">
			<button type="submit" class="btn btn-secondary">Return Home</button>
		</form>
	</div>
	<jsp:include page="foot.jsp" />
</body>
</html>