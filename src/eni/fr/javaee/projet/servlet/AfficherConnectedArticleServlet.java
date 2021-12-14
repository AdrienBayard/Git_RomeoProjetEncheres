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

/**
 * Servlet implementation class AfficherConnectedArticleServlet
 */
@WebServlet(name = "afficherconnected", urlPatterns = { "/afficherConnected" })
public class AfficherConnectedArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AfficherConnectedArticleServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("entrée do get");

		// Afficher tous les articles
		List<ArticleVendu> listeArticles = new ArrayList<ArticleVendu>();
		try {
			listeArticles = (List<ArticleVendu>) ArticleManager.getInstance().afficherAchatsEnCours();

		} catch (BLLException e) {
			e.printStackTrace();
		}

		request.setAttribute("listeArticles", listeArticles);
		RequestDispatcher aiguilleur = getServletContext().getRequestDispatcher("/connected");
		aiguilleur.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int noUtilisateur = 0;
		// Génération d'une liste blanche
		List<ArticleVendu> listeArticles = new ArrayList<>();

		// Récupération du pseudo de session
		HttpSession session = request.getSession();
		String pseudo = (String) session.getAttribute("pseudo");

		try {
			noUtilisateur = UtilisateurManager.getInstance().afficherProfil(pseudo).getNoUtilisateur();
		} catch (BLLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

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

		// Dans "mes achats"
		if (request.getParameter("ventesAchats") != null) {

			// Tous les articles avec un délai encore ouvert
			if (request.getParameter("encheresOuvertes") != null) {
				try {
					listeArticles = (List<ArticleVendu>) ArticleManager.getInstance().afficherAchatsEnCours();

				} catch (BLLException e) {
					e.printStackTrace();
				}
				System.out.println("achat/enchereouvertes");
			}

			// Afficher uniquement mes enchères (Uniquement les enchêres où l'utilisateur
			// est intervenu + la date d'échéance doit être ouverte)
			if (request.getParameter("mesEncheres") != null) {

				listeArticles = EnchereManager.getInstance().trouverArticleEncherit(noUtilisateur);
				for (ArticleVendu articleVendu : listeArticles) {
					System.out.println(articleVendu.toString());
				}

			}

			// Afficher uniquement mes enchères remportées (Uniquement les enchêres où
			// l'utilisateur est le meilleur encherisseur et la date doit être fermée).

			if (request.getParameter("mesEncheresRemportees") != null) {
				try {
					listeArticles = ArticleManager.getInstance().afficherEncheresRemportees(pseudo);
				} catch (BLLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		// Dans "mes ventes"
		if (request.getParameter("ventesAchats") != null) {
			System.out.println(" entrée dans vente ");

			// Afficher uniquement mes ventes en cours (Uniquement si l'utilisateur est
			// vendeur + la dateFinEnchere n'est pas arrivée à terme).

			if (request.getParameter("mesVentesEnCours") != null) {
				try {
					listeArticles = ArticleManager.getInstance().afficherVentesEnCours();
				} catch (BLLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if ((request.getParameter("ventesNonDebutees") != null)
					&& (request.getParameter("ventesNonDebutees").equals("ON"))) {
				// Afficher uniquement mes ventes non débutées (Uniquement si l'utilisateur est
				// vendeur + la dateDebutEnchere n'est pas arrivée)
				System.out.println("youpi");
			}
			if ((request.getParameter("ventesTerminees") != null)
					&& (request.getParameter("ventesTerminees").equals("ON"))) {
				// Afficher uniquement mes ventes non débutées (Uniquement si l'utilisateur est
				// vendeur + la dateFinEnchere est dépassée)
				System.out.println("youpi");
			}
		}
		
		request.setAttribute("listeArticles", listeArticles);

		RequestDispatcher aiguilleur = getServletContext().getRequestDispatcher("/connected");
		aiguilleur.forward(request, response);
	}
}
