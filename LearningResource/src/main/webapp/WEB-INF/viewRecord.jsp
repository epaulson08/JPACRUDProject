<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="head.jsp" />

<title>View Record</title>
</head>
<body>
	<div class="container">
		<jsp:include page="nav.jsp" />
		<h2>Record result:</h2>
		<c:choose>
			<c:when test="${empty textbook}">
				No such record could be found!
			</c:when>

			<c:otherwise>
				<table class="shadeRows">
					<tr>
						<th>ID</th>
						<th>Title</th>
						<th>Subtitle</th>
						<th>Author(s)</th>
						<th>Edition</th>
						<th>Year</th>
						<th>Length</th>
						<th></th>
					</tr>
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
								<br />
								<form action="gotoAddAuthor.do" method="GET">
									<button class="btn btn-secondary btn-sm">Add Author</button>
									<input type="hidden" name="textbookId" value="${textbook.id}" />
								</form>
							</c:forEach></td>
						<td>${textbook.edition}</td>
						<%-- TODO c:choose, when, otherwise to deal with null edition, year, length --%>
						<td>${textbook.year}</td>
						<td>${textbook.length}&nbsp;pages</td>
						<td class="buttonsColumn"><form action="gotoUpdateRecord.do"
								method="GET">
								<button type="submit" class="btn btn-secondary btn-sm">Update</button>
								<input type="hidden" name="id" value="${textbook.id}" />
							</form>
							<form action="recordDeleted.do" method="POST">
								<button type="submit" class="btn btn-secondary btn-sm">Delete</button>
								<input type="hidden" name="id" value="${textbook.id}" />
							</form></td>

					</tr>
				</table>
			</c:otherwise>
		</c:choose>
		<br />
		<form action="home.do">
			<button type="submit" class="btn btn-secondary">Return Home</button>
		</form>
	</div>
	<jsp:include page="foot.jsp" />
</body>
</html>