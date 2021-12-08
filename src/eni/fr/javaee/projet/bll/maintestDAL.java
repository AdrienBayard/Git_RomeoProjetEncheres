package eni.fr.javaee.projet.bll;

import java.util.List;

import eni.fr.javaee.projet.bo.Utilisateur;

public class maintestDAL {

	public static void main(String[] args) {

		List<Utilisateur> listUtilExistants;
		try {
		listUtilExistants = UtilisateurManager.getInstance().getListeUtilisateurs();
		for(Utilisateur user : listUtilExistants) {
		System.out.println(user.getPseudo());
		System.out.println(user.getEmail());
		}
		
		
			
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
