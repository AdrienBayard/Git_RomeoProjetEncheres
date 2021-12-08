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
	

	<form id="monprofil" action=" " method="get">
		<fieldset>
			<label>Pseudo: </label><label>get pseudo</label><br>
			<label>Nom: </label>
			<label>Prénom: </label>
			<label>Email: </label>
			<label>Teléphone: </label>
			<label>Rue: </label>
			<label>Code postal: </label>
			<label>Ville: </label>
		</fieldset>
		
		<div class="button">		
		<a href="/RomeoProjetEncheres/monprofil"><button type="submit" form="modifierProfil">Modifier</button></a>	
		</div>
	</form>
	
</body>
</html>