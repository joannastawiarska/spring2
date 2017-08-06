<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Hello</title>
<style>
h1 {
	font-size: 20px;
	font-family: Georgia;
	text-shadow: 5px 5px #ffffff;
	font-style: italic;
}

p {
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

<div style=" float:right; top:0; right:0;"><a href="<c:url value="/login" />"
					class="btn btn-success btn-mini">Login</a> </div>
<div style=" float:right; top:20px; right:0;"><a href="<c:url value="/j_spring_security_logout" />"
					class="btn btn-danger btn-mini">Logout</a> </div>


	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>${greeting}</h1>
				<p>${info}</p>
			</div>
		</div>
	</section>
	

	<section class="container text-center">
		<div class="row">
				<div class="thumbnail">
					<div class="caption">
					
					<h3>Search book</h3>
				<form action="books/search" method="GET">
					Title:<br>
					<input type="text" name="title">
					<br>
					Author:<br>
					<input type="text" name="authors">
					<br><br>
					<input type="submit" value="Find" 
         				name="Submit" id="frm1_submit" />
					
				</form>
						<h3>Or display all books</h3>
						
							<a href="/webstore/books/all" class="btn btn-default"> <span
								class="glyphicon-info-sign glyphicon" /></span> Show all books
							</a>
						
						
						
					</div>
				</div>
			</div>
	</section>
	
	
</body>
</html>
