package eni.fr.javaee.projet.bll;

import java.util.ArrayList;
import java.util.List;

import eni.fr.javaee.projet.bo.ArticleVendu;
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
	
	public List<ArticleVendu> trouverArticleEncherit(int noUtilisateur){
		List<ArticleVendu> liste = new ArrayList<>(); 
		
		try {
			liste = dao.trouverArticleEncherit(noUtilisateur);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liste;
	}
	
	public void insertEnchere(int montant_enchere, int numArticle, int noUtilisateur) throws BLLException {
		Enchere nvlleEnchere = null; 
		
		nvlleEnchere = new Enchere(montant_enchere, numArticle, noUtilisateur); 
		
			try {
				dao.insertEnchere(nvlleEnchere);
			} catch (DALException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
}



