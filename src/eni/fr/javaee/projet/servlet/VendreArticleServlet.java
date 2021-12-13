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

import com.sun.research.ws.wadl.Request;

import eni.fr.javaee.projet.bll.BLLException;
import eni.fr.javaee.projet.bll.UtilisateurManager;
import eni.fr.javaee.projet.bo.Utilisateur;

/**
 * Servlet implementation class VendreArticleServlet
 */
@WebServlet(name = "VendreArticle", urlPatterns = { "/vendre" })
public class VendreArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String pseudo = (String) session.getAttribute("pseudo");
		try {
			System.out.println("hello");
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String article = request.getParameter("article");
		String description = request.getParameter("description");
		String categorie = request.getParameter("categorie");
		String dateDebutEnchere = request.getParameter("debutEnchere");
		String dateFinEnchere = request.getParameter("finEnchere");
		
		System.out.println(article + description + categorie + dateDebutEnchere + dateFinEnchere);
		
	}

}
