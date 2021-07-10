package com.abc.healthcenter.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.abc.healthcenter.entity.AppointmentEntity;
import com.abc.healthcenter.model.Appointment;
import com.abc.healthcenter.repository.AppointmentRepository;

/**
 * 
 * @author NAGA SRI HARSHA
 * date : 09-July-2021
 */
@SpringBootTest
public class AppointmentServiceTest {
	
	@Mock
	private AppointmentRepository appointmentRepository;
	@InjectMocks
	private AppointmentServiceImpl appointmentServiceImp;
	
	@Test
	public void testFindAppointmentById() {
		Appointment appointment = new Appointment();
		AppointmentEntity appointmentEntity = new AppointmentEntity();
		appointment.setAppointmentId(1111);
		appointment.setAppointmentDate(null);
		appointment.setAppointmentSlot(1);
		appointment.setDoctorId(2);
		appointment.setPatientId(1333);
		appointment.setPaymentId(1444);
		
		
		
		
		
	}

}
