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
			<table>
				<tr>
					<td>Title:</td>
					<td><input type="text" name="title" /></td>
				</tr>
				<tr>
					<td>Subtitle:</td>
					<td><input type="text" name="subtitle" /></td>
				</tr>
				<tr>
					<td>Author 1:</td>
					<td>First Name:</td>
					<td><input type="text" name="author1FirstName" />
					<td>Middle Name:</td>
					<td><input type="text" name="author1MiddleName" />
					<td>Last Name:</td>
					<td><input type="text" name="author1LastName" />
					<td>Suffix:</td>
					<td><input type="text" name="author1Suffix" />
				</tr>
				<tr>
					<td>Author 2:</td>
					<td>First Name:</td>
					<td><input type="text" name="author2FirstName" />
					<td>Middle Name:</td>
					<td><input type="text" name="author2MiddleName" />
					<td>Last Name:</td>
					<td><input type="text" name="author2LastName" />
					<td>Suffix:</td>
					<td><input type="text" name="author2Suffix" />
				</tr>
				<tr>
					<td>Author 3:</td>
					<td>First Name:</td>
					<td><input type="text" name="author3FirstName" />
					<td>Middle Name:</td>
					<td><input type="text" name="author3MiddleName" />
					<td>Last Name:</td>
					<td><input type="text" name="author3LastName" />
					<td>Suffix:</td>
					<td><input type="text" name="author3Suffix" />
				</tr>
				<tr>
					<td>Author 4:</td>
					<td>First Name:</td>
					<td><input type="text" name="author4FirstName" />
					<td>Middle Name:</td>
					<td><input type="text" name="author4MiddleName" />
					<td>Last Name:</td>
					<td><input type="text" name="author4LastName" />
					<td>Suffix:</td>
					<td><input type="text" name="author4Suffix" />
				</tr>
				<tr>
					<td>Author 5:</td>
					<td>First Name:</td>
					<td><input type="text" name="author5FirstName" />
					<td>Middle Name:</td>
					<td><input type="text" name="author5MiddleName" />
					<td>Last Name:</td>
					<td><input type="text" name="author5LastName" />
					<td>Suffix:</td>
					<td><input type="text" name="author5Suffix" />
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
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
		<br />
		<form action="home.do">
			<button type="submit" class="btn btn-secondary">Return Home</button>
		</form>
	</div>
</body>
</html>