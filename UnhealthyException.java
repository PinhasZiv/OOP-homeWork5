package homeWork6;

//Nir Avisror 311499958  Pinhas Ziv 315709139

public class UnhealthyException extends Exception {

	// TODO
	//check what is this static final
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
