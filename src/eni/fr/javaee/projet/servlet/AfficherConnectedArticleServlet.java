package eni.fr.javaee.projet.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eni.fr.javaee.projet.bll.ArticleManager;
import eni.fr.javaee.projet.bll.BLLException;
import eni.fr.javaee.projet.bo.ArticleVendu;

/**
 * Servlet implementation class AfficherConnectedArticleServlet
 */
@WebServlet(name = "afficherconnected", urlPatterns = { "/afficherconnected" })
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		System.out.println("entrée do get");
		
		
		//Afficher tous les articles
		List<ArticleVendu> listeArticles = new ArrayList<ArticleVendu>();
		try {
			listeArticles = (List<ArticleVendu>) ArticleManager.getInstance().afficherAchatsEnCours();
			 
		} catch (BLLException e) {
			e.printStackTrace();
		}

		request.setAttribute("listeArticles", listeArticles);
		
		// Afficher les article avec un certain nom
		String achats = request.getParameter("achats"); 
		System.out.println("radio button achats : " + achats);
		
		String huhuh = request.getParameter("encheresOuvertes"); 
		System.out.println("value enchère ouvertes : " + huhuh); 
		
//		Boolean zboui = Boolean.valueOf(request.getParameter("encheresOuvertes")); 
//		
//		Boolean test2 = zboui.booleanValue(); 
//		
//		if(test2) {
//			System.out.println("true");
//		} else {
//			System.out.println("false");
//		}
		Boolean test3; 		
		
		if(request.getParameter("encheresOuvertes") == null) {
			test3 = false; 
			
			System.out.println("Youpi");
		} else {
			test3 = true; 
			System.out.println("Pas de chance");
		}
		
		
		
		// Afficher les articles d'une certaine catégorie
		
		// Dans "mes achats"
		if(request.getParameter("achats") != null) {
			System.out.println("entrée achat");
			if(request.getParameter("encheresOuvertes")!= null) {
				//Afficher Uniquement les enchères ouvertes (l'utilisateur doit être vendeur + la date d'échéance doit être ouverte)
				System.out.println("achat/enchereouvertes");
			} else if((request.getParameter("mesEncheres") == "true") && (request.getParameter("mesEncheres")!= null)) {
				// Afficher uniquement mes enchères (Uniquement les enchêres où l'utilisateur est intervenu + la date d'échéance doit être ouverte)
				System.out.println("achat/mes encheres");
			} else if((request.getParameter("mesEncheresRemportees") != null) && (request.getParameter("mesEncheresRemportees").equals("true"))){
				// Afficher uniquement mes enchères remportées (Uniquement les enchêres où l'utilisateur est le meilleur encherisseur et la date doit être fermée).
				System.out.println("achat/mer");
			}	
		}
		
		
		
		//Dans "mes ventes"
		if(request.getParameter("ventes") != null) {
			if(request.getParameter("mesVentesEnCours") != null) {
				// Afficher uniquement mes ventes en cours (Uniquement si l'utilisateur est vendeur + la dateFinEnchere n'est pas arrivée à terme). 
			} else if(request.getParameter("ventesNonDebutees") != null) {
				// Afficher uniquement mes ventes non débutées (Uniquement si l'utilisateur est vendeur + la dateDebutEnchere n'est pas arrivée)

			} else if(request.getParameter("ventesTerminees") != null) {
				// Afficher uniquement mes ventes non débutées (Uniquement si l'utilisateur est vendeur + la dateFinEnchere est dépassée)

			}	
		}

	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
