package eni.fr.javaee.projet.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import eni.fr.javaee.projet.bo.Utilisateur;
import fr.eni.javaee.projet.dal.DALException;
import fr.eni.javaee.projet.dal.UtilisateurDAO;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {

	// Requête utilisée lors de l'inscription
	private static final String AFFICHER_TOUS_LES_PROFILS = "SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit from UTILISATEURS";

	private static final String AFFICHER_PROFIL = "SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit from UTILISATEURS where pseudo = ?";

	private static final String AFFICHER_PROFIL_AVEC_ID = "SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit from UTILISATEURS where no_utilisateur = ?";

	private static final String INSERT_NEW_UTILISATEUR = "INSERT INTO UTILISATEURS(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe) VALUES(?,?,?,?,?,?,?,?,?)";

	private static final String UPDATE_UTILISATEUR = "UPDATE UTILISATEURS SET pseudo = ?, nom = ?, prenom = ?, email = ?, telephone = ?, rue = ?, code_postal = ?, ville = ?, mot_de_passe = ?, credit = ? where no_utilisateur =?";

	private static final String DELETE_UTILISATEUR = "DELETE FROM UTILISATEURS Where no_utilisateur = ?";

	@Override
	public Utilisateur afficherProfil(String pseudo) throws DALException {

		Utilisateur utilisateur = null;
		ResultSet rs = null;

		// Obtenir une connexion
		Connection cnx = ConnectionProvider.getConnection();

		// Obtient une objet de commande (Statement) = ordre SQL
		try {

			// Paramétrer l'objet de commande

			PreparedStatement pStmt = cnx.prepareStatement(AFFICHER_PROFIL);
			pStmt.setString(1, pseudo);

			// Execute l'ordre SQL
			rs = pStmt.executeQuery();

			if (rs.next()) {
				utilisateur = mapAfficherProfil(rs);
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			if (rs != null) {

				try {
					cnx.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return utilisateur;
	}

	@Override
	public Utilisateur afficherProfilAvecId(int id) throws DALException {

		Utilisateur utilisateur = null;

		// Obtenir une connexion
		Connection cnx = ConnectionProvider.getConnection();

		// Obtient une objet de commande (Statement) = ordre SQL
		ResultSet rs = null;
		try {

			// Paramétrer l'objet de commande

			PreparedStatement pStmt = cnx.prepareStatement(AFFICHER_PROFIL_AVEC_ID);
			pStmt.setInt(1, id);

			// Execute l'ordre SQL
			rs = pStmt.executeQuery();

			if (rs.next()) {
				utilisateur = mapAfficherProfil(rs);
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			if (rs != null) {

				try {
					cnx.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return utilisateur;
	}

	@Override
	public Utilisateur insertUtilisateur(Utilisateur nouvelUtilisateur) throws DALException {

		Utilisateur utilisateur = null;

		// Obtenir une connexion
		Connection cnx = ConnectionProvider.getConnection();

		// Obtient une objet de commande (Statement) = ordre SQL
		ResultSet rs = null;
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

			pStmt.executeUpdate();
			rs = pStmt.getGeneratedKeys();

			if (rs.next()) {
				int idUtilisateurInsere = rs.getInt(1);
				nouvelUtilisateur.setNoUtilisateur(idUtilisateurInsere);
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			if (rs != null) {

				try {
					cnx.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
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
			pStmt.setInt(10, utilisateurModifie.getCredit());
			pStmt.setInt(11, utilisateurModifie.getNoUtilisateur());

			// Execute l'ordre SQL
			pStmt.executeUpdate();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {

			try {
				cnx.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
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

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		finally {
				
				try {
					cnx.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				
			}
		}

	}

	public Utilisateur mapAfficherProfil(ResultSet rs) throws SQLException {
		Utilisateur utilisateur = null;
		int id = rs.getInt("no_utilisateur");
		String pseudo = rs.getString("pseudo");
		String nom = rs.getString("nom");
		String prenom = rs.getString("prenom");
		String email = rs.getString("email");
		String telephone = rs.getString("telephone");
		String rue = rs.getString("rue");
		String code_postal = rs.getString("code_postal");
		String ville = rs.getString("ville");
		String motDePasse = rs.getString("mot_de_passe");
		int credit = rs.getInt("credit");

		utilisateur = new Utilisateur(id, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, motDePasse,
				credit);

		return utilisateur;
	}

	@Override
	public List<Utilisateur> getListeUtilisateur() throws DALException {

		List<Utilisateur> listeUtilisateursExistants = new ArrayList<Utilisateur>();

		// Obtenir une connexion
		Connection cnx = ConnectionProvider.getConnection();

		ResultSet rs = null;
		// Insérer la requête VERIF UTILISATEUR => Sert à vérifier, lors de
		// l'inscription que le pseudo et mail ne sotn pas pris.
		try {
			Statement pStmt = cnx.createStatement();

			rs = pStmt.executeQuery(AFFICHER_TOUS_LES_PROFILS);

			while (rs.next()) {

				Utilisateur user = mapAfficherProfil(rs);
				listeUtilisateursExistants.add(user);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(rs!= null) {
				
				try {
					cnx.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return listeUtilisateursExistants;
	}

}
