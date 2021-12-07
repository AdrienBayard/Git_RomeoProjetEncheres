package fr.eni.javaee.projet.dal;

import eni.fr.javaee.projet.dal.jdbc.UtilisateurDAOJdbcImpl;

public class ProjetDAOFactory {
	
public static UtilisateurDAO getProjetDAO() {
		
		return new UtilisateurDAOJdbcImpl();
	}

}
