package exception;

public class QueueEmptyException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public QueueEmptyException(String err) {
		super(err);
	}
}