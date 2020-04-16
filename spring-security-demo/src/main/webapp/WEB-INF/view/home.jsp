<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Luv2code Company Home Page</title>
</head>
<body>

	<h2>Luv2code Company Home Page - YooHoo!! - silly goose</h2>
	<hr>

	welcome to the Luv2code Company Home Page!

	<br>
	<br>

	<p>
		User Id :
		<security:authentication property="principal.username" />
		<br> <br> User Role :
		<security:authentication property="principal.authorities" />
	</p>


	<hr>
	<security:authorize access="hasRole('MANAGER')">
		<p>
			<a href="${pageContext.request.contextPath}/leaders">Managers
				Meeting</a>(only for managers)
		</p>
	</security:authorize>
	<hr>
	<security:authorize access="hasRole('ADMIN')">
		<p>
			<a href="${pageContext.request.contextPath}/systems">Admin
				Meeting</a>(only for admins)
		</p>
	</security:authorize>

	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">

		<input type="submit" value="LOGOUT">

	</form:form>

</body>
</html>