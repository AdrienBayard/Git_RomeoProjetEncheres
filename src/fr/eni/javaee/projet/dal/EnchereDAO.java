package fr.eni.javaee.projet.dal;

import java.util.List;

import eni.fr.javaee.projet.bo.ArticleVendu;
import eni.fr.javaee.projet.bo.Enchere;

public interface EnchereDAO {
	
	public Enchere trouverMeilleurEncherisseur(int noArticle)throws DALException;
	public List<ArticleVendu> trouverArticleEncherit(int noUtilisateur) throws DALException; 

}
