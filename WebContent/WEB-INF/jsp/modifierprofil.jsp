<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
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

	<div style="text-align: center;">

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
		<c:if test="${messageErreur != null && messageErreur == 5}">
			<p>Le mot de passe actuel n'est pas le bon</p>
		</c:if>
	</div> 
	
	<form id="modificationprofil" action="" method="post">
		<!-- TODO : Lien vers l'accueil avec utilisateur -->
		<fieldset>
			<label>Pseudo: </label><input type="text" name="pseudo" pattern="^[A-Za-z0-9]*$" value="${requestScope.pseudo}" title="Vous ne pouvez utiliser que des lettres et des chiffres" required>
			<label>Nom:</label><input type="text" name="nom" value="${requestScope.nom}" required> 
			
			<br><br> 
			
			<label>Prénom: </label><input type="text" name="prenom" value="${requestScope.prenom}" required> 
			<label>Email: </label><input type="text" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" value="${requestScope.email}" title="Ajoutez une adresse mail valide" required>
			
			<br> <br> 
			
			<label>Teléphone: </label> <input type="text" name="telephone" pattern="^[0-9]{10}$"  value="${requestScope.telephone}" title="Une suite de 10 chiffres sans espaces" required> 
			<label>Rue: </label><input type="text" name="rue" value="${requestScope.rue}" required>
			
			<br> <br> 
			
			<label> Code postal:</label> <input type="text" name="codePostal" pattern="^[0-9]{5}$" value="${requestScope.codePostal}" title="Merci d'entrer un code postal valide" required> 
			<label>Ville: </label><input type="text" name="ville" value="${requestScope.ville}" required>
			
			<br> <br>
			<label>Mot de passe actuel: </label> <input type="password" name="motDePasseActuel" value="" required> 
			<label>Nouveau mot de passe: </label> <input type="password" name="nouveauMotDePasse" value=""> 
			<label>Confirmation: </label> <input type="password" name="confirmation" value="">
			
			<br> <br>
		</fieldset>
		<div class="button">
		<button type="submit" form="modificationprofil" name="enregistrer"> Enregistrer </button>
		<button type="submit" form="modificationprofil" name="supprimer"> Supprimer</button>
		<!-- TODO : Lien vers l'accueil sans utilisateur -->
</div>
	</form>
		

</body>
</html>