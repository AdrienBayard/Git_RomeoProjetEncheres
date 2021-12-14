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
		
		// Afficher les article avec un certain nom
		String huhuh = request.getParameter("encheresOuvertes");
		System.out.println("value enchère ouvertes : " + huhuh);

		// Afficher les articles d'une certaine catégorie

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

			if ((request.getParameter("mesEncheresRemportees") != null)
					&& (request.getParameter("mesEncheresRemportees").equals("ON"))) {
				try {
					listeArticles = ArticleManager.getInstance().afficherEncheresRemportees(pseudo);
				} catch (BLLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		// Dans "mes ventes"
		if ((request.getParameter("ventesAchats") != null) && (request.getParameter("ventesAchats").equals("ventes"))) {
			System.out.println(" entrée dans vente ");

			// Afficher uniquement mes ventes en cours (Uniquement si l'utilisateur est
			// vendeur + la dateFinEnchere n'est pas arrivée à terme).

			if ((request.getParameter("mesVentesEnCours") != null)
					&& (request.getParameter("mesVentesEnCours").equals("ON"))) {

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
