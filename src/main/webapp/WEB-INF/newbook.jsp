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
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<h1>Add a Book to your Shelf</h1>
	<div>
		<a href="/home">Back to the shelves!</a>
	</div>
	<div>
		<form:form action="/books/create" method="post"
		
			modelAttribute="book">
			
			<div class="md-form form-group w-50">
				<form:label path="title" class="form-control col-xs-3">Title</form:label>
				<form:errors path="title" class="text-danger" />
				<form:input path="title"/>
			</div>
			<div class="md-form form-group w-50">
				<form:label path="author" class="form-control col-xs-3">Author</form:label>
				<form:errors path="author" class="text-danger" />
				<form:input path="author"/>
			</div>
			<div class="md-form form-group w-50"">
				<form:label path="thoughts" class="form-control col-xs-3">My Thoughts</form:label>
				<form:errors path="thoughts" class="text-danger" />
				<form:input path="thoughts"/>
			</div>
	
			<button>Submit</button>
		</form:form>




	</div>


</body>
</html>