/**
 * 
 */
package com.abc.healthcenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.abc.healthcenter.entity.PaymentEntity;



	public interface PaymentRepository extends JpaRepository<PaymentEntity ,Integer>{
	
}
