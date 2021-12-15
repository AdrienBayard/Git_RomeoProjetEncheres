package eni.fr.javaee.projet.servlet;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		int noArticle = Integer.valueOf(request.getParameter("trackingArticle"));
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
		// Nouvel enchere

	}

}
