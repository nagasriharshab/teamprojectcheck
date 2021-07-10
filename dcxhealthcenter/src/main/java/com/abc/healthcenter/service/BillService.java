package com.abc.healthcenter.service;

import com.abc.healthcenter.exception.ResourceAlreadyExistException;
import com.abc.healthcenter.exception.ResourceNotFoundException;
import com.abc.healthcenter.model.Bill;

public interface BillService {
	public void saveBill(Bill bill) throws ResourceAlreadyExistException;
	public Bill findBillbyId(int id) throws ResourceNotFoundException;

}
