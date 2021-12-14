package fr.eni.javaee.projet.dal;

import eni.fr.javaee.projet.dal.jdbc.ArticleDAOJdbcImpl;
import eni.fr.javaee.projet.dal.jdbc.EnchereDAOJdbcImpl;
import eni.fr.javaee.projet.dal.jdbc.UtilisateurDAOJdbcImpl;

public class ProjetDAOFactory {
	
public static UtilisateurDAO getUtilisateurDAO() {
		
		return new UtilisateurDAOJdbcImpl();
	}




public static ArticleDAO getArticleDAO() {
	
	return new ArticleDAOJdbcImpl();
}

public static EnchereDAO getEnchereDAO() {
	
	return new EnchereDAOJdbcImpl();
}

}