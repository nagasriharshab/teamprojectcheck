package com.abc.healthcenter.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.abc.healthcenter.entity.BillEntity;
import com.abc.healthcenter.exception.ResourceAlreadyExistException;
import com.abc.healthcenter.exception.ResourceNotFoundException;
import com.abc.healthcenter.model.Bill;
import com.abc.healthcenter.repository.BillRepository;

public class BillServiceImpl implements BillService {
	
	@Autowired
	private BillRepository billRepository;

	@Override
	public void saveBill(Bill bill) throws ResourceAlreadyExistException {
		Optional<BillEntity> billEntity = billRepository.findById(bill.getBillId());
		if(billEntity.isPresent()) {
			throw new ResourceAlreadyExistException("Bill already exist with this id "+bill.getBillId());
		}
		else {
			BillEntity billEntity1 = convertModeltoEntity(bill);
			billRepository.save(billEntity1);
		}	
		
	}


	@Override
	public Bill findBillbyId(int id) throws ResourceNotFoundException {
		Optional<BillEntity> billEntity = billRepository.findById(id);
		Bill bill = null;
		if(billEntity.isPresent()) {
			bill = convertEntitytoModel(billEntity);
			return bill;
		}
		else {
			throw new ResourceNotFoundException("No bill found with this ID"+id);
		}
	}

	
	private BillEntity convertModeltoEntity(Bill bill) {
		BillEntity billEntity = new BillEntity();
		billEntity.setBillId(bill.getBillId());
		billEntity.setBillAmount(bill.getBillAmount());
		return billEntity;
		
	}
	private Bill convertEntitytoModel(Optional<BillEntity> billEntity) {
		Bill bill = new Bill();
		bill.setBillId(billEntity.get().getBillId());
		bill.setBillAmount(billEntity.get().getBillAmount());
		bill.setAppointmentId(billEntity.get().getPayment().getAppointment().getAppointmentId());
		bill.setPaymentId(billEntity.get().getPayment().getPaymentId());
		return bill;
	
	}
}
