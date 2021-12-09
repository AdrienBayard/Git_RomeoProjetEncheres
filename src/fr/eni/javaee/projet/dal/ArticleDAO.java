package fr.eni.javaee.projet.dal;

import java.util.List;

import eni.fr.javaee.projet.bo.ArticleVendu;

public interface ArticleDAO {
	
	public List<ArticleVendu> afficherVentesEnCours() throws DALException;
	public List<ArticleVendu> afficherVentesNonDebutees() throws DALException;
	public List<ArticleVendu> afficherVentesTerminees() throws DALException;
	
	public List<ArticleVendu> afficherAchatsEnCours() throws DALException;
	public List<ArticleVendu> afficherEncheresRemportees() throws DALException;
	public List<ArticleVendu> afficherMesEncheres() throws DALException;
	
	
	public ArticleVendu insertVente(ArticleVendu nouvelArticleVendu) throws DALException;
	public ArticleVendu updateVente(ArticleVendu nouvelArticleVendu) throws DALException;
	public void deleteVente(int idArticle) throws DALException;

	
}
