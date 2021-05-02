<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<meta charset="UTF-8">
<jsp:include page="head.jsp" />
<title>Learning Resource Tracker</title>
</head>

<body>
	<jsp:include page="nav.jsp" />
	<div class="container">
		<h1>Test</h1>

		<c:forEach var="a" items="${authors}">${a}</c:forEach>
	</div>
	
	<jsp:include page="foot.jsp" />
</body>
</html>