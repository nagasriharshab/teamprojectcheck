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

import com.abc.healthcenter.model.Admin;
import com.abc.healthcenter.model.Response;
import com.abc.healthcenter.service.AdminService;

/**
 * 
 * @author venkatesh
 *
 *Date : 05-Jul-2021
 */
@RestController
@Validated
@RequestMapping("/admin")
public class AdminController {
	
	Response response = new Response();

	@Autowired
	private AdminService adminService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

	/**
	 * Method to add Admin details
	 * @param admin
	 * @return response entity containing  the request made eand status
	 */
	@PostMapping("/save")
	public ResponseEntity<?> addAdmin(@Valid @RequestBody Admin admin){
		
		LOGGER.info("adminserviceimp::saveAdmin(Admin admin) method calling");
		
		adminService.saveAdmin(admin);
		response.setMsg("Hello "+admin.getUserName()+",Welcome to HealthCenter.");
		response.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}
	
	/**
	 * Method to delete the Admin based on AdminId
	 * @param id
	 * @returnresponse entity containing  the request made and status
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteAdmin(@Valid @Min(1) @PathVariable int id){
		
		LOGGER.info("adminserviceimp::deleteAdmin(Admin admin) method calling");
		
		adminService.deleteAdminbyId(id);
		response.setMsg("Deleted Successfully");
		response.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity<>(response,HttpStatus.FOUND);
	}
	
	/**
	 * Method to update the existing Admin details
	 * @param admin
	 * @return response entity containing  the request made eand status
	 */
	@PutMapping("/update")
	public ResponseEntity<?> updateAdmin(@Valid @RequestBody Admin admin) {
		
		LOGGER.info("adminserviceimp::updateAdmin(Admin admin) method calling");
		
		adminService.updateAdminbyId(admin);
		response.setMsg("Hello Admin "+admin.getAdminId()+",details are updated");
		response.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity<>(response,HttpStatus.FOUND);
	}
	
	/**
	 * method to find the Admin using id
	 * @param id
	 * @return response entity containing  the request made eand status
	 */
	@PostMapping("/find/{id}")
	public ResponseEntity<?> findAdmin(@Valid @Min(1) @PathVariable int id){
		
		LOGGER.info("adminServiceimp::findAdminbyId(int id) method calling");
		
		Admin admin =adminService.findAdminbyId(id);
		
		return new ResponseEntity<>(admin,HttpStatus.FOUND);
		
	}
	
}