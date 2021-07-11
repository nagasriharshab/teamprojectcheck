package com.abc.healthcenter.entity;
import java.time.LocalDate;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @author NAGA SRI HARSHA
 * date : 09-July-2021
 */
@Entity
@Table(name = "Appointment_tbl")
public class AppointmentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="appointment_id")
	private int appointmentId;
	
	@Column(name ="appointment_date")
	private LocalDate appointmentDate;
	
	@Column(name = "appointment_slot")
	private int appointmentSlot;
	
	@OneToOne(mappedBy="appointment", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private AppointmentFeedbackEntity feedback = new AppointmentFeedbackEntity();
	
	@ManyToOne
	@JoinColumn(name = "patient_id")
	private PatientEntity patient;
	
	@ManyToOne
	@JoinColumn(name="doctor_id")
	private DoctorEntity doctor;
	
	@OneToOne(mappedBy="appointment", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private PaymentEntity payment = new PaymentEntity();

	/**
	 * getter for appointmentId
	 * @return the appointmentId
	 */
	public int getAppointmentId() {
		return appointmentId;
	}

	/**
	 * setter for appointmentId
	 * @param appointmentId the appointmentId to set
	 */
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	/**
	 * getter for appointmentDate
	 * @return the appointmentDate
	 */
	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}

	/**
	 * setter for AppointmentDate
	 * @param appointmentDate the appointmentDate to set
	 */
	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	/**
	 * getter for appointmentSlot
	 * @return the appointmentSlot
	 */
	public int getAppointmentSlot() {
		return appointmentSlot;
	}

	/**
	 * setter for appointmentSlot
	 * @param appointmentSlot the appointmentSlot to set
	 */
	public void setAppointmentSlot(int appointmentSlot) {
		this.appointmentSlot = appointmentSlot;
	}

	/**
	 * getter for feedbackEntity
	 * @return the feedback
	 */
	public AppointmentFeedbackEntity getFeedback() {
		return feedback;
	}

	/**
	 * setter for feedbackEntity
	 * @param feedback the feedback to set
	 */
	public void setFeedback(AppointmentFeedbackEntity feedback) {
		this.feedback = feedback;
	}

	/**
	 * getter for patientEntity
	 * @return the patient
	 */
	public PatientEntity getPatient() {
		return patient;
	}

	/**
	 * setter for patientEntity
	 * @param patient the patient to set
	 */
	public void setPatient(PatientEntity patient) {
		this.patient = patient;
	}

	/**
	 * getter for doctorEntity
	 * @return the doctor
	 */
	public DoctorEntity getDoctor() {
		return doctor;
	}

	/**
	 * setter for doctorEntity
	 * @param doctor the doctor to set
	 */
	public void setDoctor(DoctorEntity doctor) {
		this.doctor = doctor;
	}

	/**
	 * getter for paymentEntity
	 * @return the payment
	 */
	public PaymentEntity getPayment() {
		return payment;
	}

	/**
	 * setter for paymentEntity
	 * @param payment the payment to set
	 */
	public void setPayment(PaymentEntity payment) {
		this.payment = payment;
	}

	
	
}