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
import eni.fr.javaee.projet.bo.ArticleVendu;

/**
 * Servlet implementation class ModifierArticleServlet
 */
@WebServlet(name = "ModifierArticle", urlPatterns = { "/modifierArticle" })
public class ModifierArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int noArticle = Integer.parseInt(request.getParameter("trackingArticle"));
		try {
			ArticleManager.getInstance().deleteVente(noArticle);
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher aiguilleur = getServletContext().getRequestDispatcher("/afficherConnected");
		aiguilleur.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String boutton = request.getParameter("bouttonModifier");
		int no_utilisateur = 0;
		int noArticle = Integer.parseInt(request.getParameter("trackingNoArticle"));
		try {
			System.out.println("noArticle :" + noArticle);
			ArticleVendu article = ArticleManager.getInstance().selectArticleById(noArticle);
			no_utilisateur = article.getNo_utilisateur();

		} catch (BLLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (boutton.equals("modifier")) {
			String nomArticle = request.getParameter("article");
			String description = request.getParameter("description");
			String categorieString = request.getParameter("categorie");
			LocalDateTime debutEnchere = LocalDateTime.parse(request.getParameter("debutEnchere"));
			LocalDateTime finEnchere = LocalDateTime.parse(request.getParameter("finEnchere"));
			int miseAPrix = Integer.parseInt(request.getParameter("miseAPrix"));
			int categorie = 0;

			switch (categorieString) {
			case "Informatique":
				categorie = 1;
				break;
			case "Ameublement":
				categorie = 2;
				break;
			case "Vetements":
				categorie = 3;
				break;
			case "Sport et Loisirs":
				categorie = 4;
				break;

			default:
				break;
			}
			try {
				System.out.println(no_utilisateur);
				ArticleManager.getInstance().updateVente(noArticle, nomArticle, description, debutEnchere, finEnchere, miseAPrix,
						0, no_utilisateur, categorie);
			} catch (BLLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		else if (boutton.equals("supprimer")) {
			try {
				ArticleManager.getInstance().deleteVente(noArticle);
			} catch (BLLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RequestDispatcher aiguilleur = getServletContext().getRequestDispatcher("/afficherConnected");
			aiguilleur.forward(request, response);
		}

	}

}
