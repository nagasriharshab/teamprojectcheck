package com.abc.healthcenter.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.healthcenter.entity.DoctorEntity;

public interface DoctorRepository extends JpaRepository<DoctorEntity, Integer> {
 public Optional<DoctorEntity> findByDoctorName(String DoctorName);
 public Optional<DoctorEntity> findByDoctorUserName(String DoctorUserName);
 public boolean existsByDoctorUserName(String DoctorUserName);
}
