/**
 * 
 */
package com.abc.healthcenter.model;

/**
 * @author NAGA SRI HARSHA
 * date : 07-July-2021
 */
public class ErrorResponse {
	private String error;
	private int status;
	
	/**
	 * getter for error
	 * @return the error
	 */
	public String getError() {
		return error;
	}
	/**
	 * setter for error
	 * @param error the error to set
	 */
	public void setError(String error) {
		this.error = error;
	}
	/**
	 * getter for status
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * setter for status
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
