package com.abc.healthcenter.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.abc.healthcenter.entity.AppointmentEntity;
import com.abc.healthcenter.entity.DoctorEntity;
import com.abc.healthcenter.entity.PatientEntity;
import com.abc.healthcenter.model.Appointment;
import com.abc.healthcenter.model.DoctorSlotCheck;
import com.abc.healthcenter.repository.AppointmentRepository;
import com.abc.healthcenter.repository.DoctorRepository;
import com.abc.healthcenter.repository.PatientRepository;

/**
 * 
 * @author NAGA SRI HARSHA
 * date : 09-July-2021
 */
@SpringBootTest
public class AppointmentServiceTest {
	
	@Mock
	private AppointmentRepository appointmentRepository;
	
	@Mock
	private DoctorRepository doctorRepository;
	
	@Mock
	private PatientRepository patientRepository;
	
	@InjectMocks
	private AppointmentServiceImpl appointmentServiceImpl;
	
	@Test
	public void testSaveAppointmentById() {
		
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
		
		Optional<DoctorEntity> optionalDoctor = Optional.of(doctor);
		
		DoctorEntity doctor1 = new DoctorEntity();
		doctor1.setDoctorId(102);
		doctor1.setDoctorName("hash");
		doctor1.setDoctorEmail("ash@gmail.com");
		doctor1.setDoctorContact(68479483723L);
		doctor1.setDoctorDepartment("general");
		doctor1.setDoctorExperience(3);
		doctor1.setDoctorGender("MALE");
		doctor1.setDoctorQualification("M.S,M.D");
		doctor1.setDoctorAddress("OSMANIA CAFE,Tadepalligudem");
		doctor1.setDoctorUserName("HASH");
		doctor1.setDoctorPassword("ASH");
		
		DoctorEntity doctor2 = new DoctorEntity();
		doctor2.setDoctorId(102);
		doctor2.setDoctorName("hash");
		doctor2.setDoctorEmail("ash@gmail.com");
		doctor2.setDoctorContact(68479483723L);
		doctor2.setDoctorDepartment("general");
		doctor2.setDoctorExperience(3);
		doctor2.setDoctorGender("MALE");
		doctor2.setDoctorQualification("M.S,M.D");
		doctor2.setDoctorAddress("OSMANIA CAFE,Tadepalligudem");
		doctor2.setDoctorUserName("HASH");
		doctor2.setDoctorPassword("ASH");
		
		Optional<DoctorEntity> optionalDoctor1 = Optional.of(doctor);
		
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
		
		Optional<PatientEntity> optionalPatientEntity = Optional.of(patientEntity);
		
		PatientEntity patientEntity1 = new PatientEntity();
		patientEntity1.setPatientId(501);
		patientEntity1.setPatientName("likh");
		patientEntity1.setPatientAddress("Bangalor");
		patientEntity1.setPatientAge(23);
		patientEntity1.setPatientContact(990);
		patientEntity1.setPatientGender("Male");
		patientEntity1.setPatientEmail("raksha@likhimail.com");
		patientEntity1.setPatientUserName("likhikk");
		patientEntity1.setPatientPassword("likhi%%");
		patientEntity1.setPatientMessage("Hello");
		
		Optional<PatientEntity> optionalPatientEntity1 = Optional.of(patientEntity);
		
		AppointmentEntity appointmentEntity1 = new AppointmentEntity();
		appointmentEntity1.setAppointmentId(1111);
		appointmentEntity1.setAppointmentDate(LocalDate.parse("2020-07-10"));
		appointmentEntity1.setAppointmentSlot(1);
		appointmentEntity1.setDoctor(doctor);
		appointmentEntity1.setPatient(patientEntity);
		
		AppointmentEntity appointmentEntity2 = new AppointmentEntity();
		appointmentEntity2.setAppointmentId(1112);
		appointmentEntity2.setAppointmentDate(LocalDate.parse("2020-07-10"));
		appointmentEntity2.setAppointmentSlot(5);
		appointmentEntity2.setDoctor(doctor);
		appointmentEntity2.setPatient(patientEntity);
		
		AppointmentEntity appointmentEntity3 = new AppointmentEntity();
		appointmentEntity3.setAppointmentId(1113);
		appointmentEntity3.setAppointmentDate(LocalDate.parse("2020-07-10"));
		appointmentEntity3.setAppointmentSlot(8);
		appointmentEntity3.setDoctor(doctor);
		appointmentEntity3.setPatient(patientEntity);
		
		AppointmentEntity appointmentEntity4 = new AppointmentEntity();
		appointmentEntity4.setAppointmentId(1111);
		appointmentEntity4.setAppointmentDate(LocalDate.parse("2020-07-10"));
		appointmentEntity4.setAppointmentSlot(1);
		appointmentEntity4.setDoctor(doctor1);
		appointmentEntity4.setPatient(patientEntity1);
		
		AppointmentEntity appointmentEntity5 = new AppointmentEntity();
		appointmentEntity5.setAppointmentId(1111);
		appointmentEntity5.setAppointmentDate(LocalDate.parse("2020-07-10"));
		appointmentEntity5.setAppointmentSlot(1);
		appointmentEntity5.setDoctor(doctor2);
		appointmentEntity5.setPatient(patientEntity1);
		
		ArrayList<AppointmentEntity> appointmentList = new ArrayList<>();
		appointmentList.add(appointmentEntity1);
		appointmentList.add(appointmentEntity2);
		appointmentList.add(appointmentEntity3);
		
		Appointment appointment1 =  convertAppointmentEntityToAppointment(appointmentEntity1);
		Appointment appointment2 =  convertAppointmentEntityToAppointment(appointmentEntity2);
		Appointment appointment3 =  convertAppointmentEntityToAppointment(appointmentEntity3);
		ArrayList<Appointment> appointmentModels = new ArrayList<>();
		appointmentModels.add(appointment1);
		appointmentModels.add(appointment2);
		appointmentModels.add(appointment3);
		
		ArrayList<AppointmentEntity> appointmentlists = new ArrayList<>();
		appointmentlists.add(appointmentEntity4);
		appointmentlists.add(appointmentEntity5);
		
		when(appointmentRepository.findAvalaibilityOfDoctor(appointment1.getAppointmentDate(), appointment1.getAppointmentSlot())).thenReturn(appointmentlists);
		when(appointmentRepository.save(appointmentEntity1)).thenReturn(appointmentEntity1);
		when(doctorRepository.findById(doctor.getDoctorId())).thenReturn(optionalDoctor);
		when(patientRepository.findById(patientEntity.getPatientId())).thenReturn(optionalPatientEntity);
		Appointment returnedAppointment = appointmentServiceImpl.saveAppointment(appointment1);
		assertEquals(returnedAppointment.getAppointmentDate(),appointment1.getAppointmentDate());
		assertEquals(returnedAppointment.getDoctorId(),appointment1.getDoctorId());
	}
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
		appointment.setDoctorId(2);
		appointment.setPatientId(500);
		
		AppointmentEntity appointmentEntity = new AppointmentEntity();
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
		Appointment appointment = new Appointment();
		appointment.setAppointmentId(1111);
		appointment.setAppointmentDate(LocalDate.parse("2020-07-10"));
		appointment.setAppointmentSlot(1);
		appointment.setDoctorId(2);
		appointment.setPatientId(1333);
		
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
		
		AppointmentEntity appointmentEntity = new AppointmentEntity();
		appointmentEntity.setAppointmentId(1111);
		appointmentEntity.setAppointmentDate(LocalDate.parse("2020-07-10"));
		appointmentEntity.setAppointmentSlot(1);
		appointmentEntity.setDoctor(doctor);
		appointmentEntity.setPatient(patientEntity);
		Optional<AppointmentEntity> optionalEntity = Optional.of(appointmentEntity);
		doNothing().when(appointmentRepository).deleteById(1111);
		when(appointmentRepository.findById(appointment.getAppointmentId())).thenReturn(optionalEntity);
		
		appointmentServiceImpl.deleteAppointmentbyId(1111);
		verify(appointmentRepository).deleteById(1111);
	}

	  @Test 
	  public void TestUpdateAppointmentById() { 
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
		  patientEntity.setPatientId(500); patientEntity.setPatientName("likhi");
		  patientEntity.setPatientAddress("Bangalore");
		  patientEntity.setPatientAge(23); patientEntity.setPatientContact(990);
		  patientEntity.setPatientGender("Male");
		  patientEntity.setPatientEmail("raksha@likhimail.com");
		  patientEntity.setPatientUserName("likhi");
		  patientEntity.setPatientPassword("likhi%%");
		  patientEntity.setPatientMessage("Hello");
	  
		Optional<PatientEntity> optionalPatientEntity = Optional.of(patientEntity);

	  
	  Appointment appointment = new Appointment();
	  appointment.setAppointmentId(1111);
	  appointment.setAppointmentDate(LocalDate.parse("2020-07-10"));
	  appointment.setAppointmentSlot(1); appointment.setDoctorId(2);
	  appointment.setPatientId(1333);
	  
	  AppointmentEntity appointmentEntity = new AppointmentEntity();
	  appointmentEntity.setAppointmentId(1111);
	  appointmentEntity.setAppointmentDate(LocalDate.parse("2020-07-10"));
	  appointmentEntity.setAppointmentSlot(1); appointmentEntity.setDoctor(doctor);
	  appointmentEntity.setPatient(patientEntity); 
	  Optional<AppointmentEntity> optionalappointment = Optional.of(appointmentEntity);
	  
	  AppointmentEntity appointmentEntity1 = new AppointmentEntity();
	  appointmentEntity1.setAppointmentId(1111);
	  appointmentEntity1.setAppointmentDate(LocalDate.parse("2020-07-10"));
	  appointmentEntity1.setAppointmentSlot(1); 
	  appointmentEntity1.setDoctor(doctor);
	  appointmentEntity1.setPatient(patientEntity); 
	  
	  when(appointmentRepository.findById(appointment.getAppointmentId())).thenReturn(optionalappointment);
	  when(doctorRepository.findById(appointment.getDoctorId())).thenReturn(doctorEntity);
	  when(patientRepository.findById(appointment.getPatientId())).thenReturn(optionalPatientEntity);
	  when(appointmentRepository.save(appointmentEntity)).thenReturn(appointmentEntity1); 
	  appointmentServiceImpl.saveAppointment(appointment);
	  verify(appointmentRepository).save(appointmentEntity); }
	 
	
	@Test
	public void TestFindAvailableSlotsOfDoctor() {
		List<Integer> slotlist = new ArrayList<>(List.of(2,3,4,6,7,9,10,11,12,13,14,15));
		
		DoctorSlotCheck slotcheck = new DoctorSlotCheck();
		slotcheck.setCheckDate(LocalDate.parse("2020-07-10"));
		slotcheck.setDoctorId(101);
		
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
		
		AppointmentEntity appointmentEntity1 = new AppointmentEntity();
		appointmentEntity1.setAppointmentId(1111);
		appointmentEntity1.setAppointmentDate(LocalDate.parse("2020-07-10"));
		appointmentEntity1.setAppointmentSlot(1);
		appointmentEntity1.setDoctor(doctor);
		appointmentEntity1.setPatient(patientEntity);
		
		AppointmentEntity appointmentEntity2 = new AppointmentEntity();
		appointmentEntity2.setAppointmentId(1112);
		appointmentEntity2.setAppointmentDate(LocalDate.parse("2020-07-10"));
		appointmentEntity2.setAppointmentSlot(5);
		appointmentEntity2.setDoctor(doctor);
		appointmentEntity2.setPatient(patientEntity);
		
		AppointmentEntity appointmentEntity3 = new AppointmentEntity();
		appointmentEntity3.setAppointmentId(1113);
		appointmentEntity3.setAppointmentDate(LocalDate.parse("2020-07-10"));
		appointmentEntity3.setAppointmentSlot(8);
		appointmentEntity3.setDoctor(doctor);
		appointmentEntity3.setPatient(patientEntity);

		ArrayList<AppointmentEntity> appointmentList = new ArrayList<>();
		appointmentList.add(appointmentEntity1);
		appointmentList.add(appointmentEntity2);
		appointmentList.add(appointmentEntity3);

		when(appointmentRepository.findDoctorSlots(slotcheck.getCheckDate(),slotcheck.getDoctorId())).thenReturn(appointmentList);
		
		List<Integer> returnlist = appointmentServiceImpl.findAvailableSlotsOfDoctor(slotcheck);
		assertEquals(slotlist,returnlist);
	}
	
	@Test
	public void testFindAppointmentsByDoctorId(){
		int doctorId = 101;
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
		  patientEntity.setPatientId(500); patientEntity.setPatientName("likhi");
		  patientEntity.setPatientAddress("Bangalore");
		  patientEntity.setPatientAge(23); patientEntity.setPatientContact(990);
		  patientEntity.setPatientGender("Male");
		  patientEntity.setPatientEmail("raksha@likhimail.com");
		  patientEntity.setPatientUserName("likhi");
		  patientEntity.setPatientPassword("likhi%%");
		  patientEntity.setPatientMessage("Hello");
	  
		Optional<PatientEntity> optionalPatientEntity = Optional.of(patientEntity);

	  
		Appointment appointment1 = new Appointment();
		appointment1.setAppointmentId(1111);
		appointment1.setAppointmentDate(LocalDate.parse("2020-07-10"));
		appointment1.setAppointmentSlot(1);
		appointment1.setDoctorId(101);
		appointment1.setPatientId(500);
		
		Appointment appointment2 = new Appointment();
		appointment2.setAppointmentId(1112);
		appointment2.setAppointmentDate(LocalDate.parse("2020-07-10"));
		appointment2.setAppointmentSlot(5);
		appointment2.setDoctorId(101);
		appointment2.setPatientId(500);
		
		Appointment appointment3 = new Appointment();
		appointment3.setAppointmentId(1113);
		appointment3.setAppointmentDate(LocalDate.parse("2020-07-10"));
		appointment3.setAppointmentSlot(8);
		appointment3.setDoctorId(101);
		appointment3.setPatientId(500);
		
		ArrayList<Appointment> appointmentModels = new ArrayList<>();
		appointmentModels.add(appointment1);
		appointmentModels.add(appointment2);
		appointmentModels.add(appointment3);
		
		AppointmentEntity appointmentEntity1 = new AppointmentEntity();
		appointmentEntity1.setAppointmentId(1111);
		appointmentEntity1.setAppointmentDate(LocalDate.parse("2020-07-10"));
		appointmentEntity1.setAppointmentSlot(1);
		appointmentEntity1.setDoctor(doctor);
		appointmentEntity1.setPatient(patientEntity);
		
		AppointmentEntity appointmentEntity2 = new AppointmentEntity();
		appointmentEntity2.setAppointmentId(1112);
		appointmentEntity2.setAppointmentDate(LocalDate.parse("2020-07-10"));
		appointmentEntity2.setAppointmentSlot(5);
		appointmentEntity2.setDoctor(doctor);
		appointmentEntity2.setPatient(patientEntity);
		
		AppointmentEntity appointmentEntity3 = new AppointmentEntity();
		appointmentEntity3.setAppointmentId(1113);
		appointmentEntity3.setAppointmentDate(LocalDate.parse("2020-07-10"));
		appointmentEntity3.setAppointmentSlot(8);
		appointmentEntity3.setDoctor(doctor);
		appointmentEntity3.setPatient(patientEntity);

		ArrayList<AppointmentEntity> appointmentList = new ArrayList<>();
		appointmentList.add(appointmentEntity1);
		appointmentList.add(appointmentEntity2);
		appointmentList.add(appointmentEntity3);
		
		when(doctorRepository.findById(doctorId)).thenReturn(doctorEntity);
		when(appointmentRepository.findAllByDoctor(doctor)).thenReturn(appointmentList);
		when(appointmentServiceImpl.convertOptionalEntityToDoctorEntity(doctorEntity)).thenReturn(doctor);
		List<Appointment> appointments = appointmentServiceImpl.findAppointmentsByDoctorId(doctorId);
		assertEquals(appointmentModels,appointments);
	}

	
	@Test
	public void testFindAppointmentsByPatientId() {
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
		
		AppointmentEntity appointmentEntity1 = new AppointmentEntity();
		appointmentEntity1.setAppointmentId(1111);
		appointmentEntity1.setAppointmentDate(LocalDate.parse("2020-07-10"));
		appointmentEntity1.setAppointmentSlot(1);
		appointmentEntity1.setDoctor(doctor);
		appointmentEntity1.setPatient(patientEntity);
		
		AppointmentEntity appointmentEntity2 = new AppointmentEntity();
		appointmentEntity2.setAppointmentId(1112);
		appointmentEntity2.setAppointmentDate(LocalDate.parse("2020-07-10"));
		appointmentEntity2.setAppointmentSlot(5);
		appointmentEntity2.setDoctor(doctor);
		appointmentEntity2.setPatient(patientEntity);
		
		AppointmentEntity appointmentEntity3 = new AppointmentEntity();
		appointmentEntity3.setAppointmentId(1113);
		appointmentEntity3.setAppointmentDate(LocalDate.parse("2020-07-10"));
		appointmentEntity3.setAppointmentSlot(8);
		appointmentEntity3.setDoctor(doctor);
		appointmentEntity3.setPatient(patientEntity);

		ArrayList<AppointmentEntity> appointmentList = new ArrayList<>();
		appointmentList.add(appointmentEntity1);
		appointmentList.add(appointmentEntity2);
		appointmentList.add(appointmentEntity3);
		
		Appointment appointment1 =  convertAppointmentEntityToAppointment(appointmentEntity1);
		Appointment appointment2 =  convertAppointmentEntityToAppointment(appointmentEntity2);
		Appointment appointment3 =  convertAppointmentEntityToAppointment(appointmentEntity3);
		ArrayList<Appointment> appointmentModels = new ArrayList<>();
		appointmentModels.add(appointment1);
		appointmentModels.add(appointment2);
		appointmentModels.add(appointment3);
		int patientId = 500;
		
		when(patientRepository.existsById(patientId)).thenReturn(true);
		when(doctorRepository.findById(patientId).get()).thenReturn(doctor);
		when(appointmentRepository.findAllByPatient(patientEntity)).thenReturn(appointmentList);
		List<Appointment> appointments = appointmentServiceImpl.findAppointmentsByPatientId(patientId);
		assertEquals(appointmentModels,appointments);
	}
	
	public Appointment convertAppointmentEntityToAppointment(AppointmentEntity appointmentEntity) {
		Appointment appointment = new Appointment();
		appointment.setAppointmentDate(appointmentEntity.getAppointmentDate());
		appointment.setAppointmentId(appointmentEntity.getAppointmentId());
		appointment.setAppointmentSlot(appointmentEntity.getAppointmentSlot());
		appointment.setDoctorId(appointmentEntity.getDoctor().getDoctorId());
		appointment.setPatientId(appointmentEntity.getPatient().getPatientId());
		return appointment;
	}
}
