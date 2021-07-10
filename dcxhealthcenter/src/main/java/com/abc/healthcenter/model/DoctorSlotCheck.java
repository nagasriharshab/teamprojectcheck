/**
 * 
 */
package com.abc.healthcenter.model;

import java.time.LocalDate;

/**
 * @author NAGA SRI HARSHA
 * date : 10-Jul-2021
 */
public class DoctorSlotCheck {
	
	private int doctorId;
	
	private LocalDate checkDate;
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
	 * @return the checkDate
	 */
	public LocalDate getCheckDate() {
		return checkDate;
	}
	/**
	 * @param checkDate the checkDate to set
	 */
	public void setCheckDate(LocalDate checkDate) {
		this.checkDate = checkDate;
	}
	
}
