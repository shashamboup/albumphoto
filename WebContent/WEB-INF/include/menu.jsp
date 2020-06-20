<%@page pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<hr>
<ul class="nav navbar-nav">
	<li class="active"><a href="/albumPhoto">Acceuil</a></li>
	<li><a href="<c:url value='/conexion'/>">Se connecter</a></li>
	<li><a href="#">Voir les photos</a></li>
	<li><a href="#">S'inscrire</a></li>
</ul>
<hr>