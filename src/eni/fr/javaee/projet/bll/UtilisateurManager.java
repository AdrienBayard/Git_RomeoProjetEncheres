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

	public void deleteUtilisateur(int idUtilisateur) throws BLLException {

		BLLException ex = new BLLException();

		validationId(idUtilisateur, ex);

		if (ex.hasErreur()) {
			throw ex;
		}

		try {
			dao.deleteUtilisateur(idUtilisateur);
		} catch (DALException e) {
			e.printStackTrace();
			ex.ajouterErreur(e);
			throw ex;
		}

	}

	public void updateUtilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String codePostal, String ville) throws BLLException {

		BLLException ex = new BLLException();

		Utilisateur nouvelUtilisateur = null;
		nouvelUtilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville);

		if (ex.hasErreur()) {
			throw ex;
		}

		try {
			dao.updateUtilisateur(nouvelUtilisateur);
		} catch (DALException e) {
			e.printStackTrace();
			ex.ajouterErreur(e);
			throw ex;
		}

	}

	private void validationId(int idUtilisateur, BLLException ex) throws BLLException {
		if (idUtilisateur < 1) {
			ex.ajouterErreur(new ParameterException("L'id doit Etre un entier positif >= 1"));
		}
	}
}
