package com.abc.healthcenter.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.abc.healthcenter.entity.AppointmentEntity;
import com.abc.healthcenter.entity.DoctorEntity;
import com.abc.healthcenter.entity.PatientEntity;
import com.abc.healthcenter.model.Appointment;
import com.abc.healthcenter.model.Doctor;
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
	private AppointmentServiceImpl appointmentServiceImpl;
	
	@Test
	public void testFindAppointmentById() {
		
		DoctorEntity doctor = new DoctorEntity();
		doctor.setDoctorId(101);
		doctor.setDoctorName("ash");
		doctor.setDoctorEmail("ash@gmail.com");
		doctor.setDoctorContact(68479483723L);
		doctor.setDoctorDepartment("general");
		doctor.setDoctorExperience(3);
		doctor.setDoctorGender("MALE");
		doctor.setDoctorQualification("M.S,M.D");
		doctor.setDoctorAddress("OSMANIA CAFE,Tadepalligudem");
		doctor.setDoctorUserName("ASH");
		doctor.setDoctorPassword("ASH");
		
		PatientEntity patientEntity = new PatientEntity();
		patientEntity.setPatientId(500);
		patientEntity.setPatientName("likhi");
		patientEntity.setPatientAddress("Bangalore");
		patientEntity.setPatientAge(23);
		patientEntity.setPatientContact(990);
		patientEntity.setPatientGender("Male");
		patientEntity.setPatientEmail("raksha@likhimail.com");
		patientEntity.setPatientUserName("likhi");
		patientEntity.setPatientPassword("likhi%%");
		patientEntity.setPatientMessage("Hello");
		
		Appointment appointment = new Appointment();
		AppointmentEntity appointmentEntity = new AppointmentEntity();
		appointment.setAppointmentId(1111);
		appointment.setAppointmentDate(LocalDate.parse("2020-07-10"));
		appointment.setAppointmentSlot(1);
		appointment.setDoctorId(2);
		appointment.setPatientId(1333);
		
		appointmentEntity.setAppointmentId(1111);
		appointmentEntity.setAppointmentDate(LocalDate.parse("2020-07-10"));
		appointmentEntity.setAppointmentSlot(1);
		appointmentEntity.setDoctor(doctor);
		appointmentEntity.setPatient(patientEntity);
		Optional<AppointmentEntity> optionalEntity = Optional.of(appointmentEntity);
		
		when(appointmentRepository.findById(appointment.getAppointmentId())).thenReturn(optionalEntity);
		
		Appointment returnedAppointment = appointmentServiceImpl.findAppointmentbyId(1111);
		assertEquals(returnedAppointment.getAppointmentDate(),optionalEntity.get().getAppointmentDate());
		assertEquals(returnedAppointment.getDoctorId(),optionalEntity.get().getDoctor().getDoctorId());
	}

	@Test
	public void testDeleteAppointmentbyId() {
		doNothing().when(appointmentRepository).deleteById(1);
		appointmentServiceImpl.deleteAppointmentbyId(1);
		verify(appointmentRepository).deleteById(1);
	}
}
