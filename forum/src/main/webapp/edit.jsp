<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Forum</title>

<!-- Bootstrap Core CSS -->
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/font-awesome.min.css">

<!-- Custom CSS -->
<style>
body {
	padding-top: 70px;
	/* Required padding for .navbar-fixed-top. Remove if using .navbar-static-top. Change if height of navigation changes. */
}
</style>

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<jsp:include page="partials/nav.jsp"></jsp:include>

	<div class="container">
		<div class="row">
			<div class="col-lg-4"></div>
			<div class="col-lg-4 text-center">
				<form class="form-sign form-horizontal" action="edit" method="post"
					autocomplete="off">
					<h2 class="form-sign-heading">Name Editing</h2>
					<h5 class="form-sign-error-msg">${requestScope.errorMessage}</h5>
					<div class="control-group">
						<div class="controls">
							<input type="text" name="name" class="form-control"
								placeholder="User name" minlength="1" maxlength="40" required
								autofocus data-validation-required-message="Name is required" />
							<br /> <input type="hidden" value="${id}" name="id">
							<button class="btn btn-lg btn-primary btn-block register"
								type="submit" name="register" id="register">Edit Name</button>
						</div>
				</form>
			</div>
			<div class="col-lg-4"></div>
		</div>
		<!-- /.row -->

	</div>
	<!-- /.container -->


	<!-- jQuery Version 1.11.1 -->
	<script src="/resources/js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="/resources/js/bootstrap.min.js"></script>
	
</body>

</html>

