package com.abc.healthcenter.exception;
/**
 * Exception class to check invalid credentials
 * @author NAGA SRI HARSHA
 * date : 07-July-2021
 * 
 */
public class InvalidCredentialsException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidCredentialsException(String message) {
		super(message);
	}
}
