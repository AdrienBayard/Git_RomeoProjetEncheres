package fr.eni.javaee.projet.dal;

import eni.fr.javaee.projet.dal.jdbc.ArticleDAOJdbcImpl;
import eni.fr.javaee.projet.dal.jdbc.UtilisateurDAOJdbcImpl;

public class ArticleDAOFactory {
	
public static ArticleDAO getArticleDAO() {
		
		return new ArticleDAOJdbcImpl();
	}

}
