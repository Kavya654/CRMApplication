<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<style type="text/css">
table {
	margin: 0 auto;
}
</style>
</head>
<body>

	<h2 align="center">Login</h2>

	<form:form action="${pageContext.request.contextPath}/authenticateTheUser"
		method="POST">
		
		<c:if test="${param.error != null}">
			Invalid Username / Password
		</c:if>

		<table>
			<tr>
				<td>User Name :<input type="text" name="username"></td>
			</tr>
			<tr>
				<td>Password : <input type="password" name="password"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
		
	</form:form>


</body>
</html>