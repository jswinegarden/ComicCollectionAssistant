package com.techelevator.model;

public class Trade {
	private int tradeId;
	private String tradeTypeId;
	private String tradeStatusId;
	private int userFrom;
	private int userTo;
	private int comicId;
	
	public int getTradeId() {
		return tradeId;
	}
	public void setTradeId(int tradeId) {
		this.tradeId = tradeId;
	}
	public String getTradeTypeId() {
		return tradeTypeId;
	}
	public void setTradeTypeId(String tradeTypeId) {
		this.tradeTypeId = tradeTypeId;
	}
	public String getTradeStatusId() {
		return tradeStatusId;
	}
	public void setTradeStatusId(String tradeStatusId) {
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
