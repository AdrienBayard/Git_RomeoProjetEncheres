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
<meta http-equiv="refresh" content="300;url=/RomeoProjetEncheres/accueil" />

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
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- ----------------------AJOUT NEW SUPER NAVBAR TOP------------------------- -->
<link rel="stylesheet" type="text/css" href="assets/css/style.css">
<!-- ----------------------AJOUT NEW SUPER NAVBAR BOT------------------------- -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
    //  traduction : quand la radio d'ID achats est cliquée, lancer la fonction enableCheckBoxAchats et disableCheckBoxAchats si la radio ventes est cliquée.
    $(function() {
        enableCheckBoxAchats();
        $("#achats").click(enableCheckBoxAchats);
    });
    $(function() {
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
    $(function() {
        enableCheckBoxVentes();
        $("#ventes").click(enableCheckBoxVentes);
    });
    $(function() {
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
					<a class="navbar-brand"
						href="/RomeoProjetEncheres/afficherConnected">
						<div class="logoRomeo">
							<img src="assets/images/logo.png">
						</div>
					</a>
				</div>
				<div class="navbar-collapse collapse">
					<ul class="nav navbar-nav ">
						<!-- pull-right -->
						<div class="navigation">
							<ul>
								<li class="list active"><a
									href="/RomeoProjetEncheres/afficherConnected"> <span
										class="icon"> <ion-icon name="home-outline"></ion-icon>
									</span> <span class="text">Enchères</span>
								</a></li>
								<li class="list"><a href="/RomeoProjetEncheres/vendre">
										<span class="icon"> <ion-icon name="add-circle-outline"></ion-icon>
									</span> <span class="text">Ventes</span>
								</a></li>
								<li class="list"><a href="/RomeoProjetEncheres/favoris.jsp">
										<span class="icon"> <ion-icon name="star-outline"></ion-icon>
									</span> <span class="text">Favoris</span>
								</a></li>
								<li class="list"><a href="/RomeoProjetEncheres/modifier">
										<span class="icon"> <ion-icon name="person-outline"></ion-icon>
									</span> <span class="text">Mon Profil</span>
								</a></li>
								<li class="list"><a href="/RomeoProjetEncheres/accueil">
										<span class="icon"><ion-icon name="log-out-outline"></ion-icon>
									</span> <span class="text">Deconnexion</span>
								</a></li>
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
			<br>
			<ol class="breadcrumb">
				<li><a href="/RomeoProjetEncheres/afficherConnected">Accueil</a></li>
				<li class="active">Liste des enchères</li>
			</ol>
			<br>
			<!-- /container AVEC BREADCRUMB -->
		</div>
		<div class="container">
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="h-body text-center">
						<h2>Liste des enchères</h2>
					</div>
					<!-- ---------------- DEBUT DU FOMULAIRE ------------- -->
					<form class="rechercher"
						action="/RomeoProjetEncheres/afficherConnected" method="post">
						<div class="row">
							<div class="col-md-3 col-sm-6 highlight">
								<select name="cars" id="cars" class="form-control">
									<option value="Toutes">Toutes catégories</option>
									<option value="Informatique">Informatique</option>
									<option value="Ameublement">Ameublement</option>
									<option value="Vetement">Vetement</option>
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
									<input type="radio" id="achats" name="ventesAchats"
										value="achats" /> <label for="achats"> Achats</label><br>
									<!--  ↑ si ce bouton est coché ↓ seront cochables grace au js -->
									<input type="checkbox" id="encheresOuvertes"
										name="encheresOuvertes" class=achats disabled value="ON">
									<label for="encheresOuvertes"> Toutes les enchères
										ouvertes</label><br> <input type="checkbox" id="mesEncheres"
										name="mesEncheres" class=achats disabled value="ON"> <label
										for="mesEncheres"> Mes enchères</label><br> <input
										type="checkbox" id="mesEncheresRemportees"
										name="mesEncheresRemportees" disabled class=achats value="ON">
									<label for="mesEncheresRemportees"> Mes enchères
										remportées</label><br> <br>
								</div>
								<div class="col-md-2 col-sm-6"></div>
								<!-- CASES FILTRE MES VENTES -->
								<div class="col-md-3 col-sm-6">
									<input type="radio" id="ventes" name="ventesAchats"
										value="ventes" /> <label for="ventes">Mes ventes</label><br>
									<!--  ↑ si ce bouton est coché ↓ seront cochables grace au js -->
									<input type="checkbox" id="mesVentesEnCours"
										name="mesVentesEnCours" class="ventes" disabled value="ON">
									<label for="mesVentesEnCours"> Ventes en cours</label><br>
									<input type="checkbox" id="ventesNonDebutees"
										name="ventesNonDebutees" class="ventes" disabled value="ON">
									<label for="ventesNonDebutees"> Ventes non débutées</label><br>
									<input type="checkbox" id="ventesTerminees"
										name="ventesTerminees" class="ventes" disabled value="ON">
									<label for="ventesTerminees"> Ventes terminées</label><br>
									<br>
								</div>
								<div class="col-md-2 col-sm-6"></div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-5 col-sm-6"></div>
							<div class="col-md-7 col-sm-6">
								<input class="btn btn-action" type="submit" value="Valider">
							</div>
							<div class="col-md-0 col-sm-6 highlight"></div>
						</div>
					</form>
				</div>
				<!-- FIN MULTICHOIX -->
				<div class="mobile">
					<div class="row">
						<div class="col-sm-1"></div>
						<div class="col-sm-10">
							<c:forEach var="article" items="${requestScope.listeArticles}"
								begin="0">
								<div class="cardperso col-sm-5 ">
									<div class="col-sm-5">
										<img class="card-img-bottom" src="IMG\miniature.jpg" alt=""
											title="">
									</div>
									<div class="col-sm-7">
										<div class="cards">
											<div class="card-body">
												<h5 class="card-title">
													<a
														href="<c:url value="/achat"> <c:param name="trackingArticle" value="${article.noArticle}"/></a> </c:url>"><c:out
															value="${article.nomArticle}" /></a>
												</h5>
												<p class="card-text">
													<c:out value="${article.description}" />
												</p>
												<p class="card-text">
													<c:out value="Mise à prix : ${article.miseAPrix} crédits" />
													<br>
													<c:out
														value="Enchère : ${article.meilleurEnchere} crédits " />
													<br>
													<!-- prixVente -->
													<fmt:parseDate value="${ article.dateFinEncheres }"
														pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime"
														type="both" />
													<fmt:formatDate pattern="dd/MM/yyyy HH'h'mm"
														value="${ parsedDateTime }" />
													<br>
													<!-- dateFinEncheres-->
													<a
														href="<c:url value="/InfoVendeurServlet"> <c:param name="trackingVendeur" value="${article.pseudo}"/></a> </c:url>"><c:out
															value="${article.pseudo}" /></a>
													<!-- Utilisateur.pseudo-->
												</p>
												<a
													href="<c:url value="/achat">  <c:param name= "trackingArticle" value = "${article.noArticle }" /> </c:url>"
													class="
                                                btn btn-primary">Enchérir</a>
											</div>
										</div>
									</div>
									<div class="w-100"></div>
								</div>
								<c:if test="${listeArticles.indexOf(article) % 2 == 0}">
									<div class="col-sm-2"></div>
								</c:if>
							</c:forEach>
						</div>
						<div class="col-sm-1"></div>
					</div>
				</div>

				<div class="pc">

					<div class="lescartes">
						<c:forEach var="article" items="${requestScope.listeArticles}"
							begin="0">

							<div class="card">
								<div class="miniature">
									<img class="card-img-bottom" src="IMG\miniature.jpg" alt=""
										title="">
								</div>
								<div class="texte">
									<h4>
										<a
											href="<c:url value="/achat"> <c:param name="trackingArticle" value="${article.noArticle}"/></a> </c:url>"><c:out
												value="${article.nomArticle}" /></a>
									</h4>
									<p class="card-text">
										<c:out value="${article.description}" />
									</p>
									<p class="card-text">
										<c:out value="Mise à prix : ${article.miseAPrix} crédits" />
										<br>
										<c:out value="Enchère : ${article.meilleurEnchere} crédits " />
										<br>
										<!-- prixVente -->


										<fmt:parseDate value="${ article.dateFinEncheres }"
											pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
										<fmt:formatDate pattern="dd/MM/yyyy HH'h'mm"
											value="${ parsedDateTime }" />

										<br>

										<!-- dateFinEncheres-->

										<a style="text-decoration: none" class="userLink"
											href="<c:url value="/InfoVendeurServlet"> <c:param name="trackingVendeur" value="${article.pseudo}"/> </a> </c:url>"><c:out
												value="${article.pseudo}" /></a>
										<!-- Utilisateur.pseudo-->
									</p>
									<a
										href="<c:url value="/achat">  <c:param name= "trackingArticle" value = "${article.noArticle }" /> </c:url>"
										class="btn btn-primary">Enchérir</a>
                                               
								</div>
							</div>
						</c:forEach>
					</div>
				</div>



				<br> <br> <br> <br> <br> <br>
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
							<h3 class="widget-title">Association: "Les objets sont nos
								amis"</h3>
							<div class="widget-body">
								<p>Utiliser notre site, c'est partager nos valeurs!</p>
								<p>&nbsp;&nbsp;- Nos idées neuves</p>
								<p>&nbsp;&nbsp;- Une appétence grandissante pour la
									réutilisation et le recyclage</p>
								<p>&nbsp;&nbsp;- Encourager la réutilisation, donner une
									seconde vie aux objets en facilitant les échanges</p>
								<p>&nbsp;&nbsp;- Permettre l'échange du plus grand nombre
									d'objets possible</p>
								<br>
							</div>
						</div>
					</div>
					<!-- /row of widgets -->
				</div>
			</div>
		</footer>
	</div>
	<!-- JavaScript libs are placed at the end of the document so the pages load faster -->
	<script>
        const list = document.querySelectorAll('.list');
        function activeLink() {
            list.forEach((item) => item.classList.remove('active'));
            this.classList.add('active');
        }
        list.forEach((item) => item.addEventListener('mouseover', activeLink));
    </script>
	<script type="module"
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
	<script nomodule
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script
		src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
	<script src="assets/js/headroom.min.js"></script>
	<script src="assets/js/jQuery.headroom.min.js"></script>
	<script src="assets/js/template.js"></script>
</body>
</html>