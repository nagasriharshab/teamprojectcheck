/**
 * 
 */
package com.abc.healthcenter.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

/**
 * @author NAGA SRI HARSHA
 * date : 10-Jul-2021
 */
public class AppointmentFeedback {
	
	@NotNull(message = "please provide id")
	@Positive(message = "please provide valid appointmentId")
	private int appointmentId;
	
	@Size(min =1,max = 500, message = "feedback must be limited to 500 words")
	@NotNull(message = "please write feedback to submit")
	private String feedback;
	
	@NotNull(message = "please provide Patient id")
	@Positive(message = "please provide valid patientId")
	private int patientId;
	
	@Min(value = 1, message = "rating cannot be less than 1")
    @Max(value = 10, message = "rating cannot be more than 10")
	@NotNull(message = "please provide  rating")
	private int rating;
	
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
