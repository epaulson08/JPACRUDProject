<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Record Created</title>
</head>
<body>
<h3>You have successfully created: </h3>
${textbook.title} <%-- TODO I have hardcoded "textbook" but this could be generalized to "record" if reusing this page for different types of record creation --%>

</body>
</html>