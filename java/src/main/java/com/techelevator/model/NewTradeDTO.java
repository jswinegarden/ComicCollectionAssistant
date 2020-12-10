package com.techelevator.model;

import javax.validation.constraints.AssertTrue;

public class NewTradeDTO {
	private int userFrom;
	private int userTo;
	private int comicId;
	private String tradeType;
	
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
	
	public String getTradeType() {
		return tradeType;
	}
	
	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}
	
	@AssertTrue
	public boolean isValidTradeType() {
		return Trade.TRADE_TYPE_REQUEST.equals(this.tradeType) || Trade.TRADE_TYPE_SEND.equals(this.tradeType);
	}
	
}
