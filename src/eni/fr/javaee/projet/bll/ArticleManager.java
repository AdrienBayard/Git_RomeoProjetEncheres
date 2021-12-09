package eni.fr.javaee.projet.bll;

import fr.eni.javaee.projet.dal.ProjetDAOFactory;
import fr.eni.javaee.projet.dal.ArticleDAO;
import fr.eni.javaee.projet.dal.ArticleDAOFactory;
import fr.eni.javaee.projet.dal.DALException;

public class ArticleManager {

	// Création du singleton

	private static ArticleManager instance;

	private static ArticleDAO dao;

	private ArticleManager() {
		dao = ProjetDAOFactory.getArticleDAO();
	};

	public static ArticleManager getInstance() {
		if (instance == null) {
			instance = new ArticleManager();
		}
		return instance;
	}
	
	
	
}
