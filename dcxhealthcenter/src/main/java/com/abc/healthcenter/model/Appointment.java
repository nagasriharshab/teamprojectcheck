package com.abc.healthcenter.model;
import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * 
 * @author NAGA SRI HARSHA
 * date : 09-July-2021
 */
public class Appointment {
	
	@NotNull(message = "please provide id")
	@Positive(message = "please provide valid appointmentId")
	private int appointmentId;
	 
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+5:30")
	@FutureOrPresent(message = "please provide correct date")
	private LocalDate appointmentDate;
	
	@Min(value = 1, message = "please select the available slot")
    @Max(value = 15, message = "there are only 15 slots available")
	@NotNull(message = "please provide slot")
	private int appointmentSlot;

	@NotNull(message = "please provide Patient id")
	@Positive(message = "please provide valid patientId")
	private int patientId;
	
	@NotNull(message = "please provide Doctor id")
	@Positive(message = "please provide valid doctorId")
	private int doctorId;
	
	
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

	/**getter for appointmentDate
	 * @return the appointmentDate
	 */
	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}

	/**
	 * setter for appointmentDate
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
	 * getter for doctorId
	 * @return the doctorId
	 */
	public int getDoctorId() {
		return doctorId;
	}

	/**
	 * setter or doctorId
	 * @param doctorId the doctorId to set
	 */
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	
}


