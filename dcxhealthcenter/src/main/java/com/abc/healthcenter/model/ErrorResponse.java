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
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}	
}
