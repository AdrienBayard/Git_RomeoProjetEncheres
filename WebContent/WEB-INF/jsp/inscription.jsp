<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Sergey Pozhilov (GetTemplate.com)">

<title>Inscription</title>

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
					<li><a href="/RomeoProjetEncheres/accueil">Accueil</a></li>

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
			<li class="active">Inscription</li>
		</ol>

		<div class="row">

			<!-- Article main content -->
			<article class="col-xs-12 maincontent">


				<div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
					<div class="panel panel-default">
						<div class="panel-body">
							<h3 class="thin text-center">Inscription de votre nouveau
								compte</h3>
							<p class="text-center text-muted">
								Si vous possédez déjà un compte, veuillez vous <a
									href="/RomeoProjetEncheres/connexion">connecter en suivant
									ce lien</a>.
							</p>
							<hr>
							<div style="text-align: center;">

								<c:if test="${messageErreur != null && messageErreur == 1}">
									<p>le mot de passe et la confirmation doivent être
										identiques</p>
								</c:if>

								<c:if test="${messageErreur != null && messageErreur == 2}">
									<p>Pseudo déjà utilisé</p>
								</c:if>

								<c:if test="${messageErreur != null && messageErreur == 3}">
									<p>Mail déjà utilisé</p>
								</c:if>
								<c:if test="${messageErreur != null && messageErreur == 4}">
									<p>Le Pseudo et le mail sont déjà utilisés</p>
								</c:if>
							</div>
							<form id="inscription"
								action="/RomeoProjetEncheres/connexionServlet" method="post">
								<div class="top-margin">
									<label>Pseudonyme</label>
									<input type="text" class="form-control" pattern="^[A-Za-z0-9]*$" title="Vous ne pouvez utiliser que des lettres et des chiffres" name ="pseudo" required>
								</div>
								<div class="top-margin">
									<label>Nom de famille</label>
									<input type="text" class="form-control" name="nom" required>
								</div>
								<div class="top-margin">
									<label>Prénom</label>
									<input type="text" class="form-control" name="prenom"required>
								</div>
								<div class="top-margin">
									<label>Email</label>
									<input type="text" class="form-control" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" title="Ajoutez une adresse mail valide" required>
								</div>
								<div class="top-margin">
									<label>Numéro de téléphone</label>
									<input type="text" class="form-control" name="telephone" pattern="^[0-9]{10}$" title="Une suite de 10 chiffres sans espaces" required>
								</div>
								<div class="top-margin">
									<label>Rue</label>
									<input type="text" class="form-control" name="rue" required>
								</div>
								
								<div class="row top-margin">
									<div class="col-sm-6">
										<label>Ville</label> 
										<input type="text" class="form-control" name="ville" required>
									</div>
									<div class="col-sm-6">
										<label>Code Postal</label>
										<input type="text" class="form-control" name="codePostal" pattern="^[0-9]{5}$"  title="Merci d'entrer un code postal valide" required>
									</div>
								</div>

								<div class="row top-margin">
									<div class="col-sm-6">
										<label>Mot de passe</label> 
										<input class="form-control" type="password" name="motDePasse" required>
									</div>
									<div class="col-sm-6">
										<label>Confirmation</label>
										<input class="form-control" type="password" name="confirmation" required>
									</div>
								</div>

								<hr>
</form>
								<div class="row">
					 			<!--  	<div class="col-lg-8">
										<label class="checkbox"> <input type="checkbox">
										Je confirme avoir lu et accepté les <a href="LienVersConditions">conditions d'utilisation</a>
										 du site.</label>
										 
									</div> 
									-->
									
									<div class="col-lg-6 text-center">
									<a href="/RomeoProjetEncheres/connected">
										<button class="btn btn-action" type="submit" form="inscription">Inscription</button>
										</a>
										</div>
									<div class="col-lg-6 text-center">
									<a href="/RomeoProjetEncheres/accueil">
									<button class="btn btn-action">Annuler</button></a>
									</div>
									

									
									
									
									
									
								</div>
							
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
								<br>
								<br>
								<br>
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
								<a href="/RomeoProjetEncheres/accueil">Accueil</a> | 
								<b><a
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