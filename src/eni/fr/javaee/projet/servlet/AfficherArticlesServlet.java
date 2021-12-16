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
import eni.fr.javaee.projet.bo.ArticleVendu;

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

		if (recherche != null) {
			if (!recherche.equals("")) {
				recherche = recherche.toUpperCase();
			}
		}

		String cars = request.getParameter("cars");
		List<ArticleVendu> listeArticlesFiltre = new ArrayList<ArticleVendu>();
		if (cars != null) {

			switch (cars) {

			case "Informatique":
				if (recherche.equals("")) {

					for (ArticleVendu articleVendu : listeArticles) {
						if (articleVendu.getCategorie() == 1) {
							listeArticlesFiltre.add(articleVendu);
						}
					}
				} else {
					for (ArticleVendu articleVendu : listeArticles) {

						if (articleVendu.getNomArticle().toUpperCase().contains(recherche) == true
								&& (articleVendu.getCategorie() == 1)) {
							listeArticlesFiltre.add(articleVendu);
						}
					}

				}
				;
				break;
			case "Ameublement":
				if (recherche.equals("")) {

					for (ArticleVendu articleVendu : listeArticles) {
						if (articleVendu.getCategorie() == 2) {
							listeArticlesFiltre.add(articleVendu);
						}
					}
				} else {

					for (ArticleVendu articleVendu : listeArticles) {
						if (articleVendu.getNomArticle().toUpperCase().contains(recherche) == true
								&& (articleVendu.getCategorie() == 2)) {
							listeArticlesFiltre.add(articleVendu);
						}
					}

				}
				;
				break;
			case "Vetements":
				if (recherche.equals("")) {

					for (ArticleVendu articleVendu : listeArticles) {
						if (articleVendu.getCategorie() == 3) {
							listeArticlesFiltre.add(articleVendu);
						}
					}
				} else {
					for (ArticleVendu articleVendu : listeArticles) {

						if (articleVendu.getNomArticle().toUpperCase().contains(recherche) == true
								&& (articleVendu.getCategorie() == 3)) {
							listeArticlesFiltre.add(articleVendu);
						}
					}

				}
				;
				break;
			case "Sport&Loisirs":
				if (recherche.equals("")) {

					for (ArticleVendu articleVendu : listeArticles) {
						if (articleVendu.getCategorie() == 4) {
							listeArticlesFiltre.add(articleVendu);
						}
					}
				} else {
					for (ArticleVendu articleVendu : listeArticles) {

						if (articleVendu.getNomArticle().toUpperCase().contains(recherche) == true
								&& (articleVendu.getCategorie() == 4)) {
							listeArticlesFiltre.add(articleVendu);
						}
					}

				}
				;
				break;
			default:
				for (ArticleVendu articleVendu : listeArticles) {
					if (articleVendu.getNomArticle().toUpperCase().contains(recherche) == true) {
						listeArticlesFiltre.add(articleVendu);
					}
				}
				break;
			}
		}

		if (recherche == null && cars == null) {
			try {
				listeArticlesFiltre = (List<ArticleVendu>) ArticleManager.getInstance().afficherAchatsEnCours();
			} catch (BLLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		request.setAttribute("listeArticles", listeArticlesFiltre);
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
