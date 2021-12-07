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

	public Utilisateur afficherProfil(String pseudo) throws BLLException {

		BLLException ex = new BLLException();
		validationPseudo(pseudo, ex);
		Utilisateur utilisateur = null;
		try {
			utilisateur = dao.afficherProfil(pseudo);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return utilisateur;

	}

	public Utilisateur insertUtilisateur(String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse) throws BLLException {
		Utilisateur utilisateur = null;
		BLLException ex = new BLLException();
		validationPseudo(pseudo, ex);
		validationNom(nom, ex);
		validationPrenom(prenom, ex);
		validationEmail(email, ex);
		validationTelephone(telephone, ex);
		validationRue(rue, ex);
		validationCodePostal(codePostal, ex);
		validationVille(ville, ex);
		validationMotDePasse(motDePasse, ex);
		utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse);

		try {
			utilisateur = dao.insertUtilisateur(utilisateur);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return utilisateur;

	}

	public String afficherMotDePasse(String pseudo) throws BLLException {
		BLLException ex = new BLLException();
		validationPseudo(pseudo, ex);
		String motDePasse = null;
		try {
			motDePasse = dao.afficherMotDePasse(pseudo);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
			String codePostal, String ville, String motDePasse) throws BLLException {

		BLLException ex = new BLLException();
		validationPseudo(pseudo, ex);
		validationNom(nom, ex);
		validationPrenom(prenom, ex);
		validationEmail(email, ex);
		validationTelephone(telephone, ex);
		validationRue(rue, ex);
		validationCodePostal(codePostal, ex);
		validationVille(ville, ex);
		validationMotDePasse(motDePasse, ex);
		Utilisateur nouvelUtilisateur = null;
		nouvelUtilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse);

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

	private void validationPseudo(String pseudo, BLLException ex) throws BLLException {
		if (pseudo == null || pseudo.isEmpty() || pseudo.length() > 30) {
			ex.ajouterErreur(new ParameterException(
					"Le pseudo est obligatoire et doit avoir une longueur comprise entre 1 et 30"));
		}
	}

	private void validationNom(String nom, BLLException ex) throws BLLException {
		if (nom == null || nom.isEmpty() || nom.length() > 30) {
			ex.ajouterErreur(
					new ParameterException("Le nom est obligatoire et doit avoir une longueur comprise entre 1 et 30"));
		}
	}

	private void validationPrenom(String prenom, BLLException ex) throws BLLException {
		if (prenom == null || prenom.isEmpty() || prenom.length() > 30) {
			ex.ajouterErreur(new ParameterException(
					"Le prenom est obligatoire et doit avoir une longueur comprise entre 1 et 30"));
		}
	}

	private void validationEmail(String email, BLLException ex) throws BLLException {
		if (email == null || email.isEmpty() || email.length() > 30) {
			ex.ajouterErreur(new ParameterException(
					"L'email est obligatoire et doit avoir une longueur comprise entre 1 et 30"));
		}
	}

	private void validationTelephone(String telephone, BLLException ex) throws BLLException {
		if (telephone == null || telephone.isEmpty() || telephone.length() > 15) {
			ex.ajouterErreur(new ParameterException(
					"Le numero de telephone est obligatoire et doit avoir une longueur comprise entre 1 et 15"));
		}
	}

	private void validationRue(String rue, BLLException ex) throws BLLException {
		if (rue == null || rue.isEmpty() || rue.length() > 15) {
			ex.ajouterErreur(
					new ParameterException("La rue est obligatoire et doit avoir une longueur comprise entre 1 et 30"));
		}
	}

	private void validationCodePostal(String codePostal, BLLException ex) throws BLLException {
		if (codePostal == null || codePostal.isEmpty() || codePostal.length() > 10) {
			ex.ajouterErreur(new ParameterException(
					"Le code postal est obligatoire et doit avoir une longueur comprise entre 1 et 10"));
		}
	}

	private void validationVille(String ville, BLLException ex) throws BLLException {
		if (ville == null || ville.isEmpty() || ville.length() > 50) {
			ex.ajouterErreur(new ParameterException(
					"La ville est obligatoire et doit avoir une longueur comprise entre 1 et 50"));
		}
	}

	private void validationMotDePasse(String motDePasse, BLLException ex) throws BLLException {
		if (motDePasse == null || motDePasse.isEmpty() || motDePasse.length() > 30) {
			ex.ajouterErreur(new ParameterException(
					"La ville est obligatoire et doit avoir une longueur comprise entre 1 et 30"));
		}
	}

}
