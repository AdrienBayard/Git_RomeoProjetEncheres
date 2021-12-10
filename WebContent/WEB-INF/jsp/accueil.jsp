<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="eni.fr.javaee.projet.bll.UtilisateurManager" %>
<%@ page import="eni.fr.javaee.projet.bo.ArticleVendu" %>   
<%@ page import="java.util.List" %>   
<%@ page import="java.util.ArrayList" %>  

<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

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
						<li class="active"><a class="btn"
							href="/RomeoProjetEncheres/inscription">S'INSCRIRE</a></li>
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

					</form>


					<br> <br> <br> <br>

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
											<h5 class="card-title">Un bouquin de dingue 3</h5>
											<p class="card-text">Description de votre lot.</p>
											<p class="card-text">
												Prix : 63€<br>
												<!-- prixVente -->
												Fin de l'enchère : 23/12/2021<br>
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
											<h5 class="card-title">Un bouquin de dingue 4</h5>
											<p class="card-text">Description de votre lot.</p>
											<p class="card-text">
												Prix : 67€<br>
												<!-- prixVente -->
												Fin de l'enchère : 24/12/2021<br>
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
				</div>
			</div>
		</div>

------------------------------- FOR EACH GENERATION DES ARTICLES ---------------------------

<%
List<ArticleVendu> listeArticles = (List<ArticleVendu>)request.getAttribute("listeArticles");  

for(ArticleVendu article : listeArticles){ %>
	<div class="cardperso col-sm-5">
	<div class="col-sm-5">
		<img class="card-img-bottom" src="IMG\miniature.jpg" alt=""
			title="">
	</div>
	<div class="col-sm-7">
		<div class="card">
			<div class="card-body">
				<h5 class="card-title"> <%= article.getNomArticle()%> </h5>
				<p class="card-text"><%= article.getDescription()%></p>
				<p class="card-text">
					<%= article.getPrixVente()%><br>
					<!-- prixVente -->
					<%= article.getDateFinEncheres()%><br>
					<!-- dateFinEncheres-->
					<%= UtilisateurManager.getInstance().afficherProfilAvecId(article.getNo_utilisateur()).getNom()%>
					<!-- Utilisateur.pseudo-->
				</p>
				<a href="#" class="btn btn-primary">Enchérir</a>
			</div>
		</div>
	</div>
</div>
<% } %>




<%-- <c:forEach var="article" items="${requestScope.listeArticles}" begin="0">
    <div class="cardperso col-sm-5">
								<div class="col-sm-5">
									<img class="card-img-bottom" src="IMG\miniature.jpg" alt=""
										title="">
								</div>
								<div class="col-sm-7">
									<div class="card">
										<div class="card-body">
											<h5 class="card-title"><a href=""<c:out value="${article.nom()}" />></a></h5>
											<p class="card-text"><c:out value="${article.description()}" /></p>
											<p class="card-text">
												<c:out value="${article.prix}"/><br>
												<!-- prixVente -->
												<c:out value="${article.dateFinEncheres}"/><br>
												<!-- dateFinEncheres-->
									
									
 %>
										<%  %>
												<a href=""><c:out value="${UtilisateurManager.getInstance().afficherProfilAvecId(article.No_utilisateur()).getNom()}"/></a>
												<!-- Utilisateur.pseudo-->
											</p>
											<a href="#" class="btn btn-primary">Enchérir</a>
										</div>
									</div>
								</div>
							</div>
    
</c:forEach>> --%>




------------------------------- CARDS ---------------------------

<!-- 

<div class="cardperso col-sm-5">
								<div class="col-sm-5">
									<img class="card-img-bottom" src="IMG\miniature.jpg" alt=""
										title="">
								</div>
								<div class="col-sm-7">
									<div class="card">
										<div class="card-body">
											<h5 class="card-title">Un bouquin de dingue 3</h5>
											<p class="card-text">Description de votre lot.</p>
											<p class="card-text">
												Prix : 63€<br>
												prixVente
												Fin de l'enchère : 23/12/2021<br>
												dateFinEncheres
												Vendeur : tititoto44
												Utilisateur.pseudo
											</p>
											<a href="#" class="btn btn-primary">Enchérir</a>
										</div>
									</div>
								</div>
							</div>

 -->


--------------------------------------------------------------------------------------------



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