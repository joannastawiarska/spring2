<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Error 403</title>

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
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Error</h1>
				<p>${errorMessage}</p>
				<p>
					<a href="/webstore" class="btn btn-default"> <span
								class="glyphicon-info-sign glyphicon" /></span> Back to homepage
							</a>
				</p>
			</div>
		</div>
	</section>
</body>
</html>
