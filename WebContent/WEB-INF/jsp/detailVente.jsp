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

<title>Détail de la vente</title>

<link rel="shortcut icon" href="assets/images/gt_favicon.png">

<link rel="stylesheet" media="screen"
	href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/font-awesome.min.css">

<!-- Custom styles for our template -->
<link rel="stylesheet" href="assets/css/bootstrap-theme.css"
	media="screen">
<link rel="stylesheet" href="assets/css/main.css">

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
	<script src="assets/js/html5shiv.js"></script>
	<script src="assets/js/respond.min.js"></script>
	<![endif]-->


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
						<li><a href="/RomeoProjetEncheres/XXXXXX">Favoris</a></li>
						<li><a href="/RomeoProjetEncheres/modifier">Mon profil</a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">Acheter/ Vendre<b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="/RomeoProjetEncheres/connected">Acheter</a></li>
								<li><a href="/RomeoProjetEncheres/gestionarticle">Vendre</a></li>
							</ul></li>
						<li class="active"><a class="btn"
							href="/RomeoProjetEncheres/accueil">DECONNEXION</a></li>					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
		<!-- /.navbar -->
		
		
		

		<header id="head" class="secondary"></header>

		<!-- container -->
<div class="container">
			<div class="panel panel-default">
				<div class="panel-body">
	<div class="row">
		<div class="col-md-12">
			<h3 class="text-center">
				Détail de la vente
				<br>---Page dans WebContent à déplacer dans jsp ensuite---
			</h3>
			
		</div>
	</div>
	
	<div class="row">
		<div class="col-md-3">
			<img alt="" src="" />
		</div>
		
		
		<div class="col-md-6">
		<br>
		<label>Nom de l'article:  <!-- TODO  ${nomdelarticle.nomArticle}--></label><br><br>
		<label>Description: <!-- TODO  ${nomdelarticle.description}--></label><br>
		<label>Catégorie:  <!-- TODO  ${nomdelarticle.categorie}--></label><br><br>
		<label>Meilleure offre:  <!-- TODO  ${requestScope.offre}--> par <!-- TODO  ${requestScope.encherisseur}--></label><br>
		<label>Mise à prix:  <!-- TODO  ${nomdelarticle.miseAPrix}--></label><br>
		<label>Fin de l'enchère:  <!-- TODO  ${nomdelarticle.dateFinEncheres}--></label><br><br>
		<label>Retrait:  <!-- TODO${utilisateur.rue}--> </label><br>
		<label><!-- TODO  ${utilisateur.codePostal}--> <!-- TODO  ${utilisateur.ville}--></label><br><br>
		<label>Vendeur:  <!-- TODO  ${requestScope.vendeur}--></label><br><br>
		<label>Ma proposition:  <!-- TODO  ${requestScope.vendeur}--></label>
		<input id="" type="number" pattern="^[0-9]{100}$" placeholder="" step="1" min="1"><br><br> 
		<!-- TODO placeholder="${requestScope.derniereEnchere}"-->
		
		<div class="button text-center">		
				<a href="/RomeoProjetEncheres/connected"><button class="btn btn-action" form = "" name = "" value ="true">Enchérir</button></a>	
				<!-- TODO  REMPLIR FORM ET NAME avec? Adrien -->
			</div>
		</div>
		<div class="col-md-3">
			<img alt="" src="" />
		</div>
			
	</div>
	<br><br><br>
</div>
</div>
	</div>	
		
	
		<!-- /container -->


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