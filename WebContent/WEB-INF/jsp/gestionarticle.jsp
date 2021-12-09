<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="" method="post">
	<label>Article : </label> <input type="text" name="nomArticle" required>
	<label>Description : </label><textarea rows="5" cols="30" id="Description" name="description" >
	<label>Catégorie : </label> <select name="categorie">
		<option value="" selected="true"> </option>
		<option value="Informatique"> Informatique</option>
		<option value="Ameublement"> Ameublement</option>
		<option value="Vetement"> Vetement</option>
		<option value="Sport et Loisirs"> Sport et Loisirs</option>	
	</select>
	
	<label>Mise à prix : </label> <input type="number" name="miseaprix" placeholder="100" required>
	<label>Début de l'enchêre : </label> <input type="datetime-local" name="debutenchere" placeholder="" required>
	<label>Fin de l'enchêre : </label> <input type="datetime-local" name="finenchere" placeholder="" required>
	
<fieldset>
    <legend> Retrait </legend>
  		<label>Rue : </label> <input type="text" name="nomArticle" value="Rue de l'utilisateur connecté -user.getRue" required>
  		<label>Code Postal : </label> <input type="text" name="nomArticle" value="Code Postal de l'utilisateur connecté -user.getCodePostal"required>
  		<label>Ville : : </label> <input type="text" name="nomArticle" value="Ville de l'utilisateur connecté -user.getVille" required>
  </fieldset>
	
</form>
</body>
</html>