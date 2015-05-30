<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
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
		<c:if test="${sessionScope.user == null}">
			<jsp:include page="header.jsp"></jsp:include>
			<form role="form" method="get" class="navbar-form  navbar-right"
				action="reg">
				<button type="submit" class="btn btn-primary">Registration</button>
			</form>
		</c:if>
		<c:if test="${sessionScope.user != null}">
			<form role="form" method="get" class="navbar-form navbar-right"
				action="logout">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#"> <c:out
								value="${sessionScope.user.username}" /></a></li>
					<li><button type="submit" class="btn btn-primary">Logout</button></li>
				</ul>
			</form>
		</c:if>
	</div>
	<!-- /.container -->
</nav>