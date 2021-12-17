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
	String rue;
	String codePostal;
	String ville;
	String messageErreur; 

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
			 rue = UtilisateurManager.getInstance().afficherProfil(pseudo).getRue();
			 codePostal = UtilisateurManager.getInstance().afficherProfil(pseudo).getCodePostal();
			 ville = UtilisateurManager.getInstance().afficherProfil(pseudo).getVille();
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
		boolean autorisationInsert = false; 
		
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
				if(miseAPrix == 0 || miseAPrix >= 1000000) {
					autorisationInsert = false;
					request.setAttribute("messageErreur", 1); // La mise à prix doit être supérieure à 0 et inférieure à beaucoup plus que ton compte banque sauf si t'es Jeff Bezos. 
				} else if(LocalDateTime.now().isAfter(dateFinEnchere)) {
					autorisationInsert = false; 
					request.setAttribute("messageErreur", 2); // Vous ne pouvez prévoir une date de fin d'enchère déjà passée. 
				} else if(LocalDateTime.now().isAfter(dateDebutEnchere)) {
					autorisationInsert = false; 
					request.setAttribute("messageErreur", 3); // Vous ne pouvez prévoir une date de début d'enchère déjà passée. 
				} else if(description.isEmpty() || description.length() > 300) {
					autorisationInsert = false; 
					request.setAttribute("messageErreur", 4); // Vous devez prévez une description (inf. à 300 caractères). 
				} else if(article.isEmpty() || article.length() > 30) {
					autorisationInsert = false; 
					request.setAttribute("messageErreur", 5); // Vous devez prévoir un nom d'article (inf. à 30 caractères). 
				} else if(dateDebutEnchere.isAfter(dateFinEnchere)) {
					autorisationInsert = false; 
					request.setAttribute("messageErreur", 6); // La date de fin d'enchère doit être postérieure à son début. 
				} else {
					autorisationInsert = true; 
				}
	
				
			if (autorisationInsert == true) {
				ArticleManager.getInstance().insertVente(article, description, dateDebutEnchere, dateFinEnchere, miseAPrix, 0, no_utilisateur ,categorie);
				RequestDispatcher aiguileur = getServletContext().getRequestDispatcher("/afficherConnected");
				aiguileur.forward(request, response);
			} else {  
				 rue = UtilisateurManager.getInstance().afficherProfil(pseudo).getRue();
				 codePostal = UtilisateurManager.getInstance().afficherProfil(pseudo).getCodePostal();
				 ville = UtilisateurManager.getInstance().afficherProfil(pseudo).getVille();
				 request.setAttribute("rue", rue);
					request.setAttribute("codePostal", codePostal);
					request.setAttribute("ville", ville);
				RequestDispatcher aiguileur = getServletContext().getRequestDispatcher("/gestionarticle");
				aiguileur.forward(request, response);
			}
			
				
				
			} catch (BLLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}

}
