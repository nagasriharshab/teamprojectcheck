package com.abc.healthcenter.controller;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.abc.healthcenter.model.News;
import com.abc.healthcenter.model.Response;
import com.abc.healthcenter.service.NewsService;


/**
 * @author venkatesh
 *
 *Date : 06-Jul-2021
 */
@RestController
@Validated
@RequestMapping("/news")
public class NewsController {
	
	Response response = new Response();

	@Autowired
	private NewsService newsService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(NewsController.class);

	/**
	 * method to add news details
	 * @param news
	 * @return
	 */
	@PostMapping("/save")
	public ResponseEntity<?> addNews(@Valid @RequestBody News news){
		LOGGER.info("newsserviceimp::saveNews(News news) method calling");
		
		newsService.saveNews(news);
		response.setMsg("News "+news.getNewsHeader()+",News Added.");
		response.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}
	
	
	/**
	 * method to delete the news based on newsId
	 * @param id
	 * @return
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteNews(@Valid @Min(1) @PathVariable int id){
		LOGGER.info("newsserviceimp::deleteNews(News news) method calling");
		
		newsService.deleteNewsbyId(id);
		response.setMsg("Deleted Successfully");
		response.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity<>(response,HttpStatus.FOUND);
	}
	
	/**
	 * method to update the news
	 * @param news
	 * @return
	 */
	@PutMapping("/update")
	public ResponseEntity<?> updateAdmin(@Valid @RequestBody News news) {
		LOGGER.info("newsserviceimp::updateNews(News news) method calling");
		
		newsService.updateNewsbyId(news);
		response.setMsg("Hello Admin "+news.getNewsId()+",News have been updated");
		response.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity<>(response,HttpStatus.FOUND);
	}
	
	/**
	 * method to find the news using id
	 * @param id
	 * @return response entity containing  the request made eand status
	 */
	@PostMapping("/find/{id}")
	public ResponseEntity<?> findNews(@Valid @Min(1) @PathVariable int id){
		
		LOGGER.info("newsServiceimp::findAdminbyId(int id) method calling");
		
		News news =newsService.findNewsbyId(id);
		
		return new ResponseEntity<>(news,HttpStatus.FOUND);
		
	}
}
