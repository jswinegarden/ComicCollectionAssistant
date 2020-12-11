package com.techelevator.model;

import java.util.Date;

public class Comic {
	private Long comicId;
	private String comicName;
	private String publisherName;
	private String authorName;
	private String comicType;
	private Date datePublished;
	
	public Comic(Long comicId, String comicName, String publisherName, String authorName, String comicType, Date datePublished) {
		this.comicId = comicId;
		this.comicName = comicName;
		this.publisherName = publisherName;
		this.authorName = authorName;
		this.comicType = comicType;
		this.datePublished = datePublished;
	}
	
	public Long getComicId() {
		return comicId;
	}
	
	public String getComicName() {
		return comicName;
	}
	
	public String getPublisherName() {
		return publisherName;
	}
	public String getAuthorName() {
		return authorName;
	}
	
	public String getComicType() {
		return comicType;
	}
	public Date getDatePublished() {
		return datePublished;
	}
	
	
	
}
