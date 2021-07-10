/**
 * 
 */
package com.abc.healthcenter.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * @author NAGA SRI HARSHA
 * date : 08-Jul-2021
 */
public class DoctorForgetPassword {
	
	@NotEmpty(message="please provide username")
	private String doctorUserName;
	
	@NotEmpty(message="please provide email")
	@Email(message="email should be valid")
	private String doctorEmail;
	
	@NotEmpty(message="please provide password")
	private String newPassword;
	
	/**
	 * @return the doctorUserName
	 */
	public String getDoctorUserName() {
		return doctorUserName;
	}
	/**
	 * @param doctorUserName the doctorUserName to set
	 */
	public void setDoctorUserName(String doctorUserName) {
		this.doctorUserName = doctorUserName;
	}
	/**
	 * @return the doctorEmail
	 */
	public String getDoctorEmail() {
		return doctorEmail;
	}
	/**
	 * @param doctorEmail the doctorEmail to set
	 */
	public void setDoctorEmail(String doctorEmail) {
		this.doctorEmail = doctorEmail;
	}
	/**
	 * @return the newPassword
	 */
	public String getNewPassword() {
		return newPassword;
	}
	/**
	 * @param newPassword the newPassword to set
	 */
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	
}
