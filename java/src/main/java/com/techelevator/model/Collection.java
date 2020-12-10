package com.techelevator.model;

public class Collection {
	
	private Long collectionId;
	private String collectionName;
	private String collectionDescription;
	
	public Collection(Long collectionId, String collectionName, String collectionDesc) {
		this.collectionId = collectionId;
		this.collectionName = collectionName;
		this.collectionDescription = collectionDesc;
	}
	public Collection() {}
	
	public Long getCollectionId() {
		return collectionId;
	}
	public void setCollectionId(Long collectionId) {
		this.collectionId = collectionId;
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
