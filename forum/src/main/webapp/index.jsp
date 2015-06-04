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

	<!-- Page Content -->
	<div class="container">
		<form class="form-sign form-horizontal" action="goto" method="get"
			autocomplete="off">
			<input type="hidden" value="${upperRootId.id}" name="id" id="id">
			<button type="submit" class="btn btn-primary">Up</button>
		</form>
		<div class="row">
			<div class="col-lg-6">
				<c:forEach items="${msg}" var="list">
					<div class="list-group">
						<c:if test="${list.id == 1}">
							<a href="edit?id=${list.id}" class="list-group-item">
								<h4 class="list-group-item-heading">${list.msg}</h4>
								<p class="list-group-item-text">${list.lastMsg}</p>
								<br>
							</a>
						</c:if>
						<c:if test="${list.id != 1}">
							<a href="goto?id=${list.id}" class="list-group-item">
								<h4 class="list-group-item-heading">${list.msg}</h4>
								<p class="list-group-item-text">${list.lastMsg}</p>
							</a>
						</c:if>
					</div>
				</c:forEach>
			</div>
		</div>
		<!-- /.row -->
		<c:if test="${sessionScope.user != null}">
			<button type="button" class="btn btn-info" data-toggle="collapse"
				data-target="#demo">Create new topic</button>
			<div id="demo" class="collapse">
				<form class="form-horizontal" role="form" method="post"
					action="post">
					<div class="form-group">
						<label for="message" class="col-sm-2 control-label">Title</label>
						<div class="col-sm-6">
							<textarea class="form-control" rows="1" name="message"></textarea>
						</div>
						<br>
						<div class="col-sm-1">
							<label for="isLast" class="col-sm-2 control-label">New
								Theme?</label>
						</div>
						<div class="col-sm-1">
							<input type="checkbox" aria-label="..." name="isLast">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-10 col-sm-offset-2">
							<input id="sub_br_but" name="sub_br_but" type="hidden" value="ok">
							<input id="m" name="m" type="submit" value="Send"
								class="btn btn-primary">
						</div>
					</div>
				</form>
			</div>
		</c:if>
	</div>

	</div>
	<!-- /.container -->

	<!-- jQuery Version 1.11.1 -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>


</body>

</html>

