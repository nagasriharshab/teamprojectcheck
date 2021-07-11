/**
 * 
 */
package com.abc.healthcenter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * @author NAGA SRI HARSHA
 * date : 10-July-2021
 */
@Entity
@Table(name = "feedback_tbl")
public class AppointmentFeedbackEntity {
	
	@Id
	@Column(name="feedback_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int feedbackId;
	
	@OneToOne
	@JoinColumn(name = "appointment_id")
	private AppointmentEntity appointment;
	
	@Column(name="feedback")
	@Size(min = 1,max = 5000)
	private String feedback;
	
	@JoinColumn(name="patient_id")
	private int patientId;
	
	@Column(name="rating")
	private int rating;

	/**
	 * getter for patientId
	 * @return the patientId
	 */
	public int getPatientId() {
		return patientId;
	}

	/**
	 * setter for patientId
	 * @param patientId the patientId to set
	 */
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	/**
	 * getter for feedbackId
	 * @return the feedbackId
	 */
	public int getFeedbackId() {
		return feedbackId;
	}

	/**
	 * setter for feedbackId
	 * @param feedbackId the feedbackId to set
	 */
	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	/**
	 * getter for appointmentEntity
	 * @return the appointment
	 */
	public AppointmentEntity getAppointment() {
		return appointment;
	}

	/**
	 * setter for appointmentEntity
	 * @param appointment the appointment to set
	 */
	public void setAppointment(AppointmentEntity appointment) {
		this.appointment = appointment;
	}

	/**
	 * getter for feedback
	 * @return the feedback
	 */
	public String getFeedback() {
		return feedback;
	}

	/**
	 * setter for feedback
	 * @param feedback the feedback to set
	 */
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	/**
	 * getter for rating
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}

	/**
	 * setter for rating
	 * @param rating the rating to set
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
}
