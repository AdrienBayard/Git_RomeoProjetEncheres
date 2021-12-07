package fr.eni.javaee.projet.dal;

import java.util.List;

import eni.fr.javaee.projet.bo.Utilisateur;

public interface UtilisateurDAO {

	/**
	 * TODO : Importer tous les noms des méthodes de la JDBC
	 */

	List<Utilisateur> afficherProfil() throws DALException;

}
