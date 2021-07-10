package com.abc.healthcenter.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.healthcenter.entity.AdminEntity;
import com.abc.healthcenter.exception.ResourceAlreadyExistException;
import com.abc.healthcenter.exception.ResourceNotFoundException;
import com.abc.healthcenter.model.Admin;
import com.abc.healthcenter.repository.AdminRepository;


/**
 * 
 * @author venkatesh
 *
 *Date : 05-Jul-2021
 */

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepository adminRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AdminServiceImpl.class);
	
	
    /**
     * implements saveAdmin from AdminService interface
     * {@inheritDoc}
     */
	@Override
	public void saveAdmin(Admin admin) throws ResourceAlreadyExistException {
		
		LOGGER.info("adminRepository::findById(int id)method called");
		
		Optional<AdminEntity> optionaladminEntity =adminRepository.findById(admin.getAdminId());
		
		LOGGER.info("Optional<Admin> object saved");
		if(optionaladminEntity.isPresent()) {
			LOGGER.error("ResourceAlreadyExistException encountered with id"+admin.getAdminId());
			throw new ResourceAlreadyExistException("Admin is already exist with this ID"+admin.getAdminId());
		}
		else {
			AdminEntity adminEntity = convertModeltoEntity(admin);
			adminRepository.save(adminEntity);
			LOGGER.info("Admin details saved in repository");
		
		}
		LOGGER.info("Exiting from AdminServiceImp::saveAdmin(Admin admin)method");
		
	}
	/**
	 * implements deleteAdmin from adminservice interface
	 * {@inheritDoc}
	 */
	@Override
	
	public void deleteAdminbyId(int id) throws ResourceNotFoundException {
		LOGGER.info("FindById method called from AdminServiceImp::deleteAdminbyId method");
		Optional<AdminEntity> adminEntity =adminRepository.findById(id);
		if(adminEntity.isPresent()) {
			adminRepository.deleteById(id);
			LOGGER.info("DELETED the given Admin Details");
		}
		else {
			LOGGER.error("ResourceNotFoundException encountered with id "+id);	
		throw new ResourceNotFoundException ("can not find Admin with this Id "+id);
		}
		
		LOGGER.info("Exiting from AdminServiceImp::deleteAdminbyId(int id)method");
	} 
	
	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void updateAdminbyId(Admin admin) throws ResourceNotFoundException {
		
		LOGGER.info("FindById method called from AdminServiceImp::updateAdminbyId method");
		AdminEntity adminEntity =adminRepository.findById(admin.getAdminId()).get();
		if(adminEntity == null) {
			LOGGER.error("ResourceNotFoundException encountered with id "+admin.getAdminId());
			throw new ResourceNotFoundException ("can not find Admin with this Id"+admin.getAdminId());
	}
		else {
			adminEntity.setAdminId(admin.getAdminId());
			adminEntity.setUserName(admin.getUserName());
			adminEntity.setPassword(admin.getPassword());
			adminRepository.save(adminEntity);
			LOGGER.info("Admin Details are updated");
		}
		LOGGER.info("Exiting from AdminServiceImp::updateAdminbyId(Admin admin)method ");
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Admin findAdminbyId(int id) throws ResourceNotFoundException {
		
		LOGGER.info("adminRepository::findbyId method calling from AdminService::FindAdminbyId");
		
		Optional<AdminEntity> adminEntity = adminRepository.findById(id);
		if(adminEntity.isPresent()) {
			
			Admin admin = convertEntitytoModel(adminEntity);
			LOGGER.info("returned admin object to admincontroller::findadmin(int id) method");
			return admin;
		}
		else {
			
			LOGGER.error("ResourceNotFoundException encounterd with Id" +id);
			throw new ResourceNotFoundException("can not find Admin with this id");
		}
		
	}
	
	/**
	 * converting model to entity
	 * @param admin
	 * @return adminEntity
	 */
	private AdminEntity convertModeltoEntity(Admin admin) {
		AdminEntity adminEntity = new AdminEntity ();
		adminEntity.setAdminId(admin.getAdminId());
		adminEntity.setUserName(admin.getUserName());
		adminEntity.setPassword(admin.getPassword());
		return adminEntity;
		
	}
		
	/**
	 * converting entity to model
	 * @param adminEntity
	 * @return admin
	 */
	private Admin convertEntitytoModel(Optional<AdminEntity> adminEntity) {
		Admin admin = new Admin();
		admin.setAdminId(adminEntity.get().getAdminId());
		admin.setUserName(adminEntity.get().getUserName());
		admin.setPassword(adminEntity.get().getPassword());
		return admin;
	}
	
	
}

