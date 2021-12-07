package fr.eni.javaee.projet.dal;

import eni.fr.javaee.projet.bo.Utilisateur;

public interface UtilisateurDAO {

	/**
	 * TODO : Importer tous les noms des méthodes de la JDBC
	 */

	Utilisateur afficherProfil(String pseudo) throws DALException;

	Utilisateur insertUtilisateur(Utilisateur nouvelUtilisateur) throws DALException;

	String afficherMotDePasse(String pseudo) throws DALException;
	
	void updateUtilisateur(Utilisateur utilisateurModifie) throws DALException;
	
	void deleteUtilisateur(int idUtilisateur)throws DALException;
	
}
