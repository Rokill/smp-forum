<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!-- Collect the nav links, forms, and other content for toggling -->
<form role="form" method="post" class="navbar-form  navbar-left"
	action="auth">
	<div class="input-group">
		<span class="input-group-addon"><i
			class="glyphicon glyphicon-user"></i></span> <input id="name"
			class="form-control" name="name" value="" placeholder="User Name">
	</div>

	<div class="input-group">
		<span class="input-group-addon"><i
			class="glyphicon glyphicon-lock"></i></span> <input id="pass"
			type="password" class="form-control" name="pass" value=""
			placeholder="Password">
	</div>
	<button type="submit" class="btn btn-primary">Login</button>
</form>
<!-- /.navbar-collapse -->