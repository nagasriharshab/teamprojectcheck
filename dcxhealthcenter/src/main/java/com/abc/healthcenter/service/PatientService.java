package com.abc.healthcenter.service;

import com.abc.healthcenter.exception.InvalidCredentialsException;
import com.abc.healthcenter.exception.ResourceAlreadyExistException;
import com.abc.healthcenter.exception.ResourceNotFoundException;

import com.abc.healthcenter.model.Patient;
import com.abc.healthcenter.model.PatientForgetPassword;
import com.abc.healthcenter.model.PatientLogin;

/**
 * 
 * @author likhith  A S
 *
 * date: Jul 5, 2021
 */
public interface PatientService {
	/**
	 * Method to save the Patient Details
	 * @param doctor
	 * @throws ResourceAlreadyExistingException
	 */
	
	 public void savePatient(Patient patient) throws ResourceAlreadyExistException;
	 /**
	  * Method to find Patient Details by using ID
	  * @param id
	  * @return patient
	  * @throws ResourceNotFoundException
	  */
	 
	 public Patient findPatientbyId(int id) throws ResourceNotFoundException;
	 /**
	  * Method to delete Patient Details by using ID
	  * @param id
	  * @throws ResourceNotFoundException
	  */
	 
	 public void deletePatientbyId(int id)throws ResourceNotFoundException;
	 /**
	  * Method to update Patient Details
	  * @param patient
	  * @throws ResourceAlreadyExistingException
	  */
	 
	 public void updatePatient(Patient patient) throws ResourceNotFoundException;
	 /**
	  * 
	  * @param name
	  * @return Patient details
	  * @throws ResourceNotFoundException
	  */
	 public Patient findPatientbyName(String name) throws ResourceNotFoundException;
	 
	 /**
	  * Method to check patient credentials
	  * @param patientlogin
	  * @return 
	  * @throws InvalidCredentialsException
	  */
	 public boolean checkPatientCredentials(PatientLogin patientlogin) throws InvalidCredentialsException;
	 
	 /**
	  * Method to change patient password
	  * @param patientcredentials
	  * @throws InvalidCredentialsException
	  */
	 public void forgetPasword(PatientForgetPassword patientcredentials) throws InvalidCredentialsException;
}