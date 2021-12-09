<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mon profil</title>
</head>
<link href="CSS\profil.css" rel="stylesheet">
<body>
<div class=header>

		ENI-ENCHERES <!-- TODO : Mettre le logo -->
	</div>
	
	<% %>
	

	<form id="monprofil" action=" " method="get">
		<fieldset>
			<label>Pseudo: </label><label>${requestScope.pseudo}</label><br>
			<label>Nom: </label><label>${requestScope.nom}</label><br>
			<label>Prénom: </label><label>${requestScope.prenom}</label><br>
			<label>Email: </label><label>${requestScope.email}</label><br>
			<label>Teléphone: </label><label>${requestScope.telephone}</label><br>
			<label>Rue: </label><label>${requestScope.rue}</label><br>
			<label>Code postal: </label><label>${requestScope.codePostal}</label><br>
			<label>Ville: </label><label>${requestScope.ville}</label><br>
		</fieldset>
		
		<div class="button">		
		<a href="/RomeoProjetEncheres/modifierprofil"><button type="submit" name = "button" value = "true">Modifier</button></a>	
		</div>
	</form>
	
</body>
</html>