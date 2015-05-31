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
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/font-awesome.min.css">
<link rel="stylesheet" href="resources/css/forum.css">

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
			<div class="col-lg-12 text-center">
				<section id="unseen">
					<div class="container">
						<c:forEach items="${msg}" var="list" varStatus="i">
							<div class="row">
								<c:if test="${i.index%2 == 1}">
									<div class="col-sm-3"></div>
								</c:if>
								<div class="col-sm-5">
									<div class="panel panel-default">
										<div class="panel-heading">
											<strong>${list.username}</strong> <span>commented
												${list.postTime}</span>
										</div>

										<div class="panel-body">${list.msg}
											<form class="form-horizontal" role="form" method="post"
												action="like">
												<input type="hidden" name="id" value="${list.id}" />
												<c:if test="${sessionScope.user.canLike == true }">
													<button class="btn btn-sm btn-default like-btn active"
														type="submit" id="10">
														<span class="glyphicon glyphicon-thumbs-up"></span> <span
															class="text">Like</span> <span class="badge like-badge">${list.rating}</span>
												</c:if>
												<c:if test="${sessionScope.user.canLike == false }">
													<button class="btn btn-sm btn-default like-btn active"
														type="button" id="10">
														<span class="glyphicon glyphicon-thumbs-up"></span> <span
															class="text">Already Liked</span> <span class="badge like-badge">${list.rating}</span>
												</c:if>
												</button>
											</form>
										</div>
									</div>
									<!-- /panel panel-default -->
								</div>
							</div>
							<!-- /row -->
						</c:forEach>
					</div>
					<!-- /container -->
					<c:if test="${sessionScope.user != null}">

						<form class="form-horizontal" role="form" method="post"
							action="post">
							<div class="form-group">
								<label for="message" class="col-sm-2 control-label">Message</label>
								<div class="col-sm-10">
									<textarea class="form-control" rows="4" name="message"></textarea>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-10 col-sm-offset-2">
									<input id="msg_but" name="msg_but" type="hidden" value="ok">
									<input id="m" name="m" type="submit" value="Send"
										class="btn btn-primary">
								</div>
							</div>
						</form>
					</c:if>
				</section>
			</div>
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

