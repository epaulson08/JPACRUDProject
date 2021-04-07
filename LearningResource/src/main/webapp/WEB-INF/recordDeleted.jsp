<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="head.jsp" />

<title>Record Deleted</title>
</head>
<body>
	<jsp:include page="nav.jsp" />
	<div class="container">
		<h2>Record Deleted</h2>
		<p>"${textbook.title}" was successfully deleted.</p>
		<form action="home.do">
			<button type="submit" class="btn btn-secondary">Return Home</button>
		</form>
	</div>

</body>
</html>