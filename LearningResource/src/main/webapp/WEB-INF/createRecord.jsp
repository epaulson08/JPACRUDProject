<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Record</title>
</head>
<body>

	<h2>Create a Record:</h2>
	<%-- TODO: Could dynamically bind type of record (textbook, journal, etc.) --%>
	<form action="recordCreated.do" method="POST">
		<br />Title: <input type="text" name="title" />
		<br />Author: <input type="text" name="author" />
		<br /> <%-- TODO: Add other fields --%>
		<br /><button type="submit">Submit</button>
	</form>


</body>
</html>