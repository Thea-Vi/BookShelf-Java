<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/styles.css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<main>

		<div class="header">
			<h1>Welcome!</h1>
			<h4>Join our growing community.</h4>
		</div>

		<div class="form">

			<div class="register">
				<h3>Register</h3>
				<form:form action="/register" method="post" modelAttribute="newUser"
					class="">

					<div class="md-form form-group w-50">
						<form:label path="userName" class="form-control col-xs-3">User Name:</form:label>
						<form:errors path="userName" class="text-danger" />
						<form:input path="userName" class="col-xs-3" />
					</div>

					<div class="md-form form-group w-50">
						<form:label path="email" class="form-control">Email:</form:label>
						<form:errors path="email" class="text-danger" />
						<form:input path="email" />
					</div>

					<div class="md-form form-group w-50">
						<form:label path="password" class="form-control">Password:</form:label>
						<form:errors path="password" class="text-danger" />
						<form:input type="password" path="password" />
					</div>

					<div class="md-form form-group w-50">
						<form:label path="confirm" class="form-control">Confirm PW:</form:label>
						<form:errors path="confirm" class="text-danger" />
						<form:input type="password" path="confirm" />

					</div>

					<button class="btn btn-success">Register</button>
				</form:form>
			</div>

			<div class="login">
				<h3>Log In</h3>
				<form:form action="/login" method="post" modelAttribute="newLogin"
					class="">

					<div class="md-form form-group w-50">
						<label class="form-control col-xs-3">Email</label>
						<form:errors path="email" class="text-danger" />
						<form:input path="email" class="col-xs-3" />
					</div>

					<div class="md-form form-group w-50">
						<label class="form-control col-xs-3">Password:</label>
						<form:errors path="password" class="text-danger" />
						<form:input type="password" path="password" />
					</div>


					<button class="btn btn-primary">Login</button>
				</form:form>
			</div>
		</div>
	</main>

</body>
</html>