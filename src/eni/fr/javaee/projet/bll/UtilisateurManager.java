package eni.fr.javaee.projet.bll;

import fr.eni.javaee.projet.dal.UtilisateurDAO;
import fr.eni.javaee.projet.dal.ProjetDAOFactory;

public class UtilisateurManager {
	
	//Création du singleton
	
private static UtilisateurManager instance;
	
	private static UtilisateurDAO dao;
	
	private UtilisateurManager() {
		dao = ProjetDAOFactory.getUtilisateurDAO();
	};

	public static UtilisateurManager getInstance() {
		if(instance == null) {
			instance = new UtilisateurManager();
		}
		return instance;
	}
	
	/**
	 * TODO : Importer toutes les méthodes de la DAO
	 */

}
