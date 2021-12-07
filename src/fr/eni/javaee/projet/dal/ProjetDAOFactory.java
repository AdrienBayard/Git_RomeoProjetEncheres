package fr.eni.javaee.projet.dal;

import eni.fr.javaee.projet.dal.jdbc.UtilisateurDAOJdbcImpl;

public class ProjetDAOFactory {
	
public static UtilisateurDAO getUtilisateurDAO() {
		
		return new UtilisateurDAOJdbcImpl();
	}

}
