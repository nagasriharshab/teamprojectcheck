package com.abc.healthcenter.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * 
 * @author likhith  A S
 *
 * date: Jul 5, 2021
 */

@Entity
@Table (name = "patient_tbl")
public class PatientEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="patient_Id")
	private int patientId ;
	
	@Column(name = "patient_name")
	private String patientName;
	
	@Column(name="user_name")
	private String patientUserName;
	
	@Column(name="password")
	private String patientPassword;
	
	@Column(name = "patient_age")
	private int patientAge;
	
	@Column(name = "patient_gender")
	private String patientGender;
	
	@Column(name = "patient_address")
	private String patientAddress;
	
	@Column(name = "patient_email")
	private String patientEmail;
	
	@Column(name = "patient_contact")
	private long patientContact;
	
	@Column(name = "patient_message")
	private String patientMessage;
	
	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List <AppointmentEntity> appointments = new ArrayList <>();
	
	@OneToMany(mappedBy="patient", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<PaymentEntity> payments = new ArrayList<>();

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
	 * getter method for patient password
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
	 * getter method for patient appointment
	 * @return appointments
	 */
	public List<AppointmentEntity> getAppointments() {
		return appointments;
	}
	
	/**
	 * setter method for patient appointment
	 * @param appointments
	 */
	public void setAppointments(List<AppointmentEntity> appointments) {
		this.appointments = appointments;
	}
	
	/**
	 * getter method for patient payments
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
	 * getter method for patient id
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
	 * getter method for patient name
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
	 * getter method for patient age
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
	 * getter method for patient gender
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
		this.patientGender=patientGender;
	}
	
	/**
	 * getter method for patient address
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
	 * getter method for patient email
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
	 * getter method for patient contact
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
	 * getter method for patient message
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
