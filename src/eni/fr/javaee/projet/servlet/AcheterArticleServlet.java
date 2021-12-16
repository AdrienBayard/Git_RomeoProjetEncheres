package eni.fr.javaee.projet.servlet;

import java.io.IOException;

import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import eni.fr.javaee.projet.bll.ArticleManager;
import eni.fr.javaee.projet.bll.BLLException;
import eni.fr.javaee.projet.bll.EnchereManager;
import eni.fr.javaee.projet.bll.UtilisateurManager;
import eni.fr.javaee.projet.bo.ArticleVendu;
import eni.fr.javaee.projet.bo.Enchere;
import eni.fr.javaee.projet.bo.Utilisateur;

/**
 * Servlet implementation class acheterArticleServlet
 */
@WebServlet(name = "AcheterArticle", urlPatterns = { "/achat" })
public class AcheterArticleServlet extends HttpServlet {
	int noArticle = 0;
	Boolean modification = false;
	String message = "";
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String pseudo = (String) session.getAttribute("pseudo");
		ArticleVendu article = null;
		String pseudoDuMeilleurEncherisseur = null;
		String ville = null;
		String codePostal = null;
		String rue = null;
		String telephone = null;
		int montantEnchere = 0;	
		if(!message.equals("")) {
			request.setAttribute("message", message);
			message = "";
		}
		else {
			message = "";
			if (modification == false) {
				
				noArticle = Integer.valueOf(request.getParameter("trackingArticle"));
			}
			else {
				modification = false;
			}
		}
		try {
			article = ArticleManager.getInstance().selectArticleById(noArticle);
			int noUtilisateurVendeur = article.getNo_utilisateur();
			Utilisateur utilisateur = UtilisateurManager.getInstance().afficherProfilAvecId(noUtilisateurVendeur);
			ville = utilisateur.getVille();
			codePostal = utilisateur.getCodePostal();
			rue = utilisateur.getRue();
			telephone = utilisateur.getTelephone();
			
			Enchere meilleurEnchere = EnchereManager.getInstance().trouverMeilleurEncherisseur(noArticle);
			if (meilleurEnchere != null) {
				
				int noUtilisateur = meilleurEnchere.getNoUtilisateur();
				montantEnchere = meilleurEnchere.getMontant_enchere();
				
				if (noUtilisateur != 0) {
					pseudoDuMeilleurEncherisseur = UtilisateurManager.getInstance().afficherProfilAvecId(noUtilisateur)
							.getPseudo();
				}
			}
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String nomArticle = article.getNomArticle();
		String description = article.getDescription();
		String categorie = null;
		int miseAPrix = article.getMiseAPrix();
		LocalDateTime debutEnchere = article.getDateDebutEncheres();
		LocalDateTime finEnchere = article.getDateFinEncheres();
		// TODO : récupérer le point de retrait
		String vendeur = article.getPseudo();

		switch (article.getCategorie()) {
		case 1:
			categorie = "Informatique";
			break;
		case 2:
			categorie = "Ameublement";
			break;
		case 3:
			categorie = "Vetement";
			break;
		case 4:
			categorie = "Sport & Loisirs";
			break;

		default:
			break;
		}

		request.setAttribute("nomArticle", nomArticle);
		request.setAttribute("description", description);
		request.setAttribute("categorie", categorie);
		request.setAttribute("miseAPrix", miseAPrix);
		request.setAttribute("finEnchere", finEnchere);
		request.setAttribute("vendeur", vendeur);
		request.setAttribute("pseudoDuMeilleurEncherisseur", pseudoDuMeilleurEncherisseur);
		request.setAttribute("montantEnchere", montantEnchere);
		request.setAttribute("ville", ville);
		request.setAttribute("codePostal", codePostal);
		request.setAttribute("rue", rue);
		request.setAttribute("telephone", telephone);
		request.setAttribute("debutEnchere", debutEnchere);
		

		 if ((debutEnchere.isAfter(LocalDateTime.now())) && (pseudo.equals(vendeur))) {
			request.setAttribute("noArticle", noArticle);
			RequestDispatcher aiguilleur = getServletContext().getRequestDispatcher("/modifierarticle");
			aiguilleur.forward(request, response);
		}
		 else if ((finEnchere.isBefore(LocalDateTime.now())) && (pseudoDuMeilleurEncherisseur == null)){
			pseudoDuMeilleurEncherisseur = "Personne n'a";
			request.setAttribute("pseudoDuMeilleurEncherisseur", pseudoDuMeilleurEncherisseur);
			request.setAttribute("noArticle", noArticle);
			RequestDispatcher aiguilleur = getServletContext().getRequestDispatcher("/venteterminee");
			aiguilleur.forward(request, response);
		}
		else if ((finEnchere.isBefore(LocalDateTime.now())) && (!pseudoDuMeilleurEncherisseur.equals(pseudo))) {
			pseudoDuMeilleurEncherisseur = pseudoDuMeilleurEncherisseur + " a";
			request.setAttribute("pseudoDuMeilleurEncherisseur", pseudoDuMeilleurEncherisseur);
			request.setAttribute("noArticle", noArticle);
			RequestDispatcher aiguilleur = getServletContext().getRequestDispatcher("/venteterminee");
			aiguilleur.forward(request, response);
		}
		else if((finEnchere.isBefore(LocalDateTime.now())) && (pseudoDuMeilleurEncherisseur.equals(pseudo))) {
			RequestDispatcher aiguilleur = getServletContext().getRequestDispatcher("/achatremporte");
			aiguilleur.forward(request, response);
		}
		else {
			RequestDispatcher aiguilleur = getServletContext().getRequestDispatcher("/detailvente");
			aiguilleur.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		modification = false;
		message = "";
		HttpSession session = request.getSession();
		String pseudo = (String) session.getAttribute("pseudo");
		int ancienNoUtilisateur = 0 ;
		String ancienPseudo = "" ;
		String ancienNom = "";
		String ancienPrenom= "";
		String ancienEmail= "";
		String ancienTelephone= "";
		String ancienRue= "";
		String ancienCodePostal= "";
		String ancienVille= "";
		String ancienMotDePasse= "";
		int ancienCredit =0;
		int ancienneMeilleureEnchere = 0;
		int noUtilisateur=0;
		
		try {
		//Ancien profil : 
			if (EnchereManager.getInstance().trouverMeilleurEncherisseur(noArticle) != null) {
				 ancienNoUtilisateur = EnchereManager.getInstance().trouverMeilleurEncherisseur(noArticle).getNoUtilisateur();
				 Utilisateur ancienUtilisateur =UtilisateurManager.getInstance().afficherProfilAvecId(ancienNoUtilisateur);
				 ancienPseudo = ancienUtilisateur.getPseudo();
				 ancienNom = ancienUtilisateur.getNom();
				 ancienPrenom = ancienUtilisateur.getPrenom();
				 ancienEmail = ancienUtilisateur.getEmail();
				 ancienTelephone = ancienUtilisateur.getTelephone();
				 ancienRue = ancienUtilisateur.getRue();
				 ancienCodePostal = ancienUtilisateur.getCodePostal();
				 ancienVille = ancienUtilisateur.getVille();
				 ancienMotDePasse = ancienUtilisateur.getMotDePasse();
				 ancienCredit = ancienUtilisateur.getCredit();
				 ancienneMeilleureEnchere = EnchereManager.getInstance().trouverMeilleurEncherisseur(noArticle).getMontant_enchere();
				if(ancienneMeilleureEnchere != 0) {
					
					ancienCredit = ancienCredit + ancienneMeilleureEnchere;
				}
			}
		
		
		//Nouveau profil
			Utilisateur nouvelUtilisateur = UtilisateurManager.getInstance().afficherProfil(pseudo);
		int nouveauNoUtilisateur = nouvelUtilisateur.getNoUtilisateur();
		String nouveauNom = nouvelUtilisateur.getNom();
		String nouveauPrenom = nouvelUtilisateur.getPrenom();
		String nouveauEmail = nouvelUtilisateur.getEmail();
		String nouveauTelephone = nouvelUtilisateur.getTelephone();
		String nouveauRue = nouvelUtilisateur.getRue();
		String nouveauCodePostal = nouvelUtilisateur.getCodePostal();
		String nouveauVille = nouvelUtilisateur.getVille();
		String nouveauMotDePasse = nouvelUtilisateur.getMotDePasse();
		int nouveauCredit = nouvelUtilisateur.getCredit();
		int montantEnchere = Integer.parseInt(request.getParameter("montantEnchere"));
		nouveauCredit = nouveauCredit - montantEnchere;
		
		 noUtilisateur = UtilisateurManager.getInstance().afficherProfil(pseudo).getNoUtilisateur();

		 int noUtilisateurVendeur = ArticleManager.getInstance().selectArticleById(noArticle).getNo_utilisateur();
		 if (noUtilisateur == noUtilisateurVendeur) {
			 message = "Vous ne pouvez pas enchérir sur votre propre article";
			 doGet(request, response);
		 }
		 else if ((montantEnchere > ancienneMeilleureEnchere )&& (noUtilisateur != ancienNoUtilisateur) && (nouveauCredit >= 0)) {
				if (EnchereManager.getInstance().trouverMeilleurEncherisseur(noArticle) != null) {
					UtilisateurManager.getInstance().updateUtilisateur(ancienNoUtilisateur, ancienPseudo, ancienNom, ancienPrenom, ancienEmail, ancienTelephone, ancienRue, ancienCodePostal, ancienVille, ancienMotDePasse, ancienCredit);
				}
				
			 EnchereManager.getInstance().insertEnchere(montantEnchere, noArticle, noUtilisateur);
			 UtilisateurManager.getInstance().updateUtilisateur(nouveauNoUtilisateur, pseudo, nouveauNom, nouveauPrenom, nouveauEmail, nouveauTelephone, nouveauRue, nouveauCodePostal, nouveauVille, nouveauMotDePasse, nouveauCredit);
			message = "";
			modification = true;
			 doGet(request, response);
		 }
		 else if (noUtilisateur == ancienNoUtilisateur){
			  message = "Vous êtes déjà le meilleur enchérisseur";
			 doGet(request, response);
		 }
		 else {
			 message = "Une erreur s'est produite lors de l'insertion des crédits, veuillez vérifier vos crédits";
			 doGet(request, response);
		 }
		 
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
