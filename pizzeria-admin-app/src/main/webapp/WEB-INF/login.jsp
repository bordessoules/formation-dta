<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">

<title>login</title>
</head>
<body>

	<form class="form-horizontal" method="post">
		<fieldset>

			<!-- Form Name -->
			<legend>Login</legend>


			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="login">login</label>
				<div class="col-md-4">
					<input id="login" name="login" type="text" placeholder="login"
						class="form-control input-md" required="">

				</div>
			</div>
			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="pass">mot de passe</label>
				<div class="col-md-4">
					<input id="pass" name="pass" type="password" placeholder="mot de passe"
						class="form-control input-md" required="">

				</div>
			</div>


			<!-- Button -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="singlebutton"></label>
				<div class="col-md-4">
					<button id="singlebutton" name="singlebutton" type="submit"
						class="btn btn-success">Editer</button>
				</div>
			</div>

		</fieldset>
	</form>
</body>
</html>