package eni.fr.javaee.projet.bll;

import fr.eni.javaee.projet.dal.ProjetDAO;
import fr.eni.javaee.projet.dal.ProjetDAOFactory;

public class ProjetManager {
	
	//Création du singleton
	
private static ProjetManager instance;
	
	private static ProjetDAO dao;
	
	private ProjetManager() {
		dao = ProjetDAOFactory.getProjetDAO();
	};

	public static ProjetManager getInstance() {
		if(instance == null) {
			instance = new ProjetManager();
		}
		return instance;
	}
	
	/**
	 * TODO : Importer toutes les méthodes de la DAO
	 */

}
