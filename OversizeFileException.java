package week1.day6.assignment5;

@SuppressWarnings("serial")
public class OversizeFileException extends Exception {
	public OversizeFileException () {
		super();
	}

	public OversizeFileException (String message) {
		super(message);
	}
}
