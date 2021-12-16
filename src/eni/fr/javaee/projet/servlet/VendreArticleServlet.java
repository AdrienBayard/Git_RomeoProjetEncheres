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
import eni.fr.javaee.projet.bll.UtilisateurManager;


/**
 * Servlet implementation class VendreArticleServlet
 */
@WebServlet(name = "VendreArticle", urlPatterns = { "/vendre" })
public class VendreArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// DOGET pour afficher par défaut les coordonnées postales du vendeur.

		HttpSession session = request.getSession();
		String pseudo = (String) session.getAttribute("pseudo");
		try {
			String rue = UtilisateurManager.getInstance().afficherProfil(pseudo).getRue();
			String codePostal = UtilisateurManager.getInstance().afficherProfil(pseudo).getCodePostal();
			String ville = UtilisateurManager.getInstance().afficherProfil(pseudo).getVille();
			request.setAttribute("rue", rue);
			request.setAttribute("codePostal", codePostal);
			request.setAttribute("ville", ville);

			RequestDispatcher aiguileur = getServletContext().getRequestDispatcher("/gestionarticle");
			aiguileur.forward(request, response);
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
		int categorie;
		int no_utilisateur = 0;
		String article = request.getParameter("article");
		String description = request.getParameter("description");
		String categorieString = request.getParameter("categorie");
		LocalDateTime dateDebutEnchere = LocalDateTime.parse(request.getParameter("debutEnchere"));
		LocalDateTime dateFinEnchere = LocalDateTime.parse(request.getParameter("finEnchere"));
		int miseAPrix = Integer.valueOf(request.getParameter("miseAPrix"));
		switch (categorieString) {
		case "Informatique":
			categorie = 1;
			break;
		case "Ameublement":
			categorie = 2;
			break;
		case "Vetement":
			categorie = 3;
			break;
		case "Sport et Loisirs":
			categorie = 4;
			break;
		default:
			categorie = 0;
			break;
		}
		HttpSession session = request.getSession();
		String pseudo = (String) session.getAttribute("pseudo");
		try {
			no_utilisateur = UtilisateurManager.getInstance().afficherProfil(pseudo).getNoUtilisateur();
		} catch (BLLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

			try {
				ArticleManager.getInstance().insertVente(article, description, dateDebutEnchere, dateFinEnchere, miseAPrix, 0, no_utilisateur ,categorie);
			} catch (BLLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RequestDispatcher aiguileur = getServletContext().getRequestDispatcher("/afficherConnected");
			aiguileur.forward(request, response);
		
	}

}
