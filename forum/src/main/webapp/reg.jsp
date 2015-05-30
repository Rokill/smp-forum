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

<title>Bare - Start Bootstrap Template</title>

<!-- Bootstrap Core CSS -->
<link rel="stylesheet"
	href="resources/css/bootstrap.min.css">
<!-- Custom javascript for password confirmation -->
<script type="text/javascript" src="resources/js/confirmPassword.js"></script>


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


	<!-- Navigation -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Forum</a>
			</div>
		</div>
		<!-- /.container -->
	</nav>

	<!-- Page Content -->
	<div class="container">
		<div class="row">
			<div class="col-lg-4"></div>
			<div class="col-lg-4 text-center">
				<form class="form-sign form-horizontal" action="reg" method="post"
					autocomplete="off">
					<h2 class="form-sign-heading">Please Sign Up</h2>
					<c:if test="${error == 'exist' }">
						<h5 class="form-sign-error-msg">User with that name already
							exist!</h5>
					</c:if>
					<h5 class="form-sign-error-msg">${requestScope.errorMessage}</h5>

					<div class="control-group">
						<div class="controls">

							<input type="text" id="inputUserName" name="userName"
								class="form-control" placeholder="User name" minlength="1"
								maxlength="40" required autofocus
								data-validation-required-message="Name is required" /> <br />
							<div class="control-group">
								<input type="password" id="password" name="password"
									class="form-control" placeholder="Password" maxlength="60"
									minlength="1" required
									data-validation-required-message="Password is required">
								<br />
								<%--<p class="help-block form-sign-error-msg"></p>--%>
							</div>
							<div class="control-group">
								<input type="password" id="confirPassword" name="confirPassword"
									<%--onkeyup="checkPass(); return false;"--%>
                       class="form-control"
									placeholder="Confirm Password" maxlength="60" minlength="1"
									required data-validation-match-match="password"
									data-validation-match-message="Password do not match"
									data-validation-required-message="Password with confirmation is required">
								<%--<br/>--%>
								<p class="help-block form-sign-error-msg"></p>
							</div>
							<%--<span id="confirmMessage" class="confirmMessage"></span>--%>
							<p class="help-block form-sign-error-msg"></p>
						</div>
						<button class="btn btn-lg btn-primary btn-block register"
							type="submit" name="register" id="register">Sign Up</button>

					</div>
				</form>
			</div>
			<div class="col-lg-4"></div>
		</div>
		<!-- /.row -->

	</div>
	<!-- /.container -->

	<!-- jQuery Version 1.11.1 -->
	<script src="resources/js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/jqBootstrapValidation.js"></script>

	<script>
		$(function() {
			$("input").not("[type=submit]").jqBootstrapValidation();
			$(".form-sign-error-msg").css("visibility", "visible");
		});
	</script>

</body>

</html>

