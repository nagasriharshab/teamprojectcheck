package com.abc.healthcenter.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.abc.healthcenter.entity.AppointmentEntity;
/**
 * 
 * @author NAGA SRI HARSHA
 * date : 09-July-2021
 */
public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Integer> {

	public List<AppointmentEntity> findAllByDoctor(int id);
	
	public List<AppointmentEntity> findAllByPatient(int id);
	
	@Query("SELECT d FROM AppointmentEntity d WHERE d.appointmentDate =?1 AND d.appointmentSlot = ?2")
	public List<AppointmentEntity> findAvalaibilityOfDoctor(LocalDate appointmentDate,int slot);

}