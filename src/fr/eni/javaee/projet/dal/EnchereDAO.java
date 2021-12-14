package fr.eni.javaee.projet.dal;

import eni.fr.javaee.projet.bo.Enchere;

public interface EnchereDAO {
	
	public Enchere trouverMeilleurEncherisseur(int noArticle)throws DALException;


}
