package fruitbasket.com.java;

/**
 * @author user
 *
 */
public class BasketException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7313467562707163099L;
	/**
	 * Exception Message
	 * 
	 */
	private String message;

	public BasketException(String message) {
		super(message);
		this.message = message;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Throwable#toString()
	 */
	@Override
	public String toString() {
		return "BasketException [message=" + message + "]";
	}

}
