<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring MVC Demo</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>
<body>


	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>




	<div id="container">
		<div id="content">


			<input type="button" value="Add Customer"
				onclick="window.location.href='showFormForAdd' ; return false;"
				class="add-button">

			<form:form action="search" method="GET">
					Search Customer : <input type="text" name="searchByName">
				<input type="submit" value="Search" class="add-button">

			</form:form>



			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>


				<!-- temp.firstName is nothing but getter of firstname -->

				<c:forEach var="temp" items="${customers}">

					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${temp.id}"></c:param>
					</c:url>

					<c:url var="deleteLink" value="/customer/showFormForDelete">
						<c:param name="id" value="${temp.id}"></c:param>
					</c:url>

					<tr>
						<td>${temp.firstName}</td>
						<td>${temp.lastName}</td>
						<td>${temp.email}</td>
						<td><a href="${updateLink}">Update</a> |<a
							href="${deleteLink}"
							onclick="if(!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>

						</td>
					</tr>
				</c:forEach>

			</table>

		</div>


	</div>

</body>
</html>