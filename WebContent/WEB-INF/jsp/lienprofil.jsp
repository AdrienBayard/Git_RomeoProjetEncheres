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
	

	<form id="lienprofil" action=" " method="get">
		<fieldset>
			<label>Pseudo: </label><input type="text"
						class="form-control" id="pseudo" value="${requestScope.pseudo}" readonly="readonly"></div><br>
			<label>Code postal: </label><input type="text"
						class="form-control" id="pseudo" value="${requestScope.codePostal}" readonly="readonly"><br>
			<label>Ville: </label><input type="text"
						class="form-control" id="pseudo" value="${requestScope.ville}" readonly="readonly"><br>
		</fieldset>
	</form>
	
	<div>
	
		TODO : Les ventes en cours du vendeur (A faire une fois que le modèle Bootstrap aura été importée). 
		
	</div>
	
</body>
</html>