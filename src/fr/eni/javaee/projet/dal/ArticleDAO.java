package fr.eni.javaee.projet.dal;

import java.util.List;

import eni.fr.javaee.projet.bo.ArticleVendu;

public interface ArticleDAO {
	
	public List<ArticleVendu> afficherVentesEnCours() throws DALException;
	public List<ArticleVendu> afficherVentesNonDebutees() throws DALException;
	public List<ArticleVendu> afficherVentesTerminees() throws DALException;
	public List<ArticleVendu> afficherAchatsEnCours() throws DALException;
	
	public int trouverMeilleurEncherisseur(int noArticle)throws DALException;
	
	public List<ArticleVendu> afficherMesEncheres(String pseudo) throws DALException;	
	public List<ArticleVendu>afficherEncheresRemportees(String pseudo) throws DALException;
	
	public ArticleVendu insertVente(ArticleVendu nouvelArticleVendu) throws DALException;
	public ArticleVendu updateVente(ArticleVendu nouvelArticleVendu) throws DALException;
	public ArticleVendu selectArticleById(int noArticle) throws DALException;
	public void deleteVente(int idArticle) throws DALException;

	
	
}
