package eni.fr.javaee.projet.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import javassist.expr.NewArray;

/**
 * Servlet implementation class ModifierUtilisateurServlet
 */

@WebServlet(name = "ModifierUtilisateur", urlPatterns = { "/modifier" })
public class ModifierUtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Boolean checkMotDePasseActuel = false;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String pseudo = (String) session.getAttribute("pseudo");
		String afficherProfil = request.getParameter("button");
		try {
			Utilisateur utilisateur = UtilisateurManager.getInstance().afficherProfil(pseudo);
			String nom = utilisateur.getNom();
			String prenom = utilisateur.getPrenom();
			String email = utilisateur.getEmail();
			String telephone = utilisateur.getTelephone();
			String rue = utilisateur.getRue();
			String codePostal = utilisateur.getCodePostal();
			String ville = utilisateur.getVille();
			int credit = utilisateur.getCredit();
			

			request.setAttribute("pseudo", pseudo);
			request.setAttribute("nom", nom);
			request.setAttribute("prenom", prenom);
			request.setAttribute("email", email);
			request.setAttribute("telephone", telephone);
			request.setAttribute("rue", rue);
			request.setAttribute("codePostal", codePostal);
			request.setAttribute("ville", ville);
			request.setAttribute("credit", credit);

			if (checkMotDePasseActuel == true) {
				request.setAttribute("messageErreur", 5); // Msg : Le mot de passe actuel n'est pas le bon

			}
			if (afficherProfil == null || afficherProfil.equals("false")) {

				RequestDispatcher aiguilleur = getServletContext().getRequestDispatcher("/monprofil");
				aiguilleur.forward(request, response);
			} else {
				RequestDispatcher aiguilleur = getServletContext().getRequestDispatcher("/modifierprofil");
				aiguilleur.forward(request, response);
			}

		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String quelBouton = request.getParameter("buttonModifierProfil");
		HttpSession session = request.getSession();
		String motDePasseActuel = request.getParameter("motDePasseActuel");
		Boolean modification = true;
		if (quelBouton.equals("modifier")) {
		Boolean motDePasseErrone = false;
		Boolean pseudoErrone = false;
		Boolean emailErrone = false;
		checkMotDePasseActuel = false;

		// Récupération des informations du client depuis le formulaire.
		String nouveauPseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		String nouveauMotDePasse = request.getParameter("nouveauMotDePasse");
		String confirmation = request.getParameter("confirmation");
		
			
		

		// Récupération des pseudos et mail déjà existants.
		List<Utilisateur> listUtilExistants;
		try {
			String pseudoSession = (String) session.getAttribute("pseudo");
			String ancienMotdePasse = UtilisateurManager.getInstance().afficherProfil(pseudoSession).getMotDePasse();
			if (!motDePasseActuel.equals(ancienMotdePasse)) {
				modification = false;
				motDePasseErrone = true;
			} else if (!nouveauMotDePasse.equals(confirmation)) {
				modification = false;
				request.setAttribute("messageErreur", 1); // Msg : le mdp et la confirmation doivent être identiques.
			} else {
				listUtilExistants = UtilisateurManager.getInstance().getListeUtilisateurs();
				for (Utilisateur utilisateur : listUtilExistants) {
					if (utilisateur.getNoUtilisateur() != UtilisateurManager.getInstance().afficherProfil(pseudoSession)
							.getNoUtilisateur()) {
						if (utilisateur.getPseudo().equals(nouveauPseudo)) {
							modification = false;
							pseudoErrone = true;
							request.setAttribute("messageErreur", 2); // Msg : Pseudo déjà utilisé
							
						}
						if (utilisateur.getEmail().equals(email)) {
							modification = false;
							emailErrone = true;
							request.setAttribute("messageErreur", 3); // Msg : Mail déjà utilisé
							
						}
						if ((pseudoErrone == true) && (emailErrone == true) ) {
							request.setAttribute("messageErreur", 4); // Msg : Pseudo ou adresse mail déjà utilisés.
						}
					}
				}
			}

			if (modification == true) {
				String ancienPseudo = (String) session.getAttribute("pseudo");
				if (nouveauMotDePasse.isEmpty()) {
					nouveauMotDePasse = UtilisateurManager.getInstance().afficherProfil(ancienPseudo).getMotDePasse();
				}
				session.setAttribute("pseudo", nouveauPseudo);

				int noUtilisateur = UtilisateurManager.getInstance().afficherProfil(ancienPseudo).getNoUtilisateur();
				int credit = UtilisateurManager.getInstance().afficherProfil(ancienPseudo).getCredit();
				UtilisateurManager.getInstance().updateUtilisateur(noUtilisateur, nouveauPseudo, nom, prenom, email,
						telephone, rue, codePostal, ville, nouveauMotDePasse, credit);
				RequestDispatcher aiguilleur = getServletContext().getRequestDispatcher("/afficherConnected");
				aiguilleur.forward(request, response);

			} else if (modification == false && motDePasseErrone == true) {
				checkMotDePasseActuel = true;
				doGet(request, response);
			} else {
				doGet(request, response);
			}

		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		else if (quelBouton.equals("supprimer")) {
			List<ArticleVendu> articles = new ArrayList<ArticleVendu>();
			List<ArticleVendu> encheres = new ArrayList<ArticleVendu>();
			modification = true;
			String pseudo = (String) session.getAttribute("pseudo");
			int idUtilisateur = 0;
			String ancienMotdePasse = null;
			try {
				idUtilisateur = UtilisateurManager.getInstance().afficherProfil(pseudo).getNoUtilisateur();
				 ancienMotdePasse = UtilisateurManager.getInstance().afficherProfil(pseudo).getMotDePasse();
				articles = ArticleManager.getInstance().afficherAchatsEnCours();
				encheres = EnchereManager.getInstance().trouverArticleEncherit(idUtilisateur);
			} catch (BLLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				if (!motDePasseActuel.equals(ancienMotdePasse)) {
					checkMotDePasseActuel = true;
					doGet(request, response);
				}
				for (ArticleVendu articleVendu : articles) {
					if (articleVendu.getNo_utilisateur() == idUtilisateur) {
						modification = false;
						request.setAttribute("messageErreur", 6); // Msg : Vous ne pouvez pas supprimer votre compte vous avez un article en vente
						doGet(request, response);	
						
					}
				}
				 if(encheres != null && modification == true) {
					modification = false;
					request.setAttribute("messageErreur", 7); // Msg : Vous ne pouvez pas supprimer votre compte vous avez une enchere en cours
					doGet(request, response);
				}
			
				
				else if (modification == true){
					
					try {
						UtilisateurManager.getInstance().deleteUtilisateur(idUtilisateur);
					} catch (BLLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					RequestDispatcher aiguilleur = getServletContext().getRequestDispatcher("/accueil");
					aiguilleur.forward(request, response);
				}
				
		}
	}

}
