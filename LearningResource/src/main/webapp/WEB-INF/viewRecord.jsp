<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Record</title>
</head>
<body>
	<%--
<h2>${textbook.getClass()} result:</h2>  <%-- TODO: string manipulation to access only part of name of class after last "."; or hard-code a switch 
--%>
	<h2>Record result:</h2>
	<table>
		<tr>
			<th></th>
			<th>ID</th>
			<th>Title</th>
			<th>Subtitle</th>
			<th>Author</th>
			<th>Edition</th>
			<th>Year</th>
			<th>Length</th>
		</tr>
			<tr>
			<td><form action="gotoUpdateRecord.do" method="GET"><button type="submit">Update</button>
			<input type="hidden" name="id" value="${textbook.id}" /></form>
			<form action="recordDeleted.do" method="POST"><button type="submit">Delete</button>
			<input type="hidden" name="id" value="${textbook.id}" /></form>
			</td>
			<td><form></form></td>
				<td>${textbook.id}</td>
				<td>${textbook.title}</td>
				<td>${textbook.subtitle}</td>
				<td>${textbook.author}</td>
				<td>${textbook.edition}</td>
				<%-- TODO c:choose, when, otherwise to deal with null edition, year, length --%>
				<td>${textbook.year}</td>
				<td>${textbook.length}pages</td>
			</tr>
	</table>

<form action="home.do"><button type="submit">Return Home</button></form>

</body>
</html>