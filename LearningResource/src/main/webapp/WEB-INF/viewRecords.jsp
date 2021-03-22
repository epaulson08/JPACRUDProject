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

<title>View Records</title>
</head>
<body>
	<div class="container">
		<%--
<h2>${textbook.getClass()} result:</h2>  <%-- TODO: string manipulation to access only part of name of class after last "."; or hard-code a switch 
--%>
		<h2>Record results:</h2>
		<c:choose>
			<c:when test="${not empty textbooks}">
				<table class="shadeRows">
					<tr>
						<th>ID:</th>
						<th>Title:</th>
						<th>Subtitle:</th>
						<%-- TODO: BROKEN WHEN CHANGED `author` to `authors`: --%>
						<th>Author(s)</th>
						<th>Edition</th>
						<th>Year</th>
						<th>Length</th>
						<th></th>
					</tr>
					<c:forEach var="textbook" items="${textbooks}">
						<tr>
							<td>${textbook.id}</td>
							<td class="nowrap">${textbook.title}</td>
							<td>${textbook.subtitle}</td>
							<td><c:forEach var="author" items="${textbook.authors}"
									varStatus="status">
									<c:if test="${not empty author.firstName}">
						${author.firstName}&nbsp;</c:if>
									<c:if test="${not empty author.middleName}">${not empty author.middleName}&nbsp;</c:if>
									<c:if test="${not empty author.lastName}">${author.lastName}&nbsp;</c:if>
									<c:if test="${not empty author.suffix}">${author.suffix}</c:if>
									<c:if test="${not status.last}">,&nbsp;</c:if>
								</c:forEach></td>

							<td>${textbook.edition}</td>
							<td>${textbook.year}</td>
							<td><c:if test="${not empty textbook.length}">${textbook.length}&nbsp;pages</c:if></td>
							<td class="buttonsColumn"><form action="gotoUpdateRecord.do"
									method="GET">
									<input type="hidden" name="id" value="${textbook.id}" />
									<button type="submit" class="btn btn-secondary btn-sm">Update</button>
								</form>
								<form action="recordDeleted.do" method="POST">
									<button type="submit" class="btn btn-secondary btn-sm">Delete</button>
									<input type="hidden" name="id" value="${textbook.id}" />
								</form></td>
						</tr>
					</c:forEach>
				</table>
			</c:when>
			<c:otherwise>No results were found!</c:otherwise>
		</c:choose>
		<br />
		<form action="home.do">
			<button type="submit" class="btn btn-secondary">Return Home</button>
		</form>
	</div>
</body>
</html>