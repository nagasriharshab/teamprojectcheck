package com.abc.healthcenter.service;


import com.abc.healthcenter.exception.ResourceAlreadyExistException;
import com.abc.healthcenter.exception.ResourceNotFoundException;
import com.abc.healthcenter.model.News;	



/**
 * @author vvanaboi
 *
 *Date : 06-Jul-2021
 */
public interface NewsService {
	
	/**
	 * method to save the news details
	 * @param news
	 * @throws ResourceAlreadyExistException
	 */
	
	public void saveNews(News news) throws ResourceAlreadyExistException;
	
	/**
	 * method to delete the news details
	 * @param newsHeader
	 * @throws ResourceNotFoundException
	 */
	
	public void deleteNewsbyId(int id) throws ResourceNotFoundException;
	
	/**
	 *method to update the news details 
	 * @param news
	 * @throws ResourceNotFoundException
	 */
	public void updateNewsbyId(News news) throws ResourceNotFoundException;
	
	
	/**
	 * method to find the news
	 * @param id
	 * @return
	 * @throws ResourceNotFoundException
	 */
	public News findNewsbyId(int id) throws ResourceNotFoundException;

}
