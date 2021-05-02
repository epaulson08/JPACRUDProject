<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="head.jsp" />
<title>Search by ID</title>
</head>
<body>
	<jsp:include page="nav.jsp" />
	<div class="container">
		<h2>Search for record by ID:</h2>
		<br />
		<form action="searchRecordByID.do">
			ID: <input type="text" name="id" /> <br />
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
	<jsp:include page="foot.jsp" />
</body>
</html>