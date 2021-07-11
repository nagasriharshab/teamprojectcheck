package com.abc.healthcenter.service;

import java.util.List;

import com.abc.healthcenter.exception.ResourceAlreadyExistException;
import com.abc.healthcenter.exception.ResourceNotAvailableException;
import com.abc.healthcenter.exception.ResourceNotFoundException;
import com.abc.healthcenter.model.Appointment;
import com.abc.healthcenter.model.DoctorSlotCheck;

/**
 * AppointmentService Interface
 * @author NAGA SRI HARSHA
 * date : 10-July-2021
 */
public interface AppointmentService {
	/**
	 * method to save appointments
	 * @param appointment
	 * @throws ResourceAlreadyExistException
	 */
	public Appointment saveAppointment(Appointment appointment) throws ResourceAlreadyExistException;
	
	/**
	 * method to find appointments by appointment id
	 * @param id
	 * @return the found appointment
	 * @throws ResourceNotFoundException
	 */
	 public Appointment findAppointmentbyId(int id) throws ResourceNotFoundException;
	 
	 /**
	  * method to delete appointemnts by appointment id
	  * @param id
	  * @throws ResourceNotFoundException
	  */
	 public void deleteAppointmentbyId(int id)throws ResourceNotFoundException;
	 
	 /**
	  * method to find the list of appointments of a doctor
	  * @param name
	  * @return list of appointments
	  * @throws ResourceNotFoundException
	  */
	 public List<Appointment> findAppointmentsByDoctorId(int doctorId) throws ResourceNotFoundException;
	 
	 /**
	  * method to updaate appointment by id
	  * @param appointment
	  * @throws ResourceNotFoundException
	  */
	 public void updateAppointmentById(Appointment appointment) throws ResourceNotFoundException;
	 
	 /**
	  * method to find the list of appointments of a patient
	  * @param doctorId
	  * @return list of appointments
	  * @throws ResourceNotFoundException
	  */
	public List<Appointment> findAppointmentsByPatientId(int patientId) throws ResourceNotFoundException;
	
	/**
	 * method to return the number of slots available for a doctor on a particular date
	 * @param slotcheck
	 * @return list of slots
	 * @throws ResourceNotAvailableException
	 */
	public List<Integer> findAvailableSlotsOfDoctor(DoctorSlotCheck slotcheck) throws ResourceNotAvailableException;
}