package fr.eni.javaee.projet.dal;

import eni.fr.javaee.projet.dal.jdbc.ProjetDAOJdbcImpl;

public class ProjetDAOFactory {
	
public static ProjetDAO getProjetDAO() {
		
		return new ProjetDAOJdbcImpl();
	}

}
