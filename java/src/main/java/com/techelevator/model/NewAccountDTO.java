package com.techelevator.model;

public class NewAccountDTO {
	private Long userId;
	private Long comicId;
	private Long comicConditionId;
	private Long comicTradeableStatusId;
	private Long collectionId;
	private Long accountTypeId;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getComicId() {
		return comicId;
	}
	public void setComicId(Long comicId) {
		this.comicId = comicId;
	}
	public Long getComicConditionId() {
		return comicConditionId;
	}
	public void setComicConditionId(Long comicConditionId) {
		this.comicConditionId = comicConditionId;
	}
	public Long getComicTradeableStatusId() {
		return comicTradeableStatusId;
	}
	public void setComicTradeableStatusId(Long comicTradeableStatusId) {
		this.comicTradeableStatusId = comicTradeableStatusId;
	}
	public Long getCollectionId() {
		return collectionId;
	}
	public void setCollectionId(Long collectionId) {
		this.collectionId = collectionId;
	}
	public Long getAccountTypeId() {
		return accountTypeId;
	}
	public void setAccountTypeId(Long accountTypeId) {
		this.accountTypeId = accountTypeId;
	}
	
	
	
	
}