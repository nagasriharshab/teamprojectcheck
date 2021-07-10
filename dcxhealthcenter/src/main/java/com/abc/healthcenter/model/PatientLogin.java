package com.abc.healthcenter.model;

/**
 * @author likhith  A S
 * date : 07-July-2021
 */
public class PatientLogin {
	String patientUserName;
	String patientPassword;
	/**
	 * @return the patientUserName
	 */
	public String getPatientUserName() {
		return patientUserName;
	}
	/**
	 * @param patientUserName the PatientUserName to set
	 */
	public void setPatientUserName(String patientUserName) {
		this.patientUserName = patientUserName;
	}
	/**
	 * @return the patientPassword
	 */
	public String getPatientPassword() {
		return patientPassword;
	}
	/**
	 * @param doctorPassword the patientPassword to set
	 */
	public void setPatientPassword(String patientPassword) {
		this.patientPassword = patientPassword;
	}
	
}