package com.afocus.pbuilder.common.exception;


public class TransformerException extends RuntimeException{

	private static final long serialVersionUID = -7994767188698737760L;

	public TransformerException() {
		super();
		
	}

	public TransformerException(String message, Throwable cause) {
		super(message, cause);
	}

	public TransformerException(String message) {
		super(message);
	}

	public TransformerException(Throwable cause) {
		super(cause);
	}

}
