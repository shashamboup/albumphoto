<%@page import="beans.Utilistateur"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifier Client</title>
<link rel="stylesheet" href="<c:url value='/css/myStyle.css'/>">

</head>
<body>
<h1>Modification d'un Utilisateur</h1>
   <%
		Utilistateur utilisateur = (Utilistateur)request.getAttribute("utilisateur");
		if (utilisateur == null) {
			out.print("L'utilisateur que vous souhaitez modifier n'existe pas !");
		} else {
	%>
	<form>
		<div class="form-group">
			<label for="inputAddress">NOM</label> <input type="text"
				class="form-control" id="nom" placeholder="votre nom">
		</div>
		<div class="form-group">
			<label for="inputAddress2">PRENOM</label> <input type="text"
				class="form-control" id="prenom" value="<%=utilisateur.getNom()%>"
				placeholder="votre prenom">
		</div>
		<div class="form-row">
			<div class="form-group col-md-6">
				<label for="inputEmail4">Login</label> <input type="text"
					class="form-control" value="<%=utilisateur.getLogin()%>" id="login" placeholder="login">
			</div>
			<div class="form-group col-md-6">
				<label for="inputPassword4">Password</label> <input type="password"
					class="form-control" value="<%=utilisateur.getPassword()%>" id="password" placeholder="Password">
			</div>
			<div class="form-group col-md-6">
				<label for="inputPassword4">privilege</label> <input type="text"
					class="form-control" value="<%=utilisateur.getPrivilege()%>" id="privilege" placeholder="privilege">
			</div>
		</div>
		
		<button type="submit" class="btn btn-primary">AJOUTER</button>
	</form>
<%
		}
	%>
</body>
</html> 