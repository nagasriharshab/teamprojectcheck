/**
 * 
 */
package com.abc.healthcenter.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.healthcenter.entity.AppointmentEntity;
import com.abc.healthcenter.entity.AppointmentFeedbackEntity;
import com.abc.healthcenter.exception.ResourceAlreadyExistException;
import com.abc.healthcenter.exception.ResourceNotAvailableException;
import com.abc.healthcenter.exception.ResourceNotFoundException;
import com.abc.healthcenter.model.AppointmentFeedback;
import com.abc.healthcenter.repository.AppointmentFeedbackRepository;
import com.abc.healthcenter.repository.AppointmentRepository;

/**
 * @author NAGA SRI HARSHA
 * date : 10-July-2021
 */
@Service
public class AppointmentFeedbackServiceImpl implements AppointmentFeedbackService {
@Autowired
private AppointmentFeedbackRepository appointmentFeedbackRepository;

@Autowired
private AppointmentRepository appointmentRepository;

private static final Logger LOGGER = LoggerFactory.getLogger(AppointmentFeedbackServiceImpl.class);

	/**
	 * implements saveFeedback method from AppointmentFeedbackService interface
	 * {@inheritDoc}
	 */
	@Override
	public AppointmentFeedback saveFeedback(AppointmentFeedback feedback) {
		LOGGER.info("AppointmentRepository::findById method called");
		Optional<AppointmentEntity> optionalAppointment = appointmentRepository.findById(feedback.getAppointmentId());
		if(optionalAppointment.isPresent()) {
			AppointmentEntity appointmentEntity = convertOptionalAppointmentEntityToAppointmentEntity(optionalAppointment);
			LOGGER.info("AppointmentFeedbackRepository::ExistsbyId method called");
			if(appointmentFeedbackRepository.existsByAppointment(appointmentEntity)) {
				LOGGER.error("ResourceAlreadyExistException encountered");
				throw new ResourceAlreadyExistException("Feed back already submitted");
			}
			else {
				AppointmentFeedbackEntity feedbackEntity = new AppointmentFeedbackEntity();
				feedbackEntity.setFeedback(feedback.getFeedback());
				feedbackEntity.setRating(feedback.getRating());
				feedbackEntity.setPatientId(feedback.getPatientId());
				feedbackEntity.setAppointment(appointmentEntity);
				LOGGER.info("AppointmentFeedbackRepository::save method called");
				AppointmentFeedbackEntity returnedFeedback = appointmentFeedbackRepository.save(feedbackEntity);
				return convertFeedbackEntityToFeedback(returnedFeedback);
					}
				}
		else {
			LOGGER.error("ResourceNotFoundException encountered with appointmentId"+feedback.getAppointmentId());
			throw new ResourceNotFoundException("No appoinment exists with this id"+feedback.getAppointmentId());
			}
	}
	/**
	 * implements viewFeedback method from AppointmentFeedbackService interface
	 * {@inheritDoc}
	 */
	@Override
	public AppointmentFeedback viewFeedback(int appointmentId) throws ResourceNotFoundException,ResourceNotAvailableException{
		LOGGER.info("AppointmentRepository::findById method called");
		Optional<AppointmentEntity> optionalAppointmentEntity = appointmentRepository.findById(appointmentId);
		if(optionalAppointmentEntity.isPresent()) {
			AppointmentEntity appointmentEntity = new AppointmentEntity();
			appointmentEntity.setAppointmentDate(optionalAppointmentEntity.get().getAppointmentDate());
			appointmentEntity.setAppointmentId(optionalAppointmentEntity.get().getAppointmentId());
			appointmentEntity.setAppointmentSlot(optionalAppointmentEntity.get().getAppointmentSlot());
			appointmentEntity.setDoctor(optionalAppointmentEntity.get().getDoctor());
			appointmentEntity.setFeedback(optionalAppointmentEntity.get().getFeedback());
			appointmentEntity.setPatient(optionalAppointmentEntity.get().getPatient());
			LOGGER.info("AppointmentFeedbackRepository::findByAppointment method called");
			Optional<AppointmentFeedbackEntity> optionalfeedbackEntity = appointmentFeedbackRepository.findByAppointment(appointmentEntity);
			if(optionalfeedbackEntity.isPresent()) {
				AppointmentFeedback feedback = new AppointmentFeedback();
				feedback.setAppointmentId(optionalfeedbackEntity.get().getAppointment().getAppointmentId());
				feedback.setFeedback(optionalfeedbackEntity.get().getFeedback());
				feedback.setPatientId(optionalfeedbackEntity.get().getPatientId());
				feedback.setRating(optionalfeedbackEntity.get().getRating());
				return feedback;
			}
			else {
				LOGGER.error("ResourceNotFoundException encountered");
				throw new ResourceNotAvailableException("Patient havent given feedback yet");
			}
		}
		else {
			LOGGER.error("ResourceNotFoundException encountered with this Id"+appointmentId);
			throw new ResourceNotFoundException("No appointment exists with this id"+appointmentId);
		}
	}
	private AppointmentEntity convertOptionalAppointmentEntityToAppointmentEntity(Optional<AppointmentEntity> appointmentEntity) {
		AppointmentEntity appointment = new AppointmentEntity();
		appointment.setAppointmentDate(appointmentEntity.get().getAppointmentDate());
		appointment.setAppointmentId(appointmentEntity.get().getAppointmentId());
		appointment.setAppointmentSlot(appointmentEntity.get().getAppointmentSlot());
		appointment.setDoctor(appointmentEntity.get().getDoctor());
		appointment.setPatient(appointmentEntity.get().getPatient());
		return appointment;
	}
	
	
	private AppointmentFeedback convertFeedbackEntityToFeedback(AppointmentFeedbackEntity appointmentFeedback) {
		AppointmentFeedback feedback = new AppointmentFeedback();
		feedback.setAppointmentId(appointmentFeedback.getAppointment().getAppointmentId());
		feedback.setFeedback(appointmentFeedback.getFeedback());
		feedback.setPatientId(appointmentFeedback.getPatientId());
		feedback.setRating(appointmentFeedback.getRating());
		return feedback;
	}

}