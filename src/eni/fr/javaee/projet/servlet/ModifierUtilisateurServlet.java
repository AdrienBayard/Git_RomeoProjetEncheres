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
 * Servlet implementation class ModifierUtilisateurServlet
 */
@WebServlet(name = "ModifierUtilisateur", urlPatterns = { "/modifier" })
public class ModifierUtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String pseudo = (String) session.getAttribute("pseudo");
		String afficherProfil =  request.getParameter("button");
		try {
			Utilisateur utilisateur = UtilisateurManager.getInstance().afficherProfil(pseudo);
			String nom = utilisateur.getNom();
			String prenom = utilisateur.getPrenom();
			String email = utilisateur.getEmail();
			String telephone = utilisateur.getTelephone();
			String rue = utilisateur.getRue();
			String codePostal = utilisateur.getCodePostal();
			String ville = utilisateur.getVille();
			String motDePasse = utilisateur.getMotDePasse();
		
			
			request.setAttribute("pseudo", pseudo);
			request.setAttribute("nom", nom);
			request.setAttribute("prenom", prenom);
			request.setAttribute("email", email);
			request.setAttribute("telephone", telephone);
			request.setAttribute("rue", rue);
			request.setAttribute("codePostal", codePostal);
			request.setAttribute("ville", ville);
			
			if (afficherProfil == null || afficherProfil.equals("false")) {
				
				RequestDispatcher aiguilleur = getServletContext().getRequestDispatcher("/monprofil");			
				aiguilleur.forward(request, response);
			}
			else if (afficherProfil.equals("true")){
				RequestDispatcher aiguilleur = getServletContext().getRequestDispatcher("/modifierprofil");			
				aiguilleur.forward(request, response);
			}
			
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Boolean modification = true;

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
					modification = true;
				} else if ((user.getPseudo().equals(pseudo)) || (user.getEmail().equals(email))
						|| (!motDePasse.equals(confirmation))) {
					modification = false;
					
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

			if (modification == true) {
				HttpSession session = request.getSession();
				String ancienPseudo = (String) session.getAttribute("pseudo");
				
				int noUtilisateur = UtilisateurManager.getInstance().afficherProfil(ancienPseudo).getNoUtilisateur();
				UtilisateurManager.getInstance().updateUtilisateur(noUtilisateur, pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse);
				RequestDispatcher aiguilleur = getServletContext().getRequestDispatcher("/connected");
				aiguilleur.forward(request, response);

			} else if (modification == false) {
					RequestDispatcher aiguilleur = getServletContext().getRequestDispatcher("/inscription");
					aiguilleur.forward(request, response);
			}

		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
