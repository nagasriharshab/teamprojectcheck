package com.abc.healthcenter.controller;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.healthcenter.model.Payment;
import com.abc.healthcenter.model.Response;
import com.abc.healthcenter.service.PaymentService;


/**
 * 
 * @author Pavan Panchal
 *
 * Date : 06-Jul-2021
 */

@RestController
@Validated
@RequestMapping("/payment")
public class PaymentController {
	Response response = new Response();
	private static final Logger LOGGER = LoggerFactory.getLogger(PaymentController.class);

	@Autowired
	private PaymentService paymentService;
	
	/**
	 * The method makes payment
	 * @param payment
	 * @return
	 */
	@PostMapping("/make")
	public ResponseEntity<?> makePayment(@Valid @RequestBody Payment payment){
		LOGGER.info("PaymentServiceImpl::makePayment(Payment payment) method called");
		paymentService.makePayment(payment);
		response.setMsg("Hello " + "" + ", Your payment is successful. We have recived the sum from you. You can check your payment details in your appointment ");
		response.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}
	
	/**
	 * The method finds payment details by payment ID
	 * @param id
	 * @return
	 */
	@PostMapping("/find/{id}")
	public ResponseEntity<?> getPaymentDetails(@Valid @Min(1) @PathVariable int id){
		LOGGER.info("PaymentServiceImpl::getPaymentDetailsbyID(int id) method called");
		Payment payment = paymentService.getPaymentDetailsbyID(id);
		return new ResponseEntity<>(payment ,HttpStatus.FOUND);
	}
	
	/**
	 * The method deletes payment details by payment ID
	 * @param id
	 * @return
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deletePayment(@Valid @Min(1) @PathVariable int id){
		LOGGER.info("PaymentServiceImpl::deletePaymentbyId(int id) method called");
		paymentService.deletePaymentbyId(id);
		response.setMsg("Hello "+ "" + ", your request for refund is processed. the status will be reflected in your appointment");
		response.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity<>(response,HttpStatus.FOUND);
	}
}
