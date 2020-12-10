package com.techelevator.model;

public class Account {
	private Long accountId;
	private Long userId;
	private Long comicId;
	private Long collectionId;
	private String accountType;
	
	public Account (Long accountId, Long userId, Long comicId, Long collectionId, String accountType) {
		this.accountId = accountId;
		this.userId = userId;
		this.comicId = comicId;
		this.collectionId = collectionId;
		this.accountType = accountType;
	}
	public Account () {}
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public Long getComicId() {
		return comicId;
	}
	public void setComicId(Long comicId) {
		this.comicId = comicId;
	}
	public Long getCollectionId() {
		return collectionId;
	}
	public void setCollectionId(Long collectionId) {
		this.collectionId = collectionId;
	}
	
	
	
	
}
