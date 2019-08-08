package com.edu.realestate.exceptions;

public class AuthenticationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AuthenticationException() {
		super("AuthenticateE");
	}

	public AuthenticationException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
