package com.abc.healthcenter.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.abc.healthcenter.entity.AppointmentEntity;
import com.abc.healthcenter.entity.DoctorEntity;
import com.abc.healthcenter.entity.PatientEntity;
/**
 * 
 * @author NAGA SRI HARSHA
 * date : 09-July-2021
 */
public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Integer> {
	/**
	 * method to find the list of appointments of the given doctor
	 * @param doctor
	 * @return list of appointments
	 */
	public List<AppointmentEntity> findAllByDoctor(DoctorEntity doctor);
	
	/**
	 * method to find the list of appointments of the given patient
	 * @param patient
	 * @return list of appointments
	 */
	public List<AppointmentEntity> findAllByPatient(PatientEntity patient);
	
	/**
	 * method to find the availability of the doctor on a particular date and slot
	 * @param appointmentDate
	 * @param slot
	 * @return list of appointments
	 */
	@Query("SELECT d FROM AppointmentEntity d WHERE d.appointmentDate =?1 AND d.appointmentSlot = ?2")
	public List<AppointmentEntity> findAvalaibilityOfDoctor(LocalDate appointmentDate,int slot);

	/**
	 * method to find the available slots of a doctor in a date
	 * @param date
	 * @param doctorId
	 * @return list of Appointments
	 */
	@Query("SELECT d FROM AppointmentEntity d WHERE d.appointmentDate = :date AND d.doctor.doctorId = :doctorId")
	public List<AppointmentEntity> findDoctorSlots(LocalDate date,int doctorId);
}