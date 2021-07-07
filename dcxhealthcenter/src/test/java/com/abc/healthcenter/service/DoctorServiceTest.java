
package com.abc.healthcenter.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.abc.healthcenter.entity.DoctorEntity;
import com.abc.healthcenter.exception.ResourceNotFoundException;
import com.abc.healthcenter.model.Doctor;
import com.abc.healthcenter.repository.DoctorRepository;

/**
 * @author NAGA SRI HARSHA
 *date : 06-July-2021
 */
@SpringBootTest
public class DoctorServiceTest {
	@Mock
	private DoctorRepository doctorRepository;
	
	@InjectMocks
	private DoctorServiceImp doctorServiceImp;
	
	@Test
	public void testFindbyId() {
		DoctorEntity  doctor = new DoctorEntity();
		doctor.setDoctorID(101);
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
		Optional<DoctorEntity> optionalDoctor = Optional .of(doctor);
		when(doctorRepository.findById(101)).thenReturn(optionalDoctor);
		Doctor doctorModel = doctorServiceImp.findDoctorbyId(101);
		assertNotNull(doctorModel);
		assertEquals(doctor.getDoctorName(),doctorModel.getDoctorName());
		assertEquals(doctor.getDoctorContact(),doctorModel.getDoctorContact());
	}
	
	
	@Test
	public void testSaveDoctor() {
		Doctor doctor = new Doctor();
			doctor.setDoctorID(101);
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
		doctorServiceImp.saveDoctor(doctor);
		
		DoctorEntity  doctorEntity = new DoctorEntity();
			doctorEntity.setDoctorID(101);
			doctorEntity.setDoctorName("ash");
			doctorEntity.setDoctorEmail("ash@gmail.com");
			doctorEntity.setDoctorContact(68479483723L);
			doctorEntity.setDoctorDepartment("general");
			doctorEntity.setDoctorExperience(3);
			doctorEntity.setDoctorGender("MALE");
			doctorEntity.setDoctorQualification("M.S,M.D");
			doctorEntity.setDoctorAddress("OSMANIA CAFE,Tadepalligudem");
			doctorEntity.setDoctorUserName("ASH");
			doctorEntity.setDoctorPassword("ASH");
			
		//Optional<DoctorEntity> optionalDoctor = Optional .of(doctorEntity);
		//when(doctorRepository.findById(101)).thenReturn(optionalDoctor);
		//verify(doctorRepository,times(1)).save(doctorEntity);
		}
	public void testFindbyIdThrowingException(){
		when(doctorRepository.findById(144)).thenThrow(ResourceNotFoundException.class);
		assertThrows(ResourceNotFoundException.class,()->doctorServiceImp.findDoctorbyId(144));
	}
}
