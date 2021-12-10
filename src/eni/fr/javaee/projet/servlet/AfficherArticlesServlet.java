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

import eni.fr.javaee.projet.bll.ArticleManager;
import eni.fr.javaee.projet.bo.ArticleVendu;
import fr.eni.javaee.projet.dal.DALException;

/**
 * Servlet implementation class AfficherArticlesServlet
 */
@WebServlet(name = "AfficherArticles", urlPatterns = { "/accueil" })
public class AfficherArticlesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("hello");
//		List<ArticleVendu> listeArticles = new ArrayList<ArticleVendu>();
//		try {
//		 listeArticles  = (List<ArticleVendu>) ArticleManager.getInstance().afficherAchatsEnCours();
//		} catch (DALException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		for (ArticleVendu articleVendu : listeArticles) {
//			System.out.println("test : " + articleVendu.toString());
//		}
//		System.out.println("test 2 : " +listeArticles.toString());
//		request.setAttribute("listeArticles", listeArticles);
		RequestDispatcher aiguilleur = getServletContext().getRequestDispatcher("/pageAccueil");
		aiguilleur.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
