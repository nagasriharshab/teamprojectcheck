package com.abc.healthcenter.exception;
/**
 * Exception to handle bad requests that attempts duplicate value injection
 * @author NAGA SRI HARSHA
 * date : 07-July-2021
 */
public class ResourceAlreadyExistException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceAlreadyExistException(String msg) {
		super(msg);
	}
}
