package eni.fr.javaee.projet.bll;

import java.util.ArrayList;
import java.util.List;

public class BLLException extends Exception {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private List<Exception> erreurs = new ArrayList<Exception>();
	
	public BLLException() {
		super();
	}
	
	public BLLException(String message) {
		super(message);
	}
	
	public BLLException(String message, Throwable exception) {
		super(message, exception);
	}
	
	/**
	 * Ajoute une exception à la liste d'exception.
	 * @param e L'exception à ajouter.
	 */
	public void ajouterErreur(Exception e) {
		erreurs.add(e);
	}
	
	/**
	 * Indique si la liste des erreurs est vide ou non
	 * @return true s'il y a des erreurs, false sinon.
	 */
	public boolean hasErreur() {
		return !erreurs.isEmpty();
	}

	//MÃ©thodes
	@Override
	public String getMessage() {
		StringBuffer sb = new StringBuffer();
		for(Exception e : erreurs) {
			sb.append(e.getMessage()).append(System.lineSeparator());
		}		
		return sb.toString() ;
	}

}
