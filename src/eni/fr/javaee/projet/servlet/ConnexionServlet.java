package eni.fr.javaee.projet.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eni.fr.javaee.projet.bll.BLLException;
import eni.fr.javaee.projet.bll.UtilisateurManager;
import eni.fr.javaee.projet.bo.Utilisateur;
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
		Boolean mdpValide = true;
		String leMdp = null;
		
		//		faire appel à la méthode sql pour récupérer le motDePasse d'un pseudo 
		try {
			leMdp = UtilisateurManager.getInstance().afficherMotDePasse(pseudo);
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if(motDePasse.equals(leMdp)) {
			mdpValide = true;
			laJsp = "/WEB-INF/jsp/connected.jsp";
		}
		else {
			mdpValide = false;
			laJsp = "/WEB-INF/jsp/connexion.jsp";
			
		}
		request.setAttribute("mdpValide", mdpValide);
		RequestDispatcher aiguilleur = getServletContext().getRequestDispatcher(laJsp);
		aiguilleur.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// Récupération des informations du client depuis le formulaire.  
		String pseudo = req.getParameter("pseudo"); 
		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");
		String telephone = req.getParameter("telephone");
		String rue = req.getParameter("rue");
		String codePostal = req.getParameter("codePostal");
		String ville = req.getParameter("ville");
		String motDePasse = req.getParameter("motDePasse");
		String confirmation = req.getParameter("confirmation");
		
		// Récupération des pseudos et mail déjà existants. 
		try {
			List<Utilisateur> listUtilExistants = UtilisateurManager.getInstance().getListeUtilisateurs();
			
			for(Utilisateur user : listUtilExistants) {
				System.out.println(user.toString());
			}
		} catch (BLLException e) {
			e.printStackTrace();
		} 
		
		if(!motDePasse.equals(confirmation))
		
		super.doPost(req, resp);
	}
	
	

}
