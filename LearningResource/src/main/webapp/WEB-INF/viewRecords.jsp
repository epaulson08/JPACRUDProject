<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Records</title>
</head>
<body>
	<%--
<h2>${textbook.getClass()} result:</h2>  <%-- TODO: string manipulation to access only part of name of class after last "."; or hard-code a switch 
--%>
	<h2>Record results:</h2>
	<table>
		<tr>
			<th></th>
			<th>ID:</th>
			<th>Title:</th>
			<th>Subtitle:</th>
			<th>Author</th>
			<th>Edition</th>
			<th>Year</th>
			<th>Length</th>
		</tr>
		<c:forEach var="textbook" items="textbooks">
			<tr>
				<td><form action="gotoUpdateRecord.do" method="GET">
						<input type="hidden" id="textbook" value="${textbook}" />
						<button type="submit">Update</button>
					</form>
					<form action="deleteRecord.do" method="POST">
						<button type="submit">Delete</button>
					</form></td>
				<td>${textbook.id}</td>
				<td>${textbook.title}</td>
				<td>${textbook.subtitle}</td>
				<td>${textbook.author}</td>
				<td>${textbook.edition}</td>
				<%-- TODO c:choose, when, otherwise to deal with null edition, year, length --%>
				<td>${textbook.year}</td>
				<td>${textbook.length}pages</td>
			</tr>
		</c:forEach>
	</table>

	<form action="home.do">
		<button type="submit">Return Home</button>
	</form>

</body>
</html>