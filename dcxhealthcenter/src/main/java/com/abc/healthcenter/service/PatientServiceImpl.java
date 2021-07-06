package com.abc.healthcenter.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.abc.healthcenter.entity.PatientEntity;
import com.abc.healthcenter.exception.ResourceAlreadyExistException;
import com.abc.healthcenter.exception.ResourceNotFoundException;
import com.abc.healthcenter.model.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.abc.healthcenter.repository.PatientRepository;

/**
 * @author likhith A S
 *
 * date: Jul 5, 2021
 */
@Service
public class PatientServiceImpl implements PatientService{
	
	 @Autowired
	    private PatientRepository patientRepository;
	 private static final Logger LOGGER = LoggerFactory.getLogger(PatientServiceImpl.class);
	 
	/**
	 * Implements Save Patient Details  from PatientService Interface
	 * {@inheritdoc}
	 */

	@Override
	public void savePatient(Patient patient) throws ResourceAlreadyExistException {
		LOGGER.info("patientRepository::findById(int id)method called");
		 Optional<PatientEntity> optionalPatient = patientRepository.findById(patient.getPatientId());
			
			if(optionalPatient.isPresent()) {
				throw new ResourceAlreadyExistException("Patient already existing with id: "+patient.getPatientId());
			}
			else {
				PatientEntity patientEntity =convertModelToEntity(patient);
				
				patientRepository.save(patientEntity);
				LOGGER.info("patient details saved in repository");
				
			}
			LOGGER.info("Exiting from PatientServiceImpl::savePatient(Patient patient)method");
	}
	
	/**
	 *Implements Find Patient by Id from PatientService Interface
	 * {@inheritdoc}
	 */

	@Override
	public Patient findPatientbyId(int id) throws ResourceNotFoundException {
		
		LOGGER.info("patientRepository::findById method called from PatientService::findPatientbyId");
		Optional<PatientEntity> patientEntity = patientRepository.findById(id);
		if(patientEntity.isPresent()) {
		
			Patient patient = convertEntityToModel(patientEntity);
			LOGGER.info("returned patient object to PatientController::findPatient(int id)method");
			return patient;
		}
		else {
			LOGGER.error("ResourceNotFoundException encountered with ID "+id);
			throw new ResourceNotFoundException("Cannot find patient with this ID "+id);
		}
	}
	
	/**
	 *Implements delete Patient by Id from PatientService Interface
	 * {@inheritdoc}
	 */
	@Override
	public void deletePatientbyId(int id) throws ResourceNotFoundException {
		LOGGER.info("patientRepository::findById method called from PatientService::deletePatientbyId");
		Optional<PatientEntity> patientEntity = patientRepository.findById(id);
		if(patientEntity.isPresent()) {
			patientRepository.deleteById(id);
		}
		else {
			LOGGER.error("ResourceNotFoundException encountered with id "+id);
			throw new ResourceNotFoundException("Cannot find patient with this ID "+id);
		}
		LOGGER.info("Exiting from PatientServiceImpl::deletePatientbyId(int id)method");
	}
	
	/**
	 * Implements delete Patient by Name from PatientService Interface
	 * {@inheritdoc}
	 */
	@Override
	public Patient findPatientbyName(String name) throws ResourceNotFoundException {
		LOGGER.info("FindByName method called from PatientServiceImp::findPatientbyName method");
		Optional<PatientEntity> patientEntity = patientRepository.findByPatientName(name);
		if(patientEntity.isPresent()) {
			Patient patient = convertEntityToModel(patientEntity);
			LOGGER.info("Requested Patient is created and returned");
			return patient;
		}
		else {
			LOGGER.info("ResourceNotFoundException encountered with name "+name);
			throw new ResourceNotFoundException("Cannot find patient with this Name "+name);
		}
	}
	/**
	 * Implements update Patient from PatientService Interface
	 *  {@inheritdoc}
	 */
	@Override
	public void updatePatient(Patient patient) throws ResourceNotFoundException {
		LOGGER.info("patientRepository::findById method called from PatientService::updatePatientbyId");
		PatientEntity patientEntity = patientRepository.findById(patient.getPatientId()).get();
		
		if(patientEntity==null) {
			LOGGER.error("ResourceNotFoundException encountered with id "+patient.getPatientId());
			throw new ResourceNotFoundException("Cannot Find Patient with this id: "+patient.getPatientId());
		}
		else {
			
			patientEntity.setPatientId(patient.getPatientId());
			patientEntity.setPatientName(patient.getPatientName());
			patientEntity.setPatientAddress(patient.getPatientAddress());
			patientEntity.setPatientAge(patient.getPatientAge());
			patientEntity.setPatientContact(patient.getPatientContact());
			patientEntity.setPatientGender(patient.getPatientGender());
			patientEntity.setPatientEmail(patient.getPatientEmail());
			patientEntity.setPatientuserName(patient.getPatientuserName());
			patientEntity.setPatientpassword(patient.getPatientpassword());
			patientEntity.setPatientMessage(patient.getPatientMessage());
			patientEntity.setAppointments(patient.getAppointments());
			patientEntity.setPayments(patient.getPayments());
			patientRepository.save(patientEntity);
			LOGGER.info("patient details updated in repository");
		}
		LOGGER.info("Exiting from PatientServiceImpl::updatePatient(Patient patient)method");
	}
	
	/**
	 * This method converts model into entity
	 * @param patient
	 * @return patientEntity
	 */
	private PatientEntity convertModelToEntity(Patient patient) {
		PatientEntity patientEntity = new PatientEntity();
		patientEntity.setPatientId(patient.getPatientId());
		patientEntity.setPatientName(patient.getPatientName());
		patientEntity.setPatientAddress(patient.getPatientAddress());
		patientEntity.setPatientAge(patient.getPatientAge());
		patientEntity.setPatientContact(patient.getPatientContact());
		patientEntity.setPatientGender(patient.getPatientGender());
		patientEntity.setPatientEmail(patient.getPatientEmail());
		patientEntity.setPatientuserName(patient.getPatientuserName());
		patientEntity.setPatientpassword(patient.getPatientpassword());
		patientEntity.setPatientMessage(patient.getPatientMessage());
		patientEntity.setAppointments(patient.getAppointments());
		patientEntity.setPayments(patient.getPayments());
		
		return patientEntity;
		
	}
	
	/**
	 * this method converts Entity to model
	 * @param patientEntity
	 * @return patient
	 */
	private Patient convertEntityToModel(Optional<PatientEntity> patientEntity) {
		Patient patient = new Patient();
		patient.setPatientId(patientEntity.get().getPatientId());
		patient.setPatientName(patientEntity.get().getPatientName());
		patient.setPatientAddress(patientEntity.get().getPatientAddress());
		patient.setPatientAge(patientEntity.get().getPatientAge());
		patient.setPatientContact(patientEntity.get().getPatientContact());
		patient.setPatientGender(patientEntity.get().getPatientGender());
		patient.setPatientEmail(patientEntity.get().getPatientEmail());
		patient.setPatientuserName(patientEntity.get().getPatientuserName());
		patient.setPatientpassword(patientEntity.get().getPatientpassword());
		patient.setPatientMessage(patientEntity.get().getPatientMessage());
		patient.setAppointments(patientEntity.get().getAppointments());
		patient.setPayments(patientEntity.get().getPayments());
		return patient;
	}
	

}