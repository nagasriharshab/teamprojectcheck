package com.abc.healthcenter.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.abc.healthcenter.entity.PatientEntity;

/**
 * @author Likhith A S
 *
 * date: Jul 5, 2021
 */


	public interface PatientRepository extends JpaRepository<PatientEntity,Integer>{
		
		public Optional<PatientEntity> findByPatientName(String PatientName);
		public Optional<PatientEntity> findByPatientUserName(String PatientUserName);
		public boolean existsByPatientUserName(String PatientUserName);
			
	}