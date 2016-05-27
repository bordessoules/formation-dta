<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="fr.pizzeria.model.Pizza"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>

<title>Liste des pizzas</title>
</head>
<body>

	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Code</th>
				<th>Nom</th>
				<th>Prix</th>
				<th>Categorie</th>
				<th>Image</th>
			</tr>
		</thead>
		
		<c:forEach var= "p" items="${listePizzas }">
		
		<tr id="tr-${p.code }">
			<td>${p.id }</td>
			<td>${p.code }</td>
			<td>${p.nom }</td>
			<td>${p.prix }</td>
			<td>${p.categorie }</td>
			<td><img alt="photo" src="${p.urlImage }"></td>
			<td><a href="edit?code=${p.code }"><button type="button">Editer</button></a></td>
			<td><button type="button" onclick="supprimer('${p.code }')">Supprimer</button></td>
		</tr>
		</c:forEach>
	</table>
	<script type="text/javascript">
	function supprimer(code){
		url = ' <%=request.getContextPath() %>/pizzas/delete'+"?code=" +code;
		alert(url);
		$.ajax({
			type : "DELETE",
			url : url,
			success :function(){
				$("#tr-"+code).remove();
			}
		})
	}
	
	</script>
</body>
</html>