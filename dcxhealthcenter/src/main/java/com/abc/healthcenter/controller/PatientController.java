package com.abc.healthcenter.controller;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.abc.healthcenter.model.Patient;
import com.abc.healthcenter.model.Response;
import com.abc.healthcenter.service.PatientService;

/**
 * @author Likhith A S
 *
 * date: Jul 5, 2021
 */

@RestController
@RequestMapping("/patient")
public class PatientController {
	Response response = new Response();
	private static final Logger LOGGER = LoggerFactory.getLogger(PatientController.class);

	@Autowired
	private PatientService patientService;
	/**
	 * Method to add patient details
	 * @param patient
	 * @return response entity containing the reply to request made and the status
	 */
	@PostMapping("/save")
	public ResponseEntity<?> addProduct(@Valid @RequestBody Patient patient) {	
		LOGGER.info("patientServiceImp::savePatient(Patient patient) method called");
		patientService.savePatient(patient);
		response.setMsg("Hi "+patient.getPatientName()+", your details have been saved");
		response.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}
	/**
	 * Method to find patient details by ID
	 * @param id
	 * @return response entity containing the reply to request made and the status
	 */
	@PostMapping("/find/{id}")
	public ResponseEntity<?> findPatient(@Valid @Min(1) @PathVariable int id){
		LOGGER.info("patientServiceImp::findPatientbyId(int id) method called");
		Patient patient= patientService.findPatientbyId(id);
		return new ResponseEntity<>(patient,HttpStatus.FOUND);
		
}
	
	/**
	 * Method to find the patient by patientName
	 * @param name
	 * @return response entity containing the reply to request made and the status
	 */
	@PostMapping("/findbyName/{name}")
	public ResponseEntity<?> findPatientbyNameMethod(@Valid @PathVariable String name){
		LOGGER.info("patientServiceImp::findPatientbyName(String name) method called");
		Patient patient = patientService.findPatientbyName(name);
		return new ResponseEntity<>(patient,HttpStatus.FOUND);
	}
	
	/**
	 * Method to delete the patient details using ID
	 * @param id
	 * @return response entity containing the reply to request made and the status
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deletePatient(@Valid @Min(1) @PathVariable int id){
		LOGGER.info("patientServiceImp::deletePatientbyId(int id) method called");
		patientService.deletePatientbyId(id);
		response.setMsg("Deleted successfully");
		response.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity<>(response,HttpStatus.FOUND);
	}
	
	/**
	 * Method to update the patient details using ID
	 * @param patient
	 * @return response entity containing the reply to request made and the status
	 */
	@PostMapping("/update")
	public ResponseEntity<?> updateProduct(@Valid @RequestBody Patient patient) {	
		LOGGER.info("patientServiceImp::updatePatient(Patient patient) method called");
		patientService.updatePatient(patient);
		response.setMsg("Hi "+patient.getPatientName()+", your details have been updated");
		response.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}
}
