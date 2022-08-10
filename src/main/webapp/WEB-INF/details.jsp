<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core"%>      
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details Page</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css"> 
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
	<div class="container">
		<div class= "header" style="display: flex; justify-content: space-between; align-items: center;">
			<h1>Expense Details</h1>
			<a class="btn btn-primary" href="/travel">Go Back</a>
		</div>
		<div style="display:flex; gap: 20px;">
			<h3>Expense Name:</h3>
			<h4><c:out value="${oneTravelExpense.name }"></c:out></h4>
		</div>
		<div style="display:flex; gap: 20px;">
			<h3>Expense Description:</h3>
			<h3><c:out value="${oneTravelExpense.description }"></c:out></h3>
		</div>
		<div style="display:flex; gap: 20px;">
			<h3>Vendor:</h3>
			<h3><c:out value="${oneTravelExpense.vendor }"></c:out></h3>
		</div>
		<div style="display:flex; gap: 20px;">
			<h3>Amount Spent:</h3>
			<h3>$<c:out value="${oneTravelExpense.amount }"></c:out></h3>
		</div>
	</div>
</body>
</html>