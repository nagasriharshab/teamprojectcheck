package com.abc.healthcenter.service;

import java.util.List;

import com.abc.healthcenter.exception.ResourceAlreadyExistException;
import com.abc.healthcenter.exception.ResourceNotAvailableException;
import com.abc.healthcenter.exception.ResourceNotFoundException;
import com.abc.healthcenter.exception.UnauthorisedAttemptException;
import com.abc.healthcenter.model.Appointment;
import com.abc.healthcenter.model.AppointmentFeedback;
import com.abc.healthcenter.model.DoctorSlotCheck;

/**
 * 
 * @author NAGA SRI HARSHA
 * date : 10-July-2021
 */
public interface AppointmentService {
	/**
	 * 
	 * @param appointment
	 * @throws ResourceAlreadyExistException
	 */
	public Appointment saveAppointment(Appointment appointment) throws ResourceAlreadyExistException;
	
	/**
	 * 
	 * @param id
	 * @return
	 * @throws ResourceNotFoundException
	 */
	 public Appointment findAppointmentbyId(int id) throws ResourceNotFoundException;
	 
	 /**
	  * 
	  * @param id
	  * @throws ResourceNotFoundException
	  */
	 public void deleteAppointmentbyId(int id)throws ResourceNotFoundException;
	 
	 /**
	  * 
	  * @param name
	  * @return
	  * @throws ResourceNotFoundException
	  */
	 public List<Appointment> findAppointmentsByDoctorId(int doctorId) throws ResourceNotFoundException;
	 
	 /**
	  * 
	  * @param appointment
	  * @throws ResourceNotFoundException
	  */
	 public void updateAppointmentById(Appointment appointment) throws ResourceNotFoundException;
	 
	 /**
	  * 
	  * @param doctorId
	  * @return
	  * @throws ResourceNotFoundException
	  */
	public List<Appointment> findAppointmentsByPatientId(int patientId) throws ResourceNotFoundException;
	
	/**
	 * 
	 * @param feedback
	 * @throws ResourceAlreadyExistException
	 * @throws UnauthorisedAttemptException
	 * @throws ResourceNotFoundException
	 */
	public void saveFeedback(AppointmentFeedback feedback) throws ResourceAlreadyExistException,UnauthorisedAttemptException,ResourceNotFoundException;
	
	/**
	 * 
	 * @param appointmentId
	 * @return
	 * @throws ResourceNotFoundException
	 */
	public String viewfeedback(int appointmentId)throws ResourceNotFoundException;
	
	public List<Integer> findAvailableSlotsOfDoctor(DoctorSlotCheck slotcheck) throws ResourceNotAvailableException;
}