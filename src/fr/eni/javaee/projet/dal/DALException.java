package fr.eni.javaee.projet.dal;

public class DALException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DALException() {
	}

	public DALException(String message) {
		super(message);
	}

	public DALException(Throwable cause) {
		super(cause);
	}

	public DALException(String message, Throwable cause) {
		super(message, cause);
	}

}
