package exception;

public class StackEmptyException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StackEmptyException(String message) {
		super(message);
	}
}
