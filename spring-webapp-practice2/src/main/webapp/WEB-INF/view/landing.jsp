<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome Page</title>
<style type="text/css">
table {
	margin: 0 auto;
	border-collapse: collapse;
}

th, td {
	padding: 10px 20px;
}
</style>
</head>
<body>

	<h1 align="center">Current Covid Patients</h1>
	<hr>

	<p align="center">
		<form:form action="/" method="GET">
			<h3 align="center">
				Search Customer By Name: <input type="text" name="name" value="${name}"> <input type="submit" value="Search"><br>
				Search Customer By Age:  <input type="text" name="age" value="${age}"> 
				<input type="submit" value="Search">

			</h3>
		</form:form>
	</p>

	<security:authorize access="hasRole('ADMIN')">
		<h2 align="center">
			<a href="${pageContext.request.contextPath}/register"> Add
				patient</a>
		</h2>
	</security:authorize>

	<table border="1">
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Country</th>
			<th>Age</th>
			<th>Email</th>
			<security:authorize access="hasRole('ADMIN')">
				<th>Modify</th>
			</security:authorize>
		</tr>
		<c:forEach var="temp" items="${customer}">

			<c:url var="updateLink"
				value="${pageContext.request.contextPath}/update">
				<c:param name="id" value="${temp.id}"></c:param>
			</c:url>

			<c:url var="deleteLink"
				value="${pageContext.request.contextPath}/delete">
				<c:param name="id" value="${temp.id}"></c:param>
			</c:url>

			<tr>
				<td>${temp.firstName}</td>
				<td>${temp.lastName}</td>
				<td>${temp.country.countryName}</td>
				<td>${temp.age}</td>
				<td>${temp.email}</td>
				<security:authorize access="hasRole('ADMIN')">
					<td><a href="${updateLink}">Update</a> | <a
						href="${deleteLink}">Delete</a></td>
				</security:authorize>
			</tr>
		</c:forEach>

	</table>
	
	<security:authorize access="hasRole('ADMIN')">
		<form:form action="${pageContext.request.contextPath}/logout"
			method="POST">
			<p align="center">
				<input type="submit" value="LOGOUT">
			</p>
		</form:form>
	</security:authorize>

	<security:authorize access="!hasRole('ADMIN')">
		<h3 align="center">
			<a href="/showMyLoginPage">Manage </a><i></i>
		</h3>
	</security:authorize>

</body>
</html>