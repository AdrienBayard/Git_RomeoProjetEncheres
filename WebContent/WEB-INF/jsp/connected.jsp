<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Accueil</title>

    <link rel="stylesheet" href="CSS\accueil.css">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
        integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

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

</head>


<body>

    <!-- HEADER -->
    <div class=header>
        ENI-ENCHERES
        <!--TODO: logo à la place-->:
        <div class="boutons">
            <a href="">ENCHÈRES</a> | <a href="/RomeoProjetEncheres/gestionarticle">VENDRE UN ARTICLE </a> | <a href="/RomeoProjetEncheres/modifier">MON PROFIL </a> | <a
                href="accueil">DÉCONNEXION </a>
        </div>
    </div>


    <div class="container">

        <!-- TITRE -->
        <div class="titre">
            <h2>Liste des enchères :</h2>
        </div>

        <!-- FILTRE -->
        <form class="rechercher">
            <br>
            filtres : <br>
            <input type="rechercher" id="rechercher" name="rechercher" placeholder="Chercher par nom d'article"
                aria-label="Rechercher dans le site">
            <button>Search</button>

            <br>

            <select name="cars" id="cars">
                <option value="Toutes">Toutes</option>
                <option value="Informatique">Informatique</option>
                <option value="Ameublement">Ameublement</option>
                <option value="Vetements">Vetements</option>
                <option value="Sport&Loisirs">Sport&Loisirs</option>
            </select>
            <br>
            <br>

            <div class="checkboxs">
                <!-- CASES FILTRE MES ACHATS -->

                <input type="radio" id="achats" name="achatsOuVentes" value="achats" />
                <label for="achats"> Achats</label><br>
                <!--  ↑ si ce bouton est coché ↓ seront cochables grace au js -->

                <input type="checkbox" id="encheresOuvertes" name="encheresOuvertes" class=achats disabled
                    value="encheresOuvertes">
                <label for="encheresOuvertes"> enchèrs ouvertes</label><br>
                <input type="checkbox" id="mesEncheres" name="mesEncheres" class=achats disabled value="mesEncheres">
                <label for="mesEncheres"> mes enchères</label><br>
                <input type="checkbox" id="mesEncheresRemportees" name="mesEncheresRemportees" disabled class=achats
                    value="mesEncheresRemportees">
                <label for="mesEncheresRemportees"> mes enchères emportées</label><br><br>


                <!-- CASES FILTRE MES VENTES -->

                <input type="radio" id="ventes" name="achatsOuVentes" value="ventes" />
                <label for="ventes">Mes ventes</label><br>
                <!--  ↑ si ce bouton est coché ↓ seront cochables grace au js -->

                <input type="checkbox" id="mesVentesEnCours" name="mesVentesEnCours" class="ventes" disabled
                    value="mesVentesEnCours">
                <label for="mesVentesEnCours">mes ventes en cours</label><br>
                <input type="checkbox" id="ventesNonDebutees" name="ventesNonDebutees" class="ventes" disabled
                    value="ventesNonDebutees">
                <label for="ventesNonDebutees">ventes non débutées</label><br>
                <input type="checkbox" id="ventesTerminees" name="ventesTerminees" class="ventes" disabled
                    value="ventesTerminees">
                <label for="ventesTerminees">ventes terminées</label><br><br>
            </div>


            <input type="submit" value="Submit">
        </form>


        <br>
        <br>
        <div class="row">
            <div class="col-xl-6 col-lg-6 col-sm-12" style="width: 18rem;">
                <img src="IMG\miniature.jpg" class="miniature" alt="miniature">
                <div class="card-body">

                    <p class="card-text">Un bouquin de dingue
                        <!--nomArticle--><br>
                        Prix : 6€
                        <!-- prixVente --><br>
                        Fin de l'enchère : 19/12/2021
                        <!-- dateFinEncheres--><br>
                        Vendeur : tititoto44
                        <!-- Utilisateur.pseudo-->
                    </p>
                </div>
            </div>
            <div class="col-xl-6 col-lg-6 col-sm-12" style="width: 18rem;">
                <img src="IMG\miniature.jpg" class="miniature" alt="miniature">
                <div class="card-body">
                    <p class="card-text">Un deuxième bouquin de dingue
                        <!--nomArticle--><br>
                        Prix : 6€
                        <!-- prixVente --><br>
                        Fin de l'enchère : 19/12/2021
                        <!-- dateFinEncheres--><br>
                        Vendeur : tititoto44
                        <!-- Utilisateur.pseudo-->
                    </p>
                </div>
            </div>
        </div>
    </div>

    <footer>

    </footer>

</body>

</html>