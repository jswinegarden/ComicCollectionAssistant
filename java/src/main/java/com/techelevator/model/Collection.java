package com.techelevator.model;

public class Collection {
	
	private Long collectionId;
	private String collectionName;
	private String collectionDescription;
	private Long favorite_status_id;
	private Long collection_visibility_id;
	
	public Collection(Long collectionId, String collectionName, String collectionDesc, Long favorite_status_id, Long collection_visibility_id) {
		this.collectionId = collectionId;
		this.collectionName = collectionName;
		this.collectionDescription = collectionDesc;
		this.favorite_status_id = favorite_status_id;
		this.collection_visibility_id = collection_visibility_id;
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
	public void setFavoriteStatusId(Long favorite_status_id) {
		this.favorite_status_id  = favorite_status_id;
	}
	public Long getFavoriteStatusId() {
		return favorite_status_id;
	}
	public void setCollectionVisbilityId(Long collection_visibility_id) {
		this.collection_visibility_id = collection_visibility_id;
	}
	public Long getCollectionVisbilityId() {
		return collection_visibility_id;
	}
	
}
