<%-- TODO: fix table formatting --%>
<%-- fix ugly author adding mechanism --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="head.jsp" />
<title>Create Record</title>
</head>
<body>
	<jsp:include page="nav.jsp" />
	<div class="container">
		<h2>Create a Record:</h2>
		<form action="recordCreated.do" method="POST">
			Title: <input type="text" name="title" /> <br /> Subtitle: <input
				type="text" name="subtitle" /> <br /> Author: First Name: <input
				type="text" name="firstName" /> Middle Name: <input type="text"
				name="middleName" /> Last Name: <input type="text" name="lastName" />
			Suffix: <input type="text" name="suffix" /> <br /> Edition: <input
				type="text" name="edition" /> Year: <input type="text" name="year" />
			Length: <input type="text" name="length" />
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
		<br />
		<form action="home.do">
			<button type="submit" class="btn btn-secondary">Return Home</button>
		</form>
	</div>
</body>
</html>