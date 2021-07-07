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

@Entity
@Table(name = "Appointment_tbl")
public class AppointmentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="appointment_id")
	private int AppointmentId;
	
	@Column(name ="appointment_date")
	private LocalDate AppointmentDate;
	
	@Column(name = "appointment_slot")
	private int AppointmentSlot;
	
	@ManyToOne
	@JoinColumn(name = "patient_id")
	private PatientEntity patient;
	
	@ManyToOne
	@JoinColumn(name="doctor_id")
	private DoctorEntity doctor;
	
	@OneToOne(mappedBy = "appointment",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private BillEntity bill;

	/**
	 * @return the appointmentId
	 */
	public int getAppointmentId() {
		return AppointmentId;
	}

	/**
	 * @param appointmentId the appointmentId to set
	 */
	public void setAppointmentId(int appointmentId) {
		AppointmentId = appointmentId;
	}

	/**
	 * @return the appointmentDate
	 */
	public LocalDate getAppointmentDate() {
		return AppointmentDate;
	}

	/**
	 * @param appointmentDate the appointmentDate to set
	 */
	public void setAppointmentDate(LocalDate appointmentDate) {
		AppointmentDate = appointmentDate;
	}

	/**
	 * @return the appointmentSlot
	 */
	public int getAppointmentSlot() {
		return AppointmentSlot;
	}

	/**
	 * @param appointmentSlot the appointmentSlot to set
	 */
	public void setAppointmentSlot(int appointmentSlot) {
		AppointmentSlot = appointmentSlot;
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
	 * @return the bill
	 */
	public BillEntity getBill() {
		return bill;
	}

	/**
	 * @param bill the bill to set
	 */
	public void setBill(BillEntity bill) {
		this.bill = bill;
	}

	
	
}
