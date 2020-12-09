package com.techelevator.model;

import java.util.Date;

public class Comic {
	private int comicId;
	private int collectionId;
	private String comicName;
	private String publisherName;
	private String authorName;
	private String comicType;
	private Date datePublished;
	
	public int getComicId() {
		return comicId;
	}
	public void setComicId(int comicId) {
		this.comicId = comicId;
	}
	public int getCollectionId() {
		return collectionId;
	}
	public void setCollectionId(int collectionId) {
		this.collectionId = collectionId;
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
