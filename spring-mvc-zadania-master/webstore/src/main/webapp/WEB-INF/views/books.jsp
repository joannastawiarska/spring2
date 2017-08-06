<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Books</title>
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
				<h1>Books</h1>
				<p class="header">This page contains all informations about books</p>
			</div>
		</div>
	</section>

	<section class="container">
		<div class="row">
		<div class="text-center">${message}<br /><br /></div>
			<c:forEach items="${bookList}" var="book">
				<div class="col-sm-6 col-md-3 text-center" style="padding-bottom: 15px">
					<div class="thumbnail">
						<div class="caption">
							<h3>${book.id}</h3>
							<p>${book.title}</p>
							<p>${book.authors}</p>
							<p>Status: ${book.status}</p>
							
								<a
									href=" <spring:url value="/books/book/${book.id}" /> "
									class="btn btn-default"> <span
								class="glyphicon-info-sign glyphicon" /></span> Details
								</a>
								<a
									href=" <spring:url value="/books/delete/${book.id}" /> "
									class="btn btn-default"> <span
								class="glyphicon glyphicon-trash" /></span> Delete
								</a>
							

						</div>
						
					</div>
				</div>
			</c:forEach>
		
		</div>
	</section>
	<section class="container text-center">
	<a href="/webstore" class="btn btn-default"> <span
								class="glyphicon-info-sign glyphicon" /></span> Back to homepage
							</a>
							</section>
</body>
</html>
