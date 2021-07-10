package com.abc.healthcenter.entity;

import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


import javax.persistence.Table;

/**
 * 
 * @author venkatesh
 *
 *Date : 05-Jul-2021
 */
@Entity
@Table(name = "news_tbl")
public class NewsEntity {

	@Id
	@Column(name="newsId")
	private int newsId;
	
	@Column(name="header")
	private String newsHeader;
	
	@Column(name="body")
	private String newsBody;
	
	@Column(name="contact")
	private String newsContact;
	
	@Column(name="date")
	private LocalDate newsDate;
	
	private int AdminId;
    /**
     * 
     * @return
     */
	public int getAdminId() {
		return AdminId;
	}
	/**
	 * 
	 * @param adminId
	 */
	public void setAdminId(int adminId) {
		AdminId = adminId;
	}
	/**
	 * getter for news id
	 * @return
	 */
	public int getNewsId() {
		return newsId;
	}
    /**
     * setter for news id
     * @param newsId
     */
	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}
    /**
     * getter for news header
     * @return
     */
	public String getNewsHeader() {
		return newsHeader;
	}
    /**
     * setter for news header
     * @param newsHeader
     */
	public void setNewsHeader(String newsHeader) {
		this.newsHeader = newsHeader;
	}
    /**
     * getter for news body
     * @return
     */
	public String getNewsBody() {
		return newsBody;
	}
    /**
     * setter for news body
     * @param newsBody
     */
	public void setNewsBody(String newsBody) {
		this.newsBody = newsBody;
	}
    /**
     * getter for news contact
     * @return
     */
	public String getNewsContact() {
		return newsContact;
	}
    /**
     * setter for news contact
     * @param newsContact
     */
	public void setNewsContact(String newsContact) {
		this.newsContact = newsContact;
	}
    /**
     * getter for news date
     * @return
     */
	public LocalDate getNewsDate() {
		return newsDate;
	}
    /**
     * setter for news date
     * @param newsDate
     */
	public void setNewsDate(LocalDate newsDate) {
		this.newsDate = newsDate;
	}
   
	
}

