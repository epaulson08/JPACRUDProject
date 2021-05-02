<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="head.jsp" />

<title>View Records</title>
</head>
<body>
	<jsp:include page="nav.jsp" />
	<div class="container">
		<h2>Record results:</h2>
		<br />
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
	<jsp:include page="foot.jsp" />
</body>
</html>