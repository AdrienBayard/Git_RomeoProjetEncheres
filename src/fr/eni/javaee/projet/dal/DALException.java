package fr.eni.javaee.projet.dal;

@SuppressWarnings("serial")
public class DALException extends Exception {

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
