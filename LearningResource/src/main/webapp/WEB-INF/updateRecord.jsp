<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Record</title>
</head>
<body>
	<h2>Update a Record:</h2>
	<%-- TODO: Could dynamically bind type of record (textbook, journal, etc.) --%>
	<form action="recordUpdated.do" method="POST">
		<br />ID: ${textbook.id} <input type="hidden" name="id" value="${textbook.id}" />
		<br />Author: ${textbook.author} <input type="text" name="author" />
		<br />Title: ${textbook.title} <input type="text" name="title" />
		<br />Subtitle: ${textbook.subtitle} <input type="text" name="subtitle" />
		<br />Edition: ${textbook.edition} <input type="text" name="edition" />
		<br />Year: ${textbook.year} <input type="text" name="year" />
		<br />Length: ${textbook.year}<input type="text" name="length" />
		<input type="hidden" name="oldTitle" value="${textbook.title}" />		
		<br /><button type="submit">Submit</button>
	</form>

<form action="home.do"><button type="submit">Return Home</button></form>

</body>
</html>