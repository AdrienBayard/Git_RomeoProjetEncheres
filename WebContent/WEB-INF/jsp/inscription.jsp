<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscription</title>
</head>
<link href="CSS\inscription.css" rel="stylesheet">
<body>
	<div class=header>

		ENI-ENCHERES <!-- TODO : Mettre le logo -->

	</div>
	<h1 style="text-align: center;">Mon profil</h1>
	
	<c:if test="${messageErreur != null && messageErreur == 1}">
	<p>Msg : le mdp et la confirmation doivent être identiques</p>
</c:if>

<c:if test="${messageErreur != null && messageErreur == 2}">
	<p>Msg : Pseudo déjà utilisé</p>
</c:if>

<c:if test="${messageErreur != null && messageErreur == 3}">
	<p>Msg : Mail déjà utilisé</p>
</c:if>
<c:if test="${messageErreur != null && messageErreur == 4}">
	<p>Msg : Le Pseudo et le mail sont déjà utilisés </p>
</c:if>

	<form id="inscription" action="/RomeoProjetEncheres/connexionServlet" method="post">
		<!-- TODO : Lien vers l'accueil avec utilisateur -->
		<fieldset>
			<label>Pseudo: </label><input type="text" name="pseudo" required>
			<label>Nom:</label><input type="text" name="nom" required> <br>
			<br> <label>Prénom: </label><input type="text" name="prenom"
				required> <label>Email: </label><input type="text"
				name="email" required><br> <br> <label>Teléphone:
			</label> <input type="text" name="telephone" required> 
			<label>Rue:
			</label>
			<input type="text" name="rue" required><br> <br> 
			<label>Code
				postal:</label> <input type="text" name="codePostal" required> <label>Ville:
			</label><input type="text" name="ville" required><br> <br>
			<label>Mot de passe: </label><input type="password" name="motDePasse"
				required> <label>Confirmation: </label> <input
				type="password" name="confirmation" required><br> <br>
		</fieldset>
	
	<div class="button">
		<button type="submit" form="inscription">Créer</button>
		<a href="/RomeoProjetEncheres/accueil"><button>Annuler</button></a>
			<!-- TODO : Lien vers l'accueil sans utilisateur -->	
	</div>
	</form>




</body>
</html>