package eni.fr.javaee.projet.dal.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import eni.fr.javaee.projet.bo.Utilisateur;
import fr.eni.javaee.projet.dal.DALException;
import fr.eni.javaee.projet.dal.ProjetDAO;

public class ProjetDAOJdbcImpl implements ProjetDAO {
	
	private static final String AFFICHER_TOUS_LES_UTILISATEURS = ""; //TODO : Importer la méthode SQL
	
	private static final String INSERT_NEW_UTILISATEUR = ""; //TODO : Importer la méthode SQL
	
	private static final String UPDATE_UTILISATEUR = ""; 	//TODO : Importer la méthode SQL
	
	private static final String AFFICHER_PROFIL = ""; //TODO : Importer la méthode SQL
	
	@Override
	public List<Utilisateur> afficherTousLesUtilisateurs() throws DALException {

		List<Utilisateur> listeDesUtilisateurs = new ArrayList<Utilisateur>();
		
		// Obtenir une connexion
		Connection cnx = ConnectionProvider.getConnection();
		
		// Obtient une objet de commande (Statement) = ordre SQL
		Statement ordre = null;
		try {
			ordre = cnx.createStatement();
		
		// Paramétrer l'objet de commande
		
		
		// Execute l'ordre SQL
		ResultSet rs = null;
		rs = ordre.executeQuery(AFFICHER_TOUS_LES_UTILISATEURS);
		
		while(rs.next()) {
			
		}
		
		
		cnx.close();
		
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}	
		
		return listeDesUtilisateurs;
	}

	
	
	

}
