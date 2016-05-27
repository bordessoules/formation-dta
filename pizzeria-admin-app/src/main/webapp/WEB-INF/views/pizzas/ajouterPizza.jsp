<%@page import="fr.pizzeria.model.CategoriePizza"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@page import="fr.pizzeria.model.Pizza"%>
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

<title>ajouter une pizza</title>
</head>
<body>
	<c:set var="pizza" scope="page" value="${pizza }" />

	<form class="form-horizontal" method="post">
		<fieldset>

			<!-- Form Name -->
			<legend>ajout de pizza</legend>


			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="code">code</label>
				<div class="col-md-4">
					<input id="nom" name="code" type="text"
						placeholder="nom de la pizza"
						class="form-control input-md" required="" disabled>

				</div>
			</div>


			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="nom">nom</label>
				<div class="col-md-4">
					<input id="nom" name="nom" type="text" 
						placeholder="nom de la pizza" class="form-control input-md"
						required="">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="prix">prix</label>
				<div class="col-md-4">
					<input id="prix" name="prix" type="text" placeholder="xx.xx"
						 class=" form-control
						input-md"
						required="">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="urlimage">URL
					image</label>
				<div class="col-md-4">
					<input id="urlimage" name="urlImage" type="text" placeholder="URL"
						class=" form-control
						input-md"
						required="">

				</div>
			</div>

			<!-- Select Basic -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="categorie">Categorie</label>
				<div class="col-md-4">
					<select id="categorie" name="categorie" class="form-control">
						<c:forEach var="c" items="${categories}">
							<option value="${c}">${c.libelle}</option>
						</c:forEach>
					</select>
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