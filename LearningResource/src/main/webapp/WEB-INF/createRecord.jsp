<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet" href="styles.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>

<title>Create Record</title>
</head>
<body>
	<div class="container">
		<h2>Create a Record:</h2>
		<%-- TODO: Could dynamically bind type of record (textbook, journal, etc.) --%>
		<form action="recordCreated.do" method="POST">
			<table>
				<tr>
					<td>Author:</td>
					<td><input type="text" name="author" />
				</tr>
				<tr>
					<td>Title:</td>
					<td><input type="text" name="title" />
				</tr>
				<tr>
					<td>Subtitle:</td>
					<td><input type="text" name="subtitle" /></td>
				</tr>
				<tr>
					<td>Edition:</td>
					<td><input type="text" name="edition" /></td>
				</tr>
				<tr>
					<td>Year:</td>
					<td><input type="text" name="year" /></td>
				</tr>
				<tr>
					<td>Length:</td>
					<td><input type="text" name="length" /></td>
				</tr>
			</table>
			<button type="submit" class="btn btn-primary">Submit</button></td>
		</form>
		<br />
		<form action="home.do">
			<button type="submit" class="btn btn-secondary">Return Home</button>
		</form>
	</div>
</body>
</html>