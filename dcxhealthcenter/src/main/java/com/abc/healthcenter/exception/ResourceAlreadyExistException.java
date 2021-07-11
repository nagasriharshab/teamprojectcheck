
package com.abc.healthcenter.exception;
/**
 * 
 * @author NAGA SRI HARSHA
 * date : 11-July-2021
 */
public class ResourceAlreadyExistException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * constructor for ExceptionMessage
	 * @param message
	 */
	public ResourceAlreadyExistException(String message) {
		super(message);
	}

}