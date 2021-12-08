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
			<label>Nom: </label><input type="text" value="get nom"/></input><br>
			<label>Prénom: </label><input type="text" value="get prenom"/></input><br>
			<label>Email: </label><input type="text" value="get email"/></input><br>
			<label>Teléphone: </label><input type="text" value="get telephone"/></input><br>
			<label>Rue: </label><input type="text" value="get rue"/></input><br>
			<label>Code postal: </label><input type="text" value="get code_postal"/></input><br>
			<label>Ville: </label><input type="text" value="get ville"/></input><br>
		</fieldset>
		
		<div class="button">		
		<a href="/RomeoProjetEncheres/monprofil"><button type="submit" form="modifierProfil">Modifier</button></a>	
		</div>
	</form>
	
</body>
</html>