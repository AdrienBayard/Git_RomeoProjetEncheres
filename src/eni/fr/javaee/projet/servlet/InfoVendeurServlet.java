package eni.fr.javaee.projet.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eni.fr.javaee.projet.bll.BLLException;
import eni.fr.javaee.projet.bll.UtilisateurManager;

/**
 * Servlet implementation class InfoVendeurServlet
 */
@WebServlet("/InfoVendeurServlet")
public class InfoVendeurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoVendeurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pseudoVendeur = request.getParameter("trackingVendeur"); 
		
		try {
			String pseudo = UtilisateurManager.getInstance().afficherProfil(pseudoVendeur).getPseudo();
			String codePostal = UtilisateurManager.getInstance().afficherProfil(pseudoVendeur).getCodePostal();
			String ville = UtilisateurManager.getInstance().afficherProfil(pseudoVendeur).getVille();
			request.setAttribute("pseudo", pseudo);
			request.setAttribute("codePostal", codePostal);
			request.setAttribute("ville", ville);
			
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		RequestDispatcher aiguilleur = getServletContext().getRequestDispatcher("/lienprofil");
		aiguilleur.forward(request, response);
	}


}
