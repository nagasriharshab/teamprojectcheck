package com.abc.healthcenter.controller;

import java.util.List;


import javax.validation.Valid;

import javax.validation.constraints.Min;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.healthcenter.model.Appointment;
import com.abc.healthcenter.model.AppointmentFeedback;
import com.abc.healthcenter.model.DoctorSlotCheck;
import com.abc.healthcenter.model.Response;
import com.abc.healthcenter.service.AppointmentService;

/**
 * 
 * @author NAGA SRI HARSHA
 * date : 09-July-2021
 */
@RestController
@Validated
@RequestMapping("/appointment")
public class AppointmentController {
	

	Response response = new Response();
	
	@Autowired
	private AppointmentService appointmentService;
	
	private static final Logger LOGGER= LoggerFactory.getLogger(AppointmentController.class);
	
	
	@PostMapping("/save")
	public ResponseEntity<Object> addAppointment(@Valid @RequestBody Appointment appointment){
		LOGGER.info("AppointmentServiceImp::saveAppointment(Appointment appointment) method called");
		Appointment returnedAppointment = appointmentService.saveAppointment(appointment);	
		return new ResponseEntity<>(returnedAppointment,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Object> findAppointment(@Valid @Min(1) @PathVariable int id){
		LOGGER.info("AppointmentServiceImp::findAppointmentbyId(Appointment appointment) method called");
		Appointment appointment = appointmentService.findAppointmentbyId(id);
		return new ResponseEntity<>(appointment,HttpStatus.FOUND);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteAppointment(@Valid @Min(1) @PathVariable int id){
		appointmentService.deleteAppointmentbyId(id);
		response.setMsg("Deleted appointment successfully");
		response.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity<>(response,HttpStatus.FOUND);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Object> updateAppointment(@Valid @RequestBody Appointment appointment){
		appointmentService.updateAppointmentById(appointment);
		response.setMsg("Hello, your appointment detalis with Appointment Id "+appointment.getAppointmentId()+", are updated");
		response.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity<>(response,HttpStatus.FOUND);
	}
	
	@GetMapping("/findByDoctor/{id}")
	public ResponseEntity<Object> findAppointmentsByDoctor(@Valid @Min(1) @PathVariable int id){
		List<Appointment> appointment = appointmentService.findAppointmentsByDoctorId(id);
		return new ResponseEntity<>(appointment,HttpStatus.FOUND);
		
	}
	
	@GetMapping("/findByPatient/{id}")
	public ResponseEntity<Object> findAppointmentsByPatient(@Valid @Min(1) @PathVariable int id){
		List<Appointment> appointment = appointmentService.findAppointmentsByPatientId(id);
		return new ResponseEntity<>(appointment,HttpStatus.FOUND);
	}
	
	@PostMapping("/feedback/save")
	public ResponseEntity<Object> savefeedback(@Valid @RequestBody AppointmentFeedback feedback){
		appointmentService.saveFeedback(feedback);
		response.setMsg("your feedback is saved");
		response.setStatus(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/feedback/view/{id}")
	public ResponseEntity<Object> viewfeedback(@Valid @PathVariable int id){
		String feedback = appointmentService.viewfeedback(id);
		return new ResponseEntity<>(feedback,HttpStatus.FOUND);
	}
	
	@GetMapping("/slotcheck")
	public ResponseEntity<Object> checkslotforDoctor(@Valid @RequestBody DoctorSlotCheck slotcheck){
		List<Integer> availablelist = appointmentService.findAvailableSlotsOfDoctor(slotcheck);
		return new ResponseEntity<>(availablelist,HttpStatus.FOUND);
	}

}