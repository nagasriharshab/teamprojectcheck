/**
 * 
 */
package com.abc.healthcenter.exception;

/**
 * @author NAGA SRI HARSHA
 * date : 10-Jul-2021
 */
public class ResourceNotAvailableException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * constructor for ExceptionMessage
	 * @param msg
	 */
	public ResourceNotAvailableException(String msg) {
		super(msg);
	}
}
