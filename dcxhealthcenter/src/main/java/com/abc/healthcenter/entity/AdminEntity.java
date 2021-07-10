package com.abc.healthcenter.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * 
 * @author venkatesh
 *
 *Date : 05-Jul-2021
 */
@Entity
@Table(name = "admin_tbl")

public class AdminEntity {
	@Id
	@Column(name="admin_id")
	private int adminId;
	
	@Column(name="name")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	
	//private List<NewsEntity> news;
	
	/**
	 * getter for admin id
	 * @return
	 */
	public int getAdminId() {
		return adminId;
	}
	/**
	 * setter for admin id
	 * @param adminId
	 */
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	/**
	 * getter for user name
	 * @return
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * setter for user name
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * getter for password
	 * @return
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * setter for password
	 * @param password
	 */

	public void setPassword(String password) {
		this.password = password;
	}
	
}
