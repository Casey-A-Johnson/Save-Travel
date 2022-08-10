<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css"> 
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
	<div class="container">
		<div class= "header">
			<h1>Save Travel</h1>
		</div>
		<div>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Expense</th>
						<th>Vendor</th>
						<th>Amount</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var = "expense" items = "${travelList}">
						<tr>
							<td><a href="/travel/${expense.id }"><c:out value="${expense.name }"/></a></td>
							<td><c:out value="${expense.vendor }"/></td>
							<td>$<c:out value="${expense.amount }"/></td>
							<td style="display: flex; gap: 10px;">
							 <a class = "btn btn-outline-warning" href= "/travel/edit/${expense.id}">Edit</a>
							 <form action = "/travel/delete/${expense.id }" method = "post">
								<input type= "hidden" name= "_method" value="delete"/>
								<button class="btn btn-outline-danger" type= "submit">Delete</button>
							 </form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="subheader">
				<h1>Add an Expense</h1>
			</div>
			<div class= "form">
				<form:form action = "/travel/add" method= "post" modelAttribute ="travelExpense" >
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
					<div class= "button">
						<button class="btn btn-primary" type= "submit">Submit</button>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>