package eni.fr.javaee.projet.bll;

import fr.eni.javaee.projet.dal.UtilisateurDAO;
import eni.fr.javaee.projet.bo.Utilisateur;
import fr.eni.javaee.projet.dal.DALException;
import fr.eni.javaee.projet.dal.ProjetDAOFactory;

public class UtilisateurManager {

	// Création du singleton

	private static UtilisateurManager instance;

	private static UtilisateurDAO dao;

	private UtilisateurManager() {
		dao = ProjetDAOFactory.getUtilisateurDAO();
	};

	public static UtilisateurManager getInstance() {
		if (instance == null) {
			instance = new UtilisateurManager();
		}
		return instance;
	}

	public Utilisateur afficherProfil(String pseudo) throws DALException {

		Utilisateur utilisateur = dao.afficherProfil(pseudo);
		return utilisateur;

	}

	public Utilisateur insertUtilisateur(Utilisateur nouvelUtilisateur) throws DALException {
		Utilisateur utilisateur = dao.insertUtilisateur(nouvelUtilisateur);
		return utilisateur;

	}

	public String afficherMotDePasse(String pseudo) throws DALException {

		String motDePasse = dao.afficherMotDePasse(pseudo);
		return motDePasse;
	}
}
