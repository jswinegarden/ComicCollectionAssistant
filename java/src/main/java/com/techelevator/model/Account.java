package com.techelevator.model;

public class Account {
	private int accountId;
	private int userId;
	private String accountType;
	
	public Account (int accountId, int userId, String accountType) {
		this.accountId = accountId;
		this.userId = userId;
		this.accountType = accountType;
	}
	public Account () {}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	
}
