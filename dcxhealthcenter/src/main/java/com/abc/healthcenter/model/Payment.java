package com.abc.healthcenter.model;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;



/**
 * 
 * @author Pavan
 *
 * Date : 06-Jul-2021
 */
public class Payment {
	private int paymentId;
	
	
	@NotEmpty (message="please provide payment date")
	private String paymentDate;
	
	
	@NotEmpty (message="please provide payment method")
	private String paymentMethod;
	
	@NotNull (message="please provide payment amount")
	private double paymentAmount;
	
	@NotNull (message="please provide payment amount")
	private int patientId;

	@NotNull (message="please provide payment amount")
	private int billId;
	
	@NotNull(message="please enter appointmentId")
	private int appointmentId;

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

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}
}
	
