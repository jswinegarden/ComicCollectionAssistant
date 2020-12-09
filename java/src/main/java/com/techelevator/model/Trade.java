package com.techelevator.model;

public class Trade {
	private int tradeId;
	private int tradeTypeId;
	private int tradeStatusId;
	private int userFrom;
	private int userTo;
	private int comicId;
	
	public int getTradeId() {
		return tradeId;
	}
	public void setTradeId(int tradeId) {
		this.tradeId = tradeId;
	}
	public int getTradeTypeId() {
		return tradeTypeId;
	}
	public void setTradeTypeId(int tradeTypeId) {
		this.tradeTypeId = tradeTypeId;
	}
	public int getTradeStatusId() {
		return tradeStatusId;
	}
	public void setTradeStatusId(int tradeStatusId) {
		this.tradeStatusId = tradeStatusId;
	}
	public int getUserFrom() {
		return userFrom;
	}
	public void setUserFrom(int userFrom) {
		this.userFrom = userFrom;
	}
	public int getUserTo() {
		return userTo;
	}
	public void setUserTo(int userTo) {
		this.userTo = userTo;
	}
	public int getComicId() {
		return comicId;
	}
	public void setComicId(int comicId) {
		this.comicId = comicId;
	}
	
	
}
