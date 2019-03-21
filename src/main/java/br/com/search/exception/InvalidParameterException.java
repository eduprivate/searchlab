package br.com.search.exception;

@SuppressWarnings("serial")
public class InvalidParameterException extends Throwable {
	public InvalidParameterException() {
		super();
	}

	public InvalidParameterException(Throwable cause) {
		super(cause);
	}

	public InvalidParameterException(String message) {
		super(message);
	}

	public InvalidParameterException(String message, Throwable cause) {
		super(message, cause);
	}
}