package eni.fr.javaee.projet.servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eni.fr.javaee.projet.bll.BLLException;
import eni.fr.javaee.projet.bll.UtilisateurManager;
import eni.fr.javaee.projet.bo.Utilisateur;

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
			leMdp = UtilisateurManager.getInstance().afficherProfil(pseudo).getMotDePasse();
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
		HttpSession session = request.getSession();
		session.setAttribute("pseudo", pseudo);
		request.setAttribute("mdpValide", mdpValide);
		RequestDispatcher aiguilleur = getServletContext().getRequestDispatcher(laJsp);
		aiguilleur.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Boolean inscription = true;

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

		// Récupération des pseudos et mail déjà existants.
		List<Utilisateur> listUtilExistants;
		try {
			listUtilExistants = UtilisateurManager.getInstance().getListeUtilisateurs();
			for (Utilisateur user : listUtilExistants) {
				if ((!user.getPseudo().equals(pseudo)) && (!user.getEmail().equals(email)) && (motDePasse.equals(confirmation))) {
					inscription = true;
				} else if ((user.getPseudo().equals(pseudo)) || (user.getEmail().equals(email))
						|| (!motDePasse.equals(confirmation))) {
					inscription = false;
					
					if ((user.getPseudo().equals(pseudo)) && (user.getEmail().equals(email))) {
						request.setAttribute("messageErreur", 4); // Msg : Pseudo ou adresse mail déjà utilisés.
					} 
					
					else if (user.getPseudo().equals(pseudo)) {
						request.setAttribute("messageErreur", 2); // Msg : Pseudo déjà utilisé
					}
					else if (user.getEmail().equals(email)) {
						request.setAttribute("messageErreur", 3); // Msg : Mail déjà utilisé
					}
					else if (!motDePasse.equals(confirmation)) {
						request.setAttribute("messageErreur", 1); // Msg : le mdp et la confirmation doivent être
																	// identiques.
					}
					break;
				}
			}

			if (inscription == true) {
				UtilisateurManager.getInstance().insertUtilisateur(pseudo, nom, prenom, email, telephone, rue,
						codePostal, ville, motDePasse);
				HttpSession session = request.getSession();
				session.setAttribute("pseudo", pseudo);
				RequestDispatcher aiguilleur = getServletContext().getRequestDispatcher("/connected");
				aiguilleur.forward(request, response);

			} else if (inscription == false) {
					RequestDispatcher aiguilleur = getServletContext().getRequestDispatcher("/inscription");
					aiguilleur.forward(request, response);
			}

		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
