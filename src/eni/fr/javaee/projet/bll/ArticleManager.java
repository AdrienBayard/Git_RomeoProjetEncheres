package eni.fr.javaee.projet.bll;

import fr.eni.javaee.projet.dal.ProjetDAOFactory;

import java.time.LocalDateTime;
import java.util.List;

import eni.fr.javaee.projet.bo.ArticleVendu;
import fr.eni.javaee.projet.dal.ArticleDAO;
import fr.eni.javaee.projet.dal.DALException;

public class ArticleManager {

	// Création du singleton

	private static ArticleManager instance;

	private static ArticleDAO dao;

	private ArticleManager() {
		dao = ProjetDAOFactory.getArticleDAO();
	};

	public static ArticleManager getInstance() {
		if (instance == null) {
			instance = new ArticleManager();
		}
		return instance;
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

	public List<ArticleVendu> afficherAchatsEnCours() throws DALException {
		return null;
	}

	public List<ArticleVendu> afficherEncheresRemportees() throws DALException {
		return null;
	}

	public List<ArticleVendu> afficherMesEncheres() throws DALException {
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public ArticleVendu insertVente(String nomArticle, String description, LocalDateTime dateDebutEncheres, LocalDateTime dateFinEncheres, int miseAPrix, int prixVente, String etatVente) throws DALException {
		
		ArticleVendu article = null;
		
		BLLException ex = new BLLException();
		
		validationNomArticle(nomArticle);
		validationDescription(description);
		validationDebutEncheres(dateDebutEncheres);
		validationDateFinEncheres(dateFinEncheres);
		
		
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public ArticleVendu updateVente(ArticleVendu nouvelArticleVendu) throws DALException {
		return null;
	}

	public ArticleVendu deleteVente(ArticleVendu idArticle) throws DALException {
		return null;
	}

}
