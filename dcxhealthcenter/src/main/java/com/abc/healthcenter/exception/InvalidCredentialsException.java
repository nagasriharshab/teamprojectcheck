/**
 * 
 */
package com.abc.healthcenter.exception;

/**
 * Exception class to implement InvalidCredentialsException
 * @author NAGA SRI HARSHA
 * date : 07-Jul-2021
 */
public class InvalidCredentialsException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * constructor for ExceptionMessage
	 * @param message
	 */
	public InvalidCredentialsException(String message) {
		super(message);
	}
}
