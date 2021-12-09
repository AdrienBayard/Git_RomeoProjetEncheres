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

<title>Connexion</title>

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
<style>
.mdpIncorrect{
background-color : grey;

}
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
					<li><a href="/RomeoProjetEncheres/accueil">Accueil</a></li>
					<li><a href="/RomeoProjetEncheres/monprofil">Mon profil</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Acheter/ Vendre<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="/RomeoProjetEncheres/accueil">Acheter</a></li>
							<li><a href="/RomeoProjetEncheres/VENTE">Vendre</a></li>
						</ul></li>
					<li><a href="LIEN DECONNEXION">Déconnexion</a></li>
					<li class="active"><a class="btn"
						href="/RomeoProjetEncheres/connexion">SE CONNECTER</a></li>
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
			<li class="active">Accès utilisateur</li>
		</ol>

		<div class="row">

			<!-- Article main content -->
			<article class="col-xs-12 maincontent">
			<!--  	<header class="page-header">test</header> 
				<header>
					<h1 class="page-title">Connexion</h1>
					
				</header>-->

				<div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
					<div class="panel panel-default">
						<div class="panel-body">
							<h3 class="thin text-center">Veuillez vous identifier</h3>
							<p class="text-center text-muted">
								Bonjour, connectez vous afin de profiter de toutes nos
								opportunités. 
								<br>Il est nécessaire de vous <a href="/inscription">enregistrer</a>
								afin de pouvoir enchérir ou poster vos offres.

							</p>
							<hr>

					 		<form action="/RomeoProjetEncheres/connexionServlet" method="get">  
				
								<div class="top-margin">
									<label for="pseudo">Identifiant <span
										class="text-danger">*</span></label> <input type="text"
										class="form-control" id="pseudo" name="pseudo">
									<c:if test="${mdpValide != null && mdpValide == false}">
									<p class="mdpIncorrect">Identifiant(s) incorrect(s)</p>
									</c:if>
								</div>	
								

								<div class="top-margin">
									<label for="motDePasse">Mot de passe <span class="text-danger">*</span></label>
									<input type="password" class="form-control" id="motDePasse" name="motDePasse">
								</div>

							
								<div class="center-margin">
									<input type="checkbox" id="rememberme" name="rememberme">
									<label for="rememberme">Se souvenir de moi</label>
								</div>
								<hr>
									<div class="row">

									<div class="col-lg-12 text-center">
										<button class="btn btn-action" type="submit" id="connexion" name="connexion">Connexion</button>
									</div>
								</div>
							</form>
							<br>
							<form action="/RomeoProjetEncheres/inscription">
										<div class="col-lg-12 text-center">
										<button class="btn btn-action" type="submit">Créer un compte</button>
									</div>
							</form>
						</div>
					</div>

				</div>

			</article>
			<!-- /Article -->

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
<br><br><br></p>
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
								<a href="/RomeoProjetEncheres/accueil">Accueil</a> | <a href="/RomeoProjetEncheres/monprofil">Mon profil</a> | <a
									href="/RomeoProjetEncheres/accueil">Acheter</a> | <a href="PAGE DECONNEXION">Déconnexion</a>
								| <b><a href="/RomeoProjetEncheres/inscription">S'inscrire</a></b>
							</p>
						</div>
					</div>

					<div class="col-md-6 widget">
						<div class="widget-body">
							<p class="text-right">
AA
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