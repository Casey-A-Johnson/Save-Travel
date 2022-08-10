<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>         
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Page</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css"> 
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
	<div class = "container">
		<div class="header" style="display: flex; justify-content: space-between; align-items: center;">
			<h1>Edit Expense</h1>
			<a class="btn btn-primary" href="/travel">Go Back</a>
		</div>
		<div style="margin-top: 20px;">
			<form:form action = "/process/edit/${expense.id}" method= "post" modelAttribute ="travelExpense" >
				<input type= "hidden" name="_method" value = "put"/>
				<div class= "mb-3">
					<form:label class="form-label" path="name">Expense</form:label>
					<form:input class="form-control" type= "text" path = "name"/>
					<div class="form-text">
						<form:errors class="errors" path = "name"/>
					</div>
				</div>
				<div class= "mb-3">
					<form:label class="form-label" path="vendor">Vendor</form:label>
					<form:input class="form-control" type= "text" path = "vendor"/>
					<div class="form-text">
						<form:errors class="errors" path = "vendor"/>
					</div>
					
				</div>
				<div class= "mb-3">
					<form:label path="amount">Amount</form:label>
					<form:input class="form-control" type= "number" path = "amount"/>
					<div class="form-text">
						<form:errors class="errors" path = "amount"/>
					</div>
				</div>
				<div class= "mb-3">
					<form:label path="description">Description</form:label>
					<form:textarea class="form-control" path = "description"></form:textarea>
					<div class="form-text">
						<form:errors class="errors" path = "description"/>
					</div>
				</div>
				<div>
					<button class="btn btn-primary" type= "submit">Submit</button>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>