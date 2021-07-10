package com.abc.healthcenter.service;

import com.abc.healthcenter.exception.ResourceAlreadyExistException;
import com.abc.healthcenter.exception.ResourceNotFoundException;
import com.abc.healthcenter.model.Payment;

/**
 * 
 * @author Pavan Panchal
 *
 */
	public interface PaymentService {

	/**
	 * 
	 * @param payment
	 * @throws ResourceAlreadyExistException
	 */
	public void makePayment(Payment payment) throws ResourceAlreadyExistException;

	/**
	 * 
	 * @param id
	 * @return
	 * @throws ResourceNotFoundException
	 */
	public Payment getPaymentDetailsbyID(int id)throws ResourceNotFoundException ;

	/**
	 * 
	 * @param id
	 * @throws ResourceNotFoundException
	 */
	public void deletePaymentbyId(int id) throws ResourceNotFoundException;

	/**
	 * 
	 * @param payment
	 * @throws ResourceNotFoundException
	 */
	public void updatePayment(Payment payment) throws ResourceNotFoundException;

	

}
