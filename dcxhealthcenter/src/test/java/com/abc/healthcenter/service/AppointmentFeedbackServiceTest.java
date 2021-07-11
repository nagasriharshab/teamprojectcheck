/**
 * 
 */
package com.abc.healthcenter.service;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.abc.healthcenter.entity.AppointmentEntity;
import com.abc.healthcenter.entity.AppointmentFeedbackEntity;
import com.abc.healthcenter.entity.DoctorEntity;
import com.abc.healthcenter.entity.PatientEntity;
import com.abc.healthcenter.model.Appointment;
import com.abc.healthcenter.model.AppointmentFeedback;
import com.abc.healthcenter.repository.AppointmentFeedbackRepository;
import com.abc.healthcenter.repository.AppointmentRepository;

/**
 * @author NAGA SRI HARSHA
 * date : 11-July-2021
 */
@SpringBootTest
public class AppointmentFeedbackServiceTest {
	@Mock
	private AppointmentFeedbackRepository appointmentfeedbackRepository;

	@Mock
	private AppointmentRepository appointmentRepository;
	
	@InjectMocks
	private AppointmentFeedbackServiceImpl appointmentFeedbackServiceImpl;
	
	@Test
	public void testSaveFeedback() {
		
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
		
		Optional<DoctorEntity> doctorEntity = Optional.of(doctor);
		
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
		appointment.setAppointmentId(1111);
		appointment.setAppointmentDate(LocalDate.parse("2020-07-10"));
		appointment.setAppointmentSlot(1);
		appointment.setDoctorId(101);
		appointment.setPatientId(500);
		
		AppointmentEntity appointmentEntity = new AppointmentEntity();
		appointmentEntity.setAppointmentId(1111);
		appointmentEntity.setAppointmentDate(LocalDate.parse("2020-07-10"));
		appointmentEntity.setAppointmentSlot(1);
		appointmentEntity.setDoctor(doctor);
		appointmentEntity.setPatient(patientEntity);
		Optional<AppointmentEntity> optionalEntity = Optional.of(appointmentEntity);
		
		AppointmentFeedback feedback = new AppointmentFeedback();
		feedback.setAppointmentId(1111);
		feedback.setFeedback("the doctor is good and treated nicely..the hygience is upto the standards.");
		feedback.setRating(9);
		feedback.setPatientId(500);
		
		AppointmentFeedback feedback1 = new AppointmentFeedback();
		feedback1.setAppointmentId(1111);
		feedback1.setFeedback("the doctor is good and treated nicely..the hygience is upto the standards.");
		feedback1.setRating(9);
		feedback1.setPatientId(500);
		
		AppointmentFeedbackEntity appointmentfeedback = new AppointmentFeedbackEntity();
		
		appointmentfeedback.setAppointment(appointmentEntity);
		appointmentfeedback.setFeedback("the doctor is good and treated nicely..the hygience is upto the standards.");
		appointmentfeedback.setRating(9);
		appointmentfeedback.setPatientId(500);
		
		when(appointmentRepository.findById(feedback.getAppointmentId())).thenReturn(optionalEntity);
		when(appointmentfeedbackRepository.existsByAppointment(appointmentEntity)).thenReturn(true);
		when(appointmentfeedbackRepository.save(appointmentfeedback)).thenReturn(appointmentfeedback);
		AppointmentFeedback returnfeedback = appointmentFeedbackServiceImpl.saveFeedback(feedback1);
		
		assertEquals(feedback.getAppointmentId(),returnfeedback.getAppointmentId());
		assertEquals(feedback.getFeedback(),returnfeedback.getFeedback());	
	}
	@Test
	public void testViewFeedback() {
		int appointmentId = 1111;
		

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
		
		Optional<DoctorEntity> doctorEntity = Optional.of(doctor);
		
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
		
		
		
		AppointmentEntity appointmentEntity = new AppointmentEntity();
		appointmentEntity.setAppointmentId(1111);
		appointmentEntity.setAppointmentDate(LocalDate.parse("2020-07-10"));
		appointmentEntity.setAppointmentSlot(1);
		appointmentEntity.setDoctor(doctor);
		appointmentEntity.setPatient(patientEntity);
		Optional<AppointmentEntity> optionalEntity = Optional.of(appointmentEntity);
		
		AppointmentFeedback feedback1 = new AppointmentFeedback();
		feedback1.setAppointmentId(1111);
		feedback1.setFeedback("the doctor is good and treated nicely..the hygience is upto the standards.");
		feedback1.setRating(9);
		feedback1.setPatientId(500);
		
		AppointmentFeedbackEntity appointmentfeedback = new AppointmentFeedbackEntity();
		appointmentfeedback.setFeedbackId(111);
		appointmentfeedback.setAppointment(appointmentEntity);
		appointmentfeedback.setFeedback("the doctor is good and treated nicely..the hygience is upto the standards.");
		appointmentfeedback.setRating(9);
		appointmentfeedback.setPatientId(500);
		Optional<AppointmentFeedbackEntity> optionalfeedback = Optional.of(appointmentfeedback);
		
		when(appointmentRepository.findById(appointmentId)).thenReturn(optionalEntity);
		when(appointmentfeedbackRepository.findByAppointment(appointmentEntity)).thenReturn(optionalfeedback);
		AppointmentFeedback returnfeedback = appointmentFeedbackServiceImpl.viewFeedback(appointmentId);
		assertEquals(returnfeedback.getAppointmentId(),appointmentfeedback.getAppointment().getAppointmentId());
		assertEquals(returnfeedback.getFeedback(),appointmentfeedback.getFeedback());	
	}
}
