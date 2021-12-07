package eni.fr.javaee.projet.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import eni.fr.javaee.projet.bo.Utilisateur;
import fr.eni.javaee.projet.dal.DALException;
import fr.eni.javaee.projet.dal.UtilisateurDAO;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {

	private static final String AFFICHER_PROFIL = "select pseudo, nom, prenom, email, telephone, rue, code_postal,ville from UTILISATEURS where pseudo ='?'";
	
	private static final String INSERT_NEW_UTILISATEUR = "INSERT INTO UTILISATEURS(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe) VALUES(?,?,?,?,?,?,?,?,?)";

	private static final String UPDATE_UTILISATEUR = "UPDATE UTILISATEURS SET pseudo = ?, nom = ?, prenom = ?, email = ?, telephone = ?, rue = ?, code_postal = ?, ville = ?, mot_de_passe = ? where no_utilisateur =?";
	
	private static final String DELETE_UTILISATEUR = "DELETE FROM UTILISATEURS Where no_utilisateur = ?";
	
	@Override
	public Utilisateur afficherProfil(String pseudo) throws DALException {

		Utilisateur utilisateur = null;

		// Obtenir une connexion
		Connection cnx = ConnectionProvider.getConnection();

		// Obtient une objet de commande (Statement) = ordre SQL
		try {

			// Paramétrer l'objet de commande

			PreparedStatement pStmt = cnx.prepareStatement(AFFICHER_PROFIL);
			pStmt.setString(1, pseudo);

			// Execute l'ordre SQL
			ResultSet rs = null;
			rs = pStmt.executeQuery();

			if (rs.next()) {
				utilisateur = mapAfficherProfil(rs);
			}

			cnx.close();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return utilisateur;
	}

	@Override
	public Utilisateur insertUtilisateur(Utilisateur nouvelUtilisateur) throws DALException {

		Utilisateur utilisateur = null;

		// Obtenir une connexion
		Connection cnx = ConnectionProvider.getConnection();

		// Obtient une objet de commande (Statement) = ordre SQL
		try {

			// Paramétrer l'objet de commande

			PreparedStatement pStmt = cnx.prepareStatement(INSERT_NEW_UTILISATEUR, Statement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, nouvelUtilisateur.getPseudo());
			pStmt.setString(2, nouvelUtilisateur.getNom());
			pStmt.setString(3, nouvelUtilisateur.getPrenom());
			pStmt.setString(4, nouvelUtilisateur.getEmail());
			pStmt.setString(5, nouvelUtilisateur.getTelephone());
			pStmt.setString(6, nouvelUtilisateur.getRue());
			pStmt.setString(7, nouvelUtilisateur.getCodePostal());
			pStmt.setString(8, nouvelUtilisateur.getVille());
			pStmt.setString(9, nouvelUtilisateur.getMotDePasse());

			// Execute l'ordre SQL
			ResultSet rs = null;

			pStmt.executeUpdate();
			rs = pStmt.getGeneratedKeys();

			if (rs.next()) {
				int idUtilisateurInsere = rs.getInt(1);
				nouvelUtilisateur.setNoUtilisateur(idUtilisateurInsere);
			}

			cnx.close();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return utilisateur;
	}
	
	public void updateUtilisateur(Utilisateur utilisateurModifie) throws DALException {
		// Obtenir une connexion
		Connection cnx = ConnectionProvider.getConnection();

		// Obtient une objet de commande (Statement) = ordre SQL
		try {

			// Paramétrer l'objet de commande

			PreparedStatement pStmt = cnx.prepareStatement(UPDATE_UTILISATEUR);
			pStmt.setString(1, utilisateurModifie.getPseudo());
			pStmt.setString(2, utilisateurModifie.getNom());
			pStmt.setString(3, utilisateurModifie.getPrenom());
			pStmt.setString(4, utilisateurModifie.getEmail());
			pStmt.setString(5, utilisateurModifie.getTelephone());
			pStmt.setString(6, utilisateurModifie.getRue());
			pStmt.setString(7, utilisateurModifie.getCodePostal());
			pStmt.setString(8, utilisateurModifie.getVille());
			pStmt.setString(9, utilisateurModifie.getMotDePasse());

			// Execute l'ordre SQL
			pStmt.executeUpdate();

			cnx.close();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

	}
	
	public void deleteUtilisateur(int idUtilisateur) throws DALException {
		// Obtenir une connexion
		Connection cnx = ConnectionProvider.getConnection();

		// Obtient une objet de commande (Statement) = ordre SQL
		try {

			// Paramétrer l'objet de commande

			PreparedStatement pStmt = cnx.prepareStatement(DELETE_UTILISATEUR);

			pStmt.setInt(1, idUtilisateur);

			// Execute l'ordre SQL
			pStmt.executeUpdate();

			cnx.close();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

	}
	
	@Override
	public String afficherMotDePasse(String pseudo) throws DALException {

		Utilisateur utilisateur = null;
		String motDePasse = null;

		// Obtenir une connexion
		Connection cnx = ConnectionProvider.getConnection();

		// Obtient une objet de commande (Statement) = ordre SQL
		try {

			// Paramétrer l'objet de commande

			PreparedStatement pStmt = cnx.prepareStatement(AFFICHER_PROFIL);
			pStmt.setString(1, pseudo);

			// Execute l'ordre SQL
			ResultSet rs = null;
			rs = pStmt.executeQuery();

			if (rs.next()) {
				utilisateur = mapAfficherProfil(rs);
				motDePasse = utilisateur.getMotDePasse();
			}

			cnx.close();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return motDePasse;
	}
	

	public Utilisateur mapAfficherProfil(ResultSet rs) throws SQLException {
		Utilisateur utilisateur = null;
		String pseudo = rs.getString("pseudo");
		String nom = rs.getString("nom");
		String prenom = rs.getString("prenom");
		String email = rs.getString("email");
		String telephone = rs.getString("telephone");
		String rue = rs.getString("rue");
		String code_postal = rs.getString("code_postal");
		String ville = rs.getString("ville");

		utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, code_postal, ville);

		return utilisateur;
	}

	@Override
	public List<Utilisateur> getListeUtilisateur() throws DALException {
		// Obtenir une connexion
		Connection cnx = ConnectionProvider.getConnection();
		
		
		
		
		return null;
	}

}
