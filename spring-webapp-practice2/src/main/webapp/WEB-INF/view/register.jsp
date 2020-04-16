<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Page</title>
<style type="text/css">
table {
	margin: 0 auto;
}

.error {
	color: red;
}
</style>
</head>
<body>

	<c:if test="${isUpdateMode == false}">
		<h1 align="center">Add Patient!</h1>
	</c:if>
	<c:if test="${isUpdateMode == true}">
		<h1 align="center">Update Patient!</h1>
	</c:if>
	<form:form modelAttribute="customer" action="addCustomer" method="POST">
		<form:hidden path="id" />
		<table>
			<tr>
				<td>First Name : <form:input path="firstName" /></td>
				<td><form:errors path="firstName" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td>Last Name : <form:input path="lastName" />
				</td>
				<td><form:errors path="lastName" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td>Country : <form:select path="country">
						<c:if test="${isUpdateMode == false}">
							<form:option value="NONE" label="Select" />
						</c:if>
						<form:options items="${country}" itemLabel="countryName" />
					</form:select>
				</td>
			</tr>
			<tr>
				<td>Age : <form:input path="age" />
				</td>
				<td><form:errors path="age" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td>Email : <form:input path="email" />
				</td>
				<td><form:errors path="email" cssClass="error"></form:errors></td>
			</tr>
			<tr>

				<c:if test="${isUpdateMode == false}">
					<td><input type="submit" value="Register"></td>
				</c:if>
				<c:if test="${isUpdateMode == true}">
					<td><input type="submit" value="Update"></td>
				</c:if>
			</tr>
		</table>
	</form:form>

</body>
</html>