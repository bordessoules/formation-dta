<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="fr.pizzeria.model.Pizza"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
		<%
			List<Pizza> pizzas = (List<Pizza>) request.getAttribute("listePizzas");
			for (Pizza p : pizzas) {
		%>
		<tr>
			<td><%=p.getId()%></td>
			<td><%=p.getCode()%></td>
			<td><%=p.getNom()%></td>
			<td><%=p.getPrix()%></td>
			<td><%=p.getCategorie()%></td>
			<td><img alt="photo" src="<%=p.getUrlImage()%>"></td>
			<td><a href="edit?code=<%=p.getCode()%>"><button type="button">Editer</button></a></td>
			<td><a href="delete?code=<%=p.getCode()%>"><button type="button">Supprimer</button></a></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>