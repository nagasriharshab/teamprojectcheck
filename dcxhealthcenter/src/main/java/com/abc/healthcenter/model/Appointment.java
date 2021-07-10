package com.abc.healthcenter.model;
import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * 
 * @author NAGA SRI HARSHA
 * date : 09-July-2021
 */
public class Appointment {
	
	@NotNull(message = "please provide id")
	private int appointmentId;
	 
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+5:30")
	@FutureOrPresent(message = "please provide correct date")
	private LocalDate appointmentDate;
	
	@Min(value = 1, message = "please select the available slot")
    @Max(value = 15, message = "there are only 15 slots available")
	@NotNull(message = "please provide slot")
	private int appointmentSlot;
	
	@Size(min =1,max = 500, message = "feedback must be limited to 500 words")
	private String feedback;
	
	@Min(value = 1, message = "rating cannot be less than 1")
    @Max(value = 10, message = "rating cannot be more than 10")
	private int rating;
	
	@NotNull(message = "please provide Patient id")
	private int patientId;
	
	@NotNull(message = "please provide Doctor id")
	private int doctorId;
	
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
	 * @return the patientId
	 */
	public int getPatientId() {
		return patientId;
	}

	/**
	 * @param patientId the patientId to set
	 */
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	/**
	 * @return the doctorId
	 */
	public int getDoctorId() {
		return doctorId;
	}

	/**
	 * @param doctorId the doctorId to set
	 */
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	/**
	 * @return the billId
	 */	
}


