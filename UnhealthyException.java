package homeWork6;

//Nir Avisror 311499958  Pinhas Ziv 315709139

// special exception for an unhealthy recipe.
public class UnhealthyException extends Exception {

	private static final long serialVersionUID = 1L;

	public UnhealthyException() {
	}

	public UnhealthyException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnhealthyException(String message) {
		super(message);
	}
}
