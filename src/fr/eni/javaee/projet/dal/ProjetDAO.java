package fr.eni.javaee.projet.dal;

import java.util.List;

import eni.fr.javaee.projet.bo.Utilisateur;

public interface ProjetDAO {

	List<Utilisateur> afficherTousLesUtilisateurs() throws DALException;
	/**
	 * TODO : Importer tous les noms des méthodes de la BLL
	 */

}
