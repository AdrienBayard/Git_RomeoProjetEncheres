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
import eni.fr.javaee.projet.bll.UtilisateurManager;
import eni.fr.javaee.projet.bo.ArticleVendu;

/**
 * Servlet implementation class acheterArticleServlet
 */
@WebServlet(name = "AcheterArticle", urlPatterns = { "/achat" })
public class AcheterArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArticleVendu article = null;
		String pseudoDuMeilleurEncherisseur = null;
		int noArticle = Integer.valueOf(request.getParameter("trackingArticle"));
		try {
			 article = ArticleManager.getInstance().selectArticleById(noArticle);
			 int noUtilisateur = ArticleManager.getInstance().trouverMeilleurEncherisseur(noArticle);
			 System.out.println("test no : " + noUtilisateur);
			 pseudoDuMeilleurEncherisseur = UtilisateurManager.getInstance().afficherProfilAvecId(noUtilisateur).getPseudo();
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String nomArticle = article.getNomArticle();
		String description = article.getDescription();
		String categorie = null;
		int miseAPrix = article.getMiseAPrix();
		LocalDateTime finEnchere = article.getDateFinEncheres();
		//TODO : récupérer le point de retrait
		String vendeur = article.getPseudo();
		System.out.println(pseudoDuMeilleurEncherisseur);
		
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
		
		RequestDispatcher aiguilleur = getServletContext().getRequestDispatcher("/detailvente");
		aiguilleur.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Nouvel enchere
		
	}

}
