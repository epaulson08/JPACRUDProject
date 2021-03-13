<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Record Created</title>
</head>
<body>
<h3>You have successfully created: </h3>

	<table>
		<tr>
			<th>ID</th>
			<th>Title</th>
			<th>Subtitle</th>
			<th>Author</th>
			<th>Edition</th>
			<th>Year</th>
			<th>Length</th>
		</tr>
			<tr>
				<%-- TODO c:choose, when, otherwise to deal with null subtitle, edition, year, length --%>
				<td>${textbook.id}</td>
				<td>${textbook.title}</td>
				<td>${textbook.subtitle}</td>
				<td>${textbook.author}</td>
				<td>${textbook.edition}</td>
				<td>${textbook.year}</td>
				<td>${textbook.length}pages</td>
			</tr>
	</table>
	
	<form action="home.do"><button type="submit">Return Home</button></form>
</body>
</html>