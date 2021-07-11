/**
 * 
 */
package com.abc.healthcenter.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.healthcenter.model.AppointmentFeedback;
import com.abc.healthcenter.model.Response;
import com.abc.healthcenter.service.AppointmentFeedbackService;

/**
 * @author NAGA SRI HARSHA
 * date : 10-July-2021
 */
@RestController
@Validated
@RequestMapping("/feedback")
public class AppointmentFeedbackController {
	Response response = new Response();
	private static final Logger LOGGER = LoggerFactory.getLogger(AppointmentFeedbackController.class);
	
	@Autowired
	private AppointmentFeedbackService appointmentFeedbackService;
	/**
	 * Method to save patient's feedback to the appointment
	 * @param feedback
	 * @return response entity containing the details and status of saved feedback
	 */
	@PostMapping("/save")
	public ResponseEntity<Object> savefeedback(@Valid @RequestBody AppointmentFeedback feedback){
		LOGGER.info("appointmentFeedbackService::saveFeedback(AppointmentFeedback) method called");
		AppointmentFeedback returnedfeedback = appointmentFeedbackService.saveFeedback(feedback);
		LOGGER.info("returning the responseEntity for the request");
		return new ResponseEntity<>(returnedfeedback,HttpStatus.ACCEPTED);
	}
	/**
	 * method to view pateint's feedback for an appointment
	 * @param id
	 * @return response entity containing reply to the request made
	 */
	@GetMapping("/view/{id}")
	public ResponseEntity<Object> viewfeedback(@Valid @PathVariable int id){
		LOGGER.info("appointmentFeedbackService::viewFeedback(AppointmentId) method called");
		AppointmentFeedback feedback = appointmentFeedbackService.viewFeedback(id);
		LOGGER.info("returning the responseEntity for the request");
		return new ResponseEntity<>(feedback,HttpStatus.FOUND);
	}
}
