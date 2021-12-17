<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Sergey Pozhilov (GetTemplate.com)">
<meta http-equiv="refresh" content="300;url=/RomeoProjetEncheres/accueil" />

<title>Modifier son profil</title>

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
	<!-- ----------------------AJOUT NEW SUPER NAVBAR TOP------------------------- -->
    <link rel="stylesheet" type="text/css" href="assets/css/style.css">
   <!-- ----------------------AJOUT NEW SUPER NAVBAR BOT------------------------- -->
</head>

<body>

			<!-- ----------------------AJOUT NEW SUPER NAVBAR TOP------------------------- -->

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
				<a class="navbar-brand" href="/RomeoProjetEncheres/afficherConnected">
				<div class="logoRomeo">
				<img src="assets/images/logo.png" >
				</div>
				</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav "> <!-- pull-right -->
				
    <div class="navigation">
        <ul>
            <li class="list active">
                <a href="/RomeoProjetEncheres/afficherConnected">
                    <span class="icon">
                        <ion-icon name="home-outline"></ion-icon>
                    </span>
                    <span class="text">Enchères</span>
                </a>
            </li>
 			<li class="list">
                <a href="/RomeoProjetEncheres/vendre">
                    <span class="icon">
                        <ion-icon name="add-circle-outline"></ion-icon>
                    </span>
                    <span class="text">Ventes</span>
                </a>
            </li>
            <li class="list">
                <a href="/RomeoProjetEncheres/favoris.jsp">
                    <span class="icon">
                        <ion-icon name="star-outline"></ion-icon>
                    </span>
                    <span class="text">Favoris</span>
                </a>
            </li>

            <li class="list">
                <a href="/RomeoProjetEncheres/modifier">
                    <span class="icon">
                        <ion-icon name="person-outline"></ion-icon>
                    </span>
                    <span class="text">Mon Profil</span>
                </a>
            </li>
            <li class="list">
                <a href="/RomeoProjetEncheres/accueil">
                    <span class="icon"><ion-icon name="log-out-outline"></ion-icon>
                        
                    </span>
                    <span class="text">Deconnexion</span>
                </a>
            </li>
            
            <div class="indicator"></div>
        </ul>
    </div>
</ul>
	</div>
			<!--/.nav-collapse -->
		</div>
	</div>
	<!-- /.navbar -->
   <!-- ----------------------AJOUT NEW SUPER NAVBAR BOT------------------------- -->

	<header id="head" class="secondary"></header>

	<!-- container -->
	<div class="container">

		<br><ol class="breadcrumb">
			<li><a href="/RomeoProjetEncheres/accueil">Accueil</a></li>
			<li class="active">Modifier mon profil</li>
		</ol><br>
		
		
		
	<!-- /container AVEC BREADCRUMB -->

		<div class="row">

			<!-- Article main content -->
			<article class="col-xs-12 maincontent">


				<div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
					<div class="panel panel-default">
						<div class="panel-body">
							<h3 class="thin text-center">Modification de votre compte</h3>
							<p class="text-center text-muted">
								Si vous ne souhaitez pas modifier vos informations, veuillez suivre <a
									href="/RomeoProjetEncheres/connected">ce lien</a>.
							</p>
							<hr>
							<div style="text-align: center;">
								<c:if test="${messageErreur != null && messageErreur == 1}">
									<p class="text-center mdpIncorrect">le mot de passe et la confirmation doivent être identiques</p>
								</c:if>
						
								<c:if test="${messageErreur != null && messageErreur == 2}">
									<p class="text-center mdpIncorrect">Pseudo déjà utilisé</p>
								</c:if>
						
								<c:if test="${messageErreur != null && messageErreur == 3}">
									<p class="text-center mdpIncorrect">Mail déjà utilisé</p>
								</c:if>
								<c:if test="${messageErreur != null && messageErreur == 4}">
									<p class="text-center mdpIncorrect">Le Pseudo et le mail sont déjà utilisés</p>
								</c:if>
								<c:if test="${messageErreur != null && messageErreur == 5}">
									<p class="text-center mdpIncorrect">Le mot de passe actuel n'est pas le bon</p>
								</c:if>
								<c:if test="${messageErreur != null && messageErreur == 6}">
									<p class="text-center mdpIncorrect">Vous ne pouvez pas supprimer votre compte vous avez un article en vente</p>
								</c:if>
								<c:if test="${messageErreur != null && messageErreur == 7}">
									<p class="text-center mdpIncorrect">Vous ne pouvez pas supprimer votre compte vous avez une enchere en cours</p>
								</c:if>
							</div>
							
							
						<form id="modificationprofil" action="" method="post">

								<div class="top-margin">
									<label>Pseudonyme</label>
									<input class="form-control" type="text" name="pseudo" pattern="^[A-Za-z0-9]*$" value="${requestScope.pseudo}" title="Vous ne pouvez utiliser que des lettres et des chiffres" required>	
								</div>
								<div class="top-margin">
									<label>Nom de famille</label>
									<input class="form-control" type="text" name="nom" value="${requestScope.nom}" required> 
									
								</div>
								<div class="top-margin">
									<label>Prénom</label>
									<input class="form-control" type="text" name="prenom" value="${requestScope.prenom}" required> 

								</div>
								<div class="top-margin">
									<label>Email</label>
									<input class="form-control" type="text" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" value="${requestScope.email}" title="Ajoutez une adresse mail valide" required>

								</div>
								<div class="top-margin">
									<label>Numéro de téléphone</label>
									<input class="form-control" type="text" name="telephone" pattern="^[0-9]{10}$"  value="${requestScope.telephone}" title="Une suite de 10 chiffres sans espaces" required> 
									
								</div>
								<div class="top-margin">
									<label>Rue</label>
									<input class="form-control" type="text" name="rue" value="${requestScope.rue}" required>

								</div>
								
								<div class="row top-margin">
									<div class="col-sm-6">
										<label>Ville</label> 
										<input class="form-control" type="text" name="ville" value="${requestScope.ville}" required>

									</div>
									<div class="col-sm-6">
										<label>Code Postal</label>
										<input class="form-control" type="text" name="codePostal" pattern="^[0-9]{5}$" value="${requestScope.codePostal}" title="Merci d'entrer un code postal valide" required> 

									</div>
								</div>

								<div class="row top-margin">
									<div class="col-sm-12">
										<label>Mot de passe actuel</label> 
										<input class="form-control" type="password" name="motDePasseActuel" value="" required> 
								</div>
									</div>
								<div class="row top-margin">
									<div class="col-sm-6">
										<label>Nouveau mot de passe</label> 
										<input class="form-control" type="password" pattern="^[A-Za-z0-9]*$" name="nouveauMotDePasse" title="Pas de caractères spéciaux pour le mdp parce qu'on a pas le temps de le gérer. Merci" value=""> 

									</div>
									<div class="col-sm-6">
										<label>Confirmation</label>
										<input class="form-control" type="password" name="confirmation" value="">

									</div>
								</div>
								<div class="top-margin">
									<label>Crédits</label>
									<label class="form-control">${requestScope.credit}</label>
									
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
									
									<div class="button col-lg-6 text-center">
										<button class="btn btn-action" type="submit" form="modificationprofil" name="buttonModifierProfil" value = "modifier">Enregistrer</button>
									</div>
									<div class="col-lg-6 text-center"><a href="/RomeoProjetEncheres/accueil">
									<button class="btn btn-action" type="submit" form="modificationprofil" name="buttonModifierProfil" value = "supprimer">Supprimer</button></a>
									</div>
											<!-- TODO : Lien vers l'accueil sans utilisateur -->
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
								02 00 00 00 00<br> <a href="mailto:#">losna@mail.com</a><br>
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
						<h3 class="widget-title">Association: "Les objets sont nos amis"</h3>
						<div class="widget-body">
							<p>Utiliser notre site, c'est partager nos valeurs!</p>
							<p>&nbsp;&nbsp;- Nos idées neuves</p>
							<p>&nbsp;&nbsp;- Une appétence grandissante pour la réutilisation et le recyclage</p>
							<p>&nbsp;&nbsp;- Encourager la réutilisation, donner une seconde vie aux objets en facilitant les échanges</p>
							<p>&nbsp;&nbsp;- Permettre l'échange du plus grand nombre d'objets possible</p>
							<br>

						</div>
					</div>

				</div>
				<!-- /row of widgets -->
			</div>
		</div>

	</footer>





<!-- JavaScript libs are placed at the end of the document so the pages load faster -->
	
	    <script>
        const list = document.querySelectorAll('.list');
        function activeLink() {
            list.forEach((item) => item.classList.remove('active'));
            this.classList.add('active');
        }
        list.forEach((item) => item.addEventListener('mouseover', activeLink));


    </script>
    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
    
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