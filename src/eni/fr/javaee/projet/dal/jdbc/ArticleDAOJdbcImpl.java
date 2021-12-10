package eni.fr.javaee.projet.dal.jdbc;

import fr.eni.javaee.projet.dal.ArticleDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import eni.fr.javaee.projet.bo.ArticleVendu;
import fr.eni.javaee.projet.dal.DALException;
import fr.eni.javaee.projet.dal.ArticleDAO;

public class ArticleDAOJdbcImpl implements ArticleDAO {

	private static final String AFFICHER_VENTES_EN_COURS = "SELECT a.nom_article,  MAX(e.montant_enchere), a.date_fin_encheres, a.no_utilisateur as vendeur\r\n "
			+ " from ARTICLES_VENDUS a\r\n" + "inner join ENCHERES e on e.no_article=a.no_article\r\n "
			+ " WHERE a.date_debut_encheres <= CURRENT_TIMESTAMP and a.date_fin_encheres>= CURRENT_TIMESTAMP  and a.no_utilisateur = ? \r\n "
			+ " group by a.nom_article, a.date_fin_encheres, a.no_utilisateur;\r\n " + "";

	private static final String AFFICHER_VENTES_NON_DEBUTEES = "SELECT a.nom_article,  MAX(e.montant_enchere), a.date_fin_encheres, a.no_utilisateur as vendeur\r\n "
			+ " from ARTICLES_VENDUS a\r\n" + "inner join ENCHERES e on e.no_article=a.no_article\r\n "
			+ " WHERE a.date_debut_encheres>= CURRENT_TIMESTAMP  \r\n" + "and a.no_utilisateur = ? \r\n "
			+ " group by a.nom_article, a.date_fin_encheres, a.no_utilisateur;\r\n " + "";

	private static final String AFFICHER_VENTES_TERMINEES = "SELECT a.nom_article,  MAX(e.montant_enchere), a.date_fin_encheres, a.no_utilisateur as vendeur\r\n "
			+ " from ARTICLES_VENDUS a\r\n" + "inner join ENCHERES e on e.no_article=a.no_article\r\n "
			+ " WHERE a.date_fin_encheres<= CURRENT_TIMESTAMP\r\n" + "and a.no_utilisateur = ? \r\n "
			+ " group by a.nom_article, a.date_fin_encheres, a.no_utilisateur;\r\n " + "";

	private static final String AFFICHER_ACHATS_EN_COURS = "SELECT * from ARTICLES_VENDUS where date_debut_encheres <= CURRENT_TIMESTAMP and date_fin_encheres >= CURRENT_TIMESTAMP";

	private static final String AFFICHER_ENCHERES_REMPORTEES = "SELECT a.nom_article,  MAX(e.montant_enchere), a.date_fin_encheres, a.no_utilisateur as vendeur\r\n "
			+ " from ARTICLES_VENDUS a\r\n" + "inner join ENCHERES e on e.no_article=a.no_article\r\n "
			+ " WHERE a.date_debut_encheres <= CURRENT_TIMESTAMP and a.date_fin_encheres>= CURRENT_TIMESTAMP \r\n "
			+ " group by a.nom_article, a.date_fin_encheres, a.no_utilisateur;\r\n " + "";

	private static final String AFFICHER_MES_ENCHERES = "SELECT a.nom_article,  MAX(e.montant_enchere), a.date_fin_encheres,  e.no_utilisateur  as acheteur\r\n "
			+ " from ARTICLES_VENDUS a\r\n" + "inner join ENCHERES e on e.no_article = a.no_article\r\n "
			+ " WHERE  a.date_fin_encheres <= CURRENT_TIMESTAMP group by a.nom_article, a.date_fin_encheres, e.montant_enchere, e.no_utilisateur;\r\n "
			+ " \r\n" + " \r\n "
			+ " Attention filtrer avec java que le e.no_utilisaiteur soit le même que l'utilisateur\r\n " + "";

	private static final String INSERT_VENTE = "INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial,no_utilisateur, no_categorie) VALUES (?,?,?,?,?,?,?);";

	private static final String UPDATE_VENTE = "UPDATE ARTICLES_VENDUS SET nom_article = ?, description=?, date_debut_encheres= ?, date_fin_encheres = ?, prix_initial=?, no_categorie=? where no_article =?;";

	private static final String DELETE_VENTE = "DELETE from ARTICLES_VENDUS where no_article = ?";

	public ArticleVendu insertVente(ArticleVendu nouvelArticleVendu) throws DALException {

		ArticleVendu articleVendu = null;

		// Obtenir une connexion
		Connection cnx = ConnectionProvider.getConnection();

		// Obtient une objet de commande (Statement) = ordre SQL
		try {

			// Paramétrer l'objet de commande

			Timestamp dateDebutTS = Timestamp.valueOf(nouvelArticleVendu.getDateDebutEncheres());
			Timestamp dateFinTS = Timestamp.valueOf(nouvelArticleVendu.getDateFinEncheres());

			PreparedStatement pStmt = cnx.prepareStatement(INSERT_VENTE, Statement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, nouvelArticleVendu.getNomArticle());
			pStmt.setString(2, nouvelArticleVendu.getDescription());
			pStmt.setTimestamp(3, dateDebutTS);
			pStmt.setTimestamp(4, dateFinTS);
			pStmt.setInt(5, nouvelArticleVendu.getMiseAPrix());
			pStmt.setInt(6, nouvelArticleVendu.getPrixVente());
			pStmt.setInt(7, nouvelArticleVendu.getCategorie());

			// Execute l'ordre SQL
			ResultSet rs = null;

			pStmt.executeUpdate();
			rs = pStmt.getGeneratedKeys();

			if (rs.next()) {
				int idArticleInsere = rs.getInt(1);
				nouvelArticleVendu.setNoArticle(idArticleInsere);
			}

			cnx.close();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return articleVendu;
	}

	@Override
	public ArticleVendu updateVente(ArticleVendu nouvelArticleVendu) throws DALException {
		// Obtenir une connexion
		Connection cnx = ConnectionProvider.getConnection();

		// Obtient une objet de commande (Statement) = ordre SQL
		try {

			// Paramétrer l'objet de commande

			Timestamp dateDebutTS = Timestamp.valueOf(nouvelArticleVendu.getDateDebutEncheres());
			Timestamp dateFinTS = Timestamp.valueOf(nouvelArticleVendu.getDateFinEncheres());

			PreparedStatement pStmt = cnx.prepareStatement(UPDATE_VENTE);
			pStmt.setString(1, nouvelArticleVendu.getNomArticle());
			pStmt.setString(2, nouvelArticleVendu.getDescription());
			pStmt.setTimestamp(3, dateDebutTS);
			pStmt.setTimestamp(4, dateFinTS);
			pStmt.setInt(5, nouvelArticleVendu.getMiseAPrix());
			pStmt.setInt(6, nouvelArticleVendu.getCategorie());
			pStmt.setInt(7, nouvelArticleVendu.getNoArticle());

			pStmt.executeUpdate();

			// Execute l'ordre SQL

			cnx.close();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return nouvelArticleVendu;
	}

	@Override
	public void deleteVente(int idArticle) throws DALException {
		Connection cnx = ConnectionProvider.getConnection();

		// Obtient une objet de commande (Statement) = ordre SQL
		try {

			// Paramétrer l'objet de commande

			PreparedStatement pStmt = cnx.prepareStatement(DELETE_VENTE);

			pStmt.setInt(1, idArticle);

			// Execute l'ordre SQL
			pStmt.executeUpdate();

			cnx.close();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	public List<ArticleVendu> afficherVentesEnCours() throws DALException {
		return null;

	}

	public List<ArticleVendu> afficherVentesNonDebutees() throws DALException {
		return null;

	}

	public List<ArticleVendu> afficherVentesTerminees() throws DALException {
		return null;

	}

	@Override
	public List<ArticleVendu> afficherAchatsEnCours() throws DALException {

		List<ArticleVendu> listeAchatsAAfficher = new ArrayList<ArticleVendu>();

		// Obtenir une connexion
		Connection cnx = ConnectionProvider.getConnection();
		try {
			Statement pStmt = cnx.createStatement();

			ResultSet rs = null;
			rs = pStmt.executeQuery(AFFICHER_ACHATS_EN_COURS);

			while (rs.next()) {

				ArticleVendu article = mapAfficherVente(rs);
				listeAchatsAAfficher.add(article);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listeAchatsAAfficher;
	}

//	private static final String AFFICHER_ENCHERES_REMPORTEES = "SELECT a.nom_article,  MAX(e.montant_enchere), a.date_fin_encheres, a.no_utilisateur as vendeur\r\n"
//			+ "from ARTICLES_VENDUS a\r\n" + "inner join ENCHERES e on e.no_article=a.no_article\r\n"
//			+ "WHERE a.date_debut_encheres <= CURRENT_TIMESTAMP and a.date_fin_encheres>= CURRENT_TIMESTAMP \r\n"
//			+ "group by a.nom_article, a.date_fin_encheres, a.no_utilisateur;\r\n" + "";
//
//	
	@Override
	public List<ArticleVendu> afficherEncheresRemportees() throws DALException {

		List<ArticleVendu> listeAchatsAAfficher = new ArrayList<ArticleVendu>();

		// Obtenir une connexion
		Connection cnx = ConnectionProvider.getConnection();
		try {
			Statement pStmt = cnx.createStatement();

			ResultSet rs = null;
			rs = pStmt.executeQuery(AFFICHER_ACHATS_EN_COURS);

			while (rs.next()) {

				ArticleVendu article = mapAfficherVente(rs);
				listeAchatsAAfficher.add(article);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listeAchatsAAfficher;
	}

	@Override
	public List<ArticleVendu> afficherMesEncheres() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArticleVendu mapAfficherVente(ResultSet rs) throws SQLException {
		ArticleVendu articleVendu = null;

		int no_Article = rs.getInt("no_article");
		String nomArticle = rs.getString("nom_article");
		String description = rs.getString("description");
		LocalDateTime dateDebutEncheres = rs.getTimestamp(4).toLocalDateTime();
		LocalDateTime dateFinEncheres = rs.getTimestamp(5).toLocalDateTime();
		int miseAPrix = rs.getInt("prix_initial");
		int prixVente = rs.getInt("prix_vente");
		int categorie = rs.getInt("no_categorie");
		int no_utilisateur = rs.getInt("no_utilisateur");

		articleVendu = new ArticleVendu(no_Article, nomArticle, description, dateDebutEncheres, dateFinEncheres,
				miseAPrix, prixVente, categorie, no_utilisateur);

		return articleVendu;
	}

}
