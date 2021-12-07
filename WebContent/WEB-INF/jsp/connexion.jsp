<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connexion</title>
</head>
<body>
	<!--- TODO Logo --->

	<%
		Boolean mdpValide = (Boolean) request.getAttribute("mdpValide");

	%>


	<form action="/Connexion/connexion" method="get">
		<label for="pseudo">Pseudo :</label> <input type="text" id="pseudo"
			name="pseudo"> <br> <label for="motDePasse">Mot
			de passe :</label> <input type="password" id="motDePasse" name="motDePasse">
		<br>
		<button type="submit" id="connexion" name="connexion">Connexion</button>
		<input type="checkbox" id="rememberme" name="rememberme"> <label
			for="rememberme">Se souvenir de moi</label> <br> <a
			href="/motDePasseOublie">Mot de passe oublié</a> <br>
	</form>
	<form action="/inscription">
		<button type="submit" id="inscription" name="inscription">Créer
			un compte</button>
	</form>

</body>
</html>