package eni.fr.javaee.projet.dal.jdbc;

import fr.eni.javaee.projet.dal.ArticleDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.tomcat.jni.Time;

import eni.fr.javaee.projet.bo.ArticleVendu;
import eni.fr.javaee.projet.bo.Utilisateur;
import fr.eni.javaee.projet.dal.DALException;
import fr.eni.javaee.projet.dal.ArticleDAO;

public class ArticleDAOJdbcImpl implements ArticleDAO {

	private static final String AFFICHER_VENTE = "";
	private static final String INSERT_VENTE = "INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial,no_utilisateur, no_categorie) VALUES (?,?,?,?,?,?,?);";
	private static final String UPDATE_VENTE = "UPDATE ARTICLES_VENDUS SET nom_article = ?, description=?, date_debut_encheres= ?, date_fin_encheres = ?, prix_initial=?, no_categorie=? where no_article =?;";
	private static final String DELETE_VENTE = "DELETE from ARTICLES_VENDUS where no_article = ?";
	
	public ArticleVendu insertVente() throws DALException {
		return null;
	}
	
	
	public ArticleVendu updateVente() throws DALException {
		return null;
	}
	
	public ArticleVendu deleteVente() throws DALException {
		return null;
	}
	
	
	
	public ArticleVendu mapAfficherVente(ResultSet rs) throws SQLException {
		ArticleVendu articleVendu = null;
		
		int noArticle = rs.getInt("noArticle");
		String nomArticle = rs.getString("nomArticle");
		String description = rs.getString("description");
		LocalDateTime dateDebutEncheres = rs.getTimestamp(4).toLocalDateTime();
		LocalDateTime dateFinEncheres = rs.getTimestamp(5).toLocalDateTime();
		int miseAPrix = rs.getInt("miseAPrix");
		int prixVente = rs.getInt("prixVente");
		String etatVente = rs.getString("etatVente");
		 
		return articleVendu;
	}
	
	
	
}
