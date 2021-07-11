/**
 * 
 */
package com.abc.healthcenter.exception;

/**
 * @author NAGA SRI HARSHA
 * date : 10-Jul-2021
 */
public class UnauthorisedAttemptException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * constructor for Exception Message
	 * @param msg
	 */
	public UnauthorisedAttemptException(String msg) {
		super(msg);
	}
}
