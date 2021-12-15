package eni.fr.javaee.projet.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import eni.fr.javaee.projet.bll.ArticleManager;
import eni.fr.javaee.projet.bll.BLLException;
import eni.fr.javaee.projet.bll.UtilisateurManager;
import eni.fr.javaee.projet.bo.ArticleVendu;
import eni.fr.javaee.projet.bo.Enchere;

import fr.eni.javaee.projet.dal.DALException;
import fr.eni.javaee.projet.dal.EnchereDAO;

public class EnchereDAOJdbcImpl implements EnchereDAO {

	// Requetes SQL
	private static final String TROUVER_MEILLEUR_ENCHERISSEUR = "SELECT TOP 1 e.no_utilisateur, e.montant_enchere \r\n "
			+ " FROM ENCHERES e inner join ARTICLES_VENDUS a on a.no_article = e.no_article \r\n " + " WHERE a.no_article = ? \r\n "
			+ " ORDER BY e.montant_enchere DESC ";
	
	private static final String TROUVER_ARTICLE_ENCHERIT = "select no_article from ENCHERES WHERE no_utilisateur = ? group by no_article"; 
	
	private static final String INSERT_ENCHERE = "INSERT INTO ENCHERES(montant_enchere, no_article, no_utilisateur) values (?, ?, ?)"; 
	// INSERT enchère ------------------------------------------------------------------------
	public void insertEnchere(Enchere enchere) throws DALException {
		

		// Obtenir une connexion
		Connection cnx = ConnectionProvider.getConnection();
		
		// Obtient une objet de commande (Statement) = ordre SQL
		ResultSet rs = null;
		

		// Paramétrer l'objet de commande
		try {
				PreparedStatement pStmt = cnx.prepareStatement(INSERT_ENCHERE, Statement.RETURN_GENERATED_KEYS);
				pStmt.setInt(1, enchere.getMontant_enchere()); 
				pStmt.setInt(2, enchere.getNumArticle());
				pStmt.setInt(3, enchere.getNoUtilisateur()); 
				
		// Execute l'ordre SQL
		pStmt.executeUpdate();
		rs = pStmt.getGeneratedKeys();		
		
		if (rs.next()) {
			int idEnchereInseree = rs.getInt(1);
			enchere.setNumEnchere(idEnchereInseree); 
		}
				
		} catch (SQLException e) {
				e.printStackTrace();
		} finally {
			if(rs != null) {
				
				try {
					cnx.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
			}

		}	
		
	}
	
	
	
	

	// Trouver Article encherit ------------------------------------------------------------------
	public List<ArticleVendu> trouverArticleEncherit(int noUtilisateur) throws DALException {
		
		int acheteur = 0;
		List<ArticleVendu> listeArticleEncherit = new ArrayList<>();
		Connection cnx = ConnectionProvider.getConnection();

// Obtient une objet de commande (Statement) = ordre SQL
		ResultSet rs = null;
		try {

// Paramétrer l'objet de commande
			PreparedStatement pStmt = cnx.prepareStatement(TROUVER_ARTICLE_ENCHERIT);
			pStmt.setInt(1, noUtilisateur);

// Execute l'ordre SQL
			rs = pStmt.executeQuery();

// pStmt.executeUpdate();

			while(rs.next()) {
				int noArticle = rs.getInt(1);
				ArticleVendu article;
				try {
					article = ArticleManager.getInstance().selectArticleById(noArticle);
					listeArticleEncherit.add(article); 
				} catch (BLLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 	
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {

			try {
				cnx.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return listeArticleEncherit;
	}


	// Trouver meilleur encherisseur --------------------------------------------------------------
	@Override
	public Enchere trouverMeilleurEncherisseur(int noArticle) throws DALException {
		
			Enchere nouvelleEnchere = null;

			Connection cnx = ConnectionProvider.getConnection();

	// Obtient une objet de commande (Statement) = ordre SQL
			ResultSet rs = null;
			try {

	// Paramétrer l'objet de commande
				PreparedStatement pStmt = cnx.prepareStatement(TROUVER_MEILLEUR_ENCHERISSEUR);
				pStmt.setInt(1, noArticle);

	// Execute l'ordre SQL
				rs = pStmt.executeQuery();

	// pStmt.executeUpdate();

				if(rs.next()) {
					int noAcheteur = rs.getInt(2);
					int montantEnchere = rs.getInt(1);
					nouvelleEnchere = new Enchere (noAcheteur, montantEnchere);
				}

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
			return nouvelleEnchere;
		}
	

// MAP Construction Article ------------------------------------

}

