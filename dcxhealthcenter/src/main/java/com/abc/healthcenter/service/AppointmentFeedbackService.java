/**
 * 
 */
package com.abc.healthcenter.service;

import com.abc.healthcenter.exception.ResourceAlreadyExistException;
import com.abc.healthcenter.exception.ResourceNotAvailableException;
import com.abc.healthcenter.exception.ResourceNotFoundException;
import com.abc.healthcenter.model.AppointmentFeedback;

/**
 * @author NAGA SRI HARSHA
 * date : 10-July-2021
 */
public interface AppointmentFeedbackService {
	
	/**
	 * method to save feedback for an appointment
	 * @param feedback
	 * @return
	 */
	public AppointmentFeedback saveFeedback(AppointmentFeedback feedback) throws ResourceAlreadyExistException,ResourceNotFoundException;
	
	/**
	 * method to view feedback of an appointment
	 * @param AppointmentId
	 * @return
	 */
	public AppointmentFeedback viewFeedback(int appointmentId) throws ResourceNotFoundException,ResourceNotAvailableException;
}
