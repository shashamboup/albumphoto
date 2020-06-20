<%@page import="beans.Utilistateur"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>creer album</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

/* Set height of the grid so .sidenav can be 100% (adjust as needed) */
.row.content {
	height: 450px
}

/* Set gray background color and 100% height */
.sidenav {
	padding-top: 20px;
	background-color: #f1f1f1;
	height: 100%;
}

/* Set black background color, white text and some padding */
footer {
	background-color: #555;
	color: white;
	padding: 15px;
}

/* On small screens, set height to 'auto' for sidenav and grid */
@media screen and (max-width: 767px) {
	.sidenav {
		height: auto;
		padding: 15px;
	}
	.row.content {
		height: auto;
	}
}
</style>
</head>

<body>
	<%
		Utilistateur utilisateur = (Utilistateur) session.getAttribute("utilisateur");
	%>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Logo</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li><a href="<c:url value='/acceuil'/>">Acceuil</a></li>
					<li><a href="<c:url value='/connexion'/>">Se connecter</a></li>
					<li><a href="<c:url value='/adduser'/>">S'inscrire</a></li>
					<li><a href="<c:url value='/creeralbum'/>">Voir les photos</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="<c:url value='/connexion'/>"><span
							class="glyphicon glyphicon-log-in"></span>Se connecter</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2 sidenav"></div>
			<div class="col-sm-8 text-left">
				<h1>Welcome</h1>
				<form method="post">
					<div class="form-group">
						<label for="inputNom">Nom de l'album</label> <input type="text"
							name="nomalbum" class="form-control" id="nom"
							placeholder="votre nom" required="required">
					</div>
					<div class="form-group">
						<label for="inputPrenom">Categorie</label> <select
							name="categorie">
							<option>vacance</option>
							<option>sport</option>
							<option>mariage</option>
							<option>anniversaire</option>
							<option>professional</option>
						</select>
					</div>
					<div class="form-group">
						<label for="type">Type</label> <select name="type">
							<option>Public</option>
							<option>Privé</option>
						</select>
					</div>
					<div class="form-group">
						<label for="proprietaire">nom du proprietaire </label> <input
							type="text" name="proprietaire" class="form-control"
							id="proprietaire" placeholder="proprietaite de l'album" 
							value="<%=utilisateur.getNom() + utilisateur.getPrenom()%>" required="required">
					</div>
					<div class="form-group">
						<label for="inputNom">Date creation</label> <input type="text"
							name="datecreation" class="form-control" id="datecreation"
							placeholder="votre nom" required="required">
					</div>

					<button class="btn btn-lg btn-primary btn-block text-uppercase"
						type="submit">Ajouter</button>
				</form>
			</div>
		</div>
		<div class="col-sm-2 sidenav">
		
		</div>
	</div>
	<footer class="container-fluid text-center">
		<p>@RAMA ET AICHA</p>
	</footer>
</body>
</html>