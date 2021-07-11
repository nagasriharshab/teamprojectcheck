/**
 * 
 */
package com.abc.healthcenter.model;

import java.time.LocalDate;

/**
 * @author NAGA SRI HARSHA
 * date : 10-July-2021
 */
public class DoctorSlotCheck {
	
	private int doctorId;
	
	private LocalDate checkDate;
	/**
	 * getter for doctorId
	 * @return the doctorId
	 */
	public int getDoctorId() {
		return doctorId;
	}
	/**
	 * setter for doctorId
	 * @param doctorId the doctorId to set
	 */
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	/**
	 * getter for checkDate
	 * @return the checkDate
	 */
	public LocalDate getCheckDate() {
		return checkDate;
	}
	/**
	 * setter for checkDate
	 * @param checkDate the checkDate to set
	 */
	public void setCheckDate(LocalDate checkDate) {
		this.checkDate = checkDate;
	}
	
}
