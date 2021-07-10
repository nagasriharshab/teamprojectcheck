package com.abc.healthcenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.healthcenter.entity.NewsEntity;
	

	/**
	 * @author venkatesh
	 *
	 *Date : 06-Jul-2021
	 */
	public interface NewsRepository extends JpaRepository<NewsEntity , Integer> {

}

