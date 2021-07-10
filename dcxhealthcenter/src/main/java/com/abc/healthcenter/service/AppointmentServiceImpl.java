package com.abc.healthcenter.service;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.healthcenter.entity.AppointmentEntity;
import com.abc.healthcenter.entity.DoctorEntity;
import com.abc.healthcenter.entity.PatientEntity;
import com.abc.healthcenter.exception.ResourceAlreadyExistException;
import com.abc.healthcenter.exception.ResourceNotFoundException;
import com.abc.healthcenter.exception.UnauthorisedAttemptException;
import com.abc.healthcenter.model.Appointment;
import com.abc.healthcenter.model.AppointmentFeedback;
import com.abc.healthcenter.repository.AppointmentRepository;
import com.abc.healthcenter.repository.DoctorRepository;
import com.abc.healthcenter.repository.PatientRepository;

/**
 * 
 * @author NAGA SRI HARSHA
 * date : 09-July-2021
 */
@Service
public class AppointmentServiceImpl implements AppointmentService {
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private PatientRepository patientRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AppointmentServiceImpl.class);

	/**
	 * Implements Save Appointment Details  from AppointmentService Interface
	 * {@inheritDoc}
	 */
	@Override
	public Appointment saveAppointment(Appointment appointment) throws ResourceAlreadyExistException {
		
		LOGGER.info("appointmentRepository::findAvailability(LocalDate localdate,int appointmentSlot)method called");
		List<AppointmentEntity> appointmentList = appointmentRepository.findAvalaibilityOfDoctor(appointment.getAppointmentDate(), appointment.getAppointmentSlot());
		LOGGER.info("converted appointmentmodel into appointmententity");
		AppointmentEntity appointmentEntity = convertAppointmentToAppointmentEntity(appointment);

		if(appointmentList.isEmpty()) {
			LOGGER.info("Appointment details saved in repository");
			AppointmentEntity returnedAppointmentEntity = appointmentRepository.save(appointmentEntity);
			LOGGER.info("Exiting from AppointmentServiceImp::saveAppointment(Appointment appointment)method");
			return convertAppointmentEntityToAppointment(returnedAppointmentEntity);
			}
		else {			
			Iterator<AppointmentEntity> i = appointmentList.iterator();
			while(i.hasNext()) {
				AppointmentEntity duplicateappointmentEntity = i.next();
				if(duplicateappointmentEntity.getDoctor().getDoctorId() == (appointment.getDoctorId())) {
					LOGGER.error("ResourceAlreadyExistException encountered with id"+appointment.getAppointmentId());
					throw new ResourceAlreadyExistException("Doctor isn't available for this slot : "+appointment.getAppointmentId());
				}
			}
			LOGGER.info("Appointment details saved in repository");
			AppointmentEntity returnedAppointmentEntity = appointmentRepository.save(appointmentEntity);
			LOGGER.info("Exiting from AppointmentServiceImp::saveAppointment(Appointment appointment)method");
			return convertAppointmentEntityToAppointment(returnedAppointmentEntity);
			}
			
		}


	/**
	 *Implements Find Appointment by Id from AppointmentService Interface
	 * {@inheritDoc}
	 */
	@Override
	public Appointment findAppointmentbyId(int id) throws ResourceNotFoundException {
	
		LOGGER.info("appointmentRepository::findById method called from AppointmentService::findAppointmentbyId");
		Optional<AppointmentEntity> appointmentEntity = appointmentRepository.findById(id);
		if(appointmentEntity.isPresent()) {
			return convertOptionalAppointmentEntityToAppointment(appointmentEntity);	
		}
		else 
		{
			LOGGER.error("ResourceNotFoundException encountered with ID "+id);
			throw new ResourceNotFoundException("Cannot find appointment with this ID :"+id);
		}
		
	}

	/**
	 *Implements delete Appointment by Id from AppointmentService Interface
	 * {@inheritDoc}
	 */
	
	@Override
	public void deleteAppointmentbyId(int id) throws ResourceNotFoundException {
		LOGGER.info("FindById method called from AppointmentServiceImp::deleteAppointmentbyId method");
		Optional<AppointmentEntity> appointmentEntity = appointmentRepository.findById(id);
		if(appointmentEntity.isPresent()) {	
			appointmentRepository.deleteById(id);
			LOGGER.info("DELETED the given Appointment Details");
		}else {
			LOGGER.error("ResourceNotFoundException encountered with ID "+id);
			throw new ResourceNotFoundException("Cannot find appointment with this ID "+id);
		}
		LOGGER.info("Exiting from AppointmentServiceImp::deleteAppointmentbyId(int id)method");
	}

	/**
	 *Implements updates Appointment by Id from AppointmentService Interface
	 * {@inheritDoc}
	 */
	@Override
	public void updateAppointmentById(Appointment appointment) throws ResourceNotFoundException {
		
		LOGGER.info("FindById method called from AppointmentServiceImp::updateAppointmentbyId method");
		AppointmentEntity appointmentEntity = appointmentRepository.findById(appointment.getAppointmentId()).get();
		
		if(appointmentEntity == null) {
			LOGGER.error("ResourceNotFoundException encountered with id "+appointment.getAppointmentId());
			throw new ResourceNotFoundException("Cannot find appointment with this ID "+appointment);
		}
		else {
			appointmentEntity.setAppointmentId(appointment.getAppointmentId());
			appointmentEntity.setAppointmentSlot(appointment.getAppointmentSlot());
			appointmentEntity.setAppointmentDate(appointment.getAppointmentDate());
			DoctorEntity doctorEntity = doctorRepository.findById(appointment.getDoctorId()).get();
			if(doctorEntity == null) {
				throw new ResourceNotFoundException("Cannot find doctor with this ID "+appointment.getDoctorId());
			}
			else {
				appointmentEntity.setDoctor(doctorEntity);
			}
			PatientEntity patientEntity = patientRepository.findById(appointment.getPatientId()).get();
			if(patientEntity == null) {
				throw new ResourceNotFoundException("Cannot find Patient with this ID "+appointment.getPatientId());
			}
			else {
				appointmentEntity.setPatient(patientEntity);
			}
			LOGGER.info("Appointment Details are updated");
			appointmentRepository.save(appointmentEntity);
		}
		LOGGER.info("Exiting from AppointmentServiceImp::updateAppointmentbyId(Appointment appointment)method ");
		
	}


	@Override
	public List<Appointment> findAppointmentsByDoctorId(int doctorId) throws ResourceNotFoundException {
		List<AppointmentEntity> appointmentsList = appointmentRepository.findAllByDoctor(doctorId);
		if(appointmentsList.isEmpty()) {
			throw new ResourceNotFoundException("Cannot find appointments with this doctorID "+doctorId);
		}
		else {
			List<Appointment> appointments = new ArrayList<>();
			Iterator<AppointmentEntity> i =  appointmentsList.iterator();
			
			while(i.hasNext()) {
				AppointmentEntity appointment = i.next();
				Appointment appointmentModel =  convertAppointmentEntityToAppointment(appointment);
				appointments.add(appointmentModel);
				}
			return  appointments;
		}
	}

	@Override
	public List<Appointment> findAppointmentsByPatientId(int patientId) throws ResourceNotFoundException {
		
		List<AppointmentEntity> appointmentsList = appointmentRepository.findAllByPatient(patientId);
		if(appointmentsList.isEmpty()) {
			throw new ResourceNotFoundException("Cannot find appointments with this ID "+patientId);
			
		}
		else {
			List<Appointment> appointments = new ArrayList<>();			
			Iterator<AppointmentEntity> i =  appointmentsList.iterator();
			
			while(i.hasNext()) {
				AppointmentEntity appointment = i.next();
				Appointment appointmentModel =  convertAppointmentEntityToAppointment(appointment);
				appointments.add(appointmentModel);
				
				
				
			}
			return  appointments;
		}
	}
	
	@Override
	public void saveFeedback(AppointmentFeedback feedback) throws ResourceAlreadyExistException,UnauthorisedAttemptException,ResourceNotFoundException {
		 if(appointmentRepository.existsById(feedback.getAppointmentId())) {
			 AppointmentEntity appointmentEntity = appointmentRepository.findById(feedback.getAppointmentId()).get();
			 if(appointmentEntity.getPatient().getPatientId() == feedback.getPatientId()) {
				 if(appointmentEntity.getFeedback().isEmpty()) {
					 appointmentEntity.setFeedback(feedback.getFeedback());
					 appointmentEntity.setRating(feedback.getRating());
					 appointmentRepository.save(appointmentEntity);
				 }else {
					 throw new ResourceAlreadyExistException("THe feedback is already submitted for this appointment"+feedback.getAppointmentId());
				 }
			 }
			 else {
				 throw new UnauthorisedAttemptException("Sorry,You cant fill feedback for this appointment"+feedback.getPatientId());
			 }
		 }
		 else {
			 throw new ResourceNotFoundException("No appointment is scheduled with this Id"+feedback.getAppointmentId());
		 }
	}
	@Override
	public String viewfeedback(int appointmentId)throws ResourceNotFoundException{
		if(appointmentRepository.existsById(appointmentId)) {
			String feedback = appointmentRepository.findById(appointmentId).get().getFeedback();
			if(feedback.isEmpty()) {
				throw new ResourceNotFoundException("Patient haven't given feedback yet"+appointmentId);
			}
			else {
				return feedback;
			}
		}
		else {
			throw new ResourceNotFoundException("No appointment is scheduled with this Id"+appointmentId);
		}
	}
	public DoctorEntity convertOptionalEntityToDoctorEntity(Optional<DoctorEntity> optionalDoctorEntity) {
		DoctorEntity doctorEntity = new DoctorEntity();
		doctorEntity.setDoctorId(optionalDoctorEntity.get().getDoctorId());
		doctorEntity.setDoctorId(optionalDoctorEntity.get().getDoctorId());
		doctorEntity.setDoctorName(optionalDoctorEntity.get().getDoctorName());
		doctorEntity.setDoctorEmail(optionalDoctorEntity.get().getDoctorEmail());
		doctorEntity.setDoctorContact(optionalDoctorEntity.get().getDoctorContact());
		doctorEntity.setDoctorDepartment(optionalDoctorEntity.get().getDoctorDepartment());
		doctorEntity.setDoctorExperience(optionalDoctorEntity.get().getDoctorExperience());
		doctorEntity.setDoctorGender(optionalDoctorEntity.get().getDoctorGender());
		doctorEntity.setDoctorQualification(optionalDoctorEntity.get().getDoctorQualification());
		doctorEntity.setDoctorAddress(optionalDoctorEntity.get().getDoctorAddress());
		doctorEntity.setDoctorUserName(optionalDoctorEntity.get().getDoctorUserName());
		doctorEntity.setDoctorPassword(optionalDoctorEntity.get().getDoctorPassword());
		return doctorEntity;
	}
	public PatientEntity convertOptionalEntityToPatientEntity(Optional<PatientEntity> optionalPatientEntity) {
		PatientEntity patientEntity = new PatientEntity();
		patientEntity.setPatientId(optionalPatientEntity.get().getPatientId());
		patientEntity.setPatientName(optionalPatientEntity.get().getPatientName());
		patientEntity.setPatientAddress(optionalPatientEntity.get().getPatientAddress());
		patientEntity.setPatientAge(optionalPatientEntity.get().getPatientAge());
		patientEntity.setPatientContact(optionalPatientEntity.get().getPatientContact());
		patientEntity.setPatientGender(optionalPatientEntity.get().getPatientGender());
		patientEntity.setPatientEmail(optionalPatientEntity.get().getPatientEmail());
		patientEntity.setPatientUserName(optionalPatientEntity.get().getPatientUserName());
		patientEntity.setPatientPassword(optionalPatientEntity.get().getPatientPassword());
		patientEntity.setPatientMessage(optionalPatientEntity.get().getPatientMessage());
		return patientEntity;
	}
	public Appointment convertAppointmentEntityToAppointment(AppointmentEntity appointmentEntity) {
		Appointment appointment = new Appointment();
		appointment.setAppointmentDate(appointmentEntity.getAppointmentDate());
		appointment.setAppointmentId(appointmentEntity.getAppointmentId());
		appointment.setAppointmentSlot(appointmentEntity.getAppointmentSlot());
		appointment.setDoctorId(appointmentEntity.getDoctor().getDoctorId());
		appointment.setPatientId(appointmentEntity.getPatient().getPatientId());
		return appointment;
	}
	public Appointment convertOptionalAppointmentEntityToAppointment(Optional<AppointmentEntity> appointmentEntity) {
		Appointment appointment = new Appointment();
		appointment.setAppointmentDate(appointmentEntity.get().getAppointmentDate());
		appointment.setAppointmentId(appointmentEntity.get().getAppointmentId());
		appointment.setAppointmentSlot(appointmentEntity.get().getAppointmentSlot());
		appointment.setDoctorId(appointmentEntity.get().getDoctor().getDoctorId());
		appointment.setPatientId(appointmentEntity.get().getPatient().getPatientId());
		return appointment;
	}
	public AppointmentEntity convertAppointmentToAppointmentEntity(Appointment appointment) {
		AppointmentEntity appointmentEntity = new AppointmentEntity();
		appointmentEntity.setAppointmentId(appointment.getAppointmentId());
		appointmentEntity.setAppointmentSlot(appointment.getAppointmentSlot());
		appointmentEntity.setAppointmentDate(appointment.getAppointmentDate());
		
		Optional<DoctorEntity> optionalDoctorEntity = doctorRepository.findById(appointment.getDoctorId());
		if(optionalDoctorEntity.isPresent()) {
			DoctorEntity doctorEntity = convertOptionalEntityToDoctorEntity(optionalDoctorEntity); 
			appointmentEntity.setDoctor(doctorEntity);
		}
		
		Optional<PatientEntity> optionalPatientEntity = patientRepository.findById(appointment.getPatientId());
		if(optionalPatientEntity.isPresent()) {
			PatientEntity patientEntity = convertOptionalEntityToPatientEntity(optionalPatientEntity);
			appointmentEntity.setPatient(patientEntity);
		}
		
		appointmentEntity.setPayment(null);
		return appointmentEntity;
	}
}