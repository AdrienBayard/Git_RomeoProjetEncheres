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
import eni.fr.javaee.projet.bll.BLLException;
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
		RequestDispatcher aiguilleur = getServletContext().getRequestDispatcher("/pageAccueil");
		aiguilleur.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("entrée do posrt");

		
		// Afficher les article avec un certain nom
		String huhuh = request.getParameter("encheresOuvertes"); 
		System.out.println("value enchère ouvertes : " + huhuh); 
		
		
		
		// Afficher les articles d'une certaine catégorie
		
		// Dans "mes achats"
		if((request.getParameter("ventesAchats") != null) && (request.getParameter("ventesAchats").equals("achats"))) {
			System.out.println("entrée achat");
			
			if((request.getParameter("mesEncheres") != null) && (request.getParameter("encheresOuvertes").equals("ON"))) {
				//Afficher Uniquement les enchères ouvertes (l'utilisateur doit être vendeur + la date d'échéance doit être ouverte)
				System.out.println("achat/enchereouvertes");
			}
			if((request.getParameter("mesEncheres") != null) && (request.getParameter("mesEncheres").equals("ON"))) {
				// Afficher uniquement mes enchères (Uniquement les enchêres où l'utilisateur est intervenu + la date d'échéance doit être ouverte)
				System.out.println("achat/mes encheres");
			}
			if((request.getParameter("mesEncheresRemportees") != null) && (request.getParameter("mesEncheresRemportees").equals("ON"))){
				// Afficher uniquement mes enchères remportées (Uniquement les enchêres où l'utilisateur est le meilleur encherisseur et la date doit être fermée).
				System.out.println("achat/mer");
			}	
		}
		
		
		
		//Dans "mes ventes"
		if((request.getParameter("ventesAchats") != null) && (request.getParameter("ventesAchats").equals("ventes"))) {
			System.out.println("youpi");
			if((request.getParameter("mesVentesEnCours") != null) && (request.getParameter("mesVentesEnCours").equals("ON"))) {
				System.out.println("youpi");
				// Afficher uniquement mes ventes en cours (Uniquement si l'utilisateur est vendeur + la dateFinEnchere n'est pas arrivée à terme). 
			}
			if((request.getParameter("ventesNonDebutees") != null) && (request.getParameter("ventesNonDebutees").equals("ON"))) {
				// Afficher uniquement mes ventes non débutées (Uniquement si l'utilisateur est vendeur + la dateDebutEnchere n'est pas arrivée)
				System.out.println("youpi");
			}
			if((request.getParameter("ventesTerminees") != null) && (request.getParameter("ventesTerminees").equals("ON"))) {
				// Afficher uniquement mes ventes non débutées (Uniquement si l'utilisateur est vendeur + la dateFinEnchere est dépassée)
				System.out.println("youpi");
			}	
		}

	
	}

}

