package com.abc.healthcenter.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
/**
 * 
 * @author likhith  A S
 *Jul 8, 2021
 */
public class PatientForgetPassword {
	
	@NotEmpty(message="please provide username")
	private String patientUserName;
	
	@NotEmpty(message="please provide email")
	@Email(message="email should be valid")
	private String patientEmail;
	
	@NotEmpty(message="please provide password")
	private String newPassword;
	/**
	 * getter method for patient username
	 * @return patientUserName
	 */
	public String getPatientUserName() {
		return patientUserName;
	}
	/**
	 * setter method for patient username
	 * @param patientUserName
	 */
	public void setPatientUserName(String patientUserName) {
		this.patientUserName = patientUserName;
	}
	
	/**
	 *getter method for patient email
	 * @return patientEmail
	 */
	public String getPatientEmail() {
		return patientEmail;
	}
	
	/**
	 *setter method for patient email
	 * @param patientEmail
	 */
	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}
	
	/**
	 * getter method for new password
	 * @return newPassword
	 */
	public String getNewPassword() {
		return newPassword;
	}
	
	/**
	 * setter method for new password
	 * @param newPassword
	 */
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	
	
}