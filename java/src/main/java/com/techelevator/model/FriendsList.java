package com.techelevator.model;

public class FriendsList {
	private int requestId;
	private int userFrom;
	private int userTo;
	private String requestStatus;
	private String requestType;
	
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
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
	public String getRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}
	public String getRequestType() {
		return requestType;
	}
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	
	
}
