package com.abc.healthcenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.healthcenter.entity.AdminEntity;

/**
 * 
 * @author vvanaboi
 *
 *Date : 06-Jul-2021
 */

public interface AdminRepository extends JpaRepository<AdminEntity , Integer> {
	

}

