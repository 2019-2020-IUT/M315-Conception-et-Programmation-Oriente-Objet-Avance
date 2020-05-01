package openClosedPrinciples.core;

/**
 * @author Mireille Blay-Fornarino
 *
 */
public class AlreadyBooked extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AlreadyBooked(String message) {
		super(message);
	}

}
