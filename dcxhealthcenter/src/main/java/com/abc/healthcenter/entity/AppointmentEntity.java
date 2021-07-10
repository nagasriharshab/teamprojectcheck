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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

/**
 * 
 * @author NAGA SRI HARSHA
 * date : 09-July-2021
 */
@Entity
@Table(name = "Appointment_tbl")
public class AppointmentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="appointment_id")
	private int appointmentId;
	
	@Column(name ="appointment_date")
	private LocalDate appointmentDate;
	
	@Column(name = "appointment_slot")
	private int appointmentSlot;
	
	@Column(name = "feed_back")
	@Size(min = 1,max = 5000)
	private String feedback;
	
	@Column(name = "rating")
	private int rating;
	@ManyToOne
	@JoinColumn(name = "patient_id")
	private PatientEntity patient;
	
	@ManyToOne
	@JoinColumn(name="doctor_id")
	private DoctorEntity doctor;
	
	@OneToOne(mappedBy="appointment", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private PaymentEntity payment = new PaymentEntity();

	/**
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}

	/**
	 * @return the feedback
	 */
	public String getFeedback() {
		return feedback;
	}

	/**
	 * @param feedback the feedback to set
	 */
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	/**
	 * @return the appointmentId
	 */
	public int getAppointmentId() {
		return appointmentId;
	}

	/**
	 * @param appointmentId the appointmentId to set
	 */
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	/**
	 * @return the appointmentDate
	 */
	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}

	/**
	 * @param appointmentDate the appointmentDate to set
	 */
	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	/**
	 * @return the appointmentSlot
	 */
	public int getAppointmentSlot() {
		return appointmentSlot;
	}

	/**
	 * @param appointmentSlot the appointmentSlot to set
	 */
	public void setAppointmentSlot(int appointmentSlot) {
		this.appointmentSlot = appointmentSlot;
	}

	/**
	 * @return the patient
	 */
	public PatientEntity getPatient() {
		return patient;
	}

	/**
	 * @param patient the patient to set
	 */
	public void setPatient(PatientEntity patient) {
		this.patient = patient;
	}

	/**
	 * @return the doctor
	 */
	public DoctorEntity getDoctor() {
		return doctor;
	}

	/**
	 * @param doctor the doctor to set
	 */
	public void setDoctor(DoctorEntity doctor) {
		this.doctor = doctor;
	}

	/**
	 * @return the payment
	 */
	public PaymentEntity getPayment() {
		return payment;
	}

	/**
	 * @param payment the payment to set
	 */
	public void setPayment(PaymentEntity payment) {
		this.payment = payment;
	}

	
}