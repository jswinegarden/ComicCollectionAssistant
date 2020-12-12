package com.techelevator.model;

public class NewCollectionDTO {
	private Long collectionId;
	private String collectionName;
	private String collectionDesc;
	private Long favorite_status_id;
	private Long collection_visibility_id;
	
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
	public String getCollectionDesc() {
		return collectionDesc;
	}
	public void setCollectionDesc(String collectionDesc) {
		this.collectionDesc = collectionDesc;
	}
	public Long getFavorite_status_id() {
		return favorite_status_id;
	}
	public void setFavorite_status_id(Long favorite_status_id) {
		this.favorite_status_id = favorite_status_id;
	}
	public Long getCollection_visibility_id() {
		return collection_visibility_id;
	}
	public void setCollection_visibility_id(Long collection_visibility_id) {
		this.collection_visibility_id = collection_visibility_id;
	}
	
	
	
}
