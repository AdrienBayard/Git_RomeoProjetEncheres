package eni.fr.javaee.projet.dal.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import eni.fr.javaee.projet.bo.Utilisateur;
import fr.eni.javaee.projet.dal.DALException;
import fr.eni.javaee.projet.dal.UtilisateurDAO;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {
	
	private static final String AFFICHER_PROFIL = "select pseudo, nom, prenom, email, telephone, rue, code_postal,ville from UTILISATEURS where pseudo ='?'"; //TODO : Importer la méthode SQL
	
	private static final String INSERT_NEW_UTILISATEUR = ""; //TODO : Importer la méthode SQL
	
	private static final String UPDATE_UTILISATEUR = ""; 	//TODO : Importer la méthode SQL
	
	
	@Override
	public List<Utilisateur> afficherProfil() throws DALException {

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
		rs = ordre.executeQuery(AFFICHER_PROFIL);
		
		while(rs.next()) {
			
		}
		
		
		cnx.close();
		
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}	
		
		return listeDesUtilisateurs;
	}

	
	
	

}
