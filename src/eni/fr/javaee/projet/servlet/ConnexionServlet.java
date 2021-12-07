package eni.fr.javaee.projet.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import eni.fr.javaee.projet.bll.UtilisateurManager;
import fr.eni.javaee.projet.dal.DALException;


/**
 * Servlet implementation class ui
 */
@WebServlet("/connexionServlet")
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnexionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String pseudo = request.getParameter("pseudo");
		String motDePasse = request.getParameter("motDePasse");
		String laJsp = null;
		Boolean mdpValide = false;
		String leMdp = null;
		//		faire appel à la méthode sql pour récupérer le motDePasse d'un ID 
		
		try {
			leMdp = UtilisateurManager.getInstance().afficherMotDePasse(pseudo);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(motDePasse.equals(leMdp)) {
			mdpValide = true;
			laJsp = "/WEB-INF/connected.jsp";
		}
		else {
			mdpValide = false;
			laJsp = "/WEB-INF/connexion.jsp";
			
		}
		
		RequestDispatcher aiguilleur = getServletContext().getRequestDispatcher(laJsp);
		aiguilleur.forward(request, response);
	}

}
