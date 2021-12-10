<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">


<title>Accueil</title>

<link rel="shortcut icon" href="assets/images/gt_favicon.png">

<link rel="stylesheet" media="screen"
	href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/font-awesome.min.css">

<!-- Custom styles for our template -->
<link rel="stylesheet" href="assets/css/bootstrap-theme.css"
	media="screen">
<link rel="stylesheet" href="assets/css/main.css">


    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
   <script>
        //  traduction : quand la radio d'ID achats est cliquée, lancer la fonction enableCheckBoxAchats et disableCheckBoxAchats si la radio ventes est cliquée.
        $(function () {
            enableCheckBoxAchats();
            $("#achats").click(enableCheckBoxAchats);
        });

        $(function () {
            disableCheckBoxAchats();
            $("#ventes").click(disableCheckBoxAchats);
        });

        // traduction : si la radio d'ID achats est cliquée; désactiver l'attribut "disabled" des checkbox de la classe ventes :> Les rendre cliquables
        function enableCheckBoxAchats() {
            $("input.achats").removeAttr("disabled");
        }

        function disableCheckBoxAchats() {
            $("input.achats").prop("disabled", true);
            $("input.achats").prop("checked", false);
        }
    </script>

    <script>
        // traduction : quand la radio d'ID ventes est cliquée, lancer la fonction enableCheckBoxVentes et
        // disableCheckBoxVentes si la radio ventes est cliquée.
        $(function () {
            enableCheckBoxVentes();
            $("#ventes").click(enableCheckBoxVentes);
        });

        $(function () {
            disableCheckBoxVentes();
            $("#achats").click(disableCheckBoxVentes);
        });

        // traduction : si la radio ventes est cliquée; désactiver l'attribut "disabled" des checkbox de la classe ventes :> Les rendre cliquables
        function enableCheckBoxVentes() {
            $("input.ventes").removeAttr("disabled");
        }

        // traduction : si la radio achats est cliquée; réactiver l'attribut "disabled" des checkbox de la classe ventes :> Les rendre incliquables
        function disableCheckBoxVentes() {
            $("input.ventes").prop("disabled", true);
            $("input.ventes").prop("checked", false);
        }

    </script>

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
	<script src="assets/js/html5shiv.js"></script>
	<script src="assets/js/respond.min.js"></script>
	<![endif]-->
<style>
</style>
</head>

<body>


	<div class="container-back">
		<!-- Fixed navbar -->
		<div class="navbar navbar-inverse navbar-fixed-top headroom">
			<div class="container">
				<div class="navbar-header">
					<!-- Button for smallest screens -->
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-collapse">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="index.html"><img
						src="assets/images/logo.png" alt="Progressus HTML5 template"></a>
				</div>
				<div class="navbar-collapse collapse">
					<ul class="nav navbar-nav pull-right">
					<li><a href="/RomeoProjetEncheres/XXXXXX">Enchères</a></li>
					<li><a href="/RomeoProjetEncheres/vendre">Vendre un article</a></li>					
					<li><a href="/RomeoProjetEncheres/modifier">Mon profil</a></li>					
						
						<li class="active"><a class="btn"
							href="/RomeoProjetEncheres/accueil">DECONNEXION (ajouter fctn)</a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
		<!-- /.navbar -->

		<header id="head" class="secondary"></header>

		<!-- container -->
		<div class="container">

			<ol class="breadcrumb">
				<li><a href="/RomeoProjetEncheres/accueil">Accueil</a></li>
			</ol>
		</div>
		<!-- /container -->

		<div class="container">
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="h-body text-center">
						<h2>Liste des enchères</h2>
					</div>

					<form class="rechercher">
						<div class="row">
							<div class="col-md-3 col-sm-6 highlight">
								<select name="cars" id="cars" class="form-control">
									<option value="Toutes">Toutes catégories</option>
									<option value="Informatique">Informatique</option>
									<option value="Ameublement">Ameublement</option>
									<option value="Vetements">Vetements</option>
									<option value="Sport&Loisirs">Sport et loisirs</option>
								</select>

							</div>
							<div class="col-md-6 col-sm-6 highlight">
								<div class="h-body text-center">
									<input class="form-control" type="search" id="rechercher"
										name="rechercher" placeholder="Chercher par nom d'article"
										aria-label="Rechercher dans le site">
								</div>
							</div>
							<div class="col-md-3 col-sm-6 highlight">
								<div class="h-body text-center">
									<button class="btn btn-action" type="submit">Rechercher</button>
								</div>
							</div>
						</div>


					<br> <br> 
				<!-- DEBUT MULTICHOIX -->	
				
		<div class="row">
						
            <div class="checkboxs">
                <!-- CASES FILTRE MES ACHATS -->
			<div class="col-md-2 col-sm-6"></div>
			<div class="col-md-3 col-sm-6">
			
                <input type="radio" id="achats" name="achatsOuVentes" value="achats" />
                <label for="achats"> Achats</label><br>
                <!--  ↑ si ce bouton est coché ↓ seront cochables grace au js -->

                <input type="checkbox" id="encheresOuvertes" name="encheresOuvertes" class=achats disabled
                    value="encheresOuvertes">
                <label for="encheresOuvertes"> Toutes les enchères ouvertes</label><br>
                <input type="checkbox" id="mesEncheres" name="mesEncheres" class=achats disabled value="mesEncheres">
                <label for="mesEncheres"> Mes enchères</label><br>
                <input type="checkbox" id="mesEncheresRemportees" name="mesEncheresRemportees" disabled class=achats
                    value="mesEncheresRemportees">
                <label for="mesEncheresRemportees"> Mes enchères remportées</label><br><br>
			</div>
			<div class="col-md-2 col-sm-6"></div>
                <!-- CASES FILTRE MES VENTES -->
			<div class="col-md-3 col-sm-6">
                <input type="radio" id="ventes" name="achatsOuVentes" value="ventes" />
                <label for="ventes">Mes ventes</label><br>
                <!--  ↑ si ce bouton est coché ↓ seront cochables grace au js -->

                <input type="checkbox" id="mesVentesEnCours" name="mesVentesEnCours" class="ventes" disabled
                    value="mesVentesEnCours">
                <label for="mesVentesEnCours"> Ventes en cours</label><br>
                <input type="checkbox" id="ventesNonDebutees" name="ventesNonDebutees" class="ventes" disabled
                    value="ventesNonDebutees">
                <label for="ventesNonDebutees"> Ventes non débutées</label><br>
                <input type="checkbox" id="ventesTerminees" name="ventesTerminees" class="ventes" disabled
                    value="ventesTerminees">
                <label for="ventesTerminees"> Ventes terminées</label><br><br>
                
             </div>   
			<div class="col-md-2 col-sm-6"></div>                
            </div>
			</div>
			
			
		<div class="row">
			<div class="col-md-5 col-sm-6"></div>                
			<div class="col-md-7 col-sm-6">                
            <input class="btn btn-action" type="submit" value="Valider" >	
            </div>
			<div class="col-md-0 col-sm-6 highlight"></div>                
            
            </div>

            
            
    					</form>					
            				
					</div>
					
					
					
				<!-- FIN MULTICHOIX -->	
				


					<div class="row">

						<div class="col-sm-1"></div>
						<div class="col-sm-10">

							<div class="cardperso col-sm-5">
								<div class="col-sm-5">
									<img class="card-img-bottom" src="IMG\miniature.jpg" alt=""
										title="">
								</div>
								<div class="col-sm-7">
									<div class="card">
										<div class="card-body">
											<h5 class="card-title">Un bouquin de dingue</h5>
											<p class="card-text">Description de votre lot.</p>
											<p class="card-text">
												Prix : 6€<br>
												<!-- prixVente -->
												Fin de l'enchère : 19/12/2021<br>
												<!-- dateFinEncheres-->
												Vendeur : tititoto44
												<!-- Utilisateur.pseudo-->
											</p>
											<a href="#" class="btn btn-primary">Enchérir</a>
										</div>
									</div>
								</div>
							</div>

							<div class="col-sm-2"></div>
							<div class="cardperso col-sm-5">
								<div class="col-sm-5">
									<img class="card-img-bottom" src="IMG\miniature.jpg" alt=""
										title="">
								</div>
								<div class="col-sm-7">
									<div class="card">
										<div class="card-body">
											<h5 class="card-title">Un bouquin de dingue 2</h5>
											<p class="card-text">Description de votre lot.</p>
											<p class="card-text">
												Prix : 64€<br>
												<!-- prixVente -->
												Fin de l'enchère : 21/12/2021<br>
												<!-- dateFinEncheres-->
												Vendeur : tititoto44
												<!-- Utilisateur.pseudo-->
											</p>
											<a href="#" class="btn btn-primary">Enchérir</a>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-sm-1"></div>
					</div>
					<br>
					<br>
					<br>

					<br>
					<br>
					<br>
				</div>
			</div>
		</div>





		<footer id="footer" class="top-space">

			<div class="footer1">
				<div class="container">
					<div class="row">

						<div class="col-md-3 widget">
							<h3 class="widget-title">Contact</h3>
							<div class="widget-body">
								<p>
									Votre numéro de téléphone<br> <a href="mailto:#">votreemail@mail.com</a><br>
									<br> 3 Rue Michael Faraday, Saint-Herblain, FRANCE
								</p>
							</div>
						</div>

						<div class="col-md-3 widget">
							<h3 class="widget-title">Suivez-nous</h3>
							<div class="widget-body">
								<p class="follow-me-icons clearfix">
									<a href=""><i class="fa fa-twitter fa-2"></i></a> <a href=""><i
										class="fa fa-dribbble fa-2"></i></a> <a href=""><i
										class="fa fa-github fa-2"></i></a> <a href=""><i
										class="fa fa-facebook fa-2"></i></a>
								</p>
							</div>
						</div>

						<div class="col-md-6 widget">
							<h3 class="widget-title">Texte présentation du site</h3>
							<div class="widget-body">
								<p>Description de votre entreprise en quelques lignes.</p>
								<p>
									<br> <br> <br>
								</p>
							</div>
						</div>

					</div>
					<!-- /row of widgets -->
				</div>
			</div>

			<div class="footer2">
				<div class="container">
					<div class="row">

						<div class="col-md-6 widget">
							<div class="widget-body">
								<p class="simplenav">
									<a href="/RomeoProjetEncheres/accueil">Accueil</a> | <b><a
										href="/RomeoProjetEncheres/inscription">S'inscrire</a></b> | <b><a
										href="/RomeoProjetEncheres/connexion">Se connecter</a></b>
								</p>
							</div>
						</div>

						<div class="col-md-6 widget">
							<div class="widget-body">
								<p class="text-right">AA</p>
							</div>
						</div>

					</div>
					<!-- /row of widgets -->
				</div>
			</div>
		</footer>





		<!-- JavaScript libs are placed at the end of the document so the pages load faster -->
		<script
			src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
		<script
			src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
		<script src="assets/js/headroom.min.js"></script>
		<script src="assets/js/jQuery.headroom.min.js"></script>
		<script src="assets/js/template.js"></script>
	</div>
</body>
</html>