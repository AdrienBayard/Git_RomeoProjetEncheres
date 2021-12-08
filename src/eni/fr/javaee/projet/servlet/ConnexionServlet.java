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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pseudo = request.getParameter("pseudo");
		String motDePasse = request.getParameter("motDePasse");
		String laJsp = null;
		Boolean mdpValide = true;
		String leMdp = null;

		// faire appel à la méthode sql pour récupérer le motDePasse d'un pseudo
		try {
			leMdp = UtilisateurManager.getInstance().afficherMotDePasse(pseudo);
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (motDePasse.equals(leMdp)) {
			mdpValide = true;
			laJsp = "/WEB-INF/jsp/connected.jsp";
		} else {
			mdpValide = false;
			laJsp = "/WEB-INF/jsp/connexion.jsp";

		}
		request.setAttribute("mdpValide", mdpValide);
		RequestDispatcher aiguilleur = getServletContext().getRequestDispatcher(laJsp);
		aiguilleur.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Boolean inscription = true;
		int msgErreur = 0;

		// Récupération des informations du client depuis le formulaire.
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		String motDePasse = request.getParameter("motDePasse");
		String confirmation = request.getParameter("confirmation");

		// Blocage en cas de mdp - confirmation sont différents.
		if (motDePasse != confirmation) {
			msgErreur = 1; // Msg : le mdp et la confirmation doivent être identiques. 
		}

		// Récupération des pseudos et mail déjà existants.
		List<Utilisateur> listUtilExistants;
		try {
			listUtilExistants = UtilisateurManager.getInstance().getListeUtilisateurs();
			for (Utilisateur user : listUtilExistants) {
				if ((user.getPseudo() != pseudo) && (user.getEmail() != email)) {
					inscription = true;
				} else {
					inscription = false;
				}
			}

			if (inscription == true) {
				UtilisateurManager.getInstance().insertUtilisateur(pseudo, nom, prenom, email,telephone, rue, codePostal, ville, motDePasse);
				RequestDispatcher aiguilleur = getServletContext().getRequestDispatcher("/WEB-INF/jsp/connected.jsp");
				aiguilleur.forward(request, response);
			} else if (inscription == false) {
				msgErreur = 2; // Msg : Pseudo ou adresse mail déjà utilisés.
				RequestDispatcher aiguilleur = getServletContext().getRequestDispatcher("/WEB-INF/jsp/inscription.jsp");
				aiguilleur.forward(request, response);
			}

		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
