package com.techelevator.model;

public class Collection {
	
	private int collectionId;
	private int userId;
	private String collectionName;
	private String collectionDescription;
	
	public Collection() {}
	
	public int getCollectionId() {
		return collectionId;
	}
	public void setCollectionId(int collectionId) {
		this.collectionId = collectionId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getCollectionName() {
		return collectionName;
	}
	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}
	public String getCollectionDescription() {
		return collectionDescription;
	}
	public void setCollectionDescription(String collectionDescription) {
		this.collectionDescription = collectionDescription;
	}
	
}
