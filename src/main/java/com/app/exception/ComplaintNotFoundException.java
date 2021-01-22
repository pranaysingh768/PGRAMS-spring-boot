package com.app.exception;

public class ComplaintNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public ComplaintNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ComplaintNotFoundException(String message) {
		super(message);
	}

	public ComplaintNotFoundException(Throwable cause) {
		super(cause);
	}
}
