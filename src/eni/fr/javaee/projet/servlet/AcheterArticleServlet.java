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
import javax.websocket.Session;

import com.sun.research.ws.wadl.Request;

import eni.fr.javaee.projet.bll.ArticleManager;
import eni.fr.javaee.projet.bll.BLLException;
import eni.fr.javaee.projet.bll.EnchereManager;
import eni.fr.javaee.projet.bll.UtilisateurManager;
import eni.fr.javaee.projet.bo.ArticleVendu;
import eni.fr.javaee.projet.bo.Enchere;

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
		ArticleVendu article = null;
		String pseudoDuMeilleurEncherisseur = null;
		String ville = null;
		String codePostal = null;
		String rue = null;
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
			ville = UtilisateurManager.getInstance().afficherProfilAvecId(noUtilisateurVendeur).getVille();
			codePostal = UtilisateurManager.getInstance().afficherProfilAvecId(noUtilisateurVendeur).getCodePostal();
			rue = UtilisateurManager.getInstance().afficherProfilAvecId(noUtilisateurVendeur).getRue();
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

		RequestDispatcher aiguilleur = getServletContext().getRequestDispatcher("/detailvente");
		aiguilleur.forward(request, response);
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
				 ancienPseudo = UtilisateurManager.getInstance().afficherProfilAvecId(ancienNoUtilisateur).getPseudo();
				 ancienNom = UtilisateurManager.getInstance().afficherProfilAvecId(ancienNoUtilisateur).getNom();
				 ancienPrenom = UtilisateurManager.getInstance().afficherProfilAvecId(ancienNoUtilisateur).getPrenom();
				 ancienEmail = UtilisateurManager.getInstance().afficherProfilAvecId(ancienNoUtilisateur).getEmail();
				 ancienTelephone = UtilisateurManager.getInstance().afficherProfilAvecId(ancienNoUtilisateur).getTelephone();
				 ancienRue = UtilisateurManager.getInstance().afficherProfilAvecId(ancienNoUtilisateur).getRue();
				 ancienCodePostal = UtilisateurManager.getInstance().afficherProfilAvecId(ancienNoUtilisateur).getCodePostal();
				 ancienVille = UtilisateurManager.getInstance().afficherProfilAvecId(ancienNoUtilisateur).getVille();
				 ancienMotDePasse = UtilisateurManager.getInstance().afficherProfilAvecId(ancienNoUtilisateur).getMotDePasse();
				 ancienCredit = UtilisateurManager.getInstance().afficherProfilAvecId(ancienNoUtilisateur).getCredit();
				 ancienneMeilleureEnchere = EnchereManager.getInstance().trouverMeilleurEncherisseur(noArticle).getMontant_enchere();
				if(ancienneMeilleureEnchere != 0) {
					
					ancienCredit = ancienCredit + ancienneMeilleureEnchere;
				}
			}
		
		
		//Nouveau profil
		int nouveauNoUtilisateur = UtilisateurManager.getInstance().afficherProfil(pseudo).getNoUtilisateur();
		String nouveauNom = UtilisateurManager.getInstance().afficherProfil(pseudo).getNom();
		String nouveauPrenom = UtilisateurManager.getInstance().afficherProfil(pseudo).getPrenom();
		String nouveauEmail = UtilisateurManager.getInstance().afficherProfil(pseudo).getEmail();
		String nouveauTelephone = UtilisateurManager.getInstance().afficherProfil(pseudo).getTelephone();
		String nouveauRue = UtilisateurManager.getInstance().afficherProfil(pseudo).getRue();
		String nouveauCodePostal = UtilisateurManager.getInstance().afficherProfil(pseudo).getCodePostal();
		String nouveauVille = UtilisateurManager.getInstance().afficherProfil(pseudo).getVille();
		String nouveauMotDePasse = UtilisateurManager.getInstance().afficherProfil(pseudo).getMotDePasse();
		int nouveauCredit = UtilisateurManager.getInstance().afficherProfil(pseudo).getCredit();
		int montantEnchere = Integer.parseInt(request.getParameter("montantEnchere"));
		nouveauCredit = nouveauCredit - montantEnchere;
		
		 noUtilisateur = UtilisateurManager.getInstance().afficherProfil(pseudo).getNoUtilisateur();

		 if ((montantEnchere > ancienneMeilleureEnchere )&& (noUtilisateur != ancienNoUtilisateur) && (nouveauCredit >= 0)) {
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
