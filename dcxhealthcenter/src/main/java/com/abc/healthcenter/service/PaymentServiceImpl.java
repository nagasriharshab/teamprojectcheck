package com.abc.healthcenter.service;


import java.sql.Date;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.healthcenter.entity.PaymentEntity;
import com.abc.healthcenter.exception.ResourceAlreadyExistException;
import com.abc.healthcenter.exception.ResourceNotFoundException;
import com.abc.healthcenter.model.Payment;
import com.abc.healthcenter.repository.PaymentRepository;

/**
 * 
 * @author Pavan Panchal
 *
 * Date : 06-Jul-2021
 */
@Service
public class PaymentServiceImpl implements PaymentService{
	
	@Autowired
	private PaymentRepository paymentRepository;
	private static final Logger LOGGER = LoggerFactory.getLogger(PaymentServiceImpl.class);
	

	/**
	 * Implements Save Payment Details from PaymentService Interface
	 * {@inheritdoc}
	 */
	@Override
	public void makePayment(Payment payment) throws ResourceAlreadyExistException {
		LOGGER.info("paymentRepository::findById(int id)method called");
		Optional <PaymentEntity> paymentEntity = paymentRepository.findById(payment.getPaymentId());
		LOGGER.info("Optional <Payment> object saved");

		if (paymentEntity.isPresent()) {
			LOGGER.error("ResourceAlreadyExistException encountered with id"+payment.getPaymentId());

			throw new ResourceAlreadyExistException("Payment is already done with this ID "+payment.getPaymentId()+ " Amount : "+ payment.getPaymentAmount());

		}
		else {
			PaymentEntity paymentEntity1 = convertModelToEntity(payment);
			paymentRepository.save(paymentEntity1);
			LOGGER.info("Payment details saved in repository");

		}
		LOGGER.info("Exiting from PaymentServiceImpl::makePayment(Payment payment)method");

		
	}
	


	/**
	 * Implements Find Payment Details from PaymentService Interface
	 * {@inheritdoc}
	 */
	@Override
	public Payment getPaymentDetailsbyID(int id) throws ResourceNotFoundException {

		//Payment payment = new Payment();
		Optional <PaymentEntity> paymentEntity = paymentRepository.findById(id);
		if (paymentEntity.isPresent()) {
			Payment payment1 = convertEntityToModel(paymentEntity);
			LOGGER.info("returned payment object to PaymentController::getPaymentDetailsbyID(int id)method");
			return payment1;

		}
		else {
			LOGGER.error("ResourceNotFoundException encountered with ID "+id);
			throw new ResourceNotFoundException("Cannot find any payment with this ID : "+id);
		}
	}
	
	/**
	 * Implements delete Payment Details by Payment ID from PaymentService Interface
	 * {@inheritdoc}
	 */
	@Override
	public void deletePaymentbyId(int id) throws ResourceNotFoundException {
		LOGGER.info("paymentRepository::findById method called from PaymentService::deletePaymentbyId");

		Optional<PaymentEntity> paymentEntity = paymentRepository.findById(id);		
		if(paymentEntity.isPresent()) {
			paymentRepository.deleteById(id);
			LOGGER.info("We have received your request. Your refund is generated sucessfully");

			
		}
		else {
			LOGGER.error("ResourceNotFoundException encountered with id "+id);
			throw new ResourceNotFoundException("Cannot find any payment details with this ID "+id);
		}
	}

	
	@Override
	public void updatePayment(Payment payment) {
		
	
		
	}
	
	
	/**
	 * This method converts Model to Entity
	 * @param payment
	 * @return paymentEntity
	 */
	private PaymentEntity convertModelToEntity(Payment payment) {
		PaymentEntity paymentEntity = new PaymentEntity();
		paymentEntity.setPaymentAmount(payment.getPaymentAmount());
		paymentEntity.setPaymentId(payment.getPaymentId());	
		paymentEntity.setPaymentDate(Date.valueOf(payment.getPaymentDate()));
		paymentEntity.setPaymentMethod(payment.getPaymentMethod());

		return paymentEntity;
		
	}
	
	/**
	 * This method converts Entity to model
	 * @param paymentEntity
	 * @return payment
	 */
	private Payment convertEntityToModel(Optional<PaymentEntity> paymentEntity) {
		Payment payment = new Payment();
		
		payment.setPaymentId(paymentEntity.get().getPaymentId());
		payment.setPaymentDate(paymentEntity.get().getPaymentDate().toString());
		payment.setPaymentMethod(paymentEntity.get().getPaymentMethod());
		payment.setPaymentAmount(paymentEntity.get().getPaymentAmount());
		
		return payment;
	}


}