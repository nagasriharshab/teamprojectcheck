package com.abc.healthcenter.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.abc.healthcenter.entity.PatientEntity;
import com.abc.healthcenter.exception.ResourceNotFoundException;
import com.abc.healthcenter.model.Patient;
import com.abc.healthcenter.repository.PatientRepository;
import com.abc.healthcenter.service.PatientServiceImpl;

/**
 * @author Likhith A S
 *
 * date: Jul 6, 2021
 */
@SpringBootTest
public class PatientServiceTest {
	@Mock
	private PatientRepository patientRepository;
	@InjectMocks
	private PatientServiceImpl patientServiceImpl;
	
	@Test
	public void testFindPatientById() {
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
		Optional<PatientEntity> optionalPatient = Optional.of(patientEntity);
        
        
		when(patientRepository.findById(150)).thenReturn(optionalPatient);
		
		Patient patient=patientServiceImpl.findPatientbyId(150);
		
		assertEquals(patient.getPatientName(),patientEntity.getPatientName());
		assertEquals(patient.getPatientId(),patientEntity.getPatientId());
	}
	//test for exception
	 @Test
     public void testFindPatientByIdThrowingException() {
        
         when(patientRepository.findById(144)).thenThrow(ResourceNotFoundException.class);
        
         assertThrows(ResourceNotFoundException.class,()->patientServiceImpl.findPatientbyId(144));
     }
	
	 
	 @Test
		public void testFindPatientByName() {
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
			Optional<PatientEntity> optionalPatient = Optional.of(patientEntity);
	        
	        
			when(patientRepository.findByPatientName("likhi")).thenReturn(optionalPatient);
			
			Patient patient=patientServiceImpl.findPatientbyName("likhi");
			
			assertEquals(patient.getPatientName(),patientEntity.getPatientName());
			assertEquals(patient.getPatientId(),patientEntity.getPatientId());
			assertEquals(patient.getPatientUserName(),patientEntity.getPatientUserName());
		}
		// test for exception
		 @Test
	     public void testFindPatientByNameThrowingException() {
	        
	         when(patientRepository.findByPatientName("raksha")).thenThrow(ResourceNotFoundException.class);
	        
	         assertThrows(ResourceNotFoundException.class,()->patientServiceImpl.findPatientbyName("raksha"));
	     }// checking
		 
		
}