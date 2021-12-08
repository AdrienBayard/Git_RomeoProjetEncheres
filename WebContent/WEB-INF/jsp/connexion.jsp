<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connexion</title>
<link rel="stylesheet" href="CSS\connexion.css">
<style>
.mdpIncorrect{
background-color : grey;

}
</style>
</head>

<body>
	<!--- TODO Logo --->

	<c:if test="${mdpValide != null && mdpValide == false}">
		<p class="mdpIncorrect">Identifiant(s) incorrect(s)</p>
	</c:if>





	<form action="/RomeoProjetEncheres/connexionServlet" method="get">
		<label for="pseudo">Pseudo :</label> <input type="text" id="pseudo"
			name="pseudo"> <br> <label for="motDePasse">Mot
			de passe :</label> <input type="password" id="motDePasse" name="motDePasse">
		<br>
		<button type="submit" id="connexion" name="connexion">Connexion</button>
		<input type="checkbox" id="rememberme" name="rememberme"> <label
			for="rememberme">Se souvenir de moi</label> <br> <a
			href="/motDePasseOublie">Mot de passe oublié</a> <br>
	</form>
	<form action="/RomeoProjetEncheres/inscription">
		<button type="submit" id="inscription" name="inscription">Créer
			un compte</button>
	</form>

</body>
</html>