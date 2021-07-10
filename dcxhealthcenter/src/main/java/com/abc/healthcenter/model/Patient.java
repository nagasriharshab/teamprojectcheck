
package com.abc.healthcenter.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.abc.healthcenter.entity.AppointmentEntity;
import com.abc.healthcenter.entity.PaymentEntity;

/**
 * Model Class Of Patient
 * @author likhith  A S
 *
 * date: Jul 5, 2021
 */
public class Patient{
	
	private int patientId ;
	
	@NotEmpty(message = "Patient Name is required")
	private String patientName;
	
	@NotEmpty(message = "Patient UserName is required")
	private String patientUserName;
	
	@NotEmpty(message = "Patient Password is required")
	private String patientPassword;
	
	@NotNull(message = "Patient Age is required")
	private int patientAge;
	
	@NotEmpty(message = "Patient Gender is required")
	private String patientGender;
	
	@NotEmpty(message = "Patient Address is required")
	private String patientAddress;
	
	@NotEmpty(message = "Patient Email is required")
	private String patientEmail;
	
	@NotNull(message = "Patient Contact is required")
	private long patientContact;
	
	@NotEmpty(message = "Patient Message is required")
	private String patientMessage;
	
	
	private List <AppointmentEntity> appointments = new ArrayList <>();
	
	
	private List<PaymentEntity> payments = new ArrayList<>();
	

	/**
	 *  getter method for patient username
	 * @return patientUsername
	 */
	public String getPatientUserName() {
		return patientUserName;
	}
	
	/**
	 *  setter method for patient username
	 * @param patientUserName
	 */
	public void setPatientUserName(String patientUserName) {
		this.patientUserName = patientUserName;
	}
	
	/**
	 *  getter method for patient password
	 * @return patientPassword
	 */
	public String getPatientPassword() {
		return patientPassword;
	}
	
	/**
	 * setter method for patient password
	 * @param patientPassword
	 */
	public void setPatientPassword(String patientPassword) {
		this.patientPassword = patientPassword;
	}
	
	/**
	 *  getter method for patient appointments
	 * @return appointments
	 */
	public List<AppointmentEntity> getAppointments() {
		return appointments;
	}
	
	/**
	 * setter method for patient appointments
	 * @param appointments
	 */
	public void setAppointments(List<AppointmentEntity> appointments) {
		this.appointments = appointments;
	}
	
	/**
	 *  getter method for patient payments
	 * @return payments
	 */
	public List<PaymentEntity> getPayments() {
		return payments;
	}
	
	/**
	 * setter method for patient payments
	 * @param payments
	 */
	public void setPayments(List<PaymentEntity> payments) {
		this.payments = payments;
	}

	/**
	 *  getter method for patient id
	 * @return patientId
	 */
	public int getPatientId() {
		return patientId;
	}
	
	/**
	 * setter method for patient id
	 * @param patientId
	 */
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	
	/**
	 *  getter method for patient name
	 * @return patientName
	 */
	public String getPatientName() {
		return patientName;
	}
	
	/**
	 * setter method for patient name
	 * @param patientName
	 */
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	
	/**
	 *  getter method for patient age
	 * @return patientAge
	 */
	public int getPatientAge() {
		return patientAge;
	}
	
	/**
	 * setter method for patient age
	 * @param patientAge
	 */
	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}
	
	/**
	 *  getter method for patient gender
	 * @return patientGender
	 */
	public String getPatientGender() {
		return patientGender;
	}
	
	/**
	 * setter method for patient gender
	 * @param patientGender
	 */
	public void setPatientGender(String patientGender) {
		this.patientGender = patientGender;
	}
	
	/**
	 *  getter method for patient address
	 * @return patientAddress
	 */
	public String getPatientAddress() {
		return patientAddress;
	}
	
	/**
	 * setter method for patient address
	 * @param patientAddress
	 */
	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}
	
	/**
	 *  getter method for patient email
	 * @return patientEmail
	 */
	public String getPatientEmail() {
		return patientEmail;
	}
	
	/**
	 * setter method for patient email
	 * @param patientEmail
	 */
	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}
	
	/**
	 *  getter method for patient contact
	 * @return patientContact
	 */
	public long getPatientContact() {
		return patientContact;
	}
	
	/**
	 * setter method for patient contact
	 * @param patientContact
	 */
	public void setPatientContact(long patientContact) {
		this.patientContact = patientContact;
	}
	
	/**
	 *  getter method for patient message
	 * @return patientMessage
	 */
	public String getPatientMessage() {
		return patientMessage;
	}
	
	/**
	 * setter method for patient message
	 * @param patientMessage
	 */
	public void setPatientMessage(String patientMessage) {
		this.patientMessage = patientMessage;
	}
}
