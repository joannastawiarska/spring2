<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Book</title>

<style>
h1 {
	font-size: 20px;
	font-family: Georgia;
	text-shadow: 5px 5px #ffffff;
	font-style: italic;
}

p {
	font-family: Courier New;
	font-size: 13px;
}

p.header {
	font-family: Courier New;
	font-size: 18px;
}

h3 {
	font-size: 25px;
	font-family: Georgia;
}

input {
	font-family: Courier New;
	font-size: 12px;
	background-color: #e7e7e7;
}
</style>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Book info</h1>
				<p class="header">This page contain info about book</p>
			</div>
		</div>
	</section>
	<section class="container text-center">
		<div class="row">
			<div class="col-md-12">
				<h3>${book.id}</h3>
				<p>
					<strong>Book title: </strong>${book.title}</span>
				</p>
				<p>
					<strong>Wrote by</strong>: ${book.authors}
				</p>
				
					<a href="<spring:url value="/books/all" />" class="btn btn-default">
						<span class="glyphicon-hand-left glyphicon"></span> Back to all books
					</a>

				

			</div>
		</div>
	</section>
</body>
</html>
