<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Accueil</title>

<link rel="stylesheet" href="CSS\accueil.css">

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">



</head>


<body>
	<div class=header>
		ENI-ENCHERES
		<!--TODO: logo à la place-->
		:
		<div class="boutons">
			<a href="/RomeoProjetEncheres/inscription">s'inscrire</a> | <a href="/RomeoProjetEncheres/connexion">se connecter</a>
		</div>
	</div>
	<div class="container">
		<div class="titre">
			<h2>Liste des enchères :</h2>
		</div>
		<form class="rechercher">
			<br> filtres : <br> <input type="rechercher"
				id="rechercher" name="rechercher"
				placeholder="Chercher par nom d'article"
				aria-label="Rechercher dans le site">
			<button>Search</button>

			<br> <select name="cars" id="cars">
				<option value="Toutes">Toutes</option>
				<option value="Informatique">Informatique</option>
				<option value="Ameublement">Ameublement</option>
				<option value="Vetements">Vetements</option>
				<option value="Sport&Loisirs">Sport&Loisirs</option>
			</select>
		</form>
		<br> <br>
		<div class="row">
			<div class="col-xl-6 col-lg-6 col-sm-12" style="width: 18rem;">
				<img src="IMG\miniature.jpg" class="miniature" alt="miniature">
				<div class="card-body">

					<p class="card-text">
						Un bouquin de dingue
						<!--nomArticle-->
						<br> Prix : 6€
						<!-- prixVente -->
						<br> Fin de l'enchère : 19/12/2021
						<!-- dateFinEncheres-->
						<br> Vendeur : tititoto44
						<!-- Utilisateur.pseudo-->
					</p>
				</div>
			</div>
			<div class="col-xl-6 col-lg-6 col-sm-12" style="width: 18rem;">
				<img src="IMG\miniature.jpg" class="miniature" alt="miniature">
				<div class="card-body">
					<p class="card-text">
						Un deuxième bouquin de dingue
						<!--nomArticle-->
						<br> Prix : 6€
						<!-- prixVente -->
						<br> Fin de l'enchère : 19/12/2021
						<!-- dateFinEncheres-->
						<br> Vendeur : tititoto44
						<!-- Utilisateur.pseudo-->
					</p>
				</div>
			</div>
		</div>
	</div>

	<footer> </footer>

</body>

</html>