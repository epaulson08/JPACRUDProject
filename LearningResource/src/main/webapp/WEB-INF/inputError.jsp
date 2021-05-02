<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="head.jsp" />
<title>Input Error</title>
</head>
<body>
	<jsp:include page="nav.jsp" />
	<div class="container">
		<h2>There was a problem with your input.</h2>

		<form action="home.do" method="GET" class="btn btn-primary">
			<button type="submit" class="btn btn-secondary">Return Home</button>
		</form>
	</div>
	<jsp:include page="foot.jsp" />
</body>
</html>