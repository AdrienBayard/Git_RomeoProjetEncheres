package eni.fr.javaee.projet.dal.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * Singleton
 *
 */
public class ConnectionProvider {
	
	private static final String POOL_RACINE_JNDI = "java:comp/env/";
	private static final String POOL_NOM_JNDI = "jdbc/Projet_Romeo404";// <-- seul ceci change entre 2 applications
	
	private static DataSource dataSource ; /// pool de connexions auquel demander les connexions
	
	private static ConnectionProvider instance;
	

	private ConnectionProvider () {
		
		// Obtenir l'annuaire JNDI
		Context annuaire = null;
		try {
			annuaire = new InitialContext();
		} catch (NamingException ne) {
			ne.printStackTrace();
		}
				
		// Obtenir le pool de connexions
		try {
			dataSource = (DataSource)annuaire.lookup(POOL_RACINE_JNDI + POOL_NOM_JNDI);
		} catch (NamingException ne) {
			ne.printStackTrace();
		}
	}
	
	public static ConnectionProvider getInstance() {
		if (instance==null) {
			instance = new ConnectionProvider();
		}
			
		return instance;
	}
	
	
	@SuppressWarnings("static-access")
	public static Connection getConnection() {
		
		// Obtenir une connexion du pool
		Connection cnx = null;
		try {
			cnx = getInstance().dataSource.getConnection();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return cnx;
		
	}
	
	

}









