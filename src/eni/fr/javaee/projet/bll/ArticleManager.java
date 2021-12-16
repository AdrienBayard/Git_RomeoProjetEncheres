package eni.fr.javaee.projet.bll;

import fr.eni.javaee.projet.dal.ProjetDAOFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import eni.fr.javaee.projet.bo.ArticleVendu;
import eni.fr.javaee.projet.bo.Enchere;
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

	public List<ArticleVendu> afficherVentesEnCours(int noUtilisateur) throws BLLException {
	List<ArticleVendu> listeArticles = new ArrayList<ArticleVendu>(); 
		
		try {  
			listeArticles = dao.afficherVentesEnCours(noUtilisateur);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return listeArticles;
	}
	
	

	public List<ArticleVendu> afficherVentesNonDebutees(int noUtilisateur) throws BLLException   {
List<ArticleVendu> listeArticles = new ArrayList<ArticleVendu>(); 
		
		try {  
			listeArticles = dao.afficherVentesNonDebutees(noUtilisateur);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return listeArticles;
	}
	

	public List<ArticleVendu> afficherVentesTerminees(int noUtilisateur) throws BLLException {
List<ArticleVendu> listeArticles = new ArrayList<ArticleVendu>(); 
		
		try {  
			listeArticles = dao.afficherVentesTerminees(noUtilisateur);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return listeArticles;
	}

	public List<ArticleVendu> afficherAchatsEnCours() throws BLLException {
		
		List<ArticleVendu> listeArticles = new ArrayList<ArticleVendu>(); 
		
		try {  
			listeArticles = dao.afficherAchatsEnCours();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return listeArticles;
		
	}

	public List<ArticleVendu> afficherEncheresRemportees(String pseudo) throws BLLException {
		List<ArticleVendu> listeArticles = new ArrayList<ArticleVendu>(); 
		
		try {  
			listeArticles = dao.afficherEncheresRemportees(pseudo);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return listeArticles;
	}
	
	

	public List<ArticleVendu> afficherMesEncheres(String pseudo) throws BLLException {
		List<ArticleVendu> listeArticles = new ArrayList<ArticleVendu>() ; 
		try {  
			listeArticles = dao.afficherMesEncheres(pseudo);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return listeArticles;
	}

	
	public ArticleVendu selectArticleById(int noArticle) throws  BLLException {
		ArticleVendu article = null;
		BLLException ex = new BLLException();
		validationId(noArticle, ex);
		try {
			article = dao.selectArticleById(noArticle);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return article;
	}
	
	
//	 _____________________________________________________________________

	public ArticleVendu insertVente(String nomArticle, String description, LocalDateTime dateDebutEncheres,
			LocalDateTime dateFinEncheres, int miseAPrix, int prixVente, int no_utilisateur, int categorie)
			throws BLLException {

		ArticleVendu article = null;

		BLLException ex = new BLLException();

		validationNomArticle(nomArticle, ex);
		validationDescription(description, ex);
		validationDebutEncheres(dateDebutEncheres, ex);
		validationDateFinEncheres(dateFinEncheres, ex);
		validationMiseAPrix(miseAPrix, ex);
//		validationPrixVente(prixVente, ex);

		article = new ArticleVendu(0, nomArticle, description, dateDebutEncheres, dateFinEncheres, miseAPrix, prixVente, no_utilisateur,
				categorie);
		try {
			dao.insertVente(article);
		} catch (DALException e) {
			e.printStackTrace();
		}

		return article;
	}

//	private void validationPrixVente(int prixVente, BLLException ex) throws BLLException{
//		if () {
//			ex.ajouterErreur( new ParameterException("Vous devez indiquer un prix d'achat sous forme de nombre entier"));
//		}
//		 
//	}

	private void validationMiseAPrix(int miseAPrix, BLLException ex) throws BLLException {
		if (miseAPrix == 0) {
			ex.ajouterErreur(
					new ParameterException("Vous devez indiquer un prix de départ sous forme de nombre entier"));
		}

	}

	private void validationDateFinEncheres(LocalDateTime dateFinEncheres, BLLException ex) throws BLLException {
		if (LocalDateTime.now().isAfter(dateFinEncheres)) {
			ex.ajouterErreur(new ParameterException(
					"Vous devez indiquer une date de fin d'enchère posterieure à la date du jour et à celle de la date de début d'enchère"));
		}
	}

	private void validationDebutEncheres(LocalDateTime dateDebutEncheres, BLLException ex) throws BLLException {
		if (LocalDateTime.now().isAfter(dateDebutEncheres)) {
			ex.ajouterErreur(new ParameterException(
					"Vous devez indiquer une date de début d'enchère posterieure à la date du jour"));
		}

	}

	private void validationDescription(String description, BLLException ex) throws BLLException {
		if (description.isEmpty() || description.length() > 300) {
			ex.ajouterErreur(new ParameterException("Vous devez indiquer une description comprise entre 1 et 300"));
		}

	}

	private void validationNomArticle(String nomArticle, BLLException ex) throws BLLException {
		if (nomArticle.isEmpty() || nomArticle.length() > 30) {
			ex.ajouterErreur(new ParameterException("Vous devez indiquer une description comprise entre 1 et 30"));
		}

	}

	
	
//	 -------------------------------------------------------

	public void updateVente(int noArticle, String nomArticle, String description, LocalDateTime dateDebutEncheres,
			LocalDateTime dateFinEncheres, int miseAPrix, int prixVente, int no_utilisateur, int categorie)
			throws BLLException {

		ArticleVendu article = null;
		BLLException ex = new BLLException();

		validationNomArticle(nomArticle, ex);
		validationDescription(description, ex);
		validationDebutEncheres(dateDebutEncheres, ex);
		validationDateFinEncheres(dateFinEncheres, ex);
		validationMiseAPrix(miseAPrix, ex);
//		validationPrixVente(prixVente, ex);

		article = new ArticleVendu(noArticle, nomArticle, description, dateDebutEncheres, dateFinEncheres, miseAPrix, prixVente,
				no_utilisateur, categorie );

		if (ex.hasErreur()) {
			throw ex;
		}

		try {
			dao.updateVente(article);
		} catch (DALException e) {
			e.printStackTrace();
			ex.ajouterErreur(e);
		}

	}

	public void deleteVente(int idArticle) throws BLLException {

		BLLException ex = new BLLException();

		validationId(idArticle, ex);

		if (ex.hasErreur()) {
			throw ex;
		}

		try {
			dao.deleteVente(idArticle);
		} catch (DALException e) {
			e.printStackTrace();
			ex.ajouterErreur(e);
			throw ex;
		}
	}

	private void validationId(int idArticle, BLLException ex) throws BLLException {
		if (idArticle < 1) {
			ex.ajouterErreur(new ParameterException("L'id doit Etre un entier positif >= 1"));
		}
	}
	
	
	
	
//	---------------------------
	
	
	
	
	
}


