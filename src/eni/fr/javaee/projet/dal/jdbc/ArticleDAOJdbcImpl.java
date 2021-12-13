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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import eni.fr.javaee.projet.bll.ArticleManager;
import eni.fr.javaee.projet.bll.BLLException;
import eni.fr.javaee.projet.bll.UtilisateurManager;
import eni.fr.javaee.projet.bo.ArticleVendu;
import eni.fr.javaee.projet.bo.Utilisateur;
import fr.eni.javaee.projet.dal.DALException;
import jdk.nashorn.internal.ir.RuntimeNode.Request;
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
	
	private static final String TROUVER_MEILLEUR_ENCHERISSEUR = "SELECT TOP 1 e.no_utilisateur"
			+" FROM ENCHERES e , ARTICLES_VENDUS a/r/n "
			+" WHERE a.no_article = ?/r/n "
			+ " ORDER BY e.montant_enchere DESC /r/n"; 

//	private static final String AFFICHER_MES_ENCHERES = "select TOP 1 a.nom_article, a.date_fin_encheres, e.no_utilisateur, (e.montant_enchere) as PrixVente\r\n" + 
//			"from ARTICLES_VENDUS a inner join ENCHERES e on e.no_article = a.no_article\r\n" + 
//			"where a.no_article = ? and a.date_debut_encheres <= CURRENT_TIMESTAMP and a.date_fin_encheres >= CURRENT_TIMESTAMP\r\n" + 
//			"group by a.nom_article, a.date_fin_encheres, e.no_utilisateur, e.montant_enchere\r\n" + 
//			"ORDER BY e.montant_enchere DESC; " + "";

	private static final String INSERT_VENTE = "INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial,no_utilisateur, no_categorie) VALUES (?,?,?,?,?,?,?);";

	private static final String UPDATE_VENTE = "UPDATE ARTICLES_VENDUS SET nom_article = ?, description=?, date_debut_encheres= ?, date_fin_encheres = ?, prix_initial=?, no_categorie=? where no_article =?;";

	private static final String DELETE_VENTE = "DELETE from ARTICLES_VENDUS where no_article = ?";

	public ArticleVendu insertVente(ArticleVendu nouvelArticleVendu) throws DALException {

		ArticleVendu articleVendu = null;

		// Obtenir une connexion
		Connection cnx = ConnectionProvider.getConnection();

		// Obtient une objet de commande (Statement) = ordre SQL
		ResultSet rs = null;
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

			pStmt.executeUpdate();
			rs = pStmt.getGeneratedKeys();

			if (rs.next()) {
				int idArticleInsere = rs.getInt(1);
				nouvelArticleVendu.setNoArticle(idArticleInsere);
			}

		

		} catch (SQLException sqle) {
			sqle.printStackTrace();
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

		ResultSet rs = null;
		// Obtenir une connexion
		Connection cnx = ConnectionProvider.getConnection();
		try {
			Statement pStmt = cnx.createStatement();

			rs = pStmt.executeQuery(AFFICHER_ACHATS_EN_COURS);

			while (rs.next()) {

				ArticleVendu article = mapAfficherVente(rs);
				listeAchatsAAfficher.add(article);
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

		return listeAchatsAAfficher;
	}

//	private static final String AFFICHER_ENCHERES_REMPORTEES = "SELECT a.nom_article,  MAX(e.montant_enchere), a.date_fin_encheres, a.no_utilisateur as vendeur\r\n"
//			+ "from ARTICLES_VENDUS a\r\n" + "inner join ENCHERES e on e.no_article=a.no_article\r\n"
//			+ "WHERE a.date_debut_encheres <= CURRENT_TIMESTAMP and a.date_fin_encheres>= CURRENT_TIMESTAMP \r\n"
//			+ "group by a.nom_article, a.date_fin_encheres, a.no_utilisateur;\r\n" + "";
//
//	
//	@Override
	public List<ArticleVendu> afficherEncheresRemportees() throws DALException {

		List<ArticleVendu> listeAchatsAAfficher = new ArrayList<ArticleVendu>();
//
//		ResultSet rs = null;
//		// Obtenir une connexion
//		Connection cnx = ConnectionProvider.getConnection();
//		try {
//			Statement pStmt = cnx.createStatement();
//
//			rs = pStmt.executeQuery(AFFICHER_MES_ENCHERES);
//
//			while (rs.next()) {
//
//				ArticleVendu article = mapAfficherVente(rs);
//				listeAchatsAAfficher.add(article);
//			}
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		finally {
//			if(rs!= null) {
//				
//				try {
//					cnx.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
//
		return listeAchatsAAfficher;
	}

	@Override
	public List<ArticleVendu> afficherMesEncheres() throws DALException {
		
		List<ArticleVendu> listeAchatsAAfficher = new ArrayList<ArticleVendu>();
		int noArticle = 0;
		int noAcheteur = 0;
		ResultSet rs = null;
		// Obtenir une connexion
		Connection cnx = ConnectionProvider.getConnection();
		try {
			Statement pStmt = cnx.createStatement();

			rs = pStmt.executeQuery(AFFICHER_ACHATS_EN_COURS);

			while (rs.next()) {

				ArticleVendu article = mapAfficherVente(rs);
				noArticle = article.getNoArticle();
				noAcheteur = trouverMeilleurEncherisseur(noArticle);
//				HttpSession session = request.getSession();
//		        String pseudo = (String) session.getAttribute("pseudo");
				String pseudo = System.getProperty("pseudo");
				System.out.println(pseudo);
				try {
					if (noAcheteur == (UtilisateurManager.getInstance().afficherProfil(pseudo).getNoUtilisateur())){
						listeAchatsAAfficher.add(article);
}
				} catch (BLLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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

		return listeAchatsAAfficher;
	}

	private int trouverMeilleurEncherisseur(int noArticle) {
		int noAcheteur = 0;
		
		Connection cnx = ConnectionProvider.getConnection();

		// Obtient une objet de commande (Statement) = ordre SQL
		try {

			// Paramétrer l'objet de commande
			PreparedStatement pStmt = cnx.prepareStatement(TROUVER_MEILLEUR_ENCHERISSEUR);
			pStmt.setInt(1, noArticle);
			
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
		return noAcheteur;
	}

	public ArticleVendu mapAfficherVente(ResultSet rs) throws SQLException {
		ArticleVendu articleVendu = null;
		String pseudo = null;

		int no_Article = rs.getInt("no_article");
		String nomArticle = rs.getString("nom_article");
		String description = rs.getString("description");
		LocalDateTime dateDebutEncheres = rs.getTimestamp(4).toLocalDateTime();
		LocalDateTime dateFinEncheres = rs.getTimestamp(5).toLocalDateTime();
		int miseAPrix = rs.getInt("prix_initial");
		int prixVente = rs.getInt("prix_vente");
		int categorie = rs.getInt("no_categorie");
		int no_utilisateur = rs.getInt("no_utilisateur");
		try {
			pseudo = UtilisateurManager.getInstance().afficherProfilAvecId(no_utilisateur).getPseudo();
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		articleVendu = new ArticleVendu(no_Article, nomArticle, description, dateDebutEncheres, dateFinEncheres,
				miseAPrix, prixVente, categorie, no_utilisateur, pseudo);

		return articleVendu;
	}



}
