package com.techelevator.model;

public class FriendsList {
	private int requestId;
	private int userFrom;
	private int userTo;
	private int requestStatusId;
	private int requestTypeId;
	
	public FriendsList(int requestId, int requestStatusId, int requestTypeId, int userFrom, int userTo) {
		this.requestId = requestId;
		this.requestStatusId = requestStatusId;
		this.requestTypeId = requestTypeId;
		this.userFrom = userFrom;
		this.userTo = userTo;
	}
	public FriendsList() {}
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
	public int getRequestStatus() {
		return requestStatusId;
	}
	public void setRequestStatus(int requestStatusId) {
		this.requestStatusId = requestStatusId;
	}
	public int getRequestType() {
		return requestTypeId;
	}
	public void setRequestType(int requestTypeId) {
		this.requestTypeId = requestTypeId;
	}
	
	
}
