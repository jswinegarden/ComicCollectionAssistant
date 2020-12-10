package com.techelevator.model;

import java.util.Date;

public class Comic {
	private Long comicId;
	private String comicName;
	private String publisherName;
	private String authorName;
	private String comicType;
	private Date datePublished;
	
	public Long getComicId() {
		return comicId;
	}
	public void setComicId(Long comicId) {
		this.comicId = comicId;
	}
	public String getComicName() {
		return comicName;
	}
	public void setComicName(String comicName) {
		this.comicName = comicName;
	}
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getComicType() {
		return comicType;
	}
	public void setComicType(String comicType) {
		this.comicType = comicType;
	}
	public Date getDatePublished() {
		return datePublished;
	}
	public void setDatePublished(Date datePublished) {
		this.datePublished = datePublished;
	}
	
	
}
