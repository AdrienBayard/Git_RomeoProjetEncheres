package eni.fr.javaee.projet.bll;

import eni.fr.javaee.projet.bo.Enchere;
import fr.eni.javaee.projet.dal.DALException;
import fr.eni.javaee.projet.dal.EnchereDAO;
import fr.eni.javaee.projet.dal.ProjetDAOFactory;

public class EnchereManager {

	// Création du singleton

		private static EnchereManager instance;

		private static EnchereDAO dao;

		private EnchereManager() {
			dao = ProjetDAOFactory.getEnchereDAO();
		};

		public static EnchereManager getInstance() {
			if (instance == null) {
				instance = new EnchereManager();
			}
			return instance;
		}
	
	public Enchere trouverMeilleurEncherisseur(int noArticle) throws BLLException {
		Enchere nouvelleEnchere = null;
		
		try {
			nouvelleEnchere = dao.trouverMeilleurEncherisseur(noArticle);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return nouvelleEnchere;
	}
	
}
