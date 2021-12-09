<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class=header>

		ENI-ENCHERES <!-- TODO : Mettre le logo -->
	</div>
	

	<h1 style="text-align: center;">Mon profil</h1>

<%-- 	<div style="text-align: center;">

		<c:if test="${messageErreur != null && messageErreur == 1}">
			<p>le mot de passe et la confirmation doivent être identiques</p>
		</c:if>

		<c:if test="${messageErreur != null && messageErreur == 2}">
			<p>Pseudo déjà utilisé</p>
		</c:if>

		<c:if test="${messageErreur != null && messageErreur == 3}">
			<p>Mail déjà utilisé</p>
		</c:if>
		<c:if test="${messageErreur != null && messageErreur == 4}">
			<p>Le Pseudo et le mail sont déjà utilisés</p>
		</c:if>
	</div> --%>
	
	<form id="modificationprofil" action=""
		method="post">
		<!-- TODO : Lien vers l'accueil avec utilisateur -->
		<fieldset>
			<label>Pseudo: </label><input type="text" name="pseudo" pattern="^[A-Za-z0-9]*$" value="Pseudo" title="Vous ne pouvez utiliser que des lettres et des chiffres" required>
			<label>Nom:</label><input type="text" name="nom" value="Nom" required> 
			
			<br><br> 
			
			<label>Prénom: </label><input type="text" name="prenom" value="Prénom" required> 
			<label>Email: </label><input type="text" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" value="email@mail.fr" title="Ajoutez une adresse mail valide" required>
			
			<br> <br> 
			
			<label>Teléphone: </label> <input type="text" name="telephone" pattern="^[0-9]{10}$"  value="Téléphone" title="Une suite de 10 chiffres sans espaces" required> 
			<label>Rue: </label><input type="text" name="rue" value="Rue" required>
			
			<br> <br> 
			
			<label> Code postal:</label> <input type="text" name="codePostal" pattern="^[0-9]{5}$" value="Code Postal" title="Merci d'entrer un code postal valide" required> 
			<label>Ville: </label><input type="text" name="ville" value="Ville" required>
			
			<br> <br>
			
			<label>Mot de passe: </label> <input type="password" name="motDePasse" value="Mot de passe" required> 
			<label>Confirmation: </label> <input type="password" name="confirmation" value="Confirmation" required>
			
			<br> <br>
		</fieldset>
</body>
</html>