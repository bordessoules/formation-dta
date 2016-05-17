package fr.pizzeria.exception;

public class UpdatePizzaException extends DaoException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2854428262757205794L;

	public UpdatePizzaException() {
		super();
	}

	public UpdatePizzaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UpdatePizzaException(String message, Throwable cause) {
		super(message, cause);
	}

	public UpdatePizzaException(String message) {
		super(message);
	}

	public UpdatePizzaException(Throwable cause) {
		super(cause);
	}
	
	

}