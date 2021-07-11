/**
 * 
 */
package com.abc.healthcenter.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.healthcenter.entity.AppointmentEntity;
import com.abc.healthcenter.entity.AppointmentFeedbackEntity;

/**
 * @author NAGA SRI HARSHA
 * date : 11-July-2021
 */
public interface AppointmentFeedbackRepository extends JpaRepository<AppointmentFeedbackEntity,Integer> {
	
	/**
	 * method to check whether a Feedback exists with the given appointment or not
	 * @param appointment
	 * @return
	 */
	public boolean existsByAppointment(AppointmentEntity appointment);
	
	/**
	 * method to find the feedback on the basis of appointment given
	 * @param appointment
	 * @return
	 */
	public Optional<AppointmentFeedbackEntity> findByAppointment(AppointmentEntity appointment);
}
