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

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import eni.fr.javaee.projet.bll.ArticleManager;
import eni.fr.javaee.projet.bll.BLLException;
import eni.fr.javaee.projet.bll.UtilisateurManager;
import eni.fr.javaee.projet.bo.ArticleVendu;
import fr.eni.javaee.projet.dal.DALException;

/**
 * Servlet implementation class AfficherArticlesServlet
 */
@WebServlet(name = "AfficherArticles", urlPatterns = { "/accueil" })
public class AfficherArticlesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<ArticleVendu> listeArticles = new ArrayList<ArticleVendu>();
		try {
			listeArticles = (List<ArticleVendu>) ArticleManager.getInstance().afficherAchatsEnCours();

		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String recherche = request.getParameter("rechercher");

		List<ArticleVendu> listeArticlesFiltre = new ArrayList<ArticleVendu>();
		if ((request.getParameter("cars") != null)) {

			switch (request.getParameter("cars")) {

			case "Informatique":
				if (recherche == null) {

					for (ArticleVendu articleVendu : listeArticles) {
						if (articleVendu.getCategorie() == 1) {
							listeArticlesFiltre.add(articleVendu);
						}
					}
				}
				else (articleVendu.getNomArticle().contains(recherche) == true){
					
				}
				;
				break;
			case "Ameublement":
				for (ArticleVendu articleVendu : listeArticles) {
					if (articleVendu.getCategorie() == 2) {
						listeArticlesFiltre.add(articleVendu);
					}
				}
				;
				break;
			case "Vetements":
				for (ArticleVendu articleVendu : listeArticles) {
					if (articleVendu.getCategorie() == 3) {
						listeArticlesFiltre.add(articleVendu);
					}
				}
				;
				break;
			case "Sport&Loisirs":
				for (ArticleVendu articleVendu : listeArticles) {
					if (articleVendu.getCategorie() == 3) {
						listeArticlesFiltre.add(articleVendu);
					}
				}
				;
				break;
			default:
				break;
			}

			if (recherche != null) {
				for (ArticleVendu articleVendu : listeArticlesFiltre) {
					if (articleVendu.getNomArticle().contains(recherche) == true) {
						listeArticlesFiltre.add(articleVendu);
					}
				}
			}

		}

		if (recherche != null) {
			for (ArticleVendu articleVendu : listeArticles) {
				if (articleVendu.getNomArticle().contains(recherche) == true) {
					listeArticles.add(articleVendu);
				}
			}
		}
		request.setAttribute("listeArticles", listeArticles);
		HttpSession session = request.getSession();
		session.invalidate();
		RequestDispatcher aiguilleur = getServletContext().getRequestDispatcher("/pageAccueil");
		aiguilleur.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
